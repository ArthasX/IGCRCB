/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG480Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程组定义保存VO
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
	 * processGroupDefinition   取得
	 * @return processGroupDefinition processGroupDefinition
	 */
	public IG480Info getProcessGroupDefinition() {
		return processGroupDefinition;
	}

	/**
	 * processGroupDefinition   设定
	 * @param processGroupDefinition processGroupDefinition
	 */
	public void setProcessGroupDefinition(IG480Info processGroupDefinition) {
		this.processGroupDefinition = processGroupDefinition;
	}

	/**
	 * processGroupDefinitionList   取得
	 * @return processGroupDefinitionList processGroupDefinitionList
	 */
	public List<IG480Info> getProcessGroupDefinitionList() {
		return processGroupDefinitionList;
	}

	/**
	 * processGroupDefinitionList   设定
	 * @param processGroupDefinitionList processGroupDefinitionList
	 */
	public void setProcessGroupDefinitionList(
			List<IG480Info> processGroupDefinitionList) {
		this.processGroupDefinitionList = processGroupDefinitionList;
	}
	
	
	
	



	
	
}
