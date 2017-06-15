/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG413Info;

/**
 * 前后处理tianjia信息检索结果ＶＯ
 * 
 * @author liupeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGPRD01062VO extends BaseVO implements Serializable{
	
	/** 表单信息信息检索结果 */
	protected List<IG007Info> processInfoDefList;
	
	/** 前后处理检索结果 */
	protected List<IG413Info> processEventDefList;
	
	
	public List<IG413Info> getProcessEventDefList() {
		return processEventDefList;
	}

	public void setProcessEventDefList(List<IG413Info> processEventDefList) {
		this.processEventDefList = processEventDefList;
	}

	/**下拉列表信息*/
	protected Map<Integer,String[]> optionMap;
	
	public Map<Integer, String[]> getOptionMap() {
		return optionMap;
	}

	public void setOptionMap(Map<Integer, String[]> optionMap) {
		this.optionMap = optionMap;
	}
	/**
	 * 构造函数
	 * @param processInfoDef　表单信息信息检索结果
	 */
	public IGPRD01062VO(List<IG413Info> processEventDefList) {
		this.processEventDefList = processEventDefList;
	}
	
	/**
	 * 表单信息信息检索结果取得
	 * @return 表单信息信息检索结果
	 */
	public List<IG007Info> getProcessInfoDefList() {
		return processInfoDefList;
	}
}


