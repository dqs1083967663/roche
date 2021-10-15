package com.roche.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.roche.manage.mapper.RocheUserMapper;
import com.roche.manage.domain.RocheUser;
import com.roche.manage.service.IRocheUserService;
import com.roche.common.core.text.Convert;

/**
 * 注册用户查询Service业务层处理
 * 
 * @author dongqiushuo
 * @date 2021-10-11
 */
@Service
public class RocheUserServiceImpl implements IRocheUserService 
{
    @Autowired
    private RocheUserMapper rocheUserMapper;

    /**
     * 查询注册用户查询
     * 
     * @param userId 注册用户查询主键
     * @return 注册用户查询
     */
    @Override
    public RocheUser selectRocheUserByUserId(Long userId)
    {
        return rocheUserMapper.selectRocheUserByUserId(userId);
    }

    /**
     * 查询注册用户查询列表
     * 
     * @param rocheUser 注册用户查询
     * @return 注册用户查询
     */
    @Override
    public List<RocheUser> selectRocheUserList(RocheUser rocheUser)
    {
        return rocheUserMapper.selectRocheUserList(rocheUser);
    }

    /**
     * 新增注册用户查询
     * 
     * @param rocheUser 注册用户查询
     * @return 结果
     */
    @Override
    public int insertRocheUser(RocheUser rocheUser)
    {
        return rocheUserMapper.insertRocheUser(rocheUser);
    }

    /**
     * 修改注册用户查询
     * 
     * @param rocheUser 注册用户查询
     * @return 结果
     */
    @Override
    public int updateRocheUser(RocheUser rocheUser)
    {
        return rocheUserMapper.updateRocheUser(rocheUser);
    }

    /**
     * 批量删除注册用户查询
     * 
     * @param userIds 需要删除的注册用户查询主键
     * @return 结果
     */
    @Override
    public int deleteRocheUserByUserIds(String userIds)
    {
        return rocheUserMapper.deleteRocheUserByUserIds(Convert.toStrArray(userIds));
    }

    /**
     * 删除注册用户查询信息
     * 
     * @param userId 注册用户查询主键
     * @return 结果
     */
    @Override
    public int deleteRocheUserByUserId(Long userId)
    {
        return rocheUserMapper.deleteRocheUserByUserId(userId);
    }
}
