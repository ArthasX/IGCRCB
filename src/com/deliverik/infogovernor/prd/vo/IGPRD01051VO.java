/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG233Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * 流程状态信息检索结果ＶＯ
 * 
 * @author liupeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGPRD01051VO extends BaseVO implements Serializable{
	
	/** 流程状态信息检索结果 */
	protected List<IG333Info> processStatusDefList;
	
	/** 分派节点信息集合 */
	protected List<IG233Info> apList;

	public List<IG333Info> getProcessStatusDefList() {
		return processStatusDefList;
	}

	public void setProcessStatusDefList(List<IG333Info> processStatusDefList) {
		this.processStatusDefList = processStatusDefList;
	}
	
	/**
	 * 分派节点信息集合取得
	 * @return 分派节点信息集合
	 */
	public List<IG233Info> getApList() {
		return apList;
	}

	/**
	 * 分派节点信息集合设定
	 * @param apList 分派节点信息集合
	 */
	public void setApList(List<IG233Info> apList) {
		this.apList = apList;
	}
}


