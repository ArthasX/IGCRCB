/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.condition;

import java.util.List;

/**
  * ����: �澯����ģ�����������ӿ�
  * ��������: �澯����ģ�����������ӿ�
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public interface Mss00004SearchCond {
	
	/**
	 * ����ģ��idȡ��
	 */
	public Integer getRuletempid();
	/**
	 * ����ģ������ȡ��
	 * @���� zhaoyong
	 */
	public String getRuletempname();
	/**
	 * ģ��״̬ȡ��
	 * @���� zhaoyong
	 */
	public Integer getTempstate();
	/**
	 * ɾ��idȡ��
	 * @���� zhaoyong
	 */
	public String[] getDeleteId();
	
	/**
	 * �豸����ȡ��
	 */
	public String getTypeid();
	
	/**
	 * ��������ȡ��
	 */
	public Integer getRulecondition();
	
	/**
	 * ����ʱ��ȡ��
	 */
	public String getCreatetime();
	
	/**
	 * ����ȡ��
	 */
	public String getTempdesc();
	
	/**
	 * ģ��״̬ȡ��
	 * @���� zhaoyong
	 */
	public Integer getTempstates();
	
	/**
	 * ģ��ID�б�
	 * @return
	 */
	public List<Integer> getTempidList();
	
	/**
	 * ����
	 * @return
	 */
	public String getSummary();
}