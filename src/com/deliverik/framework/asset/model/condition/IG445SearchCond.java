package com.deliverik.framework.asset.model.condition;

/**
 * <p>
 * �豸ͳ�Ʒ�����Ϣ��ѯ������ƽ̨������
 * </p>
 * <p>
 * (δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>ciupdtime_from</td>
 * <td>�ʲ��Ǽǿ�ʼʱ�䣨���ڵ��ڣ�</td>
 * </tr>
 * <tr>
 * <td>ciupdtime_to</td>
 * <td>�ʲ��Ǽǽ�ֹʱ�䣨С�ڵ��ڣ�</td>
 * </tr> 
 * <tr>
 * <td>eid</td>
 * <td>�ʲ�ģ��ID</td>
 * </tr> 
 * <tr>
 * <td>eiorgsyscoding_q</td>
 * <td>�ʲ�������������루ǰ��һ��ģ��ƥ�䣩</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface IG445SearchCond {
	
	/** �ʲ��Ǽǿ�ʼʱ��*/
	public String getCiupdtime_from();
	
	/** �ʲ��Ǽǽ�ֹʱ��*/
	public String getCiupdtime_to();
	
	/** �ʲ�ģ��ID*/
	public String getEid();
	
	/** �ʲ��������������*/
	public String getEiorgsyscoding_q();
	
}
