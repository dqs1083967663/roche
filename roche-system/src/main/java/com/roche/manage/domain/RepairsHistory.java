package com.roche.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.roche.common.annotation.Excel;
import com.roche.common.core.domain.BaseEntity;

/**
 * 自助排查维修统计对象 repairs_history
 * 
 * @author qiushuodong
 * @date 2021-10-13
 */
public class RepairsHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 维修id */
    private Long selfId;

    /** 名称 */
    @Excel(name = "名称")
    private String repairsName;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String machineType;

    /** 解决数 */
    @Excel(name = "解决数")
    private Long usefulCount;

    /** 未解决数 */
    @Excel(name = "未解决数")
    private Long uselessCount;

    /** 成功的百分比 */
    @Excel(name = "成功的百分比")
    private String usefulPercent;

    /** 查询用户个数 */
    @Excel(name = "查询用户个数")
    private Long useNum;

    public void setSelfId(Long selfId) 
    {
        this.selfId = selfId;
    }

    public Long getSelfId() 
    {
        return selfId;
    }
    public void setRepairsName(String repairsName) 
    {
        this.repairsName = repairsName;
    }

    public String getRepairsName() 
    {
        return repairsName;
    }
    public void setMachineType(String machineType) 
    {
        this.machineType = machineType;
    }

    public String getMachineType() 
    {
        return machineType;
    }
    public void setUsefulCount(Long usefulCount) 
    {
        this.usefulCount = usefulCount;
    }

    public Long getUsefulCount() 
    {
        return usefulCount;
    }
    public void setUselessCount(Long uselessCount) 
    {
        this.uselessCount = uselessCount;
    }

    public Long getUselessCount() 
    {
        return uselessCount;
    }
    public void setUsefulPercent(String usefulPercent) 
    {
        this.usefulPercent = usefulPercent;
    }

    public String getUsefulPercent() 
    {
        return usefulPercent;
    }
    public void setUseNum(Long useNum) 
    {
        this.useNum = useNum;
    }

    public Long getUseNum() 
    {
        return useNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("selfId", getSelfId())
            .append("repairsName", getRepairsName())
            .append("machineType", getMachineType())
            .append("usefulCount", getUsefulCount())
            .append("uselessCount", getUselessCount())
            .append("usefulPercent", getUsefulPercent())
            .append("useNum", getUseNum())
            .toString();
    }
}
