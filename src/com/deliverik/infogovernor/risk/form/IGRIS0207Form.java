package com.deliverik.infogovernor.risk.form;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.risk.model.RiskCheck;


/**
 * 风险检查FORM
 * 
 */
@SuppressWarnings("serial")
public class IGRIS0207Form extends BaseForm implements RiskCheck{
	
	/** 风险检查ID */
	protected Integer rcid;
	

	/** 风险检查名称 */
	protected String rcname;
	
	/** 风险检查方法说明 */
	protected String rcdesc;
	
	/** 风险检查方法 */
	protected String rccommon;
	
	/** 风险检查重要程度 */
	protected String rctype;
	
	/** 风险检查状态 */
	protected String rcstatus;
	
	/** 风险检查起始日期 */
	protected String rcstartdate;
	
	/** 风险检查结束日期 */
	protected String rcenddate;
	
	/** 风险检查频率 */
	protected String rcfrequency;
	
	/** 风险检查频率内容 */
	protected String rcfrequencydesc;
	
	/** 风险检查频率(周) */
	protected String[] rcfrequencyweek;
	
	/** 风险检查频率(月) */
	protected String[] rcfrequencymonth;
	
	/** 风险检查频率(每月最后一天) */
	protected String rcfrequencymonthlastday;
	/** 风险检查频率(立即发起) */
	protected String once;
	

	/** 风险检查责任人id */
	protected String rcuserid;
	
	/** 风险检查责任人姓名 */
	protected String rcusername;
	
	/** 风险检查责任组角色id */
	protected Integer rcroleid;
	
	/** 风险检查责任组角色名 */
	protected String rcrolename;
	
	/** 风险检查相关资产 */
	protected Integer rcasset;
	
	/** 风险检查相关资产名称 */
	protected String rcassetname;
	
	/** 风险检查相关资产版本*/
	protected Integer rcassetversion;
	
	/** 风险检查附件 */
	protected String rcattch;
	
	/** 风险检查选项 */
	protected String rcoption;
	
	/** 风险检查策略执行表达式 */
	protected String rccron;
	
	protected String fingerPrint;
	
	/** 风险检查类型 */
	protected String rcclass;
	
	/** 附件 */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** 0为新增 1为变更 */
	protected String mode = "0";

	/** 风险检查项类别 */
	protected String rccategory;
	
	/** 风险检查项类别名称 */
	protected String rccategoryname;
	
	/** 风险检查登记时间 */
	protected String rccreatetime;
	
	/** 风险检查审批时间 */
	protected String rcapprovetime;
	
	/** 风险检查审批人 */
	protected String rcapprover;
	
	/** 处理时间 */
	protected String rcupdatetime;
	
	/** 将要删除的附件id串*/
	protected String predelkey;
	/** 合作执行组  */
	protected String cog;
	/** 合作执行人  */
	protected String ciiop;
	/** 合作执行组ID  */
	protected String cogid;
	/** 合作执行人ID  */
	protected String ciiopid;
	/** 风险检查方式 */
	protected String rcrtestmode;
	/** 工作执行期限  */
	protected Integer wtip;

	/** 风险检查计划检查时间 */
	protected String rcrplandate_from;

	/** 风险检查计划检查时间 */
	protected String rcrplandate_to;
	
	/** 为1时只查询未执行的检查工作，其它情况都查全部检查工作 */
	protected String isNull;
	
	
	/** 检查名称 */
	protected String csname;

	/** 描述 */
	protected String csdesc;

	/** 状态 */
	protected String csstatus;

	/** 开始日期 */
	protected String csstartdate;

	/** 结束日期 */
	protected String csenddate;

	/** 频率 */
	protected String csfrequency;

	/** 策略执行表达式 */
	protected String cscron;

	/** 责任人ID */
	protected String csuserid;

	/** 责任人姓名 */
	protected String csusername;

	/** 责任组角色ID */
	protected Integer csroleid;

	/** 责任组角色名称 */
	protected String csrolename;

	/** 相关资产ID */
	protected Integer csasset;

	/** 相关资产名称 */
	protected String csassetname;

	/** 附件 */
	protected String csattch ;

	/** 选项 */
	protected String csoption ;
	
	
	
	
	
