package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.deliverik.framework.soc.asset.model.SOC0606Info;



/**
 * </p>
 * �ʲ�������Ϣ��ͼʵ��
 *</p>
 */
@SuppressWarnings("serial")
@org.hibernate.annotations.Entity(mutable=false)
@IdClass(SOC0606PK.class)
@Entity
//public class ConfigItemVW extends BaseEntity implements Serializable, Cloneable, ConfigItemVWInfo {
public class SOC0606VW implements Serializable, Cloneable, SOC0606Info {

	/** �ʲ�����ID */
	protected String ciid;
	
	/** �ʲ�ID */
	@Id
	protected String eiid;
	
	/** �ʲ�ģ������ID */
	@Id
	protected String cid;
	
	/** �ʲ�ģ��ID */
	protected String eid;
	
	/** �ʲ�ģ���������� */
	protected String cname;
	
	/** �ʲ�ģ������˵�� */
	protected String cdesc;
	
	/** �ʲ�ģ�����Ե�λ */
	protected String cunit;
	
	/** �ʲ�ģ������״̬��1���ã�2ͣ�ã� */
	protected String cstatus;
	
	/** �ʲ�ģ���������� */
	protected String ccategory;
	
	/** �ʲ�ģ�������Ƿ���ʾ��ʶ��1��ʾ��0����ʾ�� */
	protected String cseq;
	
	/** �ʲ�ģ�����Ա�� */
	protected String clabel;
	
	/** �ʲ�ģ������ȡֵ��Χ */
	protected String coption;

	/** �ʲ�ģ�����Ը�����ʶ */
	protected String cattach;
	
	/** �ʲ�ģ�Ͳ����*/
	public String esyscoding;
	
	/** �ʲ�ģ�����Ա����� */
	protected String crequired;
	
	/** �ʲ�����ֵ */
	protected String civalue;
	
	/** �ʲ����Ը���ʱ�� */
	protected String ciupdtime;
	
	/** �ʲ����Թ���ʱ�� */
	protected String ciexpire;
	
	/** �ʲ�����״̬��ƽ̨������δʹ�ã� */
	protected String cistatus;
	
	/** �ʲ����Ը��±�ʶ */
	protected String cicurver;
	
	/** �ʲ����Դ�汾�� */
	protected Integer civersion;
	
    /** �ʲ�����С�汾�� */
	protected Integer cismallversion;
	
	/** �ʲ����԰汾��Ϣ */
	protected String civerinfo;
	
	protected String eilabel;
	
	protected String einame;
	
	protected String srename;

	/**�����ʶ*/
    private Integer corder;
	
	public String getCicurver() {
		return cicurver;
	}

	public void setCicurver(String cicurver) {
		this.cicurver = cicurver;
	}

	public String getSrename() {
		return srename;
	}

	public void setSrename(String srename) {
		this.srename = srename;
	}

	public String getEiname() {
		return einame;
	}

	public void setEiname(String einame) {
		this.einame = einame;
	}

	public String getEilabel() {
		return eilabel;
	}

	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * �ʲ�ģ�Ͳ����ȡ��
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getEsyscoding() {
		return esyscoding;
	}
	
	/**
	 * �ʲ�ģ�Ͳ�����趨
	 *
	 * @param esyscoding �ʲ�ģ�Ͳ����
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * ����ȡ��
	 * 
	 * @return 
	 */
	public Serializable getPK() {
		return new SOC0606PK(eiid, cid);
	}

	/**
	 * �ʲ�����IDȡ��
	 * @return �ʲ�����ID
	 */
	public String getCiid() {
		return ciid;
	}

	/**
	 * �ʲ�����ID�趨
	 *
	 * @param ciid �ʲ�����ID
	 */
	public void setCiid(String ciid) {
		this.ciid = ciid;
	}

	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID�趨
	 *
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * �ʲ�ģ������IDȡ��
	 * @return �ʲ�ģ������ID
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * �ʲ�ģ������ID�趨
	 *
	 * @param cid �ʲ�ģ������ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
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
	 * �ʲ�����ֵȡ��
	 * @return �ʲ�����ֵ
	 */
	public String getCivalue() {
		return civalue;
	}

