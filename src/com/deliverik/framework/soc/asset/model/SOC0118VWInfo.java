/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: SOC0118VW�ӿ�
  * ��������: SOC0118VW�ӿ�
  * ������¼: 2016/06/21
  * �޸ļ�¼: 
  */
public interface SOC0118VWInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId();

	/**
	 * �ʲ�ID                  ȡ��
	 *
	 * @return �ʲ�ID                  
	 */
	public Integer getEiid();

	/**
	 * �ʲ�ģ��ID              ȡ��
	 *
	 * @return �ʲ�ģ��ID              
	 */
	public String getEid();

	/**
	 * �ʲ����˵��            ȡ��
	 *
	 * @return �ʲ����˵��            
	 */
	public String getEidesc();

	/**
	 * �ʲ�����                ȡ��
	 *
	 * @return �ʲ�����                
	 */
	public String getEiname();

	/**
	 * �ʲ����                ȡ��
	 *
	 * @return �ʲ����                
	 */
	public String getEilabel();

	/**
	 * �ʲ��Ǽ���              ȡ��
	 *
	 * @return �ʲ��Ǽ���              
	 */
	public String getEiinsdate();

	/**
	 * �������������          ȡ��
	 *
	 * @return �������������          
	 */
	public String getEiorgsyscoding();

	/**
	 * ����ģ�Ͳ����          ȡ��
	 *
	 * @return ����ģ�Ͳ����          
	 */
	public String getEsyscoding();

	/**
	 * ����ʱ��                ȡ��
	 *
	 * @return ����ʱ��                
	 */
	public String getEiupdtime();

	/**
	 * �ʲ�״̬                ȡ��
	 *
	 * @return �ʲ�״̬                
	 */
	public String getEistatus();

	/**
	 * �汾                    ȡ��
	 *
	 * @return �汾                    
	 */
	public String getEiversion();
	
	/**
	 * �ʲ�������ȡ��
	 * @return �ʲ�������
	 */
	public String getEiuserid();
	
	/**
	 * �ʲ�����������ȡ��
	 * @return �ʲ�����������
	 */
	public String getEiusername();
	
	/**
	 * �ʲ�С�汾ȡ��
	 * @return �ʲ�С�汾
	 */
	public Integer getEismallversion();
	
	/**
	 * �ʲ����������ڵ�ʵ���ʶȡ��
	 * @return �ʲ����������ڵ�ʵ���ʶ
	 */
	public Integer getEirootmark();
}