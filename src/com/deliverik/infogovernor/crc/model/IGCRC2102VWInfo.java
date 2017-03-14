/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.model;

import com.deliverik.framework.base.BaseModel;

/**	
 * 概述:部门下拉框值接口
 * 创建记录：yukexin    2014-8-15 下午3:29:28	
 * 修改记录：null
 */	
public interface IGCRC2102VWInfo extends BaseModel{
	/**
	 * 主键取得
	 * @return id  主键
	 */
	public String getId();
	/**
	 * 名称设定
	 * @param label  名称
	 */
	public String getLabel();
	/**
	 * 值取得
	 * @return value  值
	 */
	public String getValue();
}
