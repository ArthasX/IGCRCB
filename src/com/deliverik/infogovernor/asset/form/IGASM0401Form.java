package com.deliverik.infogovernor.asset.form;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.asset.model.condition.IG499SearchCond;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * ��ͬ��ѯ����FORM
 * 
 */
public class IGASM0401Form extends BaseForm implements IG688SearchCond,IG499SearchCond{

	private static final long serialVersionUID = 1L;

	/**
     * ��ѯ��ʶ
     */
    private String queryflag;
	/** �ʲ�ģ�ͱ�� */
	protected String elabel;
	
	/** �ʲ�ģ���� */
	protected String ename;
	
	/** ��ͬ��� */
	protected String eilabel;
	
	/** ��ͬ���� */
	protected String einame;
	
	/** �ʲ�ģ�ͷ��� */
	protected String ecategory;
	
	/** �ʲ�ģ��һ������ */
	protected String ekey1;
	
	/** �ʲ�ģ�Ͷ������� */
	protected String ekey2;
	
	/** ��ͬ����ʱ��FROM */
	protected String eiupdtime_from;
	
	/** ��ͬ����ʱ��TO */
	protected String eiupdtime_to;
	
	/** ɾ����ͬ���� */
	protected String[] deleteEiid;
	
	/** ��ͬ������������������ */
	protected String[] cname = new String[4];
	
	/** ��ͬ����ֵ������������ */
	protected String[] civalue = new String[4];
	
	/** ��ͬ��ͨ���ñ�ż����������� */
	protected String[] cclabel = new String[2];
	
	/** ��ͬ��ͨ����ֵ������������ */
	protected String[] ccivalue = new String[2];
	
	/** �������� */
	protected String eiorgname;
	
	protected String eiorgsyscoding;
	
	public String eistatus;
	
	/** �ʲ�������ģ��*/
	public String esyscoding;
	
	/** �ʲ�ʹ�û���code*/
	public String usesyscoding;
	
	/** 
	 * �ʲ�ģ�͵�״̬ 
	 */
	protected String estatus;
	
	/** ��ͬ��� */
	protected String compacttype;
	
	/** ǩ��ʱ�� */
	protected String condudetime;
	
	/** ������ */
	protected String facilitator;
	
	/** ������ */
	protected String operator;
	
	/** ��ѯʱ��� */
	protected String datetime;
	
	/** ǩ��ʱ��:�� */
	protected String condudetime_from;
	
	/** ǩ��ʱ��:�� */
	protected String condudetime_to;
	
	private String eidesc_like;
	
	public String getCompacttype() {
		return compacttype;
	}

	public void setCompacttype(String compacttype) {
		this.compacttype = compacttype;
	}

	public String getCondudetime() {
		return condudetime;
	}

	public void setCondudetime(String condudetime) {
		this.condudetime = condudetime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getFacilitator() {
		return facilitator;
	}

	public void setFacilitator(String facilitator) {
		this.facilitator = facilitator;
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
	 * ��ͬ����ȡ��
	 * @return ��ͬ����
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * ��ͬ�����趨
	 *
	 * @param eilabel ��ͬ����
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}
	
	/**
	 * ǩ��ʱ��:��ȡ��
	 * @return ǩ��ʱ��:��
	 */
	public String getCondudetime_from() {
		return condudetime_from;
	}

	/**
	 * ǩ��ʱ��:���趨
	 * @param condudetime_fromǩ��ʱ��:��
	 */
	public void setCondudetime_from(String condudetime_from) {
		this.condudetime_from = condudetime_from;
	}

	/**
	 * ǩ��ʱ��:��ȡ��
	 * @return ǩ��ʱ��:��
	 */
	public String getCondudetime_to() {
		return condudetime_to;
	}

	/**
	 * ǩ��ʱ��:���趨
	 * @param condudetime_toǩ��ʱ��:��
	 */
	public void setCondudetime_to(String condudetime_to) {
		this.condudetime_to = condudetime_to;
	}

	/**
	 * ��ͬ����ȡ��
	 * @return ��ͬ����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ��ͬ�����趨
	 *
	 * @param einame ��ͬ����
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
	 * ��ͬ����ʱ��FROMȡ��
	 * @return ��ͬ����ʱ��FROM
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	/**
	 * ��ͬ����ʱ��FROM�趨
	 *
	 * @param eiupdtime_from ��ͬ����ʱ��FROM
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	/**
	 * ��ͬ����ʱ��TOȡ��
	 * @return ��ͬ����ʱ��TO
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	/**
	 * ��ͬ����ʱ��TO�趨
	 *
	 * @param eiupdtime_to ��ͬ����ʱ��TO
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}


	/**
	 * ɾ����ͬ����ȡ��
	 * @return ɾ����ͬ����
	 */
	public String[] getDeleteEiid() {
		return deleteEiid;
	}


	/**
	 * ɾ����ͬ�����趨
	 *
	 * @param deleteEiid ɾ����ͬ����
	 */
	public void setDeleteEiid(String[] deleteEiid) {
		this.deleteEiid = deleteEiid;
	}

	/**
	 * ��ͬ������������������ȡ��
	 * @return ��ͬ������������������
	 */
	public String[] getCname() {
		return cname;
	}

	/**
	 * ��ͬ�������������������趨
	 *
	 * @param cname ��ͬ������������������
	 */
	public void setCname(String[] cname) {
		this.cname = cname;
	}

	/**
	 * ��ͬ����ֵ������������ȡ��
	 * @return ��ͬ����ֵ������������
	 */
	public String[] getCivalue() {
		return civalue;
	}

	/**
	 * ��ͬ����ֵ�������������趨
	 *
	 * @param civalue ��ͬ����ֵ������������
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

	/**
	 * ��ͬ��ͨ���ñ�ż�����������ȡ��
	 * @return ��ͬ��ͨ���ñ�ż�����������
	 */
	public String[] getCclabel() {
		return cclabel;
	}

	/**
	 * ��ͬ��ͨ���ñ�ż������������趨
	 *
	 * @param cclabel ��ͬ��ͨ���ñ�ż�����������
	 */
	public void setCclabel(String[] cclabel) {
		this.cclabel = cclabel;
	}

	/**
	 * ��ͬ��ͨ����ֵ������������ȡ��
	 * @return ��ͬ��ͨ����ֵ������������
	 */
	public String[] getCcivalue() {
		return ccivalue;
	}

	/**
	 * ��ͬ��ͨ����ֵ�������������趨
	 *
	 * @param ccivalue ��ͬ��ͨ����ֵ������������
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
	@Override
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

	public String getEiid() {
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

	public String getPayed() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.asset.model.condition.IG499SearchCond#getEiorgsyscoding_in()
	 */
	public String getEiorgsyscoding_in() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.asset.model.condition.IG499SearchCond#setEiorgsyscoding_in(java.lang.String)
	 */
	public void setEiorgsyscoding_in(String eiorgsyscoding_in) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.asset.model.condition.IG499SearchCond#getEiusername()
	 */
	public String getEiusername() {
		// TODO Auto-generated method stub
		return null;
	}

}
