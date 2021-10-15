package com.roche.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.roche.common.annotation.Excel;
import com.roche.common.core.domain.BaseEntity;

/**
 * 自助排查问题点击历史对象 sys_repairs_self_click_history
 *
 * @author ruoyi
 * @date 2021-10-14
 */
public class SysRepairsSelfClickHistory extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键oid
     */
    private String oid;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long userId;

    /**
     * 用户名
     */
    @Excel(name = "用户名")
    private String userName;

    /**
     * 问题id
     */
    @Excel(name = "问题id")
    private Long selfId;

    /**
     * 是否有帮助
     */
    @Excel(name = "是否有帮助")
    private String usefullCheck;

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setSelfId(Long selfId) {
        this.selfId = selfId;
    }

    public Long getSelfId() {
        return selfId;
    }

    public void setUsefullCheck(String usefullCheck) {
        this.usefullCheck = usefullCheck;
    }

    public String getUsefullCheck() {
        return usefullCheck;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("oid", getOid())
                .append("userId", getUserId())
                .append("selfId", getSelfId())
                .append("usefullCheck", getUsefullCheck())
                .append("username", getUserName())
                .toString();
    }
}
