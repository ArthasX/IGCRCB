package com.deliverik.infogovernor.taglib;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.platform.WebApplicationSupport;

/**
 * 流程逾期为未处理等级显示图片标签
 * @author Deliverik
 *
 */
public class ProcessOverdueLevelBgColorTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	protected String prid;
	
	public int doStartTag() throws JspException {
		
	    String imghtml = "";
	    FlowSearchBL flowSearchBL = (FlowSearchBL) WebApplicationSupport.getBean("flowSearchBL");
	    try {
	    	List<ProcessRecordInfo> prInfo = flowSearchBL.searchProcessInfo(Integer.parseInt(prid), null);
	    	if (!prInfo.isEmpty()) {
				if(prInfo.get(0).getPrPriority() != null && !"".equals(prInfo.get(0).getPrPriority())){
					imghtml = "#FFCCCC";
				}
			}
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (BLException e) {
            e.printStackTrace();
        }
		TagUtils.getInstance().write(pageContext, imghtml);
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
}