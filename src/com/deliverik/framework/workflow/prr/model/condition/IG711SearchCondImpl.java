/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
 * ���񹤵���־��ѯ����ʵ��
 */
public class IG711SearchCondImpl implements IG711SearchCond {
	
	/** ��Ȩ��ʼ����_�� */
	protected String pabegintime_f;
	
	/** ��Ȩ��ʼ����_�� */
	protected String pabegintime_t;
	
	/** ��Ȩ��ʶλ */
	protected String paflag;
	
	/** ��Ȩ��*/
	protected String paiid;
	
	/** ��Ȩ���� */
	protected String patype;
	
	/** ��¼�û���id */
	protected String loginUser;
	
	/** ��Ȩ��ʶλ */
	protected String nopaflag;
	
	
	/**
	 * ��¼�û���idȡ��
	 * @return ��¼�û���id
	 */
	public String getLoginUser() {
		return loginUser;
	}
	/**
	 * ��¼�û���id�趨
	 *
	 * @param loginUser ��¼�û���id
	 */
	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	
	/**
	 * ��Ȩ��ʶλȡ��
	 * @return ��Ȩ��ʶλ
	 */
	public String getPaflag() {
		return paflag;
	}

	/**
	 * ��Ȩ��ʶλ�趨
	 *
	 * @param paflag ��Ȩ��ʶλ
	 */
	public void setPaflag(String paflag) {
		this.paflag = paflag;
	}

	/**
	 * ��Ȩ��ʼ����_��ȡ��
	 * @return ��Ȩ��ʼ����_��
	 */
	public String getPabegintime_f() {
		return pabegintime_f;
	}

	/**
	 * ��Ȩ��ʼ����_���趨
	 *
	 * @param pabegintime_f ��Ȩ��ʼ����_��
	 */
	public void setPabegintime_f(String pabegintime_f) {
		this.pabegintime_f = pabegintime_f;
	}

	/**
	 * ��Ȩ��ʼ����_��ȡ��
	 * @return ��Ȩ��ʼ����_��
	 */
	public String getPabegintime_t() {
		return pabegintime_t;
	}

	/**
	 * ��Ȩ��ʼ����_���趨
	 *
	 * @param pabegintime_t ��Ȩ��ʼ����_��
	 */
	public void setPabegintime_t(String pabegintime_t) {
		this.pabegintime_t = pabegintime_t;
	}
	
	/**
	 * ��Ȩ��ȡ��
	 * @return ��Ȩ��
	 */
	public String getPaiid() {
		return paiid;
	}

	/**
	 * ��Ȩ���趨
	 *
	 * @param paiid ��Ȩ��
	 */
	public void setPaiid(String paiid) {
		this.paiid = paiid;
	}

	/**
	 * ��Ȩ����ȡ��
	 * 
	 * @return ��Ȩ����
	 */
	public String getPatype() {
		return patype;
	}

	/**
	 * ��Ȩ�����趨
	 *
	 * @param paflag ��Ȩ����
	 */
	public void setPatype(String patype) {
		this.patype = patype;
	}
	
	/**
	 * ��Ȩ��ʶλȡ��
	 * @return ��Ȩ��ʶλ
	 */
	public String getNopaflag() {
		return nopaflag;
	}
	
	/**
	 * ��Ȩ��ʶλ�趨
	 * @param nopaflag��Ȩ��ʶλ
	 */
	public void setNopaflag(String nopaflag) {
		this.nopaflag = nopaflag;
	}

}
