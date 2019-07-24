package com.hand6.health.domain.entity;/**
 * Created by Administrator on 2019/7/9.
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hand6.health.bean.ExcelColumn;
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
    @ExcelColumn(value = "工号",col = 0)
    private String handUserNumber;
    @ExcelColumn(value = "姓名",col = 1)
    private String handFullName;
    @ExcelColumn(value = "性别",col = 3)
    private String gender;
    @ExcelColumn(value = "跑步距离",col = 4)
    private BigDecimal runDistance;
    @ExcelColumn(value = "跑步配速",col = 5)
    private String runAvgSpeed;
    @ExcelColumn(value = "走路距离",col = 6)
    private BigDecimal walkDistance;
    @ExcelColumn(value = "走路配速",col = 7)
    private String walkAvgSpeed;
    @ExcelColumn(value = "骑行距离",col = 8)
    private BigDecimal rideDistance;
    @ExcelColumn(value = "骑行配速",col = 9)
    private String rideAvgSpeed;
    private BigDecimal otherDistince;
    private String otherAvgSpeed;
    @DateTimeFormat(pattern = "YYYY-MM-DD hh:mm;ss")
    private Date actionTime;
    private String status;
    @ExcelColumn(value = "状态",col = 2)
    @Transient
    private String statusDesc;


    @Transient
    private String startDate;
    @Transient
    private String endDate;
}
