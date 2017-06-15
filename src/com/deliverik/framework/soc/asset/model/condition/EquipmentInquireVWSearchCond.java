/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.condition;

/**
 * ����:3D����֧��IP��ѯ 
 * ����������3D����֧��IP��ѯ
 * �����ˣ�����͢
 * ������¼�� 2013-01-31
 * �޸ļ�¼��
 */
public interface EquipmentInquireVWSearchCond {

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
	 *��������ȡ��
	 * @return ��������
	 */
	public String getComputerContainer();
	
	/**
	 *��������Idȡ��
	 * @return ��������Id
	 */
	public Integer getComputerContainerId();
	
    /**
     * �豸����ȡ��
     *
     * @return einame �豸����
     */
    public String getEiname();

    /**
     * �豸���ȡ��
     *
     * @return eilabel �豸���
     */
    public String getEilabel();
}
