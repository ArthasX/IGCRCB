/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.model;

import java.io.Serializable;

public interface EventAndProblemVWInfo extends Serializable{

	
	public String getId();
	
	
	public String getEventNum();
	
	public String getHappenTime();
	
	public String getIsClosed();
	
	public String getEventSource();
	
	public String getEventTitle();
	
	public String getEventType() ;
	
	public String getInvolveSystem();
	
	public String getInfluenceRange() ;
	
	public String getInfluenceRangeRemarks();
	
	public String getEventLevel() ;
	
	public String getEventCause() ;
	
	public String getEmergencySolution();
	
	public String getProblemNum();
	
	public String getPptimizationScheme() ;
	
	public String getPlannedSolutionTime();
	
	public String getPersonLiable();
	
	public String getEventusername();
	
	public String getEventstatus();
	
	public String getEventContent();
	
	public String getProblemTitle();
	
	public String getProblemopentime();
	
	public String getProblemusername();
	
	public String getProblemstatus();
	
	public String getProblemcontent();
	
}
