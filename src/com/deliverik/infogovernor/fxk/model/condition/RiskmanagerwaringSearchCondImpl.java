/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.model.condition;

/**
  * ����: ���չ�����ʾ���ݱ��������ʵ��
  * ��������: ���չ�����ʾ���ݱ��������ʵ��
  * ������¼: 2014/06/17
  * �޸ļ�¼: 
  */
public class RiskmanagerwaringSearchCondImpl implements RiskmanagerwaringSearchCond {
	
	/** ������ʾ���� */
	protected String rwname;

	/** �·�����id */
	protected String nuserid;

	/** �·��������� */
	protected String nusername;

	/** �·��߻����� */
	protected String norgname;

	/** �·��߻����� */
	protected String norgid;

	/** �·�ʱ�� */
	protected String ntime;
	
	/** ���·��û��û�ID */
	protected String userid;
	protected String username_s;
	

	public String getUsername_s() {
		return username_s;
	}

	public void setUsername_s(String username_s) {
		this.username_s = username_s;
	}

	/**
	 * ������ʾ����ȡ��
	 * @return rwname ������ʾ����
	 */
	
	public String getRwname() {
		return rwname;
	}

	/**
	 * ������ʾ�����趨
	 * @param rwname ������ʾ����
	 */
	public void setRwname(String rwname) {
		this.rwname = rwname;
	}

	/**
	 * �·�����idȡ��
	 * @return nuserid �·�����id
	 */
	
	public String getNuserid() {
		return nuserid;
	}

	/**
	 * �·�����id�趨
	 * @param nuserid �·�����id
	 */
	public void setNuserid(String nuserid) {
		this.nuserid = nuserid;
	}

	/**
	 * �·���������ȡ��
	 * @return nusername �·���������
	 */
	
	public String getNusername() {
		return nusername;
	}

	/**
	 * �·����������趨
	 * @param nusername �·���������
	 */
	public void setNusername(String nusername) {
		this.nusername = nusername;
	}

	/**
	 * �·��߻�����ȡ��
	 * @return norgname �·��߻�����
	 */
	
	public String getNorgname() {
		return norgname;
	}

	/**
	 * �·��߻������趨
	 * @param norgname �·��߻�����
	 */
	public void setNorgname(String norgname) {
		this.norgname = norgname;
	}

	/**
	 * �·��߻�����ȡ��
	 * @return norgid �·��߻�����
	 */
	
	public String getNorgid() {
		return norgid;
	}

	/**
	 * �·��߻������趨
	 * @param norgid �·��߻�����
	 */
	public void setNorgid(String norgid) {
		this.norgid = norgid;
	}

	/**
	 * �·�ʱ��ȡ��
	 * @return ntime �·�ʱ��
	 */
	
	public String getNtime() {
		return ntime;
	}

	/**
	 * �·�ʱ���趨
	 * @param ntime �·�ʱ��
	 */
	public void setNtime(String ntime) {
		this.ntime = ntime;
	}

	/**
	 * ���·��û��û�IDȡ��
	 * @return userid ���·��û��û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * ���·��û��û�ID�趨
	 * @param userid ���·��û��û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

}