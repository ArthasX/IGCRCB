/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.model.condition;

/**
  * ����: ������Ŀ���������ӿ�
  * ��������: ������Ŀ���������ӿ�
  * ������¼: 2012/07/19
  * �޸ļ�¼: 
  */
public interface InternalauditprjSearchCond {

	/** iapYear_eqȡ�� */
	public String getIapYear_eq();
	
	/** iapName_likeȡ�� */
	public String getIapName_like();
	
	/** iapStatus_eqȡ�� */
	public String getIapStatus_eq();
	
	/** iapOpenTimeFrom_geȡ�� */
	public String getIapOpenTimeFrom_ge();
	
	/** iapOpenTimeTo_leȡ�� */
	public String getIapOpenTimeTo_le();
	
	/** iapType_eqȡ�� */
	public String getIapType_eq();
}