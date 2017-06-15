/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.sdl.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sdl.model.SdlDefineInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_标准新增Form
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL0302Form extends BaseForm implements SdlDefineInfo{
	
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
	
	/** 编辑模式*/
	protected String mode = "0";

	/**
	 * 获取主键
	 * @return 主键
	 */
	public Integer getSdiid() {
		if(sdiid != null && sdiid != 0){
			return sdiid;
		}else{
			return null;
		}
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
		if(sdieiid != null && sdieiid != 0){
			return sdieiid;
		}else{
			return null;
		}
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
		if(sdibreakm != null && sdibreakm != 0){
			return sdibreakm;
		}else{
			return null;
		}
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
		if(sdibreaky != null && sdibreaky != 0){
			return sdibreaky;
		}else{
			return null;
		}
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
		if(sdicontinuousm != null && sdicontinuousm != 0){
			return sdicontinuousm;
		}else{
			return null;
		}
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
		if(sdicontinuousy != null && sdicontinuousy != 0){
			return sdicontinuousy;
		}else{
			return null;
		}
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
		if(sdiimpactm != null && sdiimpactm != 0){
			return sdiimpactm;
		}else{
			return null;
		}
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
		if(sdiimpacty != null && sdiimpacty != 0){
			return sdiimpacty;
		}else{
			return null;
		}
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
		if(sdisteadym != null && sdisteadym != 0){
			return sdisteadym;
		}else{
			return null;
		}
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
		if(sdisteadyy != null && sdisteadyy != 0){
			return sdisteadyy;
		}else{
			return null;
		}
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
		if(sdisafecasem != null && sdisafecasem != 0){
			return sdisafecasem;
		}else{
			return null;
		}
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
		if(sdisafecasey != null && sdisafecasey != 0){
			return sdisafecasey;
		}else{
			return null;
		}
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
		if(sdisafemarkm != null && sdisafemarkm != 0){
			return sdisafemarkm;
		}else{
			return null;
		}
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
		if(sdisafemarky != null && sdisafemarky != 0){
			return sdisafemarky;
		}else{
			return null;
		}
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
		if(sdiriskmarkm != null && sdiriskmarkm != 0){
			return sdiriskmarkm;
		}else{
			return null;
		}
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
		if(sdiriskmarky != null && sdiriskmarky != 0){
			return sdiriskmarky;
		}else{
			return null;
		}
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
		if(sdicapacitycasem != null && sdicapacitycasem != 0){
			return sdicapacitycasem;
		}else{
			return null;
		}
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
		if(sdicapacitycasey != null && sdicapacitycasey != 0){
			return sdicapacitycasey;
		}else{
			return null;
		}
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
		if(sdicapacitymarkm != null && sdicapacitymarkm != 0){
			return sdicapacitymarkm;
		}else{
			return null;
		}
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
		if(sdicapacitymarky != null && sdicapacitymarky != 0){
			return sdicapacitymarky;
		}else{
			return null;
		}
	}

	/**
	 * 设置年容量事件评分
	 * @param sdicapacitymarky 年容量事件评分
	 */
	public void setSdicapacitymarky(Integer sdicapacitymarky) {
		this.sdicapacitymarky = sdicapacitymarky;
	}

	/**
	 * 获取编辑模式
	 * @return 编辑模式
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 设置编辑模式
	 * @param mode 编辑模式
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
}
