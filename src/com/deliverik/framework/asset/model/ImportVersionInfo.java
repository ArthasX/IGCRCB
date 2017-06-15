/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.asset.model.entity.EiImportProgrammeTB;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 导入数据版本管理表接口
  * 功能描述: 导入数据版本管理表接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface ImportVersionInfo extends BaseModel {

	/**
	 * 导入实体ID取得
	 *
	 * @return 导入实体ID
	 */
	public Integer getImpeiid();

	/**
	 * 导入版本取得
	 *
	 * @return 导入版本
	 */
	public Integer getImpversion();

	/**
	 * 实体名取得
	 *
	 * @return 实体名
	 */
	public String getImpeiname();

	/**
	 * 导入文件名取得
	 *
	 * @return 导入文件名
	 */
	public String getImpfilename();

	/**
	 * 导入时间取得
	 *
	 * @return 导入时间
	 */
	public String getImpcreatetime();
	
	
	/** 
	 * 资产模型层次码获取
	 * 
	 */
	public String getEsyscoding();
	
	/**
	 * 逻辑删除标识取得
	 *
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag();
	/**
	 * 顶级CI类型
	 * @return 顶级CI类型
	 */
	public Integer getImpcitype();
	
	/**
	 * 导入对象类型信息取得
	 * @return 导入对象类型信息
	 */
	public EiImportProgrammeTB getEiImportProgrammeTB();
	
	/**
	 * IP取得
	 * 
	 * @return IP
	 */
	public String getImpip();

	/**
	 * 用户名取得
	 * 
	 * @return 用户名
	 */
	public String getImpuserid();

	/**
	 * 密码取得
	 * 
	 * @return 密码
	 */
	public String getImppassword();

	/**
	 * 状态取得
	 * 
	 * @return 状态
	 */
	public String getImpstatus();
	
	public IG013TB getEntityItemTB();
	
	/**获取链路图数量*/
	public Integer getEircount();
	
	/**获取所属数量*/
	public Integer getBelongcount();
}