/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.soc.dbs.model.entity;

 import java.io.Serializable;
import java.math.BigDecimal;
 import javax.persistence.Id;

import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Monitor_RtVWInfo;


/**
 * 
 * @Description:�洢ʵʱ��Ϣ��ͼʵ��TB��
 * @Author
 * @History
 * @Version V1.0
 */
@javax.persistence.Entity
public class Collect_Symmetrix_Monitor_RtVW implements Serializable, Cloneable, Collect_Symmetrix_Monitor_RtVWInfo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	protected String symtime;
	
	
	public String getSymtime() {
		return symtime;
	}
	public void setSymtime(String symtime) {
		this.symtime = symtime;
	}
	/**
	*IOPS
	*/
	protected BigDecimal symiops;
	
	/**
	*IOPSȡ��
	* @return IOPS
	*/
	public BigDecimal getSymiops(){
	return symiops;
	}
	/**
	*IOPS�趨
	* @param symiopsIOPS
	*/
	public void setSymiops(BigDecimal symiops){
	this.symiops=symiops;
	}
	/**
	*������
	*/
	protected BigDecimal symthroughput;
	
	/**
	*������ȡ��
	* @return ������
	*/
	public BigDecimal getSymthroughput(){
	return symthroughput;
	}
	/**
	*�������趨
	* @param symthroughput������
	*/
	public void setSymthroughput(BigDecimal symthroughput){
	this.symthroughput=symthroughput;
	}
	/**
	*������
	*/
	protected BigDecimal readper;
	
	/**
	*������ȡ��
	* @return ������
	*/
	public BigDecimal getReadper(){
	return readper;
	}
	/**
	*�������趨
	* @param readper������
	*/
	public void setReadper(BigDecimal readper){
	this.readper=readper;
	}
	/**
	*д����
	*/
	protected BigDecimal writeper;
	
	/**
	*д����ȡ��
	* @return д����
	*/
	public BigDecimal getWriteper(){
	return writeper;
	}
	/**
	*д�����趨
	* @param writeperд����
	*/
	public void setWriteper(BigDecimal writeper){
	this.writeper=writeper;
	}
	/**
	*����������
	*/
	protected BigDecimal hitper;
	
	/**
	*����������ȡ��
	* @return ����������
	*/
	public BigDecimal getHitper(){
	return hitper;
	}
	/**
	*�����������趨
	* @param hitper����������
	*/
	public void setHitper(BigDecimal hitper){
	this.hitper=hitper;
	}
	public String getFulltime() {
		return fulltime;
	}
	public void setFulltime(String fulltime) {
		this.fulltime = fulltime;
	}
	protected String fulltime;
}

