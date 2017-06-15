/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.form;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
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
 * @Description: 流程处理Form
 * @Author  
 * @History 2010-9-13     新建 
 * 			2013-02-27	  修改	130225	流程支持分派机构相关修改
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR0102Form extends BaseForm implements IG500Info, WorkFlowParameterInfo {
	
	//====>130225Begin
	/** 状态模式 */
	protected String psdassign;
	
	/** 处理人所属机构 */
	protected String pporgid;
	
	/** 分派参与者按机构过滤 */
	protected String assign_orgsyscoding="";
	
	/**
	 * 处理人所属机构取得
	 *
	 * @return pporgid 处理人所属机构
	 */
	public String getPporgid() {
		return pporgid;
	}

	/**
	 * 处理人所属机构设定
	 *
	 * @param pporgid 处理人所属机构
	 */
	public void setPporgid(String pporgid) {
		this.pporgid = pporgid;
	}
	
	/**
	 * 状态模式取得
	 *
	 * @return psdassign 状态模式
	 */
	public String getPsdassign() {
		return psdassign;
	}

	/**
	 * 状态模式设定
	 *
	 * @param psdassign 状态模式
	 */
	public void setPsdassign(String psdassign) {
		this.psdassign = psdassign;
	}
	//====>130225End
	
	//==>联想阳光雨露Begin

	/** 资产按机构过滤查询用属性 */
	protected String eiorgcode;
	
	/**
	 * 资产按机构过滤查询用属性取得
	 *
	 * @return eiorgcode 资产按机构过滤查询用属性
	 */
	public String getEiorgcode() {
		return eiorgcode;
	}

	/**
	 * 资产按机构过滤查询用属性设定
	 *
	 * @param eiorgcode 资产按机构过滤查询用属性
	 */
	public void setEiorgcode(String eiorgcode) {
		this.eiorgcode = eiorgcode;
	}
	//==>联想阳光雨露End
	/** 扩展参数值 */
	protected String parameters;
	
	/** 流程ID */
	protected Integer prid;
	
	/** 是否报错 */
	protected Integer iserr;

	/** 日志类型 */
	protected String log_type;

	/** 流程定义ID */
	protected String pdid;
	
	/** 资产ID */
	protected Integer eiid;
	
	/** 角色ID */
	protected Integer roleid;
	
	/** 流程状态类型 */
	protected String psdcode;
	
	/** 流程状态ID */
	protected String psdid;
	
	/** 流程参与者ID */
	protected String ppdid;
	
	/** 日志信息 */
	protected String rlcomment;
	
	/** 流程类型 */
	protected String pts;
	
	/** 节点类型 */
	protected String nodetype;
	
	/** 动作标识 如0010 */
	protected String action;
	
	/** 是否发起 0否，1是*/
	protected String isInit;
	
	/** 是否第一次进入页面*/
	protected String isFirst;
	
	/** 附件 */
	protected Map<Integer, FormFile> fileMap = null;
	
	/**流程变量参数值*/
	protected String[] pivarvalue;
	
	/**流程变量参数标识*/
	protected String[] pivarname;
	
	/**流程变量参数名称*/
	protected String[] pivarlabel;
	
	/**流程变量参数类型*/
	protected String[] pivartype;
	
	/**流程变量权限*/
	protected String[] pidaccess;
	
	/**流程变量参数ID*/
	protected String[] piid;
	
	protected String[] pidid;
	
	protected String[] pivarassetname;
	protected String[] pivarprname;
	protected String[] pivarprjname;
	
	/** 流程变量单选 */
	protected String[] pivarradio;
	
	/** 流程变量多选 */
	protected String[] pivarcheckbox;
	
	/** 流程变量树 */
	protected String[] pivartreename;
	
	/** 流程变量参数值最大字节数 */
	private static final int MAX_BYTE = 3000;
	
	/** 流程类型名称 */
	protected String processName;
	
	/**文本域附件绑定*/
	protected Map<Integer, FormFile> fileMapMuti = null;
	
	/** 表格类表单列附件 */
	protected Map<Integer, FormFile> fileMapTable = null;
	/**文本域附件绑定map中的对应文本域名称及顺序*/
	protected String[] att=new String[]{};
	/**文本域附件绑定删除*/
	protected String delFileMutiStr;
	
	//------------Ig500--------------
	protected String pporgnamesS;
	protected String ppusernamesS;
	
	protected String ppuseridsS;
	protected String pporgidsS;
	
	protected String rolename;
	protected String prtype;
	protected String prsubtype;
	protected String prstatus;
	protected String prsubstatus;
	protected String prtitle;
	protected String prdesc;
	protected String propentime;
	protected String prclosetime;
	protected String prplantime;
	protected String prduration;
	protected String prurgency;
	protected String primpact;
	protected Integer prassetid;
	protected String prassetname;
	protected String prbusiness;
	protected String primplplan;
	protected String prbackplan;
	protected String prvfyplan;
	protected Integer pid;
	protected String pcode;
	protected String pname;
	protected String prinfo;
	protected Integer prcorid;
	protected String prcortype;
	protected String prcortitle;
	protected String prassetcategory;
	protected String pruserid;
	protected String prusername;
	protected String prrolename;
	protected String prpdid;
	protected String prpdname;
	protected String prorgid;
	protected String prorgname;
	protected String prserialnum;
	protected Integer prfacttime;
	protected String prptdcond;
	protected String fingerPrint;
	/** 备注 */
	protected String[] pidcomment;
	
	/**参与者角色ID*/
	protected String[] roleids;

	/**参与者角色名称*/
	protected String[] rolenames;

	/**参与者用户ID*/
	protected String[] ppuserids;
	
	/**参与者用户名称*/
	protected String[] ppusernames;
	
	/**参与者机构ID*/
	protected String[] pporgids;
	
	/**参与者机构名称*/
	protected String[] pporgnames;
	
	/** 流程图XML */
	protected String flowXML;
	
	/** 可分派角色 */
	protected String ppsuper;
	
	/** 快捷发起 */
	protected String isServiceStart;
	
	/** 关联流程ID */
	protected Integer parprid;
	
	/** 授权用户ID */
	protected String paiid;
	
	/** 流程变量角色名称 */
	protected String[] pivarrolename;
	
	/** 临时角色负责人 */
	protected boolean tempRoleManager;
	
	/**页面跳转标识*/
	protected String jump;
	
	/** 执行人更新标识 */
	protected String people_code;
	
	/** 角色负责人标识 */
	protected String psdmode_code;

	/** 流程变量模式 */
	protected String[] pidmode;
	
	/** 流程私有权限范围 */
	protected String[] privatescope;
	
	/** 参与者ID（格式：roleid_userid）*/
	protected String[] participants;
	
	/** 参与者ID（格式：roleid_）*/
	protected String[] participants_;
	
	/** 主办部门 */
	protected String[] ppsupers;
	/** 资产 */
	protected Map<Integer, String> entityMap = null;
	
	/** 流程与资产关系ID字符串 */
	protected String pieids;
	
	/** 改派页面初始化选择人员标识 */
	protected String selected_participants;
	/** 抄阅人表主键 */
	protected String cruid;
	/** 抄阅人是否查看 */
	protected String islook;
	/** 页面是否显示菜单和按钮	yes：显示	no：不显示 */
	protected String pageFlag;
	/** 表格列信息定义主键集合 */
	protected String[] column_pidid;
	/** 表格列值集合 */
	protected String[] column_value;
	/** 表格列值行号集合 */
	protected String[] column_rownumber; 
	/** 表格类表单附件列标识 */
	protected String addTableColumnFileStr;
	
	/** 表格类表单列附件删除标识 */
	protected String delTableColumnFileStr;
	/** 历史流程ID */
	protected Integer historyPrid;
	
	/** 复制按钮显示标识 */
	protected String showCopy;
	
	/** 是否更新表格式表单值 */
	protected boolean updateTableValue = true;
	
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
	
	/** 表单说明 */
	protected String[] piddesc;
	
	/** 人员表单电话 */
	protected String [] par_phone;
	
	/** 处理参与者ID */
	protected String ppidstr;
	
	/**
	 * 角色负责人标识取得
	 *
	 * @return psdmode_code 角色负责人标识
	 */
	public String getPsdmode_code() {
		return psdmode_code;
	}

	/**
	 * 角色负责人标识设定
	 *
	 * @param psdmode_code 角色负责人标识
	 */
	public void setPsdmode_code(String psdmode_code) {
		this.psdmode_code = psdmode_code;
	}

	/**
	 * 执行人更新标识取得
	 *
	 * @return people_code 执行人更新标识
	 */
	public String getPeople_code() {
		return people_code;
	}

	/**
	 * 执行人更新标识设定
	 *
	 * @param people_code 执行人更新标识
	 */
	public void setPeople_code(String people_code) {
		this.people_code = people_code;
	}

	public String getJump() {
		return jump;
	}

	public void setJump(String jump) {
		this.jump = jump;
	}

	public String[] getPivarrolename() {
		return pivarrolename;
	}

	public void setPivarrolename(String[] pivarrolename) {
		this.pivarrolename = pivarrolename;
	}
	
	
	public String getPaiid() {
		return paiid;
	}

	public void setPaiid(String paiid) {
		this.paiid = paiid;
	}

	public String getIsServiceStart() {
		return isServiceStart;
	}

	public void setIsServiceStart(String isServiceStart) {
		this.isServiceStart = isServiceStart;
	}

	public Integer getParprid() {
		return parprid;
	}

	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}

	public String getLog_type() {
		return log_type;
	}

	public void setLog_type(String log_type) {
		this.log_type = log_type;
	}

	public Integer getIserr() {
		return iserr;
	}

	public void setIserr(Integer iserr) {
		this.iserr = iserr;
	}
	
	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
	
	
	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	public String getPrtype() {
		return prtype;
	}

	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	public String getPrsubtype() {
		return prsubtype;
	}

	public void setPrsubtype(String prsubtype) {
		this.prsubtype = prsubtype;
	}

	public String getPrstatus() {
		return prstatus;
	}

	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	public String getPrsubstatus() {
		return prsubstatus;
	}

	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}

	public String getPrtitle() {
		return prtitle;
	}

	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	public String getPrdesc() {
		return prdesc;
	}

	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	public String getPropentime() {
		return propentime;
	}

	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	public String getPrclosetime() {
		return prclosetime;
	}

	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	public String getPrplantime() {
		return prplantime;
	}

	public void setPrplantime(String prplantime) {
		this.prplantime = prplantime;
	}

	public String getPrduration() {
		return prduration;
	}

	public void setPrduration(String prduration) {
		this.prduration = prduration;
	}

	public String getPrurgency() {
		return prurgency;
	}

	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	public String getPrimpact() {
		return primpact;
	}

	public void setPrimpact(String primpact) {
		this.primpact = primpact;
	}

	public Integer getPrassetid() {
		return prassetid;
	}

	public void setPrassetid(Integer prassetid) {
		this.prassetid = prassetid;
	}

	public String getPrassetname() {
		return prassetname;
	}

	public void setPrassetname(String prassetname) {
		this.prassetname = prassetname;
	}

	public String getPrbusiness() {
		return prbusiness;
	}

	public void setPrbusiness(String prbusiness) {
		this.prbusiness = prbusiness;
	}

	public String getPrimplplan() {
		return primplplan;
	}

	public void setPrimplplan(String primplplan) {
		this.primplplan = primplplan;
	}

	public String getPrbackplan() {
		return prbackplan;
	}

	public void setPrbackplan(String prbackplan) {
		this.prbackplan = prbackplan;
	}

	public String getPrvfyplan() {
		return prvfyplan;
	}

	public void setPrvfyplan(String prvfyplan) {
		this.prvfyplan = prvfyplan;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPrinfo() {
		return prinfo;
	}

	public void setPrinfo(String prinfo) {
		this.prinfo = prinfo;
	}

	public Integer getPrcorid() {
		return prcorid;
	}

	public void setPrcorid(Integer prcorid) {
		this.prcorid = prcorid;
	}

	public String getPrcortype() {
		return prcortype;
	}

	public void setPrcortype(String prcortype) {
		this.prcortype = prcortype;
	}

	public String getPrcortitle() {
		return prcortitle;
	}

	public void setPrcortitle(String prcortitle) {
		this.prcortitle = prcortitle;
	}

	public String getPrassetcategory() {
		return prassetcategory;
	}

	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	public String getPruserid() {
		return pruserid;
	}

	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}

	public String getPrusername() {
		return prusername;
	}

	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}


	public String getPrrolename() {
		return prrolename;
	}

	public void setPrrolename(String prrolename) {
		this.prrolename = prrolename;
	}

	public String getPrpdid() {
		return prpdid;
	}

	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	public String getPrpdname() {
		return prpdname;
	}

	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}

	public String getProrgid() {
		return prorgid;
	}

	public void setProrgid(String prorgid) {
		this.prorgid = prorgid;
	}

	public String getProrgname() {
		return prorgname;
	}

	public void setProrgname(String prorgname) {
		this.prorgname = prorgname;
	}

	public String getPrserialnum() {
		return prserialnum;
	}

	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	public Integer getPrfacttime() {
		return prfacttime;
	}

	public void setPrfacttime(Integer prfacttime) {
		this.prfacttime = prfacttime;
	}

	public String getPrptdcond() {
		return prptdcond;
	}

	public void setPrptdcond(String prptdcond) {
		this.prptdcond = prptdcond;
	}

	public String[] getPidid() {
		return pidid;
	}

	public void setPidid(String[] pidid) {
		this.pidid = pidid;
	}

	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}

	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}

	public String[] getPivarvalue() {
		return pivarvalue;
	}

	public void setPivarvalue(String[] pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	public String[] getPivarname() {
		return pivarname;
	}

	public void setPivarname(String[] pivarname) {
		this.pivarname = pivarname;
	}

	public String[] getPivarlabel() {
		return pivarlabel;
	}

	public void setPivarlabel(String[] pivarlabel) {
		this.pivarlabel = pivarlabel;
	}

	public String[] getPivartype() {
		return pivartype;
	}

	public void setPivartype(String[] pivartype) {
		this.pivartype = pivartype;
	}

	public String[] getPiid() {
		return piid;
	}

	public void setPiid(String[] piid) {
		this.piid = piid;
	}

	public static int getMAX_BYTE() {
		return MAX_BYTE;
	}

	/**
	 * 流程参与者ID取得
	 * 
	 * @return 流程参与者ID
	 */
	public String getPpdid() {
		return ppdid;
	}

	/**
	 * 流程参与者ID设定
	 *
	 * @param ppdid 流程参与者ID
	 */
	public void setPpdid(String ppdid) {
		this.ppdid = ppdid;
	}

	/**
	 * 流程状态类型取得
	 * 
	 * @return 流程状态类型
	 */
	public String getPsdcode() {
		return psdcode;
	}

	/**
	 * 流程状态类型设定
	 *
	 * @param roleid 流程状态类型
	 */
	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
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
	 * 角色ID取得
	 * 
	 * @return 角色ID
	 */
	public Integer getRoleid() {
		if(roleid != null && roleid == 0){
			return null;
		}
		return roleid;
	}

	/**
	 * 角色ID设定
	 *
	 * @param roleid 角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
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
	 * 流程ID取得
	 * 
	 * @return 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 *
	 * @param prid 流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
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
	 * 是否发起取得
	 * @return 是否发起
	 */
	public String getIsInit() {
		return isInit;
	}

	/**
	 * 是否发起设定
	 * @param isInit 是否发起
	 */
	public void setIsInit(String isInit) {
		this.isInit = isInit;
	}
	
	public String getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		errors = super.validate(mapping, request);
		if (pivarvalue != null) {
			for (int i = 0; i < pivarvalue.length; i++) {
				if (!IGStringUtils.isValidBytes(pivarvalue[i], MAX_BYTE)) {
					errors.add(Globals.ERROR_KEY, new ActionMessage(
							"errors.invalid", pivarlabel[i]+"内容过长"));
					this.setIserr(1);
				}
			}
		}
		if(fileMap!=null){
			Set<Integer> keySet = fileMap.keySet();
			Iterator<Integer> keyite = keySet.iterator();
			while(keyite.hasNext()){
				Integer key = keyite.next();
				if(fileMap.get(key).getFileSize()>MAX_BYTE*20480){
//					errors.add(Globals.ERROR_KEY, new ActionMessage(
//							"errors.invalid", "附件大小不能超过5M!"));
					errors.add(Globals.ERROR_KEY, new ActionMessage(
							"IGCO10000.E006", "30"));
					this.setIserr(1);
				}
				if("exe".equals(fileMap.get(key).getFileName().split("[.]")[(fileMap.get(key).getFileName().split("[.]").length-1)]) ||
				   "bat".equals(fileMap.get(key).getFileName().split("[.]")[(fileMap.get(key).getFileName().split("[.]").length-1)]) ||
				   "EXE".equals(fileMap.get(key).getFileName().split("[.]")[(fileMap.get(key).getFileName().split("[.]").length-1)]) ||
				   "BAT".equals(fileMap.get(key).getFileName().split("[.]")[(fileMap.get(key).getFileName().split("[.]").length-1)])){
					errors.add(Globals.ERROR_KEY, new ActionMessage(
							"errors.invalid", "附件类型不能为exe文件或bat文件!"));
					this.setIserr(1);
				}
			}
		}
		if(fileMapMuti!=null){
			Set<Integer> keySet = fileMapMuti.keySet();
			Iterator<Integer> keyite = keySet.iterator();
			
			while(keyite.hasNext()){
				Integer key = keyite.next();
			    if (fileMapMuti.get(key) != null) {
			        if(fileMapMuti.get(key).getFileSize()>MAX_BYTE*20480){
//			            errors.add(Globals.ERROR_KEY, new ActionMessage(
//			                    "errors.invalid", "附件大小不能超过5M!"));
			        	errors.add(Globals.ERROR_KEY, new ActionMessage(
								"IGCO10000.E006", "30"));
			            this.setIserr(1);
			        }
			        if("exe".equals(fileMapMuti.get(key).getFileName().split("[.]")[(fileMapMuti.get(key).getFileName().split("[.]").length-1)]) ||
			                "bat".equals(fileMapMuti.get(key).getFileName().split("[.]")[(fileMapMuti.get(key).getFileName().split("[.]").length-1)]) ||
			                "EXE".equals(fileMapMuti.get(key).getFileName().split("[.]")[(fileMapMuti.get(key).getFileName().split("[.]").length-1)]) ||
			                "BAT".equals(fileMapMuti.get(key).getFileName().split("[.]")[(fileMapMuti.get(key).getFileName().split("[.]").length-1)])){
			            errors.add(Globals.ERROR_KEY, new ActionMessage(
			                    "errors.invalid", "附件类型不能为exe文件或bat文件!"));
			            this.setIserr(1);
			        }
			    }
			}
		}
		request.getSession().setAttribute("IGPRR0102Form", this);
		return errors;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		super.reset(mapping, request);
		if(!"assign".equals(isInit)) {
			fileMap = new HashMap<Integer, FormFile>();
			isInit = null;
//			pivarname = null;
//			pivarlabel = null;
//			pivartype = null;
//			pidaccess = null;
			piid = null;
			pidid = null;
//			rlcomment = null;
			people_code = null;
			psdmode_code = null;
		}
		this.assign_orgsyscoding = null;
		this.roleids = null;
		this.rolenames = null;
		this.ppuserids = null;
		this.ppusernames = null;
		this.pporgids = null;
		this.pporgnames = null;
		this.participants = null;
		this.participants_ = null;
		if(this.iserr==null){
			this.iserr=0;
		}
		fileMapMuti = new HashMap<Integer, FormFile>();
		this.entityMap = new HashMap<Integer, String>();
		this.fileMapTable = new HashMap<Integer, FormFile>();
	}

	public String[] getPivarassetname() {
		return pivarassetname;
	}

	public void setPivarassetname(String[] pivarassetname) {
		this.pivarassetname = pivarassetname;
	}

	public String[] getPivarprname() {
		return pivarprname;
	}

	public void setPivarprname(String[] pivarprname) {
		this.pivarprname = pivarprname;
	}

	public String[] getPivarprjname() {
		return pivarprjname;
	}

	public void setPivarprjname(String[] pivarprjname) {
		this.pivarprjname = pivarprjname;
	}

	/**
	 * 获取参与者机构ID
	 * @return 参与者机构ID
	 */
	public String[] getPporgids() {
		return pporgids;
	}
	
	/**
	 * 设置参与者机构ID
	 * @param pporgids 参与者机构ID
	 */
	public void setPporgids(String[] pporgids) {
		this.pporgids = pporgids;
	}
	
	/**
	 * 获取参与者机构名称
	 * @return 参与者机构名称
	 */
	public String[] getPporgnames() {
		return pporgnames;
	}
	
	/**
	 * 设置参与者机构名称
	 * @param pporgnames 参与者机构名称
	 */
	public void setPporgnames(String[] pporgnames) {
		this.pporgnames = pporgnames;
	}
	
	/**
	 * 获取参与者角色ID
	 * @return 参与者角色ID
	 */
	public String[] getRoleids() {
		return roleids;
	}

	/**
	 * 设置参与者角色ID
	 * @param roleids 参与者角色ID
	 */
	public void setRoleids(String[] roleids) {
		this.roleids = roleids;
	}

	/**
	 * 获取参与者角色名称
	 * @return 参与者角色名称
	 */
	public String[] getRolenames() {
		return rolenames;
	}

	/**
	 * 设置参与者角色名称
	 * @param rolenames 参与者角色名称
	 */
	public void setRolenames(String[] rolenames) {
		this.rolenames = rolenames;
	}

	/**
	 * 获取参与者用户ID
	 * @return 参与者用户ID
	 */
	public String[] getPpuserids() {
		return ppuserids;
	}

	/**
	 * 设置参与者用户ID
	 * @param ppuserids 参与者用户ID
	 */
	public void setPpuserids(String[] ppuserids) {
		this.ppuserids = ppuserids;
	}

	/**
	 * 获取参与者用户名称
	 * @return 参与者用户名称
	 */
	public String[] getPpusernames() {
		return ppusernames;
	}

	/**
	 * 设置参与者用户名称
	 * @param ppusernames 参与者用户名称
	 */
	public void setPpusernames(String[] ppusernames) {
		this.ppusernames = ppusernames;
	}

	public String getPts() {
		return pts;
	}

	public void setPts(String pts) {
		this.pts = pts;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * 流程图XML取得
	 * @return 流程图XML
	 */
	public String getFlowXML() {
		return flowXML;
	}

	/**
	 * 流程图XML设定
	 * @param flowXML 流程图XML
	 */
	public void setFlowXML(String flowXML) {
		this.flowXML = flowXML;
	}

	public String getNodetype() {
		return nodetype;
	}

	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
	}

	public String getPporgnamesS() {
		return pporgnamesS;
	}

	public void setPporgnamesS(String pporgnamesS) {
		this.pporgnamesS = pporgnamesS;
	}

	public String getPpusernamesS() {
		return ppusernamesS;
	}

	public void setPpusernamesS(String ppusernamesS) {
		this.ppusernamesS = ppusernamesS;
	}

	public String getPpuseridsS() {
		return ppuseridsS;
	}

	public void setPpuseridsS(String ppuseridsS) {
		this.ppuseridsS = ppuseridsS;
	}

	public String getPporgidsS() {
		return pporgidsS;
	}

	public void setPporgidsS(String pporgidsS) {
		this.pporgidsS = pporgidsS;
	}

	/**
	 * 可分派角色取得
	 * @return 可分派角色
	 */
	public String getPpsuper() {
		return ppsuper;
	}

	/**
	 * 可分派角色设定
	 * @param ppsuper可分派角色
	 */
	public void setPpsuper(String ppsuper) {
		this.ppsuper = ppsuper;
	}
	
	/**
	 * 临时角色负责人取得
	 * @return 临时角色负责人
	 */
	public boolean isTempRoleManager() {
		return tempRoleManager;
	}

	/**
	 * 临时角色负责人设定
	 * @param tempRoleManager临时角色负责人
	 */
	public void setTempRoleManager(boolean tempRoleManager) {
		this.tempRoleManager = tempRoleManager;
	}
	public Map<Integer, FormFile> getFileMapMuti() {
		return fileMapMuti;
	}

	public void setFileMapMuti(Map<Integer, FormFile> fileMapMuti) {
		this.fileMapMuti = fileMapMuti;
	}

	public String[] getAtt() {
		return att;
	}

	public void setAtt(String[] att) {
		this.att = att;
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

	public String[] getPivartreename() {
		return pivartreename;
	}

	public void setPivartreename(String[] pivartreename) {
		this.pivartreename = pivartreename;
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
	 * 流程与资产关系ID字符串取得
	 * @return 流程与资产关系ID字符串
	 */
	public String getPieids() {
		return pieids;
	}

	/**
	 * 流程与资产关系ID字符串设定
	 * @param pieids 流程与资产关系ID字符串
	 */
	public void setPieids(String pieids) {
		this.pieids = pieids;
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
	 * 改派页面初始化选择人员标识取得
	 * 
	 * @return 改派页面初始化选择人员标识
	 */
	public String getSelected_participants() {
		return selected_participants;
	}

	/**
	 * 改派页面初始化选择人员标识设定
	 * 
	 * @param selected_participants 改派页面初始化选择人员标识
	 */
	public void setSelected_participants(String selected_participants) {
		this.selected_participants = selected_participants;
	}

	/**
	 * 参与者ID取得
	 * 
	 * @return 参与者ID取得
	 */
	public String[] getParticipants_() {
		return participants_;
	}

	/**
	 * 参与者ID设定
	 * 
	 * @param participants_ 参与者ID
	 */
	public void setParticipants_(String[] participants_) {
		this.participants_ = participants_;
	}

	

	public String getCruid() {
		return cruid;
	}

	public void setCruid(String cruid) {
		this.cruid = cruid;
	}

	public String getIslook() {
		return islook;
	}

	public void setIslook(String islook) {
		this.islook = islook;
	}
	/** 页面是否显示菜单和按钮	yes：显示	no：不显示 */
	public String getPageFlag() {
		return pageFlag;
	}
	/** 页面是否显示菜单和按钮	yes：显示	no：不显示 */
	public void setPageFlag(String pageFlag) {
		this.pageFlag = pageFlag;
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

	/**
	 * 表格类表单列附件取得
	 * @return fileMapTable 表格类表单列附件
	 */
	public Map<Integer, FormFile> getFileMapTable() {
		return fileMapTable;
	}
	
	public void setAttachFileTable(int index,FormFile file){
		fileMapTable.put(new Integer(index), file);
	}
	
	public FormFile getAttachFileTable(int index){
		return fileMapTable.get(new Integer(index));
	}

	/**
	 * 表格类表单列附件设定
	 * @param fileMapTable 表格类表单列附件
	 */
	public void setFileMapTable(Map<Integer, FormFile> fileMapTable) {
		this.fileMapTable = fileMapTable;
	}

	/**
	 * 资产设定
	 * @param entityMap 资产
	 */
	public void setEntityMap(Map<Integer, String> entityMap) {
		this.entityMap = entityMap;
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
	 * 表格类表单列附件删除标识取得
	 * @return delTableColumnFileStr 表格类表单列附件删除标识
	 */
	public String getDelTableColumnFileStr() {
		return delTableColumnFileStr;
	}

	/**
	 * 表格类表单列附件删除标识设定
	 * @param delTableColumnFileStr 表格类表单列附件删除标识
	 */
	public void setDelTableColumnFileStr(String delTableColumnFileStr) {
		this.delTableColumnFileStr = delTableColumnFileStr;
	}
	
	/**
	 * 历史流程ID取得
	 * @return historyPrid 历史流程ID
	 */
	public Integer getHistoryPrid() {
		return historyPrid;
	}

	/**
	 * 历史流程ID设定
	 * @param historyPrid 历史流程ID
	 */
	public void setHistoryPrid(Integer historyPrid) {
		this.historyPrid = historyPrid;
	}

	/**
	 * 复制按钮显示标识取得
	 * @return showCopy 复制按钮显示标识
	 */
	public String getShowCopy() {
		return showCopy;
	}

	/**
	 * 复制按钮显示标识设定
	 * @param showCopy 复制按钮显示标识
	 */
	public void setShowCopy(String showCopy) {
		this.showCopy = showCopy;
	}

	/**
	 * 是否更新表格式表单值取得
	 * @return updateTableValue 是否更新表格式表单值
	 */
	public boolean isUpdateTableValue() {
		return updateTableValue;
	}

	/**
	 * 是否更新表格式表单值设定
	 * @param updateTableValue 是否更新表格式表单值
	 */
	public void setUpdateTableValue(boolean updateTableValue) {
		this.updateTableValue = updateTableValue;
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

	/**
	 * maxByte取得
	 * @return maxByte maxByte
	 */
	public static int getMaxByte() {
		return MAX_BYTE;
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
	
	/**
	 * 处理参与者ID取得
	 * @return 处理参与者ID
	 */
	public String getPpidstr() {
		return ppidstr;
	}

	/**
	 * 处理参与者ID设定
	 * @param ppidstr 处理参与者ID
	 */
	public void setPpidstr(String ppidstr) {
		this.ppidstr = ppidstr;
	}
	
	/**
	 * 处理参与者ID取得
	 * @return 处理参与者ID
	 */
	public Integer getPpid() {
		if(StringUtils.isEmpty(getPpidstr())) {
			return null;
		} else {
			return new Integer(getPpidstr().split("_")[0]);
		}
	}

	public void clear() {
		this.setParameters(null);
		this.setIserr(null);
		this.setLog_type(null);
		this.setPdid(null);
		this.setEiid(null);
		this.setRoleid(null);
		this.setPsdcode(null);
		this.setPsdid(null);
		this.setPpdid(null);
		this.setRlcomment(null);
		this.setPts(null);
		this.setNodetype(null);
		this.setAction(null);
		this.setIsInit(null);
		this.setIsFirst(null);
		this.setFileMap(null);
		this.setPivarvalue(null);
		this.setPivarname(null);
		this.setPivarlabel(null);
		this.setPivartype(null);
		this.setPidaccess(null);
		this.setPiid(null);
		this.setPidid(null);
		this.setPivarassetname(null);
		this.setPivarprname(null);
		this.setPivarprjname(null);
		this.setPivarradio(null);
		this.setPivarcheckbox(null);
		this.setPivartreename(null);
		this.setProcessName(null);
		this.setFileMapMuti(null);
		this.setFileMapTable(null);
		this.setAtt(null);
		this.setDelFileMutiStr(null);
		this.setPporgnamesS(null);
		this.setPpusernamesS(null);
		this.setPpuseridsS(null);
		this.setPporgidsS(null);
		this.setRolename(null);
		this.setPrtype(null);
		this.setPrsubtype(null);
		this.setPrstatus(null);
		this.setPrsubstatus(null);
		this.setPrtitle(null);
		this.setPrdesc(null);
		this.setPropentime(null);
		this.setPrclosetime(null);
		this.setPrplantime(null);
		this.setPrduration(null);
		this.setPrurgency(null);
		this.setPrimpact(null);
		this.setPrassetid(null);
		this.setPrassetname(null);
		this.setPrbusiness(null);
		this.setPrimplplan(null);
		this.setPrbackplan(null);
		this.setPrvfyplan(null);
		this.setPid(null);
		this.setPcode(null);
		this.setPname(null);
		this.setPrinfo(null);
		this.setPrcorid(null);
		this.setPrcortype(null);
		this.setPrcortitle(null);
		this.setPrassetcategory(null);
		this.setPruserid(null);
		this.setPrusername(null);
		this.setPrroleid(null);
		this.setPpidstr(null);
		this.setPrrolename(null);
		this.setPrpdid(null);
		this.setPrpdname(null);
		this.setProrgid(null);
		this.setProrgname(null);
		this.setPrserialnum(null);
		this.setPrfacttime(null);
		this.setPrptdcond(null);
		this.setFingerPrint(null);
		this.setPidcomment(null);
		this.setPporgnames(null);
		this.setFlowXML(null);
		this.setPpsuper(null);
		this.setIsServiceStart(null);
		this.setParprid(null);
		this.setPaiid(null);
		this.setPivarrolename(null);
		this.setTempRoleManager(false);
		this.setPeople_code(null);
		this.setPsdmode_code(null);
		this.setPidmode(null);
		this.setPrivatescope(null);
		this.setParticipants(null);
		this.setParticipants_(null);
		this.setPpsupers(null);
		this.setEntityMap(null);
		this.setPieids(null);
		this.setSelected_participants(null);
		this.setCruid(null);
		this.setIslook(null);
		this.setPageFlag(null);
		this.setColumn_pidid(null);
		this.setColumn_value(null);
		this.setColumn_rownumber(null);
		this.setAddTableColumnFileStr(null);
		this.setDelTableColumnFileStr(null);
		this.setHistoryPrid(null);
		this.setShowCopy(null);
		this.setUpdateTableValue(true);
		this.setPar_userid(null);
		this.setPar_username(null);
		this.setPar_orgid(null);
		this.setPar_orgname(null);
		this.setPar_roleid(null);
		this.setPar_rolename(null);
		this.setPar_pidid(null);
		this.setPiddesc(null);
	}

	protected Integer prroleid;
	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}
	//当处理页的处理角色下拉列表提交时截取,否则取prroleid
	public Integer getPrroleid() {
		if(StringUtils.isEmpty(getPpidstr())) {
			return this.prroleid;
		} else {
			return new Integer(getPpidstr().split("_")[1]);
		}
	}
}
