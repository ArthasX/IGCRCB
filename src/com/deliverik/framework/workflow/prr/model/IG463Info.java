/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * 授权工作管理接口
 * 
 * 
 */

public interface IG463Info extends BaseModel {
	/**
	 * 授权工作ID取得
	 * 
	 * @return 授权工作ID
	 */
	public Integer getPpwid();
	
	
	/**
	 * 流程id取得
	 * 
	 * @return 流程id
	 */
	public Integer getPpwprid();
	
	
	/**
	 * 流程类型取得
	 * 
	 * @return 流程类型
	 */
	public String getPpwprtype();
	

	/**
	 * 流程编号取得
	 * 
	 * @return 流程编号
	 */
	public String getPpwprserialnum();
	
	
	/**
	 * 流程标题取得
	 * 
	 * @return 流程标题
	 */
	public String getPpwprtitle();
	
	/**
	 * 授权人id取得
	 * 
	 * @return 授权人id
	 */
	public String getPpwauthorizeuserid();
	
	/**
	 * 代理人id取得
	 * 
	 * @return 代理人id
	 */
	public String getPpwproxyuserid();
	
	/**
	 * 代理人姓名取得
	 * 
	 * @return 代理人姓名
	 */
	public String getPpwproxyusername();
	
	
	/**
	 * 代理人处理时间取得
	 * 
	 * @return 代理人处理时间
	 */
	public String getPpwoptiontime();
	
	
	/**
	 * 关闭标志取得
	 * 
	 * @return 关闭标志
	 */
	public String getPpwcloseflag();
	
}