/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;


/**
  * ����: �����߰�ť������Ϣ���������ʵ��
  * ��������: �����߰�ť������Ϣ���������ʵ��
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
public class IG132SearchCondImpl implements
		IG132SearchCond {

	/** ���� */
	protected String ppbdid;

	/** �����߶���ID */
	protected String ppdid;

	/** ��ť����ID */
	protected String pbdid;

	/** ��ť��ʾ���� */
	protected String ppbdname;

	/** ��ť��ʾ��Ϣ */
	protected String ppbddesc;

	/** �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0 */
	protected String ppbdauth;
	
	/** ���� */
	protected String ppbdid_like;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPpbdid() {
		return ppbdid;
	}

	/**
	 * �����趨
	 *
	 * @param ppbdid ����
	 */
	public void setPpbdid(String ppbdid) {
		this.ppbdid = ppbdid;
	}

	/**
	 * �����߶���IDȡ��
	 *
	 * @return �����߶���ID
	 */
	public String getPpdid() {
		return ppdid;
	}

	/**
	 * �����߶���ID�趨
	 *
	 * @param ppdid �����߶���ID
	 */
	public void setPpdid(String ppdid) {
		this.ppdid = ppdid;
	}

	/**
	 * ��ť����IDȡ��
	 *
	 * @return ��ť����ID
	 */
	public String getPbdid() {
		return pbdid;
	}

	/**
	 * ��ť����ID�趨
	 *
	 * @param pbdid ��ť����ID
	 */
	public void setPbdid(String pbdid) {
		this.pbdid = pbdid;
	}

	/**
	 * ��ť��ʾ����ȡ��
	 *
	 * @return ��ť��ʾ����
	 */
	public String getPpbdname() {
		return ppbdname;
	}

	/**
	 * ��ť��ʾ�����趨
	 *
	 * @param ppbdname ��ť��ʾ����
	 */
	public void setPpbdname(String ppbdname) {
		this.ppbdname = ppbdname;
	}

	/**
	 * ��ť��ʾ��Ϣȡ��
	 *
	 * @return ��ť��ʾ��Ϣ
	 */
	public String getPpbddesc() {
		return ppbddesc;
	}

	/**
	 * ��ť��ʾ��Ϣ�趨
	 *
	 * @param ppbddesc ��ť��ʾ��Ϣ
	 */
	public void setPpbddesc(String ppbddesc) {
		this.ppbddesc = ppbddesc;
	}

	/**
	 * �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0ȡ��
	 *
	 * @return �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0
	 */
	public String getPpbdauth() {
		return ppbdauth;
	}

	/**
	 * �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0�趨
	 *
	 * @param ppbdauth �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0
	 */
	public void setPpbdauth(String ppbdauth) {
		this.ppbdauth = ppbdauth;
	}

	/**
	 * �����趨
	 * 
	 * @return ����
	 */
	public String getPpbdid_like() {
		return ppbdid_like;
	}

	/**
	 * �����趨
	 * 
	 * @param ppbdid_like ����
	 */
	public void setPpbdid_like(String ppbdid_like) {
		this.ppbdid_like = ppbdid_like;
	}
	
}