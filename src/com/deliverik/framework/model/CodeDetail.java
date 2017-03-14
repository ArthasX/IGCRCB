package com.deliverik.framework.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ������Ϣ�ӿ�
 * @author
 *
 */
public interface CodeDetail  extends BaseModel {

	/**
	 * ���ݷ���CDȡ��
	 * @return ���ݷ���CD
	 */
	public String getCcid ();

	/**
	 * ����CDȡ��
	 * @return ����CD
	 */
	public String getCid ();

	/**
	 * ����ֵȡ��
	 * @return ����ֵ
	 */
	public String getCvalue ();

	/**
	 * ���ݷ���CD(��)ȡ��
	 * @return ���ݷ���CD(��)
	 */
	public String getPccid ();

	/**
	 * ����CD(��)ȡ��
	 * @return ����CD(��)
	 */
	public String getPcid ();

	/**
	 * ���ݸ���ʱ��ȡ��
	 * @return ���ݸ���ʱ��
	 */
	public String getUpdtime ();
	
	/**
	 * �����
	 * @return �����
	 */
	public String getSyscoding ();
	/**
	 * �ϼ������
	 * @return �ϼ������
	 */
	public String getPsyscoding();
	
	/**
	 * ״̬ 0-ͣ�ã�1-����
	 * @return ״̬
	 */
	public String getCdstatus();
	
	/**
	 * ����ҵ����
	 * @return ����ҵ����
	 */
	public String getBusinesscode();
	/**
	 * ����˵��
	 * @return ����˵��
	 */
	public String getCdinfo();
	
	/**
	 * ���б�ʶ
	 * @return ���б�ʶ
	 */
	public Integer getCdorder();
	
}