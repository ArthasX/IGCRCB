package com.deliverik.infogovernor.taglib;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.ConfigurationCodeDetailBL;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.bl.task.IG259BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;

/**
 * 
 */

@SuppressWarnings("unused")
public class searchig380WriteTag extends TagSupport{
	
	private static final long serialVersionUID = 1L;
	/**  */
	protected String pttype;
	
	/**
	 * 
	 * 
	 * @throws JspException if a JSP exception has occurred
	 */
	public int doStartTag() throws JspException {
		StringBuffer bf = new StringBuffer("");
		if(StringUtils.isNotEmpty(pttype)){
			 	IG259SearchCondImpl condIg259SearchCondImpl=new IG259SearchCondImpl();
				condIg259SearchCondImpl.setPttype(pttype);
				IG259BL ig259bl=(IG259BL)WebApplicationSupport.getBean("ig259BL");
				List<IG259Info> ig259Infos=	ig259bl.searchIG259Info(condIg259SearchCondImpl);
				 IG380SearchCondImpl condImpl = new IG380SearchCondImpl();
			        condImpl.setPtid(ig259Infos.get(0).getPtid());
			        condImpl.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
			        IG380BL ig380BL = (IG380BL) WebApplicationSupport.getBean("ig380BL");
			        List<IG380Info> ig380infoList = ig380BL.searchIG380Info(condImpl);
			        if (ig380infoList.size() > 0) {
			           for(IG380Info info: ig380infoList ){
			        	   bf.append("<option value=\""+info.getPdid()+"\">"+info.getPdname()+"</option>");
			           }
			        }
			 	TagUtils.getInstance().write(pageContext, bf.toString());
			return (EVAL_BODY_INCLUDE);
		}else{
			return (SKIP_BODY);
		}
		
	}

	public String getPttype() {
		return pttype;
	}

	public void setPttype(String pttype) {
		this.pttype = pttype;
	}
	
}