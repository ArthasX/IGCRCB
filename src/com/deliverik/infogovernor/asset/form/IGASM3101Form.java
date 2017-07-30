package com.deliverik.infogovernor.asset.form;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;

/**
 * ������ѯ����FORM
 * 
 */
public class IGASM3101Form extends BaseForm implements SOC0124SearchCond{

	private static final long serialVersionUID = 1L;

	/**
     * ��ѯ��ʶ
     */
    private String queryflag;
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
	
	/** ��������ʱ��FROM */
	protected String eiupdtime_from;
	
	/** ��������ʱ��TO */
	protected String eiupdtime_to;
	
	/** ɾ���������� */
	protected String[] deleteEiid;
	
	/** ����������������������� */
	protected String[] cname = new String[4];
	
	/** ���������ֵ������������ */
	protected String[] civalue = new String[4];
	
	/** ����ͨ���ñ�ż����������� */
	protected String[] cclabel = new String[2];
	
	/** ����ͨ����ֵ������������ */
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
	
	
	/**ָ������*/
	protected String einame;
	
	/**ָ����*/
	protected String eilabel;
	
	/**ָ�����*/
	protected String syscoding;
	
	/**ָ����;*/
	protected String indexused;
	
	/**��ֵ*/
	protected String zbfz;
	
	/**ָ��������*/
	protected String dutyuser;
	
	/**ָ�����β���*/
	protected String dutydepartment;
	
	/**�Ƿ�ؼ�ָ��*/
	protected String keyindex;
	
	/**ָ�������ID*/
	protected String mguserid;
	
	/**ָ���������*/
	protected String managername;
	
	/**�Ǽ����� ��ʱ��*/
	protected String eiStartDate;
	
	/**�Ǽ����� ��ʱ��*/
	protected String eiEndDate;
	
	/**����ʱ�� ��ʱ��*/
	protected String euStartDate;
	
	/**����ʱ�� ��ʱ��*/
	protected String euEndDate;
	
	/**ָ������EIID*/
	protected String eiid;
	
	/**����ָ��*/
	protected String[] ccdvalue;
	
	/**��ѯ��ʶ*/
	protected String looksign;
	/** eiid�ų�����*/
	protected String eiid_NotIn;
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
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * ���������趨
	 *
	 * @param eilabel ��������
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ����������趨
	 *
	 * @param einame ���������
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
	 * ��������ʱ��FROMȡ��
	 * @return ��������ʱ��FROM
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	/**
	 * ��������ʱ��FROM�趨
	 *
	 * @param eiupdtime_from ��������ʱ��FROM
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	/**
	 * ��������ʱ��TOȡ��
	 * @return ��������ʱ��TO
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	/**
	 * ��������ʱ��TO�趨
	 *
	 * @param eiupdtime_to ��������ʱ��TO
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}


	/**
	 * ɾ����������ȡ��
	 * @return ɾ����������
	 */
	public String[] getDeleteEiid() {
		return deleteEiid;
	}


	/**
	 * ɾ�����������趨
	 *
	 * @param deleteEiid ɾ����������
	 */
	public void setDeleteEiid(String[] deleteEiid) {
		this.deleteEiid = deleteEiid;
	}

	/**
	 * �����������������������ȡ��
	 * @return �����������������������
	 */
	public String[] getCname() {
		return cname;
	}

	/**
	 * ������������������������趨
	 *
	 * @param cname �����������������������
	 */
	public void setCname(String[] cname) {
		this.cname = cname;
	}

	/**
	 * ���������ֵ������������ȡ��
	 * @return ���������ֵ������������
	 */
	public String[] getCivalue() {
		return civalue;
	}

	/**
	 * ���������ֵ�������������趨
	 *
	 * @param civalue ���������ֵ������������
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

	/**
	 * ����ͨ���ñ�ż�����������ȡ��
	 * @return ����ͨ���ñ�ż�����������
	 */
	public String[] getCclabel() {
		return cclabel;
	}

	/**
	 * ����ͨ���ñ�ż������������趨
	 *
	 * @param cclabel ����ͨ���ñ�ż�����������
	 */
	public void setCclabel(String[] cclabel) {
		this.cclabel = cclabel;
	}

	/**
	 * ����ͨ����ֵ������������ȡ��
	 * @return ����ͨ����ֵ������������
	 */
	public String[] getCcivalue() {
		return ccivalue;
	}

	/**
	 * ����ͨ����ֵ�������������趨
	 *
	 * @param ccivalue ����ͨ����ֵ������������
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

	public String getSyscoding() {
		return syscoding;
	}

	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	public String getIndexused() {
		return indexused;
	}

	public void setIndexused(String indexused) {
		this.indexused = indexused;
	}

	public String getZbfz() {
		return zbfz;
	}

	public void setZbfz(String zbfz) {
		this.zbfz = zbfz;
	}

	public String getDutyuser() {
		return dutyuser;
	}

	public void setDutyuser(String dutyuser) {
		this.dutyuser = dutyuser;
	}

	public String getDutydepartment() {
		return dutydepartment;
	}

	public void setDutydepartment(String dutydepartment) {
		this.dutydepartment = dutydepartment;
	}

	public String getKeyindex() {
		return keyindex;
	}

	public void setKeyindex(String keyindex) {
		this.keyindex = keyindex;
	}

	public String getMguserid() {
		return mguserid;
	}

	public void setMguserid(String mguserid) {
		this.mguserid = mguserid;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public String getEiStartDate() {
		return eiStartDate;
	}

	public void setEiStartDate(String eiStartDate) {
		this.eiStartDate = eiStartDate;
	}

	public String getEiEndDate() {
		return eiEndDate;
	}

	public void setEiEndDate(String eiEndDate) {
		this.eiEndDate = eiEndDate;
	}

	public String getEuStartDate() {
		return euStartDate;
	}

	public void setEuStartDate(String euStartDate) {
		this.euStartDate = euStartDate;
	}

	public String getEuEndDate() {
		return euEndDate;
	}

	public void setEuEndDate(String euEndDate) {
		this.euEndDate = euEndDate;
	}

	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	public String[] getCcdvalue() {
		return ccdvalue;
	}

	public void setCcdvalue(String[] ccdvalue) {
		this.ccdvalue = ccdvalue;
	}

	public String getLooksign() {
		return looksign;
	}

	public void setLooksign(String looksign) {
		this.looksign = looksign;
	}

	public String getDeviceType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLifeCycle() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 *  eiid�ų����ϻ�ȡ
	 * @return the eiid_NotIn
	 */
	public String getEiid_NotIn() {
		return eiid_NotIn;
	}

	/**
	 *  eiid�ų������趨
	 * @param eiid_NotIn the eiid_NotIn to set
	 */
	public void setEiid_NotIn(String eiid_NotIn) {
		this.eiid_NotIn = eiid_NotIn;
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