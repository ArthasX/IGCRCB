/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */
package com.deliverik.infogovernor.soc.vir.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM02BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM04BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR03DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0301Form;
import com.deliverik.infogovernor.soc.vir.model.VIM02Info;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM02SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.condition.Vim03SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM03TB;
import com.deliverik.infogovernor.soc.vir.vim.VIMBL;
import com.google.gson.Gson;

/**
 * 虚拟化资源调整业务逻辑实现
 *
 */
public class IGVIR03BLImpl extends BaseBLImpl implements IGVIR03BL {

    static Log log = LogFactory.getLog(IGVIR03BLImpl.class);
    
    /** VIM业务逻辑处理BL */
    
    protected VIMBL vimBL;
    
    /** 虚拟资源申请项目业务逻辑处理BL */
    protected VIM02BL vim02BL;
    
    /** 虚拟资源申请虚拟机业务逻辑处理BL */
    protected VIM03BL vim03BL;
    
    /** 虚拟资源部署日志业务逻辑处理BL */
    protected VIM04BL vim04BL;
    
    /**
     * 设置VIM业务逻辑处理BL
     * @param vimBL VIM业务逻辑处理BL
     */
    public void setVimBL(VIMBL vimBL) {
        this.vimBL = vimBL;
    }

    /**
     * 设置虚拟资源申请项目业务逻辑处理BL
     * @param vim02BL 虚拟资源申请项目业务逻辑处理BL
     */
    public void setVim02BL(VIM02BL vim02bl) {
        vim02BL = vim02bl;
    }

    /**
     * 设置虚拟资源申请虚拟机业务逻辑处理BL
     * @param vim03BL 虚拟资源申请虚拟机业务逻辑处理BL
     */
    public void setVim03BL(VIM03BL vim03bl) {
        vim03BL = vim03bl;
    }

    /**
     * 设置虚拟资源部署日志业务逻辑处理BL
     * @param vim04BL 虚拟资源部署日志业务逻辑处理BL
     */
    public void setVim04BL(VIM04BL vim04bl) {
        vim04BL = vim04bl;
    }

    /**
     * 查询项目列表
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR03DTO searchProjectList(IGVIR03DTO dto) throws BLException {
        log.debug("==================== 查询项目列表处理开始 =================");
        
        VIM02SearchCondImpl cond = new VIM02SearchCondImpl();
        cond.setProgress_eq("100");
        List<VIM02Info> vim02List = vim02BL.searchVIM02(cond);
        dto.setVim02List(vim02List);
        
        log.debug("==================== 查询项目列表处理结束 =================");
        return dto;
    }
    
    /**
     * 获取申请项目虚机信息
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR03DTO getApplyVMInf(IGVIR03DTO dto) throws BLException {
        log.debug("============== 获取申请项目虚机信息开始 ==============");
        Integer pid = Integer.parseInt(dto.getPid());
        User user = dto.getUser();
        Vim03SearchCondImpl cond =  new Vim03SearchCondImpl();
        cond.setPid_eq(pid);
        if (null != user) {
            cond.setUserid_eq(user.getUserid());
        }
        // 查询项目信息
        VIM02Info vim02info = vim02BL.searchVIM02ByPK(pid);
        // 查询虚机信息
        List<VIM03Info> searchVim03 = vim03BL.searchVim03(cond);
        Map<String, Object> infoMap = new HashMap<String, Object>();
        infoMap.put("ProjectInfo", vim02info);
        infoMap.put("VmInfo", searchVim03);
        Gson gson = new Gson();
        String vmInfo_json = gson.toJson(infoMap);
        dto.setVmInfo_json(vmInfo_json);
        gson = null;
        log.debug("============== 获取申请项目虚机信息结束 ==============");
        return dto;
    }
    
    /**
     * 保存调整后的虚机信息
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR03DTO saveApplyVMInfo(IGVIR03DTO dto) throws BLException {
        log.debug("============ 调整虚机信息处理开始 ============");
        
        IGVIR0301Form form = dto.getIgvir0301Form();
        Integer pid = form.getPid();
        
        Vim03SearchCondImpl cond = new Vim03SearchCondImpl();
        cond.setPid_eq(pid);
        List<VIM03Info> vim03List = vim03BL.searchVim03(cond);
        
        Map<Integer, VIM03Info> vim03Map = new HashMap<Integer, VIM03Info>();
        for (VIM03Info vim03Info : vim03List) {
            vim03Map.put(vim03Info.getId(), vim03Info);
        }
        
        // 取得虚机信息
        Integer[] vmids = form.getVmids();
        String[] vmcpus = form.getVmcpus();
        String[] vmmems = form.getVmmems();
        String[] vmdisks = form.getVmdisks();
        
        List<VIM03Info> vim03infoList = new ArrayList<VIM03Info>();
        for (int i = 0; i < vmcpus.length; i++) {
            Integer vmid = vmids[i];
            VIM03Info vim03Info = vim03Map.get(vmid);
            VIM03TB vim03tb = (VIM03TB) SerializationUtils.clone(vim03Info);
            String vmcpu = vmcpus[i];
            String vmmem = vmmems[i];
            String vmdisk = vmdisks[i];
            
            // 虚机信息实体赋值
            vim03tb.setVmCpus(Integer.parseInt(vmcpu));
            vim03tb.setVmMem(Integer.parseInt(vmmem));
            vim03tb.setVmDisk(Integer.parseInt(vmdisk));
            vim03infoList.add(vim03tb);
        }
        vim03BL.registVim03All(vim03infoList);
        
        vim03Map = null;
        vim03List = null;
        vim03infoList = null;
        log.debug("============ 调整虚机信息处理结束 ============");
        return dto;
    }
    
    
    
    
    public static void main(String[] args) throws BLException {
        
        
    }

}
