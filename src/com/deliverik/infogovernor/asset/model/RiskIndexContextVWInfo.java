/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ����ָ��չʾ���ݲ�ѯ�ӿ�
  * ��������: ����ָ��չʾ���ݲ�ѯ�ӿ�
  * ������¼: 2014/07/26
  * �޸ļ�¼: 
  */
public interface RiskIndexContextVWInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getRimid();

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public Integer getEiid();

	/**
	 * ���㷽ʽȡ��
	 *
	 * @return ���㷽ʽ
	 */
	public String getRimtype();

	/**
	 * �洢sqlȡ��
	 *
	 * @return �洢sql
	 */
	public String getRimsql();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getEiname();

	/**
	 * ���ձ��ȡ��
	 *
	 * @return ���ձ��
	 */
	public String getEilabel();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getRimdesc();

	/**
	 * ����ȡ��
	 * @return esyscoding ����
	 */
	public String getEsyscoding() ;
}