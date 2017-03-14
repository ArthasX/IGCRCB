package com.deliverik.infogovernor.asset.form;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;

/**
 * �豸��ѯ����FORM
 * 
 */
public class IGASM1414Form extends BaseForm implements SOC0124SearchCond{

	private static final long serialVersionUID = 1L;

	/** �ʲ�ģ�ͱ�� */
	protected String elabel;
	
	/** �ʲ�ģ���� */
	protected String ename;
	/**
     * ��ѯ��ʶ
     */
    private String queryflag;
	
	/** �豸��� */
	protected String eilabel;
	
	/** �豸���� */
	protected String einame;
	
	/** �ʲ�ģ�ͷ��� */
	protected String ecategory;
	
	/** �ʲ�ģ��һ������ */
	protected String ekey1;
	
	/** �ʲ�ģ�Ͷ������� */
	protected String ekey2;
	
	/** �豸����ʱ��FROM */
	protected String eiupdtime_from;
	
	/** �豸����ʱ��TO */
	protected String eiupdtime_to;
	
	/** ɾ���豸���� */
	protected String[] deleteEiid;
	
	/** �豸������������������ */
	protected String[] cname = new String[4];
	
	/** �豸����ֵ������������ */
	protected String[] civalue = new String[4];
	
	/** �豸��ͨ���ñ�ż����������� */
	protected String[] cclabel = new String[2];
	
	/** �豸��ͨ����ֵ������������ */
	protected String[] ccivalue = new String[2];
	/** �ʲ�����������*/
	public String eiorgsyscoding;
	
	/** �ʲ���������������*/
	public String eiorgname;
	/** �ʲ�������ģ��*/
	public String esyscoding;
	
	/** �ʲ����״̬ */
	protected String eistatus;//�·���N|R  �Ͻɴ�U  ���ϴ�N|R  
	
	/** �ʲ�ʹ�û���code*/
	public String usesyscoding;
	/** �ʲ�ʹ�û�������*/
	public String useorgname;
	
	/** 
	 * �ʲ�ģ�͵�״̬ 
	 */
	protected String estatus;
	
	private String eidesc_like;
	
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
	public String getUseorgname() {
		return useorgname;
	}

	public void setUseorgname(String useorgname) {
		this.useorgname = useorgname;
	}

	public String getUsesyscoding() {
		return usesyscoding;
	}

	public void setUsesyscoding(String usesyscoding) {
		this.usesyscoding = usesyscoding;
	}

	public String getEistatus() {
		return eistatus;
	}

	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
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
	 * �豸����ȡ��
	 * @return �豸����
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �豸�����趨
	 *
	 * @param eilabel �豸����
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
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
	 *
	 * @param einame �豸����
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
	 * �豸����ʱ��FROMȡ��
	 * @return �豸����ʱ��FROM
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	/**
	 * �豸����ʱ��FROM�趨
	 *
	 * @param eiupdtime_from �豸����ʱ��FROM
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	/**
	 * �豸����ʱ��TOȡ��
	 * @return �豸����ʱ��TO
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	/**
	 * �豸����ʱ��TO�趨
	 *
	 * @param eiupdtime_to �豸����ʱ��TO
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}


	/**
	 * ɾ���豸����ȡ��
	 * @return ɾ���豸����
	 */
	public String[] getDeleteEiid() {
		return deleteEiid;
	}


	/**
	 * ɾ���豸�����趨
	 *
	 * @param deleteEiid ɾ���豸����
	 */
	public void setDeleteEiid(String[] deleteEiid) {
		this.deleteEiid = deleteEiid;
	}

	/**
	 * �豸������������������ȡ��
	 * @return �豸������������������
	 */
	public String[] getCname() {
		return cname;
	}

	/**
	 * �豸�������������������趨
	 *
	 * @param cname �豸������������������
	 */
	public void setCname(String[] cname) {
		this.cname = cname;
	}

	/**
	 * �豸����ֵ������������ȡ��
	 * @return �豸����ֵ������������
	 */
	public String[] getCivalue() {
		return civalue;
	}

	/**
	 * �豸����ֵ�������������趨
	 *
	 * @param civalue �豸����ֵ������������
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

	/**
	 * �豸��ͨ���ñ�ż�����������ȡ��
	 * @return �豸��ͨ���ñ�ż�����������
	 */
	public String[] getCclabel() {
		return cclabel;
	}

	/**
	 * �豸��ͨ���ñ�ż������������趨
	 *
	 * @param cclabel �豸��ͨ���ñ�ż�����������
	 */
	public void setCclabel(String[] cclabel) {
		this.cclabel = cclabel;
	}

	/**
	 * �豸��ͨ����ֵ������������ȡ��
	 * @return �豸��ͨ����ֵ������������
	 */
	public String[] getCcivalue() {
		return ccivalue;
	}

	/**
	 * �豸��ͨ����ֵ�������������趨
	 *
	 * @param ccivalue �豸��ͨ����ֵ������������
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

	public List<String> getEiidList() {
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

	public String getEistatus_q() {
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
