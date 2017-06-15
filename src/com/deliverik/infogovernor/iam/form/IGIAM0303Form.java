/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.iam.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.iam.model.entity.InternalauditprjTB;

/**
 * ����:��Ʊ�����Ϣɾ���޸�Form��
 * �����������ṩ����Ʊ�����Ϣ���Եķ�װ
 * �����ˣ���ӿ��
 * ������¼�� 2012-8-10
 * �޸ļ�¼��
 */
public class IGIAM0303Form extends BaseForm {
	/** ����ID */
	protected Integer apid;

	/** ��Ʊ������� */
	protected String apreporttype;

	/** �����ĿID */
	protected Integer approjectid;

	/** ��Ŀ���� */
	protected String approjectname;

	/** ��Ŀ��� */
	protected String approjectyear;

	/** ��Ʊ��渽��KEY */
	protected String apattkey;

	/** ������Ŀ��Ϣʵ�� */
	protected InternalauditprjTB internalauditprjTB;

	/** ��Ҫɾ���ĸ���id�� */
	protected String deletekeys;

	/** ���� */
	protected Map<Integer, FormFile> fileMap = null;

	public Integer getApid() {
		return apid;
	}

	public void setApid(Integer apid) {
		this.apid = apid;
	}

	public String getApreporttype() {
		return apreporttype;
	}

	public void setApreporttype(String apreporttype) {
		this.apreporttype = apreporttype;
	}

	public Integer getApprojectid() {
		return approjectid;
	}

	public void setApprojectid(Integer approjectid) {
		this.approjectid = approjectid;
	}

	public String getApprojectname() {
		return approjectname;
	}

	public void setApprojectname(String approjectname) {
		this.approjectname = approjectname;
	}

	public String getApprojectyear() {
		return approjectyear;
	}

	public void setApprojectyear(String approjectyear) {
		this.approjectyear = approjectyear;
	}

	public String getApattkey() {
		return apattkey;
	}

	public void setApattkey(String apattkey) {
		this.apattkey = apattkey;
	}

	public InternalauditprjTB getInternalauditprjTB() {
		return internalauditprjTB;
	}

	public void setInternalauditprjTB(InternalauditprjTB internalauditprjTB) {
		this.internalauditprjTB = internalauditprjTB;
	}

	public String getDeletekeys() {
		return deletekeys;
	}

	public void setDeletekeys(String deletekeys) {
		this.deletekeys = deletekeys;
	}

	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.fileMap = new HashMap<Integer, FormFile>();
	}

	/**
	 * ��ȡ����
	 * 
	 * @return ��ȡ����
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get(new Integer(index));
	}

	/**
	 * ���ø���
	 * 
	 * @param index
	 *            ������������
	 * @param file
	 *            ����
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put(new Integer(index), file);
	}
}
