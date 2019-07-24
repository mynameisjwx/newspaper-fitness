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
@Table(name = "hand_user")
@Builder
public class HandUser extends AuditDomain{
    @Id
    @GeneratedValue //对于自增张、序列（SEQUENCE）类型的主键，需要添加该注解
    private Long id;
    private String userNumber;
    private String password;
    private String gender;
    private String fullName;
    private String wechatNumber;
    public String getUserNumber(){
        return this.getUserNumber();
    }
}
