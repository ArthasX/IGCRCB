/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_����ˮƽ��Ϣ��ѯMODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface SdlInfoSearchCond {
	
	/**
	 * ��ȡ���
	 * 
	 * @return ���
	 */
	public String getSitype();

	/**
	 * ��ȡ��ʼʱ��
	 * 
	 * @return ��ʼʱ��
	 */
	public String getSibegin();
	
	/**
	 * ��ȡ����ʱ��
	 * 
	 * @return ����ʱ��
	 */
	public String getSiend();

	/**
	 * ��ȡ����ʲ�ID
	 * 
	 * @return ����ʲ�ID
	 */
	public Integer getSieiid();

	/**
	 * ��ȡ�������ID
	 * 
	 * @return �������ID
	 */
	public Integer getSiprid();
	
	/**
	 * ��ȡ����
	 * 
	 * @return ����
	 */
	public String getSimark();

}
