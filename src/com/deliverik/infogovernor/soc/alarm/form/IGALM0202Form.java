/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.alarm.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.soc.alarm.model.CRM08Info;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM07TB;

/**
 * ����ģ�����Form
 * @author zhangnan
 * 2013.08.01
 */
@SuppressWarnings("serial")
public class IGALM0202Form extends BaseForm implements CRM08Info {
	
	/** ģ������ */
	protected String ruletempname_like;
	
	/** ģ��״̬ */
	protected Integer tempstate;
	
	/** ģ��״̬ */
	protected Integer tempstate_eq;
	
	/** ģ������ccid */
	protected String typeccid;
	
	/** ģ������cid */
	protected String typecid;
	
	/** ɾ��ģ�����id���� */
	protected String[] deleteId;
	
	/** ����ģ������ */
	protected Integer ruletempid;

	public Integer getTempstate() {
		return tempstate;
	}

	public void setTempstate(Integer tempstate) {
		this.tempstate = tempstate;
	}

	public String[] getDeleteId() {
		return deleteId;
	}

	public void setDeleteId(String[] deleteId) {
		this.deleteId = deleteId;
	}

	public Integer getAlarmlevel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCategoryccid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCategorycid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCreatetime() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getRulecondition() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CRM07TB> getCrm07TBList() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTypeccid() {
		return typeccid;
	}

	public void setTypeccid(String typeccid) {
		this.typeccid = typeccid;
	}

	public String getTypecid() {
		return typecid;
	}

	public void setTypecid(String typecid) {
		this.typecid = typecid;
	}

	public Integer getRuletempid() {
		return ruletempid;
	}

	public void setRuletempid(Integer ruletempid) {
		this.ruletempid = ruletempid;
	}

	public Integer getTempstate_eq() {
		return tempstate_eq;
	}

	public void setTempstate_eq(Integer tempstate_eq) {
		this.tempstate_eq = tempstate_eq;
	}

	public String getRuletempname_like() {
		return ruletempname_like;
	}

	public void setRuletempname_like(String ruletempname_like) {
		this.ruletempname_like = ruletempname_like;
	}

	public String getRuletempname() {
		// TODO Auto-generated method stub
		return null;
	}

}
