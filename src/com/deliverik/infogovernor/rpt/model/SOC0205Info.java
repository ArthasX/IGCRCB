/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.rpt.model.entity.SOC0207TB;

/**
  * ����: ��������ӿ�
  * ��������: ��������ӿ�
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/09 ��ReportManageInfo������ΪSOC0205Info
  */
public interface SOC0205Info extends BaseModel {

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getRmId();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getRmName();

	/**
	 * ģ�����ȡ��
	 *
	 * @return ģ�����
	 */
	public SOC0207TB getReportTemplateTB();

	/**
	 * ��ȡ��
	 *
	 * @return ��
	 */
	public String getRmYear();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getRmQuarter();

	/**
	 * ��ȡ��
	 *
	 * @return ��
	 */
	public String getRmMonth();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getCreateDate();
	/**
	 * �����Ӹ��ӱ���ʱ��ȡ��
	 *
	 * @return lastAnnexationDate �����Ӹ��ӱ���ʱ��
	 */
	public String getLastAnnexationDate();
	/**
	 * ����ȡ��
	 *
	 * @return rmDateType ����
	 */
	public String getRmDateType();


	/**
	 * ���һ��ȡ��
	 *
	 * @return rmLastDay ���һ��
	 */
	public String getRmLastDay() ;
	/**
	 * ģ������ȡ��
	 *
	 * @return rtName ģ������
	 */
	public String getRtName();
	/**
	 * ��Ÿ��ӱ���ID�Զ���Ϊ�ָ���ȡ��
	 *
	 * @return raStr ��Ÿ��ӱ���ID�Զ���Ϊ�ָ���
	 */
	public String getRaStr();
	/**
	 * ��׺����ȡ��
	 *
	 * @return rmSuffix ��׺����
	 */
	public String getRmSuffix();
}