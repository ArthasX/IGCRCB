/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
 * 
 * �ʲ�������̲�ѯ�ӿ�
 *
 */
public interface SOC0600SearchCond {
	/**
	 * �ʲ�idȡ��
	 * @return eiid �ʲ�id
	 */
	public String getEiid();

	/**
	 * �������ͼ���ȡ��
	 * @return prpdid_in �������ͼ���
	 */
	public List<String> getPrpdid_in();

	/**
	 * ��������ȡ��
	 * @return prpdid_eq ��������
	 */
	public String getPrpdid_eq();
}
