/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.dut.model.condition.DelaySearchCond;

/**
 * 
 * ��ʱ��������form
 *
 */
public class IGDUT0402Form extends BaseForm implements DelaySearchCond {
	
	private static final long serialVersionUID = 1L;

	/** ����id */
	protected Integer id;

	/** ����ʱ��� */
	protected String datetime_from;
	
	/** ����ʱ�䵽 */
	protected String datetime_to;

	/** ���뵥λ */
	protected String orgname_eq;

	/** ������� */
	protected String title_like;
	
	/**
	 * ɾ������
	 */
	protected String[] deleteId;

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * ����id�趨
	 *
	 * @param id ����id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * ���뵥λȡ��
	 *
	 * @return ���뵥λ
	 */
	public String getOrgname_eq() {
		return orgname_eq;
	}

	/**
	 * ���뵥λ�趨
	 *
	 * @param orgname ���뵥λ
	 */
	public void setOrgname_eq(String orgname_eq) {
		this.orgname_eq = orgname_eq;
	}

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getTitle_like() {
		return title_like;
	}

	/**
	 * ��������趨
	 *
	 * @param title �������
	 */
	public void setTitle_like(String title_like) {
		this.title_like = title_like;
	}
	
	/**
	 * ����ʱ���ȡ��
	 * @return
	 */
	public String getDatetime_from() {
		return datetime_from;
	}

	/**
	 * ����ʱ����趨
	 * @param datetime_from
	 */
	public void setDatetime_from(String datetime_from) {
		this.datetime_from = datetime_from;
	}

	/**
	 * ����ʱ�䵽ȡ��
	 * @return
	 */
	public String getDatetime_to() {
		return datetime_to;
	}

	/**
	 * ����ʱ�䵽�趨
	 * @param datetime_to
	 */
	public void setDatetime_to(String datetime_to) {
		this.datetime_to = datetime_to;
	}

	/**
	 * ɾ������ȡ��
	 * @return
	 */
	public String[] getDeleteId() {
		return deleteId;
	}

	/**
	 * ɾ�������趨
	 * @param deleteRoleid
	 */
	public void setDeleteId(String[] deleteId) {
		this.deleteId = deleteId;
	}
}
