package com.deliverik.infogovernor.prj.model.condition;

/**
 * ����: projectlog����������ӿ�
 * ��������: projectlog����������ӿ�
 * ������¼: 2012/04/19
 * �޸ļ�¼: 
 */
public interface ProjectLogSearchCond {

	public abstract Integer getPid();	
	/**��־����*/
	public String getPlinfo();
	/**��־����*/
	public String getPltype();
	/**��־��ʼʱ��*/
	public String getPltime_from();
	/**��־����ʱ��*/
	public String getPltime_to();
	/**��־���Ͳ�Ϊ��*/
	public String getPltype_ne();
	

}