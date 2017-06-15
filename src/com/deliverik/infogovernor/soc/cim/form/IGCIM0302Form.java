package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0103SearchCond;

/**
 * ��ƶԱȽ����ѯ����FORM
 * 
 */
public class IGCIM0302Form extends BaseForm implements SOC0103SearchCond{
	
	private static final long serialVersionUID = 1L;

	
	/** ���ʱ��� ��ʼ */
	protected String autime_from;
	
	/** ���ʱ��� ���� */
	protected String autime_to;
	
	/** ����������� */
	protected String autdesc;
	
	/** �ʲ������ */
	protected String esyscoding;
	
	/** �ʲ����� */
	protected String ename;
	
	/** �����ʶ */
	protected String[] checkbox;
	
	/** ���ID */
	protected Integer[] aurids;
	
	/** ��ƽ��˵�� */
	protected String[] auresultdesces;
	
	/** �������ID */
	protected Integer autid;
	
	/** ����ʱ�� */
	protected String autupdtime;
	
	/** �Ա�ʱ�� */
	protected String autcomptime;

	protected Integer eiid;

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * �����������ȡ��
	 * @return �����������
	 */
	public String getAutdesc() {
		return autdesc;
	}

	/**
	 * ������������趨
	 * @param autdesc �����������
	 */
	public void setAutdesc(String autdesc) {
		this.autdesc = autdesc;
	}

	/**
	 * ���ʱ��� ��ʼȡ��
	 * @return ���ʱ��� ��ʼ
	 */
	public String getAutime_from() {
		return autime_from;
	}

	/**
	 * ���ʱ��� ��ʼ�趨
	 * @param autime_from ���ʱ��� ��ʼ
	 */
	public void setAutime_from(String autime_from) {
		this.autime_from = autime_from;
	}

	/**
	 * ���ʱ��� ����ȡ��
	 * @return ���ʱ��� ����
	 */
	public String getAutime_to() {
		return autime_to;
	}

	/**
	 * ���ʱ��� �����趨
	 * @param autime_to ���ʱ��� ����
	 */
	public void setAutime_to(String autime_to) {
		this.autime_to = autime_to;
	}

	/**
	 * �ʲ������ȡ��
	 * @return �ʲ������
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ�������趨
	 * @param esyscoding �ʲ������
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * �ʲ�����ȡ��
	 * @return �ʲ�����
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * �ʲ������趨
	 * @param einame �ʲ�����
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * �����ʶȡ��
	 * @return �����ʶ
	 */
	public String[] getCheckbox() {
		return checkbox;
	}

	/**
	 * �����ʶ�趨
	 * @param checkbox �����ʶ
	 */
	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}

	/**
	 * ��ƽ��˵��ȡ��
	 * @return ��ƽ��˵��
	 */
	public String[] getAuresultdesces() {
		return auresultdesces;
	}

	/**
	 * ��ƽ��˵���趨 
	 * @param auresultdesces ��ƽ��˵��
	 */
	public void setAuresultdesces(String[] auresultdesces) {
		this.auresultdesces = auresultdesces;
	}

	/**
	 * ���IDȡ��
	 * @return ���ID
	 */
	public Integer[] getAurids() {
		return aurids;
	}

	/**
	 * ���ID�趨
	 * @param aurids ���ID
	 */
	public void setAurids(Integer[] aurids) {
		this.aurids = aurids;
	}

	/**
	 * �������IDȡ��
	 * @return �������ID
	 */
	public Integer getAutid() {
		return autid;
	}

	/**
	 * �������ID�趨
	 * @param autid �������ID
	 */
	public void setAutid(Integer autid) {
		this.autid = autid;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getAutupdtime() {
		return autupdtime;
	}

	/**
	 * ����ʱ���趨
	 * @param autupdtime ����ʱ��
	 */
	public void setAutupdtime(String autupdtime) {
		this.autupdtime = autupdtime;
	}

	/**
	 * �Ա�ʱ��ȡ��
	 * @return �Ա�ʱ��
	 */
	public String getAutcomptime() {
		return autcomptime;
	}

	/**
	 * �Ա�ʱ���趨
	 * @param autcomptime �Ա�ʱ��
	 */
	public void setAutcomptime(String autcomptime) {
		this.autcomptime = autcomptime;
	}
	

}
