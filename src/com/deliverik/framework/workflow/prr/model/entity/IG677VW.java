package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.workflow.prr.model.IG677Info;


/**
 * 流程记录与参与用户信息实体
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IG677")
public class IG677VW  implements Serializable, Cloneable, IG677Info {
	/**
	 * 流程记录ID
	 */
	protected Integer prid;
	
	/**
	 * 流程记录类型
	 */
	protected String prtype;
	
	/**
	 * 流程记录子类型
	 */
	protected String prsubtype;
	
	/**
	 * 流程记录状态
	 */
	protected String prstatus;
	
	/**
	 * 流程记录状态子状态
	 */
	protected String prsubstatus;
	
	/**
	 * 流程记录题目
	 */
	protected String prtitle;
	
	/**
	 * 流程记录描述
	 */
	protected String prdesc;
	
	/**
	 * 流程记录建立时间
	 */
	protected String propentime;
	
	/**
	 * 流程记录关闭时间
	 */
	protected String prclosetime;
	
	/**
	 * 流程记录计划执行时间
	 */
	protected String prplantime;
	
	/**
	 * 流程记录计划执行周期
	 */
	protected String prduration;
	
	/**
	 * 流程记录紧急程度
	 */
	protected String prurgency;
	
	/**
	 * 流程记录影响程度
	 */
	protected String primpact;
	
	/**
	 * 流程记录相关资产ID
	 */
	protected Integer prassetid;
	
	/**
	 * 流程记录相关资产名称
	 */
	protected String prassetname;
	
	/**
	 * 流程记录的相关业务
	 */
	protected String prbusiness;
	
	/**
	 * 流程记录执行计划
	 */
	protected String primplplan;
	
	/**
	 * 流程记录恢复计划
	 */
	protected String prbackplan;
	
	/**
	 * 流程记录验证计划
	 */
	protected String prvfyplan;
	
	/**
	 * 流程记录相关项目ID
	 */
	protected Integer pid;
	
	/**
	 * 流程记录相关项目编号
	 */
	protected String pcode;
	
	/**
	 * 流程记录相关项目名称
	 */
	protected String pname;
	
	/**
	 * 流程记录发起者联系方式
	 */
	protected String prinfo;
	
	/**
	 * 流程记录相关流程ID
	 */
	protected Integer prcorid;
	
	/**
	 * 流程记录相关流程类型
	 */
	protected String prcortype;
	
	/**
	 * 流程记录相关流程名称
	 */
	protected String prcortitle;
	
	/**
	 * 流程记录相关资产类型
	 */
	protected String prassetcategory;
	
	/**
	 * 流程记录发起者用户ID
	 */
	protected String pruserid;
	
	/**
	 * 流程记录发起者用户姓名
	 */
	protected String prusername;
	
	/**
	 * 流程记录发起者角色ID
	 */
	protected Integer prroleid;
	
	/**
	 * 流程记录发起者角色名称
	 */
	protected String prrolename;
	
	/**
	 * 流程记录流程类型ID
	 */
	protected String prpdid;
	
	/**
	 * 流程记录流程类型名称
	 */
	protected String prpdname;
	
	/**
	 * 流程记录发起者所属机构层次码
	 */
	protected String prorgid;
	
	/**
	 * 流程记录发起者所属机构名称
	 */
	protected String prorgname;
	
	/**
	 * 流程记录工单号
	 */
	protected String prserialnum;
	
	/**
	 * 流程记录实际解决时间（从开始到结束）
	 */
	protected String prfacttime;
	
	/**
	 * 流程参与用户信息ID
	 */
	@Id
	protected Integer ppid;
	
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
	 * 流程策略版本
	 */
	protected Integer prStrategyVersion;
	
	/**
	 * 流程状态处理完成时间
	 */
	protected Date rslclosetime;
	
	/**
	 * 流程状态ID
	 */
	protected String psdid;
	
	/**
	 * 流程动态分支编号
	 */
	protected Integer psdnum;
	
	/**
	 * 主键取得
	 * @return piid
	 */
	public Serializable getPK() {
		return ppid;
	}


	public boolean equals(Object obj) {
		if (!(obj instanceof IG677VW))
			return false;
		IG677Info target = (IG677Info) obj;
		if (!(getPrid()==target.getPrid()))
			return false;
		if (!(getPpid()==target.getPpid()))
			return false;
		
		return true;
	}


	/**
	 * 流程记录类型取得
	 * @return 流程记录类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 流程记录类型设定
	 * @param prtype 流程记录类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 流程记录子类型取得
	 * @return 流程记录子类型
	 */
	public String getPrsubtype() {
		return prsubtype;
	}

	/**
	 * 流程记录子类型设定
	 * @param prsubtype 流程记录子类型
	 */
	public void setPrsubtype(String prsubtype) {
		this.prsubtype = prsubtype;
	}

	/**
	 * 流程记录状态取得
	 * @return 流程记录状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 流程记录状态设定
	 * @param prstatus 流程记录状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * 流程记录状态子状态取得
	 * @return 流程记录状态子状态
	 */
	public String getPrsubstatus() {
		return prsubstatus;
	}

	/**
	 * 流程记录状态子状态设定
	 * @param prsubstatus 流程记录状态子状态
	 */
	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}

	/**
	 * 流程记录题目取得
	 * @return 流程记录题目
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * 流程记录题目设定
	 * @param prtitle 流程记录题目
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * 流程记录描述取得
	 * @return 流程记录描述
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * 流程记录描述设定
	 * @param prdesc 流程记录描述
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * 流程记录建立时间取得
	 * @return 流程记录建立时间
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * 流程记录建立时间设定
	 * @param propentime 流程记录建立时间
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * 流程记录关闭时间取得
	 * @return 流程记录关闭时间
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * 流程记录关闭时间设定
	 * @param prclosetime 流程记录关闭时间
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * 流程记录计划执行时间取得
	 * @return 流程记录计划执行时间
	 */
	public String getPrplantime() {
		return prplantime;
	}

	/**
	 * 流程记录计划执行时间设定
	 * @param prplantime 流程记录计划执行时间
	 */
	public void setPrplantime(String prplantime) {
		this.prplantime = prplantime;
	}

	/**
	 * 流程记录计划执行周期取得
	 * @return 流程记录计划执行周期
	 */
	public String getPrduration() {
		return prduration;
	}

	/**
	 * 流程记录计划执行周期设定
	 * @param prduration 流程记录计划执行周期
	 */
	public void setPrduration(String prduration) {
		this.prduration = prduration;
	}

	/**
	 * 流程记录紧急程度取得
	 * @return 流程记录紧急程度
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * 流程记录紧急程度设定
	 * @param prurgency 流程记录紧急程度
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	/**
	 * 流程记录影响程度取得
	 * @return 流程记录影响程度
	 */
	public String getPrimpact() {
		return primpact;
	}

	/**
	 * 流程记录影响程度设定
	 * @param primpact 流程记录影响程度
	 */
	public void setPrimpact(String primpact) {
		this.primpact = primpact;
	}

	/**
	 * 流程记录相关资产ID取得
	 * @return 流程记录相关资产ID
	 */
	public Integer getPrassetid() {
		return prassetid;
	}

	/**
	 * 流程记录相关资产ID设定
	 * @param prassetid 流程记录相关资产ID
	 */
	public void setPrassetid(Integer prassetid) {
		this.prassetid = prassetid;
	}

	/**
	 * 流程记录相关资产名称取得
	 * @return 流程记录相关资产名称
	 */
	public String getPrassetname() {
		return prassetname;
	}

	/**
	 * 流程记录相关资产名称设定
	 * @param prassetname 流程记录相关资产名称
	 */
	public void setPrassetname(String prassetname) {
		this.prassetname = prassetname;
	}

	/**
	 * 流程记录的相关业务取得
	 * @return 流程记录的相关业务
	 */
	public String getPrbusiness() {
		return prbusiness;
	}

	/**
	 * 流程记录的相关业务设定
	 * @param prbusiness 流程记录的相关业务
	 */
	public void setPrbusiness(String prbusiness) {
		this.prbusiness = prbusiness;
	}

	/**
	 * 流程记录执行计划取得
	 * @return 流程记录执行计划
	 */
	public String getPrimplplan() {
		return primplplan;
	}

	/**
	 * 流程记录执行计划设定
	 * @param primplplan 流程记录执行计划
	 */
	public void setPrimplplan(String primplplan) {
		this.primplplan = primplplan;
	}

	/**
	 * 流程记录恢复计划取得
	 * @return 流程记录恢复计划
	 */
	public String getPrbackplan() {
		return prbackplan;
	}

	/**
	 * 流程记录恢复计划设定
	 * @param prbackplan 流程记录恢复计划
	 */
	public void setPrbackplan(String prbackplan) {
		this.prbackplan = prbackplan;
	}

	/**
	 * 流程记录验证计划取得
	 * @return 流程记录验证计划
	 */
	public String getPrvfyplan() {
		return prvfyplan;
	}

	/**
	 * 流程记录验证计划设定
	 * @param prvfyplan 流程记录验证计划
	 */
	public void setPrvfyplan(String prvfyplan) {
		this.prvfyplan = prvfyplan;
	}
	
	/**
	 * 流程记录相关项目ID取得
	 * @return 流程记录相关项目ID
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 流程记录相关项目ID设定
	 * @param pid 流程记录相关项目ID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * 流程记录相关项目编号取得
	 * @return 流程记录相关项目编号
	 */
	public String getPcode() {
		return pcode;
	}

	/**
	 * 流程记录相关项目编号设定
	 * @param pcode 流程记录相关项目编号
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/**
	 * 流程记录相关项目名称取得
	 * @return 流程记录相关项目名称
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * 流程记录相关项目名称设定
	 * @param pname 流程记录相关项目名称
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	/**
	 * 流程记录发起者联系方式取得
	 * @return 流程记录发起者联系方式
	 */
	public String getPrinfo() {
		return prinfo;
	}

	/**
	 * 流程记录发起者联系方式设定
	 * @param prinfo 流程记录发起者联系方式
	 */
	public void setPrinfo(String prinfo) {
		this.prinfo = prinfo;
	}

	/**
	 * 流程记录相关流程ID取得
	 * @return 流程记录相关流程ID
	 */
	public Integer getPrcorid() {
		return prcorid;
	}

	/**
	 * 流程记录相关流程ID设定
	 * @param prcorid 流程记录相关流程ID
	 */
	public void setPrcorid(Integer prcorid) {
		this.prcorid = prcorid;
	}

	/**
	 * 流程记录相关流程类型取得
	 * @return 流程记录相关流程类型
	 */
	public String getPrcortype() {
		return prcortype;
	}

	/**
	 * 流程记录相关流程类型设定
	 * @param prcortype 流程记录相关流程类型
	 */
	public void setPrcortype(String prcortype) {
		this.prcortype = prcortype;
	}

	/**
	 * 流程记录相关流程名称取得
	 * @return 流程记录相关流程名称
	 */
	public String getPrcortitle() {
		return prcortitle;
	}

	/**
	 * 流程记录相关流程名称设定
	 * @param prcortitle 流程记录相关流程名称
	 */
	public void setPrcortitle(String prcortitle) {
		this.prcortitle = prcortitle;
	}

	/**
	 * 流程记录相关资产类型取得
	 * @return 流程记录相关资产类型
	 */
	public String getPrassetcategory() {
		return prassetcategory;
	}

	/**
	 * 流程记录相关资产类型设定
	 * @param prassetcategory 流程记录相关资产类型
	 */
	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	/**
	 * 流程记录发起者用户姓名取得
	 * @return 流程记录发起者用户姓名
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * 流程记录发起者用户姓名设定
	 * @param prusername 流程记录发起者用户姓名
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * 流程记录发起者角色名称取得
	 * @return 流程记录发起者角色名称
	 */
	public String getPrrolename() {
		return prrolename;
	}

	/**
	 * 流程记录发起者角色名称设定
	 * @param prrolename 流程记录发起者角色名称
	 */
	public void setPrrolename(String prrolename) {
		this.prrolename = prrolename;
	}

	/**
	 * 流程记录发起者用户ID取得
	 * @return 流程记录发起者用户ID
	 */
	public String getPruserid() {
		return pruserid;
	}

	/**
	 * 流程记录发起者用户ID设定
	 * @param pruserid 流程记录发起者用户ID
	 */
	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}

	/**
	 * 流程记录发起者角色ID取得
	 * @return 流程记录发起者角色ID
	 */
	public Integer getPrroleid() {
		return prroleid;
	}

	/**
	 * 流程记录发起者角色ID设定
	 * @param prroleid 流程记录发起者角色ID
	 */
	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}

	/**
	 * 流程记录流程类型ID取得
	 * @return 流程记录流程类型ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * 流程记录流程类型ID设定
	 * @param prpdid 流程记录流程类型ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * 流程记录流程类型名称取得
	 * @return 流程记录流程类型名称
	 */
	public String getPrpdname() {
		return prpdname;
	}

	/**
	 * 流程记录流程类型名称设定
	 * @param prpdname 流程记录流程类型名称
	 */
	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}

	/**
	 * 流程记录发起者所属机构层次码取得
	 * @return 流程记录发起者所属机构层次码
	 */
	public String getProrgid() {
		return prorgid;
	}

	/**
	 * 流流程记录发起者所属机构层次码设定
	 * @param prorgid 流程记录发起者所属机构层次码
	 */
	public void setProrgid(String prorgid) {
		this.prorgid = prorgid;
	}

	/**
	 * 流程记录发起者所属机构名称取得
	 * @return 流程记录发起者所属机构名称
	 */
	public String getProrgname() {
		return prorgname;
	}

	/**
	 * 流程记录发起者所属机构名称设定
	 * @param prorgname 流程记录发起者所属机构名称
	 */
	public void setProrgname(String prorgname) {
		this.prorgname = prorgname;
	}

	/**
	 * 流程记录工单号取得
	 * @return 流程记录工单号
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * 流程记录工单号设定
	 * @param prserialnum 流程记录工单号
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	/**
	 * 流程记录实际解决时间（从开始到结束）取得
	 * @return 流程记录实际解决时间
	 */
	public String getPrfacttime() {
		return prfacttime;
	}

	/**
	 * 流程记录实际解决时间（从开始到结束）设定
	 * @param piid 流程记录实际解决时间
	 */
	public void setPrfacttime(String prfacttime) {
		this.prfacttime = prfacttime;
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
	 * 流程策略取得
	 * @return 流程策略
	 */
	public Integer getPrStrategyVersion() {
		if(prStrategyVersion != null && prStrategyVersion == 0) {
			return null;
		} else {
			return prStrategyVersion;
		}
	}

	/**
	 * 流程策略设定
	 * @param prStrategyVersion 流程策略
	 */
	public void setPrStrategyVersion(Integer prStrategyVersion) {
		if(prStrategyVersion != null && prStrategyVersion == 0) {
			this.prStrategyVersion = null;
		} else {
			this.prStrategyVersion = prStrategyVersion;
		}
	}

	/**
	 * 流程状态处理完成时间取得
	 * @return 流程状态处理完成时间
	 */
	public Date getRslclosetime() {
		return rslclosetime;
	}

	/**
	 * 流程状态处理完成时间设定
	 * @param rslclosetime 流程状态处理完成时间
	 */
	public void setRslclosetime(Date rslclosetime) {
		this.rslclosetime = rslclosetime;
	}

	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态ID设定
	 * @param psdid 流程状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 流程动态分支编号取得
	 * @return 流程动态分支编号
	 */
	public Integer getPsdnum() {
		return psdnum;
	}

	/**
	 * 流程动态分支编号设定
	 * @param psdnum 流程动态分支编号
	 */
	public void setPsdnum(Integer psdnum) {
		this.psdnum = psdnum;
	}
	
}
