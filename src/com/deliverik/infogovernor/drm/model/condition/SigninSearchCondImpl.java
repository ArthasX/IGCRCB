/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: ǩ�����������ʵ��
  * ��������: ǩ�����������ʵ��
  * ������¼: 2015/03/12
  * �޸ļ�¼: 
  */
public class SigninSearchCondImpl implements SigninSearchCond {
	/**����*/
	protected Integer siid;

	/** ��������id */
	protected Integer drillprid;

	/** Ӧ��ָ������id */
	protected Integer ecprid;

	/** ��������id */
	protected Integer sceneprid;

	/** �û�id */
	protected String siuserid;
	/** �û��� */
	protected String siusername;

	/** ��ɫid */
	protected Integer siroleid;

	/** �Ƿ�Ӧ��ָ�Ӳ����� */
	protected Integer wdc;

	/** �Ƿ񳡾������� */
	protected Integer wdp;

	/** �Ƿ�ǩ�� */
	protected Integer signined;

	/** ǩ��ʱ�� */
	protected String sitime;

	/** ��ɫ����in */
	protected Integer[] roleidin;
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getSiid() {
		return siid;
	}

	/**
	 * �����趨
	 *
	 * @param siid ����
	 */
	public void setSiid(Integer siid) {
		this.siid = siid;
	}

	/**
	 * ��������idȡ��
	 *
	 * @return ��������id
	 */
	public Integer getDrillprid() {
		return drillprid;
	}

	/**
	 * ��������id�趨
	 *
	 * @param drillprid ��������id
	 */
	public void setDrillprid(Integer drillprid) {
		this.drillprid = drillprid;
	}

	/**
	 * Ӧ��ָ������idȡ��
	 *
	 * @return Ӧ��ָ������id
	 */
	public Integer getEcprid() {
		return ecprid;
	}

	/**
	 * Ӧ��ָ������id�趨
	 *
	 * @param ecprid Ӧ��ָ������id
	 */
	public void setEcprid(Integer ecprid) {
		this.ecprid = ecprid;
	}

	/**
	 * ��������idȡ��
	 *
	 * @return ��������id
	 */
	public Integer getSceneprid() {
		return sceneprid;
	}

	/**
	 * ��������id�趨
	 *
	 * @param sceneprid ��������id
	 */
	public void setSceneprid(Integer sceneprid) {
		this.sceneprid = sceneprid;
	}

	/**
	 * �û�idȡ��
	 *
	 * @return �û�id
	 */
	public String getSiuserid() {
		return siuserid;
	}

	/**
	 * �û�id�趨
	 *
	 * @param siuserid �û�id
	 */
	public void setSiuserid(String siuserid) {
		this.siuserid = siuserid;
	}
	/**
	 * �û���ȡ��
	 *
	 * @return �û���
	 */
	public String getSiusername() {
		return siusername;
	}
	
	/**
	 * �û����趨
	 *
	 * @param siuserid �û���
	 */
	public void setSiusername(String siusername) {
		this.siusername = siusername;
	}

	/**
	 * ��ɫidȡ��
	 *
	 * @return ��ɫid
	 */
	public Integer getSiroleid() {
		return siroleid;
	}

	/**
	 * ��ɫid�趨
	 *
	 * @param siroleid ��ɫid
	 */
	public void setSiroleid(Integer siroleid) {
		this.siroleid = siroleid;
	}

	/**
	 * �Ƿ�Ӧ��ָ�Ӳ�����ȡ��
	 *
	 * @return �Ƿ�Ӧ��ָ�Ӳ�����
	 */
	public Integer getWdc() {
		return wdc;
	}

	/**
	 * �Ƿ�Ӧ��ָ�Ӳ������趨
	 *
	 * @param wdc �Ƿ�Ӧ��ָ�Ӳ�����
	 */
	public void setWdc(Integer wdc) {
		this.wdc = wdc;
	}

	/**
	 * �Ƿ񳡾�������ȡ��
	 *
	 * @return �Ƿ񳡾�������
	 */
	public Integer getWdp() {
		return wdp;
	}

	/**
	 * �Ƿ񳡾��������趨
	 *
	 * @param wdp �Ƿ񳡾�������
	 */
	public void setWdp(Integer wdp) {
		this.wdp = wdp;
	}

	/**
	 * �Ƿ�ǩ��ȡ��
	 *
	 * @return �Ƿ�ǩ��
	 */
	public Integer getSignined() {
		return signined;
	}

	/**
	 * �Ƿ�ǩ���趨
	 *
	 * @param signined �Ƿ�ǩ��
	 */
	public void setSignined(Integer signined) {
		this.signined = signined;
	}

	/**
	 * ǩ��ʱ��ȡ��
	 *
	 * @return ǩ��ʱ��
	 */
	public String getSitime() {
		return sitime;
	}

	/**
	 * ǩ��ʱ���趨
	 *
	 * @param sitime ǩ��ʱ��
	 */
	public void setSitime(String sitime) {
		this.sitime = sitime;
	}

	public Integer[] getRoleidin() {
		return roleidin;
	}

	public void setRoleidin(Integer[] roleidin) {
		this.roleidin = roleidin;
	}
	
}