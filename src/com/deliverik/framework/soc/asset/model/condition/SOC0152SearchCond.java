/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
  * ����: �ʲ���ϵ����������ӿ�
  * ��������: �ʲ���ϵ����������ӿ�
  * ������¼: ����ȫ 2013/05/27
  * �޸ļ�¼: 
  */
public interface SOC0152SearchCond {
	
	/**
	 * ģ����ȡ��
	 *
	 * @return rlnCode_eq ģ����
	 */
	
	public String getRlnCode_eq();


	/**
	 * ��ʼģ��IDȡ��
	 *
	 * @return fromModelEid_eq ��ʼģ��ID
	 */
	
	public String getFromModelEid_eq();


	/**
	 * ��ģ��IDȡ��
	 *
	 * @return toModelEid_eq ��ģ��ID
	 */
	
	public String getToModelEid_eq();
	
	/**
	 * ���ģ����ȡ��
	 *
	 * @return rlnCode_in ���ģ����
	 */
	
	public List<String> getRlnCode_in();
	
	/**
	 * ��ϵ������ȡ��
	 *
	 * @return rlnType_eq ��ϵ������
	 */
	
	public String getRlnType_eq();
}