/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.sym.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCond;

/**
 * ������Ϣ��ѯForm
 * 
 */
@SuppressWarnings("serial")
public class IGSYM0413Form extends BaseForm implements ReportFileDefinitionSearchCond {

	/** ������ʾ����(ģ��ƥ��) */
	protected String rfdtitle_like;
	
	/** ������ʾ���� */
	protected String rfdtitle;
	
	/**  ������� */
	protected String rfdtype;
	
	/** ����ɾ������ */
	protected String[] deleteRfdid;
	
	/** �������� */
	protected Integer rfdid;
	
	/** ���������ʾ���� */
	protected String rfdtypename;
	
	/** ���������� */
	protected String rfdfilename;
	
	/** ����˵�� */
	protected String rfddesc;
	
	/** �������� */
	protected String rfdpictype;

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
	 * ����ɾ������ȡ��
	 * @return ����ɾ������
	 */
	public String[] getDeleteRfdid() {
		return deleteRfdid;
	}

	/**
	 * ����ɾ�������趨
	 * @param deleteRfdid ����ɾ������
	 */
	public void setDeleteRfdid(String[] deleteRfdid) {
		this.deleteRfdid = deleteRfdid;
	}
	
	/**
	 * ��ʼ������
	 *
	 * @param mapping 
	 * @param request 
	 */
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.deleteRfdid = null;
		this.rfdid = null;
	}
	
	/**
	 * ���������ʾ����ȡ��
	 * 
	 * @return ���������ʾ����
	 */
	public String getRfdtypename() {
		return rfdtypename;
	}

	/**
	 * ���������ʾ�����趨
	 *
	 * @param rfdtypename ���������ʾ����
	 */
	public void setRfdtypename(String rfdtypename) {
		this.rfdtypename = rfdtypename;
	}
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getRfdid() {
		return rfdid;
	}
	
	/**
	 * ���������趨
	 * @param rfdid ��������
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
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

	public String getRfddesc() {
		return rfddesc;
	}

	public void setRfddesc(String rfddesc) {
		this.rfddesc = rfddesc;
	}

	public String getRfdpictype() {
		return rfdpictype;
	}

	public void setRfdpictype(String rfdpictype) {
		this.rfdpictype = rfdpictype;
	}
	
	
}
