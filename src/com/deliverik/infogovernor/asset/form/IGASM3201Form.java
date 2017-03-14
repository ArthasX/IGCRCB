package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 人员编辑画面FORM
 * 
 */
public class IGASM3201Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	/** 资产ID */
	protected Integer eiid;
	
	/** 风险事件名称 */
	protected String fcname;
	
	/** 风险事件描述 */
	protected String fcdesc;
	
	/** 风险事件来源 */
	protected String fcorigin;
	
	/** 风险事件所属领域 */
	protected String fccategory;
	
	/** 相关评估工作名称 */
	protected String fccheckjob;
	
	/** 相关评估工作ID */
	protected String riskjobid;
	
	/** 风险点名称 */
	protected String fcriskname;
	
	/** 风险点ID */
	protected String riskid;
	
	/** 风险点分类名称 */
	protected String fctypename;
	
	/** 风险点分类ID */
	protected String risktype;
	
	/** 风险严重级别名称 */
	protected String fcseveritylevel;
	
	/** 风险发生可能性名称 */
	protected String fcpossibility;
	
	/** 风险级别名称 */
	protected String fclevel;
	
	/** 风险识别时间 */
	protected String riskcatchtime;
	
	/** 应对任务名称 */
	protected String fcrisktask;
	
	/** 应对任务描述 */
	protected String fcrisktaskdesc;
	
	/** 应对策略 */
	protected String fcpolicy;
	
	/** 应对目标 */
	protected String fcoperatoraim;
	
	/** 应对部门 */
	protected String fcoperatordept;
	
	/** 应对部门ID */
	protected String riskoperatordept;
	
	/** 应对负责人 */
	protected String fcoperator;
	
	/** 应对负责人ID */
	protected String riskoperator;
	
	/** 抄送风控人员 */
	protected String fcccoperator;
	
	/** 抄送风控人员ID */
	protected String riskccoperator;
	
	/** 评审结果 */
	protected String riskreviewresult;
	
	/** 问题整改工作ID */
	protected String riskdealid;
	
	/** 资产模型ID */
	protected String eid;
	
	/** 资产模型编码 */
	protected String elabel;

	/** 资产模型名称 */
	protected String ename;

	/** 资产名称 */
	protected String einame;
	
	/** 资产编号 */
	protected String eilabel;

	/** 资产说明 */
	protected String eidesc;

	/** 资产状态 */
	protected String eistatus;

	/** 资产变更时间 */
	protected String eiupdtime;
	
	/** 资产最新版本号 */
	protected String eiversion;

	/** 登记日 */
	protected String eiinsdate;
	
	/** 编辑模式（登记/变更） */
	protected String mode = "0";
	
	/** 资产所属机构*/
	public String eiorgsyscoding;
	
	/** 资产所属机构名称*/
	public String eiorgname;
	
	/** 资产登记人*/
	protected String eiuserid;
	
	/** 资产登记人姓名*/
	protected String eiusername;
	
	protected String fingerPrint;
	
	/** 资产小版本*/
	protected Integer eismallversion;
	
	/** 风险识别开始时间*/
	protected String riskcatchtime_from;
	
	/** 风险识别结束时间*/
	protected String riskcatchtime_to;
	
	/**内容*/
	protected String prdesc;
	
	/**排序标识*/
	protected String order;
	
	/** 排序字段 */
	protected String sing;
	
	/** 资产项所属模型*/
	public String esyscoding;
	
	/**搜索菜单栏标志位*/
	protected String showFlag;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEid() {
			return eid;
	}

	/**
	 * 资产模型ID设定
	 *
	 * @param eid 资产模型ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * 资产模型编码取得
	 * @return 资产模型编码
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * 资产模型编码设定
	 *
	 * @param elabel 资产模型编码
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * 资产模型名称取得
	 * @return 资产模型名称
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * 资产模型名称设定
	 *
	 * @param ename 资产模型名称
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * 人员名称取得
	 * @return 人员名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 人员名称设定
	 *
	 * @param einame 人员名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 人员编码取得
	 * @return 人员编码
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 人员编码设定
	 *
	 * @param eilabel 人员编码
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 人员说明取得
	 * @return 人员说明
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * 人员说明设定
	 *
	 * @param eidesc 人员说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * 人员更新时间取得
	 * @return 人员更新时间
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * 人员更新时间设定
	 *
	 * @param eiupdtime 人员更新时间
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * 人员状态取得
	 * @return 人员状态
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * 人员状态设定
	 *
	 * @param eistatus 人员状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * 人员版本号取得
	 * @return 人员版本号
	 */
	public String getEiversion() {
		return eiversion;
	}

	/**
	 * 人员版本号设定
	 *
	 * @param eiversion 人员版本号
	 */
	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 编辑模式取得
	 * @return 编辑模式
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 人员登记日取得
	 * @return 人员登记日
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * 人员登记日设定
	 *
	 * @param eiinsdate 人员登记日
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}


	/**
	 * 编辑模式设定
	 *
	 * @param mode 编辑模式
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * 资产管理人取得
	 * @return 资产管理人
	 */
	public String getEiuserid() {
		return eiuserid;
	}
	
	/**
	 * 资产管理人设定
	 *
	 * @param eiuserid 资产管理人
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}
	
	/**
	 * 资产管理人姓名取得
	 * @return 资产管理人姓名
	 */
	public String getEiusername() {
		return eiusername;
	}
	
	/**
	 * 资产管理人姓名设定
	 *
	 * @param eiusername 资产管理人姓名
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	/**
	 * 资产小版本取得
	 * @return 资产小版本
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}
	/**
	 * 资产小版本设定
	 *
	 * @param eismallversion 资产小版本
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}
	

	public String getFccategory() {
		return fccategory;
	}

	public void setFccategory(String fccategory) {
		this.fccategory = fccategory;
	}

	public String getFcname() {
		return fcname;
	}

	public void setFcname(String fcname) {
		this.fcname = fcname;
	}

	public String getFcdesc() {
		return fcdesc;
	}

	public void setFcdesc(String fcdesc) {
		this.fcdesc = fcdesc;
	}
	
	public String getFcorigin() {
		return fcorigin;
	}

	public void setFcorigin(String fcorigin) {
		this.fcorigin = fcorigin;
	}

	public String getFcriskname() {
		return fcriskname;
	}

	public void setFcriskname(String fcriskname) {
		this.fcriskname = fcriskname;
	}

	public String getRiskid() {
		return riskid;
	}

	public void setRiskid(String riskid) {
		this.riskid = riskid;
	}

	public String getFccheckjob() {
		return fccheckjob;
	}

	public void setFccheckjob(String fccheckjob) {
		this.fccheckjob = fccheckjob;
	}

	public String getRiskjobid() {
		return riskjobid;
	}

	public void setRiskjobid(String riskjobid) {
		this.riskjobid = riskjobid;
	}

	public String getFctypename() {
		return fctypename;
	}

	public void setFctypename(String fctypename) {
		this.fctypename = fctypename;
	}

	public String getRisktype() {
		return risktype;
	}

	public void setRisktype(String risktype) {
		this.risktype = risktype;
	}

	public String getFcseveritylevel() {
		return fcseveritylevel;
	}

	public void setFcseveritylevel(String fcseveritylevel) {
		this.fcseveritylevel = fcseveritylevel;
	}

	public String getFcpossibility() {
		return fcpossibility;
	}

	public void setFcpossibility(String fcpossibility) {
		this.fcpossibility = fcpossibility;
	}

	public String getFclevel() {
		return fclevel;
	}

	public void setFclevel(String fclevel) {
		this.fclevel = fclevel;
	}

	public String getRiskcatchtime() {
		return riskcatchtime;
	}

	public void setRiskcatchtime(String riskcatchtime) {
		this.riskcatchtime = riskcatchtime;
	}

	public String getFcrisktask() {
		return fcrisktask;
	}

	public void setFcrisktask(String fcrisktask) {
		this.fcrisktask = fcrisktask;
	}

	public String getFcrisktaskdesc() {
		return fcrisktaskdesc;
	}

	public void setFcrisktaskdesc(String fcrisktaskdesc) {
		this.fcrisktaskdesc = fcrisktaskdesc;
	}

	public String getFcpolicy() {
		return fcpolicy;
	}

	public void setFcpolicy(String fcpolicy) {
		this.fcpolicy = fcpolicy;
	}

	public String getFcoperatoraim() {
		return fcoperatoraim;
	}

	public void setFcoperatoraim(String fcoperatoraim) {
		this.fcoperatoraim = fcoperatoraim;
	}

	public String getFcoperatordept() {
		return fcoperatordept;
	}

	public void setFcoperatordept(String fcoperatordept) {
		this.fcoperatordept = fcoperatordept;
	}

	public String getRiskoperatordept() {
		return riskoperatordept;
	}

	public void setRiskoperatordept(String riskoperatordept) {
		this.riskoperatordept = riskoperatordept;
	}

	public String getFcoperator() {
		return fcoperator;
	}

	public void setFcoperator(String fcoperator) {
		this.fcoperator = fcoperator;
	}

	public String getRiskoperator() {
		return riskoperator;
	}

	public void setRiskoperator(String riskoperator) {
		this.riskoperator = riskoperator;
	}

	public String getFcccoperator() {
		return fcccoperator;
	}

	public void setFcccoperator(String fcccoperator) {
		this.fcccoperator = fcccoperator;
	}

	public String getRiskccoperator() {
		return riskccoperator;
	}

	public void setRiskccoperator(String riskccoperator) {
		this.riskccoperator = riskccoperator;
	}

	public String getRiskreviewresult() {
		return riskreviewresult;
	}

	public void setRiskreviewresult(String riskreviewresult) {
		this.riskreviewresult = riskreviewresult;
	}

	public String getRiskdealid() {
		return riskdealid;
	}

	public void setRiskdealid(String riskdealid) {
		this.riskdealid = riskdealid;
	}

	public Integer getEiid() {
		return eiid;
	}

	public String getRiskcatchtime_from() {
		return riskcatchtime_from;
	}

	public void setRiskcatchtime_from(String riskcatchtime_from) {
		this.riskcatchtime_from = riskcatchtime_from;
	}

	public String getRiskcatchtime_to() {
		return riskcatchtime_to;
	}

	public void setRiskcatchtime_to(String riskcatchtime_to) {
		this.riskcatchtime_to = riskcatchtime_to;
	}

	public String getSing() {
		return sing;
	}

	public void setSing(String sing) {
		this.sing = sing;
	}

	public String getPrdesc() {
		return prdesc;
	}

	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
	/**
	 * @return the showFlag
	 */
	public String getShowFlag() {
		return showFlag;
	}

	/**
	 * @param showFlag the showFlag to set
	 */
	public void setShowFlag(String showFlag) {
		this.showFlag = showFlag;
	}

}
