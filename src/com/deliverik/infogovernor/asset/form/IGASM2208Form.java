/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.form;

import java.util.List;

import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * ����: �豸��ѯ����Form
 * ��������: �豸��ѯ����Form
 * ������¼: 2011/05/19
 * �޸ļ�¼: 
 */
public class IGASM2208Form extends BaseForm implements IG688SearchCond{
	private static final long serialVersionUID = 1L;
	
	/** �ʲ���������������*/
	public String eiorgname;
	
	/**
     * ��ѯ��ʶ
     */
    private String queryflag;
	
	/** �ʲ�ʹ�û�������*/
	public String useorgname;
	
	/** �ʲ�ģ���� */
	protected String ename;
	
	/** �豸���� */
	protected String einame;
	
	/** ��ʼʱ�� */
	protected String eiupdtime_from;
	
	/** ����ʱ�� */
	protected String eiupdtime_to;
	
	/** �ʲ�����������*/
	public String eiorgsyscoding;
	
	/** �ʲ�������ģ��*/
	public String esyscoding;
	
	/** �ʲ�ʹ�û���code*/
	public String usesyscoding;
	
	/** �ʲ�ģ�ͷ��� */
	protected String ecategory;
	
	/** �豸ID */
	protected String eiid;
	
	/** Ȩ�ޱ�ʶID */
	protected boolean flag;
	
	private String eidesc_like;
	/** 
	 * �ʲ�ģ�͵�״̬ 
	 */
	protected String estatus;
	
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
	 * Ȩ�ޱ�ʶȡ��
	 * @return Ȩ�ޱ�ʶ
	 */
	public Boolean getFlag() {
		return flag;
	}

	/**
	 * Ȩ�ޱ�ʶ�趨
	 *
	 * @param flag Ȩ�ޱ�ʶ
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	/**
	 * �豸IDȡ��
	 * @return �豸ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �豸ID�趨
	 * @param eiid�豸ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * �ʲ���������������ȡ��
	 * @return �ʲ���������������
	 */
	public String getEiorgname() {
		return eiorgname;
	}

	/**
	 * �ʲ����������������趨
	 * @param eiorgname�ʲ���������������
	 */
	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	/**
	 * �ʲ�ʹ�û�������ȡ��
	 * @return �ʲ�ʹ�û�������
	 */
	public String getUseorgname() {
		return useorgname;
	}

	/**
	 * �ʲ�ʹ�û��������趨
	 * @param useorgname�ʲ�ʹ�û�������
	 */
	public void setUseorgname(String useorgname) {
		this.useorgname = useorgname;
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
	 * @param ename�ʲ�ģ����
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * �豸����ȡ��
	 * @return �豸����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * �豸�����趨
	 * @param einame�豸����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ��ʼʱ��ȡ��
	 * @return ��ʼʱ��
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	/**
	 * ��ʼʱ���趨
	 * @param eiupdtime_from��ʼʱ��
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	/**
	 * ����ʱ���趨
	 * @param eiupdtime_to����ʱ��
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}

	/**
	 * �ʲ�����������ȡ��
	 * @return �ʲ�����������
	 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	/**
	 * �ʲ������������趨
	 * @param eiorgsyscoding�ʲ�����������
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * �ʲ�������ģ��ȡ��
	 * @return �ʲ�������ģ��
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ�������ģ���趨
	 * @param esyscoding�ʲ�������ģ��
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * �ʲ�ʹ�û���codeȡ��
	 * @return �ʲ�ʹ�û���code
	 */
	public String getUsesyscoding() {
		return usesyscoding;
	}

	/**
	 * �ʲ�ʹ�û���code�趨
	 * @param usesyscoding�ʲ�ʹ�û���code
	 */
	public void setUsesyscoding(String usesyscoding) {
		this.usesyscoding = usesyscoding;
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

	public String[] getCcivalue() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getCclabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getCivalue() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getCname() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getEiidList() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEilabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiorgcode() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiorgsyscoding_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEistatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEistatus_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEkey1() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEkey2() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getElabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWbdate_from() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWbdate_to() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmodeltype_eq() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCondudetime_from() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCondudetime_to() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFacilitator() {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * eidesc_like is returned.
     * @return eidesc_like
     */
    public String getEidesc_like() {
        return eidesc_like;
    }

    /**
     * eidesc_like is set.
     * @param eidesc_like eidesc_like
     */
    public void setEidesc_like(String eidesc_like) {
        this.eidesc_like = eidesc_like;
    }

    /**
     * ��ѯ��ʶ is returned.
     * @return queryflag
     */
    public String getQueryflag() {
        return queryflag;
    }

    /**
     * ��ѯ��ʶ is set.
     * @param queryflag ��ѯ��ʶ
     */
    public void setQueryflag(String queryflag) {
        this.queryflag = queryflag;
    }
	
}
