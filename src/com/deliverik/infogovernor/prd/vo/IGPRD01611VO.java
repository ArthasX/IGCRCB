/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG992Info;

/**
 * 外部事件tianjia信息检索结果ＶＯ
 * 
 * @author liupeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGPRD01611VO extends BaseVO implements Serializable{
	
	/**
	 * 构造函数
	 * @param processInfoDef　表单信息信息检索结果
	 */
	public IGPRD01611VO(List<IG992Info> processExternalDefList) {
		this.ProcessExternalDefList = processExternalDefList;
	}
	
	protected List<IG992Info> ProcessExternalDefList;

	public List<IG992Info> getProcessExternalDefList() {
		return ProcessExternalDefList;
	}

	public void setProcessEventDefList(
			List<IG992Info> ProcessEventDefList) {
		this.ProcessExternalDefList = ProcessEventDefList;
	}
	
}


