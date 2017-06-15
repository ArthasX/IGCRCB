/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
 * 
 * @Description:知识业务系统关联Cond类
 * @Author
 * @History
 * @Version V1.0
 */
public class KnowledgeAppImpactSearchCondImpl implements KnowledgeAppImpactSearchCond {
	/**
	 *知识ID
	 */
	protected Integer knid;

	/**
	 *知识ID取得
	 * 
	 * @return 知识ID
	 */
	public Integer getKnid() {
		return knid;
	}

	/**
	 *知识ID设定
	 * 
	 * @param knid知识ID
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}

	/**
	 *业务系统Code
	 */
	protected String kaicode;

	/**
	 *业务系统Code取得
	 * 
	 * @return 业务系统Code
	 */
	public String getKaicode() {
		return kaicode;
	}

	/**
	 *业务系统Code设定
	 * 
	 * @param kaicode业务系统Code
	 */
	public void setKaicode(String kaicode) {
		this.kaicode = kaicode;
	}

	/**
	 * 知识版本
	 */
	protected Integer knversion;

	/**
	 * 知识版本取得
	 * @return 知识版本
	 */
	public Integer getKnversion() {
		return knversion;
	}

	/**
	 * 知识版本设定
	 * @param knversion 知识版本
	 */
	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}
}
