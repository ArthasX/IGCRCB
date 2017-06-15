/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.soc.srv.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_服务台_工单管理_事件快捷发起FormBean
 * </p>
 * 
 * @author masai@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSRV0217Form extends BaseForm implements IG500Info {

	/** 服务工单编号 */
	protected Integer parprid;
	
	/** 事件题目 */
	protected String prtitle;

	/** 事件描述 */
	protected String prdesc;

	/** 事件紧急度 */
	protected String prurgency;

	/** 事件影响度 */
	protected String primpact;

	/** 事件资产ID */
	protected Integer prassetid;

	/** 事件编号 */
	protected Integer prid;

	/** 流程类型 */
	protected String prtype;

	/** 子流程类型 */
	protected String prsubtype;

	/** 事件状态 */
	protected String prstatus;

	/** 子流程状态 */
	protected String prsubstatus;

	/** 事件发起日期 */
	protected String propentime;

	/** 事件资产名称 */
	protected String prassetname;

	/** 事件恢复计划 */
	protected String prbackplan;

	/** 保留字段 */
	protected String prbusiness;

	/** 事件关闭时间 */
	protected String prclosetime;

	/** 事件计划结束时间 */
	protected String prduration;

	/** 事件执行计划 */
	protected String primplplan;

	/** 事件计划结束时间 */
	protected String prplantime;

	/** 事件验证计划 */
	protected String prvfyplan;

	/** 项目编号 */
	protected String pcode;

	/** 项目ID */
	protected Integer pid;

	/** 项目名称 */
	protected String pname;

	/** 事件发起者联系方式 */
	protected String prinfo;

	/** 相关事件ID */
	protected Integer prcorid;

	/** 相关事件类型 */
	protected String prcortype;

	/** 相关事件名称 */
	protected String prcortitle;

	/** 资产类型 */
	protected String prassetcategory;
	
	/** 发起者ID */
	protected String pruserid;
	
	/** 发起者姓名 */
	protected String prusername;
	
	/** 发起者角色ID */
	protected Integer prroleid;
	
	/** 发起者角色名称 */
	protected String prrolename;
	
	/** 子流程定义ID */
	protected String prpdid;
	
	/** 子流程定义名称 */
	protected String prpdname;

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
	
	/**流程变量参数ID*/
	protected String[] piid;
	
	/** 流程变量参数值最大字节数 */
	private static final int MAX_BYTE = 256;
	
	/**解码标志*/
	protected String flag;
	
	/**发起者机构id*/
	protected String prorgid;
	
	/**发起者机构名称*/
	protected String prorgname;
	
	/**报告人姓名*/
	protected String prt_username;
	
	/**报告人联系方式*/
	protected String prt_userconnect;
	
	/**报告人所属机构名称*/
	protected String prt_orgname;
	
	/**报告人所属机构名称*/
	protected String prt_orgsyscoding;
	
	/**报告人同发起者*/
	protected String prt_pruser;
	
	/**影响人姓名*/
	protected String aft_username;
	
	/**影响人联系方式*/
	protected String aft_userconnect;
	
	/**影响人所属机构名称*/
	protected String aft_orgname;
	
	/**影响人所属机构名称*/
	protected String aft_orgsyscoding;
	
	/**影响人同发起者*/
	protected String aft_pruser;
	
	/** 是否第一次进入页面*/
	protected String isFirst;

	protected String prserialnum;
	
	protected String[] pivarassetname;
	protected String[] pivarprname;
	protected String[] pivarprjname;
	
	public String getPrt_orgsyscoding() {
		return prt_orgsyscoding;
	}

	public void setPrt_orgsyscoding(String prt_orgsyscoding) {
		this.prt_orgsyscoding = prt_orgsyscoding;
	}

	public String getAft_orgsyscoding() {
		return aft_orgsyscoding;
	}

	public void setAft_orgsyscoding(String aft_orgsyscoding) {
		this.aft_orgsyscoding = aft_orgsyscoding;
	}

	public String getPrt_username() {
		return prt_username;
	}

	public void setPrt_username(String prt_username) {
		this.prt_username = prt_username;
	}

	public String getPrt_userconnect() {
		return prt_userconnect;
	}

	public void setPrt_userconnect(String prt_userconnect) {
		this.prt_userconnect = prt_userconnect;
	}

	public String getPrt_orgname() {
		return prt_orgname;
	}

	public void setPrt_orgname(String prt_orgname) {
		this.prt_orgname = prt_orgname;
	}

	public String getPrt_pruser() {
		return prt_pruser;
	}

	public void setPrt_pruser(String prt_pruser) {
		this.prt_pruser = prt_pruser;
	}

	public String getAft_username() {
		return aft_username;
	}

	public void setAft_username(String aft_username) {
		this.aft_username = aft_username;
	}

	public String getAft_userconnect() {
		return aft_userconnect;
	}

	public void setAft_userconnect(String aft_userconnect) {
		this.aft_userconnect = aft_userconnect;
	}

	public String getAft_orgname() {
		return aft_orgname;
	}

	public void setAft_orgname(String aft_orgname) {
		this.aft_orgname = aft_orgname;
	}

	public String getAft_pruser() {
		return aft_pruser;
	}

	public void setAft_pruser(String aft_pruser) {
		this.aft_pruser = aft_pruser;
	}

	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}

	public String getPrserialnum() {
		return prserialnum;
	}

	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}
	/**
	 * 获取资产ID
	 * @return 资产ID
	 */
	public Integer getPrassetid() {
		return prassetid;
	}

	/**
	 * 设置资产ID
	 * @param prassetid 资产ID
	 */
	public void setPrassetid(Integer prassetid) {
		if (prassetid != null && prassetid.intValue() == 0) {
			this.prassetid = null;
		} else {
			this.prassetid = prassetid;
		}
	}

	/**
	 * 获取流程编号
	 * @return 结束时间
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 设置流程编号
	 * @param prid 流程编号
	 */
	public void setPrid(Integer prid) {
		if (prid != null && prid.intValue() == 0) {
			this.prid = null;
		} else {
			this.prid = prid;
		}
	}

	/**
	 * 获取项目ID
	 * @return 项目ID
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 设置项目ID
	 * @param pid 项目ID
	 */
	public void setPid(Integer pid) {
		if (pid != null && pid.intValue() == 0) {
			this.pid = null;
		} else {
			this.pid = pid;
		}
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
	 * 获取相关流程编号
	 * @return 相关流程编号
	 */
	
	public Integer getPrcorid() {
		return prcorid;
	}

	/**
	 * 设置流程编号
	 * @param prcorid 流程编号
	 */
	public void setPrcorid(Integer prcorid) {
		if (prcorid != null && prcorid.intValue() == 0) {
			this.prcorid = null;
		} else {
			this.prcorid = prcorid;
		}
	}

	/**
	 * 获取发起者角色ID
	 * @return 发起者角色ID
	 */
	public Integer getPrroleid() {
		return prroleid;
	}

	/**
	 * 设置发起者角色ID
	 * @param prroleid 发起者角色ID
	 */
	public void setPrroleid(Integer prroleid) {
		if (prroleid != null && prroleid.intValue() == 0) {
			this.prroleid = null;
		} else {
			this.prroleid = prroleid;
		}
	}

	/**
	 * 获取事件题目
	 * @return 事件题目
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * 设置事件题目
	 * @param prtitle 事件题目
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * 获取事件描述
	 * @return 事件描述
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * 设置事件描述
	 * @param prdesc 事件描述
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * 获取事件紧急度
	 * @return 事件紧急度
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * 设置事件紧急度
	 * @param prurgency 事件紧急度
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	/**
	 * 获取事件影响度
	 * @return 事件影响度
	 */
	public String getPrimpact() {
		return primpact;
	}

	/**
	 * 设置事件影响度
	 * @param primpact 事件影响度
	 */
	public void setPrimpact(String primpact) {
		this.primpact = primpact;
	}

	/**
	 * 获取流程类型
	 * @return 流程类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 设置流程类型
	 * @param prtype 流程类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 获取子流程类型
	 * @return 子流程类型
	 */
	public String getPrsubtype() {
		return prsubtype;
	}

	/**
	 * 设置子流程类型
	 * @param prsubtype 子流程类型
	 */
	public void setPrsubtype(String prsubtype) {
		this.prsubtype = prsubtype;
	}

	/**
	 * 获取事件状态
	 * @return 事件状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 设置事件状态
	 * @param prstatus 事件状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * 获取子流程状态
	 * @return 子流程状态
	 */
	public String getPrsubstatus() {
		return prsubstatus;
	}

	/**
	 * 设置子流程状态
	 * @param prsubstatus 子流程状态
	 */
	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}

	/**
	 * 获取事件发起日期
	 * @return 事件发起日期
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * 设置事件发起日期
	 * @param propentime 事件发起日期
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * 获取事件资产名称
	 * @return 事件资产名称
	 */
	public String getPrassetname() {
		return prassetname;
	}

	/**
	 * 设置事件资产名称
	 * @param prassetname 事件资产名称
	 */
	public void setPrassetname(String prassetname) {
		this.prassetname = prassetname;
	}

	/**
	 * 获取事件恢复计划
	 * @return 事件恢复计划
	 */
	public String getPrbackplan() {
		return prbackplan;
	}

	/**
	 * 设置事件恢复计划
	 * @param prbackplan 事件恢复计划
	 */
	public void setPrbackplan(String prbackplan) {
		this.prbackplan = prbackplan;
	}

	/**
	 * 获取保留字段
	 * @return 保留字段
	 */
	public String getPrbusiness() {
		return prbusiness;
	}

	/**
	 * 设置保留字段
	 * @param prbusiness 保留字段
	 */
	public void setPrbusiness(String prbusiness) {
		this.prbusiness = prbusiness;
	}

	/**
	 * 获取事件关闭时间
	 * @return 事件关闭时间
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * 设置事件关闭时间
	 * @param prclosetime 事件关闭时间
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * 获取事件计划结束时间
	 * @return 事件计划结束时间
	 */
	public String getPrduration() {
		return prduration;
	}

	/**
	 * 设置事件计划结束时间
	 * @param prduration 事件计划结束时间
	 */
	public void setPrduration(String prduration) {
		this.prduration = prduration;
	}

	/**
	 * 获取事件执行计划
	 * @return 事件执行计划
	 */
	public String getPrimplplan() {
		return primplplan;
	}

	/**
	 * 设置事件执行计划
	 * @param primplplan 事件执行计划
	 */
	public void setPrimplplan(String primplplan) {
		this.primplplan = primplplan;
	}

	/**
	 * 获取事件计划结束时间
	 * @return 事件计划结束时间
	 */
	public String getPrplantime() {
		return prplantime;
	}

	/**
	 * 设置事件计划结束时间
	 * @param prplantime 事件计划结束时间
	 */
	public void setPrplantime(String prplantime) {
		this.prplantime = prplantime;
	}

	/**
	 * 获取事件验证计划
	 * @return 事件验证计划
	 */
	public String getPrvfyplan() {
		return prvfyplan;
	}

	/**
	 * 设置事件验证计划
	 * @param prvfyplan 事件验证计划
	 */
	public void setPrvfyplan(String prvfyplan) {
		this.prvfyplan = prvfyplan;
	}

	/**
	 * 获取项目编号
	 * @return 项目编号
	 */
	public String getPcode() {
		return pcode;
	}

	/**
	 * 设置项目编号
	 * @param pcode 项目编号
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/**
	 * 获取项目名称
	 * @return 项目名称
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * 设置项目名称
	 * @param pname 项目名称
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * 获取事件发起者联系方式
	 * @return 事件发起者联系方式
	 */
	public String getPrinfo() {
		return prinfo;
	}

	/**
	 * 设置事件发起者联系方式
	 * @param prinfo 事件发起者联系方式
	 */
	public void setPrinfo(String prinfo) {
		this.prinfo = prinfo;
	}

	/**
	 * 获取相关事件类型
	 * @return 相关事件类型
	 */
	public String getPrcortype() {
		return prcortype;
	}

	/**
	 * 设置相关事件类型
	 * @param prcortype 相关事件类型
	 */
	public void setPrcortype(String prcortype) {
		this.prcortype = prcortype;
	}

	/**
	 * 获取相关事件名称
	 * @return 相关事件名称
	 */
	public String getPrcortitle() {
		return prcortitle;
	}

	/**
	 * 设置相关事件名称
	 * @param prcortitle 相关事件名称
	 */
	public void setPrcortitle(String prcortitle) {
		this.prcortitle = prcortitle;
	}

	/**
	 * 获取资产类型
	 * @return 资产类型
	 */
	public String getPrassetcategory() {
		return prassetcategory;
	}

	/**
	 * 设置资产类型
	 * @param prassetcategory 资产类型
	 */
	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	/**
	 * 获取发起者ID
	 * @return 发起者ID
	 */
	public String getPruserid() {
		return pruserid;
	}

	/**
	 * 设置发起者ID
	 * @param pruserid 发起者ID
	 */
	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}

	/**
	 * 获取发起者姓名
	 * @return 发起者姓名
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * 设置发起者姓名
	 * @param prusername 发起者姓名
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * 获取发起者角色名称
	 * @return 发起者角色名称
	 */
	public String getPrrolename() {
		return prrolename;
	}

	/**
	 * 设置发起者角色名称
	 * @param prrolename 发起者角色名称
	 */
	public void setPrrolename(String prrolename) {
		this.prrolename = prrolename;
	}

	/**
	 * 获取子流程定义ID
	 * @return 子流程定义ID
	 */
	public String getPrpdid() {
		if(prpdid !=null){
			return null;
		}else{
			return prpdid;
		}
	}

	/**
	 * 设置子流程定义ID
	 * @param prpdid 子流程定义ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * 获取子流程定义名称
	 * @return 子流程定义名称
	 */
	public String getPrpdname() {
		return prpdname;
	}

	/**
	 * 设置子流程定义名称
	 * @param prpdname 子流程定义名称
	 */
	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}

	/**
	 * 获取流程变量参数值
	 * @return 流程变量参数值
	 */
	public String[] getPivarvalue() {
		return pivarvalue;
	}

	/**
	 * 设置流程变量参数值
	 * @param pivarvalue 流程变量参数值
	 */
	public void setPivarvalue(String[] pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	/**
	 * 获取流程变量参数标识
	 * @return 流程变量参数标识
	 */
	public String[] getPivarname() {
		return pivarname;
	}

	/**
	 * 设置流程变量参数标识
	 * @param pivarname 流程变量参数标识
	 */
	public void setPivarname(String[] pivarname) {
		this.pivarname = pivarname;
	}

	/**
	 * 获取流程变量参数名称
	 * @return 流程变量参数名称
	 */
	public String[] getPivarlabel() {
		return pivarlabel;
	}

	/**
	 * 设置流程变量参数名称
	 * @param pivarlabel 流程变量参数名称
	 */
	public void setPivarlabel(String[] pivarlabel) {
		this.pivarlabel = pivarlabel;
	}

	/**
	 * 获取流程变量参数类型
	 * @return 流程变量参数类型
	 */
	public String[] getPivartype() {
		return pivartype;
	}

	/**
	 * 设置流程变量参数类型
	 * @param pivartype 流程变量参数类型
	 */
	public void setPivartype(String[] pivartype) {
		this.pivartype = pivartype;
	}

	/**
	 * 获取流程变量参数ID
	 * @return 流程变量参数ID
	 */
	public String[] getPiid() {
		return piid;
	}

	/**
	 * 设置流程变量参数ID
	 * @param piid 流程变量参数ID
	 */
	public void setPiid(String[] piid) {
		this.piid = piid;
	}
	
	/**
	 * 获取解码标志
	 * @return 解码标志
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * 设置解码标志
	 * @param flag 解码标志
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	/**
	 * 获取发起者机构id
	 * @return 发起者机构id
	 */
	public String getProrgid() {
		return prorgid;
	}

	/**
	 * 设置发起者机构id
	 * @param prorgid 发起者机构id
	 */
	public void setProrgid(String prorgid) {
		this.prorgid = prorgid;
	}

	/**
	 * 获取发起者机构名称
	 * @return 发起者机构名称
	 */
	public String getProrgname() {
		return prorgname;
	}

	/**
	 * 设置发起者机构名称
	 * @param flag 发起者机构名称
	 */
	public void setProrgname(String prorgname) {
		this.prorgname = prorgname;
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
				}
			}
		}
		request.getSession().setAttribute("IGSVC0217Form", this);
		return errors;
	}

	public Integer getPrfacttime() {
		return null;
	}
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	@Override
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.fileMap = new HashMap<Integer, FormFile>();
	}

	public String getPrptdcond() {
		return null;
	}
	
	public String getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
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

	public Integer getParprid() {
		return parprid;
	}

	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}

	public String getGeneralname() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGeneralvalue() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPidgid() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Jsdoc)
	 * override
	 */
	public Integer getPrStrategyVersion() {
		//
		return null;
	}

	/* (non-Jsdoc)
	 * override
	 */
	public String getPrPriority() {
		//
		return null;
	}
	
}
