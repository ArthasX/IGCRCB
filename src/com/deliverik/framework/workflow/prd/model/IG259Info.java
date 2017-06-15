package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ����ģ����Ϣ
 *
 */
public interface IG259Info  extends BaseModel {

	/**
	 * ����ģ��IDȡ��
	 * @return ����ģ��ID
	 */
	public Integer getPtid();

	/**
	 * ����ģ������ȡ��
	 * @return ����ģ������
	 */
	public String getPtname();

	/**
	 * ����ģ������ȡ��
	 * @return ����ģ������
	 */
	public String getPttype();

	/**
	 * ����ģ�巢��ҳURLȡ��
	 * @return ����ģ�巢��ҳURL
	 */
	public String getPtstartpg();

	/**
	 * ����ģ�崴��ʱ��ȡ��
	 * @return ����ģ�崴��ʱ��
	 */
	public String getPtcrtdate();

	/**
	 * ����ģ����Ϣȡ��
	 * @return ����ģ����Ϣ
	 */
	public String getPtpicinfo();

	/**
	 * ����ģ��״̬ȡ��
	 * @return ����ģ��״̬
	 */
	public String getPtstatus();

	/**
	 * ����ģ��鿴ҳURLȡ��
	 * @return ����ģ��鿴ҳURL
	 */
	public String getPtdetailpg();

	/**
	 * ͨ������ģ������ת�ķ���ҳ��URL��ƽ̨������ȡ��
	 * @return ͨ������ģ������ת�ķ���ҳ��URL
	 */
	public String getPtsavepg();

	/**
	 * ����ģ��ʹ��λ�ñ�ʶ��ƽ̨������ȡ��
	 * @return ����ģ��ʹ��λ�ñ�ʶ
	 */
	public String getPtqrtzflag();
	
	/**
	 * ��λ�ñ�ʶȡ��
	 * @return firstsite ��λ�ñ�ʶ
	 */
	public String getFirstsite();

	/**
	 * ���ж���ȡ��
	 * @return pdsequence ���ж���
	 */
	public String getPdsequence();
}