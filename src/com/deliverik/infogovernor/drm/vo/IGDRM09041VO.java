/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_变更管理_查询VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGDRM09041VO extends BaseVO implements Serializable {

	public IGDRM09041VO() {

	}

	public IGDRM09041VO(List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

	protected List<IG380Info> processDefinitionList;

	/**
	 * processDefinitionList 取得
	 * 
	 * @return processDefinitionList processDefinitionList
	 */
	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	/**
	 * processDefinitionList 设定
	 * 
	 * @param processDefinitionList
	 *            processDefinitionList
	 */
	public void setProcessDefinitionList(List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

}
