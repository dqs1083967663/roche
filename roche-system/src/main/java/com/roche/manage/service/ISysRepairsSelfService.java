package com.roche.manage.service;

import java.util.List;
import com.roche.manage.domain.SysRepairsSelf;
import com.roche.common.core.domain.Ztree;

/**
 * 自助排查问题管理Service接口
 * 
 * @author qiushuo
 * @date 2021-10-08
 */
public interface ISysRepairsSelfService 
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
     * 批量删除自助排查问题管理
     * 
     * @param selfIds 需要删除的自助排查问题管理主键集合
     * @return 结果
     */
    public int deleteSysRepairsSelfBySelfIds(String selfIds);

    /**
     * 删除自助排查问题管理信息
     * 
     * @param selfId 自助排查问题管理主键
     * @return 结果
     */
    public int deleteSysRepairsSelfBySelfId(Long selfId);

    /**
     * 查询自助排查问题管理树列表
     * 
     * @return 所有自助排查问题管理信息
     */
    public List<Ztree> selectSysRepairsSelfTree();

    /**
     * 新增自助排查问题管理信息
     *
     * @param selfId 
     * @return 结果
     */
    public int insertEditSysRepairsSelf(Long selfId ,String picture);

    /**
     * 删除自助排查问题管理信息中的图片信息
     *
     * @param selfId 主键
     * @return 结果
     */
    public int deleteImgBySelfId(String imageUrl,Long selfId);
}
