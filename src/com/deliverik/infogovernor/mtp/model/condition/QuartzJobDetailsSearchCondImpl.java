package com.deliverik.infogovernor.mtp.model.condition;

/**
 * �ճ���ά�ƻ���Ϣ��������ʵ��
 */
public class QuartzJobDetailsSearchCondImpl implements QuartzJobDetailsSearchCond {

	/**QuartzJoss������*/
	protected Integer qjid;

	/**ִ��ʱ��*/
	protected String qjdtime;

	/**���ڼ� */
	protected String qjdweek;

	/**ִ��״̬��1��ִ�У�0δִ�У� */
	protected String qjdtype;
	
	/**����������*/
	protected String qjdtriname;
	
	/**
	 * ��ȡ����������
	 * @return ����������
	 */
	public String getQjdtriname() {
		return qjdtriname;
	}

	/**
	 * ���ô���������
	 * @param qjdtriname ����������
	 */
	public void setQjdtriname(String qjdtriname) {
		this.qjdtriname = qjdtriname;
	}

	/**
	 * ��ȡ��ά��������
	 * @return ����
	 */
	public Integer getQjid() {
		return qjid;
	}

	/**
	 * ������ά��������
	 * @param qjid ����
	 */
	public void setQjid(Integer qjid) {
		this.qjid = qjid;
	}

	/**
	 * ��ȡִ��ʱ��
	 * @return ִ��ʱ��
	 */
	public String getQjdtime() {
		return qjdtime;
	}

	/**
	 * ����ִ��ʱ��
	 * @param qjdtime ִ��ʱ��
	 */
	public void setQjdtime(String qjdtime) {
		this.qjdtime = qjdtime;
	}

	/**
	 * ��ȡ���ڼ�
	 * @return ���ڼ�
	 */
	public String getQjdweek() {
		return qjdweek;
	}

	/**
	 * �������ڼ�
	 * @param qjdweek ���ڼ�
	 */
	public void setQjdweek(String qjdweek) {
		this.qjdweek = qjdweek;
	}

	/**
	 * ��ȡִ��״̬
	 * @return ִ��״̬
	 */
	public String getQjdtype() {
		return qjdtype;
	}

	/**
	 * ����ִ��״̬
	 * @param qjdtype ִ��״̬
	 */
	public void setQjdtype(String qjdtype) {
		this.qjdtype = qjdtype;
	}
	
}
