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
 * Description: �������_����ˮƽ����_����ˮƽͳ�Ʋ�ѯMODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public interface SdlYearSummarySearchCond {
	/**
	 * ��ȡ���
	 * @return ���
	 */
	public String getYear();

	/**
	 * ��ȡ����ʲ�ID
	 * @return ����ʲ�ID
	 */
	public Integer getEiid();

	/**
	 * ��ȡ�ʲ�����
	 * @return �ʲ�����
	 */
	public String getEiname();

}
