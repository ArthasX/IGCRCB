package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;

public class ParticipateNumberOfJobsWriteTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	protected String userid;
	
	public int doStartTag() throws JspException {
	    String out = "";
	    IG337BL ig337BL = (IG337BL) WebApplicationSupport.getBean("ig337BL");
	    
	    try {
	        IG337SearchCondImpl cond = new IG337SearchCondImpl();
	        cond.setPpuserid(userid);
	        cond.setPpproctimeIsNull("Y");
	        out = String.valueOf(ig337BL.searchParticipateNumberOfJobs(cond));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
		TagUtils.getInstance().write(pageContext, out);
		return (EVAL_BODY_INCLUDE);
	}

    /**
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

}