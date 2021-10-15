package com.roche.manage.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.roche.common.core.domain.entity.SysRole;
import com.roche.common.core.domain.entity.SysUser;
import com.roche.manage.domain.SysRepairsSelfClickHistory;
import com.roche.manage.service.ISysRepairsSelfClickHistoryService;
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
import com.roche.manage.domain.RepairsHistory;
import com.roche.manage.service.IRepairsHistoryService;
import com.roche.common.core.controller.BaseController;
import com.roche.common.core.domain.AjaxResult;
import com.roche.common.utils.poi.ExcelUtil;
import com.roche.common.core.page.TableDataInfo;

/**
 * 自助排查维修统计Controller
 * 
 * @author qiushuodong
 * @date 2021-10-13
 */
@Controller
@RequestMapping("/manage/repairshistory")
public class RepairsHistoryController extends BaseController
{
    private String prefix = "manage/repairshistory";

    @Autowired
    private IRepairsHistoryService repairsHistoryService;

    @Autowired
    private ISysRepairsSelfClickHistoryService sysRepairsSelfClickHistoryService;

    @RequiresPermissions("manage:repairshistory:view")
    @GetMapping()
    public String repairshistory()
    {
        return prefix + "/repairshistory";
    }

    /**
     * 查询自助排查维修统计列表
     */
    @RequiresPermissions("manage:repairshistory:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RepairsHistory repairsHistory)
    {
        startPage();
        List<RepairsHistory> list = repairsHistoryService.selectRepairsHistoryList(repairsHistory);
        return getDataTable(list);
    }

    /**
     * 导出自助排查维修统计列表
     */
    @RequiresPermissions("manage:repairshistory:export")
    @Log(title = "自助排查维修统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RepairsHistory repairsHistory)
    {
        List<RepairsHistory> list = repairsHistoryService.selectRepairsHistoryList(repairsHistory);
        ExcelUtil<RepairsHistory> util = new ExcelUtil<RepairsHistory>(RepairsHistory.class);
        return util.exportExcel(list, "自助排查维修统计数据");
    }
    /**
     * 进角色页
     */
    @GetMapping("/authRole/{selfId}")
    public String authRole(@PathVariable("selfId") Long selfId, ModelMap mmap)
    {

        mmap.put("selfId", selfId);
        return prefix + "/history";
    }

//    /**
//     * 新增自助排查维修统计
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存自助排查维修统计
//     */
//    @RequiresPermissions("manage:repairshistory:add")
//    @Log(title = "自助排查维修统计", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    public AjaxResult addSave(RepairsHistory repairsHistory)
//    {
//        return toAjax(repairsHistoryService.insertRepairsHistory(repairsHistory));
//    }
//
//    /**
//     * 修改自助排查维修统计
//     */
//    @GetMapping("/edit/{selfId}")
//    public String edit(@PathVariable("selfId") Long selfId, ModelMap mmap)
//    {
//        RepairsHistory repairsHistory = repairsHistoryService.selectRepairsHistoryBySelfId(selfId);
//        mmap.put("repairsHistory", repairsHistory);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存自助排查维修统计
//     */
//    @RequiresPermissions("manage:repairshistory:edit")
//    @Log(title = "自助排查维修统计", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    public AjaxResult editSave(RepairsHistory repairsHistory)
//    {
//        return toAjax(repairsHistoryService.updateRepairsHistory(repairsHistory));
//    }
//
//    /**
//     * 删除自助排查维修统计
//     */
//    @RequiresPermissions("manage:repairshistory:remove")
//    @Log(title = "自助排查维修统计", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    public AjaxResult remove(String ids)
//    {
//        return toAjax(repairsHistoryService.deleteRepairsHistoryBySelfIds(ids));
//    }
}
