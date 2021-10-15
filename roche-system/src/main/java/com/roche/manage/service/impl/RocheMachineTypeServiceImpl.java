package com.roche.manage.service.impl;

import java.util.List;

import com.roche.manage.mapper.SysRepairsSelfMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.roche.manage.mapper.RocheMachineTypeMapper;
import com.roche.manage.domain.RocheMachineType;
import com.roche.manage.service.IRocheMachineTypeService;
import com.roche.common.core.text.Convert;

/**
 * 设备类型管理Service业务层处理
 *
 * @author dongqiushuo
 * @date 2021-10-11
 */
@Service("machine")
public class RocheMachineTypeServiceImpl implements IRocheMachineTypeService {
    @Autowired
    private RocheMachineTypeMapper rocheMachineTypeMapper;
    @Autowired
    private SysRepairsSelfMapper sysRepairsSelfMapper;

    /**
     * 查询设备类型管理
     *
     * @param machineTypeId 设备类型管理主键
     * @return 设备类型管理
     */
    @Override
    public RocheMachineType selectRocheMachineTypeByMachineTypeId(Long machineTypeId) {
        return rocheMachineTypeMapper.selectRocheMachineTypeByMachineTypeId(machineTypeId);
    }

    /**
     * 查询设备类型管理列表
     *
     * @param rocheMachineType 设备类型管理
     * @return 设备类型管理
     */
    @Override
    public List<RocheMachineType> selectRocheMachineTypeList(RocheMachineType rocheMachineType) {
        return rocheMachineTypeMapper.selectRocheMachineTypeList(rocheMachineType);
    }

    /**
     * 查询设备类型管理列表
     *
     * @return 设备类型管理
     */
    @Override
    public List<RocheMachineType> selectRocheMachineTypeList() {
        RocheMachineType rocheMachineType = new RocheMachineType();
        return rocheMachineTypeMapper.selectRocheMachineTypeList(rocheMachineType);
    }

    /**
     * 新增设备类型管理
     *
     * @param rocheMachineType 设备类型管理
     * @return 结果
     */
    @Override
    public int insertRocheMachineType(RocheMachineType rocheMachineType) {
        return rocheMachineTypeMapper.insertRocheMachineType(rocheMachineType);
    }

    /**
     * 修改设备类型管理
     *
     * @param rocheMachineType 设备类型管理
     * @return 结果
     */
    @Override
    public int updateRocheMachineType(RocheMachineType rocheMachineType) {
        RocheMachineType rocheMachineTypeBefore = rocheMachineTypeMapper.selectRocheMachineTypeByMachineTypeId
                (rocheMachineType.getMachineTypeId());
        String machineTypebegore = rocheMachineTypeBefore.getMachineType();
        String machineTypeAfter =  rocheMachineType
                .getMachineType();
        sysRepairsSelfMapper.updateSysRepairsSelfByname(machineTypebegore,machineTypeAfter);
        return rocheMachineTypeMapper.updateRocheMachineType(rocheMachineType);
    }

    /**
     * 批量删除设备类型管理
     *
     * @param machineTypeIds 需要删除的设备类型管理主键
     * @return 结果
     */
    @Override
    public int deleteRocheMachineTypeByMachineTypeIds(String machineTypeIds) {

        return rocheMachineTypeMapper.deleteRocheMachineTypeByMachineTypeIds(Convert.toStrArray(machineTypeIds));
    }

    /**
     * 删除设备类型管理信息
     *
     * @param machineTypeId 设备类型管理主键
     * @return 结果
     */
    @Override
    public int deleteRocheMachineTypeByMachineTypeId(Long machineTypeId) {
        return rocheMachineTypeMapper.deleteRocheMachineTypeByMachineTypeId(machineTypeId);
    }
}
