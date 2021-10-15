package com.roche.manage.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.roche.manage.mapper.RepairsHistoryMapper;
import com.roche.manage.domain.RepairsHistory;
import com.roche.manage.service.IRepairsHistoryService;
import com.roche.common.core.text.Convert;

/**
 * 自助排查维修统计Service业务层处理
 *
 * @author qiushuodong
 * @date 2021-10-13
 */
@Service
public class RepairsHistoryServiceImpl implements IRepairsHistoryService {
    @Autowired
    private RepairsHistoryMapper repairsHistoryMapper;

    /**
     * 查询自助排查维修统计
     *
     * @param selfId 自助排查维修统计主键
     * @return 自助排查维修统计
     */
    @Override
    public RepairsHistory selectRepairsHistoryBySelfId(Long selfId) {
        return repairsHistoryMapper.selectRepairsHistoryBySelfId(selfId);
    }

    /**
     * 查询自助排查维修统计列表
     *
     * @param repairsHistory 自助排查维修统计
     * @return 自助排查维修统计
     */
    @Override
    public List<RepairsHistory> selectRepairsHistoryList(RepairsHistory repairsHistory) {
        List<RepairsHistory> repairsHistories = repairsHistoryMapper.selectRepairsHistoryList(repairsHistory);


        for (int i = 0; i <repairsHistories.size(); i++) {
            RepairsHistory repairsHistoryGet = repairsHistories.get(i);
            //计算成功率
            Long usefulCount = repairsHistoryGet.getUsefulCount();
            Long uselessCount = repairsHistoryGet.getUselessCount();
            if (usefulCount!=null &&uselessCount!=null){
                double persent =((double) usefulCount /(double) (uselessCount + usefulCount))*100;
                BigDecimal b   =   new   BigDecimal(persent);
                double   persentAfter   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
                String suessesPersent = persentAfter+"%";
                repairsHistoryGet.setUsefulPercent(suessesPersent);
            }else
            {
                repairsHistoryGet.setUsefulPercent("无法计算");
            }


            //统计客户访问数量
            int userNum = repairsHistoryMapper.selectUserNumBySelfId(repairsHistoryGet.getSelfId());
            repairsHistoryGet.setUseNum((long)userNum);

            repairsHistories.set(i,repairsHistoryGet);
        }
        return repairsHistories;
    }

//    /**
//     * 新增自助排查维修统计
//     *
//     * @param repairsHistory 自助排查维修统计
//     * @return 结果
//     */
//    @Override
//    public int insertRepairsHistory(RepairsHistory repairsHistory)
//    {
//        return repairsHistoryMapper.insertRepairsHistory(repairsHistory);
//    }
//
//    /**
//     * 修改自助排查维修统计
//     *
//     * @param repairsHistory 自助排查维修统计
//     * @return 结果
//     */
//    @Override
//    public int updateRepairsHistory(RepairsHistory repairsHistory)
//    {
//        return repairsHistoryMapper.updateRepairsHistory(repairsHistory);
//    }
//
//    /**
//     * 批量删除自助排查维修统计
//     *
//     * @param selfIds 需要删除的自助排查维修统计主键
//     * @return 结果
//     */
//    @Override
//    public int deleteRepairsHistoryBySelfIds(String selfIds)
//    {
//        return repairsHistoryMapper.deleteRepairsHistoryBySelfIds(Convert.toStrArray(selfIds));
//    }
//
//    /**
//     * 删除自助排查维修统计信息
//     *
//     * @param selfId 自助排查维修统计主键
//     * @return 结果
//     */
//    @Override
//    public int deleteRepairsHistoryBySelfId(Long selfId)
//    {
//        return repairsHistoryMapper.deleteRepairsHistoryBySelfId(selfId);
//    }
}
