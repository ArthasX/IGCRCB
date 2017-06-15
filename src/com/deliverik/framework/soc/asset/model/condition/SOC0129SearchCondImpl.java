package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;

/**
 * �ʲ�������Ϣ��������ʵ��
 * 
 */
public class SOC0129SearchCondImpl implements SOC0129SearchCond {
	
	/** ���ݿ�ID */
	protected String id;

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
	
	/** �����汾 */
	protected int checkersion;
	

	/**
	 * @return the ���ݿ�ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * �����汾ȡ��
	 * @return checkersion �����汾
	 */
	public int getCheckersion() {
		return checkersion;
	}

	/**
	 * �����汾�趨
	 * @param checkersion �����汾
	 */
	public void setCheckersion(int checkersion) {
		this.checkersion = checkersion;
	}

	/** �Ƿ�ɼ̳б�ʶ��ʹ��entity����Ԥ���ֶ�EKEY2, 0����̳У�1�����̳�*/
	protected String ekey2;
	
	public String getEkey2() {
		return ekey2;
	}

	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
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
	
}
