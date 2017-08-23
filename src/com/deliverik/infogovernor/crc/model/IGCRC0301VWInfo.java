/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.model;

import java.io.Serializable;

public interface IGCRC0301VWInfo extends Serializable {

	public Integer getPrid();
	
	public String getPrtype();
	
	public String getPrserialnum();
	
	public String getPrtitle() ;
	
	public String getPrusername();
	
	public String getPropentime();
	
	public String getPrclosetime();
	
	public String getPrstatus();
	
	public String getPrsubstatus();
	
	public String getPrpdid();
	
	public String getPbcontent();
	
	public String getOrderstatus();
	
	public String getAfterplan();
	
	public String getPlanstime();
	public String getDutypersion();
	
	public String getPsdid() ;
}
