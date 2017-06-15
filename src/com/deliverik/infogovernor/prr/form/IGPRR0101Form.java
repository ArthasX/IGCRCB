/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.form;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * @Description: 流程发起Form
 * @Author  
 * @History 2010-9-13     新建 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR0101Form extends BaseForm implements IG500Info, WorkFlowParameterInfo {
	
	/** 扩展参数值 */
	protected String parameters;
	
	/** 流程定义ID */
	protected String pdid;
	
	/** 资产ID */
	protected Integer eiid;

	/** 流程状态ID */
	protected String psdid;
	
	/** 流程发布位置 */
	protected String pts;
	
	/** 动作标识 如0010 */
	protected String action;
	
	/** 日志信息 */
	protected String rlcomment;
	
	/** 是否第一次进入页面标识 */
	protected String isFirst;
	
	/** 附件 */
	protected Map<Integer, FormFile> fileMap = null;
	
	/**文本域附件绑定*/
	protected Map<Integer, FormFile> fileMapMuti = null;
	
	/** 表格类表单列附件 */
	protected Map<Integer, FormFile> fileMapTable = null;
	
	/**文本域附件绑定map中的对应文本域名称及顺序*/
	protected String[] att=new String[]{};
	
	/** 流程变量参数值 */
	protected String[] pivarvalue;
	
	/** 流程变量参数标识 */
	protected String[] pivarname;
	
	/** 流程变量参数名称 */
	protected String[] pivarlabel;
	
	/** 流程变量参数类型 */
	protected String[] pivartype;
	
	/** 流程变量权限 */
	protected String[] pidaccess;
	
	/** 流程变量模式 */
	protected String[] pidmode;
	
	/** 流程私有权限范围 */
	protected String[] privatescope;
	
	/** 流程变量定义ID */
	protected String[] pidid;
	
	/** 流程变量相关资产名称 */
	protected String[] pivarassetname;
	
	/** 流程变量相关流程名称 */
	protected String[] pivarprname;
	
	/** 流程变量相关项目名称 */
	protected String[] pivarprjname;
	
	/** 流程变量单选 */
	protected String[] pivarradio;
	
	/** 流程变量多选 */
	protected String[] pivarcheckbox;
	
	/** 流程变量树 */
	protected String[] pivartreename;
	
	/** 参与者ID*/
	protected String[] participants;
	
	protected String pjdtype;
	
	/** 主办部门 */
	protected String[] ppsupers;
	
	public String[] getPivartreename() {
		return pivartreename;
	}

	public void setPivartreename(String[] pivartreename) {
		this.pivartreename = pivartreename;
	}

	/** 流程变量参数值最大字节数 */
	private static final int MAX_BYTE = 3000;
	
	/**  流程记录ID */
	protected Integer prid;
	
	/** 流程记录类型 */
	protected String prtype;
	
	/** 流程记录子类型 */
	protected String prsubtype;
	
	/** 流程记录状态 */
	protected String prstatus;
	
	/** 流程记录状态子状态 */
	protected String prsubstatus;
	
	/** 流程记录题目 */
	protected String prtitle;
	
	/** 流程记录描述 */
	protected String prdesc;
	
	/** 流程记录建立时间 */
	protected String propentime;
	
	/** 流程记录关闭时间 */
	protected String prclosetime;
	
	/** 流程记录计划执行时间 */
	protected String prplantime;
	
	/** 流程记录计划执行周期 */
	protected String prduration;
	
	/** 流程记录紧急程度 */
	protected String prurgency;
	
	/** 流程记录影响程度 */
	protected String primpact;
	
	/** 流程记录相关资产ID */
	protected Integer prassetid;
	
	/** 流程记录相关资产名称 */
	protected String prassetname;
	
	/** 流程记录的相关业务 */
	protected String prbusiness;
	
	/** 流程记录执行计划 */
	protected String primplplan;
	
	/** 流程记录恢复计划 */
	protected String prbackplan;
	
	/** 流程记录验证计划 */
	protected String prvfyplan;
	
	/** 流程记录相关项目ID */
	protected Integer pid;
	
	/** 流程记录相关项目编号 */
	protected String pcode;
	
	/** 流程记录相关项目名称 */
	protected String pname;
	
	/** 流程记录发起者联系方式 */
	protected String prinfo;
	
	/** 流程记录相关流程ID */
	protected Integer prcorid;
	
	/** 流程记录相关流程类型 */
	protected String prcortype;
	
	/** 流程记录相关流程名称 */
	protected String prcortitle;
	
	/** 流程记录相关资产类型 */
	protected String prassetcategory;
	
	/** 流程记录发起者用户ID */
	protected String pruserid;
	
	/** 流程记录发起者用户姓名 */
	protected String prusername;
	
	/** 流程记录发起者角色ID */
	protected Integer prroleid;
	
	/** 流程记录发起者角色名称 */
	protected String prrolename;
	
	/** 流程记录流程类型ID */
	protected String prpdid;
	
	/** 流程记录流程类型名称 */
	protected String prpdname;
	
	/** 流程记录发起者所属机构层次码 */
	protected String prorgid;
	
	/** 流程记录发起者所属机构名称 */
	protected String prorgname;
	
	/** 流程记录工单号 */
	protected String prserialnum;
	
	/** 流程记录实际解决时间（从开始到结束） */
	protected Integer prfacttime;
	
	/** 自定义流程临时跃迁条件 */
	protected String prptdcond;
	
	/** 记录时间戳 */
	protected String fingerPrint;
	
	/** 快捷发起标识 */
	protected String isServiceStart;
	
	/** 关联流程ID */
	protected Integer parprid;
	
	/**流程变量参数ID*/
	protected String[] piid;
	
	/** 流程变量角色名称 */
	protected String[] pivarrolename;
	
	
	/** 文本域绑定附件前处理 */
	protected String strpsidid;
	
	/**文本域附件绑定删除*/
	protected String delFileMutiStr;
	
	/** 角色ID */
	protected Integer roleid;
	
	/** 流程模版ID */
	protected Integer ptid;
	
	/** 表格列信息定义主键集合 */
	protected String[] column_pidid;
	/** 表格列值集合 */
	protected String[] column_value;
	/** 表格列值行号集合 */
	protected String[] column_rownumber; 

	/** 资产 */
	protected Map<Integer, String> entityMap = null;
	
	/** 备注 */
	protected String[] pidcomment;
	
	/** 表格类表单附件列标识 */
	protected String addTableColumnFileStr;
	
	/** 表单说明 */
	protected String[] piddesc;
	
	/** 分派参与者按机构过滤 */
	protected String assign_orgsyscoding;
	
	/** 人员表单用户ID */
	protected String [] par_userid;
	
	/** 人员表单用户名称 */
	protected String [] par_username;
	
	/** 人员表单机构码 */
	protected String [] par_orgid;
	
	/** 人员表单机构名称 */
	protected String [] par_orgname;
	
	/** 人员表单角色ID */
	protected Integer [] par_roleid;
	
	/** 人员表单角色名称 */
	protected String [] par_rolename;
	
	/** 人员表单表单定义ID */
	protected String [] par_pidid;
	
	/** 人员表单电话 */
	protected String [] par_phone;
	
	/** 表格式表单附件删除标识 */
	protected String delTableColumnFileStr;
	
	/** 资产删除标识 */
	protected String pieids;
	
	/**跳转*/
	protected String jump;
	
	/**
	 *备注取得
	 */
	public String[] getPidcomment() {
		return pidcomment;
	}

	/**
	 *备注设置
	 */
	public void setPidcomment(String[] pidcomment) {
		this.pidcomment = pidcomment;
	}

	public String[] getPivarrolename() {
		return pivarrolename;
	}

	public void setPivarrolename(String[] pivarrolename) {
		this.pivarrolename = pivarrolename;
	}

	public String[] getPiid() {
		return piid;
	}

	public void setPiid(String[] piid) {
		this.piid = piid;
	}
	
	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 *
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程变量定义ID取得
	 * @return 流程变量定义ID
	 */
	public String[] getPidid() {
		return pidid;
	}

	/**
	 * 流程变量定义ID设定
	 * @param pidid 流程变量定义ID
	 */
	public void setPidid(String[] pidid) {
		this.pidid = pidid;
	}

	/**
	 * 附件取得
	 * @return 附件
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
	 * 流程变量参数值取得
	 * @return 流程变量参数值
	 */
	public String[] getPivarvalue() {
		return pivarvalue;
	}

	/**
	 * 流程变量参数值设定
	 * @param pivarvalue 流程变量参数值
	 */
	public void setPivarvalue(String[] pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	/**
	 * 流程变量参数标识取得
	 * @return 流程变量参数标识
	 */
	public String[] getPivarname() {
		return pivarname;
	}

	/**
	 * 流程变量参数标识设定
	 * @param pivarname 流程变量参数标识
	 */
	public void setPivarname(String[] pivarname) {
		this.pivarname = pivarname;
	}

	/**
	 * 流程变量参数名称取得
	 * @return 流程变量参数名称
	 */
	public String[] getPivarlabel() {
		return pivarlabel;
	}

	/**
	 * 流程变量参数名称设定
	 * @param pivarlabel 流程变量参数名称
	 */
	public void setPivarlabel(String[] pivarlabel) {
		this.pivarlabel = pivarlabel;
	}

	/**
	 * 流程变量参数类型取得
	 * @return 流程变量参数类型
	 */
	public String[] getPivartype() {
		return pivartype;
	}

	/**
	 * 流程变量参数类型设定
	 * @param pivartype 流程变量参数类型
	 */
	public void setPivartype(String[] pivartype) {
		this.pivartype = pivartype;
	}


	/**
	 * 流程状态ID取得
	 * 
	 * @return 流程状态ID
	 */
	public String getPsdid() {
		return psdid;
	}


	/**
	 * 流程状态ID设定
	 *
	 * @param psdid 流程状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	
	/**
	 * 日志信息取得
	 * 
	 * @return 日志信息
	 */
	public String getRlcomment() {
		return rlcomment;
	}

	/**
	 * 日志信息设定
	 *
	 * @param rlcomment 日志信息
	 */
	public void setRlcomment(String rlcomment) {
		this.rlcomment = rlcomment;
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
	 * 流程变量权限取得
	 * 
	 * @return 流程变量权限
	 */
	public String[] getPidaccess() {
		return pidaccess;
	}

	/**
	 * 流程变量权限设定
	 *
	 * @param pidaccess 流程变量权限
	 */
	public void setPidaccess(String[] pidaccess) {
		this.pidaccess = pidaccess;
	}
	
	/**
	 * 动作标识取得
	 * @return 动作标识
	 */
	public String getAction() {
		return action;
	}

	/**
	 * 动作标识设定
	 * @param action 动作标识
	 */
	public void setAction(String action) {
		this.action = action;
	}
	
	/**
	 * 是否第一次进入页面标识取得
	 * @return 是否第一次进入页面标识
	 */
	public String getIsFirst() {
		return isFirst;
	}

	/**
	 * 是否第一次进入页面标识设定
	 * @param isFirst 是否第一次进入页面标识
	 */
	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
	}


	/**
	 * 流程变量相关资产名称取得
	 * @return 流程变量相关资产名称
	 */
	public String[] getPivarassetname() {
		return pivarassetname;
	}

	/**
	 * 流程变量相关资产名称设定
	 * @param pivarassetname 流程变量相关资产名称
	 */
	public void setPivarassetname(String[] pivarassetname) {
		this.pivarassetname = pivarassetname;
	}

	/**
	 * 流程变量相关流程名称取得
	 * @return 流程变量相关流程名称
	 */
	public String[] getPivarprname() {
		return pivarprname;
	}

	/**
	 * 流程变量相关流程名称设定
	 * @param pivarprname 流程变量相关流程名称
	 */
	public void setPivarprname(String[] pivarprname) {
		this.pivarprname = pivarprname;
	}

	/**
	 * 流程变量相关项目名称取得
	 * @return 流程变量相关项目名称
	 */
	public String[] getPivarprjname() {
		return pivarprjname;
	}

	/**
	 * 流程变量相关项目名称设定
	 * @param pivarprjname 流程变量相关项目名称
	 */
	public void setPivarprjname(String[] pivarprjname) {
		this.pivarprjname = pivarprjname;
	}

	/**
	 * 流程发布位置取得
	 * @return 流程发布位置
	 */
	public String getPts() {
		return pts;
	}

	/**
	 * 流程发布位置设定
	 * @param pts 流程发布位置
	 */
	public void setPts(String pts) {
		this.pts = pts;
	}
	
	/**
	 * 流程记录ID取得
	 * @return流程记录ID
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
	 * 流程记录类型取得
	 * @return 流程记录类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 流程记录类型设定
	 * @param prtype 流程记录类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 流程记录子类型取得
	 * @return 流程记录子类型
	 */
	public String getPrsubtype() {
		return prsubtype;
	}

	/**
	 * 流程记录子类型设定
	 * @param prsubtype 流程记录子类型
	 */
	public void setPrsubtype(String prsubtype) {
		this.prsubtype = prsubtype;
	}

	/**
	 * 流程记录状态取得
	 * @return 流程记录状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 流程记录状态设定
	 * @param prstatus 流程记录状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * 流程记录状态子状态取得
	 * @return 流程记录状态子状态
	 */
	public String getPrsubstatus() {
		return prsubstatus;
	}

	/**
	 * 流程记录状态子状态设定
	 * @param prsubstatus 流程记录状态子状态
	 */
	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}

	/**
	 * 流程记录题目取得
	 * @return 流程记录题目
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * 流程记录题目设定
	 * @param prtitle 流程记录题目
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * 流程记录描述取得
	 * @return 流程记录描述
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * 流程记录描述设定
	 * @param prdesc 流程记录描述
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * 流程记录建立时间取得
	 * @return 流程记录建立时间
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * 流程记录建立时间设定
	 * @param propentime 流程记录建立时间
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * 流程记录关闭时间取得
	 * @return 流程记录关闭时间
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * 流程记录关闭时间设定
	 * @param prclosetime 流程记录关闭时间
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * 流程记录计划执行时间取得
	 * @return 流程记录计划执行时间
	 */
	public String getPrplantime() {
		return prplantime;
	}

	/**
	 * 流程记录计划执行时间设定
	 * @param prplantime 流程记录计划执行时间
	 */
	public void setPrplantime(String prplantime) {
		this.prplantime = prplantime;
	}

	/**
	 * 流程记录计划执行周期取得
	 * @return 流程记录计划执行周期
	 */
	public String getPrduration() {
		return prduration;
	}

	/**
	 * 流程记录计划执行周期设定
	 * @param prduration 流程记录计划执行周期
	 */
	public void setPrduration(String prduration) {
		this.prduration = prduration;
	}

	/**
	 * 流程记录紧急程度取得
	 * @return 流程记录紧急程度
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * 流程记录紧急程度设定
	 * @param prurgency 流程记录紧急程度
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	/**
	 * 流程记录影响程度取得
	 * @return 流程记录影响程度
	 */
	public String getPrimpact() {
		return primpact;
	}

	/**
	 * 流程记录影响程度设定
	 * @param primpact 流程记录影响程度
	 */
	public void setPrimpact(String primpact) {
		this.primpact = primpact;
	}

	/**
	 * 流程记录相关资产ID取得
	 * @return 流程记录相关资产ID
	 */
	public Integer getPrassetid() {
		return prassetid;
	}

	/**
	 * 流程记录相关资产ID设定
	 * @param prassetid 流程记录相关资产ID
	 */
	public void setPrassetid(Integer prassetid) {
		this.prassetid = prassetid;
	}

	/**
	 * 流程记录相关资产名称取得
	 * @return 流程记录相关资产名称
	 */
	public String getPrassetname() {
		return prassetname;
	}

	/**
	 * 流程记录相关资产名称设定
	 * @param prassetname 流程记录相关资产名称
	 */
	public void setPrassetname(String prassetname) {
		this.prassetname = prassetname;
	}

	/**
	 * 流程记录的相关业务取得
	 * @return 流程记录的相关业务
	 */
	public String getPrbusiness() {
		return prbusiness;
	}

	/**
	 * 流程记录的相关业务设定
	 * @param prbusiness 流程记录的相关业务
	 */
	public void setPrbusiness(String prbusiness) {
		this.prbusiness = prbusiness;
	}

	/**
	 * 流程记录执行计划取得
	 * @return 流程记录执行计划
	 */
	public String getPrimplplan() {
		return primplplan;
	}

	/**
	 * 流程记录执行计划设定
	 * @param primplplan 流程记录执行计划
	 */
	public void setPrimplplan(String primplplan) {
		this.primplplan = primplplan;
	}

	/**
	 * 流程记录恢复计划取得
	 * @return 流程记录恢复计划
	 */
	public String getPrbackplan() {
		return prbackplan;
	}

	/**
	 * 流程记录恢复计划设定
	 * @param prbackplan 流程记录恢复计划
	 */
	public void setPrbackplan(String prbackplan) {
		this.prbackplan = prbackplan;
	}

	/**
	 * 流程记录验证计划取得
	 * @return 流程记录验证计划
	 */
	public String getPrvfyplan() {
		return prvfyplan;
	}

	/**
	 * 流程记录验证计划设定
	 * @param prvfyplan 流程记录验证计划
	 */
	public void setPrvfyplan(String prvfyplan) {
		this.prvfyplan = prvfyplan;
	}
	
	/**
	 * 流程记录相关项目ID取得
	 * @return 流程记录相关项目ID
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 流程记录相关项目ID设定
	 * @param pid 流程记录相关项目ID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * 流程记录相关项目编号取得
	 * @return 流程记录相关项目编号
	 */
	public String getPcode() {
		return pcode;
	}

	/**
	 * 流程记录相关项目编号设定
	 * @param pcode 流程记录相关项目编号
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/**
	 * 流程记录相关项目名称取得
	 * @return 流程记录相关项目名称
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * 流程记录相关项目名称设定
	 * @param pname 流程记录相关项目名称
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	/**
	 * 流程记录发起者联系方式取得
	 * @return 流程记录发起者联系方式
	 */
	public String getPrinfo() {
		return prinfo;
	}

	/**
	 * 流程记录发起者联系方式设定
	 * @param prinfo 流程记录发起者联系方式
	 */
	public void setPrinfo(String prinfo) {
		this.prinfo = prinfo;
	}

	/**
	 * 流程记录相关流程ID取得
	 * @return 流程记录相关流程ID
	 */
	public Integer getPrcorid() {
		return prcorid;
	}

	/**
	 * 流程记录相关流程ID设定
	 * @param prcorid 流程记录相关流程ID
	 */
	public void setPrcorid(Integer prcorid) {
		this.prcorid = prcorid;
	}

	/**
	 * 流程记录相关流程类型取得
	 * @return 流程记录相关流程类型
	 */
	public String getPrcortype() {
		return prcortype;
	}

	/**
	 * 流程记录相关流程类型设定
	 * @param prcortype 流程记录相关流程类型
	 */
	public void setPrcortype(String prcortype) {
		this.prcortype = prcortype;
	}

	/**
	 * 流程记录相关流程名称取得
	 * @return 流程记录相关流程名称
	 */
	public String getPrcortitle() {
		return prcortitle;
	}

	/**
	 * 流程记录相关流程名称设定
	 * @param prcortitle 流程记录相关流程名称
	 */
	public void setPrcortitle(String prcortitle) {
		this.prcortitle = prcortitle;
	}

	/**
	 * 流程记录相关资产类型取得
	 * @return 流程记录相关资产类型
	 */
	public String getPrassetcategory() {
		return prassetcategory;
	}

	/**
	 * 流程记录相关资产类型设定
	 * @param prassetcategory 流程记录相关资产类型
	 */
	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	/**
	 * 流程记录发起者用户姓名取得
	 * @return 流程记录发起者用户姓名
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * 流程记录发起者用户姓名设定
	 * @param prusername 流程记录发起者用户姓名
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * 流程记录发起者角色名称取得
	 * @return 流程记录发起者角色名称
	 */
	public String getPrrolename() {
		return prrolename;
	}

	/**
	 * 流程记录发起者角色名称设定
	 * @param prrolename 流程记录发起者角色名称
	 */
	public void setPrrolename(String prrolename) {
		this.prrolename = prrolename;
	}

	/**
	 * 流程记录发起者用户ID取得
	 * @return 流程记录发起者用户ID
	 */
	public String getPruserid() {
		return pruserid;
	}

	/**
	 * 流程记录发起者用户ID设定
	 * @param pruserid 流程记录发起者用户ID
	 */
	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}

	/**
	 * 流程记录发起者角色ID取得
	 * @return 流程记录发起者角色ID
	 */
	public Integer getPrroleid() {
		return prroleid;
	}

	/**
	 * 流程记录发起者角色ID设定
	 * @param prroleid 流程记录发起者角色ID
	 */
	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}

	/**
	 * 流程记录流程类型ID取得
	 * @return 流程记录流程类型ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * 流程记录流程类型ID设定
	 * @param prpdid 流程记录流程类型ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * 流程记录流程类型名称取得
	 * @return 流程记录流程类型名称
	 */
	public String getPrpdname() {
		return prpdname;
	}

	/**
	 * 流程记录流程类型名称设定
	 * @param prpdname 流程记录流程类型名称
	 */
	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}

	/**
	 * 流程记录发起者所属机构层次码取得
	 * @return 流程记录发起者所属机构层次码
	 */
	public String getProrgid() {
		return prorgid;
	}

	/**
	 * 流流程记录发起者所属机构层次码设定
	 * @param prorgid 流程记录发起者所属机构层次码
	 */
	public void setProrgid(String prorgid) {
		this.prorgid = prorgid;
	}

	/**
	 * 流程记录发起者所属机构名称取得
	 * @return 流程记录发起者所属机构名称
	 */
	public String getProrgname() {
		return prorgname;
	}

	/**
	 * 流程记录发起者所属机构名称设定
	 * @param prorgname 流程记录发起者所属机构名称
	 */
	public void setProrgname(String prorgname) {
		this.prorgname = prorgname;
	}

	/**
	 * 流程记录工单号取得
	 * @return 流程记录工单号
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * 流程记录工单号设定
	 * @param prserialnum 流程记录工单号
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	/**
	 * 流程记录实际解决时间（从开始到结束）取得
	 * @return 流程记录实际解决时间
	 */
	public Integer getPrfacttime() {
		return prfacttime;
	}

	/**
	 * 流程记录实际解决时间（从开始到结束）设定
	 * @param piid 流程记录实际解决时间
	 */
	public void setPrfacttime(Integer prfacttime) {
		this.prfacttime = prfacttime;
	}

	/**
	 * 自定义流程临时跃迁条件取得
	 * @return 自定义流程临时跃迁条件
	 */
	public String getPrptdcond() {
		return prptdcond;
	}

	/**
	 * 自定义流程临时跃迁条件设定
	 * @param prptdcond 自定义流程临时跃迁条件
	 */
	public void setPrptdcond(String prptdcond) {
		this.prptdcond = prptdcond;
	}
	
	/**
	 * 记录时间戳取得
	 * @return 记录时间戳
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * 记录时间戳设定
	 * @param fingerPrint 记录时间戳
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	/**
	 * 快捷发起标识取得
	 * @return 快捷发起标识
	 */
	public String getIsServiceStart() {
		return isServiceStart;
	}

	/**
	 * 快捷发起标识设定
	 * @param isServiceStart 快捷发起标识
	 */
	public void setIsServiceStart(String isServiceStart) {
		this.isServiceStart = isServiceStart;
	}

	/**
	 * 关联流程ID取得
	 * @return 关联流程ID
	 */
	public Integer getParprid() {
		return parprid;
	}

	/**
	 * 关联流程ID设定
	 * @param parprid 关联流程ID
	 */
	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		this.isFirst = "1";
		ActionErrors errors = new ActionErrors();
		errors = super.validate(mapping, request);
		if (pivarvalue != null) {
			for (int i = 0; i < pivarvalue.length; i++) {
				if (!IGStringUtils.isValidBytes(pivarvalue[i], MAX_BYTE)) {
					errors.add(Globals.ERROR_KEY, new ActionMessage(
							"errors.invalid", pivarlabel[i]+"内容过长"));
				}
			}
		}
		request.getSession().setAttribute("IGPRR0101Form", this);
		return errors;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		fileMap = new HashMap<Integer, FormFile>();
		fileMapMuti = new HashMap<Integer, FormFile>();
		assign_orgsyscoding = null;
		this.entityMap = new HashMap<Integer, String>();
		this.fileMapTable = new Hashtable<Integer, FormFile>();
	}
	public String[] getAtt() {
		return att;
	}

	public void setAtt(String[] att) {
		this.att = att;
	}

	public Map<Integer, FormFile> getFileMapMuti() {
		return fileMapMuti;
	}

	public void setFileMapMuti(Map<Integer, FormFile> fileMap) {
		this.fileMapMuti = fileMap;
	}
	public FormFile getAttachFileMuti(int index) {
		return (FormFile) fileMapMuti.get(new Integer(index));
	}

	public void setAttachFileMuti(int index, FormFile file) {
		fileMapMuti.put(new Integer(index), file);
	}
	
	public String getDelFileMutiStr() {
		return delFileMutiStr;
	}
	public void setDelFileMutiStr(String delFileMutiStr) {
		this.delFileMutiStr = delFileMutiStr;
	}
	public String getStrpsidid() {
		return strpsidid;
	}

	public void setStrpsidid(String strpsidid) {
		this.strpsidid = strpsidid;
	}
	
	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getPrreport() {
		return null;
	}

	/**
	 * 流程变量模式取得
	 * 
	 * @return 流程变量模式
	 */
	public String[] getPidmode() {
		return pidmode;
	}

	/**
	 * 流程变量模式设定
	 * 
	 * @param pidmode 流程变量模式
	 */
	public void setPidmode(String[] pidmode) {
		this.pidmode = pidmode;
	}

	/**
	 * 流程私有权限范围取得
	 * 
	 * @return 流程私有权限范围
	 */
	public String[] getPrivatescope() {
		return privatescope;
	}

	/**
	 * 流程私有权限范围设定
	 * 
	 * @param privatescope 流程私有权限范围
	 */
	public void setPrivatescope(String[] privatescope) {
		this.privatescope = privatescope;
	}

	public String[] getPivarradio() {
		return pivarradio;
	}

	public void setPivarradio(String[] pivarradio) {
		this.pivarradio = pivarradio;
	}

	public String[] getPivarcheckbox() {
		return pivarcheckbox;
	}

	public void setPivarcheckbox(String[] pivarcheckbox) {
		this.pivarcheckbox = pivarcheckbox;
	}
	
	/**
	 * 参与者ID取得
	 * 
	 * @return 参与者ID
	 */
	public String[] getParticipants() {
		return participants;
	}

	/**
	 * 参与者ID设定
	 * 
	 * @param participants 参与者ID
	 */
	public void setParticipants(String[] participants) {
		this.participants = participants;
	}
	
	/**
	 * 主办部门取得
	 * 
	 * @return 主办部门
	 */
	public String[] getPpsupers() {
		return ppsupers;
	}

	/**
	 * 主办部门设定
	 * 
	 * @param ppsupers 主办部门
	 */
	public void setPpsupers(String[] ppsupers) {
		this.ppsupers = ppsupers;
	}

	public String prPriority;
	public String getPrPriority() {
		return prPriority;
	}
	public Integer prStrategyVersion;
	
	public Integer getPrStrategyVersion() {
		return prStrategyVersion;
	}
	public void setPrPriority(String prPriority) {
		this.prPriority = prPriority;
	}
	public void setPrStrategyVersion(Integer prStrategyVersion) {
		this.prStrategyVersion = prStrategyVersion;
	}
	/**
	 * 获取资产
	 * @return 获取资产
	 */
	public String getEntityId(int index) {
		return (String) entityMap.get(new Integer(index));
	}

	/**
	 * 设置资产
	 * @param index 资产数组索引
	 * @param file 资产
	 */
	public void setEntityId(int index, String entityId) {
		entityMap.put(new Integer(index), entityId);
	}

	/**
	 * 获取资产Map
	 * @return 资产Map
	 */
	public Map<Integer, String> getEntityMap() {
		return entityMap;
	}

	/**
	 * 流程模版ID取得
	 * 
	 * @return 流程模版ID
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * 流程模版ID设定
	 * 
	 * @param ptid 流程模版ID
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	/**
	 * 资产ID取得
	 * 
	 * @return 资产ID
	 */
	public Integer getEiid() {
		return eiid;
	}
	
	/**
	 * 资产ID设定
	 * 
	 * @param ptid 资产ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 扩展参数值取得
	 * 
	 * @return 扩展参数值
	 */
	public String getParameters() {
		return parameters;
	}
	
	/**
	 * 扩展参数值设定
	 * 
	 * @param parameters 扩展参数值
	 */
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	/**
	 * 表格列信息定义主键集合取得
	 * @return column_pidid 表格列信息定义主键集合
	 */
	public String[] getColumn_pidid() {
		return column_pidid;
	}

	/**
	 * 表格列信息定义主键集合设定
	 * @param column_pidid 表格列信息定义主键集合
	 */
	public void setColumn_pidid(String[] column_pidid) {
		this.column_pidid = column_pidid;
	}

	/**
	 * 表格列值集合取得
	 * @return column_value 表格列值集合
	 */
	public String[] getColumn_value() {
		return column_value;
	}

	/**
	 * 表格列值集合设定
	 * @param column_value 表格列值集合
	 */
	public void setColumn_value(String[] column_value) {
		this.column_value = column_value;
	}

	/**
	 * 表格列值行号集合取得
	 * @return column_rownumber 表格列值行号集合
	 */
	public String[] getColumn_rownumber() {
		return column_rownumber;
	}

	/**
	 * 表格列值行号集合设定
	 * @param column_rownumber 表格列值行号集合
	 */
	public void setColumn_rownumber(String[] column_rownumber) {
		this.column_rownumber = column_rownumber;
	}
	
	public void setAttachFileTable(int index,FormFile file){
		fileMapTable.put(new Integer(index), file);
	}
	
	public FormFile getAttachFileTable(int index){
		return fileMapTable.get(new Integer(index));
	}

	/**
	 * 表格类表单列附件取得
	 * @return fileMapTable 表格类表单列附件
	 */
	public Map<Integer, FormFile> getFileMapTable() {
		return fileMapTable;
	}

	/**
	 * 表格类表单列附件设定
	 * @param fileMapTable 表格类表单列附件
	 */
	public void setFileMapTable(Map<Integer, FormFile> fileMapTable) {
		this.fileMapTable = fileMapTable;
	}

	/**
	 * 表格类表单附件列标识取得
	 * @return addTableColumnFileStr 表格类表单附件列标识
	 */
	public String getAddTableColumnFileStr() {
		return addTableColumnFileStr;
	}

	/**
	 * 表格类表单附件列标识设定
	 * @param addTableColumnFileStr 表格类表单附件列标识
	 */
	public void setAddTableColumnFileStr(String addTableColumnFileStr) {
		this.addTableColumnFileStr = addTableColumnFileStr;
	}

	/**
	 *表单说明取得
	 */
	public String[] getPiddesc() {
		return piddesc;
	}

	/**
	 *表单说明设定
	 */
	public void setPiddesc(String[] strings) {
		this.piddesc = strings;
	}
	
	public void setEntityMap(Map<Integer, String> entityMap) {
		this.entityMap = entityMap;
	}

	/**
	 * 分派参与者按机构过滤取得
	 * @return 分派参与者按机构过滤
	 */
	public String getAssign_orgsyscoding() {
		return assign_orgsyscoding;
	}

	/**
	 * 分派参与者按机构过滤设定
	 * @param assign_orgsyscoding 分派参与者按机构过滤
	 */
	public void setAssign_orgsyscoding(String assign_orgsyscoding) {
		this.assign_orgsyscoding = assign_orgsyscoding;
	}

	/**
	 * 人员表单用户ID取得
	 * @return par_userid 人员表单用户ID
	 */
	public String[] getPar_userid() {
		return par_userid;
	}

	/**
	 * 人员表单用户ID设定
	 * @param par_userid 人员表单用户ID
	 */
	public void setPar_userid(String[] par_userid) {
		this.par_userid = par_userid;
	}

	/**
	 * 人员表单用户名称取得
	 * @return par_username 人员表单用户名称
	 */
	public String[] getPar_username() {
		return par_username;
	}

	/**
	 * 人员表单用户名称设定
	 * @param par_username 人员表单用户名称
	 */
	public void setPar_username(String[] par_username) {
		this.par_username = par_username;
	}

	/**
	 * 人员表单机构码取得
	 * @return par_orgid 人员表单机构码
	 */
	public String[] getPar_orgid() {
		return par_orgid;
	}

	/**
	 * 人员表单机构码设定
	 * @param par_orgid 人员表单机构码
	 */
	public void setPar_orgid(String[] par_orgid) {
		this.par_orgid = par_orgid;
	}

	/**
	 * 人员表单机构名称取得
	 * @return par_orgname 人员表单机构名称
	 */
	public String[] getPar_orgname() {
		return par_orgname;
	}

	/**
	 * 人员表单机构名称设定
	 * @param par_orgname 人员表单机构名称
	 */
	public void setPar_orgname(String[] par_orgname) {
		this.par_orgname = par_orgname;
	}

	/**
	 * 人员表单角色ID取得
	 * @return par_roleid 人员表单角色ID
	 */
	public Integer[] getPar_roleid() {
		return par_roleid;
	}

	/**
	 * 人员表单角色ID设定
	 * @param par_roleid 人员表单角色ID
	 */
	public void setPar_roleid(Integer[] par_roleid) {
		this.par_roleid = par_roleid;
	}

	/**
	 * 人员表单角色名称取得
	 * @return par_rolename 人员表单角色名称
	 */
	public String[] getPar_rolename() {
		return par_rolename;
	}

	/**
	 * 人员表单角色名称设定
	 * @param par_rolename 人员表单角色名称
	 */
	public void setPar_rolename(String[] par_rolename) {
		this.par_rolename = par_rolename;
	}

	/**
	 * 人员表单表单定义ID取得
	 * @return par_pidid 人员表单表单定义ID
	 */
	public String[] getPar_pidid() {
		return par_pidid;
	}

	/**
	 * 人员表单表单定义ID设定
	 * @param par_pidid 人员表单表单定义ID
	 */
	public void setPar_pidid(String[] par_pidid) {
		this.par_pidid = par_pidid;
	}

	public String[] getPar_phone() {
		return par_phone;
	}

	public void setPar_phone(String[] par_phone) {
		this.par_phone = par_phone;
	}

	public String getDelTableColumnFileStr() {
		return delTableColumnFileStr;
	}

	public void setDelTableColumnFileStr(String delTableColumnFileStr) {
		this.delTableColumnFileStr = delTableColumnFileStr;
	}

	public String getPieids() {
		return pieids;
	}

	public void setPieids(String pieids) {
		this.pieids = pieids;
	}

	/**
	 * 跳转取得
	 * @return jump 跳转
	 */
	public String getJump() {
		return jump;
	}

	/**
	 * 跳转设定
	 * @param jump 跳转
	 */
	public void setJump(String jump) {
		this.jump = jump;
	}

	/**
	 * @return the pjdtype
	 */
	public String getPjdtype() {
		return pjdtype;
	}

	/**
	 * @param pjdtype the pjdtype to set
	 */
	public void setPjdtype(String pjdtype) {
		this.pjdtype = pjdtype;
	}
	
	
	
}

