package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * 
 */

@SuppressWarnings("serial")
public class CodeValueWriteTag extends TagSupport{

	/**  */
	protected String ccid;
	
	/**  */
	protected String cid;
	
	/**  */
	protected String isChild;
	
	/**  */
	protected String pccid;
	
	/**  */
	protected String pcid;
	
	/**  */
	protected String nullText;
	
	/**  */
	protected boolean isCodeFormat = false;
	
	protected boolean isCcidCode = false;
	
	/**
	 * 
	 * 
	 * @throws JspException if a JSP exception has occurred
	 */
	public int doStartTag() throws JspException {
		
		String out = "";
		
        // CodeListUtils
		CodeListUtils c =
        	(CodeListUtils)TagUtils.getInstance().lookup(pageContext, "codeListUtils", null);
		CodeDefine cd = null;
		String ccidCode = null;
		if(isCcidCode) {
			ccidCode = ccid;
		}else {
			cd = CodeDefine.getCodeDefine(ccid);
			if(cd!=null){
				ccidCode = cd.getCcid();
			} else {
				return (SKIP_BODY);
			}
		}

        if(StringUtils.isNotEmpty(ccidCode)){
        	
        	if (StringUtils.isNotEmpty(pccid)){
                CodeDefine pcd = CodeDefine.getCodeDefine(pccid);
            	pccid = pcd.getCcid();
            }
            

            if(nullText == null)
            	nullText="";
            
            // 
            String codeValue = "";

            codeValue = StringUtils.defaultString(
        			c.getCodeValue(ccidCode, pccid, pcid, cid), 
    				nullText);

            if((StringUtils.defaultString(codeValue).length() > 0 && StringUtils.isBlank(codeValue)))
            	codeValue = "'" + codeValue + "'";

            
            out = codeValue;
            
            //
            if(isCodeFormat)
            	out = cid + ":" + codeValue;
            if(StringUtils.defaultString(cid).length() < 1)
            	out = nullText;

    		//
    		TagUtils.getInstance().write(pageContext, out);

    		return (EVAL_BODY_INCLUDE);
        }else{
        	return (SKIP_BODY);
        }
        
        
	}
	
	/**
     * Release all allocated resources.
     */
    public void release() {
        super.release();
        ccid = null;
        cid = null;
        pccid = null;
        pcid = null;
        isChild = null;
        nullText = null;
        isCodeFormat = false;
    }
    

	public void setNullText(String nullText) {
	    this.nullText = nullText;
	}
	
	public void setIsCodeFormat(boolean isCodeFormat) {
	    this.isCodeFormat = isCodeFormat;
	}

	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public void setIsChild(String isChild) {
		this.isChild = isChild;
	}

	public void setPccid(String pccid) {
		this.pccid = pccid;
	}

	public void setPcid(String pcid) {
		this.pcid = pcid;
	}

	public void setCodeFormat(boolean isCodeFormat) {
		this.isCodeFormat = isCodeFormat;
	}

	public void setIsCcidCode(boolean isCcidCode) {
	    this.isCcidCode = isCcidCode;
	}
	
}