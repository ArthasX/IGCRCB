/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: �������Ա���������ʵ��
  * ��������: �������Ա���������ʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public class IG481SearchCondImpl implements
		IG481SearchCond {
	
	/** ������id */
	protected String pgdid;

	/** ����ʽ */
	protected String createType;
	/**��һ���̶���ID*/
	protected String pdid;
	/**��һ���̶���IDģ����ѯ*/
	protected String pdid_like;
	/**�������̶���ID����*/
	protected String[] pdids_in;
	
	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getPgdid() {
		return pgdid;
	}

	/**
	 * ������id�趨
	 *
	 * @param pgdid ������id
	 */
	public void setPgdid(String pgdid) {
		this.pgdid = pgdid;
	}

	/**
	 * ����ʽȡ��
	 *
	 * @return ����ʽ
	 */
	public String getCreateType() {
		return createType;
	}

	/**
	 * ����ʽ�趨
	 *
	 * @param createType ����ʽ
	 */
	public void setCreateType(String createType) {
		this.createType = createType;
	}

	/**
	 * pdid   ȡ��
	 * @return pdid pdid
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * pdid   �趨
	 * @param pdid pdid
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * pdids_in   ȡ��
	 * @return pdids_in pdids_in
	 */
	public String[] getPdids_in() {
		return pdids_in;
	}

	/**
	 * pdids_in   �趨
	 * @param pdids_in pdids_in
	 */
	public void setPdids_in(String[] pdids_in) {
		this.pdids_in = pdids_in;
	}

	/**
	 * @return the ��һ���̶���IDģ����ѯ
	 */
	public String getPdid_like() {
		return pdid_like;
	}

	/**
	 * @param ��һ���̶���IDģ����ѯ the pdid_like to set
	 */
	public void setPdid_like(String pdid_like) {
		this.pdid_like = pdid_like;
	}

}