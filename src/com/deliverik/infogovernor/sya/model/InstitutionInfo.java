/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sya.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 制度汇编接口
  * 功能描述: 制度汇编接口
  * 创建记录: 2015-2-5 10:54:32
  * 修改记录: 
  */
public interface InstitutionInfo extends BaseModel {

	/**
	 * 主键取得
	 * @return inid  主键
	 */
	public Integer getInid();

	/**
	 * 制度名称取得
	 * @return inname  制度名称
	 */
	public String getInname();


	/**
	 * 制度描述取得
	 * @return indesc  制度描述
	 */
	public String getIndesc();

	/**
	 * 附件取得
	 * @return attkey  附件
	 */
	public String getAttkey();

	/**
	 * 登记人id取得
	 * @return inuserid  登记人id
	 */
	public String getInuserid();

	/**
	 * 登记人姓名取得
	 * @return inusername  登记人姓名
	 */
	public String getInusername();

	/**
	 * 登记人机构id取得
	 * @return inorgid  登记人机构id
	 */
	public String getInorgid();

	/**
	 * 登记人机构名称取得
	 * @return inorgname  登记人机构名称
	 */
	public String getInorgname();

	/**
	 * 创建时间取得
	 * @return createtime  创建时间
	 */
	public String getCreatetime();
	
	/**
	 * 制度分类取得
	 * @return intype  制度分类
	 */
	public String getIntype();
}