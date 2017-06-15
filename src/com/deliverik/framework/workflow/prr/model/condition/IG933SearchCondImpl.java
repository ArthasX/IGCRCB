/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>����:���񹤵���ѯ����ʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
public class IG933SearchCondImpl implements IG933SearchCond {
	
	/** ���񹤵�ID */
	protected Integer sfid;
	
	/** ���񹤵����� */
	protected String sfcode;
	
	/** �Ǽ��˲���ID */
	protected String sforgid;
	
	/** �Ǽ���ID */
	protected String sfregisterid;
	
	/** �Ǽ���NAME */
	protected String sfregistername;

	/** �Ǽǿ�ʼʱ�� */
	protected String sfinstimebegin;

	/** �Ǽǽ���ʱ�� */
	protected String sfinstimeend;
	
	/** ��¼��� */
	protected String sftype;

	/** ��¼���� */
	protected String sftitle;
	
	/** ��¼״̬ */
	protected String sfstatus;

	/** ������NAME */
	protected String sfreportname;
	
	/** �Ǽ���NAME */
	protected String sfusername;
	
	/**
	 * ���ܣ����񹤵�IDȡ��
	 * 
	 * @return ���񹤵�ID
	 */
	public Integer getSfid() {
		return sfid;
	}

	public void setSfid(Integer sfid) {
		this.sfid = sfid;
	}
	
	/**
	 * ���ܣ����񹤵�����ȡ��
	 * 
	 * @return ���񹤵�����
	 */
	public String getSfcode() {
		return sfcode;
	}

	/**
	 * ���ܣ����񹤵���������
	 * @param sfcode ���񹤵�����
	 */
	public void setSfcode(String sfcode) {
		this.sfcode = sfcode;
	}
	
	/**
	 * ���ܣ��Ǽ��˲���IDȡ��
	 * 
	 * @return �Ǽ��˲���ID
	 */
	public String getSforgid() {
		return sforgid;
	}

	public void setSforgid(String sforgid) {
		this.sforgid = sforgid;
	}

	/**
	 * ���ܣ��Ǽ���IDȡ��
	 * 
	 * @return �Ǽ���ID
	 */
	public String getSfregisterid() {
		return sfregisterid;
	}

	/**
	 * ���ܣ��Ǽ���ID����
	 * @param sfregisterid �Ǽ���ID
	 */
	public void setSfregisterid(String sfregisterid) {
		this.sfregisterid = sfregisterid;
	}
	
	/**
	 * ���ܣ��Ǽ���NAMEȡ��
	 * 
	 * @return �Ǽ���NAME
	 */
	public String getSfregistername() {
		return sfregistername;
	}

	/**
	 * ���ܣ��Ǽ���NAME����
	 * @param sfregistername �Ǽ���NAME
	 */
	public void setSfregistername(String sfregistername) {
		this.sfregistername = sfregistername;
	}

	/**
	 * ���ܣ����񹤵���¼��ʼʱ��ȡ��
	 * 
	 * @return ���񹤵���¼��ʼʱ��
	 */
	public String getSfinstimebegin() {
		return sfinstimebegin;
	}

	/**
	 * ���ܣ����񹤵���¼��ʼʱ������
	 * @param sfinstimebegin ���񹤵���¼��ʼʱ��
	 */
	public void setSfinstimebegin(String sfinstimebegin) {
		this.sfinstimebegin = sfinstimebegin;
	}

	/**
	 * ���ܣ����񹤵���¼����ʱ��ȡ��
	 * 
	 * @return ���񹤵���¼����ʱ��
	 */
	public String getSfinstimeend() {
		return sfinstimeend;
	}

	/**
	 * ���ܣ����񹤵���¼����ʱ������
	 * @param sfinstimeend ���񹤵���¼����ʱ��
	 */
	public void setSfinstimeend(String sfinstimeend) {
		this.sfinstimeend = sfinstimeend;
	}
	
	/** 
	 * ���ܣ����񹤵���¼����ȡ��
	 * 
	 * @return ���񹤵���¼����
	 */
	public String getSftype() {
		return sftype;
	}

	/**
	 * ���ܣ����񹤵���¼��������
	 * @param sftype ���񹤵���¼����
	 */
	public void setSftype(String sftype) {
		this.sftype = sftype;
	}
	
	/** 
	 * ���ܣ����񹤵���¼����ȡ��
	 * 
	 * @return ���񹤵���¼����
	 */
	public String getSftitle() {
		return sftitle;
	}

	/**
	 * ���ܣ����񹤵���¼��������
	 * @param sftitle ���񹤵���¼����
	 */
	public void setSftitle(String sftitle) {
		this.sftitle = sftitle;
	}
	
	/** 
	 * ���ܣ����񹤵���¼״̬ȡ��
	 * 
	 * @return ���񹤵���¼״̬
	 */
	public String getSfstatus() {
		return sfstatus;
	}

	/**
	 * ���ܣ����񹤵���¼״̬����
	 * @param sfstatus ���񹤵���¼״̬
	 */
	public void setSfstatus(String sfstatus) {
		this.sfstatus = sfstatus;
	}

	
	/** 
	 * ���ܣ����񹤵�������NAMEȡ��
	 * 
	 * @return ���񹤵�������NAME
	 */
	public String getSfreportname() {
		return sfreportname;
	}

	/**
	 * ���ܣ����񹤵�������NAME����
	 * @param sfreportname ���񹤵�������NAME
	 */
	public void setSfreportname(String sfreportname) {
		this.sfreportname = sfreportname;
	}	
	/**
	 * ���ܣ����񹤵��Ǽ���NAMEȡ��
	 * 
	 * @return ���񹤵�������NAME
	 */
	public String getSfusername(){
		return sfusername;
	}
	
	/**
	 * ���ܣ����񹤵��Ǽ���NAME����
	 * @param sfusername ���񹤵��Ǽ���NAME
	 */
	public void setSfusername(String sfusername) {
		this.sfusername = sfusername;
	}
}
