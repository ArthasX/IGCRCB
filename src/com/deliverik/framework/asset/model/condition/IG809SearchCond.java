/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

import java.util.Set;

/**
 * �ʲ���ϵͼ�ļ���ϢDAO�ӿڲ�ѯ�ӿ�
 *
 */
public interface IG809SearchCond {

	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public Integer getEiid();
	
	/**
	 * ��ϵͼ����ȡ��
	 * @return ��ϵͼ����
	 */
	public String getEirftype();
	
	/**
	 * ��ϵͼ�ļ���ȡ��
	 * @return ��ϵͼ�ļ���
	 */
	public String getEirfname();
	
	/**
	 * �ʲ�ID����ȡ��
	 * @return �ʲ�ID����
	 */
	public Set<Integer> getEiidList();
	
}
