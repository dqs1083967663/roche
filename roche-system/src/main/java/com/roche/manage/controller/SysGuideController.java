package com.roche.manage.controller;

import java.util.ArrayList;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.roche.common.annotation.Log;
import com.roche.common.enums.BusinessType;
import com.roche.manage.domain.SysGuide;
import com.roche.manage.service.ISysGuideService;
import com.roche.common.core.controller.BaseController;
import com.roche.common.core.domain.AjaxResult;
import com.roche.common.utils.poi.ExcelUtil;
import com.roche.common.core.page.TableDataInfo;

/**
 * 指引管理Controller
 * 
 * @author qiushuo dong
 * @date 2021-09-26
 */
@Controller
@RequestMapping("/manage/guide")
public class SysGuideController extends BaseController
{
    private String prefix = "manage/guide";

    @Autowired
    private ISysGuideService sysGuideService;

    @RequiresPermissions("manage:guide:view")
    @GetMapping()
    public String guide()
    {
        return prefix + "/guide";
    }

    /**
     * 查询指引管理列表
     */
    @RequiresPermissions("manage:guide:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysGuide sysGuide)
    {
        startPage();
        List<SysGuide> list = sysGuideService.selectSysGuideList(sysGuide);
        return getDataTable(list);
    }

    /**
     * 导出指引管理列表
     */
    @RequiresPermissions("manage:guide:export")
    @Log(title = "指引管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysGuide sysGuide)
    {
        List<SysGuide> list = sysGuideService.selectSysGuideList(sysGuide);
        ExcelUtil<SysGuide> util = new ExcelUtil<SysGuide>(SysGuide.class);
        return util.exportExcel(list, "指引管理数据");
    }
    /**
     * 指定导出指引管理列表
     */
    @Log(title = "指引管理", businessType = BusinessType.EXPORT)
    @PostMapping("/exportbyname")
    @ResponseBody
    public  AjaxResult export(String[] outname)
    {
        ExcelUtil<SysGuide> util = new ExcelUtil<SysGuide>(SysGuide.class);


        return util.exportExcelbyname(new ArrayList<>(), "指引管理数据",outname);
    }


    /**
     * 新增指引管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }
    /**
     * 导出指引管理
     */
    @GetMapping("/open")
    public String open()
    {

        return prefix + "/open";
    }

    /**
     * 新增保存指引管理
     */
    @RequiresPermissions("manage:guide:add")
    @Log(title = "指引管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysGuide sysGuide)
    {
        return toAjax(sysGuideService.insertSysGuide(sysGuide));
    }

    /**
     * 编辑新增指引图片
     */
    @RequiresPermissions("manage:guide:add")
    @Log(title = "指引管理", businessType = BusinessType.INSERT)
    @PostMapping("/addEdit")
    @ResponseBody
    public AjaxResult addEditSave(SysGuide sysGuide)
    {


        return toAjax(sysGuideService.insertEditSysGuide(sysGuide.getGuideId(),sysGuide.getGuideImg()));
    }


    /**
     * 修改指引管理
     */
    @GetMapping("/edit/{guideId}")
    public String edit(@PathVariable("guideId") Long guideId, ModelMap mmap)
    {
        SysGuide sysGuide = sysGuideService.selectSysGuideByGuideId(guideId);
        mmap.put("sysGuide", sysGuide);
        return prefix + "/edit";
    }

    /**
     * 修改保存指引管理
     */
    @RequiresPermissions("manage:guide:edit")
    @Log(title = "指引管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysGuide sysGuide)
    {
        return toAjax(sysGuideService.updateSysGuide(sysGuide));
    }

    /**
     * 删除指引管理
     */
    @RequiresPermissions("manage:guide:remove")
    @Log(title = "指引管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysGuideService.deleteSysGuideByGuideIds(ids));
    }

    /**
     * 删除指引内图片管理
     */
    @RequiresPermissions("manage:guide:remove")
    @Log(title = "指引管理", businessType = BusinessType.DELETE)
    @PostMapping( "/removeImg")
    @ResponseBody
    public AjaxResult removeImg(String imageUrl,Long guideId)
    {
        return toAjax(sysGuideService.deleteSysGuideImgByGuideId(imageUrl,guideId));
    }


    @RequiresPermissions("manage:guide:detail")
    @GetMapping("/detail/{guideId}")
    public String detail(@PathVariable("guideId") Long guideId, ModelMap mmap)
    {
        SysGuide sysGuide = sysGuideService.selectSysGuideByGuideId(guideId);
        mmap.put("sysGuide", sysGuide);
        return prefix + "/detail";
    }


}
