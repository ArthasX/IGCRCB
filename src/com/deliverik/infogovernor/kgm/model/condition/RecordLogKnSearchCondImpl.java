/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
 * @Description: ֪ʶ�����ѯ
 * @Author  
 * @History 2009-8-18     �½� 
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
