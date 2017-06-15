/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.drm.form;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ģ������
 * </p>
 * <p>
 * Description:��ѵ��¼�Ǽ�Form
 * </p>
 * 
 * @author zhangbo@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM1702Form extends BaseForm{

	/** ���� */
	protected Integer trid;

	/** ��ѵ���� */
	protected String trname;

	/** ��ѵ�ƻ�id */
	protected Integer tpid;

	/** ��ѵ�ƻ����� */
	protected String tpname;

	/** ��ѵ���� */
	protected String tpcontent;

	/** ��ѵ��ʼʱ�� */
	protected String trstime;

	/** ��ѵ����ʱ�� */
	protected String tretime;

	/** ��ѵ�ص� */
	protected String trside;

	/** ��ʦ */
	protected String trlecturer;
	
	/** ������Ϣ */
	protected Map<Integer, FormFile> fileMap = new LinkedHashMap<Integer, FormFile>();
	
	/** ��ѵ��Ա���� */
	protected String[] tpaname;
	
	/** ��ѵ��Ա��ϵ��ʽ */
	protected String[] tpatel;
	
	/** ��ѵ��Ա���� */
	protected String[] tpaorg;
	
	/** ɾ��������Ϣ */
	protected String predelkey;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getTrid() {
		return trid;
	}

	/**
	 * �����趨
	 *
	 * @param trid ����
	 */
	public void setTrid(Integer trid) {
		this.trid = trid;
	}

	/**
	 * ��ѵ����ȡ��
	 *
	 * @return ��ѵ����
	 */
	public String getTrname() {
		return trname;
	}

	/**
	 * ��ѵ�����趨
	 *
	 * @param trname ��ѵ����
	 */
	public void setTrname(String trname) {
		this.trname = trname;
	}

	/**
	 * ��ѵ�ƻ�idȡ��
	 *
	 * @return ��ѵ�ƻ�id
	 */
	public Integer getTpid() {
		return tpid;
	}

	/**
	 * ��ѵ�ƻ�id�趨
	 *
	 * @param tpid ��ѵ�ƻ�id
	 */
	public void setTpid(Integer tpid) {
		this.tpid = tpid;
	}

	/**
	 * ��ѵ�ƻ�����ȡ��
	 *
	 * @return ��ѵ�ƻ�����
	 */
	public String getTpname() {
		return tpname;
	}

	/**
	 * ��ѵ�ƻ������趨
	 *
	 * @param tpname ��ѵ�ƻ�����
	 */
	public void setTpname(String tpname) {
		this.tpname = tpname;
	}

	/**
	 * ��ѵ����ȡ��
	 *
	 * @return ��ѵ����
	 */
	public String getTpcontent() {
		return tpcontent;
	}

	/**
	 * ��ѵ�����趨
	 *
	 * @param tpcontent ��ѵ����
	 */
	public void setTpcontent(String tpcontent) {
		this.tpcontent = tpcontent;
	}

	/**
	 * ��ѵ��ʼʱ��ȡ��
	 *
	 * @return ��ѵ��ʼʱ��
	 */
	public String getTrstime() {
		return trstime;
	}

	/**
	 * ��ѵ��ʼʱ���趨
	 *
	 * @param trstime ��ѵ��ʼʱ��
	 */
	public void setTrstime(String trstime) {
		this.trstime = trstime;
	}

	/**
	 * ��ѵ����ʱ��ȡ��
	 *
	 * @return ��ѵ����ʱ��
	 */
	public String getTretime() {
		return tretime;
	}

	/**
	 * ��ѵ����ʱ���趨
	 *
	 * @param tretime ��ѵ����ʱ��
	 */
	public void setTretime(String tretime) {
		this.tretime = tretime;
	}

	/**
	 * ��ѵ�ص�ȡ��
	 *
	 * @return ��ѵ�ص�
	 */
	public String getTrside() {
		return trside;
	}

	/**
	 * ��ѵ�ص��趨
	 *
	 * @param trside ��ѵ�ص�
	 */
	public void setTrside(String trside) {
		this.trside = trside;
	}

	/**
	 * ��ʦȡ��
	 *
	 * @return ��ʦ
	 */
	public String getTrlecturer() {
		return trlecturer;
	}

	/**
	 * ��ʦ�趨
	 *
	 * @param trlecturer ��ʦ
	 */
	public void setTrlecturer(String trlecturer) {
		this.trlecturer = trlecturer;
	}

	/**  
	 * ��ȡ������Ϣ  
	 * @return fileMap ������Ϣ  
	 */
	
	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}

	/**  
	 * ���ø�����Ϣ  
	 * @param fileMap ������Ϣ  
	 */
	
	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}

	/**  
	 * ��ȡ��ѵ��Ա����  
	 * @return tpaname ��ѵ��Ա����  
	 */
	
	public String[] getTpaname() {
		return tpaname;
	}

	/**  
	 * ������ѵ��Ա����  
	 * @param tpaname ��ѵ��Ա����  
	 */
	
	public void setTpaname(String[] tpaname) {
		this.tpaname = tpaname;
	}

	/**  
	 * ��ȡ��ѵ��Ա��ϵ��ʽ  
	 * @return tpatel ��ѵ��Ա��ϵ��ʽ  
	 */
	
	public String[] getTpatel() {
		return tpatel;
	}

	/**  
	 * ������ѵ��Ա��ϵ��ʽ  
	 * @param tpatel ��ѵ��Ա��ϵ��ʽ  
	 */
	
	public void setTpatel(String[] tpatel) {
		this.tpatel = tpatel;
	}

	/**  
	 * ��ȡ��ѵ��Ա����  
	 * @return tpaorg ��ѵ��Ա����  
	 */
	
	public String[] getTpaorg() {
		return tpaorg;
	}

	/**  
	 * ������ѵ��Ա����  
	 * @param tpaorg ��ѵ��Ա����  
	 */
	
	public void setTpaorg(String[] tpaorg) {
		this.tpaorg = tpaorg;
	}
	
	/**
	 * ������Ϣ����
	 * @param index ��������
	 * @param file ������Ϣ
	 */
	public void setAttachFile(int index,FormFile file){
		fileMap.put(new Integer(index), file);
	}

	/**  
	 * ��ȡɾ��������Ϣ  
	 * @return predelkey ɾ��������Ϣ  
	 */
	
	public String getPredelkey() {
		return predelkey;
	}

	/**  
	 * ����ɾ��������Ϣ  
	 * @param predelkey ɾ��������Ϣ  
	 */
	
	public void setPredelkey(String predelkey) {
		this.predelkey = predelkey;
	}
}
