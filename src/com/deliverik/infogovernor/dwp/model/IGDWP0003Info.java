/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划表单信息实体接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGDWP0003Info extends BaseModel{
	
	/**
	 * 主键取得
	 * @return id 主键
	 */
	public Integer getId();

	/**
	 * 流程信息主键取得
	 * @return prid 流程信息主键
	 */
	public Integer getPrid();

	/**
	 * 表单定义ID取得
	 * @return pidid 表单定义ID
	 */
	public String getPidid();

	/**
	 * 表单值取得
	 * @return pivarvalue 表单值
	 */
	public String getPivarvalue();

	/**
	 * 附件key取得
	 * @return attkey 附件key
	 */
	public String getAttkey();
}
