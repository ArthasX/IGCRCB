/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��������ӿ�
  * ��������: ��������ӿ�
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public interface WorkDefinitionInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return wdid
	 */
	public Integer getWdid();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getWdname();

	/**
	 * �����ˣ�userid��ȡ��
	 *
	 * @return �����ˣ�userid��
	 */
	public String getInitiatorId();

	/**
	 * ����/Ƶ��ȡ��
	 *
	 * @return ����/Ƶ��
	 */
	public String getCycle();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getWdcreateTime();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getDescription();

	/**
	 * ��ʼ����ȡ��
	 *
	 * @return ��ʼ����
	 */
	public String getBeginDate();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getEndDate();

	/**
	 * Ԥ���������ȡ��
	 *
	 * @return Ԥ���������
	 */
	public String getEstimateFinishDate();

	/**
	 * ʵ���������ȡ��
	 *
	 * @return ʵ���������
	 */
	public String getActualFinishDate();

	/**
	 * ��ʱ����ʱ�䣨�죩ȡ��
	 *
	 * @return ��ʱ����ʱ�䣨�죩
	 */
	public String getOvertimeTipsTime();

	/**
	 * �����ˣ�userid��ȡ��
	 *
	 * @return �����ˣ�userid��
	 */
	public String getLeaderId();

	/**
	 * ִ���ˣ�userid,userid,userid,...��ȡ��
	 *
	 * @return ִ���ˣ�userid,userid,userid,...��
	 */
	public String getExcutorId();

	/**
	 * ����״̬��0��δ���ã�1�������ã�ȡ��
	 *
	 * @return ����״̬��0��δ���ã�1�������ã�
	 */
	public Integer getWdstatus();

	/**
	 * ��ȡ��
	 *
	 * @return ��
	 */
	public String getWdmonth();

	/**
	 * ÿ�����һ�췢��Y���ǣ�N����ȡ��
	 *
	 * @return ÿ�����һ�췢��Y���ǣ�N����
	 */
	public String getMonthLastDay();

	/**
	 * ��ȡ��
	 *
	 * @return ��
	 */
	public String getWdweek();

	/**
	 * ʱȡ��
	 *
	 * @return ʱ
	 */
	public String getWdhour();

	/**
	 * ��ȡ��
	 *
	 * @return ��
	 */
	public String getWdminute();

	/**
	 * �Ƿ����֪ͨ��Y,�ǣ�N����ȡ��
	 *
	 * @return �Ƿ����֪ͨ��Y,�ǣ�N����
	 */
	public String getIsMsgNotice();

	/**
	 * ��עȡ��
	 *
	 * @return ��ע
	 */
	public String getRemarks();

	/**
	 * ���¼��������ȡ��
	 *
	 * @return ���¼��������
	 */
	public String getCrtDate();
	
	/**
	 * Ԥ���ֶ�ȡ��
	 * @return Ԥ���ֶ�
	 */
	public String getReservedFiled();

}