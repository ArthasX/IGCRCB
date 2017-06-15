/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.entity.IG286TB;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;

/**
 * 流程定义基本信息编辑画面Form
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0111Form extends BaseForm implements IG007Info {
	
	/** 流程定义的ID */
	protected String pdid;
	
	/** 表单信息的默认值 */
	protected String piddefault;

	/** 表单信息的描述 */
	protected String piddesc;

	/** 表单信息的ID */
	protected String pidid;

	/** 表单信息的显示名称 */
	protected String pidlabel;

	/** 表单信息的显示名称 */
	protected String pidlabel_bak;
	
	/** 表单信息的后台名称 */
	protected String pidname;

	/** 表单信息的取值范围 */
	protected String pidoption;

	/** 表单信息是否必填项 */
	protected String pidrequired;

	/** 表单信息的类型 */
	protected String pidtype;
	
	/** 流程定义记录的时间戳 */
	protected String fingerPrint;
	
	/** 模式 0登记，1编辑 */
	protected String mode = "0";

	/** 排序ID */
	protected String pidsortid;
	
	protected Integer pidgid;
	
	/** 表单信息的模式 */
	protected String pidmode;
	
	/** 表单信息的行显示模式 */
	protected String rowwidth;
	
	/** 表单信息的行显示模式 */
	protected String privatescope;
	
	/** 表单信息的排序信息 */
	protected String pididorder;
	
	/** 是否包含附件 */
    protected String hasattach;
    
    /** 表格类表单显示模式 */
    protected String piddisplay;
    
    /** 表格类表单显示模式 */
    protected String piddisplaya;
    
    /** 表格类表单使用模式 */
    protected String piduse;
    
    /** 宽度 */
    protected Integer pidwidth;
    
    /** 父表单定义主键 */
    protected String ppidid;
    
    /** 行数 */
    protected Integer pidrows;
    
    /** 是否隐藏列名 */
    protected String pidhide;
        
    /** 是否显示行号 */
    protected String showrownum;
    
    /** 表单单位 */
    protected String pidunit;
    
    /** 是否包含备注 */
    protected String remarks;
    
    /** 是否显示边线 */
    protected String showline;
    
    /** 单选/复选显示方式 */
    protected String showstyles;
    
    /** 标题显示模式 */
    protected String titledisplay;
    
    /** 是否包含审批意见 */
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

	/** 数字类型小数位数 */
	protected String decimals;
    
    /** 人员表单角色类型 */
    protected String participantRoleType;
    
    /** 对齐方式 */
    protected String align;
    
    /** 人员表单角色范围信息 */
    protected String participantRoles;
    
    /**文本域附件绑定*/
	protected Map<Integer, FormFile> fileMapMuti = null;
	
	/** 附件信息集合 */
	protected List<Attachment> attList;
	
	/** 附件ID集合 */
	protected String [] attids;
	
	/** 附件删除标识 */
	protected String [] attdel;
	
	/** 资产名称 */
	protected String [] asmname;
	
	/** 资产ID */
	protected String [] asminfo;
	
	/** 资产信息Map */
	protected Map<Integer, String> entityInfoMap;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		fileMapMuti = new HashMap<Integer, FormFile>();
	}
	
	public String getPididorder() {
		return pididorder;
	}

	public void setPididorder(String pididorder) {
		this.pididorder = pididorder;
	}

	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	protected String ccid;
	
	protected List<IG899TB> processPrivateInfoList;

	public Integer getPidgid() {
		return pidgid;
	}

	public void setPidgid(Integer pidgid) {
		this.pidgid = pidgid;
	}

	public String getPidsortid() {
		return pidsortid;
	}

	public void setPidsortid(String pidsortid) {
		this.pidsortid = pidsortid;
	}

	/**
	 * 模式取得
	 * 
	 * @return 模式
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 模式设定
	 *
	 * @param mode 模式
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * 流程定义的ID取得
	 * 
	 * @return 流程定义的ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义的ID设定
	 *
	 * @param pdid 流程定义的ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 表单信息的默认值取得
	 * 
	 * @return 表单信息的默认值
	 */
	public String getPiddefault() {
		return piddefault;
	}

	/**
	 * 表单信息的默认值设定
	 *
	 * @param piddefault 表单信息的默认值
	 */
	public void setPiddefault(String piddefault) {
		this.piddefault = piddefault;
	}

	/**
	 * 表单信息的描述取得
	 * 
	 * @return 表单信息的描述
	 */
	public String getPiddesc() {
		return piddesc;
	}

	/**
	 * 表单信息的描述设定
	 *
	 * @param piddesc 表单信息的描述
	 */
	public void setPiddesc(String piddesc) {
		this.piddesc = piddesc;
	}

	/**
	 * 表单信息的ID取得
	 * 
	 * @return 表单信息的ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 表单信息的ID设定
	 *
	 * @param pidid 表单信息的ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 表单信息的显示名称取得
	 * 
	 * @return 表单信息的显示名称
	 */
	public String getPidlabel() {
		return pidlabel;
	}

	/**
	 * 表单信息的显示名称设定
	 *
	 * @param pidlabel 表单信息的显示名称
	 */
	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}

	/**
	 * 表单信息的显示名称取得
	 * 
	 * @return 表单信息的显示名称
	 */
	public String getPidlabel_bak() {
		return pidlabel_bak;
	}

	/**
	 * 表单信息的显示名称设定
	 *
	 * @param pidlabel_bak 表单信息的显示名称
	 */
	public void setPidlabel_bak(String pidlabel_bak) {
		this.pidlabel_bak = pidlabel_bak;
	}

	/**
	 * 表单信息的后台名称取得
	 * 
	 * @return 表单信息的后台名称
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * 表单信息的后台名称设定
	 *
	 * @param pidname 表单信息的后台名称
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * 表单信息的取值范围取得
	 * 
	 * @return 表单信息的取值范围
	 */
	public String getPidoption() {
		return pidoption;
	}

	/**
	 * 表单信息的取值范围设定
	 *
	 * @param pidoption 表单信息的取值范围
	 */
	public void setPidoption(String pidoption) {
		this.pidoption = pidoption;
	}

	/**
	 * 表单信息的是否必填项取得
	 * 
	 * @return 表单信息的是否必填项
	 */
	public String getPidrequired() {
		return pidrequired;
	}

	/**
	 * 表单信息的是否必填项设定
	 *
	 * @param pidrequired 表单信息的是否必填项
	 */
	public void setPidrequired(String pidrequired) {
		this.pidrequired = pidrequired;
	}

	/**
	 * 表单信息的类型取得
	 * 
	 * @return 表单信息的类型
	 */
	public String getPidtype() {
		return pidtype;
	}

	/**
	 * 表单信息的类型设定
	 *
	 * @param pidtype 表单信息的类型
	 */
	public void setPidtype(String pidtype) {
		this.pidtype = pidtype;
	}

	/**
	 * 表单信息记录的时间戳取得
	 * 
	 * @return 表单信息记录的时间戳
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * 表单信息记录的时间戳设定
	 *
	 * @param fingerPrint 表单信息记录的时间戳
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public String getPidaccess() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPidvalue() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPiid() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<IG286TB> getProcessLinkageDefList() {
		return null;
	}

	public String getCcid() {
		// TODO Auto-generated method stub
		return ccid;
	}

	/**
	 * 表单模式取得
	 *
	 * @return pidmode 表单模式
	 */
	public String getPidmode() {
		return pidmode;
	}

	/**
	 * 表单模式设定
	 *
	 * @param pidmode 表单模式
	 */
	public void setPidmode(String pidmode) {
		this.pidmode = pidmode;
	}

	/**
	 * 表单信息的行显示模式取得
	 * 
	 * @return 表单信息的行显示模式
	 */
	public String getRowwidth() {
		return rowwidth;
	}

	/**
	 * 表单信息的行显示模式设定
	 *
	 * @param rowwidth 表单信息的行显示模式
	 */
	public void setRowwidth(String rowwidth) {
		this.rowwidth = rowwidth;
	}
	
	/**
	 * 表单信息的行显示模式设定
	 * 
	 * @return 表单信息的行显示模式
	 */
	public String getPrivatescope() {
		return privatescope;
	}

	/**
	 * 表单信息的行显示模式取得
	 * 
	 * @param privatescope 表单信息的行显示模式
	 */
	public void setPrivatescope(String privatescope) {
		this.privatescope = privatescope;
	}

	public List<IG899TB> getProcessPrivateInfoList() {
		// TODO Auto-generated method stub
		return processPrivateInfoList;
	}
	
	public void setProcessPrivateInfoList(List<IG899TB> processPrivateInfoList){
		this.processPrivateInfoList = processPrivateInfoList;
	}
	
	/** 查看模式 0最新：可编辑，1：历史：只查看 */
	protected String viewhistory;

	/**
	 * 查看模式
	 *
	 * @return 查看模式
	 */
	public String getViewhistory() {
		return viewhistory;
	}

	/**
	 * 查看模式
	 *
	 * @param viewHistory  0：最新，1历史
	 */
	public void setViewhistory(String viewhistory) {
		this.viewhistory = viewhistory;
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
	 * 表格类表单显示模式取得
	 * @return 表格类表单显示模式
	 */
	public String getPiddisplay() {
		return piddisplay;
	}

	/**
	 * 表格类表单显示模式设定
	 * @param piddisplay 表格类表单显示模式
	 */
	public void setPiddisplay(String piddisplay) {
		this.piddisplay = piddisplay;
	}

	/**
	 * 表格类表单使用模式取得
	 * @return 表格类表单使用模式
	 */
	public String getPiduse() {
		return piduse;
	}

	/**
	 * 表格类表单使用模式设定
	 * @param piduse 表格类表单使用模式
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

	public String getPiddisplaya() {
		return piddisplaya;
	}

	public void setPiddisplaya(String piddisplaya) {
		this.piddisplaya = piddisplaya;
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
	 * 是否显示边线取得
	 * @return showline 是否显示边线
	 */
	public String getShowline() {
		return showline;
	}

	/**
	 * 是否显示边线设定
	 * @param showline 是否显示边线
	 */
	public void setShowline(String showline) {
		this.showline = showline;
	}
	
	public String getPidunit() {
		return pidunit;
	}

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
	 * 标题显示模式取得
	 * @return titledisplay 标题显示模式
	 */
	public String getTitledisplay() {
		return titledisplay;
	}

	/**
	 * 标题显示模式设定
	 * @param titledisplay 标题显示模式
	 */
	public void setTitledisplay(String titledisplay) {
		this.titledisplay = titledisplay;
	}

	/**
	 * 是否包含审批意见取得
	 * @return needidea 是否包含审批意见
	 */
	public String getNeedidea() {
		return needidea;
	}

	/**
	 * 是否包含审批意见设定
	 * @param needidea 是否包含审批意见
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
	 * 人员表单角色类型取得
	 * @return participantRoleType 人员表单角色类型
	 */
	public String getParticipantRoleType() {
		return participantRoleType;
	}

	/**
	 * 人员表单角色类型设定
	 * @param participantRoleType 人员表单角色类型
	 */
	public void setParticipantRoleType(String participantRoleType) {
		this.participantRoleType = participantRoleType;
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
	 * 数字类型小数位数取得
	 * @return 数字类型小数位数
	 */
	public String getDecimals() {
		return decimals;
	}

	/**
	 * 数字类型小数位数设定
	 * @param decimals 数字类型小数位数
	 */
	public void setDecimals(String decimals) {
		this.decimals = decimals;
	}

	/**
	 * 人员表单角色范围信息取得
	 * @return participantRoles 人员表单角色范围信息
	 */
	public String getParticipantRoles() {
		return participantRoles;
	}

	/**
	 * 人员表单角色范围信息设定
	 * @param participantRoles 人员表单角色范围信息
	 */
	public void setParticipantRoles(String participantRoles) {
		this.participantRoles = participantRoles;
	}
	
	public FormFile getAttachFileMuti(int index) {
		return (FormFile) fileMapMuti.get(new Integer(index));
	}

	public void setAttachFileMuti(int index, FormFile file) {
		fileMapMuti.put(new Integer(index), file);
	}

	public Map<Integer, FormFile> getFileMapMuti() {
		return fileMapMuti;
	}

	public void setFileMapMuti(Map<Integer, FormFile> fileMapMuti) {
		this.fileMapMuti = fileMapMuti;
	}

	public List<Attachment> getAttList() {
		return attList;
	}

	public void setAttList(List<Attachment> attList) {
		this.attList = attList;
	}

	public String[] getAttids() {
		return attids;
	}

	public void setAttids(String[] attids) {
		this.attids = attids;
	}

	public String[] getAttdel() {
		return attdel;
	}

	public void setAttdel(String[] attdel) {
		this.attdel = attdel;
	}

	public String[] getAsmname() {
		return asmname;
	}

	public void setAsmname(String[] asmname) {
		this.asmname = asmname;
	}

	public String[] getAsminfo() {
		return asminfo;
	}

	public void setAsminfo(String[] asminfo) {
		this.asminfo = asminfo;
	}

	public Map<Integer, String> getEntityInfoMap() {
		return entityInfoMap;
	}

	public void setEntityInfoMap(Map<Integer, String> entityInfoMap) {
		this.entityInfoMap = entityInfoMap;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.workflow.prd.model.IG007Info#getIsFlag()
	 */
	public String getIsFlag() {
		// TODO Auto-generated method stub
		return null;
	}
}
