package com.hand6.health.schedule;/**
 * Created by Administrator on 2019/7/9.
 */

import com.hand6.health.common.ConstantUtil;
import com.hand6.health.domain.entity.HandUser;
import com.hand6.health.domain.entity.MotionIndicators;
import com.hand6.health.domain.entity.MotionRecords;
import com.hand6.health.domain.entity.MotionSummary;
import com.hand6.health.infra.mapper.HandUserMapper;
import com.hand6.health.infra.mapper.MotionIndicatorsMapper;
import com.hand6.health.infra.mapper.MotionRecordsMapper;
import com.hand6.health.infra.mapper.MotionSummaryMapper;
import com.hand6.health.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author xxxx
 * @description 运动统计定时任务
 * @date 2019/7/9
 */
@Component
@Configuration //用于标记配置类，兼备component
@EnableScheduling //开启定时任务
public class MotionSummaryTask implements SchedulingConfigurer {
    @Mapper
    public interface CronMapper{
        @Select("select t.cron from corn t where purpose ='" + ConstantUtil.MOTION_SUMMARY + "' limit 1")
        public String getCron();
    }
    public void print(){
        System.out.println("执行动态定时任务: " + LocalDateTime.now().toLocalTime());
    }

    @Autowired
    @SuppressWarnings("all")
    private CronMapper cronMapper;

    @Autowired
    private MotionRecordsMapper motionRecordsMapper;
    @Autowired
    private MotionIndicatorsMapper motionIndicatorsMapper;
    @Autowired
    private HandUserMapper handUserMapper;
    @Autowired
    private MotionSummaryMapper summaryMapper;

    public void vaildRecord(MotionRecords motionRecords){

    }

    public void motionSummary(){
        System.out.println("执行动态定时任务: " + LocalDateTime.now().toLocalTime());
        List<HandUser> userList = handUserMapper.selectAll();
        BigDecimal runDistance = null;
        BigDecimal walkDistance = null;
        BigDecimal rideDistance = null;
        BigDecimal otherDistance = null;
        BigDecimal allDistance=null;
        MotionSummary motionSummary=null;
        Boolean runIsAchieve=false;
        Boolean walkIsAchieve=false;
        Boolean rideIsAchieve=false;
        Boolean otherIsAchieve=false;
        for (HandUser user:userList){
            runDistance = new BigDecimal(0);
            walkDistance = new BigDecimal(0);
            rideDistance = new BigDecimal(0);
            otherDistance = new BigDecimal(0);
            allDistance = new BigDecimal(0);
            motionSummary = new MotionSummary();
            motionSummary.setHandUserId(user.getId());
            motionSummary.setGender(user.getGender());
            motionSummary.setHandFullName(user.getFullName());
            List<MotionRecords> recordsList = motionRecordsMapper.findAll(MotionRecords.builder().handUserId(user.getId())
            .status(ConstantUtil.ACHIEVE).gender(user.getGender()).startDate(DateUtil.getMondayOfThisWeek(new Date()))
                    .endDate(DateUtil.getSundayOfThisWeek(new Date())).build());

            MotionIndicators runIndicators = motionIndicatorsMapper.selectOne(MotionIndicators.builder()
            .motionType(ConstantUtil.RUN).gender(user.getGender()).build());
            MotionIndicators walkIndicators = motionIndicatorsMapper.selectOne(MotionIndicators.builder()
                    .motionType(ConstantUtil.WALK).gender(user.getGender()).build());
            MotionIndicators rideIndicators = motionIndicatorsMapper.selectOne(MotionIndicators.builder()
                    .motionType(ConstantUtil.RIDE).gender(user.getGender()).build());
            MotionIndicators otherIndicators = motionIndicatorsMapper.selectOne(MotionIndicators.builder()
                    .motionType(ConstantUtil.OTHER).gender(user.getGender()).build());
            if (!ObjectUtils.isEmpty(recordsList)){
                //校验
                for (MotionRecords records:recordsList){
                    switch (records.getMotionType()){
                        case ConstantUtil.RUN: runDistance=runDistance.add(records.getMotionDistance()); break;
                        case ConstantUtil.RIDE: rideDistance=rideDistance.add(records.getMotionDistance()); break;
                        case ConstantUtil.WALK: walkDistance=walkDistance.add(records.getMotionDistance()); break;
                        case ConstantUtil.OTHER: otherDistance=walkDistance.add(records.getMotionDistance()); break;
                        default: break;
                    }
                }
                motionSummary.setRunDistance(runDistance);
                motionSummary.setRideDistance(rideDistance);
                motionSummary.setWalkDistance(walkDistance);
                motionSummary.setOtherDistince(otherDistance);
            }
            if (runDistance.compareTo(runIndicators.getTotalDistance())==-1){
                if (walkDistance.compareTo(ConstantUtil.ZERO)!=0){
                    walkDistance = runDistance.multiply(new BigDecimal(2)).add(walkDistance);
                    if (walkDistance.compareTo(walkIndicators.getTotalDistance())!=-1){
                        walkIsAchieve = true;
                    } else {
                        walkIsAchieve = false;
                    }
                }
                if (rideDistance.compareTo(ConstantUtil.ZERO) != 0){
                    rideDistance = runDistance.multiply(new BigDecimal(2)).add(rideDistance);
                    if (rideDistance.compareTo(rideIndicators.getTotalDistance())!=-1){
                        rideIsAchieve = true;
                    } else {
                        rideIsAchieve = false;
                    }
                }
                if (otherDistance.compareTo(ConstantUtil.ZERO) != 0){
                    otherDistance = runDistance.multiply(new BigDecimal(2)).add(otherDistance);
                    if (otherDistance.compareTo(otherIndicators.getTotalDistance())!=-1){
                        rideIsAchieve = true;
                    } else {
                        rideIsAchieve = false;
                    }
                }

            } else {
                runIsAchieve = true;
            }
            if (runIsAchieve||rideIsAchieve||walkIsAchieve||otherIsAchieve){
                motionSummary.setStatus(ConstantUtil.ACHIEVE);
            }else {
                motionSummary.setStatus(ConstantUtil.NOT_ACHIEVE);
            }
            motionSummary.setActionTime(new Date());
            summaryMapper.insert(motionSummary);
        }
    }



    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        taskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                () -> this.motionSummary(),
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1 从数据库获取执行周期
                    String cron = cronMapper.getCron();
                    //2.2 合法性校验.
                    if (StringUtils.isEmpty(cron)) {
                        // Omitted Code ..
                    }
                    //2.3 返回执行周期(Date)
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
}
