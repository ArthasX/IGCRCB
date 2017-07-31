/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ����ʵ���ӿ�
  * ��������: ����ʵ���ӿ�
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public interface WorkInstanceInfo extends BaseModel {

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
	
}