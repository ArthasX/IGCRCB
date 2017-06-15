/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.soc.dbs.model.entity;

 import java.io.Serializable;
import java.math.BigDecimal;
 import javax.persistence.Id;

import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Monitor_RtVWInfo;


/**
 * 
 * @Description:存储实时信息视图实体TB类
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
	*IOPS取得
	* @return IOPS
	*/
	public BigDecimal getSymiops(){
	return symiops;
	}
	/**
	*IOPS设定
	* @param symiopsIOPS
	*/
	public void setSymiops(BigDecimal symiops){
	this.symiops=symiops;
	}
	/**
	*吞吐率
	*/
	protected BigDecimal symthroughput;
	
	/**
	*吞吐率取得
	* @return 吞吐率
	*/
	public BigDecimal getSymthroughput(){
	return symthroughput;
	}
	/**
	*吞吐率设定
	* @param symthroughput吞吐率
	*/
	public void setSymthroughput(BigDecimal symthroughput){
	this.symthroughput=symthroughput;
	}
	/**
	*读比率
	*/
	protected BigDecimal readper;
	
	/**
	*读比率取得
	* @return 读比率
	*/
	public BigDecimal getReadper(){
	return readper;
	}
	/**
	*读比率设定
	* @param readper读比率
	*/
	public void setReadper(BigDecimal readper){
	this.readper=readper;
	}
	/**
	*写比率
	*/
	protected BigDecimal writeper;
	
	/**
	*写比率取得
	* @return 写比率
	*/
	public BigDecimal getWriteper(){
	return writeper;
	}
	/**
	*写比率设定
	* @param writeper写比率
	*/
	public void setWriteper(BigDecimal writeper){
	this.writeper=writeper;
	}
	/**
	*缓存命中率
	*/
	protected BigDecimal hitper;
	
	/**
	*缓存命中率取得
	* @return 缓存命中率
	*/
	public BigDecimal getHitper(){
	return hitper;
	}
	/**
	*缓存命中率设定
	* @param hitper缓存命中率
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

