package com.roche.manage.mapper;

import java.util.List;
import com.roche.manage.domain.RepairsHistory;

/**
 * 自助排查维修统计Mapper接口
 * 
 * @author qiushuodong
 * @date 2021-10-13
 */
public interface RepairsHistoryMapper 
{


    /**
     * 查询自助排查维修统计用户数量
     *
     * @param selfId 自助排查维修统计主键
     * @return 自助排查维修统计
     */
    public int selectUserNumBySelfId(Long selfId);


    /**
     * 查询自助排查维修统计
     * 
     * @param selfId 自助排查维修统计主键
     * @return 自助排查维修统计
     */
    public RepairsHistory selectRepairsHistoryBySelfId(Long selfId);

    /**
     * 查询自助排查维修统计列表
     * 
     * @param repairsHistory 自助排查维修统计
     * @return 自助排查维修统计集合
     */
    public List<RepairsHistory> selectRepairsHistoryList(RepairsHistory repairsHistory);

//    /**
//     * 新增自助排查维修统计
//     *
//     * @param repairsHistory 自助排查维修统计
//     * @return 结果
//     */
//    public int insertRepairsHistory(RepairsHistory repairsHistory);
//
//    /**
//     * 修改自助排查维修统计
//     *
//     * @param repairsHistory 自助排查维修统计
//     * @return 结果
//     */
//    public int updateRepairsHistory(RepairsHistory repairsHistory);
//
//    /**
//     * 删除自助排查维修统计
//     *
//     * @param selfId 自助排查维修统计主键
//     * @return 结果
//     */
//    public int deleteRepairsHistoryBySelfId(Long selfId);
//
//    /**
//     * 批量删除自助排查维修统计
//     *
//     * @param selfIds 需要删除的数据主键集合
//     * @return 结果
//     */
//    public int deleteRepairsHistoryBySelfIds(String[] selfIds);
}
