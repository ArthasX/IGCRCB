/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ɷ������̼���VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR03051VO extends BaseVO{

	/**�������弯��*/
	protected Map<IG259Info,List<IG380Info>> templateDefinitionMap;

	/**
	 * �������弯��ȡ��
	 * @return templateDefinitionMap �������弯��
	 */
	public Map<IG259Info, List<IG380Info>> getTemplateDefinitionMap() {
		return templateDefinitionMap;
	}

	/**
	 * �������弯���趨
	 * @param templateDefinitionMap �������弯��
	 */
	public void setTemplateDefinitionMap(
			Map<IG259Info, List<IG380Info>> templateDefinitionMap) {
		this.templateDefinitionMap = templateDefinitionMap;
	}
}
