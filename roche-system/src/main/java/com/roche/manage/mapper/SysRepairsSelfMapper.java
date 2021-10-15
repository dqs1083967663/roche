package com.roche.manage.mapper;

import java.util.List;
import com.roche.manage.domain.SysRepairsSelf;
import org.apache.ibatis.annotations.Param;

/**
 * 自助排查问题管理Mapper接口
 * 
 * @author qiushuo
 * @date 2021-10-08
 */
public interface SysRepairsSelfMapper 
{
    /**
     * 查询自助排查问题管理
     * 
     * @param selfId 自助排查问题管理主键
     * @return 自助排查问题管理
     */
    public SysRepairsSelf selectSysRepairsSelfBySelfId(Long selfId);

    /**
     * 查询自助排查问题管理列表
     * 
     * @param sysRepairsSelf 自助排查问题管理
     * @return 自助排查问题管理集合
     */
    public List<SysRepairsSelf> selectSysRepairsSelfList(SysRepairsSelf sysRepairsSelf);

    /**
     * 新增自助排查问题管理
     * 
     * @param sysRepairsSelf 自助排查问题管理
     * @return 结果
     */
    public int insertSysRepairsSelf(SysRepairsSelf sysRepairsSelf);

    /**
     * 修改自助排查问题管理
     * 
     * @param sysRepairsSelf 自助排查问题管理
     * @return 结果
     */
    public int updateSysRepairsSelf(SysRepairsSelf sysRepairsSelf);
    /**
     * 修改自助排查的设备
     *
     * @return 结果
     */
    public int updateSysRepairsSelfByname(@Param("machineTypeBegore")String machineTypeBegore,@Param("machineTypeAfter")String machineTypeAfter);



    /**
     * 删除自助排查问题管理
     * 
     * @param selfId 自助排查问题管理主键
     * @return 结果
     */
    public int deleteSysRepairsSelfBySelfId(Long selfId);

    /**
     * 批量删除自助排查问题管理
     * 
     * @param selfIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysRepairsSelfBySelfIds(String[] selfIds);
}
