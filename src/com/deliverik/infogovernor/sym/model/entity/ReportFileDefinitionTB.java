/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.model.entity.CodeDetailTB;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;

/**
 * 报表信息实体
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="ReportFileDefinition")
public class ReportFileDefinitionTB extends BaseEntity implements Serializable, Cloneable, ReportFileDefinition {

	/** 主键 */
	@Id
	@TableGenerator(
		    name="REPORTFILEDEFINITION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="REPORTFILEDEFINITION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="REPORTFILEDEFINITION_TABLE_GENERATOR")
	protected Integer rfdid;

	/** 报表显示名称 */
	protected String rfdtitle;
	
	/** 报表分类 */
	protected String rfdtype;

	/** 报表说明 */
	protected String rfddesc;

	/** 报表文件名 */
	protected String rfdfilename;

	/** 报表登记人ID */
	protected String rfduserid;

	/** 报表登记人姓名 */
	protected String rfdusername;

	/** 报表登记时间 */
	protected String rfdinstime;
	
	/** 报表版本号 */
	protected Integer rfdversion;
	
	/** 报表最新版本号 */
	protected Integer rfdnewversion;
	
	/** 报表类型 */
	protected String rfdpictype;
	
	/** 报表参数 */
	protected String rfdparameters;
	
	/** 是否订制 */
	protected String isFlag;
	
	/** 基础数据实体 */
	@OneToOne
	@JoinColumn(name="rfdtype", referencedColumnName="syscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected CodeDetailTB codeDetailTB;

	/**
	 * 获取主键
	 * @return 
	 */
	public Serializable getPK() {
		return rfdid;
	}

	/**
	 * 比较
	 * @return 
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof ReportFileDefinitionTB))
			return false;
		ReportFileDefinition target = (ReportFileDefinition) obj;
		if (!(getRfdid()==target.getRfdid()))
			return false;

		return true;
	}

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Integer getRfdid() {
		return rfdid;
	}

	/**
	 * 主键设定
	 * @param rfdid 主键
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}

	/**
	 * 报表显示名称取得
	 * @return 报表显示名称
	 */
	public String getRfdtitle() {
		return rfdtitle;
	}

	/**
	 * 报表显示名称设定
	 * @param rfdtitle 报表显示名称
	 */
	public void setRfdtitle(String rfdtitle) {
		this.rfdtitle = rfdtitle;
	}

	/**
	 * 报表分类取得
	 * @return 报表分类
	 */
	public String getRfdtype() {
		return rfdtype;
	}

	/**
	 * 报表分类设定
	 * @param rfdtype 报表分类
	 */
	public void setRfdtype(String rfdtype) {
		this.rfdtype = rfdtype;
	}

	/**
	 * 报表说明取得
	 * @return 报表说明
	 */
	public String getRfddesc() {
		return rfddesc;
	}

	/**
	 * 报表说明设定
	 * @param rfddesc 报表说明
	 */
	public void setRfddesc(String rfddesc) {
		this.rfddesc = rfddesc;
	}

	/**
	 * 报表文件名取得
	 * @return 报表文件名
	 */
	public String getRfdfilename() {
		return rfdfilename;
	}

	/**
	 * 报表文件名设定
	 * @param rfdfilename 报表文件名
	 */
	public void setRfdfilename(String rfdfilename) {
		this.rfdfilename = rfdfilename;
	}

	/**
	 * 报表登记人ID取得
	 * @return 报表登记人ID
	 */
	public String getRfduserid() {
		return rfduserid;
	}

	/**
	 * 报表登记人ID设定
	 * @param rfduserid 报表登记人ID
	 */
	public void setRfduserid(String rfduserid) {
		this.rfduserid = rfduserid;
	}

	/**
	 * 报表登记人姓名取得
	 * @return 报表登记人姓名
	 */
	public String getRfdusername() {
		return rfdusername;
	}

	/**
	 * 报表登记人姓名设定
	 * @param rfdusername 报表登记人姓名
	 */
	public void setRfdusername(String rfdusername) {
		this.rfdusername = rfdusername;
	}

	/**
	 * 报表登记时间取得
	 * @return 报表登记时间
	 */
	public String getRfdinstime() {
		return rfdinstime;
	}

	/**
	 * 报表登记时间设定
	 * @param rfdinstime 报表登记时间
	 */
	public void setRfdinstime(String rfdinstime) {
		this.rfdinstime = rfdinstime;
	}
	
	/**
	 * 报表版本号取得
	 * @return 报表版本号
	 */
	public Integer getRfdversion() {
		return rfdversion;
	}

	/**
	 * 报表版本号设定
	 * @param rfdversion 报表版本号
	 */
	public void setRfdversion(Integer rfdversion) {
		this.rfdversion = rfdversion;
	}
	
	/**
	 * 报表最新版本号取得
	 * @return 报表最新版本号
	 */
	public Integer getRfdnewversion() {
		return rfdnewversion;
	}

	/**
	 * 报表最新版本号设定
	 * @param rfdnewversion 报表最新版本号
	 */
	public void setRfdnewversion(Integer rfdnewversion) {
		this.rfdnewversion = rfdnewversion;
	}

	/**
	 * 基础数据实体取得
	 * @return 基础数据实体
	 */
	public CodeDetailTB getCodeDetailTB() {
		return codeDetailTB;
	}
	
	public String getRfdpictype() {
		return rfdpictype;
	}

	public void setRfdpictype(String rfdpictype) {
		this.rfdpictype = rfdpictype;
	}

	public String getRfdparameters() {
		return rfdparameters;
	}

	public void setRfdparameters(String rfdparameters) {
		this.rfdparameters = rfdparameters;
	}

	public String getIsFlag() {
		return isFlag;
	}

	public void setIsFlag(String isFlag) {
		this.isFlag = isFlag;
	}

	public void setCodeDetailTB(CodeDetailTB codeDetailTB) {
		this.codeDetailTB = codeDetailTB;
	}
	
	
}
