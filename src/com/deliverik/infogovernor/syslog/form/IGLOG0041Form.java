/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.syslog.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.syslog.vo.IGLOG0041VO;

/**
 * <p>
 * Title : InfoGovernor ��־�澯ģ�����
 * </p>
 * <p>
 * Description: ��ع��� >> ������� >> �澯����ģ�����Form
 * </p>
 * 
 * @author wangrongguang@deliverik.com
 * @version 1.0
 */

public class IGLOG0041Form extends BaseForm {
	
	private static final long serialVersionUID = -7806752326705441563L;
	
	private String ename; 
	
	private String esyscoding;
	
	private IGLOG0041VO vo;
	
	protected String[] deleteId;
	
	protected String typeid;
	
	/** ģ��״̬ */
	protected String tempstate;
	
	/** ģ��id */
	protected String ruletempid;
	
	/** ģ������ */
	protected String ruletempname;
	
	/** ��ѯ����ģ��״̬ */
	protected String tempstates;
	
	/** ʹ�ø�ģ����豸ip */
	protected String deviceip;
	
	protected String summary;
	
	
	public String getDeviceip() {
		return deviceip;
	}
	
	public void setDeviceip(String deviceip) {
		this.deviceip = deviceip;
	}
	
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public String getEname() {
		return ename;
	}
	
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	
	public String getEsyscoding() {
		return esyscoding;
	}
	
	public void setVo(IGLOG0041VO vo) {
		this.vo = vo;
	}
	
	public IGLOG0041VO getVo() {
		return vo;
	}
	
	/**
	 * deleteIdȡ��
	 */
	public String[] getDeleteId() {
		return deleteId;
	}
	/**
	 * deleteId�趨
	 */
	public void setDeleteId(String[] deleteId) {
		this.deleteId = deleteId;
	}
	/**
	 * ģ��״̬ȡ��
	 */
	public String getTempstate() {
		return tempstate;
	}
	/**
	 * ģ��״̬�趨
	 */
	public void setTempstate(String tempstate) {
		this.tempstate = tempstate;
	}
	/**
	 * ģ��idȡ��
	 */
	public String getRuletempid() {
		return ruletempid;
	}
	/**
	 * ģ��id�趨
	 */
	public void setRuletempid(String ruletempid) {
		this.ruletempid = ruletempid;
	}
	/**
	 * ģ������ȡ��
	 */
	public String getRuletempname() {
		return ruletempname;
	}
	/**
	 * ģ�������趨
	 */
	public void setRuletempname(String ruletempname) {
		this.ruletempname = ruletempname;
	}
	/**
	 * ��ѯ����ģ��״̬ȡ��
	 */
	public String getTempstates() {
		return tempstates;
	}
	/**
	 * ��ѯ����ģ��״̬�趨
	 */
	public void setTempstates(String tempstates) {
		this.tempstates = tempstates;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
}
