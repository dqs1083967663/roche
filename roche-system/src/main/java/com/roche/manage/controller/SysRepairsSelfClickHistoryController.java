package com.roche.manage.controller;

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
import com.roche.manage.domain.SysRepairsSelfClickHistory;
import com.roche.manage.service.ISysRepairsSelfClickHistoryService;
import com.roche.common.core.controller.BaseController;
import com.roche.common.core.domain.AjaxResult;
import com.roche.common.utils.poi.ExcelUtil;
import com.roche.common.core.page.TableDataInfo;

/**
 * 自助排查问题点击历史Controller
 * 
 * @author ruoyi
 * @date 2021-10-14
 */
@Controller
@RequestMapping("/manage/history")
public class SysRepairsSelfClickHistoryController extends BaseController
{
    private String prefix = "manage/history";

    @Autowired
    private ISysRepairsSelfClickHistoryService sysRepairsSelfClickHistoryService;

    @RequiresPermissions("manage:history:view")
    @GetMapping()
    public String history()
    {
        return prefix + "/history";
    }

    /**
     * 查询自助排查问题点击历史列表
     */
    @RequiresPermissions("manage:history:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysRepairsSelfClickHistory sysRepairsSelfClickHistory)
    {
        startPage();
        List<SysRepairsSelfClickHistory> list = sysRepairsSelfClickHistoryService.selectSysRepairsSelfClickHistoryList(sysRepairsSelfClickHistory);
        return getDataTable(list);
    }

    /**
     * 导出自助排查问题点击历史列表
     */
    @RequiresPermissions("manage:history:export")
    @Log(title = "自助排查问题点击历史", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysRepairsSelfClickHistory sysRepairsSelfClickHistory)
    {
        List<SysRepairsSelfClickHistory> list = sysRepairsSelfClickHistoryService.selectSysRepairsSelfClickHistoryList(sysRepairsSelfClickHistory);
        ExcelUtil<SysRepairsSelfClickHistory> util = new ExcelUtil<SysRepairsSelfClickHistory>(SysRepairsSelfClickHistory.class);
        return util.exportExcel(list, "自助排查问题点击历史数据");
    }

    /**
     * 新增自助排查问题点击历史
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存自助排查问题点击历史
     */
    @RequiresPermissions("manage:history:add")
    @Log(title = "自助排查问题点击历史", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysRepairsSelfClickHistory sysRepairsSelfClickHistory)
    {
        return toAjax(sysRepairsSelfClickHistoryService.insertSysRepairsSelfClickHistory(sysRepairsSelfClickHistory));
    }

    /**
     * 修改自助排查问题点击历史
     */
    @GetMapping("/edit/{oid}")
    public String edit(@PathVariable("oid") String oid, ModelMap mmap)
    {
        SysRepairsSelfClickHistory sysRepairsSelfClickHistory = sysRepairsSelfClickHistoryService.selectSysRepairsSelfClickHistoryByOid(oid);
        mmap.put("sysRepairsSelfClickHistory", sysRepairsSelfClickHistory);
        return prefix + "/edit";
    }

    /**
     * 修改保存自助排查问题点击历史
     */
    @RequiresPermissions("manage:history:edit")
    @Log(title = "自助排查问题点击历史", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysRepairsSelfClickHistory sysRepairsSelfClickHistory)
    {
        return toAjax(sysRepairsSelfClickHistoryService.updateSysRepairsSelfClickHistory(sysRepairsSelfClickHistory));
    }

    /**
     * 删除自助排查问题点击历史
     */
    @RequiresPermissions("manage:history:remove")
    @Log(title = "自助排查问题点击历史", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysRepairsSelfClickHistoryService.deleteSysRepairsSelfClickHistoryByOids(ids));
    }
}
