package com.deliverik.infogovernor.ven.form;

import com.deliverik.framework.base.BaseForm;


/**
 * 风险检查FORM
 * 
 */
@SuppressWarnings("serial")
public class IGVEN0202Form extends BaseForm {
	
	/** 风险监测主键id */
	protected Integer rmid;
	
	/** 指标名称  */	
	protected String einame;
	
	/** 指标编号  */	
	protected String eilabel;

	/**
	 * 风险监测主键id取得
	 * @return rmid  风险监测主键id
	 */
	public Integer getRmid() {
		return rmid;
	}

	/**
	 * 风险监测主键id设定
	 * @param rmid  风险监测主键id
	 */
	public void setRmid(Integer rmid) {
		this.rmid = rmid;
	}

	/**
	 * 指标名称取得
	 * @return einame  指标名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 指标名称设定
	 * @param einame  指标名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 指标编号取得
	 * @return eilabel  指标编号
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 指标编号设定
	 * @param eilabel  指标编号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}
	

	

	
//	/** 风险检查ID */
//	protected Integer rcid;
//	
//	/** 检查任务id*/
//	protected Integer cwrid;
//	
//	/** 检查策略id*/
//	protected Integer csid;
//	
//	protected String eiids;
//	
//	protected String eiversions;
//	
//	protected String einames;
//	
//	protected String riskitem;
//	
//	protected String eidesc;
//	
//	protected String eistatus;
//	
//	protected String rcommon;
//	
//	/** 风险检查名称 */
//	protected String rcname;
//	
//	/** 风险检查方法说明 */
//	protected String rcdesc;
//	
//	/** 风险检查方法 */
//	protected String rccommon;
//	
//	/** 风险检查重要程度 */
//	protected String rctype;
//	
//	/** 风险检查状态 */
//	protected String rcstatus;
//	
//	/** 风险检查起始日期 */
//	protected String rcstartdate;
//	
//	/** 风险检查结束日期 */
//	protected String rcenddate;
//	
//	/** 风险检查频率 */
//	protected String rcfrequency;
//	
//	/** 风险检查频率内容 */
//	protected String rcfrequencydesc;
//	
//	/** 风险检查频率(周) */
//	protected String[] rcfrequencyweek;
//	
//	/** 风险检查频率(月) */
//	protected String[] rcfrequencymonth;
//	
//	/** 风险检查频率(每月最后一天) */
//	protected String rcfrequencymonthlastday;
//	/** 风险检查频率(立即发起) */
//	protected String once;
//	
//
//	/** 风险检查责任人id */
//	protected String rcuserid;
//	
//	/** 风险检查责任人姓名 */
//	protected String rcusername;
//	
//	/** 风险检查责任组角色id */
//	protected Integer rcroleid;
//	
//	/** 风险检查责任组角色名 */
//	protected String rcrolename;
//	
//	/** 风险检查相关资产 */
//	protected Integer rcasset;
//	
//	/** 风险检查相关资产名称 */
//	protected String rcassetname;
//	
//	/** 风险检查相关资产版本号*/
//	protected Integer rcassetversion; 
//	
//	/** 风险检查附件 */
//	protected String rcattch;
//	
//	/** 风险检查选项 */
//	protected String rcoption;
//	
//	/** 风险检查策略执行表达式 */
//	protected String rccron;
//	
//	protected String fingerPrint;
//	
//	/** 风险检查类型 */
//	protected String rcclass;
//	
//	/** 附件 */
//	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
//	
//	/** 0为新增 1为变更 */
//	protected String mode = "0";
//
//	/** 风险检查项类别 */
//	protected String rccategory;
//	
//	/** 风险检查项类别名称 */
//	protected String rccategoryname;
//	
//	/** 风险检查登记时间 */
//	protected String rccreatetime;
//	
//	/** 风险检查审批时间 */
//	protected String rcapprovetime;
//	
//	/** 风险检查审批人 */
//	protected String rcapprover;
//	
//	/** 处理时间 */
//	protected String rcupdatetime;
//	
//	/** 将要删除的附件id串*/
//	protected String predelkey;
//	/** 合作执行组  */
//	protected String cog;
//	/** 合作执行人  */
//	protected String ciiop;
//	/** 合作执行组ID  */
//	protected String cogid;
//	/** 合作执行人ID  */
//	protected String ciiopid;
//	/** 风险检查方式 */
//	protected String rcrtestmode;
//	/** 工作执行期限  */
//	protected Integer wtip;
//
//	/** 风险检查计划检查时间 */
//	protected String rcrplandate_from;
//
//	/** 风险检查计划检查时间 */
//	protected String rcrplandate_to;
//	
//	/** 为1时只查询未执行的检查工作，其它情况都查全部检查工作 */
//	protected String isNull;
//	/**检查机构机构id*/
//	protected String[] orgids;
//	/**检查机构名称*/
//	protected String[] orgnames;
//	
//	
//	
//	public String[] getOrgids() {
//        return orgids;
//    }
//
//    public void setOrgids(String[] orgids) {
//        this.orgids = orgids;
//    }
//
//    public String[] getOrgnames() {
//        return orgnames;
//    }
//
//    public void setOrgnames(String[] orgnames) {
//        this.orgnames = orgnames;
//    }
//
//    /**
//	 * 合作执行组ID取得
//	 * @return 合作执行组ID
//	 */
//	public String getCogid() {
//		return cogid;
//	}
//
//	public void setCogid(String cogid) {
//		this.cogid = cogid;
//	}
//	
//	
//	/**
//	 * @return the cwrid
//	 */
//	public Integer getCwrid() {
//		return cwrid;
//	}
//
//	/**
//	 * @param cwrid the cwrid to set
//	 */
//	public void setCwrid(Integer cwrid) {
//		this.cwrid = cwrid;
//	}
//
//	/**
//	 * 合作执行人ID取得
//	 * @return 合作执行人ID
//	 */
//	public String getCiiopid() {
//		return ciiopid;
//	}
//
//	public void setCiiopid(String ciiopid) {
//		this.ciiopid = ciiopid;
//	}
//
//	public String getCog() {
//		return cog;
//	}
//
//	public void setCog(String cog) {
//		this.cog = cog;
//	}
//
//	public String getCiiop() {
//		return ciiop;
//	}
//
//	public void setCiiop(String ciiop) {
//		this.ciiop = ciiop;
//	}
//
//	public Integer getWtip() {
//		return wtip;
//	}
//
//	public void setWtip(Integer wtip) {
//		this.wtip = wtip;
//	}
//
//	/**
//	 * 风险检查相关资产名称取得
//	 * @return 风险检查相关资产名称
//	 */
//	public String getRcassetname() {
//		return rcassetname;
//	}
//
//	/**
//	 * 风险检查相关资产名称设定
//	 * @param rcassetname 风险检查相关资产名称
//	 */
//	public void setRcassetname(String rcassetname) {
//		this.rcassetname = rcassetname;
//	}
//
//	/**
//	 * 风险检查策略执行表达式取得
//	 * @return 风险检查策略执行表达式
//	 */
//	public String getRccron() {
//		return rccron;
//	}
//
//	/**
//	 * 风险检查策略执行表达式设定
//	 * @param rccron 风险检查策略执行表达式
//	 */
//	public void setRccron(String rccron) {
//		this.rccron = rccron;
//	}
//
//	/**
//	 * @return the fingerPrint
//	 */
//	public String getFingerPrint() {
//		return fingerPrint;
//	}
//	
//	public String getOnce() {
//		return once;
//	}
//
//	public void setOnce(String once) {
//		this.once = once;
//	}
//
//	/**
//	 * @param fingerPrint the fingerPrint to set
//	 */
//	public void setFingerPrint(String fingerPrint) {
//		this.fingerPrint = fingerPrint;
//	}
//
//	/**
//	 * 0为新增 1为变更取得
//	 * @return 0为新增 1为变更
//	 */
//	public String getMode() {
//		return mode;
//	}
//
//	/**
//	 * 0为新增 1为变更设定
//	 * @param mode 0为新增 1为变更
//	 */
//	public void setMode(String mode) {
//		this.mode = mode;
//	}
//	
//	/**
//	 * 获取附件
//	 * @return 获取附件
//	 */
//	public FormFile getAttachFile(int index) {
//		return fileMap.get(new Integer(index));
//	}
//
//	/**
//	 * 设置附件
//	 * @param index 附件数组索引
//	 * @param file 附件
//	 */
//	public void setAttachFile(int index, FormFile file) {
//		fileMap.put(new Integer(index), file);
//	}
//
//	/**
//	 * 获取附件Map
//	 * @return 附件Map
//	 */
//	public Map<Integer, FormFile> getFileMap() {
//		return fileMap;
//	}
//
//	/**
//	 * 附件设定
//	 * @param fileMap 附件
//	 */
//	public void setFileMap(Map<Integer, FormFile> fileMap) {
//		this.fileMap = fileMap;
//	}
//
//	/**
//	 * 风险检查ID取得
//	 * @return 风险检查ID
//	 */
//	public Integer getRcid() {
//		if(rcid!=null && rcid==0){
//			return null;
//		}else{
//			return rcid;
//		}
//		
//	}
//
//	/**
//	 * 风险检查名称取得
//	 * @return 风险检查名称
//	 */
//	public String getRcname() {
//		return rcname;
//	}
//
//	/**
//	 * 风险检查描述取得
//	 * @return 风险检查描述
//	 */
//	public String getRcdesc() {
//		return rcdesc;
//	}
//
//	/**
//	 * 风险检查重要程度取得
//	 * @return the 风险检查重要程度
//	 */
//	public String getRctype() {
//		return rctype;
//	}
//
//	/**
//	 * 风险检查状态取得
//	 * @return 风险检查状态
//	 */
//	public String getRcstatus() {
//		return rcstatus;
//	}
//
//	/**
//	 * 风险检查起始日期取得
//	 * @return 风险检查起始日期
//	 */
//	public String getRcstartdate() {
//		return rcstartdate;
//	}
//
//	/**
//	 * 风险检查结束日期取得
//	 * @return 风险检查结束日期
//	 */
//	public String getRcenddate() {
//		return rcenddate;
//	}
//
//	/**
//	 * 风险检查频率取得
//	 * @return 风险检查频率
//	 */
//	public String getRcfrequency() {
//		return rcfrequency;
//	}
//
//	/**
//	 * 风险检查责任人id取得
//	 * @return 风险检查责任人id
//	 */
//	public String getRcuserid() {
//		return rcuserid;
//	}
//	
//	/**
//	 * 风险检查频率(周)取得
//	 * @return 风险检查频率(周)
//	 */
//	public String[] getRcfrequencyweek() {
//		return rcfrequencyweek;
//	}
//
//	/**
//	 * 风险检查频率(周)设定
//	 *
//	 * @param rcfrequencyweek 风险检查频率(周)
//	 */
//	public void setRcfrequencyweek(String[] rcfrequencyweek) {
//		this.rcfrequencyweek = rcfrequencyweek;
//	}
//
//	/**
//	 * 风险检查频率(月)取得
//	 * @return 风险检查频率(月)
//	 */
//	public String[] getRcfrequencymonth() {
//		return rcfrequencymonth;
//	}
//
//	/**
//	 * 风险检查频率(月)设定
//	 *
//	 * @param rcfrequencymonth 风险检查频率(月)
//	 */
//	public void setRcfrequencymonth(String[] rcfrequencymonth) {
//		this.rcfrequencymonth = rcfrequencymonth;
//	}
//	
//	/**
//	 * 风险检查频率(每月最后一天)取得
//	 * @return 风险检查频率(每月最后一天)
//	 */
//	public String getRcfrequencymonthlastday() {
//		return rcfrequencymonthlastday;
//	}
//	
//	/**
//	 * 风险检查频率(每月最后一天)设定
//	 *
//	 * @param rcfrequencymonthlastday 风险检查频率(每月最后一天)
//	 */
//	public void setRcfrequencymonthlastday(String rcfrequencymonthlastday) {
//		this.rcfrequencymonthlastday = rcfrequencymonthlastday;
//	}
//	
//	/**
//	 * 风险检查责任人姓名取得
//	 * @return 风险检查责任人姓名
//	 */
//	public String getRcusername() {
//		return rcusername;
//	}
//
//	/**
//	 * 风险检查责任组角色id取得
//	 * @return 风险检查责任组角色id
//	 */
//	public Integer getRcroleid() {
//		return rcroleid;
//	}
//
//	
//	/**
//	 * @return the einames
//	 */
//	public String getEinames() {
//		return einames;
//	}
//
//	/**
//	 * @param einames the einames to set
//	 */
//	public void setEinames(String einames) {
//		this.einames = einames;
//	}
//
//	/**
//	 * 风险检查责任组角色名取得
//	 * @return 风险检查责任组角色名
//	 */
//	public String getRcrolename() {
//		return rcrolename;
//	}
//
//	/**
//	 * 风险检查相关资产取得
//	 * @return 风险检查相关资产
//	 */
//	public Integer getRcasset() {
//		return rcasset;
//	}
//
//	/**
//	 * 风险检查附件取得
//	 * @return 风险检查附件
//	 */
//	public String getRcattch() {
//		return rcattch;
//	}
//
//	/**
//	 * 风险检查选项取得
//	 * @return 风险检查选项
//	 */
//	public String getRcoption() {
//		return rcoption;
//	}
//
//	/**
//	 * 风险检查ID设定
//	 * @param rcid 风险检查ID
//	 */
//	public void setRcid(Integer rcid) {
//		this.rcid = rcid;
//	}
//
//	/**
//	 * 风险检查名称设定
//	 * @param rcname 风险检查名称
//	 */
//	public void setRcname(String rcname) {
//		this.rcname = rcname;
//	}
//
//	/**
//	 * 风险检查描述设定
//	 * @param rcdesc 风险检查描述
//	 */
//	public void setRcdesc(String rcdesc) {
//		this.rcdesc = rcdesc;
//	}
//
//	/**
//	 * 风险检查重要程度设定
//	 * @param rctype 风险检查重要程度
//	 */
//	public void setRctype(String rctype) {
//		this.rctype = rctype;
//	}
//
//	/**
//	 * 风险检查状态设定
//	 * @param rcstatus 风险检查状态
//	 */
//	public void setRcstatus(String rcstatus) {
//		this.rcstatus = rcstatus;
//	}
//
//	/**
//	 * 风险检查起始日期设定
//	 * @param rcstartdate 风险检查起始日期
//	 */
//	public void setRcstartdate(String rcstartdate) {
//		this.rcstartdate = rcstartdate;
//	}
//
//	/**
//	 * 风险检查结束日期设定
//	 * @param rcenddate 风险检查结束日期
//	 */
//	public void setRcenddate(String rcenddate) {
//		this.rcenddate = rcenddate;
//	}
//
//	/**
//	 * 风险检查频率设定
//	 * @param rcfrequency 风险检查频率
//	 */
//	public void setRcfrequency(String rcfrequency) {
//		this.rcfrequency = rcfrequency;
//	}
//
//	/**
//	 * 风险检查责任人id设定
//	 * @param rcuserid 风险检查责任人id
//	 */
//	public void setRcuserid(String rcuserid) {
//		this.rcuserid = rcuserid;
//	}
//
//	/**
//	 * 风险检查频率内容取得
//	 * @return 风险检查频率内容
//	 */
//	public String getRcfrequencydesc() {
//		return rcfrequencydesc;
//	}
//
//	/**
//	 * 风险检查频率内容设定
//	 *
//	 * @param rcfrequencydesc 风险检查频率内容
//	 */
//	public void setRcfrequencydesc(String rcfrequencydesc) {
//		this.rcfrequencydesc = rcfrequencydesc;
//	}
//	
//	/**
//	 * 风险检查责任人姓名设定
//	 * @param rcusername 风险检查责任人姓名
//	 */
//	public void setRcusername(String rcusername) {
//		this.rcusername = rcusername;
//	}
//
//	/**
//	 * 风险检查责任组角色id设定
//	 * @param rcroleid 风险检查责任组角色id
//	 */
//	public void setRcroleid(Integer rcroleid) {
//		this.rcroleid = rcroleid;
//	}
//
//	/**
//	 * 风险检查责任组角色名设定
//	 * @param rcrolename 风险检查责任组角色名
//	 */
//	public void setRcrolename(String rcrolename) {
//		this.rcrolename = rcrolename;
//	}
//
//	/**
//	 * 风险检查相关资产设定
//	 * @param rcasset 风险检查相关资产
//	 */
//	public void setRcasset(Integer rcasset) {
//		this.rcasset = rcasset;
//	}
//
//	/**
//	 * 风险检查附件设定
//	 * @param rcattch 风险检查附件
//	 */
//	public void setRcattch(String rcattch) {
//		this.rcattch = rcattch;
//	}
//
//	/**
//	 * 风险检查选项设定
//	 * @param rcoption 风险检查选项
//	 */
//	public void setRcoption(String rcoption) {
//		this.rcoption = rcoption;
//	}
//
//	/**
//	 * 风险检查项类别取得
//	 * @return 风险检查项类别
//	 */
//	public String getRccategory() {
//		return rccategory;
//	}
//
//	/**
//	 * 风险检查项类别设定
//	 *
//	 * @param rccategory 风险检查项类别
//	 */
//	public void setRccategory(String rccategory) {
//		this.rccategory = rccategory;
//	}
//
//	/**
//	 * 风险检查项类别名称取得
//	 * @return 风险检查项类别名称
//	 */
//	public String getRccategoryname() {
//		return rccategoryname;
//	}
//
//	/**
//	 * 风险检查项类别名称设定
//	 *
//	 * @param rccategoryname 风险检查项类别名称
//	 */
//	public void setRccategoryname(String rccategoryname) {
//		this.rccategoryname = rccategoryname;
//	}
//
//	/**
//	 * 风险检查登记时间取得
//	 * @return 风险检查登记时间
//	 */
//	public String getRccreatetime() {
//		return rccreatetime;
//	}
//
//	/**
//	 * 风险检查登记时间设定
//	 *
//	 * @param rccreatetime 风险检查登记时间
//	 */
//	public void setRccreatetime(String rccreatetime) {
//		this.rccreatetime = rccreatetime;
//	}
//
//	/**
//	 * 风险检查审批时间取得
//	 * @return 风险检查审批时间
//	 */
//	public String getRcapprovetime() {
//		return rcapprovetime;
//	}
//
//	/**
//	 * 风险检查审批时间设定
//	 *
//	 * @param rcapprovetime 风险检查审批时间
//	 */
//	public void setRcapprovetime(String rcapprovetime) {
//		this.rcapprovetime = rcapprovetime;
//	}
//
//	/**
//	 * 风险检查审批人取得
//	 * @return 风险检查审批人
//	 */
//	public String getRcapprover() {
//		return rcapprover;
//	}
//
//	/**
//	 * 风险检查审批人设定
//	 *
//	 * @param rcapprover 风险检查审批人
//	 */
//	public void setRcapprover(String rcapprover) {
//		this.rcapprover = rcapprover;
//	}
//	
//	/**
//	 * 处理时间取得
//	 * @return 处理时间
//	 */
//	public String getRcupdatetime() {
//		return rcupdatetime;
//	}
//
//	/**
//	 * 处理时间设定
//	 *
//	 * @param rcupdatetime 处理时间
//	 */
//	public void setRcupdatetime(String rcupdatetime) {
//		this.rcupdatetime = rcupdatetime;
//	}
//
//	/**
//	 * 将要删除的附件id串取得
//	 *
//	 * @return 将要删除的附件id串
//	 */
//	public String getPredelkey() {
//		return predelkey;
//	}
//
//	/**
//	 * 将要删除的附件id串设定
//	 *
//	 * @param predelkey 将要删除的附件id串
//	 */
//	public void setPredelkey(String predelkey) {
//		this.predelkey = predelkey;
//	}
//
//	public String getRccommon() {
//		return rccommon;
//	}
//
//	public void setRccommon(String rccommon) {
//		this.rccommon = rccommon;
//	}
//
//	public String getRcclass() {
//		return rcclass;
//	}
//
//	public void setRcclass(String rcclass) {
//		this.rcclass = rcclass;
//	}
//	public String getRcrtestmode() {
//		return rcrtestmode;
//	}
//
//	public void setRcrtestmode(String rcrtestmode) {
//		this.rcrtestmode = rcrtestmode;
//	}
//
//	public String getRcrplandate_from() {
//		return rcrplandate_from;
//	}
//
//
//	public void setRcrplandate_from(String rcrplandate_from) {
//		this.rcrplandate_from = rcrplandate_from;
//	}
//
//
//	public String getRcrplandate_to() {
//		return rcrplandate_to;
//	}
//
//
//	public void setRcrplandate_to(String rcrplandate_to) {
//		this.rcrplandate_to = rcrplandate_to;
//	}
//
//	public String getIsNull() {
//		return isNull;
//	}
//
//	public void setIsNull(String isNull) {
//		this.isNull = isNull;
//	}
//	/**
//	 * @return the eiids
//	 */
//	public String getEiids() {
//		return eiids;
//	}
//
//	/**
//	 * @param eiids the eiids to set
//	 */
//	public void setEiids(String eiids) {
//		this.eiids = eiids;
//	}
//
//	/**
//	 * @return the eiversions
//	 */
//	public String getEiversions() {
//		return eiversions;
//	}
//
//	/**
//	 * @param eiversions the eiversions to set
//	 */
//	public void setEiversions(String eiversions) {
//		this.eiversions = eiversions;
//	}
//
//	/**
//	 * @return the csid
//	 */
//	public Integer getCsid() {
//		return csid;
//	}
//
//	/**
//	 * @param csid the csid to set
//	 */
//	public void setCsid(Integer csid) {
//		this.csid = csid;
//	}
//
//	/**
//	 * @return the rcassetversion
//	 */
//	public Integer getRcassetversion() {
//		return rcassetversion;
//	}
//
//	/**
//	 * @param rcassetversion the rcassetversion to set
//	 */
//	public void setRcassetversion(Integer rcassetversion) {
//		this.rcassetversion = rcassetversion;
//	}
//
//	/**
//	 * @return the riskitem
//	 */
//	public String getRiskitem() {
//		return riskitem;
//	}
//
//	/**
//	 * @param riskitem the riskitem to set
//	 */
//	public void setRiskitem(String riskitem) {
//		this.riskitem = riskitem;
//	}
//
//	/**
//	 * @return the eidesc
//	 */
//	public String getEidesc() {
//		return eidesc;
//	}
//
//	/**
//	 * @param eidesc the eidesc to set
//	 */
//	public void setEidesc(String eidesc) {
//		this.eidesc = eidesc;
//	}
//
//	/**
//	 * @return the eistatus
//	 */
//	public String getEistatus() {
//		return eistatus;
//	}
//
//	/**
//	 * @param eistatus the eistatus to set
//	 */
//	public void setEistatus(String eistatus) {
//		this.eistatus = eistatus;
//	}
//
//	/**
//	 * @return the rcommon
//	 */
//	public String getRcommon() {
//		return rcommon;
//	}
//
//	/**
//	 * @param rcommon the rcommon to set
//	 */
//	public void setRcommon(String rcommon) {
//		this.rcommon = rcommon;
//	}

	
}
