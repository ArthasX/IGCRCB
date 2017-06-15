/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 概述: 文档查询表接口
 * 功能描述: 文档查询表接口
 * 创建记录: 2014/07/15
 * 修改记录: 
 */
public interface IGCRC1301VWInfo extends BaseModel {
	/**
	 * 文档编号取得
	 * @return eiNumber 文档编号
	 */
	public String getEiNumber();

	/**
	 * 文档名称取得
	 * @return eiName 文档名称
	 */
	public String getEiName();

	/**
	 * 文档类型取得
	 * @return eiType 文档类型
	 */
	public String getEiType();

	/**
	 * 文档分类取得
	 * @return eiSort 文档分类
	 */
	public String getEiSort();

	/**
	 * 文档密级取得
	 * @return eiDense 文档密级
	 */
	public String getEiDense();

	/**
	 * 部门取得
	 * @return department 部门
	 */
	public String getDepartment();

	/**
	 * 管理人取得
	 * @return managermentPerson 管理人
	 */
	public String getManagermentPerson();

	/**
	 * 内容取得
	 * @return content 内容
	 */
	public String getContent();
	
	/**
	 * 存储方式取得
	 * @return storageWay 存储方式
	 */
	public String getStorageWay();

	/**
	 * 存放位置取得
	 * @return storageLocation 存放位置
	 */
	public String getStorageLocation();
	
	/**
	 * 发起人取得
	 * @return userName 发起人
	 */
	public String getUserName();
	
	/**
	 * eiid取得
	 * @return eiid eiid
	 */
	public String getEiid();
	
	/**
	 * eid取得
	 * @return eid eid
	 */
	public String getEid();

	/**
	 * eLabel取得
	 * @return eLabel eLabel
	 */
	public String geteLabel();

	/**
	 * eiLabel取得
	 * @return eiLabel eiLabel
	 */
	public String getEiLabel();

	/**
	 * eCategory取得
	 * @return eCategory eCategory
	 */
	public String geteCategory();

	/**
	 * 版本号取得
	 * @return eiVersion 版本号
	 */
	public String getEiVersion();
	
	/**
	 * eName取得
	 * @return eName eName
	 */
	public String geteName();
	
	/**
	 * 是否可下载取得
	 * @return isDownload 是否可下载
	 */
	public String getIsDownload();
}
