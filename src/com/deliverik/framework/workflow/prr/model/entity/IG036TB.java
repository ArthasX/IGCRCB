package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prr.model.IG036Info;


/**
 * <p>
 * 日志信息实体
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IG036")
public class IG036TB extends BaseEntity implements Serializable, Cloneable, IG036Info {

	/** 日志ID */
	@Id
	@TableGenerator(
		    name="IG036_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG036_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG036_TABLE_GENERATOR")
	protected Integer rlid;
	
	/** 流程记录ID */
	protected Integer prid;
	
	/** 日志记录时间 */
	protected String rltime;
	
	/** 日志处理人角色ID */
	protected Integer roleid;

	/** 日志处理人角色名称 */
	protected String rlrolename;

	/** 日志处理人ID */
	protected String rluserid;

	/** 日志处理人姓名 */
	protected String rlusername;

	/** 日志描述 */
	protected String rldesc;

	/** 日志处理人填写的信息 */
	protected String rlcomment;

	/** 附件索引 */
	protected String rlattkey;

	/** 日志类型 */
	protected String rltype;

	/** 日志处理人机构层次码 */
	protected String rlorgid;

	/** 日志处理人机构名称 */
	protected String rlorgname;
	
	/** 流程状态名称 */
	protected String psname;
	
	/** 流程状态编码 */
	protected String psdcode;
	
	/** 角色负责人标识 */
	protected String rolemanger;
	
	/** 按钮ID */
	protected String pbdid;

	/** 流程状态定义ID */
	protected String psdid;

	/** 动态分支编号 */
	protected Integer psdnum;
	
	/**
	 * 附件
	 */
	@Transient
	protected List<Attachment> attachmentList;
	
	/**
	 * 角色负责人标识取得
	 * @return 角色负责人标识
	 */
	public String getRolemanger() {
		return rolemanger;
	}

	/**
	 * 角色负责人标识设定
	 * @param rolemanger 角色负责人标识
	 */
	public void setRolemanger(String rolemanger) {
		this.rolemanger = rolemanger;
	}

	/**
	 * 流程状态编码取得
	 * @return 流程状态编码
	 */
	public String getPsdcode() {
		return psdcode;
	}

	/**
	 * 流程状态编码设定
	 * @param psdcode 流程状态编码
	 */
	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}

	
	/**
	 * 流程状态名称取得
	 * @return 流程状态名称
	 */
	public String getPsname() {
		return psname;
	}

	/**
	 * 流程状态名称设定
	 * @param psname 流程状态名称
	 */
	public void setPsname(String psname) {
		this.psname = psname;
	}

	/**
	 * 附件取得
	 * @return 附件
	 */
	public List<Attachment> getAttachmentList() {
		if(this.attachmentList == null && StringUtils.isNotEmpty(this.rlattkey)){
			AttachmentBL bl = (AttachmentBL) WebApplicationSupport.getBean("attachmentBL");
			this.attachmentList = bl.searchAttachmentsByAttkey(this.rlattkey);
		}
		return attachmentList;
	}

	/**
	 * 主键取得
	 * @return rlid
	 */
	public Serializable getPK() {
		return rlid;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof IG036TB))
			return false;
		IG036Info target = (IG036Info) obj;
		if (!(getRlid()==target.getRlid()))
			return false;

		return true;
	}
	
	
	/**
	 * 附件类型取得
	 * @return 附件类型
	 */
	public String getRltype() {
		return rltype;
	}

	/**
	 * 附件类型设定
	 * @param rltype 附件类型
	 */
	public void setRltype(String rltype) {
		this.rltype = rltype;
	}

	

	/**
	 * 日志ID取得
	 * @return 日志ID
	 */
	public Integer getRlid() {
		return rlid;
	}

	/**
	 * 日志ID设定
	 * @param rlid 日志ID
	 */
	public void setRlid(Integer rlid) {
		this.rlid = rlid;
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
	 * 日志记录时间取得
	 * @return 日志记录时间
	 */
	public String getRltime() {
		return rltime;
	}

	/**
	 * 日志记录时间设定
	 * @param rltime 日志记录时间
	 */
	public void setRltime(String rltime) {
		this.rltime = rltime;
	}

	/**
	 * 日志处理人角色ID取得
	 * @return 日志处理人角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 日志处理人角色ID设定
	 * @param roleid 日志处理人角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 日志处理人角色名称取得
	 * @return 日志处理人角色名称
	 */
	public String getRlrolename() {
		return rlrolename;
	}

	/**
	 * 日志处理人角色名称设定
	 * @param rlrolename 日志处理人角色名称
	 */
	public void setRlrolename(String rlrolename) {
		this.rlrolename = rlrolename;
	}

	/**
	 * 日志处理人ID取得
	 * @return 日志处理人ID
	 */
	public String getRluserid() {
		return rluserid;
	}

	/**
	 * 日志处理人ID设定
	 * @param rluserid 日志处理人ID
	 */
	public void setRluserid(String rluserid) {
		this.rluserid = rluserid;
	}

	/**
	 * 日志处理人姓名取得
	 * @return 日志处理人姓名
	 */
	public String getRlusername() {
		return rlusername;
	}

	/**
	 * 日志处理人姓名设定
	 * @param rlusername 日志处理人姓名
	 */
	public void setRlusername(String rlusername) {
		this.rlusername = rlusername;
	}

	/**
	 * 日志描述取得
	 * @return 日志描述
	 */
	public String getRldesc() {
		return rldesc;
	}

	/**
	 * 日志描述设定
	 * @param rldesc 日志描述
	 */
	public void setRldesc(String rldesc) {
		this.rldesc = rldesc;
	}

	/**
	 * 日志处理人填写的信息取得
	 * @return 日志处理人填写的信息
	 */
	public String getRlcomment() {
		return rlcomment;
	}

	/**
	 * 日志处理人填写的信息设定
	 * @param rlcomment 日志处理人填写的信息
	 */
	public void setRlcomment(String rlcomment) {
		this.rlcomment = rlcomment;
	}

	/**
	 * 附件索引取得
	 * @return 附件索引
	 */
	public String getRlattkey() {
		return rlattkey;
	}

	/**
	 * 附件索引设定
	 * @param rlattkey 附件索引
	 */
	public void setRlattkey(String rlattkey) {
		this.rlattkey = rlattkey;
	}

	/**
	 * 日志处理人机构层次码取得
	 * @return 日志处理人机构层次码
	 */
	public String getRlorgid() {
		return rlorgid;
	}

	/**
	 * 日志处理人机构层次码设定
	 * @param rlorgid 日志处理人机构层次码
	 */
	public void setRlorgid(String rlorgid) {
		this.rlorgid = rlorgid;
	}

	/**
	 * 日志处理人机构名称取得
	 * @return 日志处理人机构名称
	 */
	public String getRlorgname() {
		return rlorgname;
	}

	/**
	 * 日志处理人机构名称设定
	 * @param rlorgname 日志处理人机构名称
	 */
	public void setRlorgname(String rlorgname) {
		this.rlorgname = rlorgname;
	}

	/**
	 * 按钮ID设定
	 * 
	 * @return 按钮ID
	 */
	public String getPbdid() {
		return pbdid;
	}

	/**
	 * 按钮ID取得
	 * 
	 * @param pbdid 按钮ID
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

	public int compareTo(IG036Info o) {
		return this.rltime.compareTo(o.getRltime());
	}
}
