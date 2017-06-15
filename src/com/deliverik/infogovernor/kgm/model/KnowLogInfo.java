/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: knowLog接口
  * 功能描述: knowLog接口
  * 创建记录: 2011/05/30
  * 修改记录: 
  */
public interface KnowLogInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getKlid();

	/**
	 * 知识ID取得
	 *
	 * @return 知识ID
	 */
	public Integer getKlkid();

	/**
	 * 创建时间取得
	 *
	 * @return 创建时间
	 */
	public String getKltime();

	/**
	 * 创建日志角色ID取得
	 *
	 * @return 创建日志角色ID
	 */
	public String getKlroleid();

	/**
	 * 创建日子角色名字取得
	 *
	 * @return 创建日子角色名字
	 */
	public String getKlrolename();

	/**
	 * 用户ID取得
	 *
	 * @return 用户ID
	 */
	public String getKluserid();

	/**
	 * 用户名称取得
	 *
	 * @return 用户名称
	 */
	public String getKlusername();

	/**
	 * 日志描述取得
	 *
	 * @return 日志描述
	 */
	public String getKldesc();

	/**
	 * 备注信息取得
	 *
	 * @return 备注信息
	 */
	public String getKlcommend();

	/**
	 * 机构ID取得
	 *
	 * @return 机构ID
	 */
	public String getKlorgid();

	/**
	 * 机构名词取得
	 *
	 * @return 机构名词
	 */
	public String getKlorgname();

}