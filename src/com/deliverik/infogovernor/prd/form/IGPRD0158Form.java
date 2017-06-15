/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prd.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.entity.IG335TB;

/**
 * 概述: 流程通知策略设定Form
 * 功能描述: 流程通知策略设定Form
 * 创建记录: 2012/04/11
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGPRD0158Form extends BaseForm {
	
	protected static int pssize = 0;
	protected static int pisize = 0;
	protected static int processWholeTactic_listSize = 0;
	
	
	public IGPRD0158Form() {
		super();
	}

	/** 流程定义ID */
	protected String pdid;
	
	/** 表单定义ID */
	protected String pidid;
	
	/** 表单定义名称 */
	protected String pidname;
	
	/** 是否发短信 */
	protected String sms;
	
	/** 是否发邮件 */
	protected String email;
	
	/** 表单定义ID */
	protected String pidid_all[];
	
	/** 流程整体策略表单值 */
	protected String pivalue_all[];
	
	/** 天 */
	protected String notifyd_all[];

	/** 小时 */
	protected String notifyh_all[];

	/** 分 */
	protected String notifym_all[];

	/** 角色ID */
	protected String roleid_all[];

	/** 处理BL */
	protected String processbl_all[];
	
	/** 流程状态定义ID */
	protected String psdid_s[];
	
	/** 确认节点是否发送通知 */
	protected String psdconfirms_s[];
	
	/** 进状态是否通知 */
	protected String isnotify [];
	
	/** 流程定义ID */
	protected String pdid_i[];
	
	/** 状态定义ID */
	protected String psdid_i[];
	
	/** 表单定义ID */
	protected String pidid_i[];
	
	/** 表单值 */
	protected String pivalue[];

	/** 天 */
	protected String notifyd[];

	/** 小时 */
	protected String notifyh[];

	/** 分 */
	protected String notifym[];
	
	/** 上报_天 */
	protected String reportd[];
	
	/** 上报_小时 */
	protected String reporth[];
	
	/** 上报_分 */
	protected String reportm[];
	
	/** 角色名称 */
	protected String rolename[];

	/** 角色ID */
	protected String roleid[];
	
	/** 上报角色负责人 */
	protected String rolemanager[];

	/** 处理BL */
	protected String processbl[];
	
	/** 报告上级通知人ID */
	protected String notifierids[];
	
	/** 报告上级通知人名字 */
	protected String notifiernames[];
	
	/** 确认节点是否发送通知 */
	protected String psdconfirms[];
	
	public void initForm(int pssize, int pisize, int processWholeTactic_listSize){
		// 流程状态定义ID 
		psdid_s = new String[pssize];
		// 是否带确认动作
		psdconfirms_s = new String[pssize];
		// 进状态是否通知 
		isnotify = new String[pssize];
		// 表单定义ID
		pidid_all = new String[processWholeTactic_listSize];
		// 流程整体策略表单值
		pivalue_all = new String[processWholeTactic_listSize];
		// 流程整体策略-天
		notifyd_all = new String[processWholeTactic_listSize];
		// 流程整体策略-小时
		notifyh_all = new String[processWholeTactic_listSize];
		// 流程整体策略-分
		notifym_all = new String[processWholeTactic_listSize];
		// 流程整体策略-角色
		roleid_all = new String[processWholeTactic_listSize];
		// 流程整体策略-处理BL
		processbl_all = new String[processWholeTactic_listSize];
		// 流程定义ID 
		pdid_i = new String[pisize];
		// 状态定义ID 
		psdid_i = new String[pisize];
		// 表单定义ID 
		pidid_i = new String[pisize];
		// 表单值 
		pivalue = new String[pisize];
		// 天 
		notifyd = new String[pisize];
		// 小时 
		notifyh = new String[pisize];
		// 分 
		notifym = new String[pisize];
		// 上报_天 
		reportd = new String[pisize];
		// 上报_小时 
		reporth = new String[pisize];
		// 上报_分 
		reportm = new String[pisize];
		// 角色名称 
		rolename = new String[pisize];
		// 角色ID 
		roleid = new String[pisize];
		// 上报角色负责人 
		rolemanager = new String[pisize];
		// 处理BL
		processbl = new String[pisize];
		// 报告上级通知人ID 
		notifierids = new String[pisize];
		// 报告上级通知人名称
		notifiernames = new String[pisize];
		// 确认节点是否发送通知
		psdconfirms = new String[pisize];
	}
	

	/**
	 * pssize取得
	 * @return pssize pssize
	 */
	public int getPssize() {
		return pssize;
	}

	/**
	 * pssize设定
	 * @param pssize pssize
	 */
	public void setPssize(int pssize) {
	    IGPRD0158Form.pssize= pssize;
	}

	/** 
     * processWholeTactic_listSize 设定
     * @param processWholeTactic_listSize processWholeTactic_listSize 
     */
    public void setProcessWholeTactic_listSize(int processWholeTactic_listSize) {
        IGPRD0158Form.processWholeTactic_listSize = processWholeTactic_listSize;
    }


    /**
	 * pisize取得
	 * @return pisize pisize
	 */
	public int getPisize() {
		return pisize;
	}

	/**
	 * pisize设定
	 * @param pisize pisize
	 */
	public void setPisize(int pisize) {
	    IGPRD0158Form.pisize = pisize;
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
	 * 表单定义ID取得
	 * @return pidid 表单定义ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 表单定义ID设定
	 * @param pidid 表单定义ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 表单定义名称取得
	 * @return pidname 表单定义名称
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * 表单定义名称设定
	 * @param pidname 表单定义名称
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/** 
     * 表单定义ID 取得
     * @return pidid_all 表单定义ID 
     */
    public String[] getPidid_all() {
        return pidid_all;
    }


    /** 
     * 表单定义ID 设定
     * @param pidid_all 表单定义ID 
     */
    public void setPidid_all(String[] pidid_all) {
        this.pidid_all = pidid_all;
    }


    /** 
     * 流程整体策略表单值 取得
     * @return pivalue_all 流程整体策略表单值 
     */
    public String[] getPivalue_all() {
        return pivalue_all;
    }


    /** 
     * 流程整体策略表单值 设定
     * @param pivalue_all 流程整体策略表单值 
     */
    public void setPivalue_all(String[] pivalue_all) {
        this.pivalue_all = pivalue_all;
    }


    /** 
     * 天 取得
     * @return notifyd_all 天 
     */
    public String[] getNotifyd_all() {
        return notifyd_all;
    }


    /** 
     * 天 设定
     * @param notifyd_all 天 
     */
    public void setNotifyd_all(String[] notifyd_all) {
        this.notifyd_all = notifyd_all;
    }


    /** 
     * 小时 取得
     * @return notifyh_all 小时 
     */
    public String[] getNotifyh_all() {
        return notifyh_all;
    }


    /** 
     * 小时 设定
     * @param notifyh_all 小时 
     */
    public void setNotifyh_all(String[] notifyh_all) {
        this.notifyh_all = notifyh_all;
    }


    /** 
     * 分 取得
     * @return notifym_all 分 
     */
    public String[] getNotifym_all() {
        return notifym_all;
    }


    /** 
     * 分 设定
     * @param notifym_all 分 
     */
    public void setNotifym_all(String[] notifym_all) {
        this.notifym_all = notifym_all;
    }


    /** 
     * 角色ID 取得
     * @return roleid_all 角色ID 
     */
    public String[] getRoleid_all() {
        return roleid_all;
    }


    /** 
     * 角色ID 设定
     * @param roleid_all 角色ID 
     */
    public void setRoleid_all(String[] roleid_all) {
        this.roleid_all = roleid_all;
    }


    /** 
     * 处理BL 取得
     * @return processbl_all 处理BL 
     */
    public String[] getProcessbl_all() {
        return processbl_all;
    }


    /** 
     * 处理BL 设定
     * @param processbl_all 处理BL 
     */
    public void setProcessbl_all(String[] processbl_all) {
        this.processbl_all = processbl_all;
    }


    /**
	 * 流程状态定义ID取得
	 * @return psdid_s 流程状态定义ID
	 */
	public String[] getPsdid_s() {
		return psdid_s;
	}

	/**
	 * 流程状态定义ID设定
	 * @param psdid_s 流程状态定义ID
	 */
	public void setPsdid_s(String[] psdid_s) {
		this.psdid_s = psdid_s;
	}

	/**
	 * 确认节点是否发送通知取得
	 * @return psdconfirms_s 确认节点是否发送通知
	 */
	public String[] getPsdconfirms_s() {
		return psdconfirms_s;
	}

	/**
	 * 确认节点是否发送通知设定
	 * @param psdconfirms_s 确认节点是否发送通知
	 */
	public void setPsdconfirms_s(String[] psdconfirms_s) {
		this.psdconfirms_s = psdconfirms_s;
	}

	/**
	 * 状态定义ID取得
	 * @return psdid_i 状态定义ID
	 */
	public String[] getPsdid_i() {
		return psdid_i;
	}

	/**
	 * 状态定义ID设定
	 * @param psdid_i 状态定义ID
	 */
	public void setPsdid_i(String[] psdid_i) {
		
		this.psdid_i = psdid_i;
	}

	/**
	 * 流程定义ID取得
	 * @return pdid_i 流程定义ID
	 */
	public String[] getPdid_i() {
		return pdid_i;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid_i 流程定义ID
	 */
	public void setPdid_i(String[] pdid_i) {
		
		this.pdid_i = pdid_i;
	}

	/**
	 * 表单定义ID取得
	 * @return pidid_i 表单定义ID
	 */
	public String[] getPidid_i() {
		return pidid_i;
	}

	/**
	 * 表单定义ID设定
	 * @param pidid_i 表单定义ID
	 */
	public void setPidid_i(String pidid_i[]) {
		
		this.pidid_i = pidid_i;
	}

	/**
	 * 表单值取得
	 * @return pivalue 表单值
	 */
	public String[] getPivalue() {
		return pivalue;
	}

	/**
	 * 表单值设定
	 * @param pivalue 表单值
	 */
	public void setPivalue(String[] pivalue) {
		
		this.pivalue = pivalue;
	}

	/**
	 * 天取得
	 * @return notifyd 天
	 */
	public String[] getNotifyd() {
		return notifyd;
	}

	/**
	 * 天设定
	 * @param notifyd 天
	 */
	public void setNotifyd(String[] notifyd) {
		
		this.notifyd = notifyd;
	}

	/**
	 * 小时取得
	 * @return notifyh 小时
	 */
	public String[] getNotifyh() {
		return notifyh;
	}

	/**
	 * 小时设定
	 * @param notifyh 小时
	 */
	public void setNotifyh(String[] notifyh) {
		
		this.notifyh = notifyh;
	}

	/**
	 * 分取得
	 * @return notifym 分
	 */
	public String[] getNotifym() {
		return notifym;
	}

	/**
	 * 分设定
	 * @param notifym 分
	 */
	public void setNotifym(String[] notifym) {
		
		this.notifym = notifym;
	}

	/**
	 * 上报_天取得
	 * @return reportd 上报_天
	 */
	public String[] getReportd() {
		return reportd;
	}

	/**
	 * 上报_天设定
	 * @param reportd 上报_天
	 */
	public void setReportd(String[] reportd) {
		
		this.reportd = reportd;
	}

	/**
	 * 上报_小时取得
	 * @return reporth 上报_小时
	 */
	public String[] getReporth() {
		return reporth;
	}

	/**
	 * 上报_小时设定
	 * @param reporth 上报_小时
	 */
	public void setReporth(String[] reporth) {
		
		this.reporth = reporth;
	}

	/**
	 * 上报_分取得
	 * @return reportm 上报_分
	 */
	public String[] getReportm() {
		return reportm;
	}

	/**
	 * 上报_分设定
	 * @param reportm 上报_分
	 */
	public void setReportm(String[] reportm) {
		
		this.reportm = reportm;
	}

	/**
	 * 角色名称取得
	 * @return rolename 角色名称
	 */
	public String[] getRolename() {
		return rolename;
	}

	/**
	 * 角色名称设定
	 * @param rolename 角色名称
	 */
	public void setRolename(String[] rolename) {
		this.rolename = rolename;
	}

	/**
	 * 角色ID取得
	 * @return roleid 角色ID
	 */
	public String[] getRoleid() {
		return roleid;
	}

	/**
	 * 角色ID设定
	 * @param roleid 角色ID
	 */
	public void setRoleid(String[] roleid) {
		
		this.roleid = roleid;
	}

	/**
	 * 上报角色负责人取得
	 * @return rolemanager 上报角色负责人
	 */
	public String[] getRolemanager() {
		return rolemanager;
	}

	/**
	 * 上报角色负责人设定
	 * @param rolemanager 上报角色负责人
	 */
	public void setRolemanager(String[] rolemanager) {
		
		this.rolemanager = rolemanager;
	}

	/**
	 * 处理BL取得
	 * @return processbl 处理BL
	 */
	public String[] getProcessbl() {
		return processbl;
	}

	/**
	 * 处理BL设定
	 * @param processbl 处理BL
	 */
	public void setProcessbl(String[] processbl) {
		
		this.processbl = processbl;
	}


	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		if("EDIT".equals(mapping.getParameter()) || "SET".equals(mapping.getParameter())) {
			initForm(pssize, pisize, processWholeTactic_listSize);
		} else {
		}
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
	 * 是否发短信取得
	 * @return sms 是否发短信
	 */
	public String getSms() {
		return sms;
	}

	/**
	 * 是否发短信设定
	 * @param sms 是否发短信
	 */
	public void setSms(String sms) {
		this.sms = sms;
	}

	/**
	 * 是否发邮件取得
	 * @return email 是否发邮件
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 是否发邮件设定
	 * @param email 是否发邮件
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 进状态是否通知取得
	 * @return isnotify 进状态是否通知
	 */
	public String[] getIsnotify() {
		return isnotify;
	}

	/**
	 * 进状态是否通知设定
	 * @param isnotify 进状态是否通知
	 */
	public void setIsnotify(String isnotify[]) {
		
		this.isnotify = isnotify;
	}

	/**
	 * 报告上级通知人ID取得
	 * @return notifierids 报告上级通知人ID
	 */
	public String[] getNotifierids() {
		return notifierids;
	}

	/**
	 * 报告上级通知人ID设定
	 * @param notifierids 报告上级通知人ID
	 */
	public void setNotifierids(String[] notifierids) {
		this.notifierids = notifierids;
	}

	/**
	 * 报告上级通知人名字取得
	 * @return notifiernames 报告上级通知人名字
	 */
	public String[] getNotifiernames() {
		return notifiernames;
	}

	/**
	 * 报告上级通知人名字设定
	 * @param notifiernames 报告上级通知人名字
	 */
	public void setNotifiernames(String[] notifiernames) {
		this.notifiernames = notifiernames;
	}

	/**
	 * 确认节点是否发送通知取得
	 * @return psdconfirms 确认节点是否发送通知
	 */
	public String[] getPsdconfirms() {
		return psdconfirms;
	}

	/**
	 * 确认节点是否发送通知设定
	 * @param psdconfirms 确认节点是否发送通知
	 */
	public void setPsdconfirms(String[] psdconfirms) {
		this.psdconfirms = psdconfirms;
	}
}
