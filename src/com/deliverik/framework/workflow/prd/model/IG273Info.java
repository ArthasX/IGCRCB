/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.workflow.prd.model.entity.IG333TB;

/**
 * ����״̬ԾǨ����
 *
 */
public interface IG273Info extends BaseModel {
	/**
	 * ����״̬ԾǨ����IDȡ��
	 * @return ����״̬ԾǨ����ID
	 */
	public String getPtdid();
	
	/**
	 * ����״̬ID��From��ȡ��
	 * @return ����״̬ID��From��
	 */
	public String getFpsdid();
	
	/**
	 * ����״̬ID��To��ȡ��
	 * @return ����״̬ID��To��
	 */
	public String getTpsdid();

	/**
	 * ����״̬ԾǨ��������ȡ��
	 * @return ����״̬ԾǨ��������
	 */
	public String getPtdname();
	
	/**
	 * ����״̬ԾǨ��������ȡ��
	 * @return ����״̬ԾǨ��������
	 */
	public String getPtddesc();
	
	/**
	 * ����״̬ԾǨ��������ȡ��
	 * @return ����״̬ԾǨ��������
	 */
	public String getPtdtype();
	
	/**
	 * ����״̬ԾǨ����ȡ��
	 * @return ����״̬ԾǨ����
	 */
	public String getPtdcond();
	
	/**
	 * ����״̬ԾǨ����ȡ��
	 * @return ����״̬ԾǨ����
	 */
	public String getPtdcondinfo();
	
	/**
	 * ���̵�ǰ״̬ȡ��
	 * @return ���̵�ǰ״̬
	 */
	public IG333TB getFromPSDTB();
	
	/**
	 * ����ԾǨ״̬ȡ��
	 * @return ����ԾǨ״̬
	 */
	public IG333TB getToPSDTB();
	
}
