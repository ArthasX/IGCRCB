/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.vim.model;

/**
 * ����: ģ��ʵ��
 * ��������: ģ��ʵ��
 * ������¼:
 * �޸ļ�¼:
 */
public class Template {
	
	/** vCenter���ñ�ID */
	protected Integer vcid;

	/** vCenter���ñ���ʾ���� */
	protected String vcname;
	
	/** ģ������ */
	protected String name;
	
	/** CPU���� */
	protected Integer numCPU;
	
	/** �ڴ��С(G) */
	protected Integer memoryGB;
	
	/** Ӳ�̴�С(G) */
	protected Integer diskGB;
	
	/** �����ǩ */
	protected String netName;

	/**
	 * vCenter���ñ�IDȡ��
	 * @return vCenter���ñ�ID
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * vCenter���ñ�ID�趨
	 * @param vcid vCenter���ñ�ID
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * vCenter���ñ���ʾ����ȡ��
	 * 
	 * @return vCenter���ñ���ʾ����
	 */
	public String getVcname() {
		return vcname;
	}

	/**
	 * vCenter���ñ���ʾ�����趨
	 * 
	 * @param vcname vCenter���ñ���ʾ����
	 */
	public void setVcname(String vcname) {
		this.vcname = vcname;
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

	/**
	 * CPU����ȡ��
	 * @return CPU����
	 */
	public Integer getNumCPU() {
		return numCPU;
	}

	/**
	 * CPU�����趨
	 * @param numCPU CPU����
	 */
	public void setNumCPU(Integer numCPU) {
		this.numCPU = numCPU;
	}

	/**
	 * �ڴ��С(G)ȡ��
	 * @return �ڴ��С(G)
	 */
	public Integer getMemoryGB() {
		return memoryGB;
	}

	/**
	 * �ڴ��С(G)�趨
	 * @param memoryGB �ڴ��С(G)
	 */
	public void setMemoryGB(Integer memoryGB) {
		this.memoryGB = memoryGB;
	}

	/**
	 * Ӳ�̴�С(G)ȡ��
	 * @return Ӳ�̴�С(G)
	 */
	public Integer getDiskGB() {
		return diskGB;
	}

	/**
	 * Ӳ�̴�С(G)�趨
	 * @param diskGB Ӳ�̴�С(G)
	 */
	public void setDiskGB(Integer diskGB) {
		this.diskGB = diskGB;
	}

	/**
	 * �����ǩȡ��
	 * @return �����ǩ
	 */
	public String getNetName() {
		return netName;
	}

	/**
	 * �����ǩ�趨
	 * @param netName �����ǩ
	 */
	public void setNetName(String netName) {
		this.netName = netName;
	}
	
}
