/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * ����: �û���Ϣʱ�䶨����������ʵ��
  * ��������: �û���Ϣʱ�䶨����������ʵ��
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
public class ProcessWorkTimeSearchCondImpl implements ProcessWorkTimeSearchCond {
	/**��ѯ��ʼ����*/
	private String startDate;
	
	/**��ѯ��������*/
	private String endDate;
	
	/**��ѯ��������*/
	protected String pwDate;
	
	/**��ѯ�û��޸ı�ʶλ*/
	protected String pwFlg;
	
	/**
	 * ��ѯ���
	 */
	protected String pwDate_like;
	
	/**��ѯ�û�ID*/
	private String userId;
	
	/**
	 * �������ڻ�ȡ
	 */
	public String getPwDate() {
		return pwDate;
	}

	/**
	 * ���������趨
	 * @param pwDate
	 */
	public void setPwDate(String pwDate) {
		this.pwDate = pwDate;
	}
	
	/**
	 * @return ��ѯ�û�ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param ��ѯ�û�ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * �û��޸ı�ʶλ��ȡ
	 */
	public String getPwFlg() {
		return pwFlg;
	}

	/**
	 * �û��޸ı�ʶλ�趨
	 * @param pwFlg
	 */
	public void setPwFlg(String pwFlg) {
		this.pwFlg = pwFlg;
	}

	/**
	 * @return ��ѯ��ʼ����
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param ��ѯ��ʼ����
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return ��ѯ��������
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param ��ѯ��������
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * ��ѯ��ݻ�ȡ
	 */
	public String getPwDate_like() {
		return pwDate_like;
	}
	/**
	 * ��ѯ����趨
	 */
	public void setPwDate_like(String pwDate_like) {
		this.pwDate_like = pwDate_like;
	}

}