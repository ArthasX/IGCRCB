/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.sym.model;

/**
 * 
 * @Description:订制报表实体接口
 * @Author
 * @History
 * @Version V1.0
 */
public interface CustomReport {
	/**
	 *主键ID
	 */
	public Integer getCrid();

	/**
	 *用户名ID
	 */
	public String getUserid();

	/**
	 *报表ID
	 */
	public Integer getRfdid();

	/**
	 *排序编号
	 */
	public Integer getOrdernum();

}
