/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.cic.model.CompareresultVWInfo;

/**
  * ����: �ȶԽ����ͼʵ��
  * ��������: �ȶԽ��ʵ��
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
public class CompareresultVW implements Serializable,
		Cloneable, CompareresultVWInfo {

	/** crid */
	@Id
	protected Integer crid;

	/** �Ƚ϶����id */
	protected Integer fkCoid;

	/** �Ƚ�ִ�б�ID */
	protected Integer fkCpid;

	/** eid */
	protected String eid;

	/** cid */
	protected String cid;

	/** Ŀ��eiid */
	protected Integer teiid;

	/** Ŀ��ciid */
	protected String tciid;

	/** Դeiid */
	protected Integer seiid;

	/** Դciid */
	protected String sciid;

	/** Դ����ֵ */
	protected String svalue;

	/** Ŀ������ֵ */
	protected String tvalue;

	/** �������� */
	protected String configtype;

	/** �Ƿ��ǻ������� */
	protected Integer isbase;

	/** ���ڵ�ģ��id */
	protected String peid;
	
	/** ���ڵ�ģ������ */
	protected String pename;
	
	/** ģ������ */
	protected String ename;
	
	/** �������� */
	protected String cname;

	/** ʱ��� */
	protected String fingerPrint;
	
	/** �������ƣ��ʲ����ƣ� */
	protected String einame;
	/***/
	protected String esyscoding;
	
	
	
	/**
	 * cridȡ��
	 *
	 * @return crid
	 */
	public Integer getCrid() {
		return crid;
	}

	/**
	 * crid�趨
	 *
	 * @param crid crid
	 */
	public void setCrid(Integer crid) {
		this.crid = crid;
	}

	/**
	 * �Ƚ϶����idȡ��
	 *
	 * @return �Ƚ϶����id
	 */
	public Integer getFkCoid() {
		return fkCoid;
	}

	/**
	 * �Ƚ϶����id�趨
	 *
	 * @param fkCoid �Ƚ϶����id
	 */
	public void setFkCoid(Integer fkCoid) {
		this.fkCoid = fkCoid;
	}

	/**
	 * �Ƚ�ִ�б�IDȡ��
	 *
	 * @return �Ƚ�ִ�б�ID
	 */
	public Integer getFkCpid() {
		return fkCpid;
	}

	/**
	 * �Ƚ�ִ�б�ID�趨
	 *
	 * @param fkCpid �Ƚ�ִ�б�ID
	 */
	public void setFkCpid(Integer fkCpid) {
		this.fkCpid = fkCpid;
	}

	/**
	 * eidȡ��
	 *
	 * @return eid
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * eid�趨
	 *
	 * @param eid eid
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * cidȡ��
	 *
	 * @return cid
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * cid�趨
	 *
	 * @param cid cid
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * Ŀ��eiidȡ��
	 *
	 * @return Ŀ��eiid
	 */
	public Integer getTeiid() {
		return teiid;
	}

	/**
	 * Ŀ��eiid�趨
	 *
	 * @param teiid Ŀ��eiid
	 */
	public void setTeiid(Integer teiid) {
		this.teiid = teiid;
	}

	/**
	 * Ŀ��ciidȡ��
	 *
	 * @return Ŀ��ciid
	 */
	public String getTciid() {
		return tciid;
	}

	/**
	 * Ŀ��ciid�趨
	 *
	 * @param tciid Ŀ��ciid
	 */
	public void setTciid(String tciid) {
		this.tciid = tciid;
	}

	/**
	 * Դeiidȡ��
	 *
	 * @return Դeiid
	 */
	public Integer getSeiid() {
		return seiid;
	}

	/**
	 * Դeiid�趨
	 *
	 * @param seiid Դeiid
	 */
	public void setSeiid(Integer seiid) {
		this.seiid = seiid;
	}

	/**
	 * Դciidȡ��
	 *
	 * @return Դciid
	 */
	public String getSciid() {
		return sciid;
	}

	/**
	 * Դciid�趨
	 *
	 * @param sciid Դciid
	 */
	public void setSciid(String sciid) {
		this.sciid = sciid;
	}

	/**
	 * Դ����ֵȡ��
	 *
	 * @return Դ����ֵ
	 */
	public String getSvalue() {
		return svalue;
	}

	/**
	 * Դ����ֵ�趨
	 *
	 * @param svalue Դ����ֵ
	 */
	public void setSvalue(String svalue) {
		this.svalue = svalue;
	}

	/**
	 * Ŀ������ֵȡ��
	 *
	 * @return Ŀ������ֵ
	 */
	public String getTvalue() {
		return tvalue;
	}

	/**
	 * Ŀ������ֵ�趨
	 *
	 * @param tvalue Ŀ������ֵ
	 */
	public void setTvalue(String tvalue) {
		this.tvalue = tvalue;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getConfigtype() {
		return configtype;
	}

	/**
	 * ���������趨
	 *
	 * @param configtype ��������
	 */
	public void setConfigtype(String configtype) {
		this.configtype = configtype;
	}

	/**
	 * �Ƿ��ǻ�������ȡ��
	 *
	 * @return �Ƿ��ǻ�������
	 */
	public Integer getIsbase() {
		return isbase;
	}

	/**
	 * �Ƿ��ǻ��������趨
	 *
	 * @param isbase �Ƿ��ǻ�������
	 */
	public void setIsbase(Integer isbase) {
		this.isbase = isbase;
	}

	/**
	 * ���ڵ�ģ��idȡ��
	 *
	 * @return ���ڵ�ģ��id
	 */
	public String getPeid() {
		return peid;
	}

	/**
	 * ���ڵ�ģ��id�趨
	 *
	 * @param peid ���ڵ�ģ��id
	 */
	public void setPeid(String peid) {
		this.peid = peid;
	}

    /** 
     * ���ڵ�ģ������ ȡ��
     * @return pename ���ڵ�ģ������ 
     */
    public String getPename() {
        return pename;
    }

    /** 
     * ���ڵ�ģ������ �趨
     * @param pename ���ڵ�ģ������ 
     */
    public void setPename(String pename) {
        this.pename = pename;
    }

    /** 
     * ģ������ ȡ��
     * @return ename ģ������ 
     */
    public String getEname() {
        return ename;
    }

    /** 
     * ģ������ �趨
     * @param ename ģ������ 
     */
    public void setEname(String ename) {
        this.ename = ename;
    }

    /** 
     * �������� ȡ��
     * @return cname �������� 
     */
    public String getCname() {
        return cname;
    }

    /** 
     * �������� �趨
     * @param cname �������� 
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

    /** 
     * ʱ��� ȡ��
     * @return fingerPrint ʱ��� 
     */
    public String getFingerPrint() {
        return fingerPrint;
    }

    /** 
     * ʱ��� �趨
     * @param fingerPrint ʱ��� 
     */
    public void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    /** 
     * �������ƣ��ʲ����ƣ� ȡ��
     * @return einame �������ƣ��ʲ����ƣ� 
     */
    public String getEiname() {
        return einame;
    }

    /** 
     * �������ƣ��ʲ����ƣ� �趨
     * @param einame �������ƣ��ʲ����ƣ� 
     */
    public void setEiname(String einame) {
        this.einame = einame;
    }

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
    
    

}