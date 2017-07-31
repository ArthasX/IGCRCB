/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model.condition;

/**
  * ����: ������־�����������ӿ�
  * ��������: ������־���������ӿ�
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public interface WorkLogSearchCond {

	/**
		/**
	 * ȡ�� ����
	 * 
	 * @return wlid
	*/
	public Integer getPK() ;
	

	/**
	 * ȡ�� ����
	 * 
	 * @return wlid
	*/
	public Integer getWlid() ;
	

	/**
	 * ȡ�� ����ʵ��������
	 * 
	 * @return wiid
	*/
	public Integer getWiid() ;
	

	/**
	 * ȡ�� ִ����
	 * 
	 * @return excutorId
	*/
	public String getExcutorId();
	

	/**
	 * ȡ�� ִ��������
	 * 
	 * @return excutorName
	*/
	public String getExcutorName() ;
	

	/**
	 * ȡ�� ����������
	 * 
	 * @return titleDate
	*/
	public String getTitleDate() ;
	

	/**
	 * ȡ�� ִ��ʱ�䣨Сʱ��
	 * 
	 * @return excuteTime
	*/
	public String getExcuteTime() ;

	/**
	 * ȡ�� ʵ�ʴ�������
	 * 
	 * @return actualDealwithDate
	*/
	public String getActualDealwithDate();
	

	/**
	 * ȡ�� ִ���������
	 * 
	 * @return wlDescription
	*/
	public String getWlDescription() ;
	

	/**
	 * ȡ�� ���¼��������
	 * 
	 * @return crtDate
	*/
	public String getCrtDate();
	

	/**
	 * ȡ�� ʱ���
	 * 
	 * @return fingerprint
	*/
	public String getFingerprint() ;
	

	/**
	 * ȡ�� ��ť����
	 * 
	 * @return btnAction
	*/
	public String getBtnAction();
}