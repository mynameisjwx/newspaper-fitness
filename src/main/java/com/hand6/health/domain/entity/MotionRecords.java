package com.hand6.health.domain.entity;/**
 * Created by Administrator on 2019/7/6.
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xxxx
 * @description
 * @date 2019/7/6
 */
@ModifyAudit
@VersionAudit
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "motion_records")
@Builder
public class MotionRecords extends AuditDomain {
    @Id
    @GeneratedValue //对于自增张、序列（SEQUENCE）类型的主键，需要添加该注解
    private Long Id;
    private Long handUserId;
    private String gender;
    private String motionType;
    private BigDecimal motionDistance;
    private String motionSpeed;//0.9.2的方式存储,用时
    private String distanceUnit;
    private String speedUnit;
    @DateTimeFormat(pattern = "YYYY-MM-DD hh:mm:ss")
    private Date motionTime;//运动时间
    private String imgUrl;
    private String status;//是否达标

    @Transient
    @DateTimeFormat(pattern = "YYYY-MM-DD hh:mm:ss")
    private Date startDate; //每周开始时间
    @Transient
    @DateTimeFormat(pattern = "YYYY-MM-DD hh:mm:ss")
    private Date endDate; //每周结束时间
}
