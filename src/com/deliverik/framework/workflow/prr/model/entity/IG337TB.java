package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.workflow.prr.model.IG337Info;

/**
 * 流程参与用户信息实体
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IG337")
public class IG337TB extends BaseEntity implements Serializable, Cloneable, IG337Info {

	/**
	 * 流程参与用户信息ID
	 */
	@Id
	@TableGenerator(
		    name="IG337_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG337_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG337_TABLE_GENERATOR")
	protected Integer ppid;
	
	/**
	 * 流程记录ID
	 */
	protected Integer prid;
	
	/**
	 * 流程参与用户角色ID
	 */
	protected Integer pproleid;
	
	/**
	 * 流程参与用户所属机构层次码
	 */
	protected String pporgid;
	
	/**
	 * 流程参与用户所属机构名称
	 */
	protected String pporgname;
	
	/**
	 * 流程参与用户角色名称
	 */
	protected String pprolename;
	
	/**
	 * 流程参与用户ID
	 */
	protected String ppuserid;
	
	/**
	 * 流程参与用户名字
	 */
	protected String ppusername;
	
	/**
	 * 流程参与用户的参与类型
	 */
	protected String pptype;
	
	/**
	 * 流程参与用户的信息（联系方式等）
	 */
	protected String ppuserinfo;
	
	/**
	 * 流程参与用户的工作评语
	 */
	protected String ppcomment;
	
	/**
	 * 流程参与用户的参与状态
	 */
	protected String ppstatus;
	
	/**
	 * 附件索引KEY
	 */
	protected String ppattkey;
	
	/**
	 * 流程参与用户指定时间
	 */
	protected String ppinittime;
	
	/**
	 * 流程参与用户处理完成时间
	 */
	protected String ppproctime;
	
	/**
	 * 流程参与用户子状态
	 */
	protected String ppsubstatus;
	
	/**
	 * 流程参与用户实际解决时间
	 */
	protected Integer ppfacttime;
	
	/**
	 * 流程回退指定时间
	 */
	protected String ppbacktime;
	
	/**
	 * 流程super参与者标识
	 */
	public String ppsuper;
	
	/**
	 * 流程参与者角色负责人标识
	 */
	public String pprolemanager;
	
	/**
	 * 流程参与者值班人标识
	 */
	public String ppdutyperson;

	/** 流程状态定义ID */
	protected String psdid;

	/** 动态分支编号 */
	protected Integer psdnum;
	
	/**
	 * 流程参与代理人id
	 */
	public String ppproxyuserid;
	
	/** 按钮定义ID */
	public String pbdid;
	
	/**
	 * 主键取得
	 * @return ppid
	 */
	public Serializable getPK() {
		return ppid;
	}


	public boolean equals(Object obj) {
		if (!(obj instanceof IG337TB))
			return false;
		IG337Info target = (IG337Info) obj;
		if (!(getPpid()==target.getPpid()))
			return false;

		return true;
	}
	
	/**
	 * 流程参与用户所属机构名称取得
	 * @return 流程参与用户所属机构名称
	 */
	public String getPporgname() {
		return pporgname;
	}

	/**
	 * 流程参与用户所属机构名称设定
	 * @param pporgname 流程参与用户所属机构名称
	 */
	public void setPporgname(String pporgname) {
		this.pporgname = pporgname;
	}

	

	/**
	 * 流程参与用户信息ID取得
	 * @return 流程参与用户信息ID
	 */
	public Integer getPpid() {
		return ppid;
	}

	/**
	 * 流程参与用户信息ID设定
	 * @param ppid 流程参与用户信息ID
	 */
	public void setPpid(Integer ppid) {
		this.ppid = ppid;
	}

	/**
	 * 流程记录ID取得
	 * @return 流程记录ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程记录ID设定
	 * @param prid 流程记录ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	/**
	 * 流程参与用户所属机构层次码取得
	 * @return 流程参与用户所属机构层次码
	 */
	public String getPporgid() {
		return pporgid;
	}

	/**
	 * 流程参与用户所属机构层次码设定
	 * @param pporgid 流程参与用户所属机构层次码
	 */
	public void setPporgid(String pporgid) {
		this.pporgid = pporgid;
	}

	/**
	 * 流程参与用户角色ID取得
	 * @return 流程参与用户角色ID
	 */
	public Integer getPproleid() {
		return pproleid;
	}

	/**
	 * 流程参与用户角色ID设定
	 * @param pproleid 流程参与用户角色ID
	 */
	public void setPproleid(Integer pproleid) {
		this.pproleid = pproleid;
	}

	/**
	 * 流程参与用户角色名称取得
	 * @return 流程参与用户角色名称
	 */
	public String getPprolename() {
		return pprolename;
	}

	/**
	 * 流程参与用户角色名称设定
	 * @param pprolename 流程参与用户角色名称
	 */
	public void setPprolename(String pprolename) {
		this.pprolename = pprolename;
	}

	/**
	 * 流程参与用户ID取得
	 * @return 流程参与用户ID
	 */
	public String getPpuserid() {
		return ppuserid;
	}

	/**
	 * 流程参与用户ID设定
	 * @param ppuserid 流程参与用户ID
	 */
	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}

	/**
	 * 流程参与用户名字取得
	 * @return 流程参与用户名字
	 */
	public String getPpusername() {
		return ppusername;
	}

	/**
	 * 流程参与用户名字设定
	 * @param ppusername 流程参与用户名字
	 */
	public void setPpusername(String ppusername) {
		this.ppusername = ppusername;
	}

	/**
	 * 流程参与用户的参与类型取得
	 * @return 流程参与用户的参与类型
	 */
	public String getPptype() {
		return pptype;
	}

	/**
	 * 流程参与用户的参与类型设定
	 * @param pptype 流程参与用户的参与类型
	 */
	public void setPptype(String pptype) {
		this.pptype = pptype;
	}

	/**
	 * 流程参与用户的信息（联系方式等）取得
	 * @return 流程参与用户的信息（联系方式等）
	 */
	public String getPpuserinfo() {
		return ppuserinfo;
	}

	/**
	 * 流程参与用户的信息（联系方式等）设定
	 * @param ppuserinfo 流程参与用户的信息
	 */
	public void setPpuserinfo(String ppuserinfo) {
		this.ppuserinfo = ppuserinfo;
	}

	/**
	 * 流程参与用户的工作评语取得
	 * @return 流程参与用户的工作评语
	 */
	public String getPpcomment() {
		return ppcomment;
	}

	/**
	 * 流程参与用户的工作评语设定
	 * @param ppcomment 流程参与用户的工作评语
	 */
	public void setPpcomment(String ppcomment) {
		this.ppcomment = ppcomment;
	}

	/**
	 * 流程参与用户的参与状态取得
	 * @return 流程参与用户的参与状态
	 */
	public String getPpstatus() {
		return ppstatus;
	}

	/**
	 * 流程参与用户的参与状态设定
	 * @param ppstatus 流程参与用户的参与状态
	 */
	public void setPpstatus(String ppstatus) {
		this.ppstatus = ppstatus;
	}

	/**
	 * 附件索引KEY取得
	 * @return 附件索引KEY
	 */
	public String getPpattkey() {
		return ppattkey;
	}

	/**
	 * 附件索引KEY设定
	 * @param ppattkey 附件索引KEY
	 */
	public void setPpattkey(String ppattkey) {
		this.ppattkey = ppattkey;
	}

	/**
	 * 流程参与用户指定时间取得
	 * @return 流程参与用户指定时间
	 */
	public String getPpinittime() {
		return ppinittime;
	}

	/**
	 * 流程参与用户指定时间设定
	 * @param ppinittime 流程参与用户指定时间
	 */
	public void setPpinittime(String ppinittime) {
		this.ppinittime = ppinittime;
	}

	/**
	 * 流程参与用户处理完成时间取得
	 * @return 流程参与用户处理完成时间
	 */
	public String getPpproctime() {
		return ppproctime;
	}

	/**
	 * 流程参与用户处理完成时间设定
	 * @param ppproctime 流程参与用户处理完成时间
	 */
	public void setPpproctime(String ppproctime) {
		this.ppproctime = ppproctime;
	}

	/**
	 * 流程参与用户子状态取得
	 * @return 流程参与用户子状态
	 */
	public String getPpsubstatus() {
		return ppsubstatus;
	}

	/**
	 * 流程参与用户子状态设定
	 * @param ppsubstatus 流程参与用户子状态
	 */
	public void setPpsubstatus(String ppsubstatus) {
		this.ppsubstatus = ppsubstatus;
	}

	/**
	 * 流程参与用户实际解决时间取得
	 * @return 流程参与用户实际解决时间
	 */
	public Integer getPpfacttime() {
		return ppfacttime;
	}

	/**
	 * 流程参与用户实际解决时间设定
	 * @param ppfacttime 流程参与用户实际解决时间
	 */
	public void setPpfacttime(Integer ppfacttime) {
		this.ppfacttime = ppfacttime;
	}

	/**
	 * 流程回退指定时间取得
	 * @return 流程回退指定时间
	 */
	public String getPpbacktime() {
		return ppbacktime;
	}

	/**
	 * 流程回退指定时间设定
	 * @param ppbacktime 流程回退指定时间
	 */
	public void setPpbacktime(String ppbacktime) {
		this.ppbacktime = ppbacktime;
	}
	
	/**
	 * 流程super参与者标识取得
	 * @return 流程super参与者标识
	 */
	public String getPpsuper() {
		return ppsuper;
	}

	/**
	 * 流程super参与者标识设定
	 * @param ppsuper流程super参与者标识
	 */
	public void setPpsuper(String ppsuper) {
		this.ppsuper = ppsuper;
	}

	/**
	 * 流程参与者角色负责人标识取得
	 * @return 流程参与者角色负责人标识
	 */
	public String getPprolemanager() {
		return pprolemanager;
	}

	/**
	 * 流程参与者角色负责人标识设定
	 * @param pprolemanager流程参与者角色负责人标识
	 */
	public void setPprolemanager(String pprolemanager) {
		this.pprolemanager = pprolemanager;
	}

	/**
	 * 流程参与者值班人标识取得
	 * @return 流程参与者值班人标识
	 */
	public String getPpdutyperson() {
		return ppdutyperson;
	}

	/**
	 * 流程参与者值班人标识设定
	 * @param ppdutyperson流程参与者值班人标识
	 */
	public void setPpdutyperson(String ppdutyperson) {
		this.ppdutyperson = ppdutyperson;
	}

	/**
	 * 流程参与代理人取得
	 * @return 流程参与代理人
	 */
	public String getPpproxyuserid() {
		return ppproxyuserid;
	}

	/**
	 * 流程参与代理人设定
	 * @param ppproxyuserid 流程参与代理人
	 */
	public void setPpproxyuserid(String ppproxyuserid) {
		this.ppproxyuserid = ppproxyuserid;
	}

	/**
	 * 按钮定义ID取得
	 * 
	 * @return 按钮定义ID
	 */
	public String getPbdid() {
		return pbdid;
	}

	/**
	 * 按钮定义ID设定
	 * 
	 * @param pbdid 按钮定义ID
	 */
	public void setPbdid(String pbdid) {
		this.pbdid = pbdid;
	}

	/**
	 * 流程状态定义ID取得
	 * @return 流程状态定义ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态定义ID设定
	 * @param psdid 流程状态定义ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 动态分支编号取得
	 * @return 动态分支编号
	 */
	public Integer getPsdnum() {
		return psdnum;
	}

	/**
	 * 动态分支编号设定
	 * @param psdnum 动态分支编号
	 */
	public void setPsdnum(Integer psdnum) {
		this.psdnum = psdnum;
	}
	public UserTB getProxyUserTB() {
		return null;
	}
	
}
