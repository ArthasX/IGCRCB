/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * 接待管理实体接口
 *
 */
public interface ItemsCodesSt extends BaseModel {

	public Integer getIcid();
	public String getSelectid();
	public String getSelectname();
	public String getTypecode();
	public String getTypename();
	public String getType();
	public String getDesc();
	public String getStatus();

}
