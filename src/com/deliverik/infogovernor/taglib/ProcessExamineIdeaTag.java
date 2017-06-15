/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.smr.bl.IGSMRCONSTANT;
import com.deliverik.infogovernor.smr.bl.task.ApproveSuggestionBL;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;
import com.deliverik.infogovernor.smr.model.condition.ApproveSuggestionSearchCondImpl;

/**
 * 概述:审批意见自定义标签 
 * 功能描述：审批意见自定义标签
 * 创建人：赵梓廷
 * 创建记录： 2013-08-02
 * 修改记录：
 */
@SuppressWarnings("serial")
public class ProcessExamineIdeaTag extends TagSupport {
	
	public final static String IMG_DEAD ="<img src='images/deldata.png' alt='查看审批意见' width='16' height='16' border='0' style='cursor: hand;' " ;	
	public final static String IMG_DEAD_WRITE_0 ="<img src='images/modify.png' alt='填写审批意见' width='16' height='16' border='0' style='cursor: hand;' " ;	
	public final static String IMG_DEAD_WRITE_1 ="<img src='images/deldata.png' alt='填写审批意见' width='16' height='16' border='0' style='cursor: hand;' " ;	
	// 流程id
	protected Integer prid; 
	
	// 表单id
	protected String pidid;
	
	/** 流程状态名称 */
	protected String psdname;
	
	/** 审批意见显示标识 */
	protected String needidea;
	
	/** 表格式表单标识 */
	protected String tableFlag;

	public int doStartTag() throws JspException {		
		String retHtml = "";
		try{
			retHtml = getRetHtml(prid,pidid,psdname,needidea,tableFlag);
		}catch (Exception e) {
			return (SKIP_BODY);
		}
		TagUtils.getInstance().write(pageContext, retHtml);
		return (EVAL_BODY_INCLUDE);
	}
	
	public static String getRetHtml(Integer prid,String pidid,String psdname,String needidea,String tableFlag){
		String retHtml = "";
		if(StringUtils.isEmpty(tableFlag)){
			tableFlag = "N";
		}
		if(IGSMRCONSTANT.HASH_APPROVE_IDEA_YES.equals(needidea)){
			if(IGSMRCONSTANT.PRSTATUSNAME_REPORT.equals(psdname)){
				if(isExist(prid,pidid)){
					retHtml =IMG_DEAD+"onclick='goIGSMR0202(\""+prid+"\",\""+pidid+"\",this,\"" + tableFlag + "\")'/>";
				}
			}else if(IGSMRCONSTANT.PRSTATUSNAME_FIRSTEXAMINE.equals(psdname) || IGSMRCONSTANT.PRSTATUSNAME_SECONDEXAMINE.equals(psdname)){
				if(isExist(prid,pidid)){
					retHtml =IMG_DEAD_WRITE_1+"onclick='goIGSMR0201(\""+prid+"\",\""+pidid+"\",this,\"" + tableFlag + "\")'/>";
				}else{
					retHtml =IMG_DEAD_WRITE_0+"onclick='goIGSMR0201(\""+prid+"\",\""+pidid+"\",this,\"" + tableFlag + "\")'/>";
				}
			}
		}
		return retHtml;
	}

	private static boolean isExist(Integer prid,String pidid){
		ApproveSuggestionBL approveSuggestionBL = (ApproveSuggestionBL) WebApplicationSupport.getBean("approveSuggestionBL");
		//实例化查询条件
		ApproveSuggestionSearchCondImpl cond = new ApproveSuggestionSearchCondImpl();
		cond.setPrid_eq(prid);
		cond.setPidid_eq(pidid);
	    cond.setStatus_eq(IGSMRCONSTANT.APPROVE_STATUS_YES);//有效
		//查询是否存在
		List<ApproveSuggestionInfo> list_as = approveSuggestionBL.searchApproveSuggestionInfo(cond);
		if(list_as.isEmpty()){
			return false;
		}
		return true;
	}

	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	public String getPidid() {
		return pidid;
	}

	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 流程状态名称取得
	 * @return psdname 流程状态名称
	 */
	public String getPsdname() {
		return psdname;
	}

	/**
	 * 流程状态名称设定
	 * @param psdname 流程状态名称
	 */
	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}

	/**
	 * 审批意见显示标识取得
	 * @return needidea 审批意见显示标识
	 */
	public String getNeedidea() {
		return needidea;
	}

	/**
	 * 审批意见显示标识设定
	 * @param needidea 审批意见显示标识
	 */
	public void setNeedidea(String needidea) {
		this.needidea = needidea;
	}

	/**
	 * 表格式表单标识取得
	 * @return tableFlag 表格式表单标识
	 */
	public String getTableFlag() {
		return tableFlag;
	}

	/**
	 * 表格式表单标识设定
	 * @param tableFlag 表格式表单标识
	 */
	public void setTableFlag(String tableFlag) {
		this.tableFlag = tableFlag;
	}

	/**
	 * 释放资源
	 */
	public void release() {
        super.release();
        this.pidid = null;
        this.prid = null;
        this.needidea = null;
        this.psdname = null;
        this.tableFlag = null;
    }
}
