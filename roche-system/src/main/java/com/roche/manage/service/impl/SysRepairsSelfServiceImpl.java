package com.roche.manage.service.impl;

import java.util.List;
import java.util.ArrayList;

import com.roche.common.core.domain.Ztree;
import com.roche.common.utils.StringUtils;
import com.roche.manage.domain.SysGuide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.roche.manage.mapper.SysRepairsSelfMapper;
import com.roche.manage.domain.SysRepairsSelf;
import com.roche.manage.service.ISysRepairsSelfService;
import com.roche.common.core.text.Convert;

/**
 * 自助排查问题管理Service业务层处理
 *
 * @author dongqiushuo
 * @date 2021-10-08
 */
@Service
public class SysRepairsSelfServiceImpl implements ISysRepairsSelfService {
    @Autowired
    private SysRepairsSelfMapper sysRepairsSelfMapper;

    /**
     * 查询自助排查问题管理
     *
     * @param selfId 自助排查问题管理主键
     * @return 自助排查问题管理
     */
    @Override
    public SysRepairsSelf selectSysRepairsSelfBySelfId(Long selfId) {
        return sysRepairsSelfMapper.selectSysRepairsSelfBySelfId(selfId);
    }

    /**
     * 查询自助排查问题管理列表
     *
     * @param sysRepairsSelf 自助排查问题管理
     * @return 自助排查问题管理
     */
    @Override
    public List<SysRepairsSelf> selectSysRepairsSelfList(SysRepairsSelf sysRepairsSelf) {
        return sysRepairsSelfMapper.selectSysRepairsSelfList(sysRepairsSelf);
    }

    /**
     * 新增自助排查问题管理
     *
     * @param sysRepairsSelf 自助排查问题管理
     * @return 结果
     */
    @Override
    public int insertSysRepairsSelf(SysRepairsSelf sysRepairsSelf) {
        if (sysRepairsSelf.getParentId() == null && sysRepairsSelf.getMachineType().equals("")) {
            //祖父节点没有录设备
            return 0;
        } else if (sysRepairsSelf.getParentId() == null && !sysRepairsSelf.getMachineType().equals("")) {
            //祖父节点录入
            long parentId = 0 ;
            sysRepairsSelf.setParentId(parentId);
            sysRepairsSelf.setTreePath("0");
            return sysRepairsSelfMapper.insertSysRepairsSelf(sysRepairsSelf);
        } else {
            SysRepairsSelf sysRepairsSelfFather = sysRepairsSelfMapper.selectSysRepairsSelfBySelfId(sysRepairsSelf
                    .getParentId());
            String machineType =  sysRepairsSelfFather.getMachineType();
          String treePath =   sysRepairsSelfFather.getTreePath()+","+sysRepairsSelfFather.getSelfId();
            sysRepairsSelf.setMachineType(machineType);
            sysRepairsSelf.setTreePath(treePath);
            return sysRepairsSelfMapper.insertSysRepairsSelf(sysRepairsSelf);
        }


    }

