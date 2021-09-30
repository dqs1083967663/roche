package com.roche.manage.mapper;

import java.util.List;
import com.roche.manage.domain.SysGuide;

/**
 * 指引管理Mapper接口
 * 
 * @author qiushuo dong
 * @date 2021-09-26
 */
public interface SysGuideMapper 
{
    /**
     * 查询指引管理
     * 
     * @param guideId 指引管理主键
     * @return 指引管理
     */
    public SysGuide selectSysGuideByGuideId(Long guideId);

    /**
     * 查询指引管理列表
     * 
     * @param sysGuide 指引管理
     * @return 指引管理集合
     */
    public List<SysGuide> selectSysGuideList(SysGuide sysGuide);

    /**
     * 新增指引管理
     * 
     * @param sysGuide 指引管理
     * @return 结果
     */
    public int insertSysGuide(SysGuide sysGuide);

    /**
     * 修改指引管理
     * 
     * @param sysGuide 指引管理
     * @return 结果
     */
    public int updateSysGuide(SysGuide sysGuide);

    /**
     * 删除指引管理
     * 
     * @param guideId 指引管理主键
     * @return 结果
     */
    public int deleteSysGuideByGuideId(Long guideId);

    /**
     * 批量删除指引管理
     * 
     * @param guideIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysGuideByGuideIds(String[] guideIds);

}
