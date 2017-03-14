package com.deliverik.infogovernor.taglib;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * 概述: 流程表单值转图片显示
 * 功能描述：将流程表单值转成图片显示
 * 创建记录：
 */
public class ProcessInfoValueLevelImgTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	/** 流程ID */
	protected String prid;
	
	/** 流程表单名称 */
	protected String pdname;
	
	public int doStartTag() throws JspException {
		
		
		String imghtml = "";
	    FlowSearchBL flowSearchBL = (FlowSearchBL) WebApplicationSupport.getBean("flowSearchBL");
	    try {
	    	
	    	CodeDetailBL codeDetailBL =  (CodeDetailBL) WebApplicationSupport.getBean("codeDetailBL");
	    	CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
	    	cond.setCcid(CodeDefine.getCodeDefine("PROCESSINFOTOIMG").getCcid());
	    	cond.setCvalue(pdname);
	    	List<CodeDetail> cdlist = codeDetailBL.searchCodeDetail(cond, 0);
	    	if(cdlist.size() > 0){
	    		String pidname = cdlist.get(0).getCdinfo();
	    		String out = flowSearchBL.searchPublicProcessInfo(Integer.valueOf(prid), pidname);
	    		imghtml = "<img align=\"middle\" src=\"images/" + out + ".gif\" alt=\"" + pidname + "\" border=\"0\" width=\"16\" height=\"16\"/>";
	    	}
        } catch (NumberFormatException e) {
            
        } catch (BLException e) {
            
        }
	    
		TagUtils.getInstance().write(pageContext, imghtml);
		return (EVAL_BODY_INCLUDE);
	}

	/**
	 * 流程ID取得
	 * @return prid 流程ID
	 */
	public String getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 * @param prid 流程ID
	 */
	public void setPrid(String prid) {
		this.prid = prid;
	}

	/**
	 * 流程表单名称取得
	 * @return pdname 流程表单名称
	 */
	public String getPdname() {
		return pdname;
	}

	/**
	 * 流程表单名称设定
	 * @param pdname 流程表单名称
	 */
	public void setPdname(String pdname) {
		this.pdname = pdname;
	}
}