/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��ѡ�����ӿ�
  * ��������: ��ѡ�����ӿ�
  * ������¼: 2016/10/09
  * �޸ļ�¼: 
  */
public interface OptionSencesInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getOsid();

	/**
	 * Ӧ������pridȡ��
	 *
	 * @return Ӧ������prid
	 */
	public Integer getPrid();

	/**
	 * ����eiidȡ��
	 *
	 * @return ����eiid
	 */
	public Integer getSenceEiid();

}