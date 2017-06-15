package com.deliverik.infogovernor.taglib;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.html.Constants;
import org.apache.struts.taglib.html.OptionsCollectionTag;
import org.apache.struts.taglib.html.SelectTag;
import org.apache.struts.util.IteratorAdapter;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * 
 */

@SuppressWarnings("serial")
public class OptionsCollectionExTag extends OptionsCollectionTag {

	/**  */
	protected String ccid;
	
	/**  */
	protected String isChild;
	
	/**  */
	protected String pccid;
	
	/**  */
	protected String pcid;
	
	/**  */
	protected String isMakeBlankRow; 
	
	/**  */
	protected String isCodeLabel;
	
	/**  */
	protected String type;
	/**  */
	protected String isCcidValue;
	
	/**
	 * LabelValueBean
	 * 
	 * @throws JspException if a JSP exception has occurred
	 */
	public int doStartTag() throws JspException {
        // Acquire the select tag we are associated with
		
        SelectTag selectTag =
            (SelectTag) pageContext.getAttribute(Constants.SELECT_KEY);

        if (selectTag == null) {
            JspException e =
                new JspException(messages.getMessage(
                        "optionsCollectionTag.select"));

            TagUtils.getInstance().saveException(pageContext, e);
            throw e;
        }

        // Acquire the collection containing our options
        CodeListUtils c =
        	(CodeListUtils)TagUtils.getInstance().lookup(pageContext, "codeListUtils", null);
        
        // isChild
        boolean child = Boolean.parseBoolean(StringUtils.defaultString(isChild, "FALSE"));
        // isMakeBlankRow
        boolean makeBlk = Boolean.parseBoolean(StringUtils.defaultString(isMakeBlankRow, "TRUE"));
        // isCodeLabel
        boolean cdLbl = Boolean.parseBoolean(StringUtils.defaultString(isCodeLabel, "TRUE"));
        // isCcidValue
        boolean ccidVal = Boolean.parseBoolean(StringUtils.defaultString(isCcidValue, "FALSE"));
        
        String ccidValue = "";
        
        if(ccidVal) {
        	ccidValue = ccid; 
        } else {
        	CodeDefine cd = CodeDefine.getCodeDefine(ccid);
        	ccidValue = cd.getCcid();
        }
        
        if (StringUtils.isNotEmpty(pccid)){
        	CodeDefine pcd = CodeDefine.getCodeDefine(pccid);
        	pccid = pcd.getCcid();
        }
        
        //
        List<LabelValueBean> tmp = null;
        if (child) {
        	if (StringUtils.isEmpty(pccid) || StringUtils.isEmpty(pcid)){
        		tmp = new ArrayList<LabelValueBean>();
        		if (makeBlk) {
        			tmp.add(new LabelValueBean("",""));
        		}
        	} else {
               	tmp = c.getCodeList(ccidValue, pccid, pcid, makeBlk, cdLbl,type);
        	}
        } else {
           	tmp = c.getCodeList(ccidValue, pccid, pcid, makeBlk, cdLbl,type);
        }
	
        
        //
        List<LabelValueBean> collection = null;
        
       	collection = tmp;
        
        if (collection == null) {
            JspException e =
                new JspException(messages.getMessage(
                        "optionsCollectionTag.collection"));

            TagUtils.getInstance().saveException(pageContext, e);
            throw e;
        }

        // Acquire an iterator over the options collection
        Iterator iter = getIterator(collection);

        StringBuffer sb = new StringBuffer();

        // Render the options
        while (iter.hasNext()) {
            Object bean = iter.next();
            Object beanLabel = null;
            Object beanValue = null;

            // Get the label for this option
            try {
                beanLabel = PropertyUtils.getProperty(bean, label);

                if (beanLabel == null) {
                    beanLabel = "";
                }
            } catch (IllegalAccessException e) {
                JspException jspe =
                    new JspException(messages.getMessage("getter.access",
                            label, bean));

                TagUtils.getInstance().saveException(pageContext, jspe);
                throw jspe;
            } catch (InvocationTargetException e) {
                Throwable t = e.getTargetException();
                JspException jspe =
                    new JspException(messages.getMessage("getter.result",
                            label, t.toString()));

                TagUtils.getInstance().saveException(pageContext, jspe);
                throw jspe;
            } catch (NoSuchMethodException e) {
                JspException jspe =
                    new JspException(messages.getMessage("getter.method",
                            label, bean));

                TagUtils.getInstance().saveException(pageContext, jspe);
                throw jspe;
            }

            // Get the value for this option
            try {
                beanValue = PropertyUtils.getProperty(bean, value);

                if (beanValue == null) {
                    beanValue = "";
                }
            } catch (IllegalAccessException e) {
                JspException jspe =
                    new JspException(messages.getMessage("getter.access",
                            value, bean));

                TagUtils.getInstance().saveException(pageContext, jspe);
                throw jspe;
            } catch (InvocationTargetException e) {
                Throwable t = e.getTargetException();
                JspException jspe =
                    new JspException(messages.getMessage("getter.result",
                            value, t.toString()));

                TagUtils.getInstance().saveException(pageContext, jspe);
                throw jspe;
            } catch (NoSuchMethodException e) {
                JspException jspe =
                    new JspException(messages.getMessage("getter.method",
                            value, bean));

                TagUtils.getInstance().saveException(pageContext, jspe);
                throw jspe;
            }

            String stringLabel = beanLabel.toString();
            String stringValue = beanValue.toString();

            // Render this option
            addOption(sb, stringLabel, stringValue,
                selectTag.isMatched(stringValue));
        }

        TagUtils.getInstance().write(pageContext, sb.toString());

        return SKIP_BODY;
	}

    /**
     * Return an iterator for the options collection.
     *
     * @param collection Collection to be iterated over
     * @throws JspException if an error occurs
     */
	protected Iterator getIterator(Object collection)
        throws JspException {
        if (collection.getClass().isArray()) {
            collection = Arrays.asList((Object[]) collection);
        }

        if (collection instanceof Collection) {
            return (((Collection) collection).iterator());
        } else if (collection instanceof Iterator) {
            return ((Iterator) collection);
        } else if (collection instanceof Map) {
            return (((Map) collection).entrySet().iterator());
        } else if (collection instanceof Enumeration) {
            return new IteratorAdapter((Enumeration) collection);
        } else {
            throw new JspException(messages.getMessage(
                    "optionsCollectionTag.iterator", collection.toString()));
        }
    }

    
    /**
     * Release all allocated resources.
     */
    public void release() {
        super.release();
        ccid = null;
        isChild = null;
        pccid = null;
        pcid = null;
        isMakeBlankRow = null;
        isCodeLabel = null;
        isCcidValue = null;
    }

	public void setCcid(String ccid) {
		this.ccid = ccid;
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

	public void setIsMakeBlankRow(String isMakeBlankRow) {
		this.isMakeBlankRow = isMakeBlankRow;
	}

	public void setIsCodeLabel(String isCodeLabel) {
		this.isCodeLabel = isCodeLabel;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setIsCcidValue(String isCcidValue) {
		this.isCcidValue = isCcidValue;
	}
	
}