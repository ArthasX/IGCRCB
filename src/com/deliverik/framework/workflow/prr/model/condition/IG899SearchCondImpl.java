/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * ����: ����˽�б������������ʵ��
  * ��������: ����˽�б������������ʵ��
  * ������¼: 2012/03/27
  * �޸ļ�¼: 
  */
public class IG899SearchCondImpl implements IG899SearchCond {
	
	/** ���̱�������ID */
	protected String pidid;
	
	/** ���̱���ֵID */
	protected Integer piid;

	/** ���̲����ߵĽ�ɫID */
	protected Integer roleid;
	
	/** ���̲�����ID */
	protected String userid;
	
	/** ������ */
	protected String orgid;
	
	/**
	 * ���̱�������IDȡ��
	 *
	 * @return ���̱�������ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ���̱�������ID�趨
	 *
	 * @param Pidid ���̱�������ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}
	
	/**
	 * ���̱���ֵIDȡ��
	 *
	 * @return ���̱���ֵID
	 */
	public Integer getPiid() {
		return piid;
	}
	
	/**
	 * ���̱���ֵID�趨
	 *
	 * @param Piid ���̱���ֵID
	 */
	public void setPiid(Integer piid) {
		this.piid = piid;
	}

	/**
	 * ���̲����ߵĽ�ɫIDȡ��
	 *
	 * @return ���̲����ߵĽ�ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ���̲����ߵĽ�ɫID�趨
	 *
	 * @param roleid ���̲����ߵĽ�ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
	/**
	 * ���̲�����IDȡ��
	 * 
	 * @return ���̲�����ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * ���̲�����ID�趨
	 * 
	 * @param userid ���̲�����ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * �������趨
	 * @param orgid ������
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

}