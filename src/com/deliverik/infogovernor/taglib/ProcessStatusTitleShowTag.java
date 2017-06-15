package com.deliverik.infogovernor.taglib;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.common.ProcessStatusValueBean;

/**
 * 流程状态显示标签
 * @author Deliverik
 *
 */
public class ProcessStatusTitleShowTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	protected String prid;
	
	public int doStartTag() throws JspException {
		
		String out = "";
		
		WorkFlowOperationBL workFlowOperationBL = (WorkFlowOperationBL) WebApplicationSupport.getBean("workFlowOperationBL");
		
		try {
			List<String> lst_status = workFlowOperationBL.searchCurrentRecordStatus(Integer.parseInt(prid));
			IG500Info prInfo = workFlowOperationBL.searchProcessRecordByKey(Integer.parseInt(prid));

			for (String str_status : lst_status) {
				out += "，" + ProcessStatusValueBean.getConfigInfo(prInfo.getPrpdid(), str_status);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (BLException e) {
			e.printStackTrace();
		}
		
		if (StringUtils.isNotEmpty(out)) {
			out = out.substring(1);
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
}