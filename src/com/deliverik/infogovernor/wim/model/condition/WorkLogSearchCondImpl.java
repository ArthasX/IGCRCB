/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model.condition;

/**
  * ����: ������־��������ʵ��
  * ��������: ������־��������ʵ��
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public class WorkLogSearchCondImpl implements
		WorkLogSearchCond {

	/**
	 * ������־����
	 */
	protected String wlname;

	/**
	 * ִ���ˣ�userid��
	 */
	protected String excutorId;

	/**
	 * ����������
	 */
	protected String titleDate;

	/**
	 * ִ��ʱ��
	 */
	protected String excuteTime;

	/**
	 * ʵ�ʴ�������
	 */
	protected String actualDealwithDate;

	/**
	 * ���¼��������
	 */
	protected String crtDate;

	/**
	 * ������־����ȡ��
	 *
	 * @return ������־����
	 */
	public String getWlname() {
		return wlname;
	}

	/**
	 * ������־�����趨
	 *
	 * @param ������־����
	 */
	public void setWlname(String wlname) {
		this.wlname = wlname;
	}

	/**
	 * ִ���ˣ�userid��ȡ��
	 *
	 * @return ִ���ˣ�userid��
	 */
	public String getExcutorId() {
		return excutorId;
	}

	/**
	 * ִ���ˣ�userid���趨
	 *
	 * @param ִ���ˣ�userid��
	 */
	public void setExcutorId(String excutorId) {
		this.excutorId = excutorId;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getTitleDate() {
		return titleDate;
	}

	/**
	 * �����������趨
	 *
	 * @param ����������
	 */
	public void setTitleDate(String titleDate) {
		this.titleDate = titleDate;
	}

	/**
	 * ִ��ʱ��ȡ��
	 *
	 * @return excuteTime
	 */
	public String getExcuteTime() {
		return excuteTime;
	}

	/**
	 * ִ��ʱ���趨
	 *
	 * @param ִ��ʱ��
	 */
	public void setExcuteTime(String excuteTime) {
		this.excuteTime = excuteTime;
	}

	/**
	 * ʵ�ʴ�������ȡ��
	 *
	 * @return ʵ�ʴ�������
	 */
	public String getActualDealwithDate() {
		return actualDealwithDate;
	}

	/**
	 * ʵ�ʴ��������趨
	 *
	 * @param ʵ�ʴ�������
	 */
	public void setActualDealwithDate(String actualDealwithDate) {
		this.actualDealwithDate = actualDealwithDate;
	}

	/**
	 * ���¼��������ȡ��
	 *
	 * @return ���¼��������
	 */
	public String getCrtDate() {
		return crtDate;
	}

	/**
	 * ���¼���������趨
	 *
	 * @param ���¼��������
	 */
	public void setCrtDate(String crtDate) {
		this.crtDate = crtDate;
	}
}