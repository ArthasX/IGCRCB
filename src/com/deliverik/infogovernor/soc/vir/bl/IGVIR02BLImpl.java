/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
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
 * ���⻯��Դ����ҵ���߼�ʵ��
 *
 */
public class IGVIR02BLImpl extends BaseBLImpl implements IGVIR02BL {

    static Log log = LogFactory.getLog(IGVIR0201Action.class);
    
    /** VIMҵ���߼�����BL */
    
    protected VIMBL vimBL;
    
    /** ������Դ������Ŀҵ���߼�����BL */
    protected VIM02BL vim02BL;
    
    /** ������Դ���������ҵ���߼�����BL */
    protected VIM03BL vim03BL;
    
    /** ������Դ������־ҵ���߼�����BL */
    protected VIM04BL vim04BL;
    
    /**
     * ����VIMҵ���߼�����BL
     * @param vimBL VIMҵ���߼�����BL
     */
    public void setVimBL(VIMBL vimBL) {
        this.vimBL = vimBL;
    }

    /**
     * ����������Դ������Ŀҵ���߼�����BL
     * @param vim02BL ������Դ������Ŀҵ���߼�����BL
     */
    public void setVim02BL(VIM02BL vim02bl) {
        vim02BL = vim02bl;
    }

    /**
     * ����������Դ���������ҵ���߼�����BL
     * @param vim03BL ������Դ���������ҵ���߼�����BL
     */
    public void setVim03BL(VIM03BL vim03bl) {
        vim03BL = vim03bl;
    }

    /**
     * ����������Դ������־ҵ���߼�����BL
     * @param vim04BL ������Դ������־ҵ���߼�����BL
     */
    public void setVim04BL(VIM04BL vim04bl) {
        vim04BL = vim04bl;
    }

