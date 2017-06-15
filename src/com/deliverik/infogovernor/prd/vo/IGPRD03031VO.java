/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG480Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����鶨�������������VO
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD03031VO extends BaseVO{
	
	public IGPRD03031VO(){
		
	}
	
	public IGPRD03031VO(List<IG480Info> processGroupDefinitionList){
		
		this.processGroupDefinitionList = processGroupDefinitionList;
	}
	
	protected IG480Info processGroupDefinition;

	protected List<IG380Info> innerPds;
	protected List<IG380Info> outerPds;
	

	protected List<IG480Info> processGroupDefinitionList;


	
	
	/**
	 * innerPds   ȡ��
	 * @return innerPds innerPds
	 */
	public List<IG380Info> getInnerPds() {
		return innerPds;
	}

	/**
	 * innerPds   �趨
	 * @param innerPds innerPds
	 */
	public void setInnerPds(List<IG380Info> innerPds) {
		this.innerPds = innerPds;
	}

	/**
	 * outerPds   ȡ��
	 * @return outerPds outerPds
	 */
	public List<IG380Info> getOuterPds() {
		return outerPds;
	}

	/**
	 * outerPds   �趨
	 * @param outerPds outerPds
	 */
	public void setOuterPds(List<IG380Info> outerPds) {
		this.outerPds = outerPds;
	}

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
