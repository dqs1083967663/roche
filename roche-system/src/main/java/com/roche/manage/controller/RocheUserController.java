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
import com.roche.manage.domain.RocheUser;
import com.roche.manage.service.IRocheUserService;
import com.roche.common.core.controller.BaseController;
import com.roche.common.core.domain.AjaxResult;
import com.roche.common.utils.poi.ExcelUtil;
import com.roche.common.core.page.TableDataInfo;

/**
 * 注册用户查询Controller
 * 
 * @author dongqiushuo
 * @date 2021-10-11
 */
@Controller
@RequestMapping("/manage/user")
public class RocheUserController extends BaseController
{
    private String prefix = "manage/user";

    @Autowired
    private IRocheUserService rocheUserService;

    @RequiresPermissions("manage:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    /**
     * 查询注册用户查询列表
     */
    @RequiresPermissions("manage:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RocheUser rocheUser)
    {
        startPage();
        List<RocheUser> list = rocheUserService.selectRocheUserList(rocheUser);
        return getDataTable(list);
    }

    /**
     * 导出注册用户查询列表
     */
    @RequiresPermissions("manage:user:export")
    @Log(title = "注册用户查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RocheUser rocheUser)
    {
        List<RocheUser> list = rocheUserService.selectRocheUserList(rocheUser);
        ExcelUtil<RocheUser> util = new ExcelUtil<RocheUser>(RocheUser.class);
        return util.exportExcel(list, "注册用户查询数据");
    }

    /**
     * 新增注册用户查询
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存注册用户查询
     */
    @RequiresPermissions("manage:user:add")
    @Log(title = "注册用户查询", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RocheUser rocheUser)
    {
        return toAjax(rocheUserService.insertRocheUser(rocheUser));
    }

    /**
     * 修改注册用户查询
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        RocheUser rocheUser = rocheUserService.selectRocheUserByUserId(userId);
        mmap.put("rocheUser", rocheUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存注册用户查询
     */
    @RequiresPermissions("manage:user:edit")
    @Log(title = "注册用户查询", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RocheUser rocheUser)
    {
        return toAjax(rocheUserService.updateRocheUser(rocheUser));
    }

    /**
     * 删除注册用户查询
     */
    @RequiresPermissions("manage:user:remove")
    @Log(title = "注册用户查询", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(rocheUserService.deleteRocheUserByUserIds(ids));
    }

    @RequiresPermissions("manage:user:detail")
    @GetMapping("/detail/{userId}")
    public String detail(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        RocheUser rocheUser = rocheUserService.selectRocheUserByUserId(userId);
        mmap.put("rocheUser", rocheUser);
        return prefix + "/detail";
    }
}
