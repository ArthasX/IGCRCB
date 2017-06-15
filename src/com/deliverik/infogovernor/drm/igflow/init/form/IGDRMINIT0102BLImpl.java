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
	 * �����޶�-ͨ���ʲ�ʵ��ID��ȡ�ʲ���Ϣ��ʼ�������������̷���ҳ��
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public Map<String, Object> initForm(WorkFlowParameterInfo bean) throws BLException {
		log.debug("========����ڵ����ʼ������-ͨ�������ʲ���ʼ����������ҳ�洦��ʼ========");
		Map<String, Object> map = new HashMap<String, Object>();
        String parameter = bean.getParameters();
        
        if (StringUtils.isNotEmpty(parameter)) {
        	String eiid = parameter.split("_")[0];
        	map = getProcessDefineInfoByEiid(Integer.parseInt(eiid), map);
        }
        log.debug("========����ڵ����ʼ������-ͨ�������ʲ���ʼ����������ҳ�洦�����========");
		return map;
	}
	
	/**
	 * ͨ���ʲ�ʵ��ID��ȡ�ʲ���Ϣ��ʼ�������������̷���ҳ��
	 * @param dto
	 * @return Map<String, Object>
	 * @throws BLException
	 */
	private Map<String, Object> getProcessDefineInfoByEiid(Integer eiid, Map<String, Object> map) throws BLException {
		//�ʲ��������ñ�
		Map<String, String> ciMap = new HashMap<String, String>();
		SOC0129SearchCondImpl ciCond = new SOC0129SearchCondImpl();
		ciCond.setEsyscoding_q("999060");
		ciCond.setEiid(String.valueOf(eiid));
		//ciCond.setEkey2("1");
		//�ʲ�����ʵ���
		List<SOC0129Info> ciList = soc0107BL.searchConfigItemVW(ciCond);
		for (SOC0129Info ciVW :  ciList) {
			ciMap.put(ciVW.getCname(), ciVW.getCivalue());
		}
		map.put("��������",  ciMap.get("��������"));
		String type = ciMap.get("��������");
		if(StringUtils.isNotEmpty(type)&&"1".equals(type)){
			map.put("��������",  "��ϳ���");
		}else{
			map.put("��������",  "��һ����");
		}
		String classify = ciMap.get("��������");
		if(StringUtils.isNotEmpty(classify)&& "0".equals(classify)){
			map.put("��������", "Ӧ������");
		}else{
			map.put("��������", "��������");
		}
		map.put("��������", ciMap.get("��������"));
		map.put("Ԥ�ƻָ�ʱ��", ciMap.get("Ԥ�ƻָ�ʱ��"));
		map.put("����Ӧ�����ò���", ciMap.get("����Ӧ�����ò���"));
		map.put("���峡������ID", ciMap.get("���峡������ID"));
//		map.put("��������", ciMap.get("��������"));
		map.put("ԭ����Ӧ�����ò���", ciMap.get("����Ӧ�����ò���"));
		map.put("ԭ�ʲ�ID", String.valueOf(eiid)); 
		map.put("ԭӦ����Դ�ʲ�ID", ciMap.get("Ӧ����Դ"));
		
		return map;
	}
}
