/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCond;

/**
 * ͳ�Ʒ���-�����б���FORM
 * 
 */
@SuppressWarnings("serial")
public class IGCOM0215Form extends BaseForm implements ReportFileDefinitionSearchCond{
	
	/** ������ʾ����(ģ��ƥ��) */
	protected String rfdtitle_like;
	
	/** ������ʾ���� */
	protected String rfdtitle;
	
	/**  ������� */
	protected String rfdtype;
	
	/** ���������� */
	protected String rfdfilename;
	/** ����ID*/
	protected Integer rfdid;
	/**
	 * ������ʾ����(ģ��ƥ��)ȡ��
	 * @return ������ʾ����(ģ��ƥ��)
	 */
	public String getRfdtitle_like() {
		return rfdtitle_like;
	}
	
	/**
	 * ������ʾ����(ģ��ƥ��)�趨
	 * @param rfdtitle_like ������ʾ����(ģ��ƥ��)
	 */
	public void setRfdtitle_like(String rfdtitle_like) {
		this.rfdtitle_like = rfdtitle_like;
	}
	
	/**
	 * ������ʾ����ȡ��
	 * @return ������ʾ����
	 */
	public String getRfdtitle() {
		return rfdtitle;
	}

	/**
	 * ������ʾ�����趨
	 * @param rfdtitle ������ʾ����
	 */
	public void setRfdtitle(String rfdtitle) {
		this.rfdtitle = rfdtitle;
	}

	/**
	 * �������ȡ��
	 * @return �������
	 */
	public String getRfdtype() {
		return rfdtype;
	}

	/**
	 * ��������趨
	 * @param rfdtype �������
	 */
	public void setRfdtype(String rfdtype) {
		this.rfdtype = rfdtype;
	}
	
	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getRfdfilename() {
		return rfdfilename;
	}

	/**
	 * �����������趨
	 * @param rfdfilename ����������
	 */
	public void setRfdfilename(String rfdfilename) {
		this.rfdfilename = rfdfilename;
	}

	public Integer getRfdid() {
		return rfdid;
	}

	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}
	
}
