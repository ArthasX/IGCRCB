package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;



/**
 * Ħ����¼������FORM
 * IGCIM0804Form ActionForm
 */
public class IGCIM0804Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	protected String j_username;
	protected String j_password;
	protected String url;
	//ҳ����ת��ʶ
	protected String goPage;
	/**
	 * j_usernameȡ��
	 *
	 * @return j_username j_username
	 */
	public String getJ_username() {
		return j_username;
	}
	/**
	 * j_passwordȡ��
	 *
	 * @return j_password j_password
	 */
	public String getJ_password() {
		return j_password;
	}
	/**
	 * j_username�趨
	 *
	 * @param j_username j_username
	 */
	public void setJ_username(String j_username) {
		this.j_username = j_username;
	}
	/**
	 * j_password�趨
	 *
	 * @param j_password j_password
	 */
	public void setJ_password(String j_password) {
		this.j_password = j_password;
	}
	/**
	 * urlȡ��
	 *
	 * @return url url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * url�趨
	 *
	 * @param url url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * ҳ����ת��ʶȡ��
	 * 
	 * @return ҳ����ת��ʶ
	 */
	public String getGoPage() {
		return goPage;
	}
	
	/**
	 * ҳ����ת��ʶ�趨
	 * 
	 * @param goPage ҳ����ת��ʶ
	 */
	public void setGoPage(String goPage) {
		this.goPage = goPage;
	}
	
}
