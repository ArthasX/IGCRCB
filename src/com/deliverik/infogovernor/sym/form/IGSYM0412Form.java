/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sym.model.condition.ReportFileVersionSearchCond;

/**
 * 报表版本信息查询Form
 * 
 */
@SuppressWarnings("serial")
public class IGSYM0412Form extends BaseForm implements ReportFileVersionSearchCond {

	/** 报表主键 */
	protected Integer rfdid;
	
	/** 版本主键 */
	protected Integer rfvid;
	
	/**
	 * 报表主键取得
	 * @return 报表主键
	 */
	public Integer getRfdid() {
		return rfdid;
	}
	
	/**
	 * 报表主键设定
	 * @param rfdid 报表主键
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}
	
	/**
	 * 版本主键取得
	 * @return 版本主键
	 */
	public Integer getRfvid() {
		return rfvid;
	}
	
	/**
	 * 版本主键设定
	 * @param rfvid 版本主键
	 */
	public void setRfvid(Integer rfvid) {
		this.rfvid = rfvid;
	}
	
}
