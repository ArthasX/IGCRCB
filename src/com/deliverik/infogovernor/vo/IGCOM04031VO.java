package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.Date;

import com.deliverik.framework.workflow.prr.model.IG677Info;

public class IGCOM04031VO implements Serializable,IG677Info {
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
	 * 流程动态分支编号
	 */
	protected Integer psdnum;
	
	/**
	 * 流程状态ID
	 */
	protected String psdid;

	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	public String getPrtype() {
		return prtype;
	}

	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	public String getPrsubtype() {
		return prsubtype;
	}

	public void setPrsubtype(String prsubtype) {
		this.prsubtype = prsubtype;
	}

	public String getPrstatus() {
		return prstatus;
	}

	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	public String getPrsubstatus() {
		return prsubstatus;
	}

	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}

	public String getPrtitle() {
		return prtitle;
	}

	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	public String getPrdesc() {
		return prdesc;
	}

	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	public String getPropentime() {
		return propentime;
	}

	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	public String getPrclosetime() {
		return prclosetime;
	}

	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	public String getPrplantime() {
		return prplantime;
	}

	public void setPrplantime(String prplantime) {
		this.prplantime = prplantime;
	}

	public String getPrduration() {
		return prduration;
	}

	public void setPrduration(String prduration) {
		this.prduration = prduration;
	}

	public String getPrurgency() {
		return prurgency;
	}

	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	public String getPrimpact() {
		return primpact;
	}

	public void setPrimpact(String primpact) {
		this.primpact = primpact;
	}

	public Integer getPrassetid() {
		return prassetid;
	}

	public void setPrassetid(Integer prassetid) {
		this.prassetid = prassetid;
	}

	public String getPrassetname() {
		return prassetname;
	}

	public void setPrassetname(String prassetname) {
		this.prassetname = prassetname;
	}

	public String getPrbusiness() {
		return prbusiness;
	}

	public void setPrbusiness(String prbusiness) {
		this.prbusiness = prbusiness;
	}

	public String getPrimplplan() {
		return primplplan;
	}

	public void setPrimplplan(String primplplan) {
		this.primplplan = primplplan;
	}

	public String getPrbackplan() {
		return prbackplan;
	}

	public void setPrbackplan(String prbackplan) {
		this.prbackplan = prbackplan;
	}

	public String getPrvfyplan() {
		return prvfyplan;
	}

	public void setPrvfyplan(String prvfyplan) {
		this.prvfyplan = prvfyplan;
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

	public String getPrinfo() {
		return prinfo;
	}

	public void setPrinfo(String prinfo) {
		this.prinfo = prinfo;
	}

	public Integer getPrcorid() {
		return prcorid;
	}

	public void setPrcorid(Integer prcorid) {
		this.prcorid = prcorid;
	}

	public String getPrcortype() {
		return prcortype;
	}

	public void setPrcortype(String prcortype) {
		this.prcortype = prcortype;
	}

	public String getPrcortitle() {
		return prcortitle;
	}

	public void setPrcortitle(String prcortitle) {
		this.prcortitle = prcortitle;
	}

	public String getPrassetcategory() {
		return prassetcategory;
	}

	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	public String getPruserid() {
		return pruserid;
	}

	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}

	public String getPrusername() {
		return prusername;
	}

	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	public Integer getPrroleid() {
		return prroleid;
	}

	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}

	public String getPrrolename() {
		return prrolename;
	}

	public void setPrrolename(String prrolename) {
		this.prrolename = prrolename;
	}

	public String getPrpdid() {
		return prpdid;
	}

	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	public String getPrpdname() {
		return prpdname;
	}

	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}

	public String getProrgid() {
		return prorgid;
	}

	public void setProrgid(String prorgid) {
		this.prorgid = prorgid;
	}

	public String getProrgname() {
		return prorgname;
	}

	public void setProrgname(String prorgname) {
		this.prorgname = prorgname;
	}

	public String getPrserialnum() {
		return prserialnum;
	}

	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	public String getPrfacttime() {
		return prfacttime;
	}

	public void setPrfacttime(String prfacttime) {
		this.prfacttime = prfacttime;
	}

	public Integer getPpid() {
		return ppid;
	}

	public void setPpid(Integer ppid) {
		this.ppid = ppid;
	}

	public Integer getPproleid() {
		return pproleid;
	}

	public void setPproleid(Integer pproleid) {
		this.pproleid = pproleid;
	}

	public String getPporgid() {
		return pporgid;
	}

	public void setPporgid(String pporgid) {
		this.pporgid = pporgid;
	}

	public String getPporgname() {
		return pporgname;
	}

	public void setPporgname(String pporgname) {
		this.pporgname = pporgname;
	}

	public String getPprolename() {
		return pprolename;
	}

	public void setPprolename(String pprolename) {
		this.pprolename = pprolename;
	}

	public String getPpuserid() {
		return ppuserid;
	}

	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}

	public String getPpusername() {
		return ppusername;
	}

	public void setPpusername(String ppusername) {
		this.ppusername = ppusername;
	}

	public String getPptype() {
		return pptype;
	}

	public void setPptype(String pptype) {
		this.pptype = pptype;
	}

	public String getPpuserinfo() {
		return ppuserinfo;
	}

	public void setPpuserinfo(String ppuserinfo) {
		this.ppuserinfo = ppuserinfo;
	}

	public String getPpcomment() {
		return ppcomment;
	}

	public void setPpcomment(String ppcomment) {
		this.ppcomment = ppcomment;
	}

	public String getPpstatus() {
		return ppstatus;
	}

	public void setPpstatus(String ppstatus) {
		this.ppstatus = ppstatus;
	}

	public String getPpattkey() {
		return ppattkey;
	}

	public void setPpattkey(String ppattkey) {
		this.ppattkey = ppattkey;
	}

	public String getPpinittime() {
		return ppinittime;
	}

	public void setPpinittime(String ppinittime) {
		this.ppinittime = ppinittime;
	}

	public String getPpproctime() {
		return ppproctime;
	}

	public void setPpproctime(String ppproctime) {
		this.ppproctime = ppproctime;
	}

	public String getPpsubstatus() {
		return ppsubstatus;
	}

	public void setPpsubstatus(String ppsubstatus) {
		this.ppsubstatus = ppsubstatus;
	}

	public Integer getPpfacttime() {
		return ppfacttime;
	}

	public void setPpfacttime(Integer ppfacttime) {
		this.ppfacttime = ppfacttime;
	}

	public String getPpbacktime() {
		return ppbacktime;
	}

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
