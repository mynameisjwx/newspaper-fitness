package com.hand6.health.domain.entity;/**
 * Created by Administrator on 2019/7/9.
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
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xxxx
 * @description
 * @date 2019/7/9
 */
@ModifyAudit
@VersionAudit
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "motion_summary")
@Builder
public class MotionSummary extends AuditDomain {
    @Id
    @GeneratedValue
    private Long id;
    private Long handUserId;
    private String handFullName;
    private String gender;
    private BigDecimal runDistance;
    private String runAvgSpeed;
    private BigDecimal walkDistance;
    private String walkAvgSpeed;
    private BigDecimal rideDistance;
    private String rideAvgSpeed;
    private BigDecimal otherDistince;
    private String otherAvgSpeed;
    @DateTimeFormat(pattern = "YYYY-MM-DD hh:mm;ss")
    private Date actionTime;
    private String status;
}
