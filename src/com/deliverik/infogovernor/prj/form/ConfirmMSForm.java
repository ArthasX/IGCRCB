/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.prj.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.prj.model.ProjectPlan;

public class ConfirmMSForm extends BaseForm implements ProjectPlan {
	
	private static final long serialVersionUID = 1L;
	
	/** milestone编号 */
	private String[] index;
	
	/** milestone确认时间 */
	private String[] msConfirmDate;
	
	/** milestone确认描述 */
	private String[] msConfirmDesc;
	
	/** milestone对应的projectId */
	private Integer pid;

	public String[] getMsConfirmDate() {
		return msConfirmDate;
	}

	public void setMsConfirmDate(String[] msConfirmDate) {
		this.msConfirmDate = msConfirmDate;
	}

	public String[] getMsConfirmDesc() {
		return msConfirmDesc;
	}

	public void setMsConfirmDesc(String[] msConfirmDesc) {
		this.msConfirmDesc = msConfirmDesc;
	}
	
	public Integer getPid() {
		return pid;
	}

	public String getPpldate() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpldesc() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPplid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPplinfo() {
		
		StringBuilder pplInfoBulider = new StringBuilder();
		for (int i = 0; i < index.length; i++) {
//			pplInfoBulider.append(index[i]).append(":").append(status[i]).append(":").
//			append(msName[i]).append(":").append(msPlanDate[i])
//			.append(":").append(":").append(planDesc[i]).append(":").append(msConfirmDate[i]).append(":").append(msConfirmDesc[i]);
			if(msConfirmDesc[i].equals("")){
				msConfirmDesc[i]="N";
			}
			pplInfoBulider.append(index[i]).append(":").append(msConfirmDate[i]).append(":").append(msConfirmDesc[i]).append(";");
			
//			序号：状态(P/V)：名称：计划时间：计划说明：确认时间：确认说明；
		}
		return pplInfoBulider.toString();
	}

	public String getPplstatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPplversion() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String[] getIndex() {
		return index;
	}

	public void setIndex(String[] index) {
		this.index = index;
	}

	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public String getPpltitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPplclosetime() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPplriskatt() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPplopentime() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPplshuttime() {
		// TODO Auto-generated method stub
		return null;
	}

}
