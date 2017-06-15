package com.deliverik.framework.workflow.prr.model.condition;

import java.util.List;

/**
 * <p>
 * ���̲����û���Ϣ��������
 * </p>
 * <p>
 * ��δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>prid</td>
 * <td>���̼�¼ID</td>
 * </tr>
 * <tr>
 * <td>pproleid</td>
 * <td>���̲����û���ɫID</td>
 * </tr>
 * <tr>
 * <td>ppuserid</td>
 * <td>���̲����û�ID</td>
 * </tr>
 * <tr>
 * <td>ppinittime</td>
 * <td>���̲����û�ָ��ʱ��</td>
 * </tr>
 * <tr>
 * <td>ppproctime</td>
 * <td>���̲����û��������ʱ��</td>
 * </tr>
 * <tr>
 * <td>ppstatus_q</td>
 * <td>���̲����û��Ĳ���״̬</td>
 * </tr>
 * <tr>
 * <td>ppsubstatus</td>
 * <td>���̲����û���״̬</td>
 * </tr>
 * <tr>
 * <td>ppuserinfo</td>
 * <td>���̲����û���Ϣ</td>
 * </tr>
 * <tr>
 * <td>ppuseridIsNull</td>
 * <td>���̲����û��жϱ�ʶ��Y�ж����̲����û��Ƿ�Ϊ�գ�N�ж����̲����û��Ƿ�Ϊ�գ�</td>
 * </tr>
 * <tr>
 * <td>ppproctimeIsNull</td>
 * <td>���̲����û�������ɱ�ʶ��Y�ж����̲����û��������ʱ���Ƿ�Ϊ�գ�N�ж����̲����û��������ʱ���Ƿ�Ϊ�գ�</td>
 * </tr>
 * <tr>
 * <td>ppidInList</td>
 * <td>���̲����û���ϢID��������������������̲����û���ϢID���ڸ������е����̲����û���Ϣ��</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG337SearchCond {
	
	

	/**
	 * ���̼�¼IDȡ��
	 * @return ���̼�¼ID
	 */
	public Integer getPrid();

	/**
	 * ���̲����û���ɫIDȡ��
	 * @return ���̲����û���ɫID
	 */
	public Integer getPproleid();

	/**
	 * ���̲����û�IDȡ��
	 * @return ���̲����û�ID
	 */
	public String getPpuserid();

	/**
	 * ���̲����û�ָ��ʱ��ȡ��
	 * @return ���̲����û�ָ��ʱ��
	 */
	public String getPpinittime();

	/**
	 * ���̲����û��������ʱ��ȡ��
	 * @return ���̲����û��������ʱ��
	 */
	public String getPpproctime();

	/**
	 * ���̲����û��Ĳ���״̬ȡ��
	 * @return ���̲����û��Ĳ���״̬
	 */
	public String getPpstatus_q();
	

	/**
	 * ���̲����û���״̬ȡ��
	 * @return ���̲����û���״̬
	 */
	public String getPpsubstatus();

	/**
	 * ���̲����û���Ϣȡ��
	 * @return ���̲����û���Ϣ
	 */
	public String getPpuserinfo();
	
	/**
	 * ���̲����û��жϱ�ʶ��Y�ж����̲����û��Ƿ�Ϊ�գ�N�ж����̲����û��Ƿ�Ϊ�գ�ȡ��
	 * @return ���̲����û��жϱ�ʶ
	 */
	public String getPpuseridIsNull();
	
	/**
	 * ���̲����û���ϢID�����������ȡ��
	 * @return ���̲����û���ϢID�����������
	 */
	public List<Integer> getPpidInList();
	
	/**
	 * ���̲����û�������ɱ�ʶ��Y�ж����̲����û��������ʱ���Ƿ�Ϊ�գ�N�ж����̲����û��������ʱ���Ƿ�Ϊ�գ�ȡ��
	 * @return ���̲����û�������ɱ�ʶ
	 */
	public String getPpproctimeIsNull();
	
	/**
	 * ���̲����û��Ĳ���״̬ȡ�ã�ƽ̨������
	 * @return ���̲����û��Ĳ���״̬
	 */
	public String getPpstatus();
	
	/**
	 * ���̵����в������Ƿ���ָ���û���������ȡ�ã�ƽ̨������
	 * @return ���̵����в������Ƿ���ָ���û���������
	 */
	public String getPpuserid_not();

	//====>130225Begin
	
	/**
	 * ����������������ȷ��ѯȡ��
	 *
	 * @return pporgid_eq ����������������ȷ��ѯ
	 */
	public String getPporgid_eq();
	//====>130225End

	/**
	 * ����״̬����IDȡ��
	 * @return ����״̬����ID
	 */
	public String getPsdid();

	/**
	 * ��̬��֧���ȡ��
	 * @return ��̬��֧���
	 */
	public Integer getPsdnum();
	
	/**
	 * �Ƿ��Ѿ�ȷ�ϣ�1��null��0����ֵ��ȡ��
	 * @return the ppbacktime_isNull
	 */
	public String getPpbacktime_isNull();
}
