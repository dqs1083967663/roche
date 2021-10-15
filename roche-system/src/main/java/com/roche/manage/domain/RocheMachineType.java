package com.roche.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.roche.common.annotation.Excel;
import com.roche.common.core.domain.BaseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 设备类型管理对象 roche_machine_type
 * 
 * @author dongqiushuo
 * @date 2021-10-11
 */
public class RocheMachineType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备类型id */
    private Long machineTypeId;

    /** 设备类型type */
    @Excel(name = "设备类型type")
    private String machineType;

    /** 设备类型名字 */
    @Excel(name = "设备类型名字")
    private String machineTypeName;

    /** 设备类型描述 */
    private String machineTypeDescribe;

    /** 设备类型图片 */
    private String machineTypeImg;

    public void setMachineTypeId(Long machineTypeId) 
    {
        this.machineTypeId = machineTypeId;
    }


    public Long getMachineTypeId() 
    {
        return machineTypeId;
    }
    public void setMachineType(String machineType) 
    {
        this.machineType = machineType;
    }

    @NotBlank(message = "字典标签不能为空")
    @Size(min = 0, max = 100, message = "字典标签长度不能超过100个字符")
    public String getMachineType() 
    {
        return machineType;
    }
    public void setMachineTypeName(String machineTypeName) 
    {
        this.machineTypeName = machineTypeName;
    }

    @NotBlank(message = "字典标签不能为空")
    @Size(min = 0, max = 100, message = "字典标签长度不能超过100个字符")
    public String getMachineTypeName() 
    {
        return machineTypeName;
    }
    public void setMachineTypeDescribe(String machineTypeDescribe) 
    {
        this.machineTypeDescribe = machineTypeDescribe;
    }

    public String getMachineTypeDescribe() 
    {
        return machineTypeDescribe;
    }
    public void setMachineTypeImg(String machineTypeImg) 
    {
        this.machineTypeImg = machineTypeImg;
    }

    public String getMachineTypeImg() 
    {
        return machineTypeImg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("machineTypeId", getMachineTypeId())
            .append("machineType", getMachineType())
            .append("machineTypeName", getMachineTypeName())
            .append("machineTypeDescribe", getMachineTypeDescribe())
            .append("machineTypeImg", getMachineTypeImg())
            .toString();
    }
}
