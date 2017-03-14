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
 * Description: 流程组定义简略信息显示VO
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD03011VO extends BaseVO{
	
	public IGPRD03011VO(){
		
	}
	
	public IGPRD03011VO(List<IG480Info> processGroupDefineList){
		
		this.processGroupDefineList = processGroupDefineList;
	}
	
	

	
	protected List<IG480Info> processGroupDefineList;
	
	
	
	

	/**
	 * processGroupDefineList   取得
	 * @return processGroupDefineList processGroupDefineList
	 */
	public List<IG480Info> getProcessGroupDefineList() {
		return processGroupDefineList;
	}

	/**
	 * processGroupDefineList   设定
	 * @param processGroupDefineList processGroupDefineList
	 */
	public void setProcessGroupDefineList(List<IG480Info> processGroupDefineList) {
		this.processGroupDefineList = processGroupDefineList;
	}

	
	
	
}
