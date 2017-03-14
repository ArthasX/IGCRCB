package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.SOC0117Info;

/**
 * �ʲ�ģ�ͻ�����Ϣ�༭����FORM
 * 
 */
public class IGASM0102Form extends BaseForm implements SOC0117Info{

	private static final long serialVersionUID = 1L;

	/** �ʲ�ģ��ID */
	protected String eid;
	
	/** �ʲ�ģ��ID�����֣� */
	protected String eidStr;
	
	/** �ʲ�ģ���� */
	protected String ename;
	
	/** �ʲ�ģ�ͱ�� */
	protected String elabel;

	/** �ʲ�ģ��˵�� */
	protected String edesc;

	/** �ʲ�ģ��״̬ */
	protected String estatus;

	/** �ʲ�ģ�ͷ��� */
	protected String ecategory;
	
	/** �ʲ�ģ��һ������ */
	protected String ekey1;
	
	/** �ʲ�ģ�Ͷ������� */
	protected String ekey2;
	
	/** �ʲ�ģ���������� */
	protected String ekey3;

	/** �༭ģʽ���Ǽ�/����� */
	protected String mode = "0";

	protected String esyscoding;
	
	protected String eparcoding;
	
	protected String eparname;
	
	protected String fingerPrint;
	
	/**
	 * �ʲ�ģ�����0��һ���ʲ�ģ�� 1�������ʲ�ģ�ͣ�
	 */
	protected String emodeltype;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEparcoding() {
		return eparcoding;
	}

	public void setEparcoding(String eparcoding) {
		this.eparcoding = eparcoding;
	}

	public String getEparname() {
		return eparname;
	}

	public void setEparname(String eparname) {
		this.eparname = eparname;
	}

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid() {
		if( (this.eidStr == null) || (this.eidStr.equals(""))){
			return null;
		} else {
			return this.eidStr;
		}
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
	 * �ʲ�ģ��ID�����֣�ȡ��
	 * @return �ʲ�ģ��ID�����֣�
	 */
	public String getEidStr() {
		return eidStr;
	}

	/**
	 * �ʲ�ģ��ID�����֣��趨
	 *
	 * @param eidStr �ʲ�ģ��ID�����֣�
	 */
	public void setEidStr(String eidStr) {
		this.eidStr = eidStr;
	}

	/**
	 * �ʲ�ģ����ȡ��
	 * @return �ʲ�ģ����
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * �ʲ�ģ�����趨
	 *
	 * @param ename �ʲ�ģ����
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * �ʲ�ģ�ͷ���ȡ��
	 * @return �ʲ�ģ�ͷ���
	 */
	public String getEcategory() {
		return ecategory;
	}


	/**
	 * �ʲ�ģ�ͷ����趨
	 *
	 * @param ecategory �ʲ�ģ�ͷ���
	 */
	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}


	/**
	 * �ʲ�ģ��һ������ȡ��
	 * @return �ʲ�ģ��һ������
	 */
	public String getEkey1() {
		return ekey1;
	}


	/**
	 * �ʲ�ģ��һ�������趨
	 *
	 * @param ekey1 �ʲ�ģ��һ������
	 */
	public void setEkey1(String ekey1) {
		this.ekey1 = ekey1;
	}

	/**
	 * �ʲ�ģ�Ͷ�������ȡ��
	 * @return �ʲ�ģ�Ͷ�������
	 */
	public String getEkey2() {
		return ekey2;
	}


	/**
	 * �ʲ�ģ�Ͷ��������趨
	 *
	 * @param ekey2 �ʲ�ģ�Ͷ�������
	 */
	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}


	/**
	 * �ʲ�ģ����������ȡ��
	 * @return �ʲ�ģ����������
	 */
	public String getEkey3() {
		return ekey3;
	}


	/**
	 * �ʲ�ģ�����������趨
	 *
	 * @param ekey3 �ʲ�ģ����������
	 */
	public void setEkey3(String ekey3) {
		this.ekey3 = ekey3;
	}

	/**
	 * �ʲ�ģ�ͱ��ȡ��
	 * @return �ʲ�ģ�ͱ��
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * �ʲ�ģ�ͱ���趨
	 *
	 * @param elabel �ʲ�ģ�ͱ��
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}


	/**
	 * �ʲ�ģ��˵��ȡ��
	 * @return �ʲ�ģ��˵��
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
	 * �ʲ�ģ��״̬ȡ��
	 * @return �ʲ�ģ��״̬
	 */
	public String getEstatus() {
		return estatus;
	}


	/**
	 * �ʲ�ģ��״̬�趨
	 *
	 * @param estatus �ʲ�ģ��״̬
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}


	/**
	 * �༭ģʽȡ��
	 * @return �༭ģʽ
	 */
	public String getMode() {
		return mode;
	}


	/**
	 * �༭ģʽ�趨
	 *
	 * @param mode �༭ģʽ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * �ʲ�ģ�����ȡ��
	 * @return �ʲ�ģ�����
	 */
	public String getEmodeltype() {
		return emodeltype;
	}
	
	/**
	 * �ʲ�ģ������趨
	 *
	 * @param eparcoding �ʲ�ģ�����
	 */
	public void setEmodeltype(String emodeltype) {
		this.emodeltype = emodeltype;
	}

}
