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
import com.roche.manage.domain.RocheMachineType;
import com.roche.manage.service.IRocheMachineTypeService;
import com.roche.common.core.controller.BaseController;
import com.roche.common.core.domain.AjaxResult;
import com.roche.common.utils.poi.ExcelUtil;
import com.roche.common.core.page.TableDataInfo;

/**
 * 设备类型管理Controller
 * 
 * @author dongqiushuo
 * @date 2021-10-11
 */
@Controller
@RequestMapping("/manage/type")
public class RocheMachineTypeController extends BaseController
{
    private String prefix = "manage/type";

    @Autowired
    private IRocheMachineTypeService rocheMachineTypeService;

    @RequiresPermissions("manage:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询设备类型管理列表
     */
    @RequiresPermissions("manage:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RocheMachineType rocheMachineType)
    {
        startPage();
        List<RocheMachineType> list = rocheMachineTypeService.selectRocheMachineTypeList(rocheMachineType);
        return getDataTable(list);
    }

    /**
     * 导出设备类型管理列表
     */
    @RequiresPermissions("manage:type:export")
    @Log(title = "设备类型管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RocheMachineType rocheMachineType)
    {
        List<RocheMachineType> list = rocheMachineTypeService.selectRocheMachineTypeList(rocheMachineType);
        ExcelUtil<RocheMachineType> util = new ExcelUtil<RocheMachineType>(RocheMachineType.class);
        return util.exportExcel(list, "设备类型管理数据");
    }

    /**
     * 新增设备类型管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备类型管理
     */
    @RequiresPermissions("manage:type:add")
    @Log(title = "设备类型管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RocheMachineType rocheMachineType)
    {
        return toAjax(rocheMachineTypeService.insertRocheMachineType(rocheMachineType));
    }

    /**
     * 修改设备类型管理
     */
    @GetMapping("/edit/{machineTypeId}")
    public String edit(@PathVariable("machineTypeId") Long machineTypeId, ModelMap mmap)
    {
        RocheMachineType rocheMachineType = rocheMachineTypeService.selectRocheMachineTypeByMachineTypeId(machineTypeId);
        mmap.put("rocheMachineType", rocheMachineType);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备类型管理
     */
    @RequiresPermissions("manage:type:edit")
    @Log(title = "设备类型管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RocheMachineType rocheMachineType)
    {
        return toAjax(rocheMachineTypeService.updateRocheMachineType(rocheMachineType));
    }

    /**
     * 删除设备类型管理
     */
    @RequiresPermissions("manage:type:remove")
    @Log(title = "设备类型管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(rocheMachineTypeService.deleteRocheMachineTypeByMachineTypeIds(ids));
    }
}
