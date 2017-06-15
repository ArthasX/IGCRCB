/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dut.model;

import java.util.List;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.dut.model.entity.DutyPersonTB;

/**
 * ֵ��ƻ�ʵ��ӿ�
 */
public interface DutyPlan extends BaseModel {	
	
	/**
	 * �����ID
	 */
	public Integer getDpid();

	/**
	 * ֵ������
	 */
	public String getDadcategory();
	
	/**
	 * ֵ������
	 */
	public String getDptime();
	
	/**
	 * �װ�/ҹ��
	 */
	public String getDptype();
	
	/**
	 * ״̬
	 */
	public String getDpstatus();
	
	/**
	 * ��������
	 */
	public String getDpquestion();
	
	/**
	 * �ܽ�
	 */
	public String getDpinfo();
	
	/**
	 * ������ID
	 */
	public String getDpuserid();
	
	/**
	 * ����������
	 */
	public String getDpusername();
	
	/**
	 * �Ǽ�ʱ��
	 */
	public String getDpcretime();
	
	/**
	 * ����ʱ��
	 */
	public String getDpupdtime();
	
	/**
	 * ����ʱ��
	 */
	public String getDpfintime();
	
	/**
	 * dpremarksȡ��
	 *
	 * @return dpremarks dpremarks
	 */
	public String getDpremarks();
	
	/**
     * 
	 * ֵ����ȡ��
	 * @return ֵ����
	 */
	public List<DutyPersonTB> getDutyPersonList();
	
	/**
     * 
	 * ȫ��ֵ��������ȡ��
	 * @return ȫ��ֵ��������
	 */
	public String getDutyPersonName();

}
