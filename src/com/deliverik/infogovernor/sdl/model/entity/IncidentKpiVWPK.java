package com.deliverik.infogovernor.sdl.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * 服务管理_统计汇总_事件kpi信息主键定义
 *
 * @author 
 */
@SuppressWarnings("serial")
public class IncidentKpiVWPK extends BasePK implements Serializable{

	/**紧急程度*/
	protected String urgency;
	
	/**类别层次码*/
	protected String syscoding;

	/**
	 * 构造函数
	 * 
	 */
	public IncidentKpiVWPK(){}
	
	/**
	 * 构造函数
	 * 
	 */
	public IncidentKpiVWPK(String urgency, String syscoding) {
		super();
		this.urgency = urgency;
		this.syscoding = syscoding;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	public String getSyscoding() {
		return syscoding;
	}

	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

}
