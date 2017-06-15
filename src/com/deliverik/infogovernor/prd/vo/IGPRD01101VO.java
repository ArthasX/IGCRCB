/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG202Info;

/**
 * 表单信息信息检索结果ＶＯ
 * 
 * @author liupeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGPRD01101VO extends BaseVO implements Serializable{
	
	/** 表单信息信息检索结果 */
	protected List<IG007Info> processInfoDefList;
	protected List<IG202Info> processInfoDefGeneralList;
	/** 表单定义信息 */
	protected IG007Info processInfoDef;
	
	/**
	 * 构造函数
	 * @param processInfoDef　表单信息信息检索结果
	 */
	public IGPRD01101VO(List<IG007Info> processInfoDefList) {
		this.processInfoDefList = processInfoDefList;
	}
	public IGPRD01101VO() {
	}
	
	/**
	 * 表单信息信息检索结果取得
	 * @return 表单信息信息检索结果
	 */
	public List<IG007Info> getProcessInfoDefList() {
		return processInfoDefList;
	}

	public List<IG202Info> getProcessInfoDefGeneralList() {
		return processInfoDefGeneralList;
	}
	public void setProcessInfoDefGeneralList(
			List<IG202Info> processInfoDefGeneralList) {
		this.processInfoDefGeneralList = processInfoDefGeneralList;
	}
	/**
	 * 表单定义信息取得
	 * @return processInfoDef 表单定义信息
	 */
	public IG007Info getProcessInfoDef() {
		return processInfoDef;
	}
	/**
	 * 表单定义信息设定
	 * @param processInfoDef 表单定义信息
	 */
	public void setProcessInfoDef(IG007Info processInfoDef) {
		this.processInfoDef = processInfoDef;
	}
	
}


