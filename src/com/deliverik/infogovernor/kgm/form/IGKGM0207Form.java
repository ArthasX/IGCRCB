/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.kgm.model.KnowledgeGrade;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeGradeSearchCond;


/**
 * 概述: 知识评分查询接口
 * 功能描述：知识评分查询接口
 * 创建记录：wangxiaoqiang 2010/12/07
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGKGM0207Form extends BaseForm implements KnowledgeGradeSearchCond,KnowledgeGrade{
	/**
	 *知识表key
	 */
	protected Integer knid;

	/**
	 *知识表key取得
	 * 
	 * @return 知识表key
	 */
	public Integer getKnid() {
		return knid;
	}

	/**
	 *知识表key设定
	 * 
	 * @param kgknid知识表key
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}

	/**
	 *评分
	 */
	protected Integer kggrade;

	/**
	 *评分取得
	 * 
	 * @return 评分
	 */
	public Integer getKggrade() {
		return kggrade;
	}

	/**
	 *评分设定
	 * 
	 * @param kggrade评分
	 */
	public void setKggrade(Integer kggrade) {
		this.kggrade = kggrade;
	}

	/**
	 *知识的评价
	 */
	protected String kgappraise;

	/**
	 *知识的评价取得
	 * 
	 * @return 知识的评价
	 */
	public String getKgappraise() {
		return kgappraise;
	}

	/**
	 *知识的评价设定
	 * 
	 * @param kgappraise知识的评价
	 */
	public void setKgappraise(String kgappraise) {
		this.kgappraise = kgappraise;
	}

	/**
	 *评分人
	 */
	protected String kguserid;

	/**
	 *评分人取得
	 * 
	 * @return 评分人
	 */
	public String getKguserid() {
		return kguserid;
	}

	/**
	 *评分人设定
	 * 
	 * @param kguseid评分人
	 */
	public void setKguserid(String kguserid) {
		this.kguserid = kguserid;
	}

	/**
	 *评分时间
	 */
	protected String kgtime;

	/**
	 *评分时间取得
	 * 
	 * @return 评分时间
	 */
	public String getKgtime() {
		return kgtime;
	}

	/**
	 *评分时间设定
	 * 
	 * @param kgtime评分时间
	 */
	public void setKgtime(String kgtime) {
		this.kgtime = kgtime;
	}

	protected String fingerPrint;
	public Integer getKgid() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

}
