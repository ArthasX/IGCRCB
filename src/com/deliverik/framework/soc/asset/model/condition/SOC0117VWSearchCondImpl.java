/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
  * ����: SOC0117VW��������ʵ��
  * ��������: SOC0117VW��������ʵ��
  * ������¼: 2016/06/21
  * �޸ļ�¼: 
  */
public class SOC0117VWSearchCondImpl implements
		SOC0117VWSearchCond {
	/**
	 * ���ݿ�id
	 */
	private Integer id;
	/** 
	 * �ʲ�ģ��ID 
	 */
	protected String eidStr;

	/** 
	 * �ʲ�ģ��ID like
	 */
	protected String eidStr_like;

	/** 
	 * �ʲ�ģ�ͱ�� 
	 */
	protected String elabel;
	
	/** 
	 * �ʲ�ģ������
	 */
	protected String ename;
	
	/** 
	 * �ʲ�ģ�ͷ��� 
	 */
	protected String ecategory_q;
	
	/** 
	 * �ʲ�ģ�ͷ��ࣨƽ̨������ 
	 */
	protected String ecategory;

	/** 
	 * �ʲ�ģ��һ�����ࣨƽ̨������ 
	 */
	protected String ekey1;
	
	/** 
	 * �ʲ�ģ�Ͷ������ࣨƽ̨������
	 */
	protected String ekey2;
	
	/** 
	 * �ʲ�ģ���������ࣨƽ̨������
	 */
	protected String ekey3;
	
	/** 
	 * �ʲ�ģ�Ͳ����ǰ��һ��ģ��ƥ��������� 
	 */
	protected String syscoding_q;
	
	/** 
	 * �ʲ�ģ�Ͳ���� 
	 */
	protected String esyscoding;
	
	/** 
	 * �ʲ�ģ�͸�������루ƽ̨������
	 */
	protected String eparcoding;
	
	/** 
	 * �ʲ�ģ�Ͳ����ǰ��һ��ģ��ƥ�����������like��
	 */
	protected String esyscoding_q;
	
	/** 
	 * �ʲ�ģ�Ͳ����ǰ��һ��ģ��ƥ�����������not like��
	 */
	protected String esyscoding_nq;
	
	/** 
	 * �ʲ�ģ�͸��������������� 
	 */
	protected String eparcoding_q;
	
	/** 
	 * �ʲ�ģ�͵�״̬ 
	 */
	protected String estatus;
	
	/** 
	 * �ʲ�ģ�Ͳ���������������<br>
	 * ��ȥ���ʲ�ģ�Ͳ������ü����ڵ�Ԫ��ģ��ƥ����ʲ�ģ����Ϣ�� 
	 */
	protected List<String> delList_q;
	
	/** 
	 * �ʲ�ģ�͸�����������������ƽ̨������
	 */
	protected String eparcoding_status;
	
	/** 
	 * �ʲ�ģ�Ͳ�������������ƽ̨������ 
	 */
	protected String eparcoding_status_start;
	
	/** 
	 * �ʲ�ģ�Ͳ���븨������������ƽ̨������<br>
	 *     ���������Բ�Ϊ�գ�eparcoding����Ϊ��ʱ��ȫƥ���ʲ�ģ�Ͳ���롣
	 *        ��������Ϊ�գ�eparcoding���Բ�Ϊ��ʱ��ȫƥ���ʲ�ģ�͵��ϼ�ģ�Ͳ���롣��
	 */
	protected String esyscoding_tree;//�ʲ�ģ��syscoding,igsym1201actionʹ��
	
	/** 
	 * �ʲ�ģ�Ͳ�����������������ƽ̨������<br>
	 *    �������ʲ�ģ�Ͳ������ü����ڵ�Ԫ����ȫƥ����ʲ�ģ����Ϣ�� 
	 */
	protected List<String> esyscodingList;
	
	/** 
	 * �ʲ�ģ�Ͳ�����������������ƽ̨������<br>
	 *    �������ʲ�ģ�Ͳ������ü����ڵ�Ԫ����ȫƥ����ʲ�ģ����Ϣ�� 
	 */
	protected List<String> selectList;//entity����ʾʱ��Ҫ������1����㣨��ȡֵ��Χʹ�ã�
	
	/** 
	 * �ʲ�ģ�Ͳ�����������������ƽ̨������<br>
	 * �������ʲ�ģ�Ͳ������ü����ڵ�Ԫ�ز���ȫƥ����ʲ�ģ����Ϣ�� 
	 */
	protected List<String> delList;//entity����ʾʱ��Ҫȥ����1����㣨��ȡֵ��Χʹ�ã�
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * �ʲ�ģ�Ͳ���������������ȡ��
	 * @return ȥ���ʲ�ģ�Ͳ������ü����ڵ�Ԫ��ģ��ƥ����ʲ�ģ����Ϣ
	 */
	public List<String> getDelList_q() {
		return delList_q;
	}

	/**
	 * �ʲ�ģ�Ͳ����������������趨
	 *
	 * @param delList_q ȥ���ʲ�ģ�Ͳ������ü����ڵ�Ԫ��ģ��ƥ����ʲ�ģ����Ϣ
	 */
	public void setDelList_q(List<String> delList_q) {
		this.delList_q = delList_q;
	}

	/**
	 * �ʲ�ģ�Ͳ����ǰ��һ��ģ��ƥ�����������not like��ȡ��
	 * @return �ʲ�ģ�Ͳ����ǰ��һ��ģ��ƥ�����������not like��
	 */
	public String getEsyscoding_nq() {
		return esyscoding_nq;
	}

	/**
	 * �ʲ�ģ�Ͳ����ǰ��һ��ģ��ƥ�����������not like���趨
	 *
	 * @param esyscoding_nq �ʲ�ģ�Ͳ����ǰ��һ��ģ��ƥ�����������not like��
	 */
	public void setEsyscoding_nq(String esyscoding_nq) {
		this.esyscoding_nq = esyscoding_nq;
	}

	
	/**
	 * �ʲ�ģ�ͷ���ȡ��
	 * @return �ʲ�ģ�ͷ���
	 */
	public String getEcategory_q() {
		return ecategory_q;
	}

	/**
	 * �ʲ�ģ�ͷ����趨
	 *
	 * @param ecategory_q �ʲ�ģ�ͷ���
	 */
	public void setEcategory_q(String ecategory_q) {
		this.ecategory_q = ecategory_q;
	}

	/**
	 * �ʲ�ģ�Ͳ���������������ȡ��
	 * @return �ʲ�ģ�Ͳ���������������
	 */
	public List<String> getDelList() {
		return delList;
	}

	/**
	 * �ʲ�ģ�Ͳ����������������趨
	 * 
	 * @param delList �ʲ�ģ�Ͳ���������������
	 * �������ʲ�ģ�Ͳ������ü����ڵ�Ԫ�ز���ȫƥ����ʲ�ģ����Ϣ�� 
	 */
	public void setDelList(List<String> delList) {
		this.delList = delList;
	}

	/**
	 * �ʲ�ģ�Ͳ���������������ȡ��
	 * @return �ʲ�ģ�Ͳ���������������
	 */
	public List<String> getSelectList() {
		return selectList;
	}

	/**
	 * �ʲ�ģ�Ͳ����������������趨
	 *
	 * @param selectList �ʲ�ģ�Ͳ���������������
	 * �������ʲ�ģ�Ͳ������ü����ڵ�Ԫ����ȫƥ����ʲ�ģ����Ϣ�� 
	 */
	public void setSelectList(List<String> selectList) {
		this.selectList = selectList;
	}
	
	/**
	 * �ʲ�ģ�Ͳ���븨����������ȡ��
	 * @return �ʲ�ģ�Ͳ���븨����������
	 */
	public String getEsyscoding_tree() {
		return esyscoding_tree;
	}

	/**
	 * �ʲ�ģ�Ͳ���븨�����������趨
	 *
	 * @param esyscoding_tree �ʲ�ģ�Ͳ���븨����������
	 * ���������Բ�Ϊ�գ�eparcoding����Ϊ��ʱ��ȫƥ���ʲ�ģ�Ͳ���롣
	 *   ��������Ϊ�գ�eparcoding���Բ�Ϊ��ʱ��ȫƥ���ʲ�ģ�͵��ϼ�ģ�Ͳ���룩
	 */
	public void setEsyscoding_tree(String esyscoding_tree) {
		this.esyscoding_tree = esyscoding_tree;
	}

	/**
	 * �ʲ�ģ�Ͳ�����������ȡ��
	 * @return �ʲ�ģ�Ͳ�����������
	 */
	public String getEparcoding_status_start() {
		return eparcoding_status_start;
	}

	/**
	 * �ʲ�ģ�Ͳ������������趨
	 *
	 * @param eparcoding_status_start �ʲ�ģ�Ͳ�����������
	 */
	public void setEparcoding_status_start(String eparcoding_status_start) {
		this.eparcoding_status_start = eparcoding_status_start;
	}

	/**
	 * �ʲ�ģ�͸���������������ȡ��
	 * @return �ʲ�ģ�͸���������������
	 */
	public String getEparcoding_status() {
		return eparcoding_status;
	}

	/**
	 * �ʲ�ģ�͸����������������趨
	 *
	 * @param eparcoding_status �ʲ�ģ�͸���������������
	 */
	public void setEparcoding_status(String eparcoding_status) {
		this.eparcoding_status = eparcoding_status;
	}

	/**
	 * �ʲ�ģ�͵�״̬ȡ��
	 * @return �ʲ�ģ�͵�״̬
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * �ʲ�ģ�͵�״̬�趨
	 *
	 * @param estatus �ʲ�ģ�͵�״̬
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * �ʲ�ģ�͸���������������ȡ��
	 * @return �ʲ�ģ�͸���������������
	 */
	public String getEparcoding_q() {
		return eparcoding_q;
	}

	/**
	 * �ʲ�ģ�͸����������������趨
	 *
	 * @param eparcoding_q �ʲ�ģ�͸���������������
	 */
	public void setEparcoding_q(String eparcoding_q) {
		this.eparcoding_q = eparcoding_q;
	}

	/**
	 * �ʲ�ģ�͸��������ǰ��һ��ģ��ƥ���������ȡ��
	 * @return �ʲ�ģ�͸��������ǰ��һ��ģ��ƥ���������
	 */
	public String getEsyscoding_q() {
		return esyscoding_q;
	}

	/**
	 * �ʲ�ģ�͸��������ǰ��һ��ģ��ƥ����������趨
	 *
	 * @param esyscoding_q �ʲ�ģ�͸��������ǰ��һ��ģ��ƥ���������
	 */
	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
	}

	/**
	 * �ʲ�ģ�Ͳ����ǰ��һ��ģ��ƥ���������ȡ��
	 * @return �ʲ�ģ�Ͳ����ǰ��һ��ģ��ƥ���������
	 */
	public String getSyscoding_q() {
		return syscoding_q;
	}

	/**
	 * �ʲ�ģ�Ͳ����ǰ��һ��ģ��ƥ����������趨
	 *
	 * @param syscoding_q �ʲ�ģ�Ͳ����ǰ��һ��ģ��ƥ���������
	 */
	public void setSyscoding_q(String syscoding_q) {
		this.syscoding_q = syscoding_q;
	}

	/**
	 * �ʲ�ģ�Ͳ����ȡ��
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ�ģ�Ͳ�����趨
	 *
	 * @param eparcoding �ʲ�ģ�Ͳ����
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	
	/**
	 * �ʲ�ģ�͸��������ȡ��
	 * @return �ʲ�ģ�͸��������
	 */
	public String getEparcoding() {
		return eparcoding;
	}
	/**
	 * �ʲ�ģ�͸���������趨
	 *
	 * @param eparcoding �ʲ�ģ�͸��������
	 */
	public void setEparcoding(String eparcoding) {
		this.eparcoding = eparcoding;
	}

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEidStr() {
		return eidStr;
	}

	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eidStr �ʲ�ģ��ID
	 */
	public void setEidStr(String eidStr) {
		this.eidStr = eidStr;
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
	 * �ʲ�ģ������ȡ��
	 * @return �ʲ�ģ������
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
	 * �ʲ�ģ�Ͳ���������������ȡ�� 
	 * @return �ʲ�ģ�Ͳ���������������
	 */
	public List<String> getEsyscodingList() {
		return esyscodingList;
	}


	/**
	 * �ʲ�ģ�Ͳ����������������趨
	 * @param esyscodingList �ʲ�ģ�Ͳ��������
	 * �������ʲ�ģ�Ͳ������ü����ڵ�Ԫ����ȫƥ����ʲ�ģ����Ϣ��
	 */
	public void setEsyscodingList(List<String> esyscodingList) {
		this.esyscodingList = esyscodingList;
	}

	/**
	 * �ʲ�ģ��ID likeȡ��
	 * @return �ʲ�ģ��ID like
	 */
	public String getEidStr_like() {
		return eidStr_like;
	}

	/**
	 * �ʲ�ģ��ID like�趨
	 * @param eidStr_like �ʲ�ģ��ID like
	 */
	public void setEidStr_like(String eidStr_like) {
		this.eidStr_like = eidStr_like;
	}
}