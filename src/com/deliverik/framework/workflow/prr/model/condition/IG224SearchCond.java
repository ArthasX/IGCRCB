/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>
 * ����״̬��־��������
 * </p>
 * <p>
 * ��δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>prid</td>
 * <td>����ID</td>
 * </tr>
 * <tr>
 * <td>currentPrstatus</td>
 * <td>�Ƿ��ѯ���̵�ǰ״̬��¼��ʶ</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG224SearchCond {

	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getPrid();
	
	/**
	 * �Ƿ��ѯ���̵�ǰ״̬��¼��ʶȡ��
	 * 
	 * @return �Ƿ��ѯ���̵�ǰ״̬��¼��ʶ
	 */
	public boolean isCurrentPrstatus();

	/**
	 * ����״̬NOTȡ��
	 * @return ����״̬NOT
	 */
	public String getPrstatus_ne();
	
	/**
	 * ����״̬��ȡ
	 * @return ����״̬��ȡ
	 */
	public String getPrstatus();

	/**
	 * ����״̬����IDȡ��
	 * @return ����״̬����ID
	 */
	public String getPsdid();
	

	/**
	 * �ϼ�����״̬����IDȡ��
	 * @return �ϼ�����״̬����ID
	 */
	public String getPpsdid();
	

	/**
	 * ����ڵ�״̬ȡ��
	 * @return ����ڵ�״̬
	 */
	public String getVirtualstatus();
	

	/**
	 * ��̬��֧���ȡ��
	 * @return ��̬��֧���
	 */
	public Integer getPsdnum();

	/**
	 * ��ǰ״̬ȡ��
	 * @return ��ǰ״̬
	 */
	public String getNowstatus();

	/**
	 * �Ƿ����ȡ��
	 * @return �Ƿ����
	 */
	public boolean isPend();
}
