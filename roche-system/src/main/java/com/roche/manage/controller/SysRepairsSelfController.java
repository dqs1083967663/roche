package com.roche.manage.controller;

import java.util.List;

import com.roche.manage.domain.SysGuide;
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
import com.roche.manage.domain.SysRepairsSelf;
import com.roche.manage.service.ISysRepairsSelfService;
import com.roche.common.core.controller.BaseController;
import com.roche.common.core.domain.AjaxResult;
import com.roche.common.utils.poi.ExcelUtil;
import com.roche.common.utils.StringUtils;
import com.roche.common.core.domain.Ztree;

/**
 * 自助排查问题管理Controller
 * 
 * @author qiushuo
 * @date 2021-10-08
 */
@Controller
@RequestMapping("/manage/self")
public class SysRepairsSelfController extends BaseController
{
    private String prefix = "manage/self";

    @Autowired
    private ISysRepairsSelfService sysRepairsSelfService;

    @RequiresPermissions("manage:self:view")
    @GetMapping()
    public String self()
    {
        return prefix + "/self";
    }

    /**
     * 查询自助排查问题管理树列表
     */
    @RequiresPermissions("manage:self:list")
    @PostMapping("/list")
    @ResponseBody
    public List<SysRepairsSelf> list(SysRepairsSelf sysRepairsSelf)
    {
        List<SysRepairsSelf> list = sysRepairsSelfService.selectSysRepairsSelfList(sysRepairsSelf);
        return list;
    }

    /**
     * 导出自助排查问题管理列表
     */
    @RequiresPermissions("manage:self:export")
    @Log(title = "自助排查问题管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysRepairsSelf sysRepairsSelf)
    {
        List<SysRepairsSelf> list = sysRepairsSelfService.selectSysRepairsSelfList(sysRepairsSelf);
        ExcelUtil<SysRepairsSelf> util = new ExcelUtil<SysRepairsSelf>(SysRepairsSelf.class);
        return util.exportExcel(list, "自助排查问题管理数据");
    }

    /**
     * 新增自助排查问题管理
     */
    @GetMapping(value = { "/add/{selfId}", "/add/" })
    public String add(@PathVariable(value = "selfId", required = false) Long selfId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(selfId))
        {
            mmap.put("sysRepairsSelf", sysRepairsSelfService.selectSysRepairsSelfBySelfId(selfId));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存自助排查问题管理
     */
    @RequiresPermissions("manage:self:add")
    @Log(title = "自助排查问题管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysRepairsSelf sysRepairsSelf)
    {
      int result =  sysRepairsSelfService.insertSysRepairsSelf(sysRepairsSelf);
        if(result == 0){
            return AjaxResult.warn("祖父类必须填入设备信息");
        }else{
            return toAjax(result);
        }

    }

    /**
     * 修改自助排查问题管理
     */
    @GetMapping("/edit/{selfId}")
    public String edit(@PathVariable("selfId") Long selfId, ModelMap mmap)
    {
        SysRepairsSelf sysRepairsSelf = sysRepairsSelfService.selectSysRepairsSelfBySelfId(selfId);
        mmap.put("sysRepairsSelf", sysRepairsSelf);
        return prefix + "/edit";
    }

    /**
     * 修改保存自助排查问题管理
     */
    @RequiresPermissions("manage:self:edit")
    @Log(title = "自助排查问题管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysRepairsSelf sysRepairsSelf)
    {
        int result = sysRepairsSelfService.updateSysRepairsSelf(sysRepairsSelf);
        if (result==0){
            return AjaxResult.warn("子项目的设备禁止修改");
        }
        if (result==999){
            return AjaxResult.warn("设备已经存在请修改设备");
        }
        if (result==888){
            return AjaxResult.warn("禁止修改父id");
        }
        return toAjax(result);
    }

    /**
     * 删除
     */
    @RequiresPermissions("manage:self:remove")
    @Log(title = "自助排查问题管理", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{selfId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("selfId") Long selfId)
    {
        int result= sysRepairsSelfService.deleteSysRepairsSelfBySelfId(selfId);
        if (result==0){
            return AjaxResult.warn("无法删除，还存在子项目");
        }else{
            return toAjax(result);
        }

    }

    /**
     * 选择自助排查问题管理树
     */
    @GetMapping(value = { "/selectSelfTree/{selfId}", "/selectSelfTree/" })
    public String selectSelfTree(@PathVariable(value = "selfId", required = false) Long selfId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(selfId))
        {
            mmap.put("sysRepairsSelf", sysRepairsSelfService.selectSysRepairsSelfBySelfId(selfId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载自助排查问题管理树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = sysRepairsSelfService.selectSysRepairsSelfTree();
        return ztrees;
    }


    /**
     * 编辑新增指引图片
     */
    @RequiresPermissions("manage:self:add")
    @Log(title = "自助排查问题管理", businessType = BusinessType.INSERT)
    @PostMapping("/addEdit")
    @ResponseBody
    public AjaxResult addEditSave(SysRepairsSelf sysRepairsSelf)
    {


        return toAjax(sysRepairsSelfService.insertEditSysRepairsSelf(sysRepairsSelf.getSelfId(),sysRepairsSelf.getPicture()));
    }
    /**
     * 删除指引内图片管理
     */
    @RequiresPermissions("manage:self:remove")
    @Log(title = "自助排查问题管理", businessType = BusinessType.DELETE)
    @PostMapping( "/removeImg")
    @ResponseBody
    public AjaxResult removeImg(String imageUrl,Long selfId)
    {
        return toAjax(sysRepairsSelfService.deleteImgBySelfId(imageUrl,selfId));
    }
}
