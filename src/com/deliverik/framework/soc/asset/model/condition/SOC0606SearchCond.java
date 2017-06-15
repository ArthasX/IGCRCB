/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
 * <p>
 * �ʲ�������Ϣ��������
 * </p>
 * <p>
 * <br>
 * <table border="1">
 * <tr>
 * <td>eiid</td>
 * <td>�ʲ�ID</td>
 * </tr> 
 * <tr>
 * <td>cname</td>
 * <td>�ʲ�ģ���������ƣ�ģ��ƥ�䣩</td>
 * </tr> 
 * <tr>
 * <td>esyscoding_q</td>
 * <td>�ʲ�ģ�Ͳ���루���ݲ����ȡ�ø��ʲ�����̳еõ��������ʲ�������Ϣ��</td>
 * </tr> 
 * </table>
 * </p>
 */
public interface SOC0606SearchCond {

	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public String getEiid();
	
	/**
	 * �ʲ�ģ�����������趨
	 *
	 * @param cname �ʲ�ģ����������
	 */
	public String getCname();
	
	/**
	 * �ʲ�ģ�Ͳ����ȡ��
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getEsyscoding_q();
	
	/**
	 * �ʲ�ģ�Ͳ����ȡ�ã�SOC��
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getClabel_q();
	
	/**
	 * �ʲ�ID���ϣ�SOC��
	 * @return �ʲ�ID���ϣ�SOC��
	 */
	public List<Integer> getEiid_list();
	
	public String getSreilabel_q();
	
	public String getSrname_q();
	
	/**
	 * �ʲ�ģ��idȡ��
	 *
	 * @return eid_q �ʲ�ģ��id
	 */
	
	public String getEid_q();
	
	public String getCiversion();
}
