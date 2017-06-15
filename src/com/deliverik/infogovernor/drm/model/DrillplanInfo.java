/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �����ƻ��ӿ�
  * ��������: �����ƻ��ӿ�
  * ������¼: 2015/03/02
  * �޸ļ�¼: 
  */
public interface DrillplanInfo extends BaseModel {

	/**
	 * �����ƻ�idȡ��
	 *
	 * @return �����ƻ�id
	 */
	public Integer getDid();

	/**
	 * �����ƻ��ƶ���idȡ��
	 *
	 * @return �����ƻ��ƶ���id
	 */
	public String getDuserid();

	/**
	 * �����ƻ�ָ������ȡ��
	 *
	 * @return �����ƻ�ָ������
	 */
	public String getDusername();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getCrttime();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getJudgetime();

	/**
	 * �����ƻ����ȡ��
	 *
	 * @return �����ƻ����
	 */
	public String getDserial();

	/**
	 * �����ƻ�����ȡ��
	 *
	 * @return �����ƻ�����
	 */
	public String getDname();

	/**
	 * ����״̬ a Ϊ����b�����У�c�������ȡ��
	 *
	 * @return ����״̬ a Ϊ����b�����У�c�������
	 */
	public String getJudgestatus();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getDepict();
	//������userid
	public String getJudgeuserid();
	//������username
	public String getJudgeusername();
	
    /** ������� */
    public String getDopinion();
    /**�������*/
    public String getCompletecount();

}