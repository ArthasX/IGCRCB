/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.vcd.model;

/**
 * ����: ģ��ʵ��
 * ��������: ģ��ʵ��
 * ������¼:
 * �޸ļ�¼:
 */
public class Template {
	
	/** vCloud���ñ�ID */
	protected Integer vcdid;

	/** ģ������ */
	protected String name;
	
	/**
	 * vCloud���ñ�IDȡ��
	 * @return vCloud���ñ�ID
	 */
	public Integer getVcdid() {
		return vcdid;
	}

	/**
	 * vCloud���ñ�ID�趨
	 * @param vcdid vCloud���ñ�ID
	 */
	public void setVcdid(Integer vcdid) {
		this.vcdid = vcdid;
	}

	/**
	 * ģ������ȡ��
	 * 
	 * @return ģ������
	 */
	public String getName() {
		return name;
	}

	/**
	 * ģ�������趨
	 * 
	 * @param name ģ������
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
