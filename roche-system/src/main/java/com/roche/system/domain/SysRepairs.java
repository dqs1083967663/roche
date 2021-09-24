package com.roche.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.roche.common.annotation.Excel;
import com.roche.common.core.domain.BaseEntity;

/**
 * 報修对象 sys_repairs
 * 
 * @author aarn
 * @date 2021-09-23
 */
public class SysRepairs extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 报修id */
    private Long repairsId;

    /** 报修證明 */
    @Excel(name = "报修證明")
    private String repairsImg;

    /** 报修单状态 */
    @Excel(name = "报修单状态")
    private String repairsStatus;

    /** 报修人 */
    @Excel(name = "报修人")
    private String repairsName;

    /** 报修發票 */
    @Excel(name = "报修發票")
    private String repairsBill;

    /** 報修副本 */
    @Excel(name = "報修副本")
    private String repairsFile;

    public void setRepairsId(Long repairsId) 
    {
        this.repairsId = repairsId;
    }

    public Long getRepairsId() 
    {
        return repairsId;
    }
    public void setRepairsImg(String repairsImg) 
    {
        this.repairsImg = repairsImg;
    }

    public String getRepairsImg() 
    {
        return repairsImg;
    }
    public void setRepairsStatus(String repairsStatus) 
    {
        this.repairsStatus = repairsStatus;
    }

    public String getRepairsStatus() 
    {
        return repairsStatus;
    }
    public void setRepairsName(String repairsName) 
    {
        this.repairsName = repairsName;
    }

    public String getRepairsName() 
    {
        return repairsName;
    }
    public void setRepairsBill(String repairsBill) 
    {
        this.repairsBill = repairsBill;
    }

    public String getRepairsBill() 
    {
        return repairsBill;
    }
    public void setRepairsFile(String repairsFile) 
    {
        this.repairsFile = repairsFile;
    }

    public String getRepairsFile() 
    {
        return repairsFile;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("repairsId", getRepairsId())
            .append("repairsImg", getRepairsImg())
            .append("repairsStatus", getRepairsStatus())
            .append("repairsName", getRepairsName())
            .append("repairsBill", getRepairsBill())
            .append("repairsFile", getRepairsFile())
            .toString();
    }
}
