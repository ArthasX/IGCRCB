package com.deliverik.infogovernor.soc.cim.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCond;

/**
 * @Description: �ʲ�ģ����
 * @Author  
 * @History 2009-8-18     �½� 
 * @History 2010-5-07     0000428: ���ӻ������Թ���
 * @Version V2.0
 */
public class IGCIM1202Form extends BaseForm implements SOC0117SearchCond {

	private static final long serialVersionUID = 1L;
	

	
	/** ��ѯָ�������¼��� */
	protected String syscoding_q;
	
	/** entity syscoding */
	protected String esyscoding;
	
	/** entity parsyscoding */
	protected String eparcoding;
	
	protected String eparcoding_q;
	
	/** �ʲ�����ID */
	protected String eidStr;

	/** �ʲ����ͱ�� */
	protected String elabel;
	
	/** �ʲ������� */
	protected String ename;
	
	/** �ʲ����ͷ��� */
	protected String ecategory;
	
	/** �ʲ�����һ������ */
	protected String ekey1;
	
	/** �ʲ����Ͷ������� */
	protected String ekey2;
	
	/** �ʲ������������� */
	protected String ekey3;
	
	protected String esyscoding_q;
	
	protected String estatus;
	
	/** �ʲ�ģ��syscoding,igsym1201actionʹ�� */
	protected String esyscoding_tree;
	
	protected List<String> selectList;//entity����ʾʱ��Ҫ��ѯ��1����㣨��ȡֵ��Χʹ�ã�
	
	protected List<String> delList;//entity����ʾʱ��Ҫȥ����1����㣨��ȡֵ��Χʹ�ã�
	
	/** �ʲ�ģ�������Ƿ���ʾ������ʶ 0����ʾ*/
	protected String type;
	
	protected String esyscoding_nq;
	
	/**
	 * �ʲ�ģ�����0��һ���ʲ�ģ�� 1�������ʲ�ģ�ͣ�
	 */
	protected String emodeltype_eq;
	
	/** 
	 * �ʲ�ģ�Ͳ���������������<br>
	 * ��ȥ���ʲ�ģ�Ͳ������ü����ڵ�Ԫ��ģ��ƥ����ʲ�ģ����Ϣ�� 
	 */
	protected List<String> delList_q;
	
	
	
	public List<String> getDelList_q() {
		return delList_q;
	}


	public void setDelList_q(List<String> delList_q) {
		this.delList_q = delList_q;
	}
	
	public String getEsyscoding_nq() {
		return esyscoding_nq;
	}


	public void setEsyscoding_nq(String esyscoding_nq) {
		this.esyscoding_nq = esyscoding_nq;
	}
	
	public List<String> getSelectList() {
		return selectList;
	}

	public List<String> getDelList() {
		return delList;
	}

	public void setSelectList(List<String> selectList) {
		this.selectList = selectList;
	}

	public void setDelList(List<String> delList) {
		this.delList = delList;
	}

	public String getEsyscoding_tree() {
		return esyscoding_tree;
	}

	public void setEsyscoding_tree(String esyscoding_tree) {
		this.esyscoding_tree = esyscoding_tree;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getEparcoding_q() {
		return eparcoding_q;
	}

	public void setEparcoding_q(String eparcoding_q) {
		this.eparcoding_q = eparcoding_q;
	}

	public String getEsyscoding_q() {
		return esyscoding_q;
	}

	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
	}

	public String getSyscoding_q() {
		return syscoding_q;
	}

	public void setSyscoding_q(String syscoding_q) {
		this.syscoding_q = syscoding_q;
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

	public String getEidStr() {
		return eidStr;
	}

	public void setEidStr(String eidStr) {
		this.eidStr = eidStr;
	}

	public String getElabel() {
		return elabel;
	}

	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEcategory() {
		return ecategory;
	}

	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}

	public String getEkey1() {
		return ekey1;
	}

	public void setEkey1(String ekey1) {
		this.ekey1 = ekey1;
	}

	public String getEkey2() {
		return ekey2;
	}

	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}

	public String getEkey3() {
		return ekey3;
	}

	public void setEkey3(String ekey3) {
		this.ekey3 = ekey3;
	}

	public List<String> getEsyscodingList() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEparcoding_status() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEparcoding_status_start() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEcategory_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * �ʲ�ģ�����ȡ��
	 * 
	 * @return �ʲ�ģ�����0��һ���ʲ�ģ�� 1�������ʲ�ģ�ͣ�
	 */
	public String getEmodeltype_eq() {
		return emodeltype_eq;
	}

	/**
	 * �ʲ�ģ������趨
	 * @param emodeltype_eq �ʲ�ģ�����0��һ���ʲ�ģ�� 1�������ʲ�ģ�ͣ�
	 */
	public void setEmodeltype_eq(String emodeltype_eq) {
		this.emodeltype_eq = emodeltype_eq;
	}


	public String getEidStr_like() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEname_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEparcoding_neq() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
