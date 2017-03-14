/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model;

/**
 * ����:3D����֧��IP��ѯ 
 * ����������3D����֧��IP��ѯ 
 * �����ˣ�����͢
 * ������¼�� 2013-01-31
 * �޸ļ�¼��
 */
public interface EquipmentInquireVWInfo {
	
	/**
	 *�豸����ȡ��
	 * @return �豸����
	 */
	public Integer getEiid();
	/**
	 *��������ȡ��
	 * @return ��������
	 */
	public String getEname() ;
	
	/**
	 *�豸����ȡ��
	 * @return �豸����
	 */
	public String getEiname();
	
	/**
	 *ҵ��ϵͳȡ��
	 * @return ҵ��ϵͳ
	 */
	public String getBusinesssys();
	
	/**
	 *IP��ַȡ��
	 * @return IP��ַ
	 */
	public String getIp();
	
	/**
	 *�ͺ�ȡ��
	 * @return �ͺ�
	 */
	public String getPattern();
	
	/**
	 *������λ��ȡ��
	 * @return ������λ��
	 */
	public String getSite();
	
	/**
	 *��������ȡ��
	 * @return ��������
	 */
	public String getComputerContainer();
	
	/**
	 *��������ȡ��
	 * @return ��������
	 */
	public String getComputerroom();
	
	/**
	 * ��������Idȡ��
	 *
	 * @param computerContainerId ��������Id
	 */
	public Integer getComputerContainerId();
	
	 /**
     * �豸���ȡ��
     *
     * @return eilabel �豸���
     */
    public String getEilabel();
    /**
     * ��������Idȡ��
     *
     * @return computerroomId ��������Id
     */
    public Integer getComputerroomId();
}
