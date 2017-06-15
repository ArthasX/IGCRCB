package com.deliverik.infogovernor.soc.cim.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCond;

/**
 * �ʲ�ģ�Ͳ�ѯ����FORM
 * 
 */
public class IGCIM0401Form extends BaseForm implements SOC0117SearchCond{

	private static final long serialVersionUID = 1L;

	/** �ʲ�ģ��ID */
	protected String eid;
	
	/** �ʲ�ģ��ID�����֣� */
	protected String eidStr;
	
	/** �ʲ�ģ�ͱ�� */
	protected String elabel;
	
	/** �ʲ�ģ���� */
	protected String ename;
	
	/** �ʲ�ģ�ͷ��� */
	protected String ecategory;
	
	/** �ʲ�ģ��һ������ */
	protected String ekey1;
	
	/** �ʲ�ģ�Ͷ������� */
	protected String ekey2;
	
	/** �ʲ�ģ���������� */
	protected String ekey3;
	
	/** ɾ�������ʲ�ģ��ID */
	protected String[] deleteEid;
	
	protected String esyscoding;
	
	protected String eparcoding;
	
	protected String eparname;
	
	protected String esyscoding_q;
	
	protected String eparcoding_q;
	
	/** �ʲ�ģ��״̬ 1���� 0ͣ�� */
	protected String estatus;
	
	protected String eparcoding_status;

	protected String eparcoding_status_start;
	
	protected String esyscoding_nq;
	
	/** 
	 * �ʲ�ģ�Ͳ���������������<br>
	 * ��ȥ���ʲ�ģ�Ͳ������ü����ڵ�Ԫ��ģ��ƥ����ʲ�ģ����Ϣ�� 
	 */
	protected List<String> delList_q;

    private String type;
	
	
	
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


	public String getEparcoding_status_start() {
		return eparcoding_status_start;
	}


	public void setEparcoding_status_start(String eparcoding_status_start) {
		this.eparcoding_status_start = eparcoding_status_start;
	}


	public String getEparcoding_status() {
		return eparcoding_status;
	}


	public void setEparcoding_status(String eparcoding_status) {
		this.eparcoding_status = eparcoding_status;
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
	 * ɾ�������ʲ�ģ��IDȡ��
	 * @return ɾ�������ʲ�ģ��ID
	 */
	public String[] getDeleteEid() {
		return deleteEid;
	}


	/**
	 * ɾ�������ʲ�ģ��ID�趨
	 *
	 * @param deleteEid ɾ�������ʲ�ģ��ID
	 */
	public void setDeleteEid(String[] deleteEid) {
		this.deleteEid = deleteEid;
	}


	/**
	 * ��ʼ������
	 *
	 * @param mapping 
	 * @param request 
	 */
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.deleteEid = null;
	}


	public List<String> getEsyscodingList() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getSyscoding_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEsyscoding_tree() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<String> getDelList() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<String> getSelectList() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEcategory_q() {
		// TODO Auto-generated method stub
		return null;
	}


    /* (non-Javadoc)
     * @see com.deliverik.framework.asset.model.condition.IG117SearchCond#getType()
     */
    public String getType() {
        // TODO Auto-generated method stub
        return type;
    }


    /**
     * type is set.
     * @param type type
     */
    public void setType(String type) {
        this.type = type;
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
