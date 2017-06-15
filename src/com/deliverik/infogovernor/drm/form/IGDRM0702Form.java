package com.deliverik.infogovernor.drm.form;

import java.util.List;

import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * �ʲ����ѯHELP������FORM
 * IGCOM0302Form ActionForm
 */
public class IGDRM0702Form extends BaseForm implements IG688SearchCond{

	private static final long serialVersionUID = 1L;

	/** Ӧ��ָ������prid */
	protected Integer prid;

	/** special Planר��Ԥ��eiid */
	protected String sp_eiid;

	/** �ʲ��汾 */
	protected String eiversion;
	/** �ʲ�ģ�ͱ�� */
	protected String elabel;
	
	/**
     * ��ѯ��ʶ
     */
    private String queryflag;
	
	/** �ʲ����� */
	protected String eilabel;
	
	/** �ʲ������� */
	protected String einame;
	
	/** �ʲ�ģ�ͷ��� */
	protected String ecategory;
	
	/** �ʲ�ģ��һ������ */
	protected String ekey1;
	
	/** �ʲ�ģ�Ͷ������� */
	protected String ekey2;
	
	/** �ʲ�����ʱ��FROM */
	protected String eiupdtime_from;
	
	/** �ʲ�����ʱ��TO */
	protected String eiupdtime_to;
	
	/** �ʲ�����������*/
	public String eiorgsyscoding;
	
	/** �ʲ���������������*/
	public String eiorgname;
	
	public String eistatus;
	
	/** �ʲ�ģ���� */
	protected String ename;
	
	/** ģ�Ͳ���� */
	protected String esyscoding;
	
	/** ��ʼ������� */
	protected String esyscodingbegin;
	
	/** ��ѡ��ѡ��ID */
	protected String[] selectId;
	
	/** �ʲ�ʹ�û���code*/
	public String usesyscoding;
	
	/** ά�������ղ�ѯ��ʼʱ�� */
	public String wbdate_from;
	/** ά�������ղ�ѯ����ʱ�� */
	public String wbdate_to;
	
	/** ��̬��ID */
	protected String pidid;
	
	/** 
	 * �ʲ�ģ�͵�״̬ 
	 */
	protected String estatus;
	
	private String eidesc_like;
	/**
	 * �ʲ�ģ�����0��һ���ʲ�ģ�� 1�������ʲ�ģ�ͣ�
	 */
	protected String emodeltype_eq;
	
	/** �豸����*/
	protected String deviceType;
	
	/**�ʲ���������ѯ*/
	protected String modifyflag;
	
	protected String cid;
	
	protected String roleids;
	
	/** ���������ѯ���� ��������:1,Ӧ������0 */
	protected String scenceCategory;


    public String getRoleids() {
		return roleids;
	}

	public void setRoleids(String roleids) {
		this.roleids = roleids;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getModifyflag() {
        return modifyflag;
    }

    public void setModifyflag(String modifyflag) {
        this.modifyflag = modifyflag;
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
	public void setEname(String ename) {
		this.ename = ename;
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
	 * �ʲ������ȡ��
	 * @return �ʲ������
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �ʲ�������趨
	 *
	 * @param eilabel �ʲ������
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * �ʲ�������ȡ��
	 * @return �ʲ�������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * �ʲ��������趨
	 *
	 * @param einame �ʲ�������
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

	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
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
	 * �ʲ������ʱ��FROMȡ��
	 * @return �ʲ������ʱ��FROM
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	/**
	 * �ʲ������ʱ��FROM�趨
	 *
	 * @param eiupdtime_from �ʲ������ʱ��FROM
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	/**
	 * �ʲ������ʱ��TOȡ��
	 * @return �ʲ������ʱ��TO
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	/**
	 * �ʲ������ʱ��TO�趨
	 *
	 * @param eiupdtime_to �ʲ������ʱ��TO
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}
	
	public String getEname() {
		return ename;
	}

	public String getEsyscoding() {
		return esyscoding;
	}
	
	public String[] getCivalue() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getCname() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getCcivalue() {
		return null;
	}

	public String[] getCclabel() {
		return null;
	}

	public String getEiorgsyscoding_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEsyscodingbegin() {
		return esyscodingbegin;
	}

	public void setEsyscodingbegin(String esyscodingbegin) {
		this.esyscodingbegin = esyscodingbegin;
	}

	public String getEistatus_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiorgcode() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ��ѡ��ѡ��IDȡ��
	 * @return ��ѡ��ѡ��ID
	 */
	public String[] getSelectId() {
		return selectId;
	}

	/**
	 * ��ѡ��ѡ��ID�趨
	 *
	 * @param selectId ��ѡ��ѡ��ID
	 */
	public void setSelectId(String[] selectId) {
		this.selectId = selectId;
	}

	public List<String> getEiidList() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWbdate_from() {
		return wbdate_from;
	}

	public void setWbdate_from(String wbdate_from) {
		this.wbdate_from = wbdate_from;
	}

	public String getWbdate_to() {
		return wbdate_to;
	}

	public void setWbdate_to(String wbdate_to) {
		this.wbdate_to = wbdate_to;
	}

	public String getPidid() {
		return pidid;
	}

	public void setPidid(String pidid) {
		this.pidid = pidid;
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
    
    /**
	 * �豸����ȡ��
	 *
	 * @return deviceType �豸����
	 */
	public String getDeviceType() {
		return deviceType;
	}

	/**
	 * �豸�����趨
	 *
	 * @param deviceType �豸����
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getSp_eiid() {
		return sp_eiid;
	}

	public void setSp_eiid(String sp_eiid) {
		this.sp_eiid = sp_eiid;
	}

	public String getEiversion() {
		return eiversion;
	}

	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}

	public String getScenceCategory() {
		return scenceCategory;
	}

	public void setScenceCategory(String scenceCategory) {
		this.scenceCategory = scenceCategory;
	}

}
