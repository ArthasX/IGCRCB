/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;


/**
  * ����: �����Ա��������ʵ��
  * ��������: �����Ա��������ʵ��
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
public class IG335SearchCondImpl implements
		IG335SearchCond {
	/** ״̬����ID */
	protected String psdid_eq;
	
	/** ״̬����IDLike */
	protected String psdid_like;

	/** ������ID */
	protected String pidid_eq;
	
	/** ������ID */
	protected String pidid_like;

	/** ��ֵ */
	protected String pivalue_eq;

	/**���̶���ID(��ȫƥ��)*/
	protected String pdid_eq;

	/**���̶���ID(ģ��ƥ��)*/
	protected String pdid_like;

	/**
	 * ״̬����IDȡ��
	 * @return psdid_eq ״̬����ID
	 */
	public String getPsdid_eq() {
		return psdid_eq;
	}

	/**
	 * ״̬����ID�趨
	 * @param psdid_eq ״̬����ID
	 */
	public void setPsdid_eq(String psdid_eq) {
		this.psdid_eq = psdid_eq;
	}

	/**
	 * ״̬����IDLikeȡ��
	 * @return psdid_like ״̬����IDLike
	 */
	public String getPsdid_like() {
		return psdid_like;
	}

	/**
	 * ״̬����IDLike�趨
	 * @param psdid_like ״̬����IDLike
	 */
	public void setPsdid_like(String psdid_like) {
		this.psdid_like = psdid_like;
	}

	/**
	 * ������IDȡ��
	 * @return pidid_eq ������ID
	 */
	public String getPidid_eq() {
		return pidid_eq;
	}

	/**
	 * ������ID�趨
	 * @param pidid_eq ������ID
	 */
	public void setPidid_eq(String pidid_eq) {
		this.pidid_eq = pidid_eq;
	}

	/** 
     * ������ID ȡ��
     * @return pidid_like ������ID 
     */
    public String getPidid_like() {
        return pidid_like;
    }

    /** 
     * ������ID �趨
     * @param pidid_like ������ID 
     */
    public void setPidid_like(String pidid_like) {
        this.pidid_like = pidid_like;
    }

    /**
	 * ��ֵȡ��
	 * @return pivalue_eq ��ֵ
	 */
	public String getPivalue_eq() {
		return pivalue_eq;
	}

	/**
	 * ��ֵ�趨
	 * @param pivalue_eq ��ֵ
	 */
	public void setPivalue_eq(String pivalue_eq) {
		this.pivalue_eq = pivalue_eq;
	}

	/**
	 * ���̶���ID(��ȫƥ��)ȡ��
	 * @return pdid_eq ���̶���ID(��ȫƥ��)
	 */
	public String getPdid_eq() {
		return pdid_eq;
	}
	/**
	 * ���̶���ID(��ȫƥ��)�趨
	 * @param pdid_eq
	 */
	public void setPdid_eq(String pdid_eq) {
		this.pdid_eq = pdid_eq;
	}
	
	/**
	 * ���̶���ID(ģ��ƥ��)ȡ��
	 * @return pdid_like ���̶���ID(ģ��ƥ��)
	 */
	public String getPdid_like() {
		return pdid_like;
	}
	/**
	 * ���̶���ID(ģ��ƥ��)�趨
	 * @param pdid_like
	 */
	public void setPdid_like(String pdid_like) {
		this.pdid_like = pdid_like;
	}

}