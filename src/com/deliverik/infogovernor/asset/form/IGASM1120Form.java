/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����:3D����֧��IP��ѯ 
 * ����������3D����֧��IP��ѯ
 * �����ˣ�����͢
 * ������¼�� 2013-02-01
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGASM1120Form extends BaseForm {
	
	/**ҵ��ϵͳ*/
	protected String businesssys;
	
	/**IP��ַ*/
	protected String ip;

    /**�豸����*/
    protected String einame;

    /**�豸���*/
    protected String eilabel;
	
	/**��������*/
	protected String computerContainer ;
	
	/**
	 *ҵ��ϵͳȡ��
	 * @return ҵ��ϵͳ
	 */
	public String getBusinesssys() {
		return businesssys;
	}
	
	/**
	 * ҵ��ϵͳ�趨
	 *
	 * @param businesssys ҵ��ϵͳ
	 */
	public void setBusinesssys(String businesssys) {
		this.businesssys = businesssys;
	}
	
	/**
	 *IP��ַȡ��
	 * @return IP��ַ
	 */
	public String getIp() {
		return ip;
	}
	
	/**
	 * IP��ַ�趨
	 *
	 * @param ip IP��ַ
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	/**
	 *��������ȡ��
	 * @return ��������
	 */
	public String getComputerContainer() {
		return computerContainer;
	}
	/**
	 * ���������趨
	 *
	 * @param computerContainer ��������
	 */
	public void setComputerContainer(String computerContainer) {
		this.computerContainer = computerContainer;
	}

    /**
     * �豸����ȡ��
     *
     * @return einame �豸����
     */
    public String getEiname() {
        return einame;
    }

    /**
     * �豸���ȡ��
     *
     * @return eilabel �豸���
     */
    public String getEilabel() {
        return eilabel;
    }

    /**
     * �豸�����趨
     *
     * @param einame �豸����
     */
    public void setEiname(String einame) {
        this.einame = einame;
    }

    /**
     * �豸����趨
     *
     * @param eilabel �豸���
     */
    public void setEilabel(String eilabel) {
        this.eilabel = eilabel;
    }

}
