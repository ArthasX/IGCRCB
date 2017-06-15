package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * ����ģ����Ϣ��������
 * </p>
 * <p>
 * ��δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>ptid</td>
 * <td>����ģ��ID</td>
 * </tr>
 * <tr>
 * <td>ptname</td>
 * <td>����ģ������</td>
 * </tr>
 * <tr>
 * <td>pttype</td>
 * <td>����ģ������</td>
 * </tr>
 * <tr>
 * <td>ptstatus</td>
 * <td>����ģ��״̬��a:���ã�i:ͣ�ã�</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG259SearchCond {
	
	/**
	 * ����ģ��IDȡ��
	 * @return ����ģ��ID
	 */
	public Integer getPtid();

	/**
	 * ����ģ������ȡ��
	 * @return ����ģ������
	 */
	public String getPtname();

	/**
	 * ����ģ������ȡ��
	 * @return ����ģ������
	 */
	public String getPttype();
	/**
	 * ����ģ��״̬��a���ã�iͣ�ã�ȡ��
	 * @return ����ģ��״̬
	 */
	public String getPtstatus();

	/**
	 * ����ģ��ʹ��λ�ñ�ʶ��ƽ̨������ȡ��
	 * @return ����ģ��ʹ��λ�ñ�ʶ
	 */
	public String getPtqrtzflag();
	
	/**
	 * ����ģ�������Ƿ�Ϊ������ƽ̨������ȡ��
	 * @return ����ģ�������Ƿ�Ϊ����
	 */
	public int getIsWorkPt();
	
	/**
	 * ����״̬����
	 * @return ����״̬����
	 */
	public String[] getPtstatuses();


}
