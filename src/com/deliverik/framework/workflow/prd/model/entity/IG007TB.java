package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;


/**
 * 流程变量定义信息实体
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IG007")
public class IG007TB extends BaseEntity implements Serializable, Cloneable, IG007Info {

	/**
	 * 流程变量定义ID
	 */
	@Id
	protected  String pidid;

	/**
	 * 流程类型ID
	 */
	protected  String pdid;

	/**
	 * 流程变量名称
	 */
	protected  String pidname;

	/**
	 * 流程变量显示名称
	 */
	protected  String pidlabel;

	/**
	 * 流程变量描述
	 */
	protected  String piddesc;

	/**
	 * 流程变量类型
	 */
	protected  String pidtype;

	/**
	 * 流程变量选项
	 */
	protected  String pidoption;

	/**
	 * 流程变量默认值
	 */
	protected  String piddefault;

	/**
	 * 流程变量是否必填
	 */
	protected  String pidrequired;
	
	/**
	 * 流程变量排序标识（1，2，3....，数字越小优先级越高）
	 */
	protected  String pidsortid;

	/** 表单信息的模式 */
	protected String pidmode;
	
	/**
	 * 流程变量值
	 */
	@Transient
	protected String pidvalue;
	
	/**
	 * 参与者具有的流程变量权限
	 */
	@Transient
	protected String pidaccess;
	
	/**
	 * 流程变量ID
	 */
	@Transient
	protected Integer piid;
	
	/**
	 * 共通变量ID
	 */
	protected Integer pidgid;

	/**
	 * 保存树形流程变量的CCID（取自codeCategory表）
	 */
	protected  String ccid;
	
	/** 表单信息的行显示模式 */
	protected String rowwidth;
	
	/** 私有变量权限范围 */
	protected String privatescope;
	
	/** 是否包含附件 */
    protected String hasattach;
    
    /** 表格模式 */
    protected String piddisplay;
    
    /** 使用模式 */
    protected String piduse;
    
    /** 宽度 */
    protected Integer pidwidth;
    
    /** 父表单定义主键 */
    protected String ppidid;
    
    /** 行数 */
    protected Integer pidrows;
    
    /** 是否隐藏列名 */
    protected String pidhide;
    
        
    
    /** 表格类表单是否显示边线 */
    protected String showline;
    
    /** 表单单位 */
	protected String pidunit; 
	
	/** 是否包含备注 */
    protected String remarks;
    
    /** 单选/复选显示方式 */
    protected String showstyles;
    
    /** 是否显示行号 */
    protected String showrownum;
    
	/**
	 * 备注
	 */
	@Transient
	protected String pidcomment;
	
	/** 表格名称显示方式 */
	protected String titledisplay;
	
	/** 是否需要审批意见 */
	protected String needidea;
	
    /** js方法 */
    protected String jsfunction;
    
    /** 表格式表单组模式标题内容比例 */
    protected String pidratio;
    
    /** 最大字符数 */
    protected Integer pidsize;
    
    /** 表单可写标识 */
    protected String writeable;
    
    /** 树形表单只能选择末级标识 */
    protected String selecedlast;
    
    /** 数字类型 */
    protected String numbertype;
    
    /** 对齐方式 */
    protected String align;
	
    /** 是否为标识表单 */
    protected String isFlag;
    
	/**
	 * 树形流程变量CCID取得
	 * @return 树形流程变量CCID
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * 树形流程变量CCID设定
	  * @param ccid 树形流程变量CCID
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}
	
	
	public Integer getPidgid() {
		return pidgid;
	}

	public void setPidgid(Integer pidgid) {
		this.pidgid = pidgid;
	}

	/**
	 * 主键取得
	 * @return pidid
	 */
	public Serializable getPK() {
		return pidid;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof IG007TB))
			return false;
		IG007Info target = (IG007Info) obj;
		if (!(getPidid()==target.getPidid()))
			return false;
		return true;
	}

	/**
	 * 流程变量定义ID取得
	 * @return 流程变量定义ID
	 */
	public String getPidid() {
		return pidid;
	}
	
	/**
	 * 流程变量定义ID设定
	  * @param pidid 流程变量定义ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 流程类型ID取得
	 * @return 流程类型ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程类型ID设定
	  * @param pdid 流程类型ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程变量名称取得
	 * @return 流程变量名称
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * 流程变量名称设定
	  * @param pidname 流程变量名称
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * 流程变量显示名称取得
	 * @return 流程变量显示名称
	 */
	public String getPidlabel() {
		return pidlabel;
	}

	/**
	 * 流程变量显示名称设定
	  * @param pidlabel 流程变量显示名称
	 */
	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}

	/**
	 * 流程变量描述取得
	 * @return 流程变量描述
	 */
	public String getPiddesc() {
		return piddesc;
	}

	/**
	 * 流程变量描述设定
	  * @param piddesc 流程变量描述
	 */
	public void setPiddesc(String piddesc) {
		this.piddesc = piddesc;
	}

	/**
	 * 流程变量类型取得
	 * @return 流程变量类型
	 */
	public String getPidtype() {
		return pidtype;
	}

	/**
	 * 流程变量类型设定
	  * @param pidtype 流程变量类型
	 */
	public void setPidtype(String pidtype) {
		this.pidtype = pidtype;
	}

	/**
	 * 流程变量选项取得
	 * @return 流程变量选项
	 */
	public String getPidoption() {
		return pidoption;
	}

	/**
	 * 流程变量选项设定
	  * @param pidoption 流程变量选项
	 */
	public void setPidoption(String pidoption) {
		this.pidoption = pidoption;
	}

	/**
	 * 流程变量默认值取得
	 * @return 流程变量默认值
	 */
	public String getPiddefault() {
		if(piddefault == null) {
			return "";
		} else {
			return piddefault;
		}
	}

	/**
	 * 流程变量默认值设定
	  * @param piddefault 流程变量默认值
	 */
	public void setPiddefault(String piddefault) {
		this.piddefault = piddefault;
	}

	/**
	 * 流程变量ID取得
	 * @return 流程变量ID
	 */
	public Integer getPiid() {
		return piid;
	}

	/**
	 * 流程变量ID设定
	  * @param piid 流程变量ID
	 */
	public void setPiid(Integer piid) {
		this.piid = piid;
	}

	/**
	 * 流程变量排序标识取得
	 * @return 流程变量排序标识
	 */
	public String getPidsortid() {
		return pidsortid;
	}

	/**
	 * 流程变量排序标识设定
	  * @param pidsortid 流程变量排序标识
	 */
	public void setPidsortid(String pidsortid) {
		this.pidsortid = pidsortid;
	}
	
	/**
	 * 流程变量是否必填取得
	 * @return 流程变量是否必填
	 */
	public String getPidrequired() {
		return pidrequired;
	}

	/**
	 * 流程变量是否必填设定
	  * @param pidrequired 流程变量是否必填
	 */
	public void setPidrequired(String pidrequired) {
		this.pidrequired = pidrequired;
	}
	
	/**
	 * 流程变量值取得
	 * @return 流程变量值
	 */
	public String getPidvalue() {
		return pidvalue;
	}

	/**
	 * 流程变量值设定
	 * @param pidvalue 流程变量值
	 */
	public void setPidvalue(String pidvalue) {
		this.pidvalue = pidvalue;
	}
	
	/**
	 * 参与者具有的流程变量权限取得
	 * @return 参与者具有的流程变量权限
	 */
	public String getPidaccess() {
		return pidaccess;
	}

	/**
	 * 流参与者具有的流程变量权限设定
	 * @param pidaccess 参与者具有的流程变量权限
	 */
	public void setPidaccess(String pidaccess) {
		this.pidaccess = pidaccess;
	}
	
	/**
	 * 表单信息的模式取得
	 *
	 * @return 表单信息的模式
	 */
	public String getPidmode() {
		return pidmode;
	}

	/**
	 * 表单信息的模式设定
	 *
	 * @param pidmode 表单信息的模式
	 */
	public void setPidmode(String pidmode) {
		this.pidmode = pidmode;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="initiativepidid", referencedColumnName="pidid", updatable=false, insertable= false)
	@NotFound(action = NotFoundAction.IGNORE)
	protected List<IG286TB> processLinkageDefList;
	public List<IG286TB> getProcessLinkageDefList() {
		return processLinkageDefList;
	}

	public void setProcessLinkageDefList(
			List<IG286TB> processLinkageDefList) {
		this.processLinkageDefList = processLinkageDefList;
	}

	/**
	 * 表单信息的行显示模式取得
	 *
	 * @return pidmode 表单信息的行显示模式
	 */
	public String getRowwidth() {
		return rowwidth;
	}

	/**
	 * 表单信息的行显示模式设定
	 *
	 * @param pidmode 表单信息的行显示模式
	 */
	
	public void setRowwidth(String rowwidth) {
		this.rowwidth = rowwidth;
	}

	/**
	 * 私有变量权限范围设定
	 * 
	 * @return 私有变量权限范围
	 */
	public String getPrivatescope() {
		return privatescope;
	}

	/**
	 * 私有变量权限范围取得
	 * 
	 * @param privatescope 私有变量权限范围
	 */
	public void setPrivatescope(String privatescope) {
		this.privatescope = privatescope;
	}
	
	public void setProcessPrivateInfoList(
			List<IG899TB> processPrivateInfoList) {
		this.processPrivateInfoList = processPrivateInfoList;
	}

	/**
	 * 私有变量值取得
	 */
	@Transient
	protected List<IG899TB> processPrivateInfoList;

	/**
	 * 私有变量集合设定
	 * 
	 * @return 私有变量集合
	 */
	public List<IG899TB> getProcessPrivateInfoList() {
		return processPrivateInfoList;
	}

	/**
	 * 是否包含附件取得
	 * @return 是否包含附件
	 */
	public String getHasattach() {
		return hasattach;
	}

	/**
	 * 是否包含附件设定
	 * @param hasattach 是否包含附件
	 */
	public void setHasattach(String hasattach) {
		this.hasattach = hasattach;
	}

	/**
	 * 表格模式取得
	 * @return piddisplay 表格模式
	 */
	public String getPiddisplay() {
		return piddisplay;
	}

	/**
	 * 表格模式设定
	 * @param piddisplay 表格模式
	 */
	public void setPiddisplay(String piddisplay) {
		this.piddisplay = piddisplay;
	}

	/**
	 * 使用模式取得
	 * @return piduse 使用模式
	 */
	public String getPiduse() {
		return piduse;
	}

	/**
	 * 使用模式设定
	 * @param piduse 使用模式
	 */
	public void setPiduse(String piduse) {
		this.piduse = piduse;
	}

	/**
	 * 宽度取得
	 * @return pidwidth 宽度
	 */
	public Integer getPidwidth() {
		return pidwidth;
	}

	/**
	 * 宽度设定
	 * @param pidwidth 宽度
	 */
	public void setPidwidth(Integer pidwidth) {
		this.pidwidth = pidwidth;
	}

	/**
	 * 父表单定义主键取得
	 * @return ppidid 父表单定义主键
	 */
	public String getPpidid() {
		return ppidid;
	}

	/**
	 * 父表单定义主键设定
	 * @param ppidid 父表单定义主键
	 */
	public void setPpidid(String ppidid) {
		this.ppidid = ppidid;
	}

	/**
	 * 行数取得
	 * @return pidrows 行数
	 */
	public Integer getPidrows() {
		return pidrows;
	}

	/**
	 * 行数设定
	 * @param pidrows 行数
	 */
	public void setPidrows(Integer pidrows) {
		this.pidrows = pidrows;
	}

	/**
	 * 是否隐藏列名取得
	 * @return pidhide 是否隐藏列名
	 */
	public String getPidhide() {
		return pidhide;
	}

	/**
	 * 是否隐藏列名设定
	 * @param pidhide 是否隐藏列名
	 */
	public void setPidhide(String pidhide) {
		this.pidhide = pidhide;
	}
	
	
	/**
	 * 是否显示行号取得
	 * @return showrownum 是否显示行号
	 */
	public String getShowrownum() {
		return showrownum;
	}

	/**
	 * 是否显示行号设定
	 * @param showrownum 是否显示行号
	 */
	public void setShowrownum(String showrownum) {
		this.showrownum = showrownum;
	}

	/**
	 * 表格类表单是否显示边线取得
	 * @return showline 表格类表单是否显示边线
	 */
	public String getShowline() {
		return showline;
	}

	/**
	 * 表格类表单是否显示边线设定
	 * @param showline 表格类表单是否显示边线
	 */
	public void setShowline(String showline) {
		this.showline = showline;
	}
	
	/**
	 * 表单单位取得
	 */
	public String getPidunit() {
		return pidunit;
	}
	/**
	 * 表单单位设定
	 * @param pidunit
	 */
	public void setPidunit(String pidunit) {
		this.pidunit = pidunit;
	}

	/**
	 *是否包含备注取得
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 *是否包含备注设置
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 *备注取得
	 */
	public String getPidcomment() {
		return pidcomment;
	}

	/**
	 *备注设置
	 */
	public void setPidcomment(String pidcomment) {
		this.pidcomment = pidcomment;
	}

	/**
	 *单选复选显示方式取得
	 */
	public String getShowstyles() {
		return showstyles;
	}

	/**
	 *单选复选显示方式设定
	 */
	public void setShowstyles(String showstyles) {
		this.showstyles = showstyles;
	}

	/**
	 * 表格名称显示方式取得
	 * @return titledisplay 表格名称显示方式
	 */
	public String getTitledisplay() {
		return titledisplay;
	}

	/**
	 * 表格名称显示方式设定
	 * @param titledisplay 表格名称显示方式
	 */
	public void setTitledisplay(String titledisplay) {
		this.titledisplay = titledisplay;
	}

	/**
	 * 是否需要审批意见取得
	 * @return needidea 是否需要审批意见
	 */
	public String getNeedidea() {
		return needidea;
	}

	/**
	 * 是否需要审批意见设定
	 * @param needidea 是否需要审批意见
	 */
	public void setNeedidea(String needidea) {
		this.needidea = needidea;
	}

	/**
	 * js方法取得
	 * @return jsfunction js方法
	 */
	public String getJsfunction() {
		return jsfunction;
	}

	/**
	 * js方法设定
	 * @param jsfunction js方法
	 */
	public void setJsfunction(String jsfunction) {
		this.jsfunction = jsfunction;
	}

	/**
	 * 表格式表单组模式标题内容比例取得
	 * @return pidratio 表格式表单组模式标题内容比例
	 */
	public String getPidratio() {
		return pidratio;
	}

	/**
	 * 表格式表单组模式标题内容比例设定
	 * @param pidratio 表格式表单组模式标题内容比例
	 */
	public void setPidratio(String pidratio) {
		this.pidratio = pidratio;
	}

	/**
	 * 最大字符数取得
	 * @return pidsize 最大字符数
	 */
	public Integer getPidsize() {
		return pidsize;
	}

	/**
	 * 最大字符数设定
	 * @param pidsize 最大字符数
	 */
	public void setPidsize(Integer pidsize) {
		this.pidsize = pidsize;
	}

	/**
	 * 表单可写标识取得
	 * @return writeable 表单可写标识
	 */
	public String getWriteable() {
		return writeable;
	}

	/**
	 * 表单可写标识设定
	 * @param writeable 表单可写标识
	 */
	public void setWriteable(String writeable) {
		this.writeable = writeable;
	}

	/**
	 * 树形表单只能选择末级标识取得
	 * @return selecedlast 树形表单只能选择末级标识
	 */
	public String getSelecedlast() {
		return selecedlast;
	}

	/**
	 * 树形表单只能选择末级标识设定
	 * @param selecedlast 树形表单只能选择末级标识
	 */
	public void setSelecedlast(String selecedlast) {
		this.selecedlast = selecedlast;
	}

	/**
	 * 数字类型取得
	 * @return numbertype 数字类型
	 */
	public String getNumbertype() {
		return numbertype;
	}

	/**
	 * 数字类型设定
	 * @param numbertype 数字类型
	 */
	public void setNumbertype(String numbertype) {
		this.numbertype = numbertype;
	}

	/**
	 * 对齐方式取得
	 * @return align 对齐方式
	 */
	public String getAlign() {
		return align;
	}

	/**
	 * 对齐方式设定
	 * @param align 对齐方式
	 */
	public void setAlign(String align) {
		this.align = align;
	}
	/**
	 * 是否为标识表单取得
	 * @return isFlag 是否为标识表单
	 */
	public String getIsFlag() {
		return isFlag;
	}

	/**
	 * 是否为标识表单设定
	 * @param isFlag 是否为标识表单
	 */
	public void setIsFlag(String isFlag) {
		this.isFlag = isFlag;
	}
}
