/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.fxk.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.sym.model.FormFileInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��form��Ϣ
 * </p>
 * 2014-6-16
 * 
 * @author zhangq@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGFXK0700Form extends BaseForm {
	/**�û�*/
	protected User user;
	
	/**���ռƻ���ѯ����*/
	protected int prlistsize;
	/**�����嵥��ѯ����*/
	protected int qdlistsize;
	/**�������Ĳ�ѯ����*/
	protected int qmlistsize;
	/**����������ѯ����*/
	protected int pglistsize;
	/**������ʾ��ѯ����*/
	protected int risklistsize;
	/**�嵥����ִ��*/
	protected int qdExcing;
	/**�嵥���*/
	protected int qdYear;
	
	
	/**��������ִ�е�*/
	protected int pgExcing;
	
	/**�������*/
	protected int pgYear;
	
	/**���ռƻ�����ѡ���ʶ1 ���� 0 ȫ��*/
	protected String riskselecttype;
	/**������������ѡ���ʶ1 ���� 0 ȫ��*/
	protected String pgworkselecttype;
	/** ������Ա���� */
	protected String[] usname;
	/** ������ԱID */
	protected String[] usid;
	/** ������ʾ���� */
	protected String rwname;

	/** �·�����id */
	protected String nuserid;

	/** �·��������� */
	protected String nusername;

	/** �·��߻����� */
	protected String norgname;

	/** �·��߻����� */
	protected String norgid;

	/** �·�ʱ�� */
	protected String ntime;

	/** �·�����ϵ��ʽ */
	protected String ntel;

	/** ������ʾ���� */
	protected String rwcontext;

	/** ��ʾ���� */
	protected String rwkey;

	/** ������id */
	protected String apuserid;

	/** �������������ڲ�ѯ */
	protected String username_s;

	/** ���ջ��������ڲ�ѯ */
	protected String orgid_s;
	/** ���ջ��������ڲ�ѯ */
	protected String orgname_s;

	/** �ж��ǻ���������Ա */
	protected String type;
	/** ���������� */
	protected String apusername;

	/** ���ջ����� */
	protected String[] aporgid;
	
	/**
	 * ��������ִ�е�ȡ��
	 * @return pgExcing ��������ִ�е�
	 */
	public int getPgExcing() {
		return pgExcing;
	}

	/**
	 * ��������ִ�е��趨
	 * @param pgExcing ��������ִ�е�
	 */
	public void setPgExcing(int pgExcing) {
		this.pgExcing = pgExcing;
	}

	/**���յ�����*/
	protected int riskCount;
	
	/**���������*/
	protected int checkCount;
	
	/**
	 * ���յ�����ȡ��
	 * @return riskCount ���յ�����
	 */
	public int getRiskCount() {
		return riskCount;
	}

	/**
	 * ���յ������趨
	 * @param riskCount ���յ�����
	 */
	public void setRiskCount(int riskCount) {
		this.riskCount = riskCount;
	}

	/**
	 * ���������ȡ��
	 * @return checkCount ���������
	 */
	public int getCheckCount() {
		return checkCount;
	}

	/**
	 * ����������趨
	 * @param checkCount ���������
	 */
	public void setCheckCount(int checkCount) {
		this.checkCount = checkCount;
	}

	public int getRisklistsize() {
		return risklistsize;
	}

	public void setRisklistsize(int risklistsize) {
		this.risklistsize = risklistsize;
	}

	public int getPrlistsize() {
		return prlistsize;
	}

	public void setPrlistsize(int prlistsize) {
		this.prlistsize = prlistsize;
	}

	public int getQdlistsize() {
		return qdlistsize;
	}

	public void setQdlistsize(int qdlistsize) {
		this.qdlistsize = qdlistsize;
	}

	public int getQmlistsize() {
		return qmlistsize;
	}

	public void setQmlistsize(int qmlistsize) {
		this.qmlistsize = qmlistsize;
	}

	public int getPglistsize() {
		return pglistsize;
	}

	public void setPglistsize(int pglistsize) {
		this.pglistsize = pglistsize;
	}
	/**
	 * �û�ȡ��
	 * @return user �û�
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �û��趨
	 * @param user �û�
	 */
	public void setUser(User user) {
		this.user = user;
	}

	

	/**
	 * �ж��ǻ���������Աȡ��
	 * 
	 * @return type �ж��ǻ���������Ա
	 */

	public String getType() {
		return type;
	}

	/**
	 * �ж��ǻ���������Ա�趨
	 * 
	 * @param type
	 *            �ж��ǻ���������Ա
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * �������������ڲ�ѯȡ��
	 * 
	 * @return username_s �������������ڲ�ѯ
	 */
	public String getUsername_s() {
		return username_s;
	}

	/**
	 * �������������ڲ�ѯ�趨
	 * 
	 * @param username_s
	 *            �������������ڲ�ѯ
	 */
	public void setUsername_s(String username_s) {
		this.username_s = username_s;
	}

	/**
	 * ���ջ�����ȡ��
	 * 
	 * @return orgid_s ���ջ�����
	 */
	public String getOrgid_s() {
		return orgid_s;
	}

	/**
	 * ���ջ������趨
	 * 
	 * @param orgid_s
	 *            ���ջ�����
	 */
	public void setOrgid_s(String orgid_s) {
		this.orgid_s = orgid_s;
	}

	/**
	 * ���ջ�����ȡ��
	 * 
	 * @return orgname_s ���ջ�����
	 */
	public String getOrgname_s() {
		return orgname_s;
	}

	/**
	 * ���ջ������趨
	 * 
	 * @param orgname_s
	 *            ���ջ�����
	 */
	public void setOrgname_s(String orgname_s) {
		this.orgname_s = orgname_s;
	}

	/**
	 * ������idȡ��
	 * 
	 * @return apuserid ������id
	 */
	public String getApuserid() {
		return apuserid;
	}

	/**
	 * ������id�趨
	 * 
	 * @param apuserid
	 *            ������id
	 */
	public void setApuserid(String apuserid) {
		this.apuserid = apuserid;
	}

	/**
	 * ���ջ�����ȡ��
	 * 
	 * @return aporgid ���ջ�����
	 */

	public String[] getAporgid() {
		return aporgid;
	}

	/**
	 * ���ջ������趨
	 * 
	 * @param aporgid
	 *            ���ջ�����
	 */
	public void setAporgid(String[] aporgid) {
		this.aporgid = aporgid;
	}

	/** ���ջ������� */
	protected String[] aporgname;

	/**
	 * ���ջ�������ȡ��
	 * 
	 * @return aporgname ���ջ�������
	 */
	public String[] getAporgname() {
		return aporgname;
	}

	/**
	 * ���ջ��������趨
	 * 
	 * @param aporgname
	 *            ���ջ�������
	 */
	public void setAporgname(String[] aporgname) {
		this.aporgname = aporgname;
	}

	public String attachDel;

	protected FormFile file;

	protected String attacthname;
	// �Ƿ�ɾ������
	protected String delfile;
	public String deletekeys;
	
	/**�����б�*/
	public List<Attachment>attachmentList;
	
	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	public String getRwname() {
		return rwname;
	}

	public void setRwname(String rwname) {
		this.rwname = rwname;
	}

	public String getNuserid() {
		return nuserid;
	}

	public void setNuserid(String nuserid) {
		this.nuserid = nuserid;
	}

	public String getNusername() {
		return nusername;
	}

	public void setNusername(String nusername) {
		this.nusername = nusername;
	}

	public String getNorgname() {
		return norgname;
	}

	public void setNorgname(String norgname) {
		this.norgname = norgname;
	}

	public String getNorgid() {
		return norgid;
	}

	public void setNorgid(String norgid) {
		this.norgid = norgid;
	}

	public String getNtime() {
		return ntime;
	}

	public void setNtime(String ntime) {
		this.ntime = ntime;
	}

	public String getNtel() {
		return ntel;
	}

	public void setNtel(String ntel) {
		this.ntel = ntel;
	}

	public String getRwcontext() {
		return rwcontext;
	}

	public void setRwcontext(String rwcontext) {
		this.rwcontext = rwcontext;
	}

	public String getRwkey() {
		return rwkey;
	}

	public void setRwkey(String rwkey) {
		this.rwkey = rwkey;
	}

	public String getApusername() {
		return apusername;
	}

	public void setApusername(String apusername) {
		this.apusername = apusername;
	}

	/**
	 * fileListȡ��
	 * 
	 * @return fileList fileList
	 */
	public List<FormFileInfo> getFileList() {
		return fileList;
	}

	/**
	 * fileList�趨
	 * 
	 * @param fileList
	 *            fileList
	 */
	public void setFileList(List<FormFileInfo> fileList) {
		this.fileList = fileList;
	}

	public String getAttachDel() {
		return attachDel;
	}

	public void setAttachDel(String attachDel) {
		this.attachDel = attachDel;
	}

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}

	public String getAttacthname() {
		return attacthname;
	}

	public void setAttacthname(String attacthname) {
		this.attacthname = attacthname;
	}

	public String getDelfile() {
		return delfile;
	}

	public void setDelfile(String delfile) {
		this.delfile = delfile;
	}

	public String getDeletekeys() {
		return deletekeys;
	}

	public void setDeletekeys(String deletekeys) {
		this.deletekeys = deletekeys;
	}

	protected List<FormFileInfo> fileList;

	public IGFXK0700Form() {

		fileList = new ArrayList<FormFileInfo>();

		fileList.add(new FormFileInfo());
	}

	public List<FormFileInfo> getFileListInfo() {
		return fileList;
	}

	public void setFileListInfo(List<FormFileInfo> fileList) {
		this.fileList = fileList;
	}

	public FormFileInfo getFileList(int index) {

		int size = fileList.size();
		if (index > size - 1) {
			for (int i = 0; i < index - size + 1; i++) {
				fileList.add(new FormFileInfo());
			}
		}
		return fileList.get(index);
	}

	/**
	 * ������Ա����ȡ��
	 * 
	 * @return usname ������Ա����
	 */
	public String[] getUsname() {
		return usname;
	}

	/**
	 * ������Ա�����趨
	 * 
	 * @param usname
	 *            ������Ա����
	 */
	public void setUsname(String[] usname) {
		this.usname = usname;
	}

	/**
	 * ������ԱIDȡ��
	 * 
	 * @return usid ������ԱID
	 */
	public String[] getUsid() {
		return usid;
	}

	/**
	 * ������ԱID�趨
	 * 
	 * @param usid
	 *            ������ԱID
	 */
	public void setUsid(String[] usid) {
		this.usid = usid;
	}

	/**
	 * �������ȡ��
	 * @return pgYear �������
	 */
	public int getPgYear() {
		return pgYear;
	}

	/**
	 * �嵥����ִ��ȡ��
	 * @return qdExcing �嵥����ִ��
	 */
	public int getQdExcing() {
		return qdExcing;
	}

	/**
	 * �嵥����ִ���趨
	 * @param qdExcing �嵥����ִ��
	 */
	public void setQdExcing(int qdExcing) {
		this.qdExcing = qdExcing;
	}

	/**
	 * �嵥���ȡ��
	 * @return qdYear �嵥���
	 */
	public int getQdYear() {
		return qdYear;
	}

	/**
	 * �嵥����趨
	 * @param qdYear �嵥���
	 */
	public void setQdYear(int qdYear) {
		this.qdYear = qdYear;
	}

	/**
	 * ��������趨
	 * @param pgYear �������
	 */
	public void setPgYear(int pgYear) {
		this.pgYear = pgYear;
	}

	/**
	 * ���ռƻ�����ѡ���ʶ1����0ȫ��ȡ��
	 * @return riskselecttype ���ռƻ�����ѡ���ʶ1����0ȫ��
	 */
	public String getRiskselecttype() {
		return riskselecttype;
	}

	/**
	 * ���ռƻ�����ѡ���ʶ1����0ȫ���趨
	 * @param riskselecttype ���ռƻ�����ѡ���ʶ1����0ȫ��
	 */
	public void setRiskselecttype(String riskselecttype) {
		this.riskselecttype = riskselecttype;
	}

	/**
	 * ������������ѡ���ʶ1����0ȫ��ȡ��
	 * @return pgworkselecttype ������������ѡ���ʶ1����0ȫ��
	 */
	public String getPgworkselecttype() {
		return pgworkselecttype;
	}

	/**
	 * ������������ѡ���ʶ1����0ȫ���趨
	 * @param pgworkselecttype ������������ѡ���ʶ1����0ȫ��
	 */
	public void setPgworkselecttype(String pgworkselecttype) {
		this.pgworkselecttype = pgworkselecttype;
	}

	

}