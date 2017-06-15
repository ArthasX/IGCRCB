/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.crc.report.xml;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������̶�ӦXML�ļ����ƹ�����ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface XMLFileManager {
	
	/**
	 * ��ʼ��
	 */
	public void init();

	/**
	 * ȡ��XML�ļ�����
	 * @param pdid ���̶���ID
	 * @return XML�ļ�����
	 */
	public String getFileName(String pdid);
	
	/**
	 * ȡ��XML�ļ�Ŀ¼
	 * @param pdid ���̶���ID
	 * @return �ļ�Ŀ¼
	 */
	public String getDir(String pdid);
}
