/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
 * @Description: 知识管理查询
 * @Author  
 * @History 2009-8-18     新建 
 * @Version V2.0
 */
public class RecordLogKnSearchCondImpl implements RecordLogKnSearchCond {

	protected Integer prkid;
	
	protected String rlkuserid;
	
	protected String rlkusername;
	
	protected String rlkcomment_q;
	
	

	public String getRlkcomment_q() {
		return rlkcomment_q;
	}

	public void setRlkcomment_q(String rlkcomment_q) {
		this.rlkcomment_q = rlkcomment_q;
	}

	public Integer getPrkid() {
		return prkid;
	}

	public String getRlkuserid() {
		return rlkuserid;
	}

	public String getRlkusername() {
		return rlkusername;
	}

	public void setPrkid(Integer prkid) {
		this.prkid = prkid;
	}

	public void setRlkuserid(String rlkuserid) {
		this.rlkuserid = rlkuserid;
	}

	public void setRlkusername(String rlkusername) {
		this.rlkusername = rlkusername;
	}

	
}
