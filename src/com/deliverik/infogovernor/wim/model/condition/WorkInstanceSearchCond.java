/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model.condition;

/**
  * ����: ����ʵ�����������ӿ�
  * ��������: ����ʵ�����������ӿ�
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public interface WorkInstanceSearchCond {

	/**
	 * ȡ�� ����
	 * 
	 * @return wiid
	*/
	public Integer getPK() ;

	/**
	 * ȡ�� ����
	 * 
	 * @return wiid
	*/
	public Integer getWiid() ;
	

	/**
	 * ȡ�� �������������
	 * 
	 * @return wdid
	*/
	public Integer getWdid() ;
	

	/**
	 * ȡ�� ����������
	 * 
	 * @return wdname
	*/
	public String getWdname() ;
	

	/**
	 * ȡ�� ����ʵ������
	 * 
	 * @return winame
	*/
	public String getWiname();
	

	/**
	 * ȡ�� ����״̬��0��δִ�У�1��ִ���У�2����ִ�У�3��������4����ֹ����
	 * 
	 * @return wistatus
	*/
	public String getWistatus() ;
	

	/**
	 * ȡ�� �����ˣ�userid��
	 * 
	 * @return initiatorId
	*/
	public String getInitiatorId() ;

	/**
	 * ȡ�� ����Ƶ��
	 * 
	 * @return cycle
	*/
	public String getCycle() ;
	

	/**
	 * ȡ�� ����������
	 * 
	 * @return description
	*/
	public String getDescription() ;
	

	/**
	 * ȡ�� ��ʼ����
	 * 
	 * @return beginDate
	*/
	public String getBeginDate() ;
	

	/**
	 * ȡ�� ������
	 * 
	 * @return leaderId
	*/
	public String getLeaderId();
	

	/**
	 * ȡ�� ����������
	 * 
	 * @return leaderName
	*/
	public String getLeaderName() ;
	

	/**
	 * ȡ�� ִ����
	 * 
	 * @return excutorId
	*/
	public String getExcutorId() ;
	

	/**
	 * ȡ�� ִ��������
	 * 
	 * @return excutorName
	*/
	public String getExcutorName() ;
	

	/**
	 * ȡ�� �������ͣ�1���Զ�����2���ֶ�����
	 * 
	 * @return wiLunchType
	*/
	public String getWiLunchType();
	

	/**
	 * ȡ�� ִ������ʱ�䣨Сʱ��
	 * 
	 * @return excuteTime
	*/
	public String getExcuteTime() ;
	

	/**
	 * ȡ�� ִ���������
	 * 
	 * @return wiDescription
	*/
	public String getWiDescription() ;
	

	/**
	 * ȡ�� ����ȷ������
	 * 
	 * @return confirmDate
	*/
	public String getConfirmDate() ;
	

	/**
	 * ȡ�� ����������
	 * 
	 * @return titleDate
	*/
	public String getTitleDate() ;
	

	/**
	 * ȡ�� ���¼��������
	 * 
	 * @return crtDate
	*/
	public String getCrtDate() ;
	

	/**
	 * ȡ�� ʱ���
	 * 
	 * @return fingerPrint
	*/
	public String getFingerPrint();
	
	/**
	 * @return the ����ʱ��
	 */
	public String getWorkDate() ;
	

	/**
	 * @return the ����
	 */
	public String getOrgsyscoding() ;
	

	/**
	 * @return the ��Ա
	 */
	public String getUserid();
	

	/**
	 * @return the ������ʼ���ڴ�
	 */
	public String getBegindate_from();


	/**
	 * @return the ������ʼ���ڵ�
	 */
	public String getBegindate_to();

}