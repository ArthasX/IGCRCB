/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG561Info;

/**
  * ����: ״̬��˽�б�ֵ��¼��ʵ��
  * ��������: ״̬��˽�б�ֵ��¼��ʵ��
  * ������¼: 2015/02/07
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="ig561")
public class IG561TB extends BaseEntity implements Serializable,
		Cloneable, IG561Info {

	/** ��ˮid */
	@Id
	@TableGenerator(
		name="IG561_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IG561_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG561_TABLE_GENERATOR")
	protected Integer pvlid;

	/** ����id */
	protected Integer prid;
	
	/** ��ֵid fk�� ig599*/
	protected Integer piid;

	/** ״̬id */
	protected String psdid;

	/** ��id */
	protected String pidid;

	/** ������ */
	protected String pivarname;

	/** ����ʾ */
	protected String pivarlabel;

	/** ������ */
	protected String pivartype;

	/** ��ֵ */
	protected String pivarvalue;

	/** ����key */
	protected String piattkey;

	/** Ȩ�� */
	protected String pidaccess;

	/** ���� */
	protected String pidrequired;
	
	/**�û�id*/
	protected String piuserid;
	
	
	/**�û�id*/
	public String getPiuserid() {
        return piuserid;
    }
	/**�û�id*/
    public void setPiuserid(String piuserid) {
        this.piuserid = piuserid;
    }

    /**
	 * ��ˮidȡ��
	 *
	 * @return ��ˮid
	 */
	public Integer getPvlid() {
		return pvlid;
	}

	/**
	 * ��ˮid�趨
	 *
	 * @param pvlid ��ˮid
	 */
	public void setPvlid(Integer pvlid) {
		this.pvlid = pvlid;
	}

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����id�趨
	 *
	 * @param prid ����id
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ״̬idȡ��
	 *
	 * @return ״̬id
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ״̬id�趨
	 *
	 * @param psdid ״̬id
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ��idȡ��
	 *
	 * @return ��id
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ��id�趨
	 *
	 * @param pidid ��id
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getPivarname() {
		return pivarname;
	}

	/**
	 * �������趨
	 *
	 * @param pivarname ������
	 */
	public void setPivarname(String pivarname) {
		this.pivarname = pivarname;
	}

	/**
	 * ����ʾȡ��
	 *
	 * @return ����ʾ
	 */
	public String getPivarlabel() {
		return pivarlabel;
	}

	/**
	 * ����ʾ�趨
	 *
	 * @param pivarlabel ����ʾ
	 */
	public void setPivarlabel(String pivarlabel) {
		this.pivarlabel = pivarlabel;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getPivartype() {
		return pivartype;
	}

	/**
	 * �������趨
	 *
	 * @param pivartype ������
	 */
	public void setPivartype(String pivartype) {
		this.pivartype = pivartype;
	}

	/**
	 * ��ֵȡ��
	 *
	 * @return ��ֵ
	 */
	public String getPivarvalue() {
		return pivarvalue;
	}

	/**
	 * ��ֵ�趨
	 *
	 * @param pivarvalue ��ֵ
	 */
	public void setPivarvalue(String pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	/**
	 * ����keyȡ��
	 *
	 * @return ����key
	 */
	public String getPiattkey() {
		return piattkey;
	}

	/**
	 * ����key�趨
	 *
	 * @param piattkey ����key
	 */
	public void setPiattkey(String piattkey) {
		this.piattkey = piattkey;
	}

	/**
	 * Ȩ��ȡ��
	 *
	 * @return Ȩ��
	 */
	public String getPidaccess() {
		return pidaccess;
	}

	/**
	 * Ȩ���趨
	 *
	 * @param pidaccess Ȩ��
	 */
	public void setPidaccess(String pidaccess) {
		this.pidaccess = pidaccess;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPidrequired() {
		return pidrequired;
	}

	/**
	 * �����趨
	 *
	 * @param pidrequired ����
	 */
	public void setPidrequired(String pidrequired) {
		this.pidrequired = pidrequired;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	@Override
    public Serializable getPK() {
		return pvlid;
	}
    public Integer getPiid() {
        return piid;
    }
    public void setPiid(Integer piid) {
        this.piid = piid;
    }

}