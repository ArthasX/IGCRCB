package com.deliverik.framework.asset.model.condition;

/**
 * <p>
 * �ʲ���ϵ��Ϣ��������
 * </p>
 * <p>
 * (δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>eiid</td>
 * <td>��������������ʲ�ID</td>
 * </tr>
 * <tr>
 * <td>pareiid</td>
 * <td>��������ʲ�ID</td>
 * </tr> 
 * <tr>
 * <td>cldeiid</td>
 * <td>��������ʲ�ID</td>
 * </tr> 
 * <tr>
 * <td>parversion</td>
 * <td>�����ʲ���汾</td>
 * </tr> 
 * <tr>
 * <td>parsmallversion</td>
 * <td>�����ʲ�С�汾</td>
 * </tr> 
 * <tr>
 * <td>cldversion</td>
 * <td>�����ʲ���汾</td>
 * </tr> 
 * <tr>
 * <td>cldsmallversion</td>
 * <td>�����ʲ�С�汾</td>
 * </tr> 
 * <tr>
 * <td>deleteflag</td>
 * <td>�߼�ɾ����ʶ</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface IG313SearchCond {

	/**
	 * �ʲ�ID�����������⣩ȡ��
	 * @return �ʲ�ID�����������⣩
	 */
	public Integer getEiid();
	
	/**
	 * �ʲ�ID������ȡ��
	 * @return �ʲ�ID������
	 */
	public Integer getPareiid();
	
	/**
	 * �ʲ�ID������ȡ��
	 * @return �ʲ�ID������
	 */
	public Integer getCldeiid();
	
	/**
	 * �ʲ���ϵIDȡ�ã�ƽ̨������
	 * @return �ʲ���ϵID
	 */
	public String getEirrelation();
	
	/**
	 * �ʲ���ϵ�Ƿ����ɾ����ʶ��"C"��ʶ����ɾ����ȡ�ã�ƽ̨������
	 * @return �ʲ���ϵ�Ƿ����ɾ����ʶ
	 */
	public String getEirstatus();
	
	/**
	 * �ʲ���ϵ˵��ȡ�ã�ƽ̨������
	 * @return �ʲ���ϵ˵��
	 */
	public String getEirdesc();
	
	/**
	 * ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣȡ�ã�ƽ̨������
	 * @return ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣ
	 */
	public String getEirinfo();
	
	/**
	 * �����ʲ���汾ȡ��
	 * @return �����ʲ���汾
	 */
	public Integer getParversion();
	
	/**
	 * �����ʲ�С�汾ȡ��
	 * @return �����ʲ�С�汾
	 */
	public Integer getParsmallversion();
	
	/**
	 * �����ʲ���汾ȡ��
	 * @return �����ʲ���汾
	 */
	public Integer getCldversion();

	/**
	 * �����ʲ�С�汾ȡ��
	 * @return �����ʲ�С�汾
	 */
	public Integer getCldsmallversion();

	/**
	 * �߼�ɾ����ʶȡ��
	 * @return �߼�ɾ����ʶ
	 */
	public String getDeleteflag();
	
	/**
	 * �ʲ���汾�����������⣩ȡ��
	 * 
	 * @return �ʲ���汾�����������⣩
	 */
	public String getEiversion();

	/**
	 * �ʲ�С�汾�����������⣩
	 * 
	 * @return �ʲ�С�汾�����������⣩
	 */
	public String getEismallversion();
	
	/**
	 * �ʲ�ģ��ID������ȡ��
	 * @return �ʲ�ģ��ID������
	 */
	public Integer getCldeid();
	
	/**
	 * �ʲ�ģ��ID������ȡ��
	 * @return �ʲ�ģ��ID������
	 */
	public Integer getPareid();
	
	/**
	 * ��ϵ��ȡ��
	 * @return ��ϵ��
	 */
	public String getEirrelationcode();
}
