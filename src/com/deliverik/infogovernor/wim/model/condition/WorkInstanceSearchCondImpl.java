/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model.condition;

/**
  * ����: ����ʵ����������ʵ��
  * ��������: ����ʵ����������ʵ��
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public class WorkInstanceSearchCondImpl implements
		WorkInstanceSearchCond {

	/**
	 * ����ʵ������
	 */
	protected String winame;

	/**
	 * ����״̬��0��δִ�У�1��ִ���У�2����ִ�У�3��������4����ֹ����
	 */
	protected Integer wistatus;

	/**
	 * ���ţ�id��
	 */
	protected String wiDepartmentid;

	/**
	 * ��Ա��userid��
	 */
	protected String wiuserid;

	/**
	 * �������ͣ�1���Զ�����2���ֶ�����
	 */
	protected String wiLunchType;

	/**
	 * ִ������ʱ�䣨Сʱ��
	 */
	protected String excuteTime;

	/**
	 * ʵ�ʴ������� 
	 */
	protected String actualDealwithDate;

	/**
	 * ����ȷ������
	 */
	protected String confirmDate;

	/**
	 * ����������
	 */
	protected String titleDate;

	/**
	 * ���¼��������
	 */
	protected String crtDate;

	/**
	 * ����ʵ������ȡ��
	 *
	 * @return ����ʵ������
	 */
	public String getWiname() {
		return winame;
	}

	/**
	 * ����ʵ�������趨
	 *
	 * @param ����ʵ������
	 */
	public void setWiname(String winame) {
		this.winame = winame;
	}

	/**
	 * ����״̬��0��δִ�У�1��ִ���У�2����ִ�У�3��������4����ֹ����ȡ��
	 *
	 * @return ����״̬��0��δִ�У�1��ִ���У�2����ִ�У�3��������4����ֹ����
	 */
	public Integer getWistatus() {
		return wistatus;
	}

	/**
	 * ����״̬��0��δִ�У�1��ִ���У�2����ִ�У�3��������4����ֹ�����趨
	 *
	 * @param ����״̬��0��δִ�У�1��ִ���У�2����ִ�У�3��������4����ֹ����
	 */
	public void setWistatus(Integer wistatus) {
		this.wistatus = wistatus;
	}

	/**
	 * ���ţ�id��ȡ��
	 *
	 * @return ���ţ�id��
	 */
	public String getWiDepartmentid() {
		return wiDepartmentid;
	}

	/**
	 * ���ţ�id���趨
	 *
	 * @param ���ţ�id��
	 */
	public void setWiDepartmentid(String wiDepartmentid) {
		this.wiDepartmentid = wiDepartmentid;
	}

	/**
	 * ��Ա��userid��ȡ��
	 *
	 * @return ��Ա��userid��
	 */
	public String getWiuserid() {
		return wiuserid;
	}

	/**
	 * ��Ա��userid���趨
	 *
	 * @param ��Ա��userid��
	 */
	public void setWiuserid(String wiuserid) {
		this.wiuserid = wiuserid;
	}

	/**
	 * �������ͣ�1���Զ�����2���ֶ�����ȡ��
	 *
	 * @return �������ͣ�1���Զ�����2���ֶ�����
	 */
	public String getWiLunchType() {
		return wiLunchType;
	}

	/**
	 * �������ͣ�1���Զ�����2���ֶ������趨
	 *
	 * @param �������ͣ�1���Զ�����2���ֶ�����
	 */
	public void setWiLunchType(String wiLunchType) {
		this.wiLunchType = wiLunchType;
	}

	/**
	 * ִ������ʱ�䣨Сʱ��ȡ��
	 *
	 * @return ִ������ʱ�䣨Сʱ��
	 */
	public String getExcuteTime() {
		return excuteTime;
	}

	/**
	 * ִ������ʱ�䣨Сʱ���趨
	 *
	 * @param ִ������ʱ�䣨Сʱ��
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
	 * ����ȷ������ȡ��
	 *
	 * @return ����ȷ������
	 */
	public String getConfirmDate() {
		return confirmDate;
	}

	/**
	 * ����ȷ�������趨
	 *
	 * @param ����ȷ������
	 */
	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
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