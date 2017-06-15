/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
 * 
 * @Description:知识评分Cond类
 * @Author
 * @History
 * @Version V1.0
 */
public class KnowledgeGradeSearchCondImpl implements KnowledgeGradeSearchCond {
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
}
