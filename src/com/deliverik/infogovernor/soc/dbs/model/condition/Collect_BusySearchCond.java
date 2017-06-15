/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.soc.dbs.model.condition;


/**
 * 
 * @Description: 前端端口使用率信息Cond接口
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_BusySearchCond{
	
	public String getDate_from();

	public String getDate_to();
	
	public String getDataid();
	
	public String getFlag();
	
	public String getSymm_model();
}

