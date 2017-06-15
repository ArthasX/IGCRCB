package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.platform.WebApplicationSupport;

public class PublicProcessInfoValueWriteSubTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	protected String prid;
	
	protected String pidname;
	
	public int doStartTag() throws JspException {
	    String out = "";
	    FlowSearchBL flowSearchBL = (FlowSearchBL) WebApplicationSupport.getBean("flowSearchBL");
	    try {
	        out = flowSearchBL.searchPublicProcessInfo(Integer.valueOf(prid), pidname);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (BLException e) {
            e.printStackTrace();
        }
	    
	    if(pidname.equals("…Ë±∏±‡∫≈")){
	    	out = out.substring(out.indexOf("#")+1);
	    }
	    
		TagUtils.getInstance().write(pageContext, out);
		return (EVAL_BODY_INCLUDE);
	}

    /**
     * @return the prid
     */
    public String getPrid() {
        return prid;
    }

    /**
     * @param prid the prid to set
     */
    public void setPrid(String prid) {
        this.prid = prid;
    }

    /**
     * @return the pidname
     */
    public String getPidname() {
        return pidname;
    }

    /**
     * @param pidname the pidname to set
     */
    public void setPidname(String pidname) {
        this.pidname = pidname;
    }



}