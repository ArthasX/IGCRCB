/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.form;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:�����������Form 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC0402Form extends BaseForm{
	
	/** ����ID���� */
	protected Integer[] prid;
	
	/** ������� */
	protected String rlcomment;
	
	/** ���̶���ID */
	protected String pdid;
	
	/** ����״̬�� */
	protected String prstatus;
	
	/** ������ */
	protected String[] pivarnames;
	
	/** ��ֵ */
	protected String[] pivarvalues;
	
	/** ���� */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** ��ת��ʶ */
	protected String forward = "DISP";
	
	/** ��ť���� */
	protected String buttonName;
	
	/** ��ť��ʶ */
	protected String buttonCode;
	
	/** ״̬��ʾ��*/
	protected String statusCode;

	/**
	 * ����ID����ȡ��
	 * @return prid ����ID����
	 */
	public Integer[] getPrid() {
		return prid;
	}

	/**
	 * ����ID�����趨
	 * @param prid ����ID����
	 */
	public void setPrid(Integer[] prid) {
		this.prid = prid;
	}

	/**
	 * �������ȡ��
	 * @return rlcomment �������
	 */
	public String getRlcomment() {
		return rlcomment;
	}

	/**
	 * ��������趨
	 * @param rlcomment �������
	 */
	public void setRlcomment(String rlcomment) {
		this.rlcomment = rlcomment;
	}

	/**
	 * ���̶���IDȡ��
	 * @return pdid ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����״̬��ȡ��
	 * @return prstatus ����״̬��
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ����״̬���趨
	 * @param prstatus ����״̬��
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
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

	/**
	 * ����ȡ��
	 * @return fileMap ����
	 */
	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}

	/**
	 * �����趨
	 * @param fileMap ����
	 */
	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}

	/**
	 * ������ȡ��
	 * @return pivarnames ������
	 */
	public String[] getPivarnames() {
		return pivarnames;
	}

	/**
	 * �������趨
	 * @param pivarnames ������
	 */
	public void setPivarnames(String[] pivarnames) {
		this.pivarnames = pivarnames;
	}

	/**
	 * ��ֵȡ��
	 * @return pivarvalues ��ֵ
	 */
	public String[] getPivarvalues() {
		return pivarvalues;
	}

	/**
	 * ��ֵ�趨
	 * @param pivarvalues ��ֵ
	 */
	public void setPivarvalues(String[] pivarvalues) {
		this.pivarvalues = pivarvalues;
	}

	/**
	 * ��ת��ʶȡ��
	 * @return forward ��ת��ʶ
	 */
	public String getForward() {
		return forward;
	}

	/**
	 * ��ת��ʶ�趨
	 * @param forward ��ת��ʶ
	 */
	public void setForward(String forward) {
		this.forward = forward;
	}

	/**
	 * ��ť����ȡ��
	 * @return buttonName ��ť����
	 */
	public String getButtonName() {
		return buttonName;
	}

	/**
	 * ��ť�����趨
	 * @param buttonName ��ť����
	 */
	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

	/**
	 * ��ť��ʶȡ��
	 * @return buttonCode ��ť��ʶ
	 */
	public String getButtonCode() {
		return buttonCode;
	}

	/**
	 * ��ť��ʶ�趨
	 * @param buttonCode ��ť��ʶ
	 */
	public void setButtonCode(String buttonCode) {
		this.buttonCode = buttonCode;
	}

	/**
	 * ״̬��ʾ����ȡ
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * ״̬��ʾ���趨
	 * @param statusCode
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
}
