/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.dbm.dto;

import com.deliverik.framework.base.BaseDTO;

public class IGDBM04DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/*����һ����Ҫxml�����ַ���*/
	protected String resultXML;
	
	/*���պ���ϵͳ����CPU/�ڴ�������*/
	protected String kernelUseAvg;
	
	/*��������*/
	protected String SystemPillarType;
	
	/*����¼�*/
	protected int somethings;
	
	/*�������*/
	protected int somequestion;
	
	/**
	 * ���պ���ϵͳ����CPU/�ڴ�������ȡ��
	 * @return kernelUseAvg
	 */
	public String getKernelUseAvg() {
		return kernelUseAvg;
	}
	/**
	 * ���պ���ϵͳ����CPU/�ڴ�����������
	 * @param  kernelUseAvg ���պ���ϵͳ����CPU/�ڴ�������
	 */
	public void setKernelUseAvg(String kernelUseAvg) {
		this.kernelUseAvg = kernelUseAvg;
	}
	

	public String getResultXML() {
		return resultXML;
	}
	public void setResultXML(String resultXML) {
		this.resultXML = resultXML;
	}
	public String getSystemPillarType() {
		return SystemPillarType;
	}
	public void setSystemPillarType(String systemPillarType) {
		SystemPillarType = systemPillarType;
	}
	public int getSomethings() {
		return somethings;
	}
	public void setSomethings(int somethings) {
		this.somethings = somethings;
	}
	public int getSomequestion() {
		return somequestion;
	}
	public void setSomequestion(int somequestion) {
		this.somequestion = somequestion;
	}
	
}