package com.deliverik.framework.user.model.condition;

import java.util.List;

/**
 * ������Ϣ��������ʵ��
 * 
 */
public class OrganizationSearchCondImpl implements OrganizationSearchCond {

	/** �������� */
	protected String orgname;
	
	/** �������� */
	protected String orgname_q;
	
	/** ��������(ģ����ѯ) */
	protected String orgname_like;

	/** �ϼ���������� */
	protected String orgpar;

	/** ����״̬ */
	protected String is_in_use;

	/** �ϼ���������� */
	protected String orgparid;

	/** �ϼ���������� */
	protected Integer orgsuper;

	/** ��������� */
	protected String orgsyscoding;

	/** ��������뼯�� */
	protected List<String> syscoding_area;
	
	/** ��ɫ��������Χ */
	protected String roledomain_q;
	
	/** ��ɫ��������Χ���ȫ����ƽ̨������ */
	protected String complete_name;
	
	/** �ϼ���������� */
	protected String orgparstr_q;
	
	/** ��������� */
	protected String orgsyscoding_q;
	
	/** ����ʽ */
	protected String sortType;

	/** ��������뼯�ϣ�ƽ̨������ */
	protected List<String> not_in_syscoding_area;
	
	/** ��Ҫ���˵Ļ�������루ƽ̨������ */
	protected String xbtype;
	
	
	
	/**
	 * ��������(ģ����ѯ)ȡ��
	 *
	 * @return orgname_like ��������(ģ����ѯ)
	 */
	public String getOrgname_like() {
		return orgname_like;
	}

	/**
	 * ��������(ģ����ѯ)�趨
	 *
	 * @param orgname_like ��������(ģ����ѯ)
	 */
	public void setOrgname_like(String orgname_like) {
		this.orgname_like = orgname_like;
	}

	/**
	 * ��Ҫ���˵Ļ��������ȡ�ã�ƽ̨������
	 * @return ��Ҫ���˵Ļ��������
	 */
	public String getXbtype() {
		return xbtype;
	}

	/**
	 * ��Ҫ���˵Ļ���������趨
	 *
	 * @param xbtype ��Ҫ���˵Ļ��������
	 */
	public void setXbtype(String xbtype) {
		this.xbtype = xbtype;
	}

	/**
	 * ��������뼯��ȡ�ã�ƽ̨������
	 * @return ��������뼯��
	 */
	public List<String> getNot_in_syscoding_area() {
		return not_in_syscoding_area;
	}

	/**
	 * ��������뼯���趨
	 *
	 * @param not_in_syscoding_area ��������뼯��
	 */
	public void setNot_in_syscoding_area(List<String> not_in_syscoding_area) {
		this.not_in_syscoding_area = not_in_syscoding_area;
	}
	
	/**
	 * ����ʽȡ��
	 * @return ����ʽ
	 */
	public String getSortType() {
		return sortType;
	}

	/**
	 * ����ʽ�趨
	 *
	 * @param sortType ����ʽ
	 */
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getOrgname() {
		return orgname;
	}
	
	/**
	 * ���������趨
	 *
	 * @param orgname ��������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getOrgname_q() {
		return orgname_q;
	}

	/**
	 * ���������趨
	 *
	 * @param orgname_q ��������
	 */
	public void setOrgname_q(String orgname_q) {
		this.orgname_q = orgname_q;
	}

	/**
	 * �ϼ����������ȡ��
	 * @return �ϼ����������
	 */
	public String getOrgpar() {
		return orgpar;
	}

	/**
	 * �ϼ�����������趨
	 *
	 * @param orgpar �ϼ����������
	 */
	public void setOrgpar(String orgpar) {
		this.orgpar = orgpar;
	}

	/**
	 * ����״̬ȡ��
	 * @return ����״̬
	 */
	public String getIs_in_use() {
		return is_in_use;
	}

	/**
	 * ����״̬�趨
	 *
	 * @param is_in_use ����״̬
	 */
	public void setIs_in_use(String is_in_use) {
		this.is_in_use = is_in_use;
	}

	/**
	 * �ϼ����������ȡ��
	 * @return �ϼ����������
	 */
	public String getOrgparid() {
		return orgparid;
	}

	/**
	 * �ϼ�����������趨
	 *
	 * @param orgparid �ϼ����������
	 */
	public void setOrgparid(String orgparid) {
		this.orgparid = orgparid;
	}

	/**
	 * �ϼ����������ȡ��
	 * @return �ϼ����������
	 */
	public Integer getOrgsuper() {
		return orgsuper;
	}

	/**
	 * �ϼ�����������趨
	 *
	 * @param orgsuper �ϼ����������
	 */
	public void setOrgsuper(Integer orgsuper) {
		this.orgsuper = orgsuper;
	}

	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * ����������趨
	 *
	 * @param orgsyscoding ���������
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * ��������뼯��ȡ��
	 * @return ��������뼯��
	 */
	public List<String> getSyscoding_area() {
		return syscoding_area;
	}

	/**
	 * ��������뼯���趨
	 *
	 * @param syscoding_area ��������뼯��
	 */
	public void setSyscoding_area(List<String> syscoding_area) {
		this.syscoding_area = syscoding_area;
	}

	/**
	 * ��ɫ��������Χȡ��
	 * @return ��ɫ��������Χ
	 */
	public String getRoledomain_q() {
		return roledomain_q;
	}

	/**
	 * ��ɫ��������Χ�趨
	 *
	 * @param roledomain_q ��ɫ��������Χ
	 */
	public void setRoledomain_q(String roledomain_q) {
		this.roledomain_q = roledomain_q;
	}

	/**
	 * ��ɫ��������Χ���ȫ��ȡ��
	 * @return ��ɫ��������Χ���ȫ��
	 */
	public String getComplete_name() {
		return complete_name;
	}

	/**
	 * ��ɫ��������Χ���ȫ���趨
	 *
	 * @param complete_name ��ɫ��������Χ���ȫ��
	 */
	public void setComplete_name(String complete_name) {
		this.complete_name = complete_name;
	}

	/**
	 * �ϼ����������ȡ��
	 * @return �ϼ����������
	 */
	public String getOrgparstr_q() {
		return orgparstr_q;
	}

	/**
	 * �ϼ�����������趨
	 *
	 * @param orgparstr_q �ϼ����������
	 */
	public void setOrgparstr_q(String orgparstr_q) {
		this.orgparstr_q = orgparstr_q;
	}

	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public String getOrgsyscoding_q() {
		return orgsyscoding_q;
	}

	/**
	 * ����������趨
	 *
	 * @param orgsyscoding_q ���������
	 */
	public void setOrgsyscoding_q(String orgsyscoding_q) {
		this.orgsyscoding_q = orgsyscoding_q;
	}

}
