package com.deliverik.infogovernor.taglib;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.bean.WriteTag;
import org.apache.struts.util.IteratorAdapter;

/**
 * 
 */

@SuppressWarnings("serial")
public class CollectionWriteTag extends WriteTag {

    protected String collectionName = null;

    protected String collectionProperty = null;

    /** block_id */
    protected String block_id = null;

    /** item_id */
    protected String item_id = null;

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public void setCollectionProperty(String collectionProperty) {
		this.collectionProperty = collectionProperty;
	}

	public int doStartTag() throws JspException {
        Object collection =
            TagUtils.getInstance().lookup(pageContext, collectionName, collectionProperty, null);

        if (collection == null) {
            JspException e =
                new JspException(messages.getMessage(
                        "optionsCollectionTag.collection"));

            TagUtils.getInstance().saveException(pageContext, e);
            throw e;
        }

        String code = (String) TagUtils.getInstance().lookup(pageContext, name, property, null);
        if (StringUtils.isEmpty(code)) {
            return SKIP_BODY;
        }

        boolean isFound = false;
        Iterator iter = getIterator(collection);

        while (iter.hasNext()) {
            Object bean = iter.next();
            Object beanLabel = null;
            Object beanValue = null;

            // Get the label for this option
            try {
                beanLabel = PropertyUtils.getProperty(bean, "label");

                if (beanLabel == null) {
                    beanLabel = "";
                }
            } catch (IllegalAccessException e) {
                JspException jspe =
                    new JspException(messages.getMessage("getter.access",
                            "label", bean));

                TagUtils.getInstance().saveException(pageContext, jspe);
                throw jspe;
            } catch (InvocationTargetException e) {
                Throwable t = e.getTargetException();
                JspException jspe =
                    new JspException(messages.getMessage("getter.result",
                            "label", t.toString()));

                TagUtils.getInstance().saveException(pageContext, jspe);
                throw jspe;
            } catch (NoSuchMethodException e) {
                JspException jspe =
                    new JspException(messages.getMessage("getter.method",
                            "label", bean));

                TagUtils.getInstance().saveException(pageContext, jspe);
                throw jspe;
            }

            // Get the value for this option
            try {
                beanValue = PropertyUtils.getProperty(bean, "value");

                if (beanValue == null) {
                    beanValue = "";
                }
            } catch (IllegalAccessException e) {
                JspException jspe =
                    new JspException(messages.getMessage("getter.access",
                            "value", bean));

                TagUtils.getInstance().saveException(pageContext, jspe);
                throw jspe;
            } catch (InvocationTargetException e) {
                Throwable t = e.getTargetException();
                JspException jspe =
                    new JspException(messages.getMessage("getter.result",
                            "value", t.toString()));

                TagUtils.getInstance().saveException(pageContext, jspe);
                throw jspe;
            } catch (NoSuchMethodException e) {
                JspException jspe =
                    new JspException(messages.getMessage("getter.method",
                            "value", bean));

                TagUtils.getInstance().saveException(pageContext, jspe);
                throw jspe;
            }

            String stringLabel = beanLabel.toString();
            String stringValue = beanValue.toString();

            if( code.equals(stringValue) ){
                TagUtils.getInstance().write(pageContext,
                        TagUtils.getInstance().filter(stringLabel));
                isFound = true;
                break;
            }

        }

        if( !isFound ){
            TagUtils.getInstance().write(pageContext,
                    TagUtils.getInstance().filter(code));
        }

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
        collectionName = null;
        collectionProperty = null;
        item_id = null;
        block_id = null;
    }
}