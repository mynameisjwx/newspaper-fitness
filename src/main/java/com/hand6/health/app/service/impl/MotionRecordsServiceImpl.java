package com.hand6.health.app.service.impl;/**
 * Created by Administrator on 2019/7/6.
 */

import com.hand6.health.app.service.HandUserService;
import com.hand6.health.app.service.MotionRecordsService;
import com.hand6.health.common.ConstantUtil;
import com.hand6.health.domain.entity.HandUser;
import com.hand6.health.domain.entity.MotionIndicators;
import com.hand6.health.domain.entity.MotionRecords;
import com.hand6.health.infra.mapper.MotionIndicatorsMapper;
import com.hand6.health.infra.mapper.MotionRecordsMapper;
import com.hand6.health.util.SysBeanUtil;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.service.BaseServiceImpl;
import io.choerodon.mybatis.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author xxxx
 * @description
 * @date 2019/7/6
 */
@Service
public class MotionRecordsServiceImpl extends BaseServiceImpl<MotionRecords> implements MotionRecordsService {
    @Autowired
    private MotionRecordsMapper motionRecordsMapper;
    @Autowired
    private MotionIndicatorsMapper motionIndicatorsMapper;

    @Override
    public MotionRecords save(MotionRecords motionRecords) {
        //验证是否达标
        String status = this.CalculateRecord(motionRecords);
        motionRecords.setStatus(status);
        motionRecords.setMotionTime(new Date());
        motionRecordsMapper.insert(motionRecords);
        return motionRecords;
    }

    @Override
    public MotionRecords update(MotionRecords motionRecords) {
       MotionRecords motionRecordsDB = motionRecordsMapper.selectByPrimaryKey(motionRecords);
        SysBeanUtil.copyProperties(motionRecords,motionRecordsDB);
        this.updateByPrimaryKey(motionRecordsDB);
        return motionRecordsDB;
    }

    @Override
    public MotionRecords remove(MotionRecords motionRecords) {
        int count = motionRecordsMapper.deleteByPrimaryKey(motionRecords);
        if (count > 0){
            return motionRecords;
        }
        return null;
    }

    @Override
    public List<MotionRecords> list(MotionRecords motionRecords) {
        List<MotionRecords> list = motionRecordsMapper.select(motionRecords);
        return list;
    }

    //校验单次记录是否满足要求
    public  Boolean checkSingleDistance(MotionIndicators motionIndicators,MotionRecords motionRecords){
        if (motionRecords.getMotionDistance().compareTo(motionIndicators.getSingleDistance())<0){
            return false;
        }
        return true;
    }

    /**
     * 将时间转化为秒；时间记录方式为00.9.00/9.00
     * @param time
     * @return
     */
    public BigDecimal changeToSecond(String time){
        String[] indicatorsTime = time.split("\\.");
        BigDecimal timeToS=new BigDecimal(0);
        if (indicatorsTime.length>2){
            timeToS = BigDecimal.valueOf(Integer.parseInt(indicatorsTime[0])*60*60+Integer.parseInt(indicatorsTime[1])*60+Integer.parseInt(indicatorsTime[2]));
        } else {
            timeToS = BigDecimal.valueOf(Integer.parseInt(indicatorsTime[0])*60+Integer.parseInt(indicatorsTime[1]));
        }
        return timeToS;
    }

    /**
     * 校验单次配速是否足够
     * @param motionIndicators
     * @param motionRecords
     * @return Boolean
     */
    public Boolean checkSingleSpeed(MotionIndicators motionIndicators,MotionRecords motionRecords){
        BigDecimal useTime = changeToSecond(motionRecords.getMotionSpeed()).divide(motionRecords.getMotionDistance(),2,BigDecimal.ROUND_HALF_UP);
        BigDecimal standerTime = changeToSecond(motionIndicators.getMiniSpeed());
        if (useTime.compareTo(standerTime)==1){
            //不达标
            return false;
        }
        return true;
    }

    /**
     * 判断单次骑行记录是否达标
     * @param motionRecords
     * @return
     */
    public String CalculateRecord(MotionRecords motionRecords){
        MotionIndicators motionIndicators = motionIndicatorsMapper.selectOne(MotionIndicators.builder().gender(motionRecords.getGender()).motionType(motionRecords.getMotionType()).build());
        if (!checkSingleDistance(motionIndicators,motionRecords)){
            return ConstantUtil.NOT_ACHIEVE;
        }
        if (!checkSingleSpeed(motionIndicators,motionRecords)){
            return ConstantUtil.NOT_ACHIEVE;
        }
        return ConstantUtil.ACHIEVE;
    }


}

