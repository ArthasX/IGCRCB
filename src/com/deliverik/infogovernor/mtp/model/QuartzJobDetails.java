/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.mtp.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : SOC
 * </p>
 * <p>
 * Description: �ճ���ά�ƻ���Ϣ�ӿ�
 * </p>
 * 
 * @author duchong@deliverik.com
 */

public interface QuartzJobDetails  extends BaseModel {

	/**
	 * ��ȡ����
	 * @return ����
	 */
	public Integer getQjdid();

	/**
	 * ��ȡ��ά��������
	 * @return ����
	 */
	public Integer getQjid();

	/**
	 * ��ȡִ��ʱ��
	 * @return ִ��ʱ��
	 */
	public String getQjdtime();

	/**
	 * ��ȡ���ڼ�
	 * @return ���ڼ�
	 */
	public String getQjdweek();

	/**
	 * ��ȡִ��״̬
	 * @return ִ��״̬
	 */
	public String getQjdtype();

	/**
	 * ��ȡ����������
	 * @return ����������
	 */
	public String getQjdtriname();

	/**
	 * ��ȡ�����������������
	 * @return �����������������
	 */
	public String getQjdtrigrpname();
}