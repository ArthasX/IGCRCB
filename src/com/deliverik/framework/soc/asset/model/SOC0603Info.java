package com.deliverik.framework.soc.asset.model;

import java.io.Serializable;

/**
 * ������Ϣ
 * 
 */
public interface SOC0603Info extends Serializable {

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getEiid();

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid();

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getEiname();
	
	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getEilabel();

	/**
	 * ����˵��ȡ��
	 * @return ����˵��
	 */
	public String getEidesc();

	/**
	 * ����汾��ȡ��
	 * @return ����汾��
	 */
	public Integer getEiversion();

	/**
	 * �Ǽ���ȡ��
	 * @return �Ǽ���
	 */
	public String getEiinsdate();

	/**
	 * ����λ�ã�X��ȡ��
	 * @return ����λ�ã�X��
	 */
	public String getX_value();

	/**
	 * ����λ�ã�Y��ȡ��
	 * @return ����λ�ã�Y��
	 */
	public String getY_value();

	/**
	 * ����߶ȣ�U��ȡ��
	 * @return ����߶ȣ�U��
	 */
	public String getU_total();

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getX_width();

	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public String getY_width();

	/**
	 * ��������IDȡ��
	 * @return ��������ID
	 */
	public Integer getRoom_eiid();

	/**
	 * �����������ȡ��
	 * @return �����������
	 */
	public String getRoom_eilabel();

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getRoom_einame();

	/**
	 * ������ʾͼ�ã���ȡ��
	 * 
	 * @return ��
	 */
	public String getGraphindex();
	
	/**
	 * ������ʾͼ�ã��Ƿ�������ȡ��
	 * 
	 * @return �Ƿ�������
	 */
	public String getGraphstatus();

	/**
	 * ������ʾͼ�ã���������ȡ��
	 * 
	 * @return ��������
	 */
	public String getGraphtypeid();

	/**
	 * ������ʾͼ�ã����ͱ�ʶȡ��
	 * 
	 * @return ���ͱ�ʶ
	 */
	public String getGraphtypename();

	/**
	 * ���ѹȡ��
	 * 
	 * @return ���ѹ
	 */
	public String getVoltage();

	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getWeight();

	/**
	 * ������ȡ��
	 * 
	 * @return ������
	 */
	public String getStandard();
	
	/**
	 * ������λ��ȡ��
	 * 
	 * @return ������λ��
	 */
	public String getU_value();
	
	/**
	 * �ʲ����ͣ��յ�����������ʽ��ʽ��ȡ��
	 * 
	 * @return �ʲ����ͣ��յ�����������ʽ��ʽ��
	 */
	public String getEitype();

	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getContainertype();
	
	/**
	 * ���ܺ���U��ȡ��
	 * 
	 * @return ���ܺ���U��
	 */
	public String getWidth();
	
	 /**
     * �����ȡ��
     *
     * @return maxload �����
     */
    public String getMaxload();

    /**
     * ������ȡ��
     *
     * @return maxpower ������
     */
    public String getMaxpower();

    /**
     * ʣ��U��ȡ��
     *
     * @return u_last ʣ��U��
     */
    public Integer getU_last();

    /**
     * ʣ�๦��ȡ��
     *
     * @return power_last ʣ�๦��
     */
    public Integer getPower_last();

    /**
     * ʣ������ȡ��
     *
     * @return load_last ʣ������
     */
    public Integer getLoad_last();

}