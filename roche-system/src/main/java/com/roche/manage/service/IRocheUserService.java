package com.roche.manage.service;

import java.util.List;
import com.roche.manage.domain.RocheUser;

/**
 * 注册用户查询Service接口
 * 
 * @author dongqiushuo
 * @date 2021-10-11
 */
public interface IRocheUserService 
{
    /**
     * 查询注册用户查询
     * 
     * @param userId 注册用户查询主键
     * @return 注册用户查询
     */
    public RocheUser selectRocheUserByUserId(Long userId);

    /**
     * 查询注册用户查询列表
     * 
     * @param rocheUser 注册用户查询
     * @return 注册用户查询集合
     */
    public List<RocheUser> selectRocheUserList(RocheUser rocheUser);

    /**
     * 新增注册用户查询
     * 
     * @param rocheUser 注册用户查询
     * @return 结果
     */
    public int insertRocheUser(RocheUser rocheUser);

    /**
     * 修改注册用户查询
     * 
     * @param rocheUser 注册用户查询
     * @return 结果
     */
    public int updateRocheUser(RocheUser rocheUser);

    /**
     * 批量删除注册用户查询
     * 
     * @param userIds 需要删除的注册用户查询主键集合
     * @return 结果
     */
    public int deleteRocheUserByUserIds(String userIds);

    /**
     * 删除注册用户查询信息
     * 
     * @param userId 注册用户查询主键
     * @return 结果
     */
    public int deleteRocheUserByUserId(Long userId);
}
