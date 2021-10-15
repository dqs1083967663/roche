package com.roche.manage.service;

import java.util.List;
import com.roche.manage.domain.SysRepairsSelfClickHistory;

/**
 * 自助排查问题点击历史Service接口
 * 
 * @author ruoyi
 * @date 2021-10-14
 */
public interface ISysRepairsSelfClickHistoryService 
{
    /**
     * 查询自助排查问题点击历史
     * 
     * @param oid 自助排查问题点击历史主键
     * @return 自助排查问题点击历史
     */
    public SysRepairsSelfClickHistory selectSysRepairsSelfClickHistoryByOid(String oid);

    /**
     * 查询自助排查问题点击历史列表
     * 
     * @param sysRepairsSelfClickHistory 自助排查问题点击历史
     * @return 自助排查问题点击历史集合
     */
    public List<SysRepairsSelfClickHistory> selectSysRepairsSelfClickHistoryList(SysRepairsSelfClickHistory
                                                                                         sysRepairsSelfClickHistory);

    /**
     * 新增自助排查问题点击历史
     * 
     * @param sysRepairsSelfClickHistory 自助排查问题点击历史
     * @return 结果
     */
    public int insertSysRepairsSelfClickHistory(SysRepairsSelfClickHistory sysRepairsSelfClickHistory);

    /**
     * 修改自助排查问题点击历史
     * 
     * @param sysRepairsSelfClickHistory 自助排查问题点击历史
     * @return 结果
     */
    public int updateSysRepairsSelfClickHistory(SysRepairsSelfClickHistory sysRepairsSelfClickHistory);

    /**
     * 批量删除自助排查问题点击历史
     * 
     * @param oids 需要删除的自助排查问题点击历史主键集合
     * @return 结果
     */
    public int deleteSysRepairsSelfClickHistoryByOids(String oids);

    /**
     * 删除自助排查问题点击历史信息
     * 
     * @param oid 自助排查问题点击历史主键
     * @return 结果
     */
    public int deleteSysRepairsSelfClickHistoryByOid(String oid);
}