	/**
	 * �ʲ�����ֵ�趨
	 *
	 * @param civalue �ʲ�����ֵ
	 */
	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}

	/**
	 * �ʲ����Ը���ʱ��ȡ��
	 * @return �ʲ����ø���ʱ��
	 */
	public String getCiupdtime() {
		return ciupdtime;
	}

	/**
	 * �ʲ����Ը���ʱ���趨
	 *
	 * @param ciupdtime �ʲ����Ը���ʱ��
	 */
	public void setCiupdtime(String ciupdtime) {
		this.ciupdtime = ciupdtime;
	}

	/**
	 * �ʲ����Թ���ʱ��ȡ��
	 * @return �ʲ����Թ���ʱ��
	 */
	public String getCiexpire() {
		return ciexpire;
	}

	/**
	 * �ʲ����Թ���ʱ���趨
	 *
	 * @param ciexpire �ʲ����Թ���ʱ��
	 */
	public void setCiexpire(String ciexpire) {
		this.ciexpire = ciexpire;
	}

	/**
	 * �ʲ�ģ����������ȡ��
	 * @return �ʲ�ģ����������
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * �ʲ�ģ�����������趨
	 *
	 * @param cname �ʲ�ģ����������
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * �ʲ�ģ������˵��ȡ��
	 * @return �ʲ�ģ������˵��
	 */
	public String getCdesc() {
		return cdesc;
	}

	/**
	 * �ʲ�ģ������˵���趨
	 *
	 * @param cdesc �ʲ�ģ������˵��
	 */
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	/**
	 * �ʲ�ģ�����Ե�λȡ��
	 * @return �ʲ�ģ�����Ե�λ
	 */
	public String getCunit() {
		return cunit;
	}

	/**
	 * �ʲ�ģ�����Ե�λ�趨
	 *
	 * @param cunit �ʲ�ģ�����Ե�λ
	 */
	public void setCunit(String cunit) {
		this.cunit = cunit;
	}

	/**
	 * �ʲ�ģ������״̬ȡ��
	 * @return �ʲ�ģ������״̬
	 */
	public String getCstatus() {
		return cstatus;
	}

	/**
	 * �ʲ�ģ������״̬�趨
	 *
	 * @param cstatus �ʲ�ģ������״̬
	 */
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

	/**
	 * �ʲ�ģ�������Ƿ���ʾ��ʶȡ��
	 * @return �ʲ�ģ�������Ƿ���ʾ��ʶ
	 */
	public String getCseq() {
		return cseq;
	}

	/**
	 * �ʲ�ģ�������Ƿ���ʾ��ʶ�趨
	 *
	 * @param cseq �ʲ�ģ�������Ƿ���ʾ��ʶ
	 */
	public void setCseq(String cseq) {
		this.cseq = cseq;
	}

	/**
	 * �ʲ�ģ����������ȡ��
	 * @return �ʲ�ģ���������� 
	 */
	public String getCcategory() {
		return ccategory;
	}

	/**
	 * �ʲ�ģ�����������趨
	 *
	 * @param ccategory �ʲ�ģ����������
	 */
	public void setCcategory(String ccategory) {
		this.ccategory = ccategory;
	}

	/**
	 * �ʲ�����״̬ȡ��
	 * @return �ʲ�����״̬
	 */
	public String getCistatus() {
		return cistatus;
	}

	/**
	 * �ʲ�����״̬�趨
	 *
	 * @param cistatus �ʲ�����״̬
	 */
	public void setCistatus(String cistatus) {
		this.cistatus = cistatus;
	}

	/**
	 * �ʲ����԰汾��Ϣȡ��
	 * @return �ʲ����԰汾��Ϣ
	 */
	public String getCiverinfo() {
		return civerinfo;
	}

	/**
	 * �ʲ����԰汾��Ϣ�趨
	 *
	 * @param civerinfo �ʲ����԰汾��Ϣ
	 */
	public void setCiverinfo(String civerinfo) {
		this.civerinfo = civerinfo;
	}

	/**
	 * �ʲ�ģ�����Ա��ȡ��
	 * @return �ʲ�ģ�����Ա��
	 */
	public String getClabel() {
		return clabel;
	}

	/**
	 * �ʲ�ģ�����Ա���趨
	 *
	 * @param clabel �ʲ�ģ�����Ա��
	 */
	public void setClabel(String clabel) {
		this.clabel = clabel;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χȡ��
	 * @return �ʲ�ģ������ȡֵ��Χ
	 */
	public String getCoption() {
		return coption;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χ�趨
	 *
	 * @param coption �ʲ�ģ������ȡֵ��Χ
	 */
	public void setCoption(String coption) {
		this.coption = coption;
	}

	/**
	 * �ʲ�ģ�����Ը�����ʶȡ��
	 * @return �ʲ�ģ�����Ը�����ʶ
	 */
	public String getCattach() {
		return cattach;
	}

	/**
	 * �ʲ�ģ�����Ը�����ʶ�趨
	 *
	 * @param cattach �ʲ�ģ�����Ը�����ʶ
	 */
	public void setCattach(String cattach) {
		this.cattach = cattach;
	}
	
	/**
	 * �ʲ�ģ�����Ա�����ȡ��
	 * @return �ʲ�ģ�����Ա�����
	 */
	public String getCrequired() {
		return crequired;
	}
	/**
	 * �ʲ�ģ�����Ա������趨
	 *
	 * @param crequired �ʲ�ģ�����Ա�����
	 */
	public void setCrequired(String crequired) {
		this.crequired = crequired;
	}
	
	/**
	 * �ʲ����Դ�汾��ȡ��
	 * @return �ʲ����Դ�汾��
	 */
	public Integer getCiversion() {
		return civersion;
	}

	/**
	 * �ʲ����Դ�汾���趨
	 *
	 * @param civersion �ʲ����Դ�汾��
	 */
	public void setCiversion(Integer civersion) {
		this.civersion = civersion;
	}

	/**
	 * �ʲ�����С�汾��ȡ��
	 * @return �ʲ�����С�汾��
	 */
	public Integer getCismallversion() {
		return cismallversion;
	}

	/**
	 * �ʲ�����С�汾���趨
	 *
	 * @param cismallversion �ʲ�����С�汾��
	 */
	public void setCismallversion(Integer cismallversion) {
		this.cismallversion = cismallversion;
	}

    /**
     * �����ʶ is returned.
     * @return corder
     */
    public Integer getCorder() {
        return corder;
    }

    /**
     * �����ʶ is set.
     * @param corder �����ʶ
     */
    public void setCorder(Integer corder) {
        this.corder = corder;
    }


}
