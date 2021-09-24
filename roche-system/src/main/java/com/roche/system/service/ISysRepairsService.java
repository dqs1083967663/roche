package com.roche.system.service;

import java.util.List;
import com.roche.system.domain.SysRepairs;

/**
 * 報修Service接口
 * 
 * @author aarn
 * @date 2021-09-23
 */
public interface ISysRepairsService 
{
    /**
     * 查询報修
     * 
     * @param repairsId 報修主键
     * @return 報修
     */
    public SysRepairs selectSysRepairsByRepairsId(Long repairsId);

    /**
     * 查询報修列表
     * 
     * @param sysRepairs 報修
     * @return 報修集合
     */
    public List<SysRepairs> selectSysRepairsList(SysRepairs sysRepairs);

    /**
     * 新增報修
     * 
     * @param sysRepairs 報修
     * @return 结果
     */
    public int insertSysRepairs(SysRepairs sysRepairs);

    /**
     * 修改報修
     * 
     * @param sysRepairs 報修
     * @return 结果
     */
    public int updateSysRepairs(SysRepairs sysRepairs);

    /**
     * 批量删除報修
     * 
     * @param repairsIds 需要删除的報修主键集合
     * @return 结果
     */
    public int deleteSysRepairsByRepairsIds(String repairsIds);

    /**
     * 删除報修信息
     * 
     * @param repairsId 報修主键
     * @return 结果
     */
    public int deleteSysRepairsByRepairsId(Long repairsId);
}
