/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: SOC0109VW�ӿ�
  * ��������: SOC0109VW�ӿ�
  * ������¼: 2016/06/21
  * �޸ļ�¼: 
  */
public interface SOC0109VWInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId();

	/**
	 * �ʲ�ģ������ID                           ȡ��
	 *
	 * @return �ʲ�ģ������ID                           
	 */
	public String getCid();

	/**
	 * �ʲ�ģ��ID�������                       ȡ��
	 *
	 * @return �ʲ�ģ��ID�������                       
	 */
	public String getEid();

	/**
	 * �ʲ�ģ����������                         ȡ��
	 *
	 * @return �ʲ�ģ����������                         
	 */
	public String getCname();

	/**
	 * CLABEL                                   ȡ��
	 *
	 * @return CLABEL                                   
	 */
	public String getClabel();

	/**
	 * �ʲ�ģ������˵��                         ȡ��
	 *
	 * @return �ʲ�ģ������˵��                         
	 */
	public String getCdesc();

	/**
	 * �ʲ�ģ�����Ե�λ                         ȡ��
	 *
	 * @return �ʲ�ģ�����Ե�λ                         
	 */
	public String getCunit();

	/**
	 * �ʲ�ģ������״̬                         ȡ��
	 *
	 * @return �ʲ�ģ������״̬                         
	 */
	public String getCstatus();

	/**
	 * �ʲ�ģ�������Ƿ���ʾ��ʶ��1��ʾ��0����ʾ?ȡ��
	 *
	 * @return �ʲ�ģ�������Ƿ���ʾ��ʶ��1��ʾ��0����ʾ?
	 */
	public String getCseq();

	/**
	 * �ʲ�ģ����������ģ�͵�ģ�ͷ���           ȡ��
	 *
	 * @return �ʲ�ģ����������ģ�͵�ģ�ͷ���           
	 */
	public String getCcategory();

	/**
	 * �ʲ�ģ������ȡֵ��ΧID                   ȡ��
	 *
	 * @return �ʲ�ģ������ȡֵ��ΧID                   
	 */
	public String getCoption();

	/**
	 * �ʲ�ģ��������������                     ȡ��
	 *
	 * @return �ʲ�ģ��������������                     
	 */
	public String getCattach();

	/**
	 * �ʲ�ģ����������ģ�Ͳ����               ȡ��
	 *
	 * @return �ʲ�ģ����������ģ�Ͳ����               
	 */
	public String getEsyscoding();

	/**
	 * �����ʶȡ��
	 * @return �����ʶ
	 */
	public Integer getCorder();

}