/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.model;

import java.io.Serializable;


/**
 * ����:������Դͳ����ͼ�ӿ�(������)
 * ��������:������Դͳ����ͼ�ӿ�(������) 
 * ������¼: 2014/02/19
 * �޸ļ�¼: 
 */

public interface VIM03CountByOrgVWInfo {

	/**
	 * ������ȡ��
	 * @return orgname ������
	 */
	public String getOrgname();

	/**
	 * ������ȡ��
	 * @return orgsyscoding ������
	 */
	public String getOrgsyscoding();

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
