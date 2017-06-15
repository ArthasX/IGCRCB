package com.deliverik.infogovernor.soc.vir.form;



import com.deliverik.framework.base.BaseForm;

/**
 * �豸��ѯ����FORM
 * 
 */
public class IGVIR0702Form extends BaseForm {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ҳ�������ʾ��־0-����,1-���
	 */
	protected String mode = "0";
	
	/** id */
	protected Integer vcid;
	
	/** ���� */
	protected String vcname;

	/** URL */
	protected String vcurl;

	/** �û��� */
	protected String vcusername;

	/** ���� */
	protected String vcpassword;
	
	
	/**
	 * ��ȡҳ�������ʾ��־
	 * @return String
	 */
	
	public String getMode() {
		return mode;
	}

	/**
	 * ����ҳ�������ʾ��־
	 * @param mode String
	 */
	
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * idȡ��
	 * @return vcid id
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * id�趨
	 * @param vcid id
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * ����ȡ��
	 * @return vcname ����
	 */
	public String getVcname() {
		return vcname;
	}

	/**
	 * �����趨
	 * @param vcname ����
	 */
	public void setVcname(String vcname) {
		this.vcname = vcname;
	}

	/**
	 * URLȡ��
	 * @return vcurl URL
	 */
	public String getVcurl() {
		return vcurl;
	}

	/**
	 * URL�趨
	 * @param vcurl URL
	 */
	public void setVcurl(String vcurl) {
		this.vcurl = vcurl;
	}

	/**
	 * �û���ȡ��
	 * @return vcusername �û���
	 */
	public String getVcusername() {
		return vcusername;
	}

	/**
	 * �û����趨
	 * @param vcusername �û���
	 */
	public void setVcusername(String vcusername) {
		this.vcusername = vcusername;
	}

	/**
	 * ����ȡ��
	 * @return vcpassword ����
	 */
	public String getVcpassword() {
		return vcpassword;
	}

	/**
	 * �����趨
	 * @param vcpassword ����
	 */
	public void setVcpassword(String vcpassword) {
		this.vcpassword = vcpassword;
	}
}
