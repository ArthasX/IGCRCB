/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.vo;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程数量统计操作开始
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSVC06421VO extends BaseVO{

	/** 事件总数 */
	protected Integer countI = 0;
	
	/** 事件未关闭数量 */
	protected Integer countI_E = 0;
	
	/** 事件已关闭数量 */
	protected Integer countI_C = 0;
	
	/** 问题总数 */
	protected Integer countP = 0;
	
	/** 问题未关闭数量 */
	protected Integer countP_E = 0;
	
	/** 问题已关闭数量 */
	protected Integer countP_C = 0;
	
	/** 变更总数 */
	protected Integer countC = 0;
	
	/** 变更未关闭数量 */
	protected Integer countC_E = 0;
	
	/** 变更已关闭数量 */
	protected Integer countC_C = 0;

	/**
	 * 事件总数取得
	 * @return countI 事件总数
	 */
	public Integer getCountI() {
		return countI;
	}

	/**
	 * 事件总数设定
	 * @param countI 事件总数
	 */
	public void setCountI(Integer countI) {
		this.countI = countI;
	}

	/**
	 * 事件未关闭数量取得
	 * @return countI_E 事件未关闭数量
	 */
	public Integer getCountI_E() {
		return countI_E;
	}

	/**
	 * 事件未关闭数量设定
	 * @param countI_E 事件未关闭数量
	 */
	public void setCountI_E(Integer countI_E) {
		this.countI_E = countI_E;
	}

	/**
	 * 事件已关闭数量取得
	 * @return countI_C 事件已关闭数量
	 */
	public Integer getCountI_C() {
		return countI_C;
	}

	/**
	 * 事件已关闭数量设定
	 * @param countI_C 事件已关闭数量
	 */
	public void setCountI_C(Integer countI_C) {
		this.countI_C = countI_C;
	}

	/**
	 * 问题总数取得
	 * @return countP 问题总数
	 */
	public Integer getCountP() {
		return countP;
	}

	/**
	 * 问题总数设定
	 * @param countP 问题总数
	 */
	public void setCountP(Integer countP) {
		this.countP = countP;
	}

	/**
	 * 问题未关闭数量取得
	 * @return countP_E 问题未关闭数量
	 */
	public Integer getCountP_E() {
		return countP_E;
	}

	/**
	 * 问题未关闭数量设定
	 * @param countP_E 问题未关闭数量
	 */
	public void setCountP_E(Integer countP_E) {
		this.countP_E = countP_E;
	}

	/**
	 * 问题已关闭数量取得
	 * @return countP_C 问题已关闭数量
	 */
	public Integer getCountP_C() {
		return countP_C;
	}

	/**
	 * 问题已关闭数量设定
	 * @param countP_C 问题已关闭数量
	 */
	public void setCountP_C(Integer countP_C) {
		this.countP_C = countP_C;
	}

	/**
	 * 变更总数取得
	 * @return countC 变更总数
	 */
	public Integer getCountC() {
		return countC;
	}

	/**
	 * 变更总数设定
	 * @param countC 变更总数
	 */
	public void setCountC(Integer countC) {
		this.countC = countC;
	}

	/**
	 * 变更未关闭数量取得
	 * @return countC_E 变更未关闭数量
	 */
	public Integer getCountC_E() {
		return countC_E;
	}

	/**
	 * 变更未关闭数量设定
	 * @param countC_E 变更未关闭数量
	 */
	public void setCountC_E(Integer countC_E) {
		this.countC_E = countC_E;
	}

	/**
	 * 变更已关闭数量取得
	 * @return countC_C 变更已关闭数量
	 */
	public Integer getCountC_C() {
		return countC_C;
	}

	/**
	 * 变更已关闭数量设定
	 * @param countC_C 变更已关闭数量
	 */
	public void setCountC_C(Integer countC_C) {
		this.countC_C = countC_C;
	}
}
