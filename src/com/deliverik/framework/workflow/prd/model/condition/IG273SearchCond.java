/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * ����״̬ԾǨ�����������
 * </p>
 * <p>
 * ��δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>ptdname</td>
 * <td>����״̬ԾǨ��������</td>
 * </tr>
 * <tr>
 * <td>ptdtype</td>
 * <td>����״̬ԾǨ��������</td>
 * </tr>
 * <tr>
 * <td>ptdcond</td>
 * <td>����״̬ԾǨ����</td>
 * </tr>
 * <tr>
 * <td>ptdcond_like</td>
 * <td>����״̬ԾǨ������ģ��ƥ�䣩</td>
 * </tr>
 * <tr>
 * <td>fpsdid</td>
 * <td>����״̬ID��From��</td>
 * </tr>
 * <tr>
 * <td>tpsdid</td>
 * <td>����״̬ID��To��</td>
 * </tr>
 * <tr>
 * <td>defaultRule</td>
 * <td>����״̬ȱʡԾǨ����</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG273SearchCond {
	/**
	 * ����״̬ԾǨ����IDȡ��
	 * @return ����״̬ԾǨ����ID
	 */
	public String getPtdid();
	
	/**
	 * ����״̬ID��From��ȡ��
	 * @return ����״̬ID��From��
	 */
	public String getFpsdid();
	
	/**
	 * ����״̬ID��To��ȡ��
	 * @return ����״̬ID��To��
	 */
	public String getTpsdid();

	/**
	 * ����״̬ԾǨ��������ȡ��
	 * @return ����״̬ԾǨ��������
	 */
	public String getPtdname();
	
	/**
	 * ����״̬ԾǨ��������ȡ��
	 * @return ����״̬ԾǨ��������
	 */
	public String getPtdtype();
	
	/**
	 * ����״̬ԾǨ����ȡ��
	 * @return ����״̬ԾǨ����
	 */
	public String getPtdcond();
	
	/**
	 * ����״̬ԾǨ������ģ��ƥ�䣩ȡ��
	 * @return ����״̬ԾǨ����
	 */
	public String getPtdcond_like();
	
	/**
	 * ����״̬ȱʡԾǨ����ȡ��
	 * @return ����״̬ȱʡԾǨ����
	 */
	public boolean isDefaultRule();
	
	/**
	 * ����״̬��ȱʡԾǨ����ȡ��
	 * @return ����״̬��ȱʡԾǨ����
	 */
	public boolean isNotDefaultRule();

	/**
	 * ���̲����߱���Ȩ��IDȡ��
	 * 
	 * @return ���̲����߱���Ȩ��ID
	 */
	public String getPtdid_like();
	
}
