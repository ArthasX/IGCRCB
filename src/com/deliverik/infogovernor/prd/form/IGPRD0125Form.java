/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.IG286Info;
import com.deliverik.framework.workflow.prd.model.condition.IG286SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;

/**
 * ���̶���_������Form
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0125Form extends BaseForm implements IG286Info,IG286SearchCond{
	
	protected String plid;
	/** ����id */
	protected String initiativepidid;
	/** ���������� */
	protected String initiativepidname;
	/** ����id */
	protected String passivitypidid;
	/** ���������� */
	protected String passivitypidname;
	/** �������� */
	protected String pldesc;
	
	/** bl���� */
	protected String plblname;
	
	/** js�¼����� */
	protected String pljsevent;
	/** ���������� */
	protected String pljtype;

	/** ���̶���id */
	protected String pldpdid;
	
	/**����ťid  */
	protected String pldactionid;
	
	/**����id */
	protected String pdid;

	/**�������� */
	protected String pdname;
	
	/**�������� */
	protected String pddesc;
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return plid;
	}
	
	/**
	 * ����ID
	 * @return ����ID
	 */
	public String getPlid() {
		return plid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param srid ����ID
	 */
	public void setPlid(String plid) {
		this.plid = plid;
	}

	/**
	 * ����id
	 * @return ����id
	 */
	public String getInitiativepidid() {
		return initiativepidid;
	}

	/**
	 * ����id�趨
	 *
	 * @param initiativepidid ����id
	 */
	public void setInitiativepidid(String initiativepidid) {
		this.initiativepidid = initiativepidid;
	}

	/**
	 * ����id
	 * @return ����id
	 */
	public String getPassivitypidid() {
		return passivitypidid;
	}

	/**
	 * ����id�趨
	 *
	 * @param passivitypidid ����id
	 */
	public void setPassivitypidid(String passivitypidid) {
		this.passivitypidid = passivitypidid;
	}

	/**
	 * ��������
	 * @return ��������
	 */
	public String getPldesc() {
		return pldesc;
	}

	/**
	 * ���������趨
	 *
	 * @param pldesc ��������
	 */
	public void setPldesc(String pldesc) {
		this.pldesc = pldesc;
	}

	/**
	 * bl����
	 * @return bl����
	 */
	public String getPlblname() {
		return plblname;
	}

	/**
	 * bl�����趨
	 *
	 * @param plblname bl����
	 */
	public void setPlblname(String plblname) {
		this.plblname = plblname;
	}

	/**
	 * js�¼�����
	 * @return js�¼�����
	 */
	public String getPljsevent() {
		return pljsevent;
	}

	/**
	 * js�¼������趨
	 *
	 * @param pljsevent js�¼�����
	 */
	public void setPljsevent(String pljsevent) {
		this.pljsevent = pljsevent;
	}

	/**
	 * ����������
	 * @return ����������
	 */
	public String getPljtype() {
		return pljtype;
	}

	/**
	 * ����������
	 * @param  pljtype
	 */
	public void setPljtype(String pljtype) {
		this.pljtype = pljtype;
	}

	/**
	 * ���̶���id
	 * @return ���̶���id
	 */
	public String getPldpdid() {
		return pldpdid;
	}

	/**
	 * ���̶���id
	 * @param  pldpdid
	 */
	public void setPldpdid(String pldpdid) {
		this.pldpdid = pldpdid;
	}

	/**
	 * ����ťid
	 * @return ����ťid
	 */
	public String getPldactionid() {
		return pldactionid;
	}

	/**
	 * ����ťid
	 * @param  pldactionid
	 */
	public void setPldactionid(String pldactionid) {
		this.pldactionid = pldactionid;
	}

	/**
	 * ����������
	 * @return ����������
	 */
	public String getInitiativepidname() {
		return initiativepidname;
	}

	/**
	 * ����������
	 * @param  initiativepidname
	 */
	public void setInitiativepidname(String initiativepidname) {
		this.initiativepidname = initiativepidname;
	}

	/**
	 * ����������
	 * @return ����������
	 */
	public String getPassivitypidname() {
		return passivitypidname;
	}

	/**
	 * ����������
	 * @param  passivitypidname
	 */
	public void setPassivitypidname(String passivitypidname) {
		this.passivitypidname = passivitypidname;
	}
	
	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
	public String getPdname() {
		return pdname;
	}

	public void setPdname(String pdname) {
		this.pdname = pdname;
	}

	public String getPddesc() {
		return pddesc;
	}

	public void setPddesc(String pddesc) {
		this.pddesc = pddesc;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	public IG380TB getProcessDefinitionTB() {
		// TODO Auto-generated method stub
		return null;
	}
	/** �鿴ģʽ 0���£��ɱ༭��1����ʷ��ֻ�鿴 */
	protected String viewhistory;

	/**
	 * �鿴ģʽ
	 *
	 * @return �鿴ģʽ
	 */
	public String getViewhistory() {
		return viewhistory;
	}

	/**
	 * �鿴ģʽ
	 *
	 * @param viewHistory  0�����£�1��ʷ
	 */
	public void setViewhistory(String viewhistory) {
		this.viewhistory = viewhistory;
	}

	public String getPlid_like() {
		// TODO Auto-generated method stub
		return null;
	}
}
