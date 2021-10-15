package com.roche.manage.mapper;

import java.util.List;
import com.roche.manage.domain.SysRepairsSelfClickHistory;

/**
 * 自助排查问题点击历史Mapper接口
 * 
 * @author ruoyi
 * @date 2021-10-14
 */
public interface SysRepairsSelfClickHistoryMapper 
{
    /**
     * 查询自助排查问题点击历史
     * 
     * @param oid 自助排查问题点击历史主键
     * @return 自助排查问题点击历史
     */
    public SysRepairsSelfClickHistory selectSysRepairsSelfClickHistoryByOid(String oid);


    /**
     * 查询自助排查问题点击历史的名
     *
     */
    public String selectUserName(Long userId);

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
     * 删除自助排查问题点击历史
     * 
     * @param oid 自助排查问题点击历史主键
     * @return 结果
     */
    public int deleteSysRepairsSelfClickHistoryByOid(String oid);

    /**
     * 批量删除自助排查问题点击历史
     * 
     * @param oids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysRepairsSelfClickHistoryByOids(String[] oids);
}
