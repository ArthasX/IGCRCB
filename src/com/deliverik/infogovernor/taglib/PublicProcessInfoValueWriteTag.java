package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.IGStringUtils;

public class PublicProcessInfoValueWriteTag extends TagSupport{

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
		TagUtils.getInstance().write(pageContext, getCurrentValue(out));
		return (EVAL_BODY_INCLUDE);
	}
	
	private String getCurrentValue(String v){
		String value = v;
		if(StringUtils.isNotEmpty(v)){
			if(v.indexOf("_tree_") >= 0){
				value = v.split("_tree_")[1];
			}
			if(v.contains("cv_cev_")){
				value = v.replace("cv_cev_", "");
			}
		}
		return IGStringUtils.filterXMLStr(value);
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