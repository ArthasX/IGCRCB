package com.deliverik.infogovernor.taglib;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;

/**
 * 
 */

@SuppressWarnings("unused")
public class ZcjcCodeValueWriteTag extends TagSupport{
	
	private static final long serialVersionUID = 1L;
	/**  */
	protected String ccid;
	
	/**
	 * 
	 * 
	 * @throws JspException if a JSP exception has occurred
	 */
	public int doStartTag() throws JspException {
		StringBuffer bf = new StringBuffer("");
		if(StringUtils.isNotEmpty(ccid)){
			SOC0151BL codeDetailBL=(SOC0151BL)WebApplicationSupport.getBean("soc0151BL");
//			ConfigurationCodeDetailBL codeDetailBL=(ConfigurationCodeDetailBL)WebApplicationSupport.getBean("configurationCodeDetailBL");
			 List<LabelValueBean> list = codeDetailBL.searchLabelValueBeanList(ccid);
			 	for(LabelValueBean bean:list){
			 		bf.append("<option value=\""+bean.getValue()+"\">"+bean.getValue()+"</option>");
			 	}
			 	TagUtils.getInstance().write(pageContext, bf.toString());
			return (EVAL_BODY_INCLUDE);
		}else{
			return (SKIP_BODY);
		}
		
	}
	public String getCcid() {
		return ccid;
	}

	public void setCcid(String ccid) {
		this.ccid = ccid;
	}
	
}