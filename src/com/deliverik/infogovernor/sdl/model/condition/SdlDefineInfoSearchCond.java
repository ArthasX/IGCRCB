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
 * Description: �������_����ˮƽ����_����ˮƽ��׼��ѯMODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public interface SdlDefineInfoSearchCond {
	/**
	 * ��ȡ���
	 * @return ���
	 */
	public String getSdiyear();

	/**
	 * ��ȡ����ʲ�ID
	 * @return ����ʲ�ID
	 */
	public Integer getSdieiid();

	/**
	 * ��ȡ�ʲ�����
	 * @return �ʲ�����
	 */
	public String getSdieiname();

}
