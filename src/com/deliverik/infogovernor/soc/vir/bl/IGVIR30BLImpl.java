/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.vir.IGVIRCONSTANTS;
import com.deliverik.infogovernor.soc.vir.bl.task.VCD01BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VCD02BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VCD03BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VCD04BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VCD05BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VCD06BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR30DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR3001Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR3002Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR3003Form;
import com.deliverik.infogovernor.soc.vir.model.VCD01Info;
import com.deliverik.infogovernor.soc.vir.model.VCD02Info;
import com.deliverik.infogovernor.soc.vir.model.VCD03Info;
import com.deliverik.infogovernor.soc.vir.model.VCD04Info;
import com.deliverik.infogovernor.soc.vir.model.VCD05Info;
import com.deliverik.infogovernor.soc.vir.model.VCD06Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD03SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD04SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD06SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD02TB;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD03TB;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD05TB;
import com.deliverik.infogovernor.soc.vir.vcd.VCDBL;
import com.deliverik.infogovernor.soc.vir.vcd.model.Catalog;
import com.deliverik.infogovernor.soc.vir.vcd.model.Org;
import com.deliverik.infogovernor.soc.vir.vcd.model.Template;
import com.google.gson.Gson;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:虚拟化Vcloud管理BL实现 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR30BLImpl extends BaseBLImpl implements IGVIR30BL{
	
	/** 日志对象取得 */
	private static Log log = LogFactory.getLog(IGVIR30BLImpl.class);
	
	/** vcloudBL */
	protected VCDBL vcdBL;
	
	/** vCloud链接BL */
	protected VCD01BL vcd01BL;
	
	/** 项目BL */
	protected VCD02BL vcd02BL;
	
	/** VMBL */
	protected VCD03BL vcd03BL;
	
	/** 部署日志BL */
	protected VCD04BL vcd04BL;
	
	/** 模板BL */
	protected VCD05BL vcd05BL;
	
	/** vCloud组织与平台机构关系BL */
	protected VCD06BL vcd06BL;
	
	/** 查询类Api */
	protected FlowSearchBL flowSearchBL;

	/**
	 * vcloudBL设定
	 * @param vcdBL vcloudBL
	 */
	public void setVcdBL(VCDBL vcdBL) {
		this.vcdBL = vcdBL;
	}

	/**
	 * vCloud链接BL设定
	 * @param vcd01BL vCloud链接BL
	 */
	public void setVcd01BL(VCD01BL vcd01bl) {
		vcd01BL = vcd01bl;
	}

	/**
	 * 项目BL设定
	 * @param vcd02BL 项目BL
	 */
	public void setVcd02BL(VCD02BL vcd02bl) {
		vcd02BL = vcd02bl;
	}

	/**
	 * VMBL设定
	 * @param vcd03BL VMBL
	 */
	public void setVcd03BL(VCD03BL vcd03bl) {
		vcd03BL = vcd03bl;
	}

	/**
	 * 模板BL设定
	 * @param vcd05BL 模板BL
	 */
	public void setVcd05BL(VCD05BL vcd05bl) {
		vcd05BL = vcd05bl;
	}

	/**
	 * vCloud组织与平台机构关系BL设定
	 * @param vcd06BL vCloud组织与平台机构关系BL
	 */
	public void setVcd06BL(VCD06BL vcd06bl) {
		vcd06BL = vcd06bl;
	}

	/**
	 * 查询类Api设定
	 * @param flowSearchBL 查询类Api
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 部署日志BL设定
	 * @param vcd04BL 部署日志BL
	 */
	public void setVcd04BL(VCD04BL vcd04bl) {
		vcd04BL = vcd04bl;
	}

	/**
	 * 初始化基本信息
	 * @param dto
	 * @return
	 */
	public IGVIR30DTO initBasicInfoAction(IGVIR30DTO dto) throws BLException{
		log.debug("=========初始化基本信息操作开始========");
		//dto参数取得
		User user = dto.getUser();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//取得机构信息
		List<Org> orgs = vcdBL.searchOrg();
		VCD06Info organizationInfo = null;
		List<String> list = new ArrayList<String>();
		Map<String, Org> orgMap = new HashMap<String, Org>();
		if(orgs != null){
			for(Org o:orgs){
				if(!list.contains(o.getName())){
					list.add(o.getName());
					orgMap.put(o.getName(), o);
				}
			}
			if(!list.isEmpty()){
				VCD06SearchCondImpl vcd06Cond = new VCD06SearchCondImpl();
				vcd06Cond.setVorgs(list);
				List<VCD06Info> vcd06List = vcd06BL.searchVCD06(vcd06Cond);
				organizationInfo = getOrganizationInfo(vcd06List, user.getOrgid());
			}
		}
		if(organizationInfo != null){
			resultMap.put("resultCode", "success");
			resultMap.put("message", "操作成功！");
			resultMap.put("orgInfo", organizationInfo);
			//取得链接信息
			Org org = orgMap.get(organizationInfo.getVorg());
			VCD01Info vcd01 = vcd01BL.searchVCD01ByPK(org.getVcid());
			resultMap.put("vcInfo", vcd01);
			//取得目录列表
			List<Catalog> catalogs = vcdBL.searchCatalog(vcd01, org.getName());
			resultMap.put("catalogs", catalogs);
		}else{
			resultMap.put("resultCode", "error");
			resultMap.put("message", "部门信息部匹配！");
		}
		Gson gson = new Gson();
		String json = gson.toJson(resultMap);
		dto.setJsonResult(json);
		log.debug("=========初始化基本信息操作结束========");
		return dto;
	}
	
	/**
	 * 查询模板操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR30DTO searchTemplateAction(IGVIR30DTO dto) throws BLException {
		log.debug("==========查询模板操作开始==========");
		//dto参数取得
		IGVIR3001Form form = dto.getIgvir3001Form();
		//取得链接信息
		VCD01Info vcd01 = vcd01BL.searchVCD01ByPK(form.getVcid());
	    // 模板信息Map
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Template> searchTemplate = vcdBL.searchTemplate(vcd01,form.getVorg(),form.getCatalog());
		resultMap.put("resultCode", "success");
		resultMap.put("message", "操作成功！");
		resultMap.put("templateInfo", searchTemplate);
        Gson gson = new Gson();
        String templateJson = gson.toJson(resultMap);
        dto.setJsonResult(templateJson);
		log.debug("==========查询模板操作结束==========");
		return dto;
	}
	
	/**
	 * 保存模板信息操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR30DTO saveApplyVMInfoAction(IGVIR30DTO dto) throws BLException {
		log.debug("============保存模板信息操作开始============");
		//dto参数取得
		User user = dto.getUser();
		IGVIR3001Form form = dto.getIgvir3001Form();
		
		// 项目TB
        VCD02TB entity = new VCD02TB();
        this.copyProperties(entity, form);
        entity.setOrgsyscoding(user.getOrgid());
        entity.setOrgname(user.getOrgname());
        VCD02Info info = null;
        
        // 选着已有项目
        if (null != form.getHpid() && 0 != form.getHpid() && !"0".equals(form.getHpid())) {
        	entity.setId(form.getHpid());
            info = vcd02BL.updateVCD02(entity);
        } else {
        	info = vcd02BL.registVCD02(entity);
        }
        dto.setVcd02(info);
        // 取得新增虚机信息
        String[] templates = form.getTemplates();
        String[] vmnames = form.getVmnames();
        String[] vmcpus = form.getVmcpus();
        String[] vmmems = form.getVmmems();
        String[] vmdisks = form.getVmdisks();
        String[] expiryTimes = form.getExpiryTime();
        
        //初始化模板信息
        List<VCD05Info> templateList = vcd05BL.searchVCD05();
        Map<String, VCD05Info> templateMap = new HashMap<String, VCD05Info>();
        for(VCD05Info template:templateList){
        	templateMap.put(template.getTemplateName(), template);
        }
        
        List<VCD03Info> vcd03infoList = new ArrayList<VCD03Info>();
        StringBuffer vmids = new StringBuffer();
        for (int i = 1; i < templates.length; i++) {
            String template = templates[i];
            if(StringUtils.isEmpty(template)){
            	continue;
            }
            
            VCD05Info templateInfo = null;
            if(templateMap.get(template) == null){
            	//保存模板信息
            	VCD05TB templateTB = new VCD05TB();
            	templateTB.setTemplateName(template);
            	templateInfo = vcd05BL.registVCD05(templateTB);
            }else{
            	templateInfo = templateMap.get(template);
            }
            
            String vmname = vmnames[i];
            String vmcpu = vmcpus[i];
            String vmmem = vmmems[i];
            String vmdisk = vmdisks[i];
            String expiryTime = expiryTimes[i];
            
            // 虚机信息实体赋值
            VCD03TB vcd03tb = new VCD03TB();
            vcd03tb.setVcid(form.getVcid());
            vcd03tb.setVcname(form.getVcname());
            vcd03tb.setPid(info.getId());
            vcd03tb.setTemplateid(templateInfo.getId());
            vcd03tb.setTemplateName(template);
            vcd03tb.setVmName(vmname);
            vcd03tb.setVmCpus(Integer.parseInt(vmcpu));
            vcd03tb.setVmMem(Integer.parseInt(vmmem));
            vcd03tb.setVmDisk(Integer.parseInt(vmdisk));
            vcd03tb.setOrgsyscoding(user.getOrgid());
            vcd03tb.setOrgname(user.getOrgname());
            vcd03tb.setUserid(user.getUserid());
            vcd03tb.setUserName(user.getUsername());
            vcd03tb.setExpiryTime(expiryTime);
            vcd03infoList.add(vcd03tb);
            VCD03Info vcd03 = vcd03BL.registVCD03(vcd03tb);
            vmids.append(vcd03.getId() + "#");
        }
        dto.setVmids(vmids.toString());
		log.debug("============保存模板信息操作结束============");
		return dto;
	}
	
	/**
	 * 取得vm信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR30DTO getApplyVMInfAction(IGVIR30DTO dto) throws BLException {
		log.debug("============取得vm信息操作开始==========");
		//dto参数取得
		IGVIR3002Form form = dto.getIgvir3002Form();
		Integer pid = form.getPid();
		// 查询项目信息
		VCD02Info projectInfo = vcd02BL.searchVCD02ByPK(pid);
		VCD03SearchCondImpl cond = new VCD03SearchCondImpl();
        cond.setPid(pid);
        cond.setPrid(form.getPrid());
        // 查询虚机信息
        List<VCD03Info> vcd03List = vcd03BL.searchVCD03(cond);
        Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("resultCode", "success");
		resultMap.put("message", "操作成功！");
		resultMap.put("ProjectInfo", projectInfo);
		resultMap.put("VmInfo", vcd03List);
        Gson gson = new Gson();
        String vmInfo_json = gson.toJson(resultMap);
        dto.setJsonResult(vmInfo_json);
		log.debug("============取得vm信息操作结束==========");
		return dto;
	}
	
	/**
	 * 查询部署中的VM信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR30DTO getApplyVMListAction(IGVIR30DTO dto) throws BLException{
		log.debug("==========部署种的VM查询操作开始============");
		//dto参数取得
		IGVIR3003Form form = dto.getIgvir3003Form();
		Integer prid = form.getPrid();
		Integer pid = Integer.valueOf(flowSearchBL.searchPublicProcessInfo(prid,IGVIRCONSTANTS.APPLY_FORM_PROJECT));
		dto.setPid(pid);
		VCD03SearchCondImpl cond = new VCD03SearchCondImpl();
		cond.setPid(pid);
		cond.setPrid(prid);
		List<VCD03Info> list = vcd03BL.searchVCD03(cond);
		dto.setVcd03List(list);
		log.debug("==========部署种的VM查询操作结束============");
		return dto;
	}
	
	/**
	 * 自动部署进度数据
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR30DTO getApplyVMDataListAction(IGVIR30DTO dto) throws BLException{
		log.debug("========自动部署进度数据取得操作开始=========");
		dto = getApplyVMListAction(dto);
		Gson gson = new Gson();
		String json = gson.toJson(dto.getVcd03List());
		dto.setJsonResult(json);
		log.debug("========自动部署进度数据取得操作结束=========");
		return dto;
	}
	
	/**
	 * 查询部署日志操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR30DTO searchDeployLogAction(IGVIR30DTO dto) throws BLException{
		log.debug("==========部署日志查询操作开始==========");
		//dto参数取得
		IGVIR3002Form form = dto.getIgvir3002Form();
		VCD04SearchCondImpl cond = new VCD04SearchCondImpl();
		cond.setPid(form.getPid());
		List<VCD04Info> list = vcd04BL.searchVCD04(cond);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		dto.setJsonResult(json);
		log.debug("==========部署日志查询操作结束==========");
		return dto;
	}
	
	/**
	 * 取得用户对应机构
	 * @param set
	 * @param org
	 * @return
	 */
	private VCD06Info getOrganizationInfo(List<VCD06Info> orgs,String orgsyscoding){
		VCD06Info result = null;
		if(StringUtils.isNotEmpty(orgsyscoding) 
				&& orgsyscoding.length() >= 4 
				&& orgs != null 
				&& orgs.size() > 0){
			for(VCD06Info info:orgs){
				if(orgsyscoding.equals(info.getOrgsyscoding())){
					result = info;
					break;
				}
			}
			if(result == null){
				result = getOrganizationInfo(orgs, orgsyscoding.substring(0,orgsyscoding.length() - 3));
			}
		}
		return result;
	}
}
