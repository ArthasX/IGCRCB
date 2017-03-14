/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.sdl.form;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sdl.model.SdlInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_��Ϣ����Form
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL0402Form extends BaseForm implements SdlInfo{
	
	/**����*/
	protected Integer siid;
	/**���*/
	protected String sitype;
	/**˵��*/
	protected String sidesc;
	/**��ʼʱ��*/
	protected String sibegin;
	/**����ʱ��*/
	protected String siend;
	/**����*/
	protected Integer simark;
	/**����ʲ�ID*/
	protected Integer sieiid;
	/**����ʲ�����*/
	protected String sieiname;
	/**����¼�����ID*/
	protected Integer siprid;
	/**����¼���������*/
	protected String siprtitle;
	/**����*/
	protected String siattkey;
	/**�Ǽ�����*/
	protected String sidate;
	/** �༭ģʽ*/
	protected String mode = "0";
	/**ʵ��ʱ��*/
	protected Integer sifacttime;
	
	/** ���� */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();

	/**
	 * ��ȡ����
	 * @return ����
	 */
	public Integer getSiid() {
		if(siid != null && siid != 0){
			return siid;
		}else{
			return null;
		}
	}

	/**
	 * ��������
	 * @param siid ����
	 */
	public void setSiid(Integer siid) {
		this.siid = siid;
	}

	/**
	 * ��ȡ���
	 * @return ���
	 */
	public String getSitype() {
		return sitype;
	}

	/**
	 * �������
	 * @param sitype ���
	 */
	
	public void setSitype(String sitype) {
		this.sitype = sitype;
	}

	/**
	 * ��ȡ˵��
	 * @return ˵��
	 */
	public String getSidesc() {
		return sidesc;
	}

	/**
	 * ����˵��
	 * @param sidesc ˵��
	 */
	public void setSidesc(String sidesc) {
		this.sidesc = sidesc;
	}

	/**
	 * ��ȡ��ʼʱ��
	 * @return ��ʼʱ��
	 */
	public String getSibegin() {
		return sibegin;
	}

	/**
	 * ���ÿ�ʼʱ��
	 * @param sibegin ��ʼʱ��
	 */
	public void setSibegin(String sibegin) {
		this.sibegin = sibegin;
	}

	/**
	 * ��ȡ����ʱ��
	 * @return ����ʱ��
	 */
	public String getSiend() {
		return siend;
	}

	/**
	 * ���ý���ʱ��
	 * @param siend ����ʱ��
	 */
	public void setSiend(String siend) {
		this.siend = siend;
	}

	/**
	 * ��ȡ����
	 * @return ����
	 */
	public Integer getSimark() {
		return simark;
	}

	/**
	 * ��������
	 * @param simark ����
	 */
	public void setSimark(Integer simark) {
		this.simark = simark;
	}

	/**
	 * ��ȡ����ʲ�ID
	 * @return ����ʲ�ID
	 */
	public Integer getSieiid() {
		if(sieiid != null && sieiid != 0){
			return sieiid;
		}else{
			return null;
		}
	}

	/**
	 * ��������ʲ�ID
	 * @param sieiid ����ʲ�ID
	 */
	public void setSieiid(Integer sieiid) {
		this.sieiid = sieiid;
	}

	/**
	 * ��ȡ����ʲ�����
	 * @return ����ʲ�����
	 */
	public String getSieiname() {
		return sieiname;
	}

	/**
	 * ��������ʲ�����
	 * @param sieiname ����ʲ�����
	 */
	public void setSieiname(String sieiname) {
		this.sieiname = sieiname;
	}

	/**
	 * ��ȡ�������ID
	 * @return �������ID
	 */
	public Integer getSiprid() {
		if(siprid != null && siprid != 0){
			return siprid;
		}else{
			return null;
		}
	}

	/**
	 * �����������ID
	 * @param siprid �������ID
	 */
	public void setSiprid(Integer siprid) {
		this.siprid = siprid;
	}

	/**
	 * ��ȡ�����������
	 * @return �����������
	 */
	public String getSiprtitle() {
		return siprtitle;
	}

	/**
	 * ���������������
	 * @param siprtitle �����������
	 */
	public void setSiprtitle(String siprtitle) {
		this.siprtitle = siprtitle;
	}
	/**
	 * ��ȡ����
	 * @return ����
	 */
	public String getSiattkey() {
		return siattkey;
	}

	/**
	 * ���ø���
	 * @param siattkey ����
	 */
	public void setSiattkey(String siattkey) {
		this.siattkey = siattkey;
	}
	/**
	 * ��ȡ�Ǽ�����
	 * @return �Ǽ�����
	 */
	public String getSidate() {
		return sidate;
	}

	/**
	 * ���õǼ�����
	 * @param sidate �Ǽ�����
	 */
	public void setSidate(String sidate) {
		this.sidate = sidate;
	}
	
	/**
	 * ��ȡ�༭ģʽ
	 * @return �༭ģʽ
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * ���ñ༭ģʽ
	 * @param mode �༭ģʽ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * ��ȡʵ��ʱ��
	 * @return ʵ��ʱ��
	 */
	public Integer getSifacttime() {
		return sifacttime;
	}

	/**
	 * ����ʵ��ʱ��
	 * @param sidate ʵ��ʱ��
	 */
	public void setSifacttime(Integer sifacttime) {
		this.sifacttime = sifacttime;
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
	 * ��ȡ����Map
	 * @return ����Map
	 */
	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
}
