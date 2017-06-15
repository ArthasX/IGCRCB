package com.deliverik.infogovernor.taglib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.html.ErrorsTag;

/**
 * 
 */

public class MessageTag extends ErrorsTag {

	private static final long serialVersionUID = -3208900806589612306L;

	private static final String[] KINDS = new String[] { "error", "warn", "info" };

	private static final int KIND_INDEX = 11;

	private Map<String, String> cacheMap = new HashMap<String, String>();

	public int doStartTag() throws JspException {

		ActionMessages messages = null;
		ActionMessages errors = null;

		errors = TagUtils.getInstance().getActionMessages(pageContext, Globals.ERROR_KEY);
		messages = TagUtils.getInstance().getActionMessages(pageContext, Globals.MESSAGE_KEY);
		if (((messages == null) || messages.isEmpty()) && ((errors == null) || errors.isEmpty())) {
			return (EVAL_BODY_INCLUDE);
		}

		String value = "";
		String key = "messages.header";
		if (TagUtils.getInstance().present(pageContext, bundle, locale, key))
			value = TagUtils.getInstance().message(pageContext, bundle, locale, key);
		cacheMap.put(key, value);

		value = "";
		key = "messages.footer";
		if (TagUtils.getInstance().present(pageContext, bundle, locale, key))
			value = TagUtils.getInstance().message(pageContext, bundle, locale, key);
		cacheMap.put(key, value);

		for (String kind : KINDS) {
			value = "";
			key = kind + ".prefix";
			if (TagUtils.getInstance().present(pageContext, bundle, locale, key))
				value = TagUtils.getInstance().message(pageContext, bundle, locale, key);
			cacheMap.put(key, value);

			key = kind + ".suffix";
			if (TagUtils.getInstance().present(pageContext, bundle, locale, key))
				value = TagUtils.getInstance().message(pageContext, bundle, locale, key);
			cacheMap.put(key, value);

		}
		StringBuffer results = new StringBuffer();

		results.append(cacheMap.get("messages.header"));

		printMessage(errors, results);

		printMessage(messages, results);

		results.append(cacheMap.get("messages.footer"));

		TagUtils.getInstance().write(pageContext, results.toString());

		return (EVAL_BODY_INCLUDE);
	}

	protected void printMessage(ActionMessages messages, StringBuffer results) throws JspException {
		Iterator reports = (property == null) ? messages.get() : messages.get(property);
		while (reports.hasNext()) {
			ActionMessage message = (ActionMessage) reports.next();

			String messageStr = null;
			if (message.isResource()) {
				messageStr = TagUtils.getInstance().message(pageContext, bundle, locale,
						message.getKey(), message.getValues());
			} else {
				messageStr = message.getKey();
			}

			if (messageStr != null) {
				String kind = "";
				if (message.getKey().length() > KIND_INDEX) {
					if (message.getKey().charAt(KIND_INDEX - 1) == 'E')
						kind = KINDS[0];
					else if (message.getKey().charAt(KIND_INDEX - 1) == 'W')
						kind = KINDS[1];
					else if (message.getKey().charAt(KIND_INDEX - 1) == 'I')
						kind = KINDS[2];
					else
						kind = KINDS[0];
				} else{
					kind = KINDS[0];
				}
				results.append(cacheMap.get(kind + ".prefix"));
				results.append(messageStr);
				results.append(cacheMap.get(kind + ".suffix"));
			}
		}

	}

	/**
	 * Release any acquired resources.
	 */
	public void release() {
		super.release();
	}
}