/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.vo;

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
 * Description: ����ѡ��VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDWP01041VO extends BaseVO{

	/** ���̶�����Ϣ */
	protected Map<IG259Info, List<IG380Info>> processDefinitionMap;

	/**
	 * ���̶�����Ϣȡ��
	 * @return processDefinitionMap ���̶�����Ϣ
	 */
	public Map<IG259Info, List<IG380Info>> getProcessDefinitionMap() {
		return processDefinitionMap;
	}

	/**
	 * ���̶�����Ϣ�趨
	 * @param processDefinitionMap ���̶�����Ϣ
	 */
	public void setProcessDefinitionMap(
			Map<IG259Info, List<IG380Info>> processDefinitionMap) {
		this.processDefinitionMap = processDefinitionMap;
	}
}