    /**
     * ��vCenter�ϻ�ȡ�����ģ��
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO getTemplate(IGVIR02DTO dto) throws BLException {
        log.debug("============ ��ȡ�����ģ�崦��ʼ ============");
        
        // ģ����ϢMap
        Map<String, Template> templateMap = new HashMap<String, Template>();
        try {
            List<Template> searchTemplate = vimBL.searchTemplate();
            
            for (Template template : searchTemplate) {
                templateMap.put(template.getVcid() + "!##!" + template.getVcname()+ "@_@" + template.getName(), template);
            }
            
        } catch (Exception e) {
            log.error("��ȡ�����ģ���쳣", e);
            throw new BLException("IGVIR0201.E001");
        }
//        JSONObject jsonObject = new JSONObject(templateMap);
//        String templateJson = jsonObject.toString();
        
        Gson gson = new Gson();
        String templateJson = gson.toJson(templateMap);
        dto.setTemplateJson(templateJson);
        gson = null;
        log.debug("============ ��ȡ�����ģ�崦����� ============");
        return dto;
    }
    
    /**
     * ����������Ŀ�������Ϣ
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO saveApplyVMInfo(IGVIR02DTO dto) throws BLException {
        log.debug("============ ����������Ŀ�������Ϣ��ʼ ============");
        
        IGVIR0201Form form = dto.getIgvir0201Form();
        User user = dto.getUser();
        
        // ��ĿTB
        VIM02TB vim02tb = new VIM02TB();
        BeanUtils.copyProperties(form, vim02tb);
        vim02tb.setOrgsyscoding(user.getOrgid());
        vim02tb.setOrgname(user.getOrgname());
        VIM02Info vim02info = null;
        
        // ѡ��������Ŀ
        if (null != form.getHpid() && 0 != form.getHpid() && !"0".equals(form.getHpid())) {
            vim02tb.setId(form.getHpid());
            vim02info = vim02BL.updateVIM02(vim02tb);
        } else {
            vim02info = vim02BL.registVIM02(vim02tb);
        }
            
        // ������Ŀ
        
        // ȡ�����������Ϣ
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
            // �ж�ģ���Ƿ�Ϊ��
            if(StringUtils.isNotEmpty(vcenter_template)){
                // vCenter��Ϣ
                String vCenter[] = vcenter_template.split("@_@")[0].split("!##!");
                vcenterId = vCenter[0];
                vcenterName = vCenter[1];
                // ģ����Ϣ
                template = vcenter_template.split("@_@")[1];
            }
            String vmname = vmnames[i];
            String vmcpu = vmcpus[i];
            String vmmem = vmmems[i];
            String vmdisk = vmdisks[i];
//            String applyTime = applyTimes[i];
            String expiryTime = expiryTimes[i];
            
            // �����Ϣʵ�帳ֵ
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
        log.debug("============ ����������Ŀ�������Ϣ���� ============");
        return dto;
    }
    
    /**
     * ��ȡ������Ŀ�����Ϣ
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO getApplyVMInf(IGVIR02DTO dto) throws BLException {
        log.debug("============== ��ȡ������Ŀ�����Ϣ��ʼ ==============");
        Integer pid = Integer.parseInt(dto.getPid());
        Vim03SearchCondImpl cond =  new Vim03SearchCondImpl();
        cond.setPid_eq(pid);
//        cond.setProgressIsNull(true);
        cond.setPrid(dto.getPrid());
        // ��ѯ��Ŀ��Ϣ
        VIM02Info vim02info = vim02BL.searchVIM02ByPK(pid);
        // ��ѯ�����Ϣ
        List<VIM03Info> searchVim03 = vim03BL.searchVim03(cond);
        Map<String, Object> infoMap = new HashMap<String, Object>();
        infoMap.put("ProjectInfo", vim02info);
        infoMap.put("VmInfo", searchVim03);
        Gson gson = new Gson();
        String vmInfo_json = gson.toJson(infoMap);
        dto.setVmInfo_json(vmInfo_json);
        gson = null;
        log.debug("============== ��ȡ������Ŀ�����Ϣ���� ==============");
        return dto;
    }
    
    /**
     * ����������Ŀ�������Ϣ
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO saveVMInfo4Approve(IGVIR02DTO dto) throws BLException {
        log.debug("============ ����������Ŀ�������Ϣ��ʼ ============");
        
        IGVIR0202Form form = dto.getIgvir0202Form();
        Integer pid = Integer.parseInt(form.getPid());
        
        Vim03SearchCondImpl cond =  new Vim03SearchCondImpl();
        cond.setPid_eq(pid);
        // ��ѯ�����Ϣ
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
        log.debug("============ ����������Ŀ�������Ϣ���� ============");
        return dto;
    }
    
    /**
     * ����vCenter id��ѯhost�б�
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchHostByVcid(IGVIR02DTO dto) throws BLException {
        log.debug("=========== ����vCenter id��ѯhost�б���ʼ ==========");
        
        List<Host> hostList = vimBL.searchHostByVcid(dto.getVcid());
        Gson gson = new Gson();
        String hostlist_json = gson.toJson(hostList);
        dto.setHostlist_json(hostlist_json);
        gson = null;
        
        log.debug("=========== ����vCenter id��ѯhost�б������ ==========");
        return dto;
    }
    
    /**
     * ����������ѯ����
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchNetLabelByHost(IGVIR02DTO dto) throws BLException {
        log.debug("=============== ����������ѯ���紦��ʼ ==============");
        
        List<NetLabel> searchNetLabelByHost = vimBL.searchNetLabelByHost(dto.getVcid(), dto.getHostip());
        Gson gson = new Gson();
        String netlabel_json = gson.toJson(searchNetLabelByHost);
        dto.setNetLabel_json(netlabel_json);
        gson = null;
        
        log.debug("=============== ����������ѯ���紦����� ==============");
        return dto;
    }
    
    /**
     * �����������Ĳ�ѯ����
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchNetLabelByDatacenter(IGVIR02DTO dto) throws BLException {
        log.debug("=============== �����������Ĳ�ѯ���紦��ʼ ==============");
        
        List<NetLabel> networklist = vimBL.searchNetLabelByDatacenter(dto.getVcid(), dto.getDcname());
        Gson gson = new Gson();
        String netlabel_json = gson.toJson(networklist);
        dto.setNetLabel_json(netlabel_json);
        gson = null;
        
        log.debug("=============== �����������Ĳ�ѯ���紦����� ==============");
        return dto;
    }
    
    /**
     * ��ȡ������Ŀ�����Ϣ
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO getApplyVMList(IGVIR02DTO dto) throws BLException {
        log.debug("============== ��ȡ������Ŀ�����Ϣ��ʼ ==============");
        Integer pid = Integer.parseInt(dto.getPid());
        Vim03SearchCondImpl cond =  new Vim03SearchCondImpl();
        cond.setPid_eq(pid);
        List<VIM03Info> searchVim03 = vim03BL.searchVim03(cond);
        dto.setVim03List(searchVim03);
        log.debug("============== ��ȡ������Ŀ�����Ϣ���� ==============");
        return dto;
    }
    
    /**
     * ��ѯ��������
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchDatacenterByVcid(IGVIR02DTO dto) throws BLException {
        log.debug("============ ����vCenter��ѯ�������Ĵ���ʼ ============");
        
        List<Data_Center> datacenterList = vimBL.searchDatacenterByVcid(dto.getVcid());
        Gson gson = new Gson();
        String datacenter_json = gson.toJson(datacenterList);
        dto.setDatacenter_json(datacenter_json);
        gson = null;
        
        log.debug("============ ����vCenter��ѯ�������Ĵ������ ============");
        return dto;
    }
    
    /**
     * ��ѯ��Դ��
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchResourcePoolByVcid(IGVIR02DTO dto) throws BLException {
        log.debug("=========== ����vCenter��ѯ��Դ����Ϣ����ʼ ==============");
        
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
        
        log.debug("=========== ����vCenter��ѯ��Դ����Ϣ����ʼ ==============");
        return dto;
    }
    
    /**
     * ��ѯ���������־
     * 
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchDeployLog(IGVIR02DTO dto) throws BLException {
        log.debug("=============== ��ѯ���������־����ʼ =============");
        
        VIM04SearchCondImpl cond = new VIM04SearchCondImpl();
        cond.setPid_eq(Integer.parseInt(dto.getPid()));
        List<VIM04Info> vim04List = this.vim04BL.searchVIM04(cond);
        Gson gson = new Gson();
        String deployLog_json = gson.toJson(vim04List);
        dto.setDeployLog_json(deployLog_json);
        gson = null;
        
        log.debug("=============== ��ѯ���������־������� =============");
        return dto;
    }
    public static void main(String[] args) throws BLException {
        new IGVIR02BLImpl().getTemplate(new IGVIR02DTO());
    }

}
