/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG001Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:OA角色配置初始化显示vo 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR03011VO extends BaseVO{
	
	/** 负责人角色信息集合 */
	protected List<IG001Info> ig001List_A;
	
	/** 值班人角色信息集合 */
	protected List<IG001Info> ig001List_B;
	
	/** 执行人角色信息集合 */
	protected List<IG001Info> ig001List_C;

	/**
	 * 负责人角色信息集合取得
	 * @return 负责人角色信息集合
	 */
	public final List<IG001Info> getIg001List_A() {
		return ig001List_A;
	}

	/**
	 * 负责人角色信息集合设定
	 * @param ig001List_A 负责人角色信息集合
	 */
	public final void setIg001List_A(List<IG001Info> ig001List_A) {
		this.ig001List_A = ig001List_A;
	}

	/**
	 * 值班人角色信息结合取得
	 * @return 值班人角色信息集合
	 */
	public final List<IG001Info> getIg001List_B() {
		return ig001List_B;
	}

	/**
	 * 值班人角色信息集合设定
	 * @param ig001List_B 值班人角色信息集合
	 */
	public final void setIg001List_B(List<IG001Info> ig001List_B) {
		this.ig001List_B = ig001List_B;
	}

	/**
	 * 执行人角色信息集合取得
	 * @return 执行人角色信息集合
	 */
	public final List<IG001Info> getIg001List_C() {
		return ig001List_C;
	}

	/**
	 * 执行人角色信息集合设定
	 * @param ig001List_C 执行人角色信息集合
	 */
	public final void setIg001List_C(List<IG001Info> ig001List_C) {
		this.ig001List_C = ig001List_C;
	}
	

}
