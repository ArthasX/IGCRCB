/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.parameter;

import org.apache.struts.upload.FormFile;

/**
 * 资产属性信息
 */
public interface EntityItemConfigValueInfo {
	
	/**
	 * 资产ID取得
	 * 
	 * @return 资产ID
	 */
	public Integer getEiid();

	/**
	 * 资产属性名称取得
	 * 
	 * @return 资产属性名称
	 */
	public String getName();
	
	/**
	 * 资产属性值取得
	 * 
	 * @return 资产属性值
	 */
	public String getValue();

	/**
	 * 附件信息取得
	 * @return file 附件信息
	 */
	public FormFile getFile();
}
