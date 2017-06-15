/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */

package com.deliverik.infogovernor.com.model;


/**
 * 处理中工作接口
 * 
 */
public interface ProcessInHandVWInfo {
	public Integer getPrid();
	
	/**
	 * 发起人姓名取得
	 * @return prusername 发起人姓名
	 */
	public String getPrusername();

	public String getPrurgency() ;

	public String getPrserialnum() ;

	public String getPrtype() ;

	public String getPropentime();
	
	/**
	 * 关闭时间取得
	 * @return prclosetime 关闭时间
	 */
	public String getPrclosetime();

	public String getPpusername() ;

	public String getPrstatus();
	
	/**
	 * 处理角色名称取得
	 * @return pprolename 处理角色名称
	 */
	public String getPprolename();
	
	public String getPrtitle() ;

	public String getPrpdid();

	public String getPrpdname() ;
	
	public Integer getPrstrategyversion();
	
	public String getShowtype();
	
	public String getShowtitle();

	public String getPrrolename() ;
	
	public String getShowrolename() ;

	public String getShowpdname() ;

	public String getShowimg() ;
	
	public String getShowurl() ;
	
	public Integer getRid() ;

	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid();
	
	/**
	 * 流程状态取得
	 * @return orderstatus  流程状态
	 */
	public String getOrderstatus();
	
}