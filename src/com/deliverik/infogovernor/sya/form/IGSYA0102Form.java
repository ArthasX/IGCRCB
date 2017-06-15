package com.deliverik.infogovernor.sya.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.sym.model.FormFileInfo;

@SuppressWarnings("serial")
public class IGSYA0102Form extends BaseForm{

	/**
	 * ҳ�������ʾ��־0-����,1-���
	 */
	
	protected String mode = "0";
	
	protected Integer inid;
	
	/** �ƶ�����  */	
	protected String inname;

	/** �ƶ�����  */	
	protected String indesc;

	/** ���� */
	protected String attkey;

	protected FormFile file;

	protected List<FormFileInfo> fileList;
	
	protected String attacthname;
	
	public List<Attachment>attachmentList;
	
	public String deletekeys;
	
	/** �ƶȷ���  */	
	public String intype;
	
	public IGSYA0102Form(){
		fileList = new ArrayList<FormFileInfo>();
		fileList.add(new FormFileInfo());	
	}

	public void setFileListInfo(List<FormFileInfo> fileList) {
		this.fileList = fileList;
	}
	public List<FormFileInfo> getFileListInfo() {
		return fileList;
	}
	public FormFileInfo getFileList(int index){
		
		int size = fileList.size();
		if (index>size-1) {
			for (int i = 0; i < index-size+1; i++) {
				fileList.add(new FormFileInfo());
			}
		}
		return fileList.get(index);
	}



	public String getAttkey() {
		return attkey;
	}

	public void setAttkey(String attkey) {
		this.attkey = attkey;
	}

	public FormFile getAttachFile() {
		return this.file;
	}

	public void setAttachFile( FormFile file) {
		this.file=file;
	}
	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getAttacthname() {
		return attacthname;
	}

	public void setAttacthname(String attacthname) {
		this.attacthname = attacthname;
	}

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public String getDeletekeys() {
		return deletekeys;
	}

	public void setDeletekeys(String deletekeys) {
		this.deletekeys = deletekeys;
	}

	/** ����ID 1 */
	protected String attid1;

	/** ����key 1 */
	protected String attkey1;

	/** ����URL 1 */
	protected String atturl1;

	/** �������� 1 */
	protected String attname1;

	/** ���� 1  */
	protected List<Map<Integer, FormFile>> fileListMap1 = new ArrayList<Map<Integer,FormFile>>();

	/**
	 * ���ø���
	 * @param index ������������
	 * @param file ����
	 */
	public void setAttachment1(int index, FormFile file) {
		Map<Integer, FormFile> temp = new HashMap<Integer, FormFile>();
		temp.put(index, file);
		fileListMap1.add(temp);
	}


	/**
	 * @return the fileListMap
	 */
	public List<Map<Integer, FormFile>> getFileListMap1() {
		return this.fileListMap1;
	}

	/**
	 * @param fileListMap the fileListMap to set
	 */
	public void setFileListMap1(List<Map<Integer, FormFile>> fileListMap) {
		this.fileListMap1 = fileListMap;
	}

	/**
	 * @return the attid
	 */
	public String getAttid1() {
		return this.attid1;
	}

	/**
	 * @param attid the attid to set
	 */
	public void setAttid1(String attid) {
		this.attid1 = attid;
	}

	/**
	 * @return the attkey
	 */
	public String getAttkey1() {
		return this.attkey1;
	}

	/**
	 * @param attkey the attkey to set
	 */
	public void setAttkey1(String attkey) {
		this.attkey1 = attkey;
	}

	/**
	 * @return the atturl
	 */
	public String getAtturl1() {
		return this.atturl1;
	}

	/**
	 * @param atturl the atturl to set
	 */
	public void setAtturl1(String atturl) {
		this.atturl1 = atturl;
	}

	/**
	 * @return the attname
	 */
	public String getAttname1() {
		return this.attname1;
	}

	/**
	 * @param attname the attname to set
	 */
	public void setAttname1(String attname) {
		this.attname1 = attname;
	}
	
	
	/** ����ID 2 */
	protected String attid2;

	/** ����key 2 */
	protected String attkey2;

	/** ����URL 2 */
	protected String atturl2;

	/** �������� 2 */
	protected String attname2;

	/** ���� 2  */
	protected List<Map<Integer, FormFile>> fileListMap2 = new ArrayList<Map<Integer,FormFile>>();

	/**
	 * ���ø���
	 * @param index ������������
	 * @param file ����
	 */
	public void setAttachment2(int index, FormFile file) {
		Map<Integer, FormFile> temp = new HashMap<Integer, FormFile>();
		temp.put(index, file);
		fileListMap2.add(temp);
	}


	/**
	 * @return the fileListMap
	 */
	public List<Map<Integer, FormFile>> getFileListMap2() {
		return this.fileListMap2;
	}

	/**
	 * @param fileListMap the fileListMap to set
	 */
	public void setFileListMap2(List<Map<Integer, FormFile>> fileListMap) {
		this.fileListMap2 = fileListMap;
	}

	/**
	 * @return the attid
	 */
	public String getAttid2() {
		return this.attid2;
	}

	/**
	 * @param attid the attid to set
	 */
	public void setAttid2(String attid) {
		this.attid2 = attid;
	}

	/**
	 * @return the attkey
	 */
	public String getAttkey2() {
		return this.attkey2;
	}

	/**
	 * @param attkey the attkey to set
	 */
	public void setAttkey2(String attkey) {
		this.attkey2 = attkey;
	}

	/**
	 * @return the atturl
	 */
	public String getAtturl2() {
		return this.atturl2;
	}

	/**
	 * @param atturl the atturl to set
	 */
	public void setAtturl2(String atturl) {
		this.atturl2 = atturl;
	}

	/**
	 * @return the attname
	 */
	public String getAttname2() {
		return this.attname2;
	}

	/**
	 * @param attname the attname to set
	 */
	public void setAttname2(String attname) {
		this.attname2 = attname;
	}

	/**
	 * inidȡ��
	 * @return inid  inid
	 */
	public Integer getInid() {
		return inid;
	}

	/**
	 * inid�趨
	 * @param inid  inid
	 */
	public void setInid(Integer inid) {
		this.inid = inid;
	}

	/**
	 * �ƶ�����ȡ��
	 * @return inname  �ƶ�����
	 */
	public String getInname() {
		return inname;
	}

	/**
	 * �ƶ������趨
	 * @param inname  �ƶ�����
	 */
	public void setInname(String inname) {
		this.inname = inname;
	}

	/**
	 * �ƶ�����ȡ��
	 * @return indesc  �ƶ�����
	 */
	public String getIndesc() {
		return indesc;
	}

	/**
	 * �ƶ������趨
	 * @param indesc  �ƶ�����
	 */
	public void setIndesc(String indesc) {
		this.indesc = indesc;
	}

	/**
	 * �ƶȷ���ȡ��
	 * @return intype  �ƶȷ���
	 */
	public String getIntype() {
		return intype;
	}

	/**
	 * �ƶȷ����趨
	 * @param intype  �ƶȷ���
	 */
	public void setIntype(String intype) {
		this.intype = intype;
	}


}
