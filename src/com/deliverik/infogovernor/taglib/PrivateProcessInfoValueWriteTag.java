package com.deliverik.infogovernor.taglib;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.axis.utils.StringUtils;
import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.PrivateProcessFormInfo;
import com.deliverik.framework.platform.WebApplicationSupport;

public class PrivateProcessInfoValueWriteTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	protected String prid;
	
	protected String pidname;
	
	protected String roleid;
	
	protected String userid;
	
	public int doStartTag() throws JspException {
	    String out = "";
	    FlowSearchBL flowSearchBL = (FlowSearchBL) WebApplicationSupport.getBean("flowSearchBL");
	    try {
	        List<PrivateProcessFormInfo> privateProcessFormInfoList = flowSearchBL.searchPrivateProcessInfo(Integer.valueOf(prid), pidname);
	        if (StringUtils.isEmpty(roleid) && StringUtils.isEmpty(userid)) {
	            for(PrivateProcessFormInfo privateProcessFormInfo : privateProcessFormInfoList) {
	                out = out + "<br/>" + privateProcessFormInfo.getValue();
	            }
	        } else if (!StringUtils.isEmpty(roleid) && StringUtils.isEmpty(userid)) {
	            for(PrivateProcessFormInfo privateProcessFormInfo : privateProcessFormInfoList) {
                    if (roleid.equals(String.valueOf(privateProcessFormInfo.getRoleid()))) {
                        out = out + "<br/>" + privateProcessFormInfo.getValue();
                    }
                }
	        } else if (StringUtils.isEmpty(roleid) && !StringUtils.isEmpty(userid)) {
                for(PrivateProcessFormInfo privateProcessFormInfo : privateProcessFormInfoList) {
                    if (userid.equals(privateProcessFormInfo.getUserid())) {
                        out = out + "<br/>" + privateProcessFormInfo.getValue();
                    }
                }
	        } else {
	            for(PrivateProcessFormInfo privateProcessFormInfo : privateProcessFormInfoList) {
                    if (userid.equals(privateProcessFormInfo.getUserid()) && 
                            String.valueOf(privateProcessFormInfo.getRoleid()).equals(roleid)) {
                        out = out + "<br/>" + privateProcessFormInfo.getValue();
                    }
                }
	        }
	        out = out.replaceFirst("<br/>", "");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (BLException e) {
            e.printStackTrace();
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

    /**
     * @return the roleid
     */
    public String getRoleid() {
        return roleid;
    }

    /**
     * @param roleid the roleid to set
     */
    public void setRoleid(String roleid) {
        this.roleid = roleid;
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