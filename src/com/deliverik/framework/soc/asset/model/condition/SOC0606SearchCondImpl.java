/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
 * �ʲ�������Ϣ��������ʵ��
 * 
 */
public class SOC0606SearchCondImpl implements SOC0606SearchCond {

	/** �ʲ�ID */
	protected String eiid;
	
	/** �ʲ�ģ���������� */
	protected String cname;
	
	/** �ʲ�ģ�Ͳ���� */
	protected String esyscoding_q;
	
	/** ���Ա�ţ�SOC�� */
	protected String clabel_q;
	
	/** �ʲ�ID���ϣ�SOC�� */
	protected List<Integer> eiid_list;
	
	/** �ʲ���α��뼯�ϣ�SOC�� */
	protected List<String> esyscode_list;
	
	protected String sreilabel_q;
	
	protected String srname_q;
	
	/** �ʲ�ģ��id */
	protected String eid_q;
	
	/** �汾 */
	protected String civersion;

	/**
	 * �ʲ�ģ��idȡ��
	 *
	 * @return eid_q �ʲ�ģ��id
	 */
	
	public String getEid_q() {
		return eid_q;
	}

	/**
	 * �ʲ�ģ��id�趨
	 *
	 * @param eid_q �ʲ�ģ��id
	 */
	
	public void setEid_q(String eid_q) {
		this.eid_q = eid_q;
	}

	public String getSrname_q() {
		return srname_q;
	}

	public void setSrname_q(String srname_q) {
		this.srname_q = srname_q;
	}

	public String getSreilabel_q() {
		return sreilabel_q;
	}

	public void setSreilabel_q(String sreilabel_q) {
		this.sreilabel_q = sreilabel_q;
	}

	/**
	 * �ʲ�ID���ϣ�SOC��
	 * @return �ʲ�ID���ϣ�SOC��
	 */
	public List<Integer> getEiid_list() {
		return eiid_list;
	}

	/**
	 * �ʲ�ID���ϣ�SOC���趨
	 *
	 * @param eiid_list �ʲ�ID���ϣ�SOC��
	 */
	public void setEiid_list(List<Integer> eiid_list) {
		this.eiid_list = eiid_list;
	}

	/**
	 * �ʲ���α��뼯�ϣ�SOC��
	 * @return �ʲ���α��뼯�ϣ�SOC��
	 */
	public List<String> getEsyscode_list() {
		return esyscode_list;
	}

	/**
	 * �ʲ���α��뼯�ϣ�SOC���趨
	 *
	 * @param esyscode_list �ʲ���α��뼯�ϣ�SOC��
	 */
	public void setEsyscode_list(List<String> esyscode_list) {
		this.esyscode_list = esyscode_list;
	}

	/**
	 * �ʲ�ģ�Ͳ����ȡ�ã�SOC��
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getClabel_q() {
		return clabel_q;
	}

	/**
	 * �ʲ�ģ�Ͳ�����趨��SOC��
	 *
	 * @param clabel_q �ʲ�ģ�Ͳ����
	 */
	public void setClabel_q(String clabel_q) {
		this.clabel_q = clabel_q;
	}


	/**
	 * �ʲ�ģ�Ͳ����ȡ��
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getEsyscoding_q() {
		return esyscoding_q;
	}

	/**
	 * �ʲ�ģ�Ͳ�����趨
	 *
	 * @param esyscoding_q �ʲ�ģ�Ͳ����
	 */
	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
	}

	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID�趨
	 *
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * �ʲ�ģ����������ȡ��
	 * @return �ʲ�ģ����������
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * �ʲ�ģ�����������趨
	 *
	 * @param cname �ʲ�ģ����������
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCiversion() {
		return civersion;
	}

	public void setCiversion(String civersion) {
		this.civersion = civersion;
	}
	
}
