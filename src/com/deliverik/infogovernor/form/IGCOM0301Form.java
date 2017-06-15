package com.deliverik.infogovernor.form;

import java.util.List;

import com.deliverik.framework.asset.model.condition.IG117SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * �ʲ���ѯHELP������FORM
 * IGCOM0301Form ActionForm
 */
public class IGCOM0301Form extends BaseForm implements IG117SearchCond{

	private static final long serialVersionUID = 1L;

	/** �ʲ�ģ��ID */
	protected int eid;
	
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
	
	/** �ʲ�ģ�ͷ���ʹ�ñ�ʶ */
	protected String enable;
	
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
	
	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public int getEid() {
		return eid;
	}


	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eid �ʲ�ģ��ID
	 */
	public void setEid(int eid) {
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
	 * �ʲ�ģ�ͷ���ʹ�ñ�ʶȡ��
	 * @return �ʲ�ģ�ͷ���ʹ�ñ�ʶ
	 */
	public String getEnable() {
		return enable;
	}


	/**
	 * �ʲ�ģ�ͷ���ʹ�ñ�ʶ�趨
	 *
	 * @param enable �ʲ�ģ�ͷ���ʹ�ñ�ʶ
	 */
	public void setEnable(String enable) {
		this.enable = enable;
	}


	public String getEparcoding() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEsyscoding() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<String> getEsyscodingList() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getSyscoding_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEparcoding_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEsyscoding_q() {
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


	public String getEstatus() {
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
    
}
