/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.model;

import java.io.Serializable;


/**
 * ����:������Դͳ����ͼ�ӿ�(����Ŀ)
 * ��������:������Դͳ����ͼ�ӿ�(����Ŀ) 
 * ������¼: 2014/02/19
 * �޸ļ�¼: 
 */

public interface VIM03CountByProjVWInfo {
	/**
	 * ��Ŀ��ȡ��
	 * @return pname ��Ŀ��
	 */
	public String getPname();

	/**
	 * ��ĿIDȡ��
	 * @return pid ��ĿID
	 */
	public String getPid();

	/**
	 * �������ȡ��
	 * @return count �������
	 */
	public String getCount();
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK();
	
	public Integer getTotalcpu();

	public Integer getTotalmem();

	public Integer getTotaldisk();
	
	public Integer getCost();
}
