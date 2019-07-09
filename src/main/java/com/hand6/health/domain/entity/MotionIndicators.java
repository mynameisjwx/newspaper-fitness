package com.hand6.health.domain.entity;/**
 * Created by Administrator on 2019/7/4.
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author xxxx
 * @description
 * @date 2019/7/4
 */
@ModifyAudit
@VersionAudit
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "motion_indicators")
@Builder
public class MotionIndicators extends AuditDomain {
    @Id
    @GeneratedValue
    private Long id;
    private String gender;
    private String motionType;//运动类型
    private BigDecimal totalDistance;//总距离
    private String totalDistanceUnit;//总距离单位

    private BigDecimal singleDistance;//单词距离
    private String singleDistanceUnit;//单次距离单位
    private String miniSpeed;//每公里最低配速
    private String miniSpeedUnit;//每公里最低配速单位
}
