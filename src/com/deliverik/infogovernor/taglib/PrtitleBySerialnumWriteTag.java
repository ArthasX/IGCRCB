package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * 流程状态显示标签
 * @author Deliverik
 *
 */
/**	
 * 概述: 通过事件id显示事件名
 * 创建记录：yukexin    2014-8-26 上午11:11:22	
 * 修改记录：null
 */	
public class PrtitleBySerialnumWriteTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	protected String prid;
	
	public int doStartTag() throws JspException {
		
		String out = "";
		
		WorkFlowOperationBL workFlowOperationBL = (WorkFlowOperationBL) WebApplicationSupport.getBean("workFlowOperationBL");
		try {
			if(null != prid && !"".equals(prid)){
				IG500Info ig500Info = workFlowOperationBL.searchProcessRecordBySerialnum(prid);
				out = ig500Info.getPrtitle();
			}
			TagUtils.getInstance().write(pageContext, out);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (BLException e) {
			e.printStackTrace();
		}
		
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