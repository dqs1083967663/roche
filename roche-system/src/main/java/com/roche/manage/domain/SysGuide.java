package com.roche.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.roche.common.annotation.Excel;
import com.roche.common.core.domain.BaseEntity;

/**
 * 指引管理对象 sys_guide
 * 
 * @author qiushuo dong
 * @date 2021-09-26
 */
public class SysGuide extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 指引id */
    private Long guideId;

    /** 指引描述 */
    @Excel(name = "指引描述")
    private String guideDescribe;

    /** 指引图片 */
    @Excel(name = "指引图片")
    private String guideImg;

    public void setGuideId(Long guideId) 
    {
        this.guideId = guideId;
    }

    public Long getGuideId() 
    {
        return guideId;
    }
    public void setGuideDescribe(String guideDescribe) 
    {
        this.guideDescribe = guideDescribe;
    }

    public String getGuideDescribe() 
    {
        return guideDescribe;
    }
    public void setGuideImg(String guideImg) 
    {
        this.guideImg = guideImg;
    }

    public String getGuideImg() 
    {
        return guideImg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("guideId", getGuideId())
            .append("guideDescribe", getGuideDescribe())
            .append("guideImg", getGuideImg())
            .toString();
    }
}
