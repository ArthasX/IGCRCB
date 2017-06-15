package com.deliverik.infogovernor.sym.bl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.SendMailBL;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.adapter.CodeDefinition;
import com.deliverik.infogovernor.broker.CCProxy;
import com.deliverik.infogovernor.sym.dto.IGSYM13DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1301Form;
import com.deliverik.infogovernor.sym.form.IGSYM1302Form;

/**
 * 基础数据管理业务逻辑实现
 *
 */
public class IGSYM13BLImpl extends BaseBLImpl implements IGSYM13BL {

	static Log log = LogFactory.getLog(IGSYM13BLImpl.class);

	/** 邮件发送BL */
	protected SendMailBL sendMailBL;

	/** CodeListUtils */
	protected CodeListUtils codeListUtils;
	
	protected CCProxy ccProxy;
	
	public void setSendMailBL(SendMailBL sendMailBL) {
		this.sendMailBL = sendMailBL;
	}

	public void setCodeListUtils(CodeListUtils codeListUtils) {
		this.codeListUtils = codeListUtils;
	}

	public IGSYM13DTO sendMail(IGSYM13DTO dto) throws BLException {
		IGSYM1302Form form = dto.getIgsym1302Form();
		String mailTo = form.getMailto();
		String[] to = {mailTo};
		String content = form.getMailcontent();
		if(content == null || "".equals(content)){
			content = "邮箱测试发送成功";
		}
		String isSend = codeListUtils.getCodeValue(CodeDefinition.MAIL, "", "", CodeDefinition.MAIL_IS_SEND);
		if(!"1".equals(isSend)){
			dto.addMessage(new ActionMessage("IGSYM1302.E001", "邮件"));
			dto.setEnable(false);
			return dto;
		} else {
			dto.setEnable(true);
		}
		sendMailBL.sendMail(form.getMailtitle(), content, to);
		dto.addMessage(new ActionMessage("IGSYM1303.I001", "邮件"));
		return dto;
	}

	public IGSYM13DTO sendSMS(IGSYM13DTO dto) throws BLException {
		IGSYM1301Form form = dto.getIgsym1301Form();
		String smscontent = form.getSmscontent();
		if(null == smscontent || "".equals(smscontent)){
			smscontent = "短信测试发送成功";
		}
		String isSend = codeListUtils.getCodeValue(CodeDefinition.SMS, "", "", CodeDefinition.SMS_IS_SEND);
		if(!"1".equals(isSend)){
			dto.addMessage(new ActionMessage("IGSYM1302.E001", "短信"));
			dto.setEnable(false);
			return dto;
		} else {
			dto.setEnable(true);
		}
		ccProxy.sendSmsMessage(form.getSmsnumber(), smscontent);
		dto.addMessage(new ActionMessage("IGSYM1303.I001", "短信"));
		return dto;
	}

	public void setCcProxy(CCProxy ccProxy) {
		this.ccProxy = ccProxy;
	}
}
