/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.crc.model.vo;


public class IGCRC02081VO{

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
	protected Integer prfacttime;
	
	/**
	 * 自定义流程临时跃迁条件
	 */
	protected String prptdcond;
	
	/**
	 * 流程策略版本
	 */
	protected Integer prStrategyVersion;
	
	/**
	 * 流程优先级
	 */
	protected String prPriority;
	
	
	
	/** 事件分类  */	
	private String eventType;
	/** 事件来源  */	
	private String eventSource;
	/** 严重程度 */	
	private String eventSeverity;
	/** 紧急程度  */	
	private String eventEmergency;
	
	
	
	
	/**
	 * prid取得
	 * @return prid  prid
	 */
	public Integer getPrid() {
		return prid;
	}
	/**
	 * prid设定
	 * @param prid  prid
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	/**
	 * 流程记录类型取得
	 * @return prtype  流程记录类型
	 */
	public String getPrtype() {
		return prtype;
	}
	/**
	 * 流程记录类型设定
	 * @param prtype  流程记录类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}
	/**
	 * 流程记录子类型取得
	 * @return prsubtype  流程记录子类型
	 */
	public String getPrsubtype() {
		return prsubtype;
	}
	/**
	 * 流程记录子类型设定
	 * @param prsubtype  流程记录子类型
	 */
	public void setPrsubtype(String prsubtype) {
		this.prsubtype = prsubtype;
	}
	/**
	 * 流程记录状态取得
	 * @return prstatus  流程记录状态
	 */
	public String getPrstatus() {
		return prstatus;
	}
	/**
	 * 流程记录状态设定
	 * @param prstatus  流程记录状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}
	/**
	 * 流程记录状态子状态取得
	 * @return prsubstatus  流程记录状态子状态
	 */
	public String getPrsubstatus() {
		return prsubstatus;
	}
	/**
	 * 流程记录状态子状态设定
	 * @param prsubstatus  流程记录状态子状态
	 */
	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}
	/**
	 * 流程记录题目取得
	 * @return prtitle  流程记录题目
	 */
	public String getPrtitle() {
		return prtitle;
	}
	/**
	 * 流程记录题目设定
	 * @param prtitle  流程记录题目
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}
	/**
	 * 流程记录描述取得
	 * @return prdesc  流程记录描述
	 */
	public String getPrdesc() {
		return prdesc;
	}
	/**
	 * 流程记录描述设定
	 * @param prdesc  流程记录描述
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}
	/**
	 * 流程记录建立时间取得
	 * @return propentime  流程记录建立时间
	 */
	public String getPropentime() {
		return propentime;
	}
	/**
	 * 流程记录建立时间设定
	 * @param propentime  流程记录建立时间
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}
	/**
	 * 流程记录关闭时间取得
	 * @return prclosetime  流程记录关闭时间
	 */
	public String getPrclosetime() {
		return prclosetime;
	}
	/**
	 * 流程记录关闭时间设定
	 * @param prclosetime  流程记录关闭时间
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}
	/**
	 * 流程记录计划执行时间取得
	 * @return prplantime  流程记录计划执行时间
	 */
	public String getPrplantime() {
		return prplantime;
	}
	/**
	 * 流程记录计划执行时间设定
	 * @param prplantime  流程记录计划执行时间
	 */
	public void setPrplantime(String prplantime) {
		this.prplantime = prplantime;
	}
	/**
	 * 流程记录计划执行周期取得
	 * @return prduration  流程记录计划执行周期
	 */
	public String getPrduration() {
		return prduration;
	}
	/**
	 * 流程记录计划执行周期设定
	 * @param prduration  流程记录计划执行周期
	 */
	public void setPrduration(String prduration) {
		this.prduration = prduration;
	}
	/**
	 * 流程记录紧急程度取得
	 * @return prurgency  流程记录紧急程度
	 */
	public String getPrurgency() {
		return prurgency;
	}
	/**
	 * 流程记录紧急程度设定
	 * @param prurgency  流程记录紧急程度
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}
	/**
	 * 流程记录影响程度取得
	 * @return primpact  流程记录影响程度
	 */
	public String getPrimpact() {
		return primpact;
	}
	/**
	 * 流程记录影响程度设定
	 * @param primpact  流程记录影响程度
	 */
	public void setPrimpact(String primpact) {
		this.primpact = primpact;
	}
	/**
	 * 流程记录相关资产ID取得
	 * @return prassetid  流程记录相关资产ID
	 */
	public Integer getPrassetid() {
		return prassetid;
	}
	/**
	 * 流程记录相关资产ID设定
	 * @param prassetid  流程记录相关资产ID
	 */
	public void setPrassetid(Integer prassetid) {
		this.prassetid = prassetid;
	}
	/**
	 * 流程记录相关资产名称取得
	 * @return prassetname  流程记录相关资产名称
	 */
	public String getPrassetname() {
		return prassetname;
	}
	/**
	 * 流程记录相关资产名称设定
	 * @param prassetname  流程记录相关资产名称
	 */
	public void setPrassetname(String prassetname) {
		this.prassetname = prassetname;
	}
	/**
	 * 流程记录的相关业务取得
	 * @return prbusiness  流程记录的相关业务
	 */
	public String getPrbusiness() {
		return prbusiness;
	}
	/**
	 * 流程记录的相关业务设定
	 * @param prbusiness  流程记录的相关业务
	 */
	public void setPrbusiness(String prbusiness) {
		this.prbusiness = prbusiness;
	}
	/**
	 * 流程记录执行计划取得
	 * @return primplplan  流程记录执行计划
	 */
	public String getPrimplplan() {
		return primplplan;
	}
	/**
	 * 流程记录执行计划设定
	 * @param primplplan  流程记录执行计划
	 */
	public void setPrimplplan(String primplplan) {
		this.primplplan = primplplan;
	}
	/**
	 * 流程记录恢复计划取得
	 * @return prbackplan  流程记录恢复计划
	 */
	public String getPrbackplan() {
		return prbackplan;
	}
	/**
	 * 流程记录恢复计划设定
	 * @param prbackplan  流程记录恢复计划
	 */
	public void setPrbackplan(String prbackplan) {
		this.prbackplan = prbackplan;
	}
	/**
	 * 流程记录验证计划取得
	 * @return prvfyplan  流程记录验证计划
	 */
	public String getPrvfyplan() {
		return prvfyplan;
	}
	/**
	 * 流程记录验证计划设定
	 * @param prvfyplan  流程记录验证计划
	 */
	public void setPrvfyplan(String prvfyplan) {
		this.prvfyplan = prvfyplan;
	}
	/**
	 * 流程记录相关项目ID取得
	 * @return pid  流程记录相关项目ID
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * 流程记录相关项目ID设定
	 * @param pid  流程记录相关项目ID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 流程记录相关项目编号取得
	 * @return pcode  流程记录相关项目编号
	 */
	public String getPcode() {
		return pcode;
	}
	/**
	 * 流程记录相关项目编号设定
	 * @param pcode  流程记录相关项目编号
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	/**
	 * 流程记录相关项目名称取得
	 * @return pname  流程记录相关项目名称
	 */
	public String getPname() {
		return pname;
	}
	/**
	 * 流程记录相关项目名称设定
	 * @param pname  流程记录相关项目名称
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	/**
	 * 流程记录发起者联系方式取得
	 * @return prinfo  流程记录发起者联系方式
	 */
	public String getPrinfo() {
		return prinfo;
	}
	/**
	 * 流程记录发起者联系方式设定
	 * @param prinfo  流程记录发起者联系方式
	 */
	public void setPrinfo(String prinfo) {
		this.prinfo = prinfo;
	}
	/**
	 * 流程记录相关流程ID取得
	 * @return prcorid  流程记录相关流程ID
	 */
	public Integer getPrcorid() {
		return prcorid;
	}
	/**
	 * 流程记录相关流程ID设定
	 * @param prcorid  流程记录相关流程ID
	 */
	public void setPrcorid(Integer prcorid) {
		this.prcorid = prcorid;
	}
	/**
	 * 流程记录相关流程类型取得
	 * @return prcortype  流程记录相关流程类型
	 */
	public String getPrcortype() {
		return prcortype;
	}
	/**
	 * 流程记录相关流程类型设定
	 * @param prcortype  流程记录相关流程类型
	 */
	public void setPrcortype(String prcortype) {
		this.prcortype = prcortype;
	}
	/**
	 * 流程记录相关流程名称取得
	 * @return prcortitle  流程记录相关流程名称
	 */
	public String getPrcortitle() {
		return prcortitle;
	}
	/**
	 * 流程记录相关流程名称设定
	 * @param prcortitle  流程记录相关流程名称
	 */
	public void setPrcortitle(String prcortitle) {
		this.prcortitle = prcortitle;
	}
	/**
	 * 流程记录相关资产类型取得
	 * @return prassetcategory  流程记录相关资产类型
	 */
	public String getPrassetcategory() {
		return prassetcategory;
	}
	/**
	 * 流程记录相关资产类型设定
	 * @param prassetcategory  流程记录相关资产类型
	 */
	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}
	/**
	 * 流程记录发起者用户ID取得
	 * @return pruserid  流程记录发起者用户ID
	 */
	public String getPruserid() {
		return pruserid;
	}
	/**
	 * 流程记录发起者用户ID设定
	 * @param pruserid  流程记录发起者用户ID
	 */
	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}
	/**
	 * 流程记录发起者用户姓名取得
	 * @return prusername  流程记录发起者用户姓名
	 */
	public String getPrusername() {
		return prusername;
	}
	/**
	 * 流程记录发起者用户姓名设定
	 * @param prusername  流程记录发起者用户姓名
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}
	/**
	 * 流程记录发起者角色ID取得
	 * @return prroleid  流程记录发起者角色ID
	 */
	public Integer getPrroleid() {
		return prroleid;
	}
	/**
	 * 流程记录发起者角色ID设定
	 * @param prroleid  流程记录发起者角色ID
	 */
	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}
	/**
	 * 流程记录发起者角色名称取得
	 * @return prrolename  流程记录发起者角色名称
	 */
	public String getPrrolename() {
		return prrolename;
	}
	/**
	 * 流程记录发起者角色名称设定
	 * @param prrolename  流程记录发起者角色名称
	 */
	public void setPrrolename(String prrolename) {
		this.prrolename = prrolename;
	}
	/**
	 * 流程记录流程类型ID取得
	 * @return prpdid  流程记录流程类型ID
	 */
	public String getPrpdid() {
		return prpdid;
	}
	/**
	 * 流程记录流程类型ID设定
	 * @param prpdid  流程记录流程类型ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}
	/**
	 * 流程记录流程类型名称取得
	 * @return prpdname  流程记录流程类型名称
	 */
	public String getPrpdname() {
		return prpdname;
	}
	/**
	 * 流程记录流程类型名称设定
	 * @param prpdname  流程记录流程类型名称
	 */
	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}
	/**
	 * 流程记录发起者所属机构层次码取得
	 * @return prorgid  流程记录发起者所属机构层次码
	 */
	public String getProrgid() {
		return prorgid;
	}
	/**
	 * 流程记录发起者所属机构层次码设定
	 * @param prorgid  流程记录发起者所属机构层次码
	 */
	public void setProrgid(String prorgid) {
		this.prorgid = prorgid;
	}
	/**
	 * 流程记录发起者所属机构名称取得
	 * @return prorgname  流程记录发起者所属机构名称
	 */
	public String getProrgname() {
		return prorgname;
	}
	/**
	 * 流程记录发起者所属机构名称设定
	 * @param prorgname  流程记录发起者所属机构名称
	 */
	public void setProrgname(String prorgname) {
		this.prorgname = prorgname;
	}
	/**
	 * 流程记录工单号取得
	 * @return prserialnum  流程记录工单号
	 */
	public String getPrserialnum() {
		return prserialnum;
	}
	/**
	 * 流程记录工单号设定
	 * @param prserialnum  流程记录工单号
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}
	/**
	 * 流程记录实际解决时间（从开始到结束）取得
	 * @return prfacttime  流程记录实际解决时间（从开始到结束）
	 */
	public Integer getPrfacttime() {
		return prfacttime;
	}
	/**
	 * 流程记录实际解决时间（从开始到结束）设定
	 * @param prfacttime  流程记录实际解决时间（从开始到结束）
	 */
	public void setPrfacttime(Integer prfacttime) {
		this.prfacttime = prfacttime;
	}
	/**
	 * 自定义流程临时跃迁条件取得
	 * @return prptdcond  自定义流程临时跃迁条件
	 */
	public String getPrptdcond() {
		return prptdcond;
	}
	/**
	 * 自定义流程临时跃迁条件设定
	 * @param prptdcond  自定义流程临时跃迁条件
	 */
	public void setPrptdcond(String prptdcond) {
		this.prptdcond = prptdcond;
	}
	/**
	 * 流程策略版本取得
	 * @return prStrategyVersion  流程策略版本
	 */
	public Integer getPrStrategyVersion() {
		return prStrategyVersion;
	}
	/**
	 * 流程策略版本设定
	 * @param prStrategyVersion  流程策略版本
	 */
	public void setPrStrategyVersion(Integer prStrategyVersion) {
		this.prStrategyVersion = prStrategyVersion;
	}
	/**
	 * 流程优先级取得
	 * @return prPriority  流程优先级
	 */
	public String getPrPriority() {
		return prPriority;
	}
	/**
	 * 流程优先级设定
	 * @param prPriority  流程优先级
	 */
	public void setPrPriority(String prPriority) {
		this.prPriority = prPriority;
	}
	/**
	 * 事件分类取得
	 * @return eventType  事件分类
	 */
	public String getEventType() {
		return eventType;
	}
	/**
	 * 事件分类设定
	 * @param eventType  事件分类
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	/**
	 * 事件来源取得
	 * @return eventSource  事件来源
	 */
	public String getEventSource() {
		return eventSource;
	}
	/**
	 * 事件来源设定
	 * @param eventSource  事件来源
	 */
	public void setEventSource(String eventSource) {
		this.eventSource = eventSource;
	}
	/**
	 * 严重程度取得
	 * @return eventSeverity  严重程度
	 */
	public String getEventSeverity() {
		return eventSeverity;
	}
	/**
	 * 严重程度设定
	 * @param eventSeverity  严重程度
	 */
	public void setEventSeverity(String eventSeverity) {
		this.eventSeverity = eventSeverity;
	}
	/**
	 * 紧急程度取得
	 * @return eventEmergency  紧急程度
	 */
	public String getEventEmergency() {
		return eventEmergency;
	}
	/**
	 * 紧急程度设定
	 * @param eventEmergency  紧急程度
	 */
	public void setEventEmergency(String eventEmergency) {
		this.eventEmergency = eventEmergency;
	}
	
	
}
