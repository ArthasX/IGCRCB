/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程选择VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDWP01041VO extends BaseVO{

	/** 流程定义信息 */
	protected Map<IG259Info, List<IG380Info>> processDefinitionMap;

	/**
	 * 流程定义信息取得
	 * @return processDefinitionMap 流程定义信息
	 */
	public Map<IG259Info, List<IG380Info>> getProcessDefinitionMap() {
		return processDefinitionMap;
	}

	/**
	 * 流程定义信息设定
	 * @param processDefinitionMap 流程定义信息
	 */
	public void setProcessDefinitionMap(
			Map<IG259Info, List<IG380Info>> processDefinitionMap) {
		this.processDefinitionMap = processDefinitionMap;
	}
}
