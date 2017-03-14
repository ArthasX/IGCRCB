package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG599Info;

/**
 * ���̱�����Ϣʵ��
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IG599")
public class IG599TB extends BaseEntity implements Serializable, Cloneable, IG599Info {

	/**
	 * �������Ͷ���ID
	 */
	@Id
	@TableGenerator(
		    name="IG599_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG599_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG599_TABLE_GENERATOR")
	protected Integer piid;
	
	/**
	 * ���̼�¼ID
	 */
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
	
	/** ���̱���ģʽ */
	public String pidmode;
	
	/** ˽�б���Ȩ�޷�Χ */
	protected String privatescope;
	
	/** ��ע */
	protected String pidcomment;
	
	/**
	 * �����߾��е����̱���Ȩ��
	 */
	@Transient
	protected String pidaccess;

	/**
	 * ����ȡ��
	 * @return piid
	 */
	public Serializable getPK() {
		return piid;
	}


	public boolean equals(Object obj) {
		if (!(obj instanceof IG599TB))
			return false;
		IG599Info target = (IG599Info) obj;
		if (!(getPiid()==target.getPiid()))
			return false;

		return true;
	}

	/**
	 * �������Ͷ���IDȡ��
	 * @return �������Ͷ���ID
	 */
	public Integer getPiid() {
		return piid;
	}

	/**
	 * �������Ͷ���ID�趨
	 * @param piid �������Ͷ���ID
	 */
	public void setPiid(Integer piid) {
		this.piid = piid;
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
	 * ���̱���ģʽȡ��
	 * @return ���̱���ģʽ
	 */
	public String getPidmode() {
		return pidmode;
	}

	/**
	 * ���̱���ģʽ�趨
	 * @param pidmode ���̱���ģʽ
	 */
	public void setPidmode(String pidmode) {
		this.pidmode = pidmode;
	}
	
	/**
	 * ˽�б���Ȩ�޷�Χ�趨
	 * 
	 * @return ˽�б���Ȩ�޷�Χ
	 */
	public String getPrivatescope() {
		return privatescope;
	}

	/**
	 * ˽�б���Ȩ�޷�Χȡ��
	 * 
	 * @param privatescope ˽�б���Ȩ�޷�Χ
	 */
	public void setPrivatescope(String privatescope) {
		this.privatescope = privatescope;
	}
	
	/**
	 * �����߾��е����̱���Ȩ��ȡ��
	 * @return �����߾��е����̱���Ȩ��
	 */
	public String getPidaccess() {
		return pidaccess;
	}

	public List<IG899TB> getProcessPrivateInfoList() {
		return processPrivateInfoList;
	}

	
	/**
	 *��עȡ��
	 */
	public String getPidcomment() {
		return pidcomment;
	}


	/**
	 *��ע����
	 */
	public void setPidcomment(String pidcomment) {
		this.pidcomment = pidcomment;
	}


	/**
	 * �������߾��е����̱���Ȩ���趨
	 * @param pidaccess �����߾��е����̱���Ȩ��
	 */
	public void setPidaccess(String pidaccess) {
		this.pidaccess = pidaccess;
	}
	
	@OneToMany(mappedBy = "processInfoDef",fetch = FetchType.EAGER)
	@JoinColumn(name = "piid",updatable=false, insertable= false)
	@NotFound(action = NotFoundAction.IGNORE)
	protected List<IG899TB> processPrivateInfoList;
	public List<IG899TB> getProcessPrivateInfofList() {
		return processPrivateInfoList;
	}

	public void setProcessPrivateInfoList(
			List<IG899TB> processPrivateInfoList) {
		this.processPrivateInfoList = processPrivateInfoList;
	}
}
