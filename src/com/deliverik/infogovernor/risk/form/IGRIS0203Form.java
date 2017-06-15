package com.deliverik.infogovernor.risk.form;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.risk.model.RiskCheck;


/**
 * 风险检查结果FORM
 * 
 */
@SuppressWarnings("serial")
public class IGRIS0203Form extends BaseForm implements IG500Info{
	
	/** 风险检查结果ID */
	protected Integer rcrid;
	
	protected Integer cwrid;
	
	protected Integer[] prids;
	
	/** 风险检查ID */
	protected Integer rcid;

	/** 风险检查计划检查时间 */
	protected String rcrplandate;
	
	/** 风险检查实际检查时间 */
	protected String rcrrealtime;
	
	/** 风险检查结果提交人ID */
	protected String rcruserid;
	
	/** 风险检查结果提交人姓名 */
	protected String rcrusername;
	
	/** 风险检查结果 */
	protected String rcrresult;
	
	/** 风险检查结果说明 */
	protected String rcrcomment;
	
	/** 风险检查对象 */
	protected RiskCheck riskCheck;
	
	protected Integer[] rcrids;
	
	protected String[] rcrresults;
	
	protected String[] rcrcomments;
	
	protected String csid;

	protected Integer[] filenum;
	
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	protected String isCheckrcrid;

	/** 风险检查类型 */
	protected String rcclass;
	
	/** 合作执行人  */
	protected String ciiop;

	/** 风险检查责任人姓名 */
	protected String rcusername;

	/** 风险检查计划检查时间 */
	protected String rcrplandate_from;

	/** 风险检查计划检查时间 */
	protected String rcrplandate_to;
	
	/** 流程定义ID */
	protected String pdid;
	
	
	/** 按钮名称 */
	protected String buttonName;
	
	/** 按钮标识 */
	protected String buttonCode;
	
	/** 被分派参与人信息集合 */
	protected String[] participants;
	
	
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
	
	protected OrganizationTB organizationTB;

	public String getIsCheckrcrid() {
		return isCheckrcrid;
	}


	public void setIsCheckrcrid(String isCheckrcrid) {
		this.isCheckrcrid = isCheckrcrid;
	}


