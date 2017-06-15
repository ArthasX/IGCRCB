/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
/**
 * 
 */
package com.deliverik.infogovernor.iam.form;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.iam.model.entity.InternalauditprjTB;

/**
 * @author zhaomin
 *
 */
/**
 * ����: �����������޸ġ�ɾ��form
 * ���������������������޸ġ�ɾ��
 * �����ˣ�����
 * ������¼�� 2012-7-26
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGIAM0203Form extends BaseForm  implements Serializable {

	/** ���� */
	protected Integer iajid;

	/** �ƻ���� */
	protected String iajyear;

	/** ������ĿID */
	protected Integer iajiapid;

	/** �������� */
	protected String iajname;

	/** ʵ�ʹ�����ʼ���� */
	protected String iajstarttime;

	/** ʵ�ʹ����������� */
	protected String iajovertime;

	/** ������������ */
	protected String iajdesc;

	/** �Ǽ�ʱ�� */
	protected String iajinserttime;

	/** ���� */
	protected String iajattkey;

	/** �Ǽ���ID */
	protected String iajuserid;
	
	/** ������Ŀ��Ϣʵ�� */
	protected  InternalauditprjTB internalauditprjTB;
	
	/** ��Ҫɾ���ĸ���id��*/
	protected String deletekeys;
	
	/** ���� */
	protected Map<Integer, FormFile> fileMap = null;
	
	/**
	 * ��ȡdeletekeys
	 * @return fdeletekeys deletekeys
	 */
	public String getDeletekeys() {
		return deletekeys;
	}

	/**
	 * ����deletekeys
	 * @param deletekeys  deletekeys
	 */
	public void setDeletekeys(String deletekeys) {
		this.deletekeys = deletekeys;
	}

	/**
	 * ��ȡiajid
	 * @return fiajid iajid
	 */
	public Integer getIajid() {
		return iajid;
	}

	/**
	 * ����iajid
	 * @param iajid  iajid
	 */
	public void setIajid(Integer iajid) {
		this.iajid = iajid;
	}

	/**
	 * ��ȡiajyear
	 * @return fiajyear iajyear
	 */
	public String getIajyear() {
		return iajyear;
	}

	/**
	 * ����iajyear
	 * @param iajyear  iajyear
	 */
	public void setIajyear(String iajyear) {
		this.iajyear = iajyear;
	}

	/**
	 * ��ȡiajiapid
	 * @return fiajiapid iajiapid
	 */
	public Integer getIajiapid() {
		return iajiapid;
	}

	/**
	 * ����iajiapid
	 * @param iajiapid  iajiapid
	 */
	public void setIajiapid(Integer iajiapid) {
		this.iajiapid = iajiapid;
	}

	/**
	 * ��ȡiajname
	 * @return fiajname iajname
	 */
	public String getIajname() {
		return iajname;
	}

	/**
	 * ����iajname
	 * @param iajname  iajname
	 */
	public void setIajname(String iajname) {
		this.iajname = iajname;
	}

	/**
	 * ��ȡiajstarttime
	 * @return fiajstarttime iajstarttime
	 */
	public String getIajstarttime() {
		return iajstarttime;
	}

	/**
	 * ����iajstarttime
	 * @param iajstarttime  iajstarttime
	 */
	public void setIajstarttime(String iajstarttime) {
		this.iajstarttime = iajstarttime;
	}

	/**
	 * ��ȡiajovertime
	 * @return fiajovertime iajovertime
	 */
	public String getIajovertime() {
		return iajovertime;
	}

	/**
	 * ����iajovertime
	 * @param iajovertime  iajovertime
	 */
	public void setIajovertime(String iajovertime) {
		this.iajovertime = iajovertime;
	}

	/**
	 * ��ȡiajdesc
	 * @return fiajdesc iajdesc
	 */
	public String getIajdesc() {
		return iajdesc;
	}

	/**
	 * ����iajdesc
	 * @param iajdesc  iajdesc
	 */
	public void setIajdesc(String iajdesc) {
		this.iajdesc = iajdesc;
	}

	/**
	 * ��ȡiajinserttime
	 * @return fiajinserttime iajinserttime
	 */
	public String getIajinserttime() {
		return iajinserttime;
	}

	/**
	 * ����iajinserttime
	 * @param iajinserttime  iajinserttime
	 */
	public void setIajinserttime(String iajinserttime) {
		this.iajinserttime = iajinserttime;
	}

	/**
	 * ��ȡiajattkey
	 * @return fiajattkey iajattkey
	 */
	public String getIajattkey() {
		return iajattkey;
	}

	/**
	 * ����iajattkey
	 * @param iajattkey  iajattkey
	 */
	public void setIajattkey(String iajattkey) {
		this.iajattkey = iajattkey;
	}

	/**
	 * ��ȡiajuserid
	 * @return fiajuserid iajuserid
	 */
	public String getIajuserid() {
		return iajuserid;
	}

	/**
	 * ����iajuserid
	 * @param iajuserid  iajuserid
	 */
	public void setIajuserid(String iajuserid) {
		this.iajuserid = iajuserid;
	}


	/**
	 * ��ȡinternalauditprjTB
	 * @return finternalauditprjTB internalauditprjTB
	 */
	public InternalauditprjTB getInternalauditprjTB() {
		return internalauditprjTB;
	}

	/**
	 * ����internalauditprjTB
	 * @param internalauditprjTB  internalauditprjTB
	 */
	public void setInternalauditprjTB(InternalauditprjTB internalauditprjTB) {
		this.internalauditprjTB = internalauditprjTB;
	}
	
	/**
	 * ��ȡfileMap
	 * @return ffileMap fileMap
	 */
	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}

	/**
	 * ����fileMap
	 * @param fileMap  fileMap
	 */
	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}
	@Override
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.fileMap = new HashMap<Integer, FormFile>();
	}
	
	/**
	 * ��ȡ����
	 * @return ��ȡ����
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get(new Integer(index));
	}

	/**
	 * ���ø���
	 * @param index ������������
	 * @param file ����
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put(new Integer(index), file);
	}

}
