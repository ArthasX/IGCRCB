/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �¼�ƽ������¼�ͳ��ʵ��ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IncidentAveSolveTimeVWInfo {

	/**
	 * �¼�����ȡ��
	 * @return itype �¼�����
	 */
	public String getItype();

	/**
	 * ƽ������¼�ȡ��
	 * @return solveTime ƽ������¼�
	 */
	public String getSolveTime();
}
