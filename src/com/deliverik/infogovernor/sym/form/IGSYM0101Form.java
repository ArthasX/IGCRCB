/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.form;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.condition.OrganizationSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��������_��ѯɾ��Form
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM0101Form extends BaseForm implements OrganizationSearchCond{
	
	private static final long serialVersionUID = -7806752326705441563L;

	/**
	 * ��������
	 */
	
	protected String orgid;
	
	/**
	 * �ϼ���������
	 */
	
	protected String orgpar;
	
	/**
	 * �ϼ���������
	 */
	
	protected String orgparstr;
	
	/**
	 * �ϼ���������
	 */
	
	protected String orgparname;
	
	/**
	 * ��������
	 */
	
	protected String orgname;
	
	/**
	 * ��������(��ѯ)
	 */
	
	protected String orgname_q;
	
	/**
	 * ����ɾ������
	 */
	
	protected String[] deleteOrgid;
	
	
	/**
	 * ����״̬(0ͣ�� 1����)
	 */
	
	protected String is_in_use;
	
	/**
	 * �ϼ���������
	 */
	
	protected String orgparid;
	
	protected String orgstatus;
	
	protected Integer orgsuper;//����adminorg����
	
	
	protected String orgsyscoding;
	
	protected ArrayList<String> syscoding_area;
	
	/**
	 * ��ɫ����������ѯ��(�ʲ�Ȩ�޿���)
	 */
	protected String roledomain_q;
	
	/**
	 * ��ɫ����������ѯ���ȫ����(�ʲ�Ȩ�޿���)
	 */
	protected String complete_name;
	
	/**
	 * ��ѯҳ--�ϼ�����--����syscode
	 */
	
	protected String orgparstr_q;
	

	/**
	 * �Ƿ���ʾͣ�ð�ť(ֻ�ܴ����¼�������ʼͣ��)
	 */
	protected String orgsyscoding_q;
	
	/** ����ʽ */
	protected String sortType;
	
	/**
	 * �²�����
	 *        0512: �²�ȫ��
	 *        0512001: �²�����
	 *        0512002: �²�֧��
	 */
	protected String selectorg;
	

	/**
	 * @return the sortType
	 */
	public String getSortType() {
		return sortType;
	}

	/**
	 * @param sortType the sortType to set
	 */
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public ArrayList<String> getSyscoding_area() {
		return syscoding_area;
	}

	public void setSyscoding_area(ArrayList<String> syscoding_area) {
		this.syscoding_area = syscoding_area;
	}

	public String getOrgsyscoding_q() {
		return orgsyscoding_q;
	}

	public void setOrgsyscoding_q(String orgsyscoding_q) {
		this.orgsyscoding_q = orgsyscoding_q;
	}

	public String getOrgpar() {
		return orgpar;
	}

	public void setOrgpar(String orgpar) {
		this.orgpar = orgpar;
	}



	public String getOrgparstr_q() {
		return orgparstr_q;
	}

	public void setOrgparstr_q(String orgparstr_q) {
		this.orgparstr_q = orgparstr_q;
	}

	public String getComplete_name() {
		return complete_name;
	}

	public void setComplete_name(String complete_name) {
		this.complete_name = complete_name;
	}

	public String getRoledomain_q() {
		return roledomain_q;
	}

	public void setRoledomain_q(String roledomain_q) {
		this.roledomain_q = roledomain_q;
	}

	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	public Integer getOrgsuper() {
		return orgsuper;
	}

	public void setOrgsuper(Integer orgsuper) {
		this.orgsuper = orgsuper;
	}

	public String getOrgstatus() {
		return orgstatus;
	}

	public void setOrgstatus(String orgstatus) {
		this.orgstatus = orgstatus;
	}
	
	public String getOrgparname() {
		return orgparname;
	}

	public void setOrgparname(String orgparname) {
		this.orgparname = orgparname;
	}

	public String getOrgparid() {
		return orgparid;
	}

	public void setOrgparid(String orgparid) {
		this.orgparid = orgparid;
	}

	public String getIs_in_use() {
		return is_in_use;
	}

	public void setIs_in_use(String is_in_use) {
		this.is_in_use = is_in_use;
	}

	/**
	 * ��ȡ��������
	 * @return String
	 */
	
	public String getOrgid() {
		return orgid;
	}
	
	/**
	 * ���û�������
	 * @param orgid String
	 */
	
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	
	/**
	 * ��ȡ��������
	 * @return String
	 */
	
	public String getOrgname() {
		return orgname;
	}
	
	/**
	 * ���û�������
	 * @param orgname String
	 */
	
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * ��ȡ����ɾ������
	 * @return String[]
	 */
	
	public String[] getDeleteOrgid() {
		return deleteOrgid;
	}

	/**
	 * ���û���ɾ������
	 * @param deleteOrgid String[]
	 */
	
	public void setDeleteOrgid(String[] deleteOrgid) {
		this.deleteOrgid = deleteOrgid;
	}
	
	/**
	 * ����Form
	 * @param mapping ActionMapping
	 * @param request HttpServletRequest
	 */
	
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.deleteOrgid = null;
	}

	
	/**
	 * ��ȡ�ϼ���������
	 * @return String
	 */
	
	public String getOrgparstr() {
		return orgparstr;
	}

	/**
	 * �����ϼ���������
	 * @param orgpar String
	 */
	
	public void setOrgparstr(String orgparstr) {
		this.orgparstr = orgparstr;
	}
	
	/**
	 * ��ȡ��������(��ѯ)
	 * @return String
	 */
	
	public String getOrgname_q(){
		return orgname_q;
	}
	
	/**
	 * ���û�������(��ѯ)
	 * @param orgname_q String
	 */
	
	public void setOrgname_q(String orgname_q) {
		this.orgname_q = orgname_q;
	}

	public ArrayList<String> getNot_in_syscoding_area() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.user.model.condition.OrganizationSearchCond#getXbtype()
	 */
	public String getXbtype() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSelectorg() {
		return selectorg;
	}

	public void setSelectorg(String selectorg) {
		this.selectorg = selectorg;
	}

	public String getOrgname_like() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
