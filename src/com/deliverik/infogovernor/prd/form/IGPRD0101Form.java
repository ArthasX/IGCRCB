/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.form;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCond;

/**
 * ���̶����ѯ����Form
 * 
 * @author liupeng@deliverik.com
 */
@SuppressWarnings("serial")
public class IGPRD0101Form extends BaseForm implements IG380SearchCond {

	/** ���̶���ID */
	protected String pdid;

	/** ���̶������� */
	protected String pdname;

	/** ���̶���״̬ */
	protected String pdstatus;

	/** ����ģ��ID */
	protected Integer ptid;
	
	/**��ͨ�������Զ�������ģ��ID����**/
	protected Integer[] PrTypeArray;
	
	/**��ͨ����״̬����**/
	protected String[] pdstatuses;
	
	/** ������־Ȩ�� */
	protected String permission;

	/** ���̶���ű� */
	protected FormFile xmlFile;
	
	/** ���̶���ID */
	protected String pdid_export;

	//===��ܱ���Begin
	/** ����ģ������ */
	protected String pttype;
	
	/**
	 * ����ģ������ȡ��
	 *
	 * @return pttype ����ģ������
	 */
	public String getPttype() {
		return pttype;
	}


	/**
	 * ����ģ�������趨
	 *
	 * @param pttype ����ģ������
	 */
	public void setPttype(String pttype) {
		this.pttype = pttype;
	}
	//===��ܱ���End

	/**
	 * ������־Ȩ��ȡ��
	 * @return ������־Ȩ��
	 */
	public String getPermission() {
		return permission;
	}


	/**
	 * ������־Ȩ���趨
	  * @param permission ������־Ȩ��
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 *
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ���̶�������ȡ��
	 * 
	 * @return ���̶�������
	 */
	public String getPdname() {
		return pdname;
	}

	/**
	 * ���̶��������趨
	 *
	 * @param pdname ���̶�������
	 */
	public void setPdname(String pdname) {
		this.pdname = pdname;
	}

	/**
	 * ���̶���״̬ȡ��
	 * 
	 * @return ���̶���״̬
	 */
	public String getPdstatus() {
		return pdstatus;
	}

	/**
	 * ���̶���״̬�趨
	 *
	 * @param pdstatus ���̶���״̬
	 */
	public void setPdstatus(String pdstatus) {
		this.pdstatus = pdstatus;
	}

	/**
	 * ����ģ��IDȡ��
	 * 
	 * @return ����ģ��ID
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * ����ģ��ID�趨
	 *
	 * @param ptid ����ģ��ID
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	public Integer getNotSelfPd() {
		// TODO Auto-generated method stub
		return null;
	}


	public String[] getPdstatuses() {
		return pdstatuses;
	}

	public void setPdstatuses(String[] pdstatuses) {
		this.pdstatuses = pdstatuses;
	}

	public Integer[] getPrTypeArray() {
		return PrTypeArray;
	}

	public void setPrTypeArray(Integer[] prTypeArray) {
		PrTypeArray = prTypeArray;
	}

	public String getPdid_like() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ���̶���ű�ȡ��
	 * 
	 * @return ���̶���ű�
	 */
	public FormFile getXmlFile() {
		return xmlFile;
	}

	/**
	 * ���̶���ű��趨
	 * 
	 * @param xmlFile ���̶���ű�
	 */
	public void setXmlFile(FormFile xmlFile) {
		this.xmlFile = xmlFile;
	}
	
	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getPdid_export() {
		return pdid_export;
	}

	/**
	 * ���̶���ID�趨
	 * 
	 * @param pdid_export ���̶���ID
	 */
	public void setPdid_export(String pdid_export) {
		this.pdid_export = pdid_export;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.xmlFile = null;
		this.pdid_export = null;
	}


	public String[] getPrpdid_like_or() {
		// TODO Auto-generated method stub
		return null;
	}


	public String[] getPdid_in() {
		// TODO Auto-generated method stub
		return null;
	}


	public String[] getPdid_not_in() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getActname() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
