/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */
package com.deliverik.infogovernor.soc.vir.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.vir.action.IGVIR0201Action;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM02BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM04BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR02DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0201Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0202Form;
import com.deliverik.infogovernor.soc.vir.model.VIM02Info;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.model.VIM04Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM04SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.condition.Vim03SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM02TB;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM03TB;
import com.deliverik.infogovernor.soc.vir.vim.VIMBL;
import com.deliverik.infogovernor.soc.vir.vim.model.Data_Center;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;
import com.deliverik.infogovernor.soc.vir.vim.model.NetLabel;
import com.deliverik.infogovernor.soc.vir.vim.model.Resource_Pool;
import com.deliverik.infogovernor.soc.vir.vim.model.Template;
import com.google.gson.Gson;

/**
 * 虚拟化资源管理业务逻辑实现
 *
 */
public class IGVIR02BLImpl extends BaseBLImpl implements IGVIR02BL {

    static Log log = LogFactory.getLog(IGVIR0201Action.class);
    
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
     * 从vCenter上获取虚拟机模板
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO getTemplate(IGVIR02DTO dto) throws BLException {
        log.debug("============ 获取虚拟机模板处理开始 ============");
        
        // 模板信息Map
        Map<String, Template> templateMap = new HashMap<String, Template>();
        try {
            List<Template> searchTemplate = vimBL.searchTemplate();
            
            for (Template template : searchTemplate) {
                templateMap.put(template.getVcid() + "!##!" + template.getVcname()+ "@_@" + template.getName(), template);
            }
            
        } catch (Exception e) {
            log.error("获取虚拟机模板异常", e);
            throw new BLException("IGVIR0201.E001");
        }
//        JSONObject jsonObject = new JSONObject(templateMap);
//        String templateJson = jsonObject.toString();
        
        Gson gson = new Gson();
        String templateJson = gson.toJson(templateMap);
        dto.setTemplateJson(templateJson);
        gson = null;
        log.debug("============ 获取虚拟机模板处理结束 ============");
        return dto;
    }
    
