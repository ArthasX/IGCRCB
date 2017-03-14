/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
 * 代理工作查询接口
 */
public interface IG463SearchCond {
	/**
	 * 授权人ID取得
	 * 
	 * @return 授权人ID
	 */
	public String getPpwauthorizeuserid();
	
	/**
	 * 代理人姓名取得
	 * 
	 * @return 代理人姓名
	 */
	public String getPpwproxyusername();
	
	/**
	 * 代理人处理时间 到取得
	 * 
	 * @return 代理人处理时间 到
	 */
	public String getPpwoptiontime_t();
	
	/**
	 * 代理人处理时间 从取得
	 * 
	 * @return 代理人处理时间 从
	 */
	public String getPpwoptiontime_f();
	
	/**
	 * 关闭标识取得
	 * 
	 * @return 关闭标识
	 */
	public String getPpwcloseflag();
	/**
	 * 流程id取得
	 * 
	 * @return 流程id
	 */
	public Integer getPpwprid();
	
	/**
	 * 代理人id取得
	 * 
	 * @return 代理人id
	 */
	public String getPpwproxyuserid();
	
	/**
	 * 流程编号取得
	 * 
	 * @return 流程编号
	 */
	public String getPpwprserialnum();
}
