/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dut.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ֵ�������ʵ��ӿ�
 */
public interface DutyAuditDef extends BaseModel {	
	
	/**
	 * �����ID
	 */
	public Integer getDadid();

	/**
	 * ֵ������
	 */
	public String getDadcategory();
	
	/**
	 * ������
	 */
	public String getDadtype();
	
	/**
	 * �������
	 */
	public String getDadname();
	
	/**
	 * �ʱ������
	 */
	public String getDadlimtime();
	
	/**
	 * ���������
	 */
	public String getDadcontent();
	
	/**
	 * ���˵��
	 */
	public String getDadinfo();
	
	/**
	 * ʹ��״̬
	 */
	public String getDadstatus();
	
	/**
	 * ������ID
	 */
	public String getDaduserid();
	
	/**
	 * ����������
	 */
	public String getDadusername();
	
	/**
	 * ����ʱ��
	 */
	public String getDadupdtime();
	
	/**
	 * �����ʶȡ��
	 *
	 * @return dadorderby �����ʶ
	 */
	public Integer getDadorderby();
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getPeriodType();

	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getPeriodValue();

}
