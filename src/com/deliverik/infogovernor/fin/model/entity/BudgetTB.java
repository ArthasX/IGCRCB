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
	/** 主键ID*/
	protected Integer bid;
	
	/** 预算类型*/
	protected String btype;
	
	protected String binittime;
	
	/** 开始时间*/
	protected String bopentime;
	
	/** 状态*/
	protected String bstatus;
	
	protected String breqid;
	
	protected String bapvid;
	
	/** 预算名称*/
	protected String btitle;
	
	/** 关闭时间*/
	protected String bclosetime;
	
	/** 预算简介*/
	protected String bdesc;
	
	protected String binfo;
	
	/** 预算年份*/
	protected String byear;
	
	/** 机构ID*/
	protected String borgid;
	
	/** 机构名称*/
	protected String borgname;
	
	protected String breqname;
	
	protected String bapvname;
	
	/** 预算总额*/
	protected Double bamount;
	
	protected String battkey;
	
	protected Integer pid;
	
	protected String pcode;
	
	protected String pname;
	
	/** 预算性质*/
	protected String pquality;
	
	/** 预算用途*/
	protected String puse;
	
	/** 储备预算编号*/
	protected String pstorecode;
	
	/** 需求部门*/
	protected String pneeddispart;
	
	/** 预算组成*/
	protected String pbuggetform;
	
	/** 备注*/
	protected String remark;

	/** 预算 资本金 开发*/
	protected Double bzdevelop;
	
	/** 预算 资本金 硬件*/
	protected Double bzhardware;
	
	/** 预算 资本金 软件*/
	protected Double bzsoftware;
	
	/** 预算 资本金 工程*/
	protected Double bzproject;
	
	/** 预算 资本金 其他*/
	protected Double bzelse;
	
	/** 预算 成本金 实施*/
	protected Double bcimplement;
	
	/** 预算 成本金 其他*/
	protected Double bcelse;
	
	/**
	 * 获取预算资本金开发
	 * @return fbzdevelop 预算资本金开发
	 */
	public Double getBzdevelop() {
		return bzdevelop;
	}

	/**
	 * 设置预算资本金开发
	 * @param bzdevelop  预算资本金开发
	 */
	public void setBzdevelop(Double bzdevelop) {
		this.bzdevelop = bzdevelop;
	}

	/**
	 * 获取预算资本金硬件
	 * @return fbzhardware 预算资本金硬件
	 */
	public Double getBzhardware() {
		return bzhardware;
	}

	/**
	 * 设置预算资本金硬件
	 * @param bzhardware  预算资本金硬件
	 */
	public void setBzhardware(Double bzhardware) {
		this.bzhardware = bzhardware;
	}

	/**
	 * 获取预算资本金软件
	 * @return fbzsoftware 预算资本金软件
	 */
	public Double getBzsoftware() {
		return bzsoftware;
	}

	/**
	 * 设置预算资本金软件
	 * @param bzsoftware  预算资本金软件
	 */
	public void setBzsoftware(Double bzsoftware) {
		this.bzsoftware = bzsoftware;
	}

	/**
	 * 获取预算资本金工程
	 * @return fbzproject 预算资本金工程
	 */
	public Double getBzproject() {
		return bzproject;
	}

	/**
	 * 设置预算资本金工程
	 * @param bzproject  预算资本金工程
	 */
	public void setBzproject(Double bzproject) {
		this.bzproject = bzproject;
	}

	/**
	 * 获取预算资本金其他
	 * @return fbzelse 预算资本金其他
	 */
	public Double getBzelse() {
		return bzelse;
	}

	/**
	 * 设置预算资本金其他
	 * @param bzelse  预算资本金其他
	 */
	public void setBzelse(Double bzelse) {
		this.bzelse = bzelse;
	}

	/**
	 * 获取预算成本金实施
	 * @return fbcimplement 预算成本金实施
	 */
	public Double getBcimplement() {
		return bcimplement;
	}

	/**
	 * 设置预算成本金实施
	 * @param bcimplement  预算成本金实施
	 */
	public void setBcimplement(Double bcimplement) {
		this.bcimplement = bcimplement;
	}

	/**
	 * 获取预算成本金其他
	 * @return fbcelse 预算成本金其他
	 */
	public Double getBcelse() {
		return bcelse;
	}

	/**
	 * 设置预算成本金其他
	 * @param bcelse  预算成本金其他
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

	/** 机构实体 */
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
