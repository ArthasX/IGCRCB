/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG480Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����鶨�屣��VO
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD03021VO extends BaseVO{
	
	public IGPRD03021VO(){
		
	}
	
	public IGPRD03021VO(List<IG480Info> processGroupDefinitionList){
		
		this.processGroupDefinitionList = processGroupDefinitionList;
	}
	
	protected IG480Info processGroupDefinition;

	
	protected List<IG480Info> processGroupDefinitionList;


	/**
	 * processGroupDefinition   ȡ��
	 * @return processGroupDefinition processGroupDefinition
	 */
	public IG480Info getProcessGroupDefinition() {
		return processGroupDefinition;
	}

	/**
	 * processGroupDefinition   �趨
	 * @param processGroupDefinition processGroupDefinition
	 */
	public void setProcessGroupDefinition(IG480Info processGroupDefinition) {
		this.processGroupDefinition = processGroupDefinition;
	}

	/**
	 * processGroupDefinitionList   ȡ��
	 * @return processGroupDefinitionList processGroupDefinitionList
	 */
	public List<IG480Info> getProcessGroupDefinitionList() {
		return processGroupDefinitionList;
	}

	/**
	 * processGroupDefinitionList   �趨
	 * @param processGroupDefinitionList processGroupDefinitionList
	 */
	public void setProcessGroupDefinitionList(
			List<IG480Info> processGroupDefinitionList) {
		this.processGroupDefinitionList = processGroupDefinitionList;
	}
	
	
	
	



	
	
}
