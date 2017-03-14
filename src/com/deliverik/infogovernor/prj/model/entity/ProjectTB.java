package com.deliverik.infogovernor.prj.model.entity;

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
import com.deliverik.infogovernor.fin.model.entity.BudgetTB;
import com.deliverik.infogovernor.prj.model.Project;


/**
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="Project")
public class ProjectTB extends BaseEntity implements Serializable, Cloneable, Project {

	@Id
	@TableGenerator(
		    name="PROJECT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="PROJECT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="PROJECT_TABLE_GENERATOR")
	/** 主键ID*/
	protected Integer pid;

	/** 项目类型*/
	protected String ptype;
	
	/** 项目编号*/
	protected String pcode;
	
	/** 项目名称*/
	protected String pname;
	
	/** 项目简介*/
	protected String pdesc;
	
	protected String pinfo;
	
	/** 开始时间*/
	protected String popentime;
	
	/** 结束时间*/
	protected String pclosetime;
	
	/** 状态*/
	protected String pstatus;
	
	/** 登记人机构ID*/
	protected String porg;
	
	/** 登记人角色*/
	protected String prole;
	
	/** 登记人*/
	protected String puser;
	
	/** 项目预算，对应预算表中的预算名称*/
	protected String pamount;
	
	/** 项目用途*/
	protected String ppurpose;
	
	/** 项目预算用途*/
	protected String puse;
	
	/** 项目预算额度*/
	protected Double plimit;
	
	/** 需求部门*/
	protected String pbranch;
	
	/** 预算主表ID*/
	protected Integer pbid;
	
	/** 项目目的*/
	protected String paim;
	
	/** 使用预算*/
	protected String isUseBudget;
	
	/** 计划结束时间 */
	protected String pplanclosetime;
	
	/** 项目 资本金 开发*/
	protected Double pzdevelop;
	
	/** 项目 资本金 硬件*/
	protected Double pzhardware;
	
	/** 项目 资本金 软件*/
	protected Double pzsoftware;
	
	/** 项目 资本金 工程*/
	protected Double pzproject;
	
	/** 项目 资本金 其他*/
	protected Double pzelse;
	
	/** 项目 成本金 实施*/
	protected Double pcimplement;
	
	/** 项目 成本金 其他*/
	protected Double pcelse;
	
	/** 合同编号 */
	protected Integer plcid;
	
	/** 项目性质 */
	protected String ppquality ;
	
	/** 用户机构信息实体 */
	@OneToOne
	@JoinColumn(name="pbid", referencedColumnName="bid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected  BudgetTB budgetTB;

	public Serializable getPK() {
		return pid;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof ProjectTB))
			return false;
		Project target = (Project) obj;
		if (!(getPid()==target.getPid()))
			return false;

		return true;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
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

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public String getPinfo() {
		return pinfo;
	}

	public void setPinfo(String pinfo) {
		this.pinfo = pinfo;
	}

	public String getPopentime() {
		return popentime;
	}

	public void setPopentime(String popentime) {
		this.popentime = popentime;
	}

	public String getPclosetime() {
		return pclosetime;
	}

	public void setPclosetime(String pclosetime) {
		this.pclosetime = pclosetime;
	}

	public String getPstatus() {
		return pstatus;
	}

	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}

	public String getPorg() {
		return porg;
	}

	public void setPorg(String porg) {
		this.porg = porg;
	}

	public String getProle() {
		return prole;
	}

	public void setProle(String prole) {
		this.prole = prole;
	}

	public String getPuser() {
		return puser;
	}

	public void setPuser(String puser) {
		this.puser = puser;
	}

	public String getPamount() {
		return pamount;
	}

	public void setPamount(String pamount) {
		this.pamount = pamount;
	}

	/**
	 * 计划结束时间取得
	 * @return pplanclosetime 计划结束时间
	 */
	public String getPplanclosetime() {
		return pplanclosetime;
	}

	/**
	 * 计划结束时间设定
	 * @param pplanclosetime 计划结束时间
	 */
	public void setPplanclosetime(String pplanclosetime) {
		this.pplanclosetime = pplanclosetime;
	}

	public String getPuse() {
		return puse;
	}

	public void setPuse(String puse) {
		this.puse = puse;
	}

	public Double getPlimit() {
		return plimit;
	}

	public void setPlimit(Double plimit) {
		this.plimit = plimit;
	}

	public String getPbranch() {
		return pbranch;
	}

	public void setPbranch(String pbranch) {
		this.pbranch = pbranch;
	}

	public Integer getPbid() {
		return pbid;
	}

	public void setPbid(Integer pbid) {
		this.pbid = pbid;
	}

	public String getPaim() {
		return paim;
	}

	public void setPaim(String paim) {
		this.paim = paim;
	}

	/**
	 * 获取项目用途
	 * @return fppurpose 项目用途
	 */
	public String getPpurpose() {
		return ppurpose;
	}

	/**
	 * 设置项目用途
	 * @param ppurpose  项目用途
	 */
	public void setPpurpose(String ppurpose) {
		this.ppurpose = ppurpose;
	}
	
	/**
	 * 预算表实体
	 * @param ppurpose  预算表实体
	 */
	public BudgetTB getBudgetTB() {
		return budgetTB;
	}
	/**
	 * 设置预算表实体
	 * @param ppurpose  预算表实体
	 */
	public void setBudgetTB(BudgetTB budgetTB) {
		this.budgetTB = budgetTB;
	}
	
	/**
	 * 获取使用预算
	 * @return fisUseBudget 使用预算
	 */
	public String getIsUseBudget() {
		return isUseBudget;
	}

	/**
	 * 设置使用预算
	 * @param isUseBudget  使用预算
	 */
	public void setIsUseBudget(String isUseBudget) {
		this.isUseBudget = isUseBudget;
	}
	

	/**
	 * 项目资本金开发取得
	 * @return pbzdevelop 项目资本金开发
	 */
	public Double getPzdevelop() {
		return pzdevelop;
	}

	/**
	 * 项目资本金开发设定
	 * @param pbzdevelop 项目资本金开发
	 */
	public void setPzdevelop(Double pzdevelop) {
		this.pzdevelop = pzdevelop;
	}

	/**
	 * 项目资本金硬件取得
	 * @return pbzhardware 项目资本金硬件
	 */
	public Double getPzhardware() {
		return pzhardware;
	}

	/**
	 * 项目资本金硬件设定
	 * @param pbzhardware 项目资本金硬件
	 */
	public void setPzhardware(Double pzhardware) {
		this.pzhardware = pzhardware;
	}

	/**
	 * 项目资本金软件取得
	 * @return pbzsoftware 项目资本金软件
	 */
	public Double getPzsoftware() {
		return pzsoftware;
	}

	/**
	 * 项目资本金软件设定
	 * @param pbzsoftware 项目资本金软件
	 */
	public void setPzsoftware(Double pzsoftware) {
		this.pzsoftware = pzsoftware;
	}

	/**
	 * 项目资本金工程取得
	 * @return pbzproject 项目资本金工程
	 */
	public Double getPzproject() {
		return pzproject;
	}

	/**
	 * 项目资本金工程设定
	 * @param pbzproject 项目资本金工程
	 */
	public void setPzproject(Double pzproject) {
		this.pzproject = pzproject;
	}

	/**
	 * 项目资本金其他取得
	 * @return pbzelse 项目资本金其他
	 */
	public Double getPzelse() {
		return pzelse;
	}

	/**
	 * 项目资本金其他设定
	 * @param pbzelse 项目资本金其他
	 */
	public void setPzelse(Double pzelse) {
		this.pzelse = pzelse;
	}

	/**
	 * 项目成本金实施取得
	 * @return pbcimplement 项目成本金实施
	 */
	public Double getPcimplement() {
		return pcimplement;
	}

	/**
	 * 项目成本金实施设定
	 * @param pbcimplement 项目成本金实施
	 */
	public void setPcimplement(Double pcimplement) {
		this.pcimplement = pcimplement;
	}

	/**
	 * 项目成本金其他取得
	 * @return pbcelse 项目成本金其他
	 */
	public Double getPcelse() {
		return pcelse;
	}

	/**
	 * 项目成本金其他设定
	 * @param pbcelse 项目成本金其他
	 */
	public void setPcelse(Double pcelse) {
		this.pcelse = pcelse;
	}
	
	/**
	 * 合同编号取得
	 * @return plcid 合同编号
	 */
	public Integer getPlcid() {
		return plcid;
	}

	/**
	 * 合同编号设定
	 * @param plcid 合同编号
	 */
	public void setPlcid(Integer plcid) {
		this.plcid = plcid;
	}

	/**
	 * 项目性质取得
	 * @return ppquality 项目性质
	 */
	public String getPpquality() {
		return ppquality;
	}

	/**
	 * 项目性质设定
	 * @param ppquality 项目性质
	 */
	public void setPpquality(String ppquality) {
		this.ppquality = ppquality;
	}

	public ProjectTB clone(Project project){
		this.setPclosetime(project.getPclosetime());
		this.setPcode(project.getPcode());
		this.setPdesc(project.getPdesc());
		this.setPinfo(project.getPinfo());
		this.setPname(project.getPname());
		this.setPopentime(project.getPopentime());
		this.setPorg(project.getPorg());
		this.setProle(project.getProle());
		this.setPstatus(project.getPstatus());
		this.setPtype(project.getPtype());
		this.setPuser(project.getPuser());
		this.setPamount(project.getPamount());
		this.setPuse(project.getPuse());
		this.setPbranch(project.getPbranch());
		this.setPbid(project.getPbid());
		this.setPlimit(project.getPlimit());
		this.setPaim(project.getPaim());
		this.setPpurpose(project.getPpurpose());
		this.setBudgetTB(project.getBudgetTB());
		return this;
	}

}
