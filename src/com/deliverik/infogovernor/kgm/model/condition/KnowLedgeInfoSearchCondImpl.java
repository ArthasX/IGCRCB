/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
 * 
 * @Description:知识库查询表Cond类
 * @Author
 * @History
 * @Version V1.0
 */
public class KnowLedgeInfoSearchCondImpl implements KnowLedgeInfoSearchCond {
	/**
	 *知识库分类
	 */
	protected String knclass;

	/**
	 *知识库分类取得
	 * 
	 * @return 知识库分类
	 */
	public String getKnclass() {
		return knclass;
	}

	/**
	 *知识库分类设定
	 * 
	 * @param knclass知识库分类
	 */
	public void setKnclass(String knclass) {
		this.knclass = knclass;
	}

	/**
	 *关键字
	 */
	protected String knkey;

	/**
	 *关键字取得
	 * 
	 * @return 关键字
	 */
	public String getKnkey() {
		return knkey;
	}

	/**
	 *关键字设定
	 * 
	 * @param knkey关键字
	 */
	public void setKnkey(String knkey) {
		this.knkey = knkey;
	}

	/**
	 *知识标题
	 */
	protected String kntitle;

	/**
	 *知识标题取得
	 * 
	 * @return 知识标题
	 */
	public String getKntitle() {
		return kntitle;
	}

	/**
	 *知识标题设定
	 * 
	 * @param kntitle知识标题
	 */
	public void setKntitle(String kntitle) {
		this.kntitle = kntitle;
	}

	/**
	 *事件
	 */
	protected String knapprovetime;

	/**
	 *事件取得
	 * 
	 * @return 事件
	 */
	public String getKnapprovetime() {
		return knapprovetime;
	}

	/**
	 *事件设定
	 * 
	 * @param knapprovetime事件
	 */
	public void setKnapprovetime(String knapprovetime) {
		this.knapprovetime = knapprovetime;
	}

	/**
	 *总评分
	 */
	protected Integer grade;

	/**
	 *总评分取得
	 * 
	 * @return 总评分
	 */
	public Integer getGrade() {
		return grade;
	}

	/**
	 *总评分设定
	 * 
	 * @param grade总评分
	 */
	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	/**
	 *交易码
	 */
	protected String kndealno;

	/**
	 *交易码取得
	 * 
	 * @return 交易码
	 */
	public String getKndealno() {
		return kndealno;
	}

	/**
	 *交易码设定
	 * 
	 * @param kndealno交易码
	 */
	public void setKndealno(String kndealno) {
		this.kndealno = kndealno;
	}

	/**
	 *错误码
	 */
	protected String knerrno;

	/**
	 *错误码取得
	 * 
	 * @return 错误码
	 */
	public String getKnerrno() {
		return knerrno;
	}

	/**
	 *错误码设定
	 * 
	 * @param knerrno错误码
	 */
	public void setKnerrno(String knerrno) {
		this.knerrno = knerrno;
	}
}