    /**
     * 保存申请项目和虚机信息
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO saveApplyVMInfo(IGVIR02DTO dto) throws BLException {
        log.debug("============ 保存申请项目和虚机信息开始 ============");
        
        IGVIR0201Form form = dto.getIgvir0201Form();
        User user = dto.getUser();
        
        // 项目TB
        VIM02TB vim02tb = new VIM02TB();
        BeanUtils.copyProperties(form, vim02tb);
        vim02tb.setOrgsyscoding(user.getOrgid());
        vim02tb.setOrgname(user.getOrgname());
        VIM02Info vim02info = null;
        
        // 选着已有项目
        if (null != form.getHpid() && 0 != form.getHpid() && !"0".equals(form.getHpid())) {
            vim02tb.setId(form.getHpid());
            vim02info = vim02BL.updateVIM02(vim02tb);
        } else {
            vim02info = vim02BL.registVIM02(vim02tb);
        }
            
        // 新增项目
        
        // 取得新增虚机信息
        String[] templates = form.getTemplates();
        String[] vmnames = form.getVmnames();
        String[] vmcpus = form.getVmcpus();
        String[] vmmems = form.getVmmems();
        String[] vmdisks = form.getVmdisks();
//        String[] applyTimes = form.getApplyTime();
        String[] expiryTimes = form.getExpiryTime();
        
        List<VIM03Info> vim03infoList = new ArrayList<VIM03Info>();
        StringBuffer vmids = new StringBuffer();
        for (int i = 1; i < templates.length; i++) {
            String vcenter_template = templates[i];
            String vcenterId = "";
            String vcenterName = "";
            String template = "";
            // 判断模板是否为空
            if(StringUtils.isNotEmpty(vcenter_template)){
                // vCenter信息
                String vCenter[] = vcenter_template.split("@_@")[0].split("!##!");
                vcenterId = vCenter[0];
                vcenterName = vCenter[1];
                // 模板信息
                template = vcenter_template.split("@_@")[1];
            }
            String vmname = vmnames[i];
            String vmcpu = vmcpus[i];
            String vmmem = vmmems[i];
            String vmdisk = vmdisks[i];
//            String applyTime = applyTimes[i];
            String expiryTime = expiryTimes[i];
            
            // 虚机信息实体赋值
            VIM03TB vim03tb = new VIM03TB();
            vim03tb.setPid(vim02info.getId());
            vim03tb.setPname(vim02info.getProjectName());
            if (StringUtils.isNotEmpty(vcenterId)) {
                vim03tb.setVcid(Integer.parseInt(vcenterId));
            }
            vim03tb.setVcName(vcenterName);
            vim03tb.setTemplateName(template);
            vim03tb.setVmName(vmname);
            vim03tb.setVmCpus(Integer.parseInt(vmcpu));
            vim03tb.setVmMem(Integer.parseInt(vmmem));
            vim03tb.setVmDisk(Integer.parseInt(vmdisk));
            vim03tb.setOrgsyscoding(user.getOrgid());
            vim03tb.setOrgname(user.getOrgname());
            vim03tb.setUserid(user.getUserid());
            vim03tb.setUserName(user.getUsername());
//            vim03tb.setApplyTime(applyTime);
            vim03tb.setExpiryTime(expiryTime);
            vim03infoList.add(vim03tb);
            VIM03Info vim03 = vim03BL.registVim03(vim03tb);
            vmids.append(vim03.getId() + "#");
        }
//        vim03BL.registVim03All(vim03infoList);
        dto.setVim02info(vim02info);
        dto.setVmids(vmids.toString());
        log.debug("============ 保存申请项目和虚机信息结束 ============");
        return dto;
    }
    
    /**
     * 获取申请项目虚机信息
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO getApplyVMInf(IGVIR02DTO dto) throws BLException {
        log.debug("============== 获取申请项目虚机信息开始 ==============");
        Integer pid = Integer.parseInt(dto.getPid());
        Vim03SearchCondImpl cond =  new Vim03SearchCondImpl();
        cond.setPid_eq(pid);
//        cond.setProgressIsNull(true);
        cond.setPrid(dto.getPrid());
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
     * 保存申请项目和虚机信息
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO saveVMInfo4Approve(IGVIR02DTO dto) throws BLException {
        log.debug("============ 保存申请项目和虚机信息开始 ============");
        
        IGVIR0202Form form = dto.getIgvir0202Form();
        Integer pid = Integer.parseInt(form.getPid());
        
        Vim03SearchCondImpl cond =  new Vim03SearchCondImpl();
        cond.setPid_eq(pid);
        // 查询虚机信息
        Map<String, VIM03Info> vim03map = new HashMap<String, VIM03Info>();
        List<VIM03Info> searchVim03 = vim03BL.searchVim03(cond);
        for (VIM03Info vim03Info : searchVim03) {
            vim03map.put(vim03Info.getId()+"", vim03Info);
        }
        
//        String hostNames[] = form.getHostNames();
        String networkNames[] = form.getNetworkNames();
        String vmids[] = form.getVmids();
        String[] datacenterNames = form.getDatacenterNames();
        String[] resourcePoolNames = form.getResourcePoolNames();
        List<VIM03Info> vim03infoList = new ArrayList<VIM03Info>();
        for (int i = 0; i < vmids.length; i++) {
//            String hostName = hostNames[i];
            String networkName = networkNames[i];
            String vmid = vmids[i];
            String dcname = datacenterNames[i];
            String rpname = resourcePoolNames[i];
            VIM03Info vim03info = vim03map.get(vmid);
            VIM03TB vim03tb = (VIM03TB) SerializationUtils.clone(vim03info);
//            vim03tb.setHostName(hostName);
            vim03tb.setNetworkName(networkName);
            vim03tb.setDatacenterName(dcname);
            vim03tb.setResourcePoolName(rpname);
            vim03infoList.add(vim03tb);
        }
        
        vim03BL.registVim03All(vim03infoList);
        log.debug("============ 保存申请项目和虚机信息结束 ============");
        return dto;
    }
    
    /**
     * 根据vCenter id查询host列表
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchHostByVcid(IGVIR02DTO dto) throws BLException {
        log.debug("=========== 根据vCenter id查询host列表处理开始 ==========");
        
        List<Host> hostList = vimBL.searchHostByVcid(dto.getVcid());
        Gson gson = new Gson();
        String hostlist_json = gson.toJson(hostList);
        dto.setHostlist_json(hostlist_json);
        gson = null;
        
        log.debug("=========== 根据vCenter id查询host列表处理结束 ==========");
        return dto;
    }
    
    /**
     * 根据主机查询网络
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchNetLabelByHost(IGVIR02DTO dto) throws BLException {
        log.debug("=============== 根据主机查询网络处理开始 ==============");
        
        List<NetLabel> searchNetLabelByHost = vimBL.searchNetLabelByHost(dto.getVcid(), dto.getHostip());
        Gson gson = new Gson();
        String netlabel_json = gson.toJson(searchNetLabelByHost);
        dto.setNetLabel_json(netlabel_json);
        gson = null;
        
        log.debug("=============== 根据主机查询网络处理结束 ==============");
        return dto;
    }
    
    /**
     * 根据数据中心查询网络
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchNetLabelByDatacenter(IGVIR02DTO dto) throws BLException {
        log.debug("=============== 根据数据中心查询网络处理开始 ==============");
        
        List<NetLabel> networklist = vimBL.searchNetLabelByDatacenter(dto.getVcid(), dto.getDcname());
        Gson gson = new Gson();
        String netlabel_json = gson.toJson(networklist);
        dto.setNetLabel_json(netlabel_json);
        gson = null;
        
        log.debug("=============== 根据主机中心查询网络处理结束 ==============");
        return dto;
    }
    
    /**
     * 获取申请项目虚机信息
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO getApplyVMList(IGVIR02DTO dto) throws BLException {
        log.debug("============== 获取申请项目虚机信息开始 ==============");
        Integer pid = Integer.parseInt(dto.getPid());
        Vim03SearchCondImpl cond =  new Vim03SearchCondImpl();
        cond.setPid_eq(pid);
        List<VIM03Info> searchVim03 = vim03BL.searchVim03(cond);
        dto.setVim03List(searchVim03);
        log.debug("============== 获取申请项目虚机信息结束 ==============");
        return dto;
    }
    
    /**
     * 查询数据中心
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchDatacenterByVcid(IGVIR02DTO dto) throws BLException {
        log.debug("============ 根据vCenter查询数据中心处理开始 ============");
        
        List<Data_Center> datacenterList = vimBL.searchDatacenterByVcid(dto.getVcid());
        Gson gson = new Gson();
        String datacenter_json = gson.toJson(datacenterList);
        dto.setDatacenter_json(datacenter_json);
        gson = null;
        
        log.debug("============ 根据vCenter查询数据中心处理结束 ============");
        return dto;
    }
    
    /**
     * 查询资源池
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchResourcePoolByVcid(IGVIR02DTO dto) throws BLException {
        log.debug("=========== 根据vCenter查询资源池信息处理开始 ==============");
        
        List<Resource_Pool> resourcePoolList = vimBL.searchResourcePoolByVcid(dto.getVcid());
        
        List<HashMap<String, String>> rplist = new ArrayList<HashMap<String,String>>();
        for (Resource_Pool resource_Pool : resourcePoolList) {
            String val = resource_Pool.getName();
            String label = "";
            Integer ind = val.indexOf("(");
            if (ind != -1) {
                label = val.substring(0, ind);
            } else {
                label = val;
            }
            HashMap<String, String> rlMap = new HashMap<String, String>();
            rlMap.put("label", label);
            rlMap.put("value", val);
            rplist.add(rlMap);
        }
        
        
        Gson gson = new Gson();
        String resourcePool_json = gson.toJson(rplist);
        dto.setResourcePool_json(resourcePool_json);
        gson = null;
        
        log.debug("=========== 根据vCenter查询资源池信息处理开始 ==============");
        return dto;
    }
    
    /**
     * 查询虚机部署日志
     * 
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchDeployLog(IGVIR02DTO dto) throws BLException {
        log.debug("=============== 查询虚机部署日志处理开始 =============");
        
        VIM04SearchCondImpl cond = new VIM04SearchCondImpl();
        cond.setPid_eq(Integer.parseInt(dto.getPid()));
        List<VIM04Info> vim04List = this.vim04BL.searchVIM04(cond);
        Gson gson = new Gson();
        String deployLog_json = gson.toJson(vim04List);
        dto.setDeployLog_json(deployLog_json);
        gson = null;
        
        log.debug("=============== 查询虚机部署日志处理结束 =============");
        return dto;
    }
    public static void main(String[] args) throws BLException {
        new IGVIR02BLImpl().getTemplate(new IGVIR02DTO());
    }

}
