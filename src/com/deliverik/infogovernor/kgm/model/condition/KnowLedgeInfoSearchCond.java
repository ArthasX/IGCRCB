/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
 * 
 * @Description:知识库查询表Cond接口
 * @Author
 * @History
 * @Version V1.0
 */
public interface KnowLedgeInfoSearchCond {
	/**
	 *知识库分类
	 */
	public String getKnclass();

	/**
	 *关键字
	 */
	public String getKnkey();

	/**
	 *知识标题
	 */
	public String getKntitle();

	/**
	 *事件
	 */
	public String getKnapprovetime();

	/**
	 *总评分
	 */
	public Integer getGrade();

	/**
	 *交易码
	 */
	public String getKndealno();

	/**
	 *错误码
	 */
	public String getKnerrno();

}
