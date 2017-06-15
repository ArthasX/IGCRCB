/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.risk.model.RiskCheck;

/**
 * 风险检查实体
 * @author lipeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="RiskCheck")
public class RiskCheckTB extends BaseEntity implements Serializable, Cloneable, RiskCheck {

	/** 风险检查ID */
	@Id
	@TableGenerator(
		    name="RISKCHECK_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="RISKCHECK_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKCHECK_TABLE_GENERATOR")
	protected Integer rcid;

	/** 风险检查名称 */
	protected String rcname;
	
	/** 风险检查描述 */
	protected String rcdesc;
	
	/** 风险检查重要度 */
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
	
	/** 风险检查责任人ID */
	protected String rcuserid;
	
	/** 风险检查责任人姓名 */
	protected String rcusername;
	
	/** 风险检查责任组角色ID */
	protected Integer rcroleid;
	
	/** 风险检查责任组角色名 */
	protected String rcrolename;
	
	/** 风险检查相关资产id */
	protected Integer rcasset;
	
	/** 风险检查相关资产名称 */
	protected String rcassetname;
	
	/** 风险检查相关资产版本号*/
	protected Integer rcassetversion; 
	
	/** 风险检查附件ID */
	protected String rcattch;

	/** 风险检查选项 */
	protected String rcoption;
	
	/** 风险检查策略执行表达式 */
	protected String rccron;
	
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
	
	/** 风险检查频率(每月最后一天) */
	protected String rcfrequencymonthlastday;
	
	/** 处理时间 */
	protected String rcupdatetime;

	/** 风险检查类型 */
	protected String rcclass;
	
	/** 风险检查方法 */
	protected String rccommon;
	/** 检查方式  */
	protected String rcrtestmode;
	/** 合作执行组  */
	protected String cog;
	/** 合作执行人  */
	protected String ciiop;
	/** 合作执行组ID  */
	protected String cogid;
	/** 合作执行人ID  */
	protected String ciiopid;
	/** 工作执行期限  */
	protected Integer wtip;
	
	public String getCog() {
		return cog;
	}

	public void setCog(String cog) {
		this.cog = cog;
	}
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
	 * 风险检查方式取得
	 * @return 风险检查方式
	 */
	public String getRcrtestmode() {
		return rcrtestmode;
	}

	/**
	 *风险检查方式设定
	 * @param rcrtestmode 风险检查方式
	 */
	public void setRcrtestmode(String rcrtestmode) {
		this.rcrtestmode = rcrtestmode;
	}
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return rcid;
	}
	
	
	/**
	 * 风险检查相关资产名称
	 * @return 风险检查相关资产名称
	 */
	public String getRcassetname() {
		return rcassetname;
	}


	/**
	 * 风险检查相关资产名称设定
	 *
	 * @param rccron 风险检查相关资产名称
	 */
	public void setRcassetname(String rcassetname) {
		this.rcassetname = rcassetname;
	}


	/**
	 * 风险检查相关资产版本号取得
	 * @return the rcassetversion
	 */
	public Integer getRcassetversion() {
		return rcassetversion;
	}

	/**
	 * 风险检查相关资产版本号设定
	 * @param rcassetversion the rcassetversion to set
	 */
	public void setRcassetversion(Integer rcassetversion) {
		this.rcassetversion = rcassetversion;
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
	 *
	 * @param rccron 风险检查策略执行表达式
	 */
	public void setRccron(String rccron) {
		this.rccron = rccron;
	}


	/**
	 * 风险检查ID取得
	 * @return 风险检查ID
	 */
	public Integer getRcid() {
		return rcid;
	}
	
	/**
	 * 风险检查ID设定
	 *
	 * @param rcid 风险检查ID
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * 风险检查名称取得
	 * @return 风险检查名称
	 */
	public String getRcname() {
		return rcname;
	}

	/**
	 * 风险检查名称设定
	 *
	 * @param rcname 风险检查名称
	 */
	public void setRcname(String rcname) {
		this.rcname = rcname;
	}

	/**
	 * 风险检查描述取得
	 * @return 风险检查描述
	 */
	public String getRcdesc() {
		return rcdesc;
	}

	/**
	 * 风险检查描述设定
	 *
	 * @param rcdesc 风险检查描述
	 */
	public void setRcdesc(String rcdesc) {
		this.rcdesc = rcdesc;
	}

	/**
	 * 风险检查重要度取得
	 * @return 风险检查重要度
	 */
	public String getRctype() {
		return rctype;
	}
	
	/**
	 * 风险检查重要度设定
	 *
	 * @param rctype 风险检查重要度
	 */
	public void setRctype(String rctype) {
		this.rctype = rctype;
	}

	/**
	 * 风险检查状态取得
	 * @return 风险检查状态
	 */
	public String getRcstatus() {
		return rcstatus;
	}
	
	/**
	 * 风险检查状态设定
	 *
	 * @param rcstatus 风险检查状态
	 */
	public void setRcstatus(String rcstatus) {
		this.rcstatus = rcstatus;
	}

	/**
	 * 风险检查起始日期取得
	 * @return 风险检查起始日期
	 */
	public String getRcstartdate() {
		return rcstartdate;
	}
	
	/**
	 * 风险检查起始日期设定
	 *
	 * @param rcstartdate 风险检查起始日期
	 */
	public void setRcstartdate(String rcstartdate) {
		this.rcstartdate = rcstartdate;
	}
	

	/**
	 * 风险检查结束日期取得
	 * @return 风险检查结束日期
	 */
	public String getRcenddate() {
		return rcenddate;
	}
	
	/**
	 * 风险检查结束日期设定
	 *
	 * @param rcenddate 风险检查结束日期
	 */
	public void setRcenddate(String rcenddate) {
		this.rcenddate = rcenddate;
	}

	/**
	 * 风险检查频率取得
	 * @return 风险检查频率
	 */
	public String getRcfrequency() {
		return rcfrequency;
	}
	
	/**
	 * 风险检查频率设定
	 *
	 * @param rcfrequency 风险检查频率
	 */
	public void setRcfrequency(String rcfrequency) {
		this.rcfrequency = rcfrequency;
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
	 * 风险检查责任人ID取得
	 * @return 风险检查责任人ID
	 */
	public String getRcuserid() {
		return rcuserid;
	}
	
	/**
	 * 风险检查责任人ID设定
	 *
	 * @param rcuserid 风险检查责任人ID
	 */
	public void setRcuserid(String rcuserid) {
		this.rcuserid = rcuserid;
	}

	/**
	 * 风险检查责任人姓名取得
	 * @return 风险检查责任人姓名
	 */
	public String getRcusername() {
		return rcusername;
	}
	
	/**
	 * 风险检查责任人姓名设定
	 *
	 * @param rcusername 风险检查责任人姓名
	 */
	public void setRcusername(String rcusername) {
		this.rcusername = rcusername;
	}

	/**
	 * 风险检查责任组角色ID取得
	 * @return 风险检查责任组角色ID
	 */
	public Integer getRcroleid() {
		return rcroleid;
	}
	
	/**
	 * 风险检查责任组角色ID设定
	 *
	 * @param rcroleid 风险检查责任组角色ID
	 */
	public void setRcroleid(Integer rcroleid) {
		this.rcroleid = rcroleid;
	}

	/**
	 * 风险检查责任组角色名取得
	 * @return 风险检查责任组角色名
	 */
	public String getRcrolename() {
		return rcrolename;
	}
	
	/**
	 * 风险检查责任组角色名设定
	 *
	 * @param rcrolename 风险检查责任组角色名
	 */
	public void setRcrolename(String rcrolename) {
		this.rcrolename = rcrolename;
	}

	/**
	 * 风险检查相关资产取得
	 * @return 风险检查相关资产
	 */
	public Integer getRcasset() {
		return rcasset;
	}
	
	/**
	 * 风险检查相关资产设定
	 *
	 * @param rcasset 风险检查相关资产
	 */
	public void setRcasset(Integer rcasset) {
		this.rcasset = rcasset;
	}

	/**
	 * 风险检查附件ID取得
	 * @return 风险检查附件ID
	 */
	public String getRcattch() {
		return rcattch;
	}
	
	/**
	 * 风险检查附件ID设定
	 *
	 * @param rcattch 风险检查附件ID
	 */
	public void setRcattch(String rcattch) {
		this.rcattch = rcattch;
	}

	/**
	 * 风险检查选项取得
	 * @return 风险检查选项
	 */
	public String getRcoption() {
		return rcoption;
	}
	
	/**
	 * 风险检查选项设定
	 *
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


	public String getRcclass() {
		return rcclass;
	}


	public void setRcclass(String rcclass) {
		this.rcclass = rcclass;
	}


	public String getRccommon() {
		return rccommon;
	}


	public void setRccommon(String rccommon) {
		this.rccommon = rccommon;
	}

}
