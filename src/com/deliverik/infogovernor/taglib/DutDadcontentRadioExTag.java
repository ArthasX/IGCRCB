package com.deliverik.infogovernor.taglib;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.html.BaseHandlerTag;
import org.apache.struts.util.IteratorAdapter;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.utility.CodeListUtils;

/**
 * 
 */

@SuppressWarnings("serial")
public class DutDadcontentRadioExTag extends BaseHandlerTag {

	protected String ccid;
	
	protected String pccid;
	
	protected String pcid;
	
	protected String checkedvalue;
	
	protected String radioname;
	
	protected String editAble;
	
	protected String label = "label";
	
    protected String value = "value";
	
	/**
	 * LabelValueBean
	 * 
	 * @throws JspException if a JSP exception has occurred
	 */
	public int doStartTag() throws JspException {

        CodeListUtils c =(CodeListUtils)TagUtils.getInstance().lookup(pageContext, "codeListUtils", null);
        //传入的为值

        List<LabelValueBean> tmp = c.getCodeList(ccid, pccid, pcid, false, true);
	
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
            sb.append("<input type=\"radio\" name=\"").append(radioname).append("\"").append(" value=\"");
            sb.append(TagUtils.getInstance().filter(stringValue)).append("\"");
            //选中
            if(stringValue.equals(checkedvalue)){
            	sb.append(" checked=\"checked\"");
            }
            //选中
            if("disabled".equals(editAble)){
            	sb.append(" disabled=\"disabled\"");
            }
            sb.append(">").append(stringLabel);
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
        pccid = null;
        pcid = null;
        checkedvalue = null;
        radioname = null;
        editAble = null;
        label = "label";
        value = "value";
    }

	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	public void setPccid(String pccid) {
		this.pccid = pccid;
	}

	public void setPcid(String pcid) {
		this.pcid = pcid;
	}

	public void setCheckedvalue(String checkedvalue) {
		this.checkedvalue = checkedvalue;
	}

	public void setRadioname(String radioname) {
		this.radioname = radioname;
	}

	public void setEditAble(String editAble) {
		this.editAble = editAble;
	}
	
}