	/**
	 * @return the fileMap
	 */
	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}


	/**
	 * @param fileMap the fileMap to set
	 */
	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}


	/**
	 * 风险检查结果附件数据取得
	 * @return 风险检查结果附件数据
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}


	/**
	 * 风险检查结果附件数据
	 *
	 * @param index 风险检查结果附件数据数组索引
	 * @param file 风险检查结果附件数据
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}
	/**
	 * @return the rcrids
	 */
	public Integer[] getRcrids() {
		return rcrids;
	}

	/**
	 * @param rcrids the rcrids to set
	 */
	public void setRcrids(Integer[] rcrids) {
		this.rcrids = rcrids;
	}

	

	/**
	 * @return the rcrresults
	 */
	public String[] getRcrresults() {
		return rcrresults;
	}

	/**
	 * @return the rcrcomments
	 */
	public String[] getRcrcomments() {
		return rcrcomments;
	}

	/**
	 * @param rcrresults the rcrresults to set
	 */
	public void setRcrresults(String[] rcrresults) {
		this.rcrresults = rcrresults;
	}

	/**
	 * @param rcrcomments the rcrcomments to set
	 */
	public void setRcrcomments(String[] rcrcomments) {
		this.rcrcomments = rcrcomments;
	}

	/**
	 * @return the rcrid
	 */
	public Integer getRcrid() {
		return rcrid;
	}

	/**
	 * @return the rcid
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * @return the rcrplandate
	 */
	public String getRcrplandate() {
		return rcrplandate;
	}

	/**
	 * @return the rcrrealtime
	 */
	public String getRcrrealtime() {
		return rcrrealtime;
	}

	/**
	 * @return the rcruserid
	 */
	public String getRcruserid() {
		return rcruserid;
	}

	/**
	 * @return the rcrusername
	 */
	public String getRcrusername() {
		return rcrusername;
	}

	/**
	 * @return the rcrresult
	 */
	public String getRcrresult() {
		return rcrresult;
	}

	/**
	 * @return the rcrcomment
	 */
	public String getRcrcomment() {
		return rcrcomment;
	}

	/**
	 * @return the riskCheck
	 */
	public RiskCheck getRiskCheck() {
		return riskCheck;
	}

	/**
	 * @param rcrid the rcrid to set
	 */
	public void setRcrid(Integer rcrid) {
		this.rcrid = rcrid;
	}

	/**
	 * @param rcid the rcid to set
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * @param rcrplandate the rcrplandate to set
	 */
	public void setRcrplandate(String rcrplandate) {
		this.rcrplandate = rcrplandate;
	}

	/**
	 * @param rcrrealtime the rcrrealtime to set
	 */
	public void setRcrrealtime(String rcrrealtime) {
		this.rcrrealtime = rcrrealtime;
	}

	/**
	 * @param rcruserid the rcruserid to set
	 */
	public void setRcruserid(String rcruserid) {
		this.rcruserid = rcruserid;
	}

	/**
	 * @param rcrusername the rcrusername to set
	 */
	public void setRcrusername(String rcrusername) {
		this.rcrusername = rcrusername;
	}

	/**
	 * @param rcrresult the rcrresult to set
	 */
	public void setRcrresult(String rcrresult) {
		this.rcrresult = rcrresult;
	}

	/**
	 * @param rcrcomment the rcrcomment to set
	 */
	public void setRcrcomment(String rcrcomment) {
		this.rcrcomment = rcrcomment;
	}

	/**
	 * @param riskCheck the riskCheck to set
	 */
	public void setRiskCheck(RiskCheck riskCheck) {
		this.riskCheck = riskCheck;
	}


	public Integer[] getFilenum() {
		return filenum;
	}


	public void setFilenum(Integer[] filenum) {
		this.filenum = filenum;
	}


	public String getRcclass() {
		return rcclass;
	}


	public void setRcclass(String rcclass) {
		this.rcclass = rcclass;
	}


	public String getCiiop() {
		return ciiop;
	}


	public void setCiiop(String ciiop) {
		this.ciiop = ciiop;
	}


	public String getRcusername() {
		return rcusername;
	}


	public void setRcusername(String rcusername) {
		this.rcusername = rcusername;
	}

	

	/**
	 * @return the cwrid
	 */
	public Integer getCwrid() {
		return cwrid;
	}


	/**
	 * @param cwrid the cwrid to set
	 */
	public void setCwrid(Integer cwrid) {
		this.cwrid = cwrid;
	}


	public String getRcrplandate_from() {
		return rcrplandate_from;
	}


	public void setRcrplandate_from(String rcrplandate_from) {
		this.rcrplandate_from = rcrplandate_from;
	}


	public String getRcrplandate_to() {
		return rcrplandate_to;
	}


	public void setRcrplandate_to(String rcrplandate_to) {
		this.rcrplandate_to = rcrplandate_to;
	}


	/**
	 * @return the csid
	 */
	public String getCsid() {
		return csid;
	}


	/**
	 * @param csid the csid to set
	 */
	public void setCsid(String csid) {
		this.csid = csid;
	}


	/**
	 * @return the prid
	 */
	public Integer getPrid() {
		return prid;
	}


	/**
	 * @param prid the prid to set
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}


	/**
	 * @return the prtype
	 */
	public String getPrtype() {
		return prtype;
	}


	/**
	 * @param prtype the prtype to set
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}


	/**
	 * @return the prsubtype
	 */
	public String getPrsubtype() {
		return prsubtype;
	}


	/**
	 * @param prsubtype the prsubtype to set
	 */
	public void setPrsubtype(String prsubtype) {
		this.prsubtype = prsubtype;
	}


	/**
	 * @return the prstatus
	 */
	public String getPrstatus() {
		return prstatus;
	}


	/**
	 * @param prstatus the prstatus to set
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}


	/**
	 * @return the prsubstatus
	 */
	public String getPrsubstatus() {
		return prsubstatus;
	}


	/**
	 * @param prsubstatus the prsubstatus to set
	 */
	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}


	/**
	 * @return the prtitle
	 */
	public String getPrtitle() {
		return prtitle;
	}


	/**
	 * @param prtitle the prtitle to set
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}


	/**
	 * @return the prdesc
	 */
	public String getPrdesc() {
		return prdesc;
	}


	/**
	 * @param prdesc the prdesc to set
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}


	/**
	 * @return the propentime
	 */
	public String getPropentime() {
		return propentime;
	}


	/**
	 * @param propentime the propentime to set
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}


	/**
	 * @return the prclosetime
	 */
	public String getPrclosetime() {
		return prclosetime;
	}


	/**
	 * @param prclosetime the prclosetime to set
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}


	/**
	 * @return the prplantime
	 */
	public String getPrplantime() {
		return prplantime;
	}


	/**
	 * @param prplantime the prplantime to set
	 */
	public void setPrplantime(String prplantime) {
		this.prplantime = prplantime;
	}


	/**
	 * @return the prduration
	 */
	public String getPrduration() {
		return prduration;
	}


	/**
	 * @param prduration the prduration to set
	 */
	public void setPrduration(String prduration) {
		this.prduration = prduration;
	}


	/**
	 * @return the prurgency
	 */
	public String getPrurgency() {
		return prurgency;
	}


	/**
	 * @param prurgency the prurgency to set
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}


	/**
	 * @return the primpact
	 */
	public String getPrimpact() {
		return primpact;
	}


	/**
	 * @param primpact the primpact to set
	 */
	public void setPrimpact(String primpact) {
		this.primpact = primpact;
	}


	/**
	 * @return the prassetid
	 */
	public Integer getPrassetid() {
		return prassetid;
	}


	/**
	 * @param prassetid the prassetid to set
	 */
	public void setPrassetid(Integer prassetid) {
		this.prassetid = prassetid;
	}


	/**
	 * @return the prassetname
	 */
	public String getPrassetname() {
		return prassetname;
	}


	/**
	 * @param prassetname the prassetname to set
	 */
	public void setPrassetname(String prassetname) {
		this.prassetname = prassetname;
	}


	/**
	 * @return the prbusiness
	 */
	public String getPrbusiness() {
		return prbusiness;
	}


	/**
	 * @param prbusiness the prbusiness to set
	 */
	public void setPrbusiness(String prbusiness) {
		this.prbusiness = prbusiness;
	}


	/**
	 * @return the primplplan
	 */
	public String getPrimplplan() {
		return primplplan;
	}


	/**
	 * @param primplplan the primplplan to set
	 */
	public void setPrimplplan(String primplplan) {
		this.primplplan = primplplan;
	}


	/**
	 * @return the prbackplan
	 */
	public String getPrbackplan() {
		return prbackplan;
	}


	/**
	 * @param prbackplan the prbackplan to set
	 */
	public void setPrbackplan(String prbackplan) {
		this.prbackplan = prbackplan;
	}


	/**
	 * @return the prvfyplan
	 */
	public String getPrvfyplan() {
		return prvfyplan;
	}


	/**
	 * @param prvfyplan the prvfyplan to set
	 */
	public void setPrvfyplan(String prvfyplan) {
		this.prvfyplan = prvfyplan;
	}


	/**
	 * @return the pid
	 */
	public Integer getPid() {
		return pid;
	}


	/**
	 * @param pid the pid to set
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}


	/**
	 * @return the pcode
	 */
	public String getPcode() {
		return pcode;
	}


	/**
	 * @param pcode the pcode to set
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}


	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}


	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}


	/**
	 * @return the prinfo
	 */
	public String getPrinfo() {
		return prinfo;
	}


	/**
	 * @param prinfo the prinfo to set
	 */
	public void setPrinfo(String prinfo) {
		this.prinfo = prinfo;
	}


	/**
	 * @return the prcorid
	 */
	public Integer getPrcorid() {
		return prcorid;
	}


	/**
	 * @param prcorid the prcorid to set
	 */
	public void setPrcorid(Integer prcorid) {
		this.prcorid = prcorid;
	}


	/**
	 * @return the prcortype
	 */
	public String getPrcortype() {
		return prcortype;
	}


	/**
	 * @param prcortype the prcortype to set
	 */
	public void setPrcortype(String prcortype) {
		this.prcortype = prcortype;
	}


	/**
	 * @return the prcortitle
	 */
	public String getPrcortitle() {
		return prcortitle;
	}


	/**
	 * @param prcortitle the prcortitle to set
	 */
	public void setPrcortitle(String prcortitle) {
		this.prcortitle = prcortitle;
	}


	/**
	 * @return the prassetcategory
	 */
	public String getPrassetcategory() {
		return prassetcategory;
	}


	/**
	 * @param prassetcategory the prassetcategory to set
	 */
	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}


	/**
	 * @return the pruserid
	 */
	public String getPruserid() {
		return pruserid;
	}


	/**
	 * @param pruserid the pruserid to set
	 */
	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}


	/**
	 * @return the prusername
	 */
	public String getPrusername() {
		return prusername;
	}


	/**
	 * @param prusername the prusername to set
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}


	/**
	 * @return the prroleid
	 */
	public Integer getPrroleid() {
		return prroleid;
	}


	/**
	 * @param prroleid the prroleid to set
	 */
	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}


	/**
	 * @return the prrolename
	 */
	public String getPrrolename() {
		return prrolename;
	}


	/**
	 * @param prrolename the prrolename to set
	 */
	public void setPrrolename(String prrolename) {
		this.prrolename = prrolename;
	}


	/**
	 * @return the prpdid
	 */
	public String getPrpdid() {
		return prpdid;
	}


	/**
	 * @param prpdid the prpdid to set
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}


	/**
	 * @return the prpdname
	 */
	public String getPrpdname() {
		return prpdname;
	}


	/**
	 * @param prpdname the prpdname to set
	 */
	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}


	/**
	 * @return the prorgid
	 */
	public String getProrgid() {
		return prorgid;
	}


	/**
	 * @param prorgid the prorgid to set
	 */
	public void setProrgid(String prorgid) {
		this.prorgid = prorgid;
	}


	/**
	 * @return the prorgname
	 */
	public String getProrgname() {
		return prorgname;
	}


	/**
	 * @param prorgname the prorgname to set
	 */
	public void setProrgname(String prorgname) {
		this.prorgname = prorgname;
	}


	/**
	 * @return the prserialnum
	 */
	public String getPrserialnum() {
		return prserialnum;
	}


	/**
	 * @param prserialnum the prserialnum to set
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}


	/**
	 * @return the prfacttime
	 */
	public Integer getPrfacttime() {
		return prfacttime;
	}


	/**
	 * @param prfacttime the prfacttime to set
	 */
	public void setPrfacttime(Integer prfacttime) {
		this.prfacttime = prfacttime;
	}


	/**
	 * @return the prptdcond
	 */
	public String getPrptdcond() {
		return prptdcond;
	}


	/**
	 * @param prptdcond the prptdcond to set
	 */
	public void setPrptdcond(String prptdcond) {
		this.prptdcond = prptdcond;
	}


	/**
	 * @return the prStrategyVersion
	 */
	public Integer getPrStrategyVersion() {
		return prStrategyVersion;
	}


	/**
	 * @param prStrategyVersion the prStrategyVersion to set
	 */
	public void setPrStrategyVersion(Integer prStrategyVersion) {
		this.prStrategyVersion = prStrategyVersion;
	}


	/**
	 * @return the prPriority
	 */
	public String getPrPriority() {
		return prPriority;
	}


	/**
	 * @param prPriority the prPriority to set
	 */
	public void setPrPriority(String prPriority) {
		this.prPriority = prPriority;
	}


	/**
	 * @return the organizationTB
	 */
	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}


	/**
	 * @param organizationTB the organizationTB to set
	 */
	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}


	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * @return the prids
	 */
	public Integer[] getPrids() {
		return prids;
	}


	/**
	 * @param prids the prids to set
	 */
	public void setPrids(Integer[] prids) {
		this.prids = prids;
	}


	/**
	 * @return the pdid
	 */
	public String getPdid() {
		return pdid;
	}


	/**
	 * @param pdid the pdid to set
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}


	/**
	 * @return the buttonName
	 */
	public String getButtonName() {
		return buttonName;
	}


	/**
	 * @param buttonName the buttonName to set
	 */
	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}


	/**
	 * @return the buttonCode
	 */
	public String getButtonCode() {
		return buttonCode;
	}


	/**
	 * @param buttonCode the buttonCode to set
	 */
	public void setButtonCode(String buttonCode) {
		this.buttonCode = buttonCode;
	}


	/**
	 * @return the participants
	 */
	public String[] getParticipants() {
		return participants;
	}


	/**
	 * @param participants the participants to set
	 */
	public void setParticipants(String[] participants) {
		this.participants = participants;
	}
	

	

}
