/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.form;

import java.io.Serializable;

import com.deliverik.framework.asset.model.condition.EiDomainDefSearchCond;
import com.deliverik.framework.asset.model.entity.EiDomainDefPK;
import com.deliverik.framework.base.BaseForm;
/**
 * ����: �ʲ������ѯ����FORM
 * ��������: �ʲ������ѯ����FORM
 * ������¼: 2011/04/25
 * �޸ļ�¼: 
 */
public class IGASM2003Form extends BaseForm implements EiDomainDefSearchCond{
	private static final long serialVersionUID = 1L;
	/**
	 * �ʲ���������
	 */
	protected String name_like;
	/**
	 * �ʲ����忪ʼʱ��
	 */
	protected String createtime_from;
	/**
	 * �ʲ������ֹʱ��
	 */
	protected String createtime_to;
	
	/** ɾ���ʲ�������� */
	protected String[] deleteEiddid;
	/**
	 * �ʲ�����eiddid
	 */
	protected Integer eiddid;
	/**
	 * �ʲ�Ԥ����汾��
	 */
	protected Integer version;
	
	/**
	 * �ʲ���������ȡ��
	 */
	public String getName_like() {
		return name_like;
	}
	/**
	 * �ʲ�������������
	 * @param name_like�ʲ���������
	 */
	public void setName_like(String name_like) {
		this.name_like = name_like;
	}
	/**
	 * �ʲ����忪ʼʱ��ȡ��
	 */
	public String getCreatetime_from() {
		return createtime_from;
	}
	/**
	 * �ʲ����忪ʼʱ���趨
	 * @param createtime_from�ʲ����忪ʼʱ��
	 */
	public void setCreatetime_from(String createtime_from) {
		this.createtime_from = createtime_from;
	}
	/**
	 * �ʲ������ֹʱ��ȡ��
	 */
	public String getCreatetime_to() {
		return createtime_to;
	}
	/**
	 * �ʲ������ֹʱ���趨
	 * @param createtime_to�ʲ������ֹʱ��
	 */
	public void setCreatetime_to(String createtime_to) {
		this.createtime_to = createtime_to;
	}
	/**
	 * ɾ���ʲ��������ȡ��
	 * @return ɾ���ʲ��������
	 */
	public String[] getDeleteEiddid() {
		return deleteEiddid;
	}
	/**
	 * ɾ���ʲ���������趨
	 * @param deleteEiddidɾ���ʲ��������
	 */
	public void setDeleteEiddid(String[] deleteEiddid) {
		this.deleteEiddid = deleteEiddid;
	}
	/**
	 * �ʲ�����eiddidȡ��
	 * @return �ʲ�����eiddid
	 */
	public Integer getEiddid() {
		return eiddid;
	}
	/**
	 * �ʲ�����eiddid�趨
	 * @param eiddid �ʲ�����eiddid
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}
	/**
	 * �ʲ�Ԥ����汾��ȡ��
	 * @return �ʲ�Ԥ����汾��
	 */
	public Integer getVersion() {
		return version;
	}
	/**
	 * �ʲ�Ԥ����汾���趨
	 * @param version�ʲ�Ԥ����汾��
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	/**
	 * ����ȡ��
	 */
	public Serializable getPK() {
		return new EiDomainDefPK(eiddid,version);
	}
	public String getEiddid_eq() {
		return null;
	}
	

}
