package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * 概述: 根据状态定义id显示状态中文名
 * 功能描述：根据状态定义id显示状态中文名
 * 创建记录：
 */
@SuppressWarnings("serial")
public class ProcessStatusNameByPSDIDTag extends TagSupport {

	/** 流程定义id */ 
	protected String psdid;
	
	public int doStartTag() throws JspException {
		String retHtml = "";
        IG333BL ig333BL = (IG333BL) WebApplicationSupport.getBean("ig333BL");	
        try {
            IG333Info info = ig333BL.searchIG333InfoByKey(psdid);
            retHtml = info.getPsdname();
        } catch (BLException e) {
            // TODO Auto-generated catch block
            retHtml = "";
        }
		TagUtils.getInstance().write(pageContext, retHtml);
		return (EVAL_BODY_INCLUDE);
	}

	/**
	 * 释放资源
	 */
	public void release() {
        super.release();
        psdid = null;
    }

    /** 
     * 流程定义id 取得
     * @return psdid 流程定义id 
     */
    public String getPsdid() {
        return psdid;
    }

    /** 
     * 流程定义id 设定
     * @param psdid 流程定义id 
     */
    public void setPsdid(String psdid) {
        this.psdid = psdid;
    }
	

}