/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.csebank.lom.model;

import com.csebank.lom.model.entity.RecptionTB;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ʳ�ù���_ͳ�ƻ���_��һ��Ʒ���ͳ����ϢMODEL
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */
public interface SingleGoodsStock {
	
	/**
	 * ����
	 * @return ����
	 */
	public String getGiodtime();
	
	/**
	 * ���������
	 * @return ���������
	 */
	public String getGiodtype();
	
	/**
	 * ������
	 * @return ������
	 */
	//public String getOrgname();
	
	/**
	 * ��������
	 * @return ��������
	 */
	public Integer getGiodoutnum();
	
	/**
	 * �������
	 * @return �������
	 */
	public Integer getGiodinnum();
	
	/**
	 * �����
	 * @return �����
	 */
	public Integer getGiodnum();
	
	public RecptionTB getRecptionTB();
	
	public Integer getRid() ;

}