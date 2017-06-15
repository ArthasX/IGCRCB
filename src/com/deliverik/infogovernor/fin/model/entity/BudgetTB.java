package com.deliverik.infogovernor.fin.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.infogovernor.fin.model.Budget;


/**
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="Budget")
public class BudgetTB extends BaseEntity implements Serializable, Cloneable, Budget {

	@Id
	@TableGenerator(
		    name="BUDGET_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="BUDGET_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="BUDGET_TABLE_GENERATOR")
	/** ����ID*/
	protected Integer bid;
	
	/** Ԥ������*/
	protected String btype;
	
	protected String binittime;
	
	/** ��ʼʱ��*/
	protected String bopentime;
	
	/** ״̬*/
	protected String bstatus;
	
	protected String breqid;
	
	protected String bapvid;
	
	/** Ԥ������*/
	protected String btitle;
	
	/** �ر�ʱ��*/
	protected String bclosetime;
	
	/** Ԥ����*/
	protected String bdesc;
	
	protected String binfo;
	
	/** Ԥ�����*/
	protected String byear;
	
	/** ����ID*/
	protected String borgid;
	
	/** ��������*/
	protected String borgname;
	
	protected String breqname;
	
	protected String bapvname;
	
	/** Ԥ���ܶ�*/
	protected Double bamount;
	
	protected String battkey;
	
	protected Integer pid;
	
	protected String pcode;
	
	protected String pname;
	
	/** Ԥ������*/
	protected String pquality;
	
	/** Ԥ����;*/
	protected String puse;
	
	/** ����Ԥ����*/
	protected String pstorecode;
	
	/** ������*/
	protected String pneeddispart;
	
	/** Ԥ�����*/
	protected String pbuggetform;
	
	/** ��ע*/
	protected String remark;

	/** Ԥ�� �ʱ��� ����*/
	protected Double bzdevelop;
	
	/** Ԥ�� �ʱ��� Ӳ��*/
	protected Double bzhardware;
	
	/** Ԥ�� �ʱ��� ���*/
	protected Double bzsoftware;
	
	/** Ԥ�� �ʱ��� ����*/
	protected Double bzproject;
	
	/** Ԥ�� �ʱ��� ����*/
	protected Double bzelse;
	
	/** Ԥ�� �ɱ��� ʵʩ*/
	protected Double bcimplement;
	
	/** Ԥ�� �ɱ��� ����*/
	protected Double bcelse;
	
	/**
	 * ��ȡԤ���ʱ��𿪷�
	 * @return fbzdevelop Ԥ���ʱ��𿪷�
	 */
	public Double getBzdevelop() {
		return bzdevelop;
	}

	/**
	 * ����Ԥ���ʱ��𿪷�
	 * @param bzdevelop  Ԥ���ʱ��𿪷�
	 */
	public void setBzdevelop(Double bzdevelop) {
		this.bzdevelop = bzdevelop;
	}

	/**
	 * ��ȡԤ���ʱ���Ӳ��
	 * @return fbzhardware Ԥ���ʱ���Ӳ��
	 */
	public Double getBzhardware() {
		return bzhardware;
	}

	/**
	 * ����Ԥ���ʱ���Ӳ��
	 * @param bzhardware  Ԥ���ʱ���Ӳ��
	 */
	public void setBzhardware(Double bzhardware) {
		this.bzhardware = bzhardware;
	}

	/**
	 * ��ȡԤ���ʱ������
	 * @return fbzsoftware Ԥ���ʱ������
	 */
	public Double getBzsoftware() {
		return bzsoftware;
	}

	/**
	 * ����Ԥ���ʱ������
	 * @param bzsoftware  Ԥ���ʱ������
	 */
	public void setBzsoftware(Double bzsoftware) {
		this.bzsoftware = bzsoftware;
	}

	/**
	 * ��ȡԤ���ʱ��𹤳�
	 * @return fbzproject Ԥ���ʱ��𹤳�
	 */
	public Double getBzproject() {
		return bzproject;
	}

	/**
	 * ����Ԥ���ʱ��𹤳�
	 * @param bzproject  Ԥ���ʱ��𹤳�
	 */
	public void setBzproject(Double bzproject) {
		this.bzproject = bzproject;
	}

	/**
	 * ��ȡԤ���ʱ�������
	 * @return fbzelse Ԥ���ʱ�������
	 */
	public Double getBzelse() {
		return bzelse;
	}

	/**
	 * ����Ԥ���ʱ�������
	 * @param bzelse  Ԥ���ʱ�������
	 */
	public void setBzelse(Double bzelse) {
		this.bzelse = bzelse;
	}

	/**
	 * ��ȡԤ��ɱ���ʵʩ
	 * @return fbcimplement Ԥ��ɱ���ʵʩ
	 */
	public Double getBcimplement() {
		return bcimplement;
	}

	/**
	 * ����Ԥ��ɱ���ʵʩ
	 * @param bcimplement  Ԥ��ɱ���ʵʩ
	 */
	public void setBcimplement(Double bcimplement) {
		this.bcimplement = bcimplement;
	}

	/**
	 * ��ȡԤ��ɱ�������
	 * @return fbcelse Ԥ��ɱ�������
	 */
	public Double getBcelse() {
		return bcelse;
	}

	/**
	 * ����Ԥ��ɱ�������
	 * @param bcelse  Ԥ��ɱ�������
	 */
	public void setBcelse(Double bcelse) {
		this.bcelse = bcelse;
	}

	public String getPuse() {
		return puse;
	}

	public void setPuse(String puse) {
		this.puse = puse;
	}

	public String getPquality() {
		return pquality;
	}

	public void setPquality(String pquality) {
		this.pquality = pquality;
	}

	public String getPstorecode() {
		return pstorecode;
	}

	public void setPstorecode(String pstorecode) {
		this.pstorecode = pstorecode;
	}

	public String getPneeddispart() {
		return pneeddispart;
	}

	public void setPneeddispart(String pneeddispart) {
		this.pneeddispart = pneeddispart;
	}

	public String getPbuggetform() {
		return pbuggetform;
	}

	public void setPbuggetform(String pbuggetform) {
		this.pbuggetform = pbuggetform;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/** ����ʵ�� */
	@OneToOne
	@JoinColumn(name="borgid", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB organizationTB;

	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}

	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}
	
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * 
	 * @return 
	 */
	public Serializable getPK() {
		return bid;
	}

	/**
	 * @return 
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof BudgetTB))
			return false;
		Budget target = (Budget) obj;
		if (!(getBid()==target.getBid()))
			return false;

		return true;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Budget#getBid()
	 */
	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Budget#getBtype()
	 */
	public String getBtype() {
		return btype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Budget#getBinittime()
	 */
	public String getBinittime() {
		return binittime;
	}

	public void setBinittime(String binittime) {
		this.binittime = binittime;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Budget#getBopentime()
	 */
	public String getBopentime() {
		return bopentime;
	}

	public void setBopentime(String bopentime) {
		this.bopentime = bopentime;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Budget#getBstatus()
	 */
	public String getBstatus() {
		return bstatus;
	}

	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Budget#getBreqid()
	 */
	public String getBreqid() {
		return breqid;
	}

	public void setBreqid(String breqid) {
		this.breqid = breqid;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Budget#getBapvid()
	 */
	public String getBapvid() {
		return bapvid;
	}

	public void setBapvid(String bapvid) {
		this.bapvid = bapvid;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Budget#getBtitle()
	 */
	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Budget#getBclosetime()
	 */
	public String getBclosetime() {
		return bclosetime;
	}

	public void setBclosetime(String bclosetime) {
		this.bclosetime = bclosetime;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Budget#getBdesc()
	 */
	public String getBdesc() {
		return bdesc;
	}

	public void setBdesc(String bdesc) {
		this.bdesc = bdesc;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Budget#getBinfo()
	 */
	public String getBinfo() {
		return binfo;
	}

	public void setBinfo(String binfo) {
		this.binfo = binfo;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Budget#getByear()
	 */
	public String getByear() {
		return byear;
	}

	public void setByear(String byear) {
		this.byear = byear;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Budget#getBorgid()
	 */
	public String getBorgid() {
		return borgid;
	}

	public void setBorgid(String borgid) {
		this.borgid = borgid;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Budget#getBorgname()
	 */
	public String getBorgname() {
		if(getOrganizationTB()==null){
			return borgname;
		}else{
			return getOrganizationTB().getOrgname();
		}
		
	}

	public void setBorgname(String borgname) {
		this.borgname = borgname;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Budget#getBreqname()
	 */
	public String getBreqname() {
		return breqname;
	}

	public void setBreqname(String breqname) {
		this.breqname = breqname;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Budget#getBapvname()
	 */
	public String getBapvname() {
		return bapvname;
	}

	public void setBapvname(String bapvname) {
		this.bapvname = bapvname;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Budget#getBamount()
	 */
	public Double getBamount() {
		return bamount;
	}

	public void setBamount(Double bamount) {
		this.bamount = bamount;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.fin.model.entity.Budget#getBattkey()
	 */
	public String getBattkey() {
		return battkey;
	}

	public void setBattkey(String battkey) {
		this.battkey = battkey;
	}

}
