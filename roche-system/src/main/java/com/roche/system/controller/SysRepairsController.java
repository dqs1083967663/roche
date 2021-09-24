package com.roche.system.controller;

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
import com.roche.system.domain.SysRepairs;
import com.roche.system.service.ISysRepairsService;
import com.roche.common.core.controller.BaseController;
import com.roche.common.core.domain.AjaxResult;
import com.roche.common.utils.poi.ExcelUtil;
import com.roche.common.core.page.TableDataInfo;

/**
 * 報修Controller
 * 
 * @author aarn
 * @date 2021-09-23
 */
@Controller
@RequestMapping("/system/repairs")
public class SysRepairsController extends BaseController
{
    private String prefix = "system/repairs";

    @Autowired
    private ISysRepairsService sysRepairsService;

    @RequiresPermissions("system:repairs:view")
    @GetMapping()
    public String repairs()
    {
        return prefix + "/repairs";
    }

    /**
     * 查询報修列表
     */
    @RequiresPermissions("system:repairs:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysRepairs sysRepairs)
    {
        startPage();
        List<SysRepairs> list = sysRepairsService.selectSysRepairsList(sysRepairs);
        return getDataTable(list);
    }

    /**
     * 导出報修列表
     */
    @RequiresPermissions("system:repairs:export")
    @Log(title = "報修", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysRepairs sysRepairs)
    {
        List<SysRepairs> list = sysRepairsService.selectSysRepairsList(sysRepairs);
        ExcelUtil<SysRepairs> util = new ExcelUtil<SysRepairs>(SysRepairs.class);
        return util.exportExcel(list, "報修数据");
    }

    /**
     * 新增報修
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存報修
     */
    @RequiresPermissions("system:repairs:add")
    @Log(title = "報修", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysRepairs sysRepairs)
    {
        return toAjax(sysRepairsService.insertSysRepairs(sysRepairs));
    }

    /**
     * 修改報修
     */
    @GetMapping("/edit/{repairsId}")
    public String edit(@PathVariable("repairsId") Long repairsId, ModelMap mmap)
    {
        SysRepairs sysRepairs = sysRepairsService.selectSysRepairsByRepairsId(repairsId);
        mmap.put("sysRepairs", sysRepairs);
        return prefix + "/edit";
    }

    /**
     * 修改保存報修
     */
    @RequiresPermissions("system:repairs:edit")
    @Log(title = "報修", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysRepairs sysRepairs)
    {
        return toAjax(sysRepairsService.updateSysRepairs(sysRepairs));
    }

    /**
     * 删除報修
     */
    @RequiresPermissions("system:repairs:remove")
    @Log(title = "報修", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysRepairsService.deleteSysRepairsByRepairsIds(ids));
    }
}
