/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.igflow.resultset;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������ʲ�ʵ��ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ProcessInfoEntityInfo {

	/**
	 * �ʲ�IDȡ��
	 * @return eiid �ʲ�ID
	 */
	public Integer getEiid();

	/**
	 * �ʲ��汾��ȡ��
	 * @return eiversion �ʲ��汾��
	 */
	public Integer getEiversion();
	
	/**
	 * �ʲ�����ȡ��
	 * @return einame �ʲ�����
	 */
	public String getEiname();
	
	public String getFingerPrint();
	
}
