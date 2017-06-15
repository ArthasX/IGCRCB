/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.sdl.model.SdlDefineInfo;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_服务水平标准信息MODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SdlDefineInfo")
public class SdlDefineInfoTB extends BaseEntity implements Serializable, Cloneable, SdlDefineInfo {

	@Id
	@TableGenerator(
		    name="SDLDEFINEINFO_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="SDLDEFINEINFO_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SDLDEFINEINFO_TABLE_GENERATOR")
	/**主键*/
	protected Integer sdiid;

	/**年度*/
	protected String sdiyear;

	/**相关资产ID*/
	protected Integer sdieiid;

	/**资产名称 */
	protected String sdieiname;

	/**月中断时间 */
	protected Integer sdibreakm;

	/**年中断时间*/
	protected Integer sdibreaky;

	/** 月连续时间百分比*/
	protected Double sdicontinuousm;

	/**年连续时间百分比*/
	protected Double sdicontinuousy;

	/**月影响时间*/
	protected Integer sdiimpactm;

	/**年影响时间*/
	protected Integer sdiimpacty;

	/** 月稳定时间百分比*/
	protected Double sdisteadym;

	/**年稳定时间百分比*/
	protected Double sdisteadyy;

	/**月安全事件个数*/
	protected Integer sdisafecasem;

	/**年安全事件个数*/
	protected Integer sdisafecasey;

	/**月安全事件评分*/
	protected Integer sdisafemarkm;

	/**年安全事件评分*/
	protected Integer sdisafemarky;

	/** 月风险检查评分*/
	protected Integer sdiriskmarkm;

	/**年风险检查评分*/
	protected Integer sdiriskmarky;

	/**月容量事件个数 */
	protected Integer sdicapacitycasem;

	/**年容量事件个数*/
	protected Integer sdicapacitycasey;

	/**月容量事件评分*/
	protected Integer sdicapacitymarkm;

	/** 年容量事件评分*/
	protected Integer sdicapacitymarky;

	/**
	 * 获取主键
	 * @return 
	 */
	public Serializable getPK() {
		return sdiid;
	}

	/**
	 * 比较
	 * @return 
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof SdlDefineInfoTB))
			return false;
		SdlDefineInfo target = (SdlDefineInfo) obj;
		if (!(getSdiid()==target.getSdiid()))
			return false;

		return true;
	}

	/**
	 * 获取主键
	 * @return 主键
	 */
	public Integer getSdiid() {
		return sdiid;
	}

	/**
	 * 设置主键
	 * @param sdiid 主键
	 */
	public void setSdiid(Integer sdiid) {
		this.sdiid = sdiid;
	}
	
	/**
	 * 获取年度
	 * @return 年度
	 */
	public String getSdiyear() {
		return sdiyear;
	}

	/**
	 * 设置年度
	 * @param sdiyear 年度
	 */
	public void setSdiyear(String sdiyear) {
		this.sdiyear = sdiyear;
	}

	/**
	 * 获取相关资产ID
	 * @return 相关资产ID
	 */
	public Integer getSdieiid() {
		return sdieiid;
	}

	/**
	 * 设置相关资产ID
	 * @param sdieiid 相关资产ID
	 */
	public void setSdieiid(Integer sdieiid) {
		this.sdieiid = sdieiid;
	}

	/**
	 * 获取相关资产名字
	 * @return 相关资产名字
	 */
	public String getSdieiname() {
		return sdieiname;
	}

	/**
	 * 设置相关资产名字
	 * @param sdieiname 相关资产名字
	 */
	public void setSdieiname(String sdieiname) {
		this.sdieiname = sdieiname;
	}

	/**
	 * 获取月中断时间
	 * @return 月中断时间
	 */
	public Integer getSdibreakm() {
		return sdibreakm;
	}

	/**
	 * 设置月中断时间
	 * @param sdibreakm 月中断时间
	 */
	public void setSdibreakm(Integer sdibreakm) {
		this.sdibreakm = sdibreakm;
	}

	/**
	 * 获取年中断时间
	 * @return 年中断时间
	 */
	public Integer getSdibreaky() {
		return sdibreaky;
	}

	/**
	 * 设置年中断时间
	 * @param sdibreaky 年中断时间
	 */
	public void setSdibreaky(Integer sdibreaky) {
		this.sdibreaky = sdibreaky;
	}

	/**
	 * 获取月连续时间百分比
	 * @return 月连续时间百分比
	 */
	public Double getSdicontinuousm() {
		return sdicontinuousm;
	}

	/**
	 * 设置月连续时间百分比
	 * @param sdicontinuousm 月连续时间百分比
	 */
	public void setSdicontinuousm(Double sdicontinuousm) {
		this.sdicontinuousm = sdicontinuousm;
	}

	/**
	 * 获取年连续时间百分比
	 * @return 年连续时间百分比
	 */
	public Double getSdicontinuousy() {
		return sdicontinuousy;
	}

	/**
	 * 设置年连续时间百分比
	 * @param sdicontinuousy 年连续时间百分比
	 */
	public void setSdicontinuousy(Double sdicontinuousy) {
		this.sdicontinuousy = sdicontinuousy;
	}

	/**
	 * 获取月影响时间
	 * @return 月影响时间
	 */
	public Integer getSdiimpactm() {
		return sdiimpactm;
	}

	/**
	 * 设置月影响时间
	 * @param sdiimpactm 月影响时间
	 */
	public void setSdiimpactm(Integer sdiimpactm) {
		this.sdiimpactm = sdiimpactm;
	}

	/**
	 * 获取年影响时间
	 * @return 年影响时间
	 */
	public Integer getSdiimpacty() {
		return sdiimpacty;
	}

	/**
	 * 设置年影响时间
	 * @param sdiimpacty 年影响时间
	 */
	public void setSdiimpacty(Integer sdiimpacty) {
		this.sdiimpacty = sdiimpacty;
	}

	/**
	 * 获取月稳定时间百分比
	 * @return 月稳定时间百分比
	 */
	public Double getSdisteadym() {
		return sdisteadym;
	}

	/**
	 * 设置月稳定时间百分比
	 * @param sdisteadym 月稳定时间百分比
	 */
	public void setSdisteadym(Double sdisteadym) {
		this.sdisteadym = sdisteadym;
	}

	/**
	 * 获取年稳定时间百分比
	 * @return 年稳定时间百分比
	 */
	public Double getSdisteadyy() {
		return sdisteadyy;
	}

	/**
	 * 设置年稳定时间百分比
	 * @param sdisteadyy 年稳定时间百分比
	 */
	public void setSdisteadyy(Double sdisteadyy) {
		this.sdisteadyy = sdisteadyy;
	}

	/**
	 * 获取月安全事件个数
	 * @return 月安全事件个数
	 */
	public Integer getSdisafecasem() {
		return sdisafecasem;
	}

	/**
	 * 设置月安全事件个数
	 * @param sdisafecasem 月安全事件个数
	 */
	public void setSdisafecasem(Integer sdisafecasem) {
		this.sdisafecasem = sdisafecasem;
	}

	/**
	 * 获取年安全事件个数
	 * @return 年安全事件个数
	 */
	public Integer getSdisafecasey() {
		return sdisafecasey;
	}

	/**
	 * 设置年安全事件个数
	 * @param sdisafecasey 年安全事件个数
	 */
	public void setSdisafecasey(Integer sdisafecasey) {
		this.sdisafecasey = sdisafecasey;
	}

	/**
	 * 获取月安全事件评分
	 * @return 月安全事件评分
	 */
	public Integer getSdisafemarkm() {
		return sdisafemarkm;
	}

	/**
	 * 设置月安全事件评分
	 * @param sdisafemarkm 月安全事件评分
	 */
	public void setSdisafemarkm(Integer sdisafemarkm) {
		this.sdisafemarkm = sdisafemarkm;
	}

	/**
	 * 获取年安全事件评分
	 * @return 年安全事件评分
	 */
	public Integer getSdisafemarky() {
		return sdisafemarky;
	}

	/**
	 * 设置年安全事件评分
	 * @param sdisafemarky 年安全事件评分
	 */
	public void setSdisafemarky(Integer sdisafemarky) {
		this.sdisafemarky = sdisafemarky;
	}

	/**
	 * 获取月风险检查评分
	 * @return 月风险检查评分
	 */
	public Integer getSdiriskmarkm() {
		return sdiriskmarkm;
	}

	/**
	 * 设置月风险检查评分
	 * @param sdiriskmarkm 月风险检查评分
	 */
	public void setSdiriskmarkm(Integer sdiriskmarkm) {
		this.sdiriskmarkm = sdiriskmarkm;
	}

	/**
	 * 获取年风险检查评分
	 * @return 年风险检查评分
	 */
	public Integer getSdiriskmarky() {
		return sdiriskmarky;
	}

	/**
	 * 设置年风险检查评分
	 * @param sdiriskmarky 年风险检查评分
	 */
	public void setSdiriskmarky(Integer sdiriskmarky) {
		this.sdiriskmarky = sdiriskmarky;
	}

	/**
	 * 获取月容量事件个数
	 * @return 月容量事件个数
	 */
	public Integer getSdicapacitycasem() {
		return sdicapacitycasem;
	}

	/**
	 * 设置月容量事件个数
	 * @param sdicapacitycasem 月容量事件个数
	 */
	public void setSdicapacitycasem(Integer sdicapacitycasem) {
		this.sdicapacitycasem = sdicapacitycasem;
	}

	/**
	 * 获取年容量事件个数
	 * @return 年容量事件个数
	 */
	public Integer getSdicapacitycasey() {
		return sdicapacitycasey;
	}

	/**
	 * 设置年容量事件个数
	 * @param sdicapacitycasey 年容量事件个数
	 */
	public void setSdicapacitycasey(Integer sdicapacitycasey) {
		this.sdicapacitycasey = sdicapacitycasey;
	}

	/**
	 * 获取月容量事件评分
	 * @return 月容量事件评分
	 */
	public Integer getSdicapacitymarkm() {
		return sdicapacitymarkm;
	}

	/**
	 * 设置月容量事件评分
	 * @param sdicapacitymarkm 月容量事件评分
	 */
	public void setSdicapacitymarkm(Integer sdicapacitymarkm) {
		this.sdicapacitymarkm = sdicapacitymarkm;
	}

	/**
	 * 获取年容量事件评分
	 * @return 年容量事件评分
	 */
	public Integer getSdicapacitymarky() {
		return sdicapacitymarky;
	}

	/**
	 * 设置年容量事件评分
	 * @param sdicapacitymarky 年容量事件评分
	 */
	public void setSdicapacitymarky(Integer sdicapacitymarky) {
		this.sdicapacitymarky = sdicapacitymarky;
	}
	
}
