/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.vcd.model;

/**
 * ����: ��֯ʵ��
 * ��������: ��֯ʵ��
 * ������¼:
 * �޸ļ�¼:
 */
public class Org {
	
	/** vCloudID */
	protected Integer vcid;
	
	/** ��֯���� */
	protected String name;

	/**
	 * vCloudIDȡ��
	 * @return vcid vCloudID
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * vCloudID�趨
	 * @param vcid vCloudID
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * ��֯����ȡ��
	 * @return ��֯����
	 */
	public String getName() {
		return name;
	}

	/**
	 * ��֯�����趨
	 * @param name ��֯����
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
