package com.deliverik.infogovernor.drm.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseForm;

/**
 * ������������Ϣ��ϸ����FORM
 * 
 */
@SuppressWarnings("serial")
public class IGDRM0424Form extends BaseForm {

	/** �ʲ�ģ��ID */
	protected String eid;

	/** �ʲ�����ID */
	protected String[] cid;

	/** ����������ֵ */
	protected String[] cvalue;
	
	/** ���������ø��� */
	protected String[] ciattach;
	
	/** �ʲ�ģ����������ֵ */
	protected String[] entityItemCvalue;
	
	/** ģ�Ͳ���� */
	protected String esyscoding;
	
	/** ���������ø������� */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** ȡֵ��Χ�������� */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	
	/** ɾ��������ʶ */
	protected String[] delfile;
	
	/** �ʲ�ģ������ */
	protected String ename;
	
	/** �ʲ�ģ��˵�� */
	protected String edesc;
	
	/**
	 * �ʲ�ģ��˵��ȡ��
	 *
	 * @return edesc �ʲ�ģ��˵��
	 */
	
	public String getEdesc() {
		return edesc;
	}


	/**
	 * �ʲ�ģ��˵���趨
	 *
	 * @param edesc �ʲ�ģ��˵��
	 */
	
	public void setEdesc(String edesc) {
		this.edesc = edesc;
	}


	/**
	 * �ʲ�ģ������ȡ��
	 *
	 * @return ename �ʲ�ģ������
	 */
	
	public String getEname() {
		return ename;
	}


	/**
	 * �ʲ�ģ�������趨
	 *
	 * @param ename �ʲ�ģ������
	 */
	
	public void setEname(String ename) {
		this.ename = ename;
	}


	/**
	 * ɾ��������ʶȡ��
	 *
	 * @return delfile ɾ��������ʶ
	 */
	
	public String[] getDelfile() {
		return delfile;
	}


	/**
	 * ɾ��������ʶ�趨
	 *
	 * @param delfile ɾ��������ʶ
	 */
	
	public void setDelfile(String[] delfile) {
		this.delfile = delfile;
	}


	/**
	 * ����������ֵȡ��
	 * @return ����������ֵ
	 */
	public String[] getCvalue() {
		return cvalue;
	}


	/**
	 * ����������ֵ�趨
	 *
	 * @param cvalue ����������ֵ
	 */
	public void setCvalue(String[] cvalue) {
		this.cvalue = cvalue;
	}


	/**
	 * ������IDȡ��
	 * @return ������ID
	 */
	public String getEid() {
		return eid;
	}


	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eid �ʲ�ģ��ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}


	/**
	 * �ʲ�����IDȡ��
	 * @return �ʲ�����ID
	 */
	public String[] getCid() {
		return cid;
	}


	/**
	 * �ʲ�����ID�趨
	 *
	 * @param cid �ʲ�����ID
	 */
	public void setCid(String[] cid) {
		this.cid = cid;
	}


	/**
	 * ���������ø�������ȡ��
	 * @return ���������ø�������
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}


	/**
	 * ���������ø�������
	 *
	 * @param index ���������ø�����������
	 * @param file ���������ø�������
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}


	/**
	 * ���������ø���ȡ��
	 * @return ���������ø���
	 */
	public String[] getCiattach() {
		return ciattach;
	}


	/**
	 * ���������ø���
	 *
	 * @param ciattach ���������ø���
	 */
	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}

	/**
	 * ȡֵ��Χ��������ȡ��
	 * @return ȡֵ��Χ��������
	 */
	public List<LabelValueBean> getSelectedListMap(int index) {
		return (List<LabelValueBean>) selectedListMap.get( new Integer( index ) );
	}

	/**
	 * ȡֵ��Χ���������趨
	 *
	 * @param selectedList ȡֵ��Χ��������
	 */
	public void setSelectedListMap(int index,List<LabelValueBean> selectedList) {
		selectedListMap.put(new Integer(index), selectedList);
	}

	/**
	 * ȡֵ��Χ��������ȡ��
	 * @return ȡֵ��Χ��������
	 */
	public Map<Integer, List<LabelValueBean>> getSelectedListMap() {
		return selectedListMap;
	}
	/**
	 * �ʲ�ģ����������ֵȡ��
	 * @return �ʲ�ģ����������ֵ
	 */
	public String[] getEntityItemCvalue() {
		return entityItemCvalue;
	}

	/**
	 * �ʲ�ģ����������ֵ�趨
	 *
	 * @param entityItemCvalue �ʲ�ģ����������ֵ
	 */
	public void setEntityItemCvalue(String[] entityItemCvalue) {
		this.entityItemCvalue = entityItemCvalue;
	}

	/**
	 * ģ�Ͳ����ȡ��
	 * 
	 * @return ģ�Ͳ����
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * ģ�Ͳ�����趨
	 * 
	 * @param esyscoding ģ�Ͳ����
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
}
