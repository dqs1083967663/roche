package com.roche.manage.service;

import java.util.List;
import com.roche.manage.domain.RocheMachineType;

/**
 * 设备类型管理Service接口
 * 
 * @author dongqiushuo
 * @date 2021-10-11
 */
public interface IRocheMachineTypeService 
{
    /**
     * 查询设备类型管理
     * 
     * @param machineTypeId 设备类型管理主键
     * @return 设备类型管理
     */
    public RocheMachineType selectRocheMachineTypeByMachineTypeId(Long machineTypeId);

    /**
     * 查询设备类型管理列表
     * 
     * @param rocheMachineType 设备类型管理
     * @return 设备类型管理集合
     */
    public List<RocheMachineType> selectRocheMachineTypeList(RocheMachineType rocheMachineType);

    /**
     * 新增设备类型管理
     * 
     * @param rocheMachineType 设备类型管理
     * @return 结果
     */
    public int insertRocheMachineType(RocheMachineType rocheMachineType);

    /**
     * 修改设备类型管理
     * 
     * @param rocheMachineType 设备类型管理
     * @return 结果
     */
    public int updateRocheMachineType(RocheMachineType rocheMachineType);

    /**
     * 批量删除设备类型管理
     * 
     * @param machineTypeIds 需要删除的设备类型管理主键集合
     * @return 结果
     */
    public int deleteRocheMachineTypeByMachineTypeIds(String machineTypeIds);

    /**
     * 删除设备类型管理信息
     * 
     * @param machineTypeId 设备类型管理主键
     * @return 结果
     */
    public int deleteRocheMachineTypeByMachineTypeId(Long machineTypeId);
    /**
     * 查询设备类型管理列表
     *
     * @return 设备类型管理
     */
    public List<RocheMachineType> selectRocheMachineTypeList( );
}
