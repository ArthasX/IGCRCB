/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
 * <p>
 * �ʲ�ģ������ȡֵ��Χ��������
 * </p>
 * <p>
 * <br>
 * <table border="1">
 * <tr>
 * <td>ccdcategory</td>
 * <td>�ʲ�����ȡֵ��Χ��ʶ</td>
 * </tr>
 * <tr>
 * <td>ccdstatus</td>
 * <td>�ʲ�����ȡֵ��Χ״̬<br>0:ͣ��<br>1:����</td>
 * </tr> 
 * <tr>
 * <td>ccdtype</td>
 * <td>�ʲ�����ȡֵ��Χ����Ӧ��<br>"A":��ʾ�ʲ���<br>����:δʹ��</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface SOC0151SearchCond {

	/**
	 * �ʲ�����ȡֵ��Χ��ʶȡ��
	 * @return �ʲ�����ȡֵ��Χ��ʶ
	 */
	public String getCcdcategory();

	/**
	 * �ʲ�����ȡֵ��Χ״̬ȡ��
	 * @return �ʲ�����ȡֵ��Χ״̬
	 */
	public String getCcdstatus();

	/**
	 * �ʲ�����ȡֵ��Χ����Ӧ��ȡ��
	 * @return �ʲ�����ȡֵ��Χ����Ӧ��
	 */
	public String getCcdtype();

}
