/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���չ�����ʾ���ݱ�ӿ�
  * ��������: ���չ�����ʾ���ݱ�ӿ�
  * ������¼: 2014/06/17
  * �޸ļ�¼: 
  */
public interface RiskmanagerwaringInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getRwid();

	/**
	 * ������ʾ����ȡ��
	 *
	 * @return ������ʾ����
	 */
	public String getRwname();

	/**
	 * �·�����idȡ��
	 *
	 * @return �·�����id
	 */
	public String getNuserid();

	/**
	 * �·���������ȡ��
	 *
	 * @return �·���������
	 */
	public String getNusername();

	/**
	 * �·��߻�����ȡ��
	 *
	 * @return �·��߻�����
	 */
	public String getNorgname();

	/**
	 * �·��߻�����ȡ��
	 *
	 * @return �·��߻�����
	 */
	public String getNorgid();

	/**
	 * �·�ʱ��ȡ��
	 *
	 * @return �·�ʱ��
	 */
	public String getNtime();

	/**
	 * �·�����ϵ��ʽȡ��
	 *
	 * @return �·�����ϵ��ʽ
	 */
	public String getNtel();

	/**
	 * ������ʾ����ȡ��
	 *
	 * @return ������ʾ����
	 */
	public String getRwcontext();

	/**
	 * ��ʾ����ȡ��
	 *
	 * @return ��ʾ����
	 */
	public String getRwkey();
	
	/**
	 * ��ʾ����ȡ��
	 * @return showTime ��ʾ����
	 */
	public String getShowTime();

}