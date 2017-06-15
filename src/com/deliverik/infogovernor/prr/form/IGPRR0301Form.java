/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 自定义流程OA模式对应角色全局配置Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR0301Form extends BaseForm{
	
	/** 删除标识 A 负责人；B 值班人；C 执行人 */
	protected String deleteFlag;
	
	/** 负责人配置信息主键集合 */
	protected Integer[] proids_A;
	
	/** 值班人配置信息主键 */
	protected Integer[] proids_B;
	
	/** 执行人配置信息主键集合 */
	protected Integer[] proids_C;

	/**
	 * 删除标识取得
	 * @return 删除标识
	 */
	public final String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * 删除标识设定
	 * @param deleteFlag 删除标识
	 */
	public final void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * 负责人配置信息主键集合取得
	 * @return 负责人配置信息主键集合
	 */
	public final Integer[] getProids_A() {
		return proids_A;
	}

	/**
	 * 负责人配置信息主键集合设定
	 * @param proids_A 负责人配置信息主键集合
	 */
	public final void setProids_A(Integer[] proids_A) {
		this.proids_A = proids_A;
	}

	/**
	 * 值班人配置信息主键集合取得
	 * @return 值班人配置信息主键
	 */
	public final Integer[] getProids_B() {
		return proids_B;
	}

	/**
	 * 值班人配置信息主键集合设定
	 * @param proids_B 值班人配置信息主键集合
	 */
	public final void setProids_B(Integer[] proids_B) {
		this.proids_B = proids_B;
	}

	/**
	 * 执行人配置信息主键集合取得
	 * @return 执行人配置信息主键集合
	 */
	public final Integer[] getProids_C() {
		return proids_C;
	}

	/**
	 * 执行人配置信息主键集合设定
	 * @param proids_C 执行人配置信息主键集合
	 */
	public final void setProids_C(Integer[] proids_C) {
		this.proids_C = proids_C;
	}
	
}
