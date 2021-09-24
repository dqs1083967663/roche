package com.roche.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.roche.system.mapper.SysRepairsMapper;
import com.roche.system.domain.SysRepairs;
import com.roche.system.service.ISysRepairsService;
import com.roche.common.core.text.Convert;

/**
 * 報修Service业务层处理
 * 
 * @author aarn
 * @date 2021-09-23
 */
@Service
public class SysRepairsServiceImpl implements ISysRepairsService 
{
    @Autowired
    private SysRepairsMapper sysRepairsMapper;

    /**
     * 查询報修
     * 
     * @param repairsId 報修主键
     * @return 報修
     */
    @Override
    public SysRepairs selectSysRepairsByRepairsId(Long repairsId)
    {
        return sysRepairsMapper.selectSysRepairsByRepairsId(repairsId);
    }

    /**
     * 查询報修列表
     * 
     * @param sysRepairs 報修
     * @return 報修
     */
    @Override
    public List<SysRepairs> selectSysRepairsList(SysRepairs sysRepairs)
    {
        return sysRepairsMapper.selectSysRepairsList(sysRepairs);
    }

    /**
     * 新增報修
     * 
     * @param sysRepairs 報修
     * @return 结果
     */
    @Override
    public int insertSysRepairs(SysRepairs sysRepairs)
    {
        return sysRepairsMapper.insertSysRepairs(sysRepairs);
    }

    /**
     * 修改報修
     * 
     * @param sysRepairs 報修
     * @return 结果
     */
    @Override
    public int updateSysRepairs(SysRepairs sysRepairs)
    {
        return sysRepairsMapper.updateSysRepairs(sysRepairs);
    }

    /**
     * 批量删除報修
     * 
     * @param repairsIds 需要删除的報修主键
     * @return 结果
     */
    @Override
    public int deleteSysRepairsByRepairsIds(String repairsIds)
    {
        return sysRepairsMapper.deleteSysRepairsByRepairsIds(Convert.toStrArray(repairsIds));
    }

    /**
     * 删除報修信息
     * 
     * @param repairsId 報修主键
     * @return 结果
     */
    @Override
    public int deleteSysRepairsByRepairsId(Long repairsId)
    {
        return sysRepairsMapper.deleteSysRepairsByRepairsId(repairsId);
    }
}
