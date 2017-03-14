package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG113Info;


/**
 * <p>
 * ����־��Ϣʵ��
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IG113")
public class IG113TB extends BaseEntity implements Serializable, Cloneable, IG113Info {

	/** ����ID */
	@Id
	@TableGenerator(
		    name="IG113_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG113_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG113_TABLE_GENERATOR")
	protected Integer rlvid;
	
	/** ����ID */
	protected Integer piid;
	
	/** ��־ID */
	protected Integer rlid;
	
	/** ���̼�¼ID */
	protected Integer prid;
	
	
	/**
	 * ���̱�����ʶ
	 */
	protected String pivarname;
	
	/**
	 * ���̱�������
	 */
	protected String pivarlabel;
	
	/**
	 * ���̱�������
	 */
	protected String pivartype;
	
	/**
	 * ���̱���ֵ
	 */
	protected String pivarvalue;
	
	/**
	 * ���̸���KEY
	 */
	protected String piattkey;
	
	/**
	 * �����Զ���ǰ�����ʶ
	 */
	protected String pidid;
	
	
	/**
	 * ���̶������ͱ�����ʾ����
	 */
	protected String pishowvarname;
	
	/** ��ʾ���� */
	@Transient
	protected String showValue;
	
	
	/** ������־ʵ�� */
	@ManyToOne
	@JoinColumn(name = "rlid", referencedColumnName="rlid", insertable=false, updatable=false)
	@Basic(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG036TB recordLog;

	
	
	/**
	 * ���̶������ͱ�����ʾ����ȡ��
	 * @return ���̶������ͱ�����ʾ����
	 */
	public String getPishowvarname() {
		return pishowvarname;
	}



	/**
	 * ���̶������ͱ�����ʾ�����趨
	 * @param pishowvarname ���̶������ͱ�����ʾ����
	 */
	public void setPishowvarname(String pishowvarname) {
		this.pishowvarname = pishowvarname;
	}




	/**
	 * ����ȡ��
	 * @return rlvid
	 */
	public Serializable getPK() {
		return rlvid;
	}
	
	
	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getRlvid() {
		return rlvid;
	}

	/**
	 * ����ID�趨
	 * @param rlvid ����ID
	 */
	public void setRlvid(Integer rlvid) {
		this.rlvid = rlvid;
	}

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getPiid() {
		return piid;
	}

	/**
	 * ����ID�趨
	 * @param piid ����ID
	 */
	public void setPiid(Integer piid) {
		this.piid = piid;
	}

	

	/**
	 * ��־IDȡ��
	 * @return ��־ID
	 */
	public Integer getRlid() {
		return rlid;
	}

	/**
	 * ��־ID�趨
	 * @param rlid ��־ID
	 */
	public void setRlid(Integer rlid) {
		this.rlid = rlid;
	}

	/**
	 * ���̼�¼IDȡ��
	 * @return ���̼�¼ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���̼�¼ID�趨
	 * @param prid ���̼�¼ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	
	/**
	 * ���̱�����ʶȡ��
	 * @return ���̱�����ʶ
	 */
	public String getPivarname() {
		return pivarname;
	}

	/**
	 * ���̱�����ʶ�趨
	 * @param pivarname ���̱�����ʶ
	 */
	public void setPivarname(String pivarname) {
		this.pivarname = pivarname;
	}

	/**
	 * ���̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPivartype() {
		return pivartype;
	}

	/**
	 * ���̱��������趨
	 * @param pivartype ���̱�������
	 */
	public void setPivartype(String pivartype) {
		this.pivartype = pivartype;
	}

	/**
	 * ���̱���ֵȡ��
	 * @return ���̱���ֵ
	 */
	public String getPivarvalue() {
		return pivarvalue;
	}

	/**
	 * ���̱���ֵ�趨
	 * @param pivarvalue ���̱���ֵ
	 */
	public void setPivarvalue(String pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	/**
	 * ���̸���KEYȡ��
	 * @return ���̸���KEY
	 */
	public String getPiattkey() {
		return piattkey;
	}

	/**
	 * ���̸���KEY�趨
	 * @param piattkey ���̸���KEY
	 */
	public void setPiattkey(String piattkey) {
		this.piattkey = piattkey;
	}

	/**
	 * ���̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPivarlabel() {
		return pivarlabel;
	}

	/**
	 * ���̱��������趨
	 * @param pivarlabel ���̱�������
	 */
	public void setPivarlabel(String pivarlabel) {
		this.pivarlabel = pivarlabel;
	}

	/**
	 * �����Զ���ǰ�����ʶȡ��
	 * @return �����Զ���ǰ�����ʶ
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * �����Զ���ǰ�����ʶ�趨
	 * @param pidid �����Զ���ǰ�����ʶ
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ������־ʵ��ȡ��
	 * @return recordLog ������־ʵ��
	 */
	public IG036TB getRecordLog() {
		return recordLog;
	}

	/**
	 * ������־ʵ���趨
	 * @param recordLog ������־ʵ��
	 */
	public void setRecordLog(IG036TB recordLog) {
		this.recordLog = recordLog;
	}

	/**
	 * ��ʾ����ȡ��
	 * @return showValue ��ʾ����
	 */
	public String getShowValue() {
		if(StringUtils.isNotEmpty(pishowvarname)){
			this.showValue = this.pishowvarname;
		}else if(StringUtils.isNotEmpty(pivarvalue)){
			this.showValue = this.pivarvalue;
		}
		return showValue;
	}

	/**
	 * ��ʾ�����趨
	 * @param showValue ��ʾ����
	 */
	public void setShowValue(String showValue) {
		this.showValue = showValue;
	}

}
