package com.roche.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.roche.manage.mapper.SysRepairsSelfClickHistoryMapper;
import com.roche.manage.domain.SysRepairsSelfClickHistory;
import com.roche.manage.service.ISysRepairsSelfClickHistoryService;
import com.roche.common.core.text.Convert;

/**
 * 自助排查问题点击历史Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-14
 */
@Service
public class SysRepairsSelfClickHistoryServiceImpl implements ISysRepairsSelfClickHistoryService 
{
    @Autowired
    private SysRepairsSelfClickHistoryMapper sysRepairsSelfClickHistoryMapper;

    /**
     * 查询自助排查问题点击历史
     * 
     * @param oid 自助排查问题点击历史主键
     * @return 自助排查问题点击历史
     */
    @Override
    public SysRepairsSelfClickHistory selectSysRepairsSelfClickHistoryByOid(String oid)
    {
        return sysRepairsSelfClickHistoryMapper.selectSysRepairsSelfClickHistoryByOid(oid);
    }

    /**
     * 查询自助排查问题点击历史列表
     * 
     * @param sysRepairsSelfClickHistory 自助排查问题点击历史
     * @return 自助排查问题点击历史
     */
    @Override
    public List<SysRepairsSelfClickHistory> selectSysRepairsSelfClickHistoryList(SysRepairsSelfClickHistory sysRepairsSelfClickHistory)
    {
        List<SysRepairsSelfClickHistory> sysRepairsSelfClickHistories = sysRepairsSelfClickHistoryMapper
                .selectSysRepairsSelfClickHistoryList(sysRepairsSelfClickHistory);

        for (int i = 0; i <sysRepairsSelfClickHistories.size() ; i++) {
            SysRepairsSelfClickHistory sysRepairsSelfClickHistory1 = sysRepairsSelfClickHistories.get(i);
            String userName= sysRepairsSelfClickHistoryMapper.selectUserName(sysRepairsSelfClickHistory1.getUserId());
            sysRepairsSelfClickHistory1.setUserName(userName);
            sysRepairsSelfClickHistories.set(i,sysRepairsSelfClickHistory1);
        }
        return sysRepairsSelfClickHistories;
    }

    /**
     * 新增自助排查问题点击历史
     * 
     * @param sysRepairsSelfClickHistory 自助排查问题点击历史
     * @return 结果
     */
    @Override
    public int insertSysRepairsSelfClickHistory(SysRepairsSelfClickHistory sysRepairsSelfClickHistory)
    {
        return sysRepairsSelfClickHistoryMapper.insertSysRepairsSelfClickHistory(sysRepairsSelfClickHistory);
    }

    /**
     * 修改自助排查问题点击历史
     * 
     * @param sysRepairsSelfClickHistory 自助排查问题点击历史
     * @return 结果
     */
    @Override
    public int updateSysRepairsSelfClickHistory(SysRepairsSelfClickHistory sysRepairsSelfClickHistory)
    {
        return sysRepairsSelfClickHistoryMapper.updateSysRepairsSelfClickHistory(sysRepairsSelfClickHistory);
    }

    /**
     * 批量删除自助排查问题点击历史
     * 
     * @param oids 需要删除的自助排查问题点击历史主键
     * @return 结果
     */
    @Override
    public int deleteSysRepairsSelfClickHistoryByOids(String oids)
    {
        return sysRepairsSelfClickHistoryMapper.deleteSysRepairsSelfClickHistoryByOids(Convert.toStrArray(oids));
    }

    /**
     * 删除自助排查问题点击历史信息
     * 
     * @param oid 自助排查问题点击历史主键
     * @return 结果
     */
    @Override
    public int deleteSysRepairsSelfClickHistoryByOid(String oid)
    {
        return sysRepairsSelfClickHistoryMapper.deleteSysRepairsSelfClickHistoryByOid(oid);
    }
}
