package com.deliverik.infogovernor.asset.form;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;

/**
 * Ӧ�ò�ѯ����FORM
 * 
 */
public class IGASM0801Form extends BaseForm implements SOC0124SearchCond{

	private static final long serialVersionUID = 1L;

	/** �ʲ�ģ�ͱ�� */
	protected String elabel;
	
	/** �ʲ�ģ���� */
	protected String ename;
	
	/** Ӧ�ñ�� */
	protected String eilabel;
	
	/** Ӧ������ */
	protected String einame;
	
	/**
     * ��ѯ��ʶ
     */
    private String queryflag;
	
	/** �ʲ�ģ�ͷ��� */
	protected String ecategory;
	
	/** �ʲ�ģ��һ������ */
	protected String ekey1;
	
	/** �ʲ�ģ�Ͷ������� */
	protected String ekey2;
	
	/** Ӧ�ø���ʱ��FROM */
	protected String eiupdtime_from;
	
	/** Ӧ�ø���ʱ��TO */
	protected String eiupdtime_to;
	
	/** ɾ��Ӧ�ö��� */
	protected String[] deleteEiid;
	
	/** Ӧ�������������������� */
	protected String[] cname = new String[4];
	
	/** Ӧ������ֵ������������ */
	protected String[] civalue = new String[4];
	
	/** Ӧ�ù�ͨ���ñ�ż����������� */
	protected String[] cclabel = new String[2];
	
	/** Ӧ�ù�ͨ����ֵ������������ */
	protected String[] ccivalue = new String[2];
	/** �ʲ�����������*/
	public String eiorgsyscoding;
	
	/** �ʲ���������������*/
	public String eiorgname;
	
	public String eistatus;
	/** �ʲ�������ģ��*/
	public String esyscoding;
	
	/** �ʲ�ʹ�û���code*/
	public String usesyscoding;
	
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
	
	public String getUsesyscoding() {
		return usesyscoding;
	}

	public void setUsesyscoding(String usesyscoding) {
		this.usesyscoding = usesyscoding;
	}
	
	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	public String getEistatus() {
		return eistatus;
	}
	
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	/**
	 * �ʲ�ģ�ͱ���ȡ��
	 * @return �ʲ�ģ�ͱ���
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * �ʲ�ģ�ͱ����趨
	 *
	 * @param elabel �ʲ�ģ�ͱ���
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
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
	 * Ӧ�ñ���ȡ��
	 * @return Ӧ�ñ���
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * Ӧ�ñ����趨
	 *
	 * @param eilabel Ӧ�ñ���
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * Ӧ������ȡ��
	 * @return Ӧ������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * Ӧ�������趨
	 *
	 * @param einame Ӧ������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
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
	 * @param ekey1 �ʲ�ģ�Ͷ�������
	 */
	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}

	/**
	 * Ӧ�ø���ʱ��FROMȡ��
	 * @return Ӧ�ø���ʱ��FROM
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	/**
	 * Ӧ�ø���ʱ��FROM�趨
	 *
	 * @param eiupdtime_from Ӧ�ø���ʱ��FROM
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	/**
	 * Ӧ�ø���ʱ��TOȡ��
	 * @return Ӧ�ø���ʱ��TO
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	/**
	 * Ӧ�ø���ʱ��TO�趨
	 *
	 * @param eiupdtime_to Ӧ�ø���ʱ��TO
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}


	/**
	 * ɾ��Ӧ�ö���ȡ��
	 * @return ɾ��Ӧ�ö���
	 */
	public String[] getDeleteEiid() {
		return deleteEiid;
	}


	/**
	 * ɾ��Ӧ�ö����趨
	 *
	 * @param deleteEiid ɾ��Ӧ�ö���
	 */
	public void setDeleteEiid(String[] deleteEiid) {
		this.deleteEiid = deleteEiid;
	}

	/**
	 * Ӧ��������������������ȡ��
	 * @return Ӧ��������������������
	 */
	public String[] getCname() {
		return cname;
	}

	/**
	 * Ӧ���������������������趨
	 *
	 * @param cname Ӧ��������������������
	 */
	public void setCname(String[] cname) {
		this.cname = cname;
	}

	/**
	 * Ӧ������ֵ������������ȡ��
	 * @return Ӧ������ֵ������������
	 */
	public String[] getCivalue() {
		return civalue;
	}

	/**
	 * Ӧ������ֵ�������������趨
	 *
	 * @param civalue Ӧ������ֵ������������
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

	/**
	 * Ӧ�ù�ͨ���ñ�ż�����������ȡ��
	 * @return Ӧ�ù�ͨ���ñ�ż�����������
	 */
	public String[] getCclabel() {
		return cclabel;
	}

	/**
	 * Ӧ�ù�ͨ���ñ�ż������������趨
	 *
	 * @param cclabel Ӧ�ù�ͨ���ñ�ż�����������
	 */
	public void setCclabel(String[] cclabel) {
		this.cclabel = cclabel;
	}

	/**
	 * Ӧ�ù�ͨ����ֵ������������ȡ��
	 * @return Ӧ�ù�ͨ����ֵ������������
	 */
	public String[] getCcivalue() {
		return ccivalue;
	}

	/**
	 * Ӧ�ù�ͨ����ֵ�������������趨
	 *
	 * @param ccivalue Ӧ�ù�ͨ����ֵ������������
	 */
	public void setCcivalue(String[] ccivalue) {
		this.ccivalue = ccivalue;
	}

	/**
	 * ��ʼ������
	 *
	 * @param mapping 
	 * @param request 
	 */
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.deleteEiid = null;
	}

	public String getEiorgsyscoding_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEistatus_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiorgcode() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getEiidList() {
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

	public Integer getEirootmark_eq() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiupdtime_from2() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiupdtime_to2() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getIp() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isTopCiFlag() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getDeviceType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLifeCycle() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getIpAddress()
	 */
	public String getIpAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getAssetNumber()
	 */
	public String getAssetNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getAote()
	 */
	public String getAote() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getEiidNotInList() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getPayee()
	 */
	public String getPayee() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getAmount()
	 */
	public String getAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isUpgrade() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getEiinsdate_gt() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiinsdate_lt() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getEiusername()
	 */
	public String getEiusername() {
		// TODO Auto-generated method stub
		return null;
	}

}
