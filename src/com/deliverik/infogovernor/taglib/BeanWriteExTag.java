package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;

import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.bean.WriteTag;

/**
 * 
 */
@SuppressWarnings("serial")
public class BeanWriteExTag extends WriteTag {

    /** block_id */
    protected String block_id = null;

    /** item_id */
    protected String item_id = null;

    /**
     * Process the start tag.
     *
     * @throws JspException if a JSP exception has occurred
     */
    public int doStartTag() throws JspException {
        // Look up the requested bean (if necessary)
        if (ignore) {
            if (TagUtils.getInstance().lookup(pageContext, name, scope)
                == null) {
                return (SKIP_BODY); // Nothing to output
            }
        }

        // Look up the requested property value
        Object value =
            TagUtils.getInstance().lookup(pageContext, name, property, scope);

        if (value == null) {
            return (SKIP_BODY); // Nothing to output
        }

        // Convert value to the String with some formatting
        String output = formatValue(value);

        // Print this property value to our output writer, suitably filtered
        if (filter) {
            TagUtils.getInstance().write(pageContext,
                TagUtils.getInstance().filter(output));
        } else {
            TagUtils.getInstance().write(pageContext, output);
        }

        // Continue processing this page
        return (SKIP_BODY);
    }


	public void setBlock_id(String block_id) {
	    this.block_id = block_id;
	}


	public void setItem_id(String item_id) {
	    this.item_id = item_id;
	}

    /**
     * Release all allocated resources.
     */
    public void release() {
        super.release();
        item_id = null;
        block_id = null;
    }
}