	/**
	 * 合作执行组ID取得
	 * @return 合作执行组ID
	 */
	public String getCogid() {
		return cogid;
	}

	public void setCogid(String cogid) {
		this.cogid = cogid;
	}
	
	/**
	 * 合作执行人ID取得
	 * @return 合作执行人ID
	 */
	public String getCiiopid() {
		return ciiopid;
	}

	public void setCiiopid(String ciiopid) {
		this.ciiopid = ciiopid;
	}

	public String getCog() {
		return cog;
	}

	public void setCog(String cog) {
		this.cog = cog;
	}

	public String getCiiop() {
		return ciiop;
	}

	public void setCiiop(String ciiop) {
		this.ciiop = ciiop;
	}

	public Integer getWtip() {
		return wtip;
	}

	public void setWtip(Integer wtip) {
		this.wtip = wtip;
	}

	/**
	 * 风险检查相关资产名称取得
	 * @return 风险检查相关资产名称
	 */
	public String getRcassetname() {
		return rcassetname;
	}

	/**
	 * 风险检查相关资产名称设定
	 * @param rcassetname 风险检查相关资产名称
	 */
	public void setRcassetname(String rcassetname) {
		this.rcassetname = rcassetname;
	}

	/**
	 * 风险检查策略执行表达式取得
	 * @return 风险检查策略执行表达式
	 */
	public String getRccron() {
		return rccron;
	}

	/**
	 * 风险检查策略执行表达式设定
	 * @param rccron 风险检查策略执行表达式
	 */
	public void setRccron(String rccron) {
		this.rccron = rccron;
	}

