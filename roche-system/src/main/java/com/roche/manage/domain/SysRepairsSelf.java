package com.roche.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.roche.common.annotation.Excel;
import com.roche.common.core.domain.TreeEntity;

/**
 * 自助排查问题管理对象 sys_repairs_self
 * 
 * @author qiushuo
 * @date 2021-10-08
 */
public class SysRepairsSelf extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 维修id */
    private Long selfId;

    /** 名称 */
    @Excel(name = "名称")
    private String repairsName;

    /** 描述 */
    @Excel(name = "描述")
    private String nameDescribe;

    /** 解决方法 */
    private String solution;

    /** 图片描述 */
    private String pictureDescription;

    /** 图片 */
    private String picture;

    /** 视频描述 */
    private String videoDescription;

    /** 视频 */
    private String video;

    /** 附件描述 */
    private String accessoryDescription;

    /** 附件 */
    private String accessory;

    /** 其他 */
    private String other;

    /** 树脉络 */
    private String treePath;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String machineType;

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
    public void setNameDescribe(String nameDescribe) 
    {
        this.nameDescribe = nameDescribe;
    }

    public String getNameDescribe() 
    {
        return nameDescribe;
    }
    public void setSolution(String solution) 
    {
        this.solution = solution;
    }

    public String getSolution() 
    {
        return solution;
    }
    public void setPictureDescription(String pictureDescription) 
    {
        this.pictureDescription = pictureDescription;
    }

    public String getPictureDescription() 
    {
        return pictureDescription;
    }
    public void setPicture(String picture) 
    {
        this.picture = picture;
    }

    public String getPicture() 
    {
        return picture;
    }
    public void setVideoDescription(String videoDescription) 
    {
        this.videoDescription = videoDescription;
    }

    public String getVideoDescription() 
    {
        return videoDescription;
    }
    public void setVideo(String video) 
    {
        this.video = video;
    }

    public String getVideo() 
    {
        return video;
    }
    public void setAccessoryDescription(String accessoryDescription) 
    {
        this.accessoryDescription = accessoryDescription;
    }

    public String getAccessoryDescription() 
    {
        return accessoryDescription;
    }
    public void setAccessory(String accessory) 
    {
        this.accessory = accessory;
    }

    public String getAccessory() 
    {
        return accessory;
    }
    public void setOther(String other) 
    {
        this.other = other;
    }

    public String getOther() 
    {
        return other;
    }
    public void setMachineType(String machineType) 
    {
        this.machineType = machineType;
    }

    public String getMachineType() 
    {
        return machineType;
    }

    public String getTreePath() {
        return treePath;
    }

    public void setTreePath(String treePath) {
        this.treePath = treePath;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("selfId", getSelfId())
            .append("parentId", getParentId())
            .append("repairsName", getRepairsName())
            .append("nameDescribe", getNameDescribe())
            .append("solution", getSolution())
            .append("pictureDescription", getPictureDescription())
            .append("picture", getPicture())
            .append("videoDescription", getVideoDescription())
            .append("video", getVideo())
            .append("accessoryDescription", getAccessoryDescription())
            .append("accessory", getAccessory())
            .append("other", getOther())
            .append("orderNum", getOrderNum())
            .append("machineType", getMachineType())
                .append("treePath", getTreePath())
            .toString();
    }
}
