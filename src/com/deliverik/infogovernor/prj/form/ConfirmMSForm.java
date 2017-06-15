/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.prj.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.prj.model.ProjectPlan;

public class ConfirmMSForm extends BaseForm implements ProjectPlan {
	
	private static final long serialVersionUID = 1L;
	
	/** milestone��� */
	private String[] index;
	
	/** milestoneȷ��ʱ�� */
	private String[] msConfirmDate;
	
	/** milestoneȷ������ */
	private String[] msConfirmDesc;
	
	/** milestone��Ӧ��projectId */
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
			
//			��ţ�״̬(P/V)�����ƣ��ƻ�ʱ�䣺�ƻ�˵����ȷ��ʱ�䣺ȷ��˵����
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
