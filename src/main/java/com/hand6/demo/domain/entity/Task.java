package com.hand6.demo.domain.entity;/**
 * Created by Administrator on 2019/7/3.
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author xxxx
 * @description
 * @date 2019/7/3
 */
@ModifyAudit
@VersionAudit
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todo_task")
public class Task extends AuditDomain{
    @Id
    @GeneratedValue
    private Long id;
    private Long employeeId;
    private String state;
    private String taskNumber;
    private String taskDescription;

}
