/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.IG202Info;
import com.deliverik.framework.workflow.prd.model.entity.IG286TB;

/**
 * ���̶��������Ϣ�༭����Form
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0118Form extends BaseForm implements IG202Info {
	
	
	/** ����Ϣ��Ĭ��ֵ */
	protected String piddefault;

	/** ����Ϣ������ */
	protected String piddesc;

	/** ����Ϣ��ID */
	protected Integer pidid;

	/** ����Ϣ����ʾ���� */
	protected String pidlabel;

	/** ����Ϣ����ʾ���� */
	protected String pidlabel_bak;
	
	/** ����Ϣ�ĺ�̨���� */
	protected String pidname;

	/** ����Ϣ��ȡֵ��Χ */
	protected String pidoption;

	/** ����Ϣ�Ƿ������ */
	protected String pidrequired;

	/** ����Ϣ������ */
	protected String pidtype;
	
	/** ���̶����¼��ʱ��� */
	protected String fingerPrint;
	
	/** ģʽ 0�Ǽǣ�1�༭ */
	protected String mode = "0";
	
	/** ����Ϣ��ģʽ */
	protected String pidmode;
	
	/** ����Ϣ������ʾģʽ */
	protected String rowwidth;
	
	/** ����Ϣ������ʾģʽ */
	protected String privatescope;

	/** ����ID */
	protected String pidsortid;
	
	protected String ccid;
	
	protected String pidgid[];
	
	protected String pdid;
	
	/** �ӻ�������������ӹ�ͨ���� */
	protected String basic;
	
	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public String[] getPidgid() {
		return pidgid;
	}

	public void setPidgid(String[] pidgid) {
		this.pidgid = pidgid;
	}

	public String getCcid() {
		return ccid;
	}

	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	public String getPidsortid() {
		return pidsortid;
	}

	public void setPidsortid(String pidsortid) {
		this.pidsortid = pidsortid;
	}

	/**
	 * ģʽȡ��
	 * 
	 * @return ģʽ
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * ģʽ�趨
	 *
	 * @param mode ģʽ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}


	/**
	 * ����Ϣ��Ĭ��ֵȡ��
	 * 
	 * @return ����Ϣ��Ĭ��ֵ
	 */
	public String getPiddefault() {
		return piddefault;
	}

	/**
	 * ����Ϣ��Ĭ��ֵ�趨
	 *
	 * @param piddefault ����Ϣ��Ĭ��ֵ
	 */
	public void setPiddefault(String piddefault) {
		this.piddefault = piddefault;
	}

	/**
	 * ����Ϣ������ȡ��
	 * 
	 * @return ����Ϣ������
	 */
	public String getPiddesc() {
		return piddesc;
	}

	/**
	 * ����Ϣ�������趨
	 *
	 * @param piddesc ����Ϣ������
	 */
	public void setPiddesc(String piddesc) {
		this.piddesc = piddesc;
	}

	/**
	 * ����Ϣ��IDȡ��
	 * 
	 * @return ����Ϣ��ID
	 */
	public Integer getPidid() {
		return pidid;
	}

	/**
	 * ����Ϣ��ID�趨
	 *
	 * @param pidid ����Ϣ��ID
	 */
	public void setPidid(Integer pidid) {
		this.pidid = pidid;
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
	 * ����Ϣ����ʾ����ȡ��
	 * 
	 * @return ����Ϣ����ʾ����
	 */
	public String getPidlabel_bak() {
		return pidlabel_bak;
	}

	/**
	 * ����Ϣ����ʾ�����趨
	 *
	 * @param pidlabel_bak ����Ϣ����ʾ����
	 */
	public void setPidlabel_bak(String pidlabel_bak) {
		this.pidlabel_bak = pidlabel_bak;
	}

	/**
	 * ����Ϣ�ĺ�̨����ȡ��
	 * 
	 * @return ����Ϣ�ĺ�̨����
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * ����Ϣ�ĺ�̨�����趨
	 *
	 * @param pidname ����Ϣ�ĺ�̨����
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * ����Ϣ��ȡֵ��Χȡ��
	 * 
	 * @return ����Ϣ��ȡֵ��Χ
	 */
	public String getPidoption() {
		return pidoption;
	}

	/**
	 * ����Ϣ��ȡֵ��Χ�趨
	 *
	 * @param pidoption ����Ϣ��ȡֵ��Χ
	 */
	public void setPidoption(String pidoption) {
		this.pidoption = pidoption;
	}

	/**
	 * ����Ϣ���Ƿ������ȡ��
	 * 
	 * @return ����Ϣ���Ƿ������
	 */
	public String getPidrequired() {
		return pidrequired;
	}

	/**
	 * ����Ϣ���Ƿ�������趨
	 *
	 * @param pidrequired ����Ϣ���Ƿ������
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
	 * ����Ϣ��¼��ʱ���ȡ��
	 * 
	 * @return ����Ϣ��¼��ʱ���
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * ����Ϣ��¼��ʱ����趨
	 *
	 * @param fingerPrint ����Ϣ��¼��ʱ���
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public List<IG286TB> getProcessLinkageDefList() {
		return null;
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

	public String getPrivateaccess() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * �ӻ�������������ӹ�ͨ����ȡ��
	 * @return �ӻ�������������ӹ�ͨ����
	 */
	public String getBasic() {
		return basic;
	}

	/**
	 * �ӻ�������������ӹ�ͨ�����趨
	 * @param basic�ӻ�������������ӹ�ͨ����
	 */
	public void setBasic(String basic) {
		this.basic = basic;
	}
}
