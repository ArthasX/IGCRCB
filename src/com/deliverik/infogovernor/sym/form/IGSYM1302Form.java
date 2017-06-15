package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_测试_测试邮件
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */
public class IGSYM1302Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	private String mailto;
	private String mailcontent;
	private String mailtitle;
	private String mode;
	
	public String getMailto() {
		return mailto;
	}

	public void setMailto(String mailto) {
		this.mailto = mailto;
	}

	public String getMailtitle() {
		return mailtitle;
	}

	public void setMailtitle(String mailtitle) {
		this.mailtitle = mailtitle;
	}

	public String getMailcontent() {
		return mailcontent;
	}

	public void setMailcontent(String mailcontent) {
		this.mailcontent = mailcontent;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

}
