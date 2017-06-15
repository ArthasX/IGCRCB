/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.dbm.dto;

import com.deliverik.framework.base.BaseDTO;

public class IGDBM04DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/*返回一切需要xml流的字符串*/
	protected String resultXML;
	
	/*当日核心系统主机CPU/内存利用率*/
	protected String kernelUseAvg;
	
	/*数据类型*/
	protected String SystemPillarType;
	
	/*相关事件*/
	protected int somethings;
	
	/*相关问题*/
	protected int somequestion;
	
	/**
	 * 当日核心系统主机CPU/内存利用率取得
	 * @return kernelUseAvg
	 */
	public String getKernelUseAvg() {
		return kernelUseAvg;
	}
	/**
	 * 当日核心系统主机CPU/内存利用率设置
	 * @param  kernelUseAvg 当日核心系统主机CPU/内存利用率
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