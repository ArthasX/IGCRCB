package com.deliverik.framework.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;

/**
 * Base DTO class.
 *
 */
@SuppressWarnings("serial")
public class BaseDTO implements Serializable {

	/** ActionMessageList */
	protected List<ActionMessage> messageList;
	
	/** ActionForm */
	protected ActionForm form;

	/**
	 * 
	 */
	public BaseDTO() {
		super();
		this.messageList = new ArrayList<ActionMessage>();
	}

	/**
	 * 
	 * @return ActionMessageList
	 */
	public List<ActionMessage> getMessageList() {
	    return messageList;
	}

	/**
	 * 
	 * @param messageList ActionMessageList
	 */
	public void setMessageList(List<ActionMessage> messageList) {
	    this.messageList = messageList;
	}

	/**
	 * 
	 * @return ActionMessageList
	 */
	public void addMessage(ActionMessage message) {
		this.messageList.add(message);
	}

	/**
	 * ActionForm取得
	 * @return form ActionForm
	 */
	public ActionForm getForm() {
		return form;
	}

	/**
	 * ActionForm设定
	 * @param form ActionForm
	 */
	public void setForm(ActionForm form) {
		this.form = form;
	}

}


