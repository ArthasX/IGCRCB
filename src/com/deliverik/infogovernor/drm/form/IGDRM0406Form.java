package com.deliverik.infogovernor.drm.form;

import java.util.List;

import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * Ӧ����Դ����ҳ��Ϣ�������FORM
 * 
 */
public class IGDRM0406Form extends BaseForm implements IG688SearchCond{

	private static final long serialVersionUID = 1L;

	/** special Planר��Ԥ��eiid */
	protected String sp_eiid;
	/** Ӧ����Դ������ */
	protected String elabel;
	
	/**
     * ��ѯ��ʶ
     */
    private String queryflag;
	
	/** Ӧ����Դ���� */
	protected String eilabel;
	
	/** Ӧ����Դ������ */
	protected String einame;
	
	/** Ӧ����Դ������� */
	protected String ecategory;
	
	/** Ӧ����Դ����һ������ */
	protected String ekey1;
	
	/** Ӧ����Դ����������� */
	protected String ekey2;
	
	/** Ӧ����Դ����ʱ��FROM */
	protected String eiupdtime_from;
	
	/** Ӧ����Դ����ʱ��TO */
	protected String eiupdtime_to;
	
	/** Ӧ����Դ����������*/
	public String eiorgsyscoding;
	
	/** Ӧ����Դ��������������*/
	public String eiorgname;
	
	public String eistatus;
	
	/** Ӧ����Դ������ */
	protected String ename;
	
	/** ģ�Ͳ���� */
	protected String esyscoding;
	
	/** ��ʼ������� */
	protected String esyscodingbegin;
	
	/** ��ѡ��ѡ��ID */
	protected String[] selectId;
	
	/** Ӧ����Դʹ�û���code*/
	public String usesyscoding;
	
	/** ά�������ղ�ѯ��ʼʱ�� */
	public String wbdate_from;
	/** ά�������ղ�ѯ����ʱ�� */
	public String wbdate_to;
	
	/** ��̬��ID */
	protected String pidid;
	
	/** 
	 * Ӧ����Դ�����״̬ 
	 */
	protected String estatus;
	
	private String eidesc_like;
	/**
	 * Ӧ����Դ�������0��һ��Ӧ����Դ���� 1������Ӧ����Դ���ࣩ
	 */
	protected String emodeltype_eq;
	
	/** �豸����*/
	protected String deviceType;
	
	/**Ӧ����Դ��������ѯ*/
	protected String modifyflag;
	
	/**���ñ�ʶ(��ע���ʲ������û���FLEX�������������)*/
	protected String parFlag;
	

    public String getModifyflag() {
        return modifyflag;
    }

    public void setModifyflag(String modifyflag) {
        this.modifyflag = modifyflag;
    }

    /**
	 * Ӧ����Դ�����״̬ȡ��
	 * @return Ӧ����Դ�����״̬
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * Ӧ����Դ�����״̬�趨
	 *
	 * @param estatus Ӧ����Դ�����״̬
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
	 * Ӧ����Դ�������ȡ��
	 * @return Ӧ����Դ�������
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * Ӧ����Դ��������趨
	 *
	 * @param elabel Ӧ����Դ�������
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * Ӧ����Դ�����ȡ��
	 * @return Ӧ����Դ�����
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * Ӧ����Դ������趨
	 *
	 * @param eilabel Ӧ����Դ�����
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * Ӧ����Դ������ȡ��
	 * @return Ӧ����Դ������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * Ӧ����Դ�������趨
	 *
	 * @param einame Ӧ����Դ������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * Ӧ����Դ�������ȡ��
	 * @return Ӧ����Դ�������
	 */
	public String getEcategory() {
		return ecategory;
	}

	/**
	 * Ӧ����Դ��������趨
	 *
	 * @param ecategory Ӧ����Դ�������
	 */
	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}

	/**
	 * Ӧ����Դ����һ������ȡ��
	 * @return Ӧ����Դ����һ������
	 */
	public String getEkey1() {
		return ekey1;
	}

	/**
	 * Ӧ����Դ����һ�������趨
	 *
	 * @param ekey1 Ӧ����Դ����һ������
	 */
	public void setEkey1(String ekey1) {
		this.ekey1 = ekey1;
	}

	/**
	 * Ӧ����Դ�����������ȡ��
	 * @return Ӧ����Դ�����������
	 */
	public String getEkey2() {
		return ekey2;
	}

	/**
	 * Ӧ����Դ������������趨
	 *
	 * @param ekey1 Ӧ����Դ�����������
	 */
	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}

	/**
	 * Ӧ����Դ�����ʱ��FROMȡ��
	 * @return Ӧ����Դ�����ʱ��FROM
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	/**
	 * Ӧ����Դ�����ʱ��FROM�趨
	 *
	 * @param eiupdtime_from Ӧ����Դ�����ʱ��FROM
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	/**
	 * Ӧ����Դ�����ʱ��TOȡ��
	 * @return Ӧ����Դ�����ʱ��TO
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	/**
	 * Ӧ����Դ�����ʱ��TO�趨
	 *
	 * @param eiupdtime_to Ӧ����Դ�����ʱ��TO
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
	 * Ӧ����Դ�������ȡ��
	 * 
	 * @return Ӧ����Դ�������0��һ��Ӧ����Դ���� 1������Ӧ����Դ���ࣩ
	 */
	public String getEmodeltype_eq() {
		return emodeltype_eq;
	}

	/**
	 * Ӧ����Դ��������趨
	 * @param emodeltype_eq Ӧ����Դ�������0��һ��Ӧ����Դ���� 1������Ӧ����Դ���ࣩ
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

	public String getParFlag() {
		return parFlag;
	}

	public void setParFlag(String parFlag) {
		this.parFlag = parFlag;
	}

}
