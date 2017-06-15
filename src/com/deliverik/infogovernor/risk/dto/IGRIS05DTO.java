/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.risk.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.infogovernor.risk.form.IGRIS0501Form;
import com.deliverik.infogovernor.risk.model.CheckWorkConutVWInfo;


/**
 * @Description: 
 * @Author       zhangqiang
 * @History      @2014-7-9新建 
 * 			
 * @Version V1.0
 */
public class IGRIS05DTO {

	/**检查统计查询FORM*/
	protected IGRIS0501Form igris0501Form;
	
	/**检查统计查询集合*/
	protected List<CheckWorkConutVWInfo> checkWorkConutList;
	
	/**检查结果map返回*/
	protected Map<String, List<CheckWorkConutVWInfo>> checkWorkConutmap;
	
	/**类别*/
	protected Map<Integer,String> mapType;
	
	/**检查结果map返回*/
	protected Map<String, Map<String,List<CheckWorkConutVWInfo>>> checkExcelWorkConutmap;
	
	/**类别*/
	protected Map<String,Map<Integer,String>> mapTypeExcel;
	
	/** 1查询 2导出*/
	protected String flag;

	/**
	 * 类别取得
	 * @return mapType 类别
	 */
	public Map<Integer, String> getMapType() {
		return mapType;
	}

	/**
	 * 类别设定
	 * @param mapType 类别
	 */
	public void setMapType(Map<Integer, String> mapType) {
		this.mapType = mapType;
	}

	/**
	 * 检查统计查询FORM取得
	 * @return igris0501Form 检查统计查询FORM
	 */
	public IGRIS0501Form getIgris0501Form() {
		return igris0501Form;
	}

	/**
	 * 检查统计查询FORM设定
	 * @param igris0501Form 检查统计查询FORM
	 */
	public void setIgris0501Form(IGRIS0501Form igris0501Form) {
		this.igris0501Form = igris0501Form;
	}

	/**
	 * checkWorkConutList取得
	 * @return checkWorkConutList checkWorkConutList
	 */
	public List<CheckWorkConutVWInfo> getCheckWorkConutList() {
		return checkWorkConutList;
	}

	/**
	 * checkWorkConutList设定
	 * @param checkWorkConutList checkWorkConutList
	 */
	public void setCheckWorkConutList(List<CheckWorkConutVWInfo> checkWorkConutList) {
		this.checkWorkConutList = checkWorkConutList;
	}


	/**
	 * 检查结果map返回取得
	 * @return checkWorkConutmap 检查结果map返回
	 */
	public Map<String, List<CheckWorkConutVWInfo>> getCheckWorkConutmap() {
		return checkWorkConutmap;
	}

	/**
	 * 检查结果map返回设定
	 * @param checkWorkConutmap 检查结果map返回
	 */
	public void setCheckWorkConutmap(
			Map<String, List<CheckWorkConutVWInfo>> checkWorkConutmap) {
		this.checkWorkConutmap = checkWorkConutmap;
	}

	/**
	 * 1查询2导出取得
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * 1查询2导出设定
	 * @param flag the 1查询2导出
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * 检查结果map返回取得
	 * @return the checkExcelWorkConutmap
	 */
	public Map<String, Map<String, List<CheckWorkConutVWInfo>>> getCheckExcelWorkConutmap() {
		return checkExcelWorkConutmap;
	}

	/**
	 * 检查结果map返回设定
	 * @param checkExcelWorkConutmap the 检查结果map返回
	 */
	public void setCheckExcelWorkConutmap(
			Map<String, Map<String, List<CheckWorkConutVWInfo>>> checkExcelWorkConutmap) {
		this.checkExcelWorkConutmap = checkExcelWorkConutmap;
	}

	/**
	 * 类别取得
	 * @return the mapTypeExcel
	 */
	public Map<String, Map<Integer, String>> getMapTypeExcel() {
		return mapTypeExcel;
	}

	/**
	 * 类别设定
	 * @param mapTypeExcel the 类别
	 */
	public void setMapTypeExcel(Map<String, Map<Integer, String>> mapTypeExcel) {
		this.mapTypeExcel = mapTypeExcel;
	}
}