    /**
     * 修改自助排查问题管理
     *
     * @param sysRepairsSelf 自助排查问题管理
     * @return 结果
     */
    @Override
    public int updateSysRepairsSelf(SysRepairsSelf sysRepairsSelf) {

        SysRepairsSelf sysRepairsSelfBefore = sysRepairsSelfMapper.selectSysRepairsSelfBySelfId(sysRepairsSelf
                .getSelfId());

        //祖父修改
        if (sysRepairsSelf.getParentId()==0){

            //祖父设备
            if (sysRepairsSelfBefore.getMachineType().equals(sysRepairsSelf.getMachineType())){
                return sysRepairsSelfMapper.updateSysRepairsSelf(sysRepairsSelf);
            }else{

                SysRepairsSelf sysRepairsSelfSelect = new SysRepairsSelf();
                sysRepairsSelfSelect.setMachineType(sysRepairsSelf.getMachineType());
               int sysRepairsSelves = sysRepairsSelfMapper.selectSysRepairsSelfList
                        (sysRepairsSelfSelect).size();

               //已经存在一样的设备
               if (sysRepairsSelves != 0){
                   return 999;
               }

               //修改了祝福id
               if (sysRepairsSelf.getParentId()!=0){
                   return 888;
               }
                //祖父修改了设备
                sysRepairsSelfMapper.updateSysRepairsSelfByname(sysRepairsSelfBefore.getMachineType(),sysRepairsSelf
                        .getMachineType());
                return sysRepairsSelfMapper.updateSysRepairsSelf(sysRepairsSelf);
            }
        }else{
            //子节点修改
            if (!sysRepairsSelfBefore.getMachineType().equals(sysRepairsSelf.getMachineType())){
                //子节点修改了设备
                return 0;
            }

            //修改了父id
            if (sysRepairsSelf.getParentId()!=sysRepairsSelfBefore.getParentId()){
                return 888;
            }


            return sysRepairsSelfMapper.updateSysRepairsSelf(sysRepairsSelf);
        }

    }

    /**
     * 批量删除自助排查问题管理
     *
     * @param selfIds 需要删除的自助排查问题管理主键
     * @return 结果
     */
    @Override
    public int deleteSysRepairsSelfBySelfIds(String selfIds) {
        return sysRepairsSelfMapper.deleteSysRepairsSelfBySelfIds(Convert.toStrArray(selfIds));
    }

    /**
     * 删除自助排查问题管理信息
     *
     * @param selfId 自助排查问题管理主键
     * @return 结果
     */
    @Override
    public int deleteSysRepairsSelfBySelfId(Long selfId) {

        SysRepairsSelf sysRepairsSelf = new SysRepairsSelf();
        sysRepairsSelf.setParentId(selfId);
        List<SysRepairsSelf> sysRepairsSeleList = sysRepairsSelfMapper.selectSysRepairsSelfList(sysRepairsSelf);
        if (sysRepairsSeleList.size() != 0) {
            return 0;
        } else {
            return sysRepairsSelfMapper.deleteSysRepairsSelfBySelfId(selfId);
        }

    }

    /**
     * 查询自助排查问题管理树列表
     *
     * @return 所有自助排查问题管理信息
     */
    @Override
    public List<Ztree> selectSysRepairsSelfTree() {
        List<SysRepairsSelf> sysRepairsSelfList = sysRepairsSelfMapper.selectSysRepairsSelfList(new SysRepairsSelf());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (SysRepairsSelf sysRepairsSelf : sysRepairsSelfList) {
            Ztree ztree = new Ztree();
            ztree.setId(sysRepairsSelf.getSelfId());
            ztree.setpId(sysRepairsSelf.getParentId());
            ztree.setName(sysRepairsSelf.getRepairsName());
            ztree.setTitle(sysRepairsSelf.getRepairsName());
            ztrees.add(ztree);
        }
        return ztrees;
    }

    @Override
    public int insertEditSysRepairsSelf(Long selfId, String picture) {


        SysRepairsSelf sysRepairsSelf = sysRepairsSelfMapper.selectSysRepairsSelfBySelfId(selfId);
        String imgurl = "";
        imgurl = sysRepairsSelf.getPicture();
        if (!imgurl.isEmpty()) {

            sysRepairsSelf.setPicture(imgurl + "," + picture);
        } else {

            sysRepairsSelf.setPicture(picture);
        }
        ;


        return sysRepairsSelfMapper.updateSysRepairsSelf(sysRepairsSelf);

    }

    @Override
    public int deleteImgBySelfId(String imageUrl, Long selfId) {

        SysRepairsSelf sysRepairsSelf = sysRepairsSelfMapper.selectSysRepairsSelfBySelfId(selfId);
        String urldelete = StringUtils.urldelete(imageUrl, sysRepairsSelf.getPicture());
        sysRepairsSelf.setPicture(urldelete);
        return sysRepairsSelfMapper.updateSysRepairsSelf(sysRepairsSelf);

    }
}
