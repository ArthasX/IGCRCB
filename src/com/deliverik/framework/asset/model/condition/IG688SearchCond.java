package com.deliverik.framework.asset.model.condition;

import java.util.List;

/**
 * <p>
 * �ʲ���Ϣ��������
 * </p>
 * <p>
 * (δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>elabel</td>
 * <td>�ʲ�ģ�ͱ��</td>
 * </tr>
 * <tr>
 * <td>eilabel</td>
 * <td>�ʲ����</td>
 * </tr> 
 * <tr>
 * <td>einame</td>
 * <td>�ʲ����ƣ�ģ��ƥ�䣩</td>
 * </tr> 
 * <tr>
 * <td>ecategory</td>
 * <td>�ʲ�ģ�ͷ���</td>
 * </tr> 
 * <tr>
 * <td>eiupdtime_from</td>
 * <td>�ʲ����¿�ʼʱ�䣨���ڵ��ڣ�</td>
 * </tr> 
 * <tr>
 * <td>eiupdtime_to</td>
 * <td>�ʲ����½�ֹʱ�䣨С�ڵ��ڣ�</td>
 * </tr>
 * <tr>
 * <td>eiorgcode</td>
 * <td>�ʲ�������������루ǰ��һ��ģ��ƥ�䣩</td>
 * </tr> 
 * <tr>
 * <td>esyscoding</td>
 * <td>�ʲ�ģ�Ͳ���루ǰ��һ��ģ��ƥ�䣩</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface IG688SearchCond {
	
	/**
	 * �ʲ�ģ�ͱ��ȡ��
	 * @return �ʲ�ģ�ͱ��
	 */
	public String getElabel();

	/**
	 * �ʲ�ģ������ȡ�ã�ƽ̨������
	 * @return �ʲ�ģ������
	 */
	public String getEname();

	/**
	 * �ʲ����ȡ��
	 * @return �ʲ����
	 */
	public String getEilabel();
	
	/**
	 * �ʲ�����ȡ��
	 * @return �ʲ�����
	 */
	public String getEiname();

	/**
	 * �ʲ�ģ�ͷ���ȡ��
	 * @return �ʲ�ģ�ͷ���
	 */
	public String getEcategory();
	
	/**
	 * �ʲ�ģ��һ������ȡ�ã�ƽ̨������
	 * @return �ʲ�ģ��һ������
	 */
	public String getEkey1();
	
	/**
	 * �ʲ�ģ�Ͷ�������ȡ�ã�ƽ̨������
	 * @return �ʲ�ģ�Ͷ�������
	 */
	public String getEkey2();

	/**
	 * �ʲ����¿�ʼʱ��ȡ��
	 * @return �ʲ����¿�ʼʱ��FROM
	 */
	public String getEiupdtime_from();

	/**
	 * �ʲ����½�ֹʱ��ȡ��
	 * @return �ʲ����½�ֹʱ��
	 */
	public String getEiupdtime_to();

	/**
	 * �ʲ��������Ƽ�����������ȡ�ã�ƽ̨������
	 * @return �ʲ��������Ƽ�����������
	 */
	public String[] getCname();

	/**
	 * �ʲ�����ֵ������������ȡ�ã�ƽ̨������
	 * @return �ʲ�����ֵ������������
	 */
	public String[] getCivalue();

	/**
	 * �ʲ���ͨ���Ա�ż�����������ȡ�ã�ƽ̨������
	 * @return �ʲ���ͨ���Ա�ż�����������
	 */
	public String[] getCclabel();

	/**
	 * �ʲ���ͨ����ֵ������������ȡ�ã�ƽ̨������
	 * @return �ʲ���ͨ����ֵ������������
	 */
	public String[] getCcivalue();
	
	/**
	 * �ʲ��������������ȡ��
	 * @return �ʲ��������������
	 */
	public String getEiorgcode();
	
	/**
	 * �ʲ��������������ȡ��
	 * @return �ʲ��������������
	 */
	public String getEiorgsyscoding();
	
	/**
	 * �ʲ��������������ȡ��
	 * @return �ʲ��������������
	 */
	public String getEiorgsyscoding_q();
	
	/**
	 * �ʲ�״̬ȡ�ã�ƽ̨������
	 * @return �ʲ�״̬
	 */
	public String getEistatus_q();

	/**
	 * �ʲ�״̬ȡ�ã�ƽ̨������
	 * @return �ʲ�״̬
	 */
	public String getEistatus();
	
	/**
	 * �ʲ�ģ�Ͳ�����
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getEsyscoding();
	
	/**
	 * �ʲ�ID����ȡ�ã�ƽ̨������
	 * @return �ʲ�ID����
	 */
	public List<String> getEiidList();
	
	/**
	 * �ʲ�ʹ�û���codeȡ��
	 * @return �ʲ�ʹ�û���code
	 */
	public String getUsesyscoding();
	
	/** 
	 * ά����ʼ����ȡ�� 
	 * @return ά����ʼ����
	 */
	 public String getWbdate_from();
	 
	 /**
	  * ά����������ȡ�� 
	  * @return ά����������
	  */
	 public String getWbdate_to();
	 
	 /**
	 * �ʲ�ģ��״̬ȡ��
	 * 
	 * @return �ʲ�ģ��״̬
	 */
	public String getEstatus();
	
	/**
	 * �ʲ�ģ�����ȡ��
	 * 
	 * @return �ʲ�ģ�����0��һ���ʲ�ģ�� 1�������ʲ�ģ�ͣ�
	 */
	public String getEmodeltype_eq();
	
	/**
	 * �ʲ�����ģ����ѯ
	 * @return
	 */
	public String getEidesc_like();

    /**
     * �Ƿ��ѯ��Ʊ��־
     * @return
     */
    public String getQueryflag();
	
}
