/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: ֪ͨ���Ի�����Ϣ��������ʵ��
  * ��������: ֪ͨ���Ի�����Ϣ��������ʵ��
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
public class IG334SearchCondImpl implements IG334SearchCond {

	/** ��������IDģ����ѯ */
	protected String pdid_like;

	/** ��������ID��ֵ��ѯ */
	private String pdid_eq;

	/** ���̱�ID(��ȫƥ��) */
	protected String pidid_eq;

	/** ���̱�ID(ģ��ƥ��) */
	protected String pidid_like;

	/**
	 * ��������IDģ����ѯȡ��
	 *
	 * @return pdid_like ��������IDģ����ѯ
	 */
	public String getPdid_like() {
		return pdid_like;
	}

	/**
	 * ��������IDģ����ѯ�趨
	 *
	 * @param pdid_like ��������IDģ����ѯ
	 */
	public void setPdid_like(String pdid_like) {
		this.pdid_like = pdid_like;
	}

	/**
	 * ��ȡ��������ID
	 */
	public String getPdid_eq() {
		return pdid_eq;
	}

	/**
	 * ���̱�ID(��ȫƥ��)�趨
	 * @param pidid_eq
	 */
	public void setPidid_eq(String pidid_eq) {
		this.pidid_eq = pidid_eq;
	}

	/**
	 * �趨��������ID��ֵ��ѯ
	 * @param pdid_eq
	 */
	public void setPdid_eq(String pdid_eq) {
		this.pdid_eq = pdid_eq;
	}

	/**
	 * ���̱�ID(��ȫƥ��)ȡ��
	 * @return pidid_eq ���̱�ID(��ȫƥ��)
	 */
	public String getPidid_eq() {
		return pidid_eq;
	}

	/**
	 * ���̱�ID(ģ��ƥ��)ȡ��
	 * @return pidid_like ���̱�ID(ģ��ƥ��)
	 */
	public String getPidid_like() {
		return pidid_like;
	}
	
}