/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

import java.math.BigDecimal;

/**
 * 
 * �Ӵ���ѯ�ӿ�
 *
 */
public interface GoodsSearchCond {
	
	/**
	 * ��Ʒ��ϢIDȡ��
	 * @return ��Ʒ��ϢID
	 */
	public Integer getGid();

	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGcategory();

	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGname();

	/**
	 * ��Ʒ���ȡ��
	 * @return ��Ʒ���
	 */
	public String getGcode();

	/**
	 * Ԥ����ʾ����ȡ��
	 * @return Ԥ����ʾ����
	 */
	public Integer getGwarningnum();

	/**
	 * ��Ʒ�ڲ�ת�ƶ��ۣ�%��ȡ��
	 * @return ��Ʒ�ڲ�ת�ƶ��ۣ�%��
	 */
	public BigDecimal getGprice();

	/**
	 * ״̬��0:ͣ�� 1:���ã�ȡ��
	 * @return ״̬��0:ͣ�� 1:���ã�
	 */
	public String getGstatus();
	

}
