/**
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利
 */
package com.deliverik.infogovernor.rpt.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 概述: 
 * 功能描述: 
 * 创建记录: 
 * 修改记录: 
 */
public class CustomReportThread implements Runnable{
	static Log log = LogFactory.getLog(CustomReportThread.class);
	String ssn;
	String kpiName;
	String startDate;
	String endDate;
	
	public void run() {
		CustomBirtReportImport cbr=new CustomBirtReportImport();
		try {
			//cbr.runBirtReportImport(ssn,kpiName, startDate,endDate);
		} catch (Exception e) {
			log.error(e);
		}
	}
	public CustomReportThread(String ssn, String kpiName,String startDate, String endDate) {
		super();
		this.ssn = ssn;
		this.kpiName = kpiName;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
}
