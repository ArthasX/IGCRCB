/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.model;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ȹ���ͳ�ƽӿ�
 * </p>
 * 
 */
public interface IGCRC2401VWInfo {
	
	public String getUserId();
	
	public String getMainId();

	public String getUserName();
	
	public String getStartTime();
	
	public String getEndTime();
	
	public String getGrade();
	
	public String getConfirmtime();
	/**
	 * ����������ȡ
	 * @return the prid
	 */
	public Integer getPrid();
}
