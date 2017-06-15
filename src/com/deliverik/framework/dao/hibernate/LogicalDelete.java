package com.deliverik.framework.dao.hibernate;

/**
 * 逻辑删除实体接口
 * 
 * @author SQS Yoshinaga
 */
public interface LogicalDelete {

	/**
	 * 逻辑删除标识取得
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag();

	/**
	 * 逻辑删除标识设定
	 * @param deleteflag 逻辑删除标识
	 */
	public void setDeleteflag(String deleteflag);

}