	/**
	 * @return the fingerPrint
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}
	
	public String getOnce() {
		return once;
	}

	public void setOnce(String once) {
		this.once = once;
	}

	/**
	 * @param fingerPrint the fingerPrint to set
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/**
	 * 0为新增 1为变更取得
	 * @return 0为新增 1为变更
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 0为新增 1为变更设定
	 * @param mode 0为新增 1为变更
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * 获取附件
	 * @return 获取附件
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get(new Integer(index));
	}

	/**
	 * 设置附件
	 * @param index 附件数组索引
	 * @param file 附件
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put(new Integer(index), file);
	}

	/**
	 * 获取附件Map
	 * @return 附件Map
	 */
	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}

	/**
	 * 附件设定
	 * @param fileMap 附件
	 */
	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}

	/**
	 * 风险检查ID取得
	 * @return 风险检查ID
	 */
	public Integer getRcid() {
		if(rcid!=null && rcid==0){
			return null;
		}else{
			return rcid;
		}
		
	}

	/**
	 * 风险检查名称取得
	 * @return 风险检查名称
	 */
	public String getRcname() {
		return rcname;
	}

	/**
	 * 风险检查描述取得
	 * @return 风险检查描述
	 */
	public String getRcdesc() {
		return rcdesc;
	}

	/**
	 * 风险检查重要程度取得
	 * @return the 风险检查重要程度
	 */
	public String getRctype() {
		return rctype;
	}

	/**
	 * 风险检查状态取得
	 * @return 风险检查状态
	 */
	public String getRcstatus() {
		return rcstatus;
	}

	/**
	 * 风险检查起始日期取得
	 * @return 风险检查起始日期
	 */
	public String getRcstartdate() {
		return rcstartdate;
	}

	/**
	 * 风险检查结束日期取得
	 * @return 风险检查结束日期
	 */
	public String getRcenddate() {
		return rcenddate;
	}

	/**
	 * 风险检查频率取得
	 * @return 风险检查频率
	 */
	public String getRcfrequency() {
		return rcfrequency;
	}

	/**
	 * 风险检查责任人id取得
	 * @return 风险检查责任人id
	 */
	public String getRcuserid() {
		return rcuserid;
	}
	
	/**
	 * 风险检查频率(周)取得
	 * @return 风险检查频率(周)
	 */
	public String[] getRcfrequencyweek() {
		return rcfrequencyweek;
	}

	/**
	 * 风险检查频率(周)设定
	 *
	 * @param rcfrequencyweek 风险检查频率(周)
	 */
	public void setRcfrequencyweek(String[] rcfrequencyweek) {
		this.rcfrequencyweek = rcfrequencyweek;
	}

	/**
	 * 风险检查频率(月)取得
	 * @return 风险检查频率(月)
	 */
	public String[] getRcfrequencymonth() {
		return rcfrequencymonth;
	}

	/**
	 * 风险检查频率(月)设定
	 *
	 * @param rcfrequencymonth 风险检查频率(月)
	 */
	public void setRcfrequencymonth(String[] rcfrequencymonth) {
		this.rcfrequencymonth = rcfrequencymonth;
	}
	
	/**
	 * 风险检查频率(每月最后一天)取得
	 * @return 风险检查频率(每月最后一天)
	 */
	public String getRcfrequencymonthlastday() {
		return rcfrequencymonthlastday;
	}
	
	/**
	 * 风险检查频率(每月最后一天)设定
	 *
	 * @param rcfrequencymonthlastday 风险检查频率(每月最后一天)
	 */
	public void setRcfrequencymonthlastday(String rcfrequencymonthlastday) {
		this.rcfrequencymonthlastday = rcfrequencymonthlastday;
	}
	
	/**
	 * 风险检查责任人姓名取得
	 * @return 风险检查责任人姓名
	 */
	public String getRcusername() {
		return rcusername;
	}

	/**
	 * 风险检查责任组角色id取得
	 * @return 风险检查责任组角色id
	 */
	public Integer getRcroleid() {
		return rcroleid;
	}

	/**
	 * 风险检查责任组角色名取得
	 * @return 风险检查责任组角色名
	 */
	public String getRcrolename() {
		return rcrolename;
	}

	/**
	 * 风险检查相关资产取得
	 * @return 风险检查相关资产
	 */
	public Integer getRcasset() {
		return rcasset;
	}

	/**
	 * 风险检查附件取得
	 * @return 风险检查附件
	 */
	public String getRcattch() {
		return rcattch;
	}

	/**
	 * 风险检查选项取得
	 * @return 风险检查选项
	 */
	public String getRcoption() {
		return rcoption;
	}

	/**
	 * 风险检查ID设定
	 * @param rcid 风险检查ID
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * 风险检查名称设定
	 * @param rcname 风险检查名称
	 */
	public void setRcname(String rcname) {
		this.rcname = rcname;
	}

	/**
	 * 风险检查描述设定
	 * @param rcdesc 风险检查描述
	 */
	public void setRcdesc(String rcdesc) {
		this.rcdesc = rcdesc;
	}

	/**
	 * 风险检查重要程度设定
	 * @param rctype 风险检查重要程度
	 */
	public void setRctype(String rctype) {
		this.rctype = rctype;
	}

	/**
	 * 风险检查状态设定
	 * @param rcstatus 风险检查状态
	 */
	public void setRcstatus(String rcstatus) {
		this.rcstatus = rcstatus;
	}

	/**
	 * 风险检查起始日期设定
	 * @param rcstartdate 风险检查起始日期
	 */
	public void setRcstartdate(String rcstartdate) {
		this.rcstartdate = rcstartdate;
	}

	/**
	 * 风险检查结束日期设定
	 * @param rcenddate 风险检查结束日期
	 */
	public void setRcenddate(String rcenddate) {
		this.rcenddate = rcenddate;
	}

	/**
	 * 风险检查频率设定
	 * @param rcfrequency 风险检查频率
	 */
	public void setRcfrequency(String rcfrequency) {
		this.rcfrequency = rcfrequency;
	}

	/**
	 * 风险检查责任人id设定
	 * @param rcuserid 风险检查责任人id
	 */
	public void setRcuserid(String rcuserid) {
		this.rcuserid = rcuserid;
	}

	/**
	 * 风险检查频率内容取得
	 * @return 风险检查频率内容
	 */
	public String getRcfrequencydesc() {
		return rcfrequencydesc;
	}

	/**
	 * 风险检查频率内容设定
	 *
	 * @param rcfrequencydesc 风险检查频率内容
	 */
	public void setRcfrequencydesc(String rcfrequencydesc) {
		this.rcfrequencydesc = rcfrequencydesc;
	}
	
	/**
	 * 风险检查责任人姓名设定
	 * @param rcusername 风险检查责任人姓名
	 */
	public void setRcusername(String rcusername) {
		this.rcusername = rcusername;
	}

	/**
	 * 风险检查责任组角色id设定
	 * @param rcroleid 风险检查责任组角色id
	 */
	public void setRcroleid(Integer rcroleid) {
		this.rcroleid = rcroleid;
	}

	/**
	 * 风险检查责任组角色名设定
	 * @param rcrolename 风险检查责任组角色名
	 */
	public void setRcrolename(String rcrolename) {
		this.rcrolename = rcrolename;
	}

	/**
	 * 风险检查相关资产设定
	 * @param rcasset 风险检查相关资产
	 */
	public void setRcasset(Integer rcasset) {
		this.rcasset = rcasset;
	}

	/**
	 * 风险检查附件设定
	 * @param rcattch 风险检查附件
	 */
	public void setRcattch(String rcattch) {
		this.rcattch = rcattch;
	}

	/**
	 * 风险检查选项设定
	 * @param rcoption 风险检查选项
	 */
	public void setRcoption(String rcoption) {
		this.rcoption = rcoption;
	}

	/**
	 * 风险检查项类别取得
	 * @return 风险检查项类别
	 */
	public String getRccategory() {
		return rccategory;
	}

	/**
	 * 风险检查项类别设定
	 *
	 * @param rccategory 风险检查项类别
	 */
	public void setRccategory(String rccategory) {
		this.rccategory = rccategory;
	}

	/**
	 * 风险检查项类别名称取得
	 * @return 风险检查项类别名称
	 */
	public String getRccategoryname() {
		return rccategoryname;
	}

	/**
	 * 风险检查项类别名称设定
	 *
	 * @param rccategoryname 风险检查项类别名称
	 */
	public void setRccategoryname(String rccategoryname) {
		this.rccategoryname = rccategoryname;
	}

	/**
	 * 风险检查登记时间取得
	 * @return 风险检查登记时间
	 */
	public String getRccreatetime() {
		return rccreatetime;
	}

	/**
	 * 风险检查登记时间设定
	 *
	 * @param rccreatetime 风险检查登记时间
	 */
	public void setRccreatetime(String rccreatetime) {
		this.rccreatetime = rccreatetime;
	}

	/**
	 * 风险检查审批时间取得
	 * @return 风险检查审批时间
	 */
	public String getRcapprovetime() {
		return rcapprovetime;
	}

	/**
	 * 风险检查审批时间设定
	 *
	 * @param rcapprovetime 风险检查审批时间
	 */
	public void setRcapprovetime(String rcapprovetime) {
		this.rcapprovetime = rcapprovetime;
	}

	/**
	 * 风险检查审批人取得
	 * @return 风险检查审批人
	 */
	public String getRcapprover() {
		return rcapprover;
	}

	/**
	 * 风险检查审批人设定
	 *
	 * @param rcapprover 风险检查审批人
	 */
	public void setRcapprover(String rcapprover) {
		this.rcapprover = rcapprover;
	}
	
	/**
	 * 处理时间取得
	 * @return 处理时间
	 */
	public String getRcupdatetime() {
		return rcupdatetime;
	}

	/**
	 * 处理时间设定
	 *
	 * @param rcupdatetime 处理时间
	 */
	public void setRcupdatetime(String rcupdatetime) {
		this.rcupdatetime = rcupdatetime;
	}

	/**
	 * 将要删除的附件id串取得
	 *
	 * @return 将要删除的附件id串
	 */
	public String getPredelkey() {
		return predelkey;
	}

	/**
	 * 将要删除的附件id串设定
	 *
	 * @param predelkey 将要删除的附件id串
	 */
	public void setPredelkey(String predelkey) {
		this.predelkey = predelkey;
	}

	public String getRccommon() {
		return rccommon;
	}

	public void setRccommon(String rccommon) {
		this.rccommon = rccommon;
	}

	public String getRcclass() {
		return rcclass;
	}

	public void setRcclass(String rcclass) {
		this.rcclass = rcclass;
	}
	public String getRcrtestmode() {
		return rcrtestmode;
	}

	public void setRcrtestmode(String rcrtestmode) {
		this.rcrtestmode = rcrtestmode;
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

	public String getIsNull() {
		return isNull;
	}

	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}

	/**
	 * @return the csname
	 */
	public String getCsname() {
		return csname;
	}

	/**
	 * @param csname the csname to set
	 */
	public void setCsname(String csname) {
		this.csname = csname;
	}

	/**
	 * @return the csdesc
	 */
	public String getCsdesc() {
		return csdesc;
	}

	/**
	 * @param csdesc the csdesc to set
	 */
	public void setCsdesc(String csdesc) {
		this.csdesc = csdesc;
	}

	/**
	 * @return the csstatus
	 */
	public String getCsstatus() {
		return csstatus;
	}

	/**
	 * @param csstatus the csstatus to set
	 */
	public void setCsstatus(String csstatus) {
		this.csstatus = csstatus;
	}

	/**
	 * @return the csstartdate
	 */
	public String getCsstartdate() {
		return csstartdate;
	}

	/**
	 * @param csstartdate the csstartdate to set
	 */
	public void setCsstartdate(String csstartdate) {
		this.csstartdate = csstartdate;
	}

	/**
	 * @return the csenddate
	 */
	public String getCsenddate() {
		return csenddate;
	}

	/**
	 * @param csenddate the csenddate to set
	 */
	public void setCsenddate(String csenddate) {
		this.csenddate = csenddate;
	}

	/**
	 * @return the csfrequency
	 */
	public String getCsfrequency() {
		return csfrequency;
	}

	/**
	 * @param csfrequency the csfrequency to set
	 */
	public void setCsfrequency(String csfrequency) {
		this.csfrequency = csfrequency;
	}

	/**
	 * @return the cscron
	 */
	public String getCscron() {
		return cscron;
	}

	/**
	 * @param cscron the cscron to set
	 */
	public void setCscron(String cscron) {
		this.cscron = cscron;
	}

	/**
	 * @return the csuserid
	 */
	public String getCsuserid() {
		return csuserid;
	}

	/**
	 * @param csuserid the csuserid to set
	 */
	public void setCsuserid(String csuserid) {
		this.csuserid = csuserid;
	}

	/**
	 * @return the csusername
	 */
	public String getCsusername() {
		return csusername;
	}

	/**
	 * @param csusername the csusername to set
	 */
	public void setCsusername(String csusername) {
		this.csusername = csusername;
	}

	/**
	 * @return the csroleid
	 */
	public Integer getCsroleid() {
		return csroleid;
	}

	/**
	 * @param csroleid the csroleid to set
	 */
	public void setCsroleid(Integer csroleid) {
		this.csroleid = csroleid;
	}

	/**
	 * @return the csrolename
	 */
	public String getCsrolename() {
		return csrolename;
	}

	/**
	 * @param csrolename the csrolename to set
	 */
	public void setCsrolename(String csrolename) {
		this.csrolename = csrolename;
	}

	/**
	 * @return the csasset
	 */
	public Integer getCsasset() {
		return csasset;
	}

	/**
	 * @param csasset the csasset to set
	 */
	public void setCsasset(Integer csasset) {
		this.csasset = csasset;
	}

	/**
	 * @return the csassetname
	 */
	public String getCsassetname() {
		return csassetname;
	}

	/**
	 * @param csassetname the csassetname to set
	 */
	public void setCsassetname(String csassetname) {
		this.csassetname = csassetname;
	}

	/**
	 * @return the csattch
	 */
	public String getCsattch() {
		return csattch;
	}

	/**
	 * @param csattch the csattch to set
	 */
	public void setCsattch(String csattch) {
		this.csattch = csattch;
	}

	/**
	 * @return the csoption
	 */
	public String getCsoption() {
		return csoption;
	}

	/**
	 * @param csoption the csoption to set
	 */
	public void setCsoption(String csoption) {
		this.csoption = csoption;
	}

	/**
	 * @return the rcassetversion
	 */
	public Integer getRcassetversion() {
		return rcassetversion;
	}

	/**
	 * @param rcassetversion the rcassetversion to set
	 */
	public void setRcassetversion(Integer rcassetversion) {
		this.rcassetversion = rcassetversion;
	}

	
	
	
}
