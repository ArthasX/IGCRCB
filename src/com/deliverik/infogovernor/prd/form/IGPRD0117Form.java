/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.condition.IG202SearchCond;

/**
 * ����Ϣ��ѯ����Form
 * 
 * @author liupeng@deliverik.com
 */
@SuppressWarnings("serial")
public class IGPRD0117Form extends BaseForm implements IG202SearchCond {
	
	/** ����Ϣ�Ƿ���ϵͳĬ�� */
	protected String isDefault;
	

	/** ����Ϣ����ʾ���� */
	protected String pidlabel;

	/** ����Ϣ�ĺ�̨��ʾ���� */
	protected String pidname;

	/** ����Ϣ�ĺ�̨��ʾ����like��ѯ���� */
	protected String pidname_like;
	
	/** ����Ϣ�Ƿ������ */
	protected String pidrequired;

	/** ����Ϣ������ */
	protected String pidtype;
	
	/** ���̶����ID */
	protected String pdid;
	
	/** ����Ϣ��ģʽ */
	protected String pidmode;
	
	/** ����Ϣ������ʾģʽ */
	protected String rowwidth;
	
	/** ����Ϣ������ʾģʽ */
	protected String privatescope;
	
	/** �Ƿ���ʾȷ�ϰ�ť */
	protected String disp;
	
	/**
	 * ����Ϣ�Ƿ���ϵͳĬ��ȡ��
	 * 
	 * @return ����Ϣ�Ƿ���ϵͳĬ��
	 */
	public String getIsDefault() {
		return isDefault;
	}

	/**
	 * ����Ϣ�Ƿ���ϵͳĬ���趨
	 *
	 * @param isDefault ����Ϣ�Ƿ���ϵͳĬ��
	 */
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	

	/**
	 * ����Ϣ����ʾ����ȡ��
	 * 
	 * @return ����Ϣ����ʾ����
	 */
	public String getPidlabel() {
		return pidlabel;
	}

	/**
	 * ����Ϣ����ʾ�����趨
	 *
	 * @param pidlabel ����Ϣ����ʾ����
	 */
	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}

	/**
	 * ����Ϣ�ĺ�̨��ʾ����ȡ��
	 * 
	 * @return ����Ϣ�ĺ�̨��ʾ����
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * ����Ϣ�ĺ�̨��ʾ�����趨
	 *
	 * @param pidname ����Ϣ�ĺ�̨��ʾ����
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * ����Ϣ�ĺ�̨��ʾ����like��ѯ����ȡ��
	 * 
	 * @return ����Ϣ�ĺ�̨��ʾ����like��ѯ����
	 */
	public String getPidname_like() {
		return pidname_like;
	}

	/**
	 * ����Ϣ�ĺ�̨��ʾ����like��ѯ�����趨
	 *
	 * @param pidname_like ����Ϣ�ĺ�̨��ʾ����like��ѯ����
	 */
	public void setPidname_like(String pidname_like) {
		this.pidname_like = pidname_like;
	}

	/**
	 * ����Ϣ�Ƿ������ȡ��
	 * 
	 * @return ����Ϣ�Ƿ������
	 */
	public String getPidrequired() {
		return pidrequired;
	}

	/**
	 * ����Ϣ�Ƿ�������趨
	 *
	 * @param pidname_like ����Ϣ�Ƿ������
	 */
	public void setPidrequired(String pidrequired) {
		this.pidrequired = pidrequired;
	}

	/**
	 * ����Ϣ������ȡ��
	 * 
	 * @return ����Ϣ������
	 */
	public String getPidtype() {
		return pidtype;
	}

	/**
	 * ����Ϣ�������趨
	 *
	 * @param pidtype ����Ϣ������
	 */
	public void setPidtype(String pidtype) {
		this.pidtype = pidtype;
	}

	/**
	 * ���̶����IDȡ��
	 * 
	 * @return ���̶����ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶����ID�趨
	 *
	 * @param pdid ���̶����ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public String getPidmode() {
		return pidmode;
	}

	public void setPidmode(String pidmode) {
		this.pidmode = pidmode;
	}

	public String getRowwidth() {
		return rowwidth;
	}

	public void setRowwidth(String rowwidth) {
		this.rowwidth = rowwidth;
	}

	public String getPrivatescope() {
		return privatescope;
	}

	public void setPrivatescope(String privatescope) {
		this.privatescope = privatescope;
	}

	public Integer getPidid_notlike() {
		return null;
	}

	public String getDisp() {
		return disp;
	}

	public void setDisp(String disp) {
		this.disp = disp;
	}

}
