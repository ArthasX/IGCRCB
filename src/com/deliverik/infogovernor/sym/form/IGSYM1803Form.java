/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sym.model.MSGFILTERInfo;
import com.deliverik.infogovernor.sym.model.condition.MSGFILTERSearchCond;


@SuppressWarnings("serial")
public class IGSYM1803Form extends BaseForm implements MSGFILTERSearchCond,MSGFILTERInfo{
	
	protected Integer []ids;

	/** deviceip */
	protected String deviceip;

	/** state */
	protected String state;

	

	protected Integer id;
	
	protected String isflag="no";

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer[] getIds() {
		return ids;
	}


	public void setIds(Integer[] ids) {
		this.ids = ids;
	}


	public Integer getId() {
		return id;
	}


	public String getDeviceip() {
		return deviceip;
	}

	public void setDeviceip(String deviceip) {
		this.deviceip = deviceip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getIsflag() {
		return isflag;
	}


	public void setIsflag(String isflag) {
		this.isflag = isflag;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
