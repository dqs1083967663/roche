package com.roche.manage.service;

import java.util.List;
import com.roche.manage.domain.SysGuide;

/**
 * 指引管理Service接口
 * 
 * @author qiushuo dong
 * @date 2021-09-26
 */
public interface ISysGuideService 
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
     * 新增指引管理
     *
     * @param guideId 指引管理
     * @return 结果
     */
    public int insertEditSysGuide(Long guideId ,String url);

    /**
     * 修改指引管理
     * 
     * @param sysGuide 指引管理
     * @return 结果
     */
    public int updateSysGuide(SysGuide sysGuide);

    /**
     * 批量删除指引管理
     * 
     * @param guideIds 需要删除的指引管理主键集合
     * @return 结果
     */
    public int deleteSysGuideByGuideIds(String guideIds);

    /**
     * 删除指引管理信息
     * 
     * @param guideId 指引管理主键
     * @return 结果
     */
    public int deleteSysGuideByGuideId(Long guideId);
    /**
     * 删除指引中的图片信息
     *
     * @param guideId 指引管理主键
     * @return 结果
     */
    public int deleteSysGuideImgByGuideId(String imageUrl,Long guideId);
}
