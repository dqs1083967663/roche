package com.roche.manage.service.impl;

import java.util.List;

import com.roche.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.roche.manage.mapper.SysGuideMapper;
import com.roche.manage.domain.SysGuide;
import com.roche.manage.service.ISysGuideService;
import com.roche.common.core.text.Convert;

/**
 * 指引管理Service业务层处理
 * 
 * @author qiushuo dong
 * @date 2021-09-26
 */
@Service
public class SysGuideServiceImpl implements ISysGuideService 
{
    @Autowired
    private SysGuideMapper sysGuideMapper;

    /**
     * 查询指引管理
     * 
     * @param guideId 指引管理主键
     * @return 指引管理
     */
    @Override
    public SysGuide selectSysGuideByGuideId(Long guideId)
    {
        return sysGuideMapper.selectSysGuideByGuideId(guideId);
    }

    /**
     * 查询指引管理列表
     * 
     * @param sysGuide 指引管理
     * @return 指引管理
     */
    @Override
    public List<SysGuide> selectSysGuideList(SysGuide sysGuide)
    {
        return sysGuideMapper.selectSysGuideList(sysGuide);
    }

    /**
     * 新增指引管理
     * 
     * @param sysGuide 指引管理
     * @return 结果
     */
    @Override
    public int insertSysGuide(SysGuide sysGuide)
    {
        return sysGuideMapper.insertSysGuide(sysGuide);
    }

    /**
     * 新增指引管理
     *
     * @param guideId 指引管理
     * @return 结果
     */
    @Override
    public int insertEditSysGuide(Long guideId, String url) {

        SysGuide sysGuide = sysGuideMapper.selectSysGuideByGuideId(guideId);
        String imgurl="";
        imgurl= sysGuide.getGuideImg();
        if(!imgurl.isEmpty()){

            sysGuide.setGuideImg(imgurl+","+url);
        }else{

            sysGuide.setGuideImg(url);
        };


        return  sysGuideMapper.updateSysGuide(sysGuide);
    }



    /**
     * 修改指引管理
     * 
     * @param sysGuide 指引管理
     * @return 结果
     */
    @Override
    public int updateSysGuide(SysGuide sysGuide)
    {
        return sysGuideMapper.updateSysGuide(sysGuide);
    }

    /**
     * 批量删除指引管理
     * 
     * @param guideIds 需要删除的指引管理主键
     * @return 结果
     */
    @Override
    public int deleteSysGuideByGuideIds(String guideIds)
    {
        return sysGuideMapper.deleteSysGuideByGuideIds(Convert.toStrArray(guideIds));
    }

    /**
     * 删除指引管理信息
     * 
     * @param guideId 指引管理主键
     * @return 结果
     */
    @Override
    public int deleteSysGuideByGuideId(Long guideId)
    {
        return sysGuideMapper.deleteSysGuideByGuideId(guideId);
    }

    /**
     * 删除指引中的图片信息
     *
     * @param guideId 指引管理主键
     * @return 结果
     */
    @Override
    public int deleteSysGuideImgByGuideId(String imageUrl,Long guideId)
    {
        SysGuide sysGuide = sysGuideMapper.selectSysGuideByGuideId(guideId);
        System.out.println("删除的图"+imageUrl);
        System.out.println("图"+sysGuide.getGuideImg());
        String urldelete =StringUtils.urldelete(imageUrl, sysGuide.getGuideImg());
        System.out.println("删除后的图"+urldelete);
        sysGuide.setGuideImg(urldelete);
        return sysGuideMapper.updateSysGuide(sysGuide);
    }
    


}
