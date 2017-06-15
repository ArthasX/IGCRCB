package com.deliverik.infogovernor.drm.igflow.init.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.CodeDetailDefBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCondImpl;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowInitFormHandlerBL;

public class IGDRMINIT0102BLImpl extends BaseBLImpl implements WorkFlowInitFormHandlerBL{

    static Log log = LogFactory.getLog(IGDRMINIT0102BLImpl.class);
	
    protected RoleBL roleBL;
    
    protected UserRoleBL userRoleBL;
    
    protected CodeDetailBL codeDetailBL;
    
    protected CodeDetailDefBL codeDetailDefBL;
    
    protected OrganizationBL organizationBL;
    
    protected SOC0118BL soc0118BL;
    
    protected SOC0107BL soc0107BL;
    
    protected WorkFlowDefinitionBL workFlowDefinitionBL;
    
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	public void setCodeDetailDefBL(CodeDetailDefBL codeDetailDefBL) {
		this.codeDetailDefBL = codeDetailDefBL;
	}

	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	public void setSoc0107BL(SOC0107BL soc0107bl) {
		soc0107BL = soc0107bl;
	}

	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	
	/**
	 * 场景修订-通过资产实例ID获取资产信息初始化场景定义流程发起页面
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public Map<String, Object> initForm(WorkFlowParameterInfo bean) throws BLException {
		log.debug("========发起节点表单初始化处理-通过场景资产初始化场景发起页面处理开始========");
		Map<String, Object> map = new HashMap<String, Object>();
        String parameter = bean.getParameters();
        
        if (StringUtils.isNotEmpty(parameter)) {
        	String eiid = parameter.split("_")[0];
        	map = getProcessDefineInfoByEiid(Integer.parseInt(eiid), map);
        }
        log.debug("========发起节点表单初始化处理-通过场景资产初始化场景发起页面处理结束========");
		return map;
	}
	
	/**
	 * 通过资产实例ID获取资产信息初始化场景定义流程发起页面
	 * @param dto
	 * @return Map<String, Object>
	 * @throws BLException
	 */
	private Map<String, Object> getProcessDefineInfoByEiid(Integer eiid, Map<String, Object> map) throws BLException {
		//资产属性配置表
		Map<String, String> ciMap = new HashMap<String, String>();
		SOC0129SearchCondImpl ciCond = new SOC0129SearchCondImpl();
		ciCond.setEsyscoding_q("999060");
		ciCond.setEiid(String.valueOf(eiid));
		//ciCond.setEkey2("1");
		//资产属性实体表
		List<SOC0129Info> ciList = soc0107BL.searchConfigItemVW(ciCond);
		for (SOC0129Info ciVW :  ciList) {
			ciMap.put(ciVW.getCname(), ciVW.getCivalue());
		}
		map.put("场景名称",  ciMap.get("场景名称"));
		String type = ciMap.get("场景类型");
		if(StringUtils.isNotEmpty(type)&&"1".equals(type)){
			map.put("场景类型",  "组合场景");
		}else{
			map.put("场景类型",  "单一场景");
		}
		String classify = ciMap.get("场景分类");
		if(StringUtils.isNotEmpty(classify)&& "0".equals(classify)){
			map.put("场景分类", "应急场景");
		}else{
			map.put("场景分类", "演练场景");
		}
		map.put("场景描述", ciMap.get("场景描述"));
		map.put("预计恢复时间", ciMap.get("预计恢复时间"));
		map.put("场景应急处置步骤", ciMap.get("场景应急处置步骤"));
		map.put("定义场景流程ID", ciMap.get("定义场景流程ID"));
//		map.put("场景类型", ciMap.get("场景类型"));
		map.put("原场景应急处置步骤", ciMap.get("场景应急处置步骤"));
		map.put("原资产ID", String.valueOf(eiid)); 
		map.put("原应急资源资产ID", ciMap.get("应急资源"));
		
		return map;
	}
}
