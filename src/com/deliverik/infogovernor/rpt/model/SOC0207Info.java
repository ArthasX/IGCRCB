/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ����ģ��ӿ�
  * ��������: ����ģ��ӿ�
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/09 ��ReportTemplateInfo������ΪSOC0207Info
  */
public interface SOC0207Info extends BaseModel {

	/**
	 * IDȡ��
	 *
	 * @return ID
	 */
	public Integer getRtId();

	/**
	 * ģ������ȡ��
	 *
	 * @return ģ������
	 */
	public String getRtName();

	/**
	 * ���޸�λ����ȡ��
	 *
	 * @return ���޸�λ����
	 */
	public Integer getRtSum();

	/**
	 * ʱ������ȡ��
	 *
	 * @return ʱ������
	 */
	public String getRtDateType();

	/**
	 * ģ����ʵ����ȡ��
	 *
	 * @return ģ����ʵ����
	 */
	public String getRtRealName();

	/**
	 * ģ���ϴ�ʱ��ȡ��
	 *
	 * @return ģ���ϴ�ʱ��
	 */
	public String getRtUploadTime();

	/**
	 * ģ������ȡ��
	 *
	 * @return ģ������
	 */
	public String getRtType();

}