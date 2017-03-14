/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;


/**
 * <p>
 * Title : InfoGovernor 应急管理
 * </p>
 * <p>
 * Description:统计分析DTO
 * </p>
 * 
 * @author zhangjian@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM18DTO extends BaseDTO implements Serializable {
	
	/** 允许查询的最大记录数 */
	protected int maxSearchCount;

	/** 分页Bean */
	protected PagingDTO pagingDto;
	
	/** 预案统计列表 */
	protected List<Map<String,Object>> planRateList;
	
	/**演练统计*/
	protected List<Map<String,Object>> drillRateList;
	
	/**演练类型统计*/
	protected List<Map<String,Object>> drillTypeRateList;
	
	/**专项预案列表*/
	protected List<SOC0124Info> planList;
	

	/**  
	 * 获取允许查询的最大记录数  
	 * @return maxSearchCount 允许查询的最大记录数  
	 */
	
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**  
	 * 设置允许查询的最大记录数  
	 * @param maxSearchCount 允许查询的最大记录数  
	 */
	
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**  
	 * 获取分页Bean  
	 * @return pagingDto 分页Bean  
	 */
	
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**  
	 * 设置分页Bean  
	 * @param pagingDto 分页Bean  
	 */
	
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public List<SOC0124Info> getPlanList() {
		return planList;
	}

	public void setPlanList(List<SOC0124Info> planList) {
		this.planList = planList;
	}

	/**
	 * 预案统计列表取得
	 * @return planRateList 预案统计列表
	 */
	public List<Map<String, Object>> getPlanRateList() {
		return planRateList;
	}

	/**
	 * 预案统计列表设定
	 * @param planRateList 预案统计列表
	 */
	public void setPlanRateList(List<Map<String, Object>> planRateList) {
		this.planRateList = planRateList;
	}

	/**
	 * 演练统计取得
	 * @return drillRateList 演练统计
	 */
	public List<Map<String, Object>> getDrillRateList() {
		return drillRateList;
	}

	/**
	 * 演练统计设定
	 * @param drillRateList 演练统计
	 */
	public void setDrillRateList(List<Map<String, Object>> drillRateList) {
		this.drillRateList = drillRateList;
	}

	/**
	 * 演练类型统计取得
	 * @return drillTypeRateList 演练类型统计
	 */
	public List<Map<String, Object>> getDrillTypeRateList() {
		return drillTypeRateList;
	}

	/**
	 * 演练类型统计设定
	 * @param drillTypeRateList 演练类型统计
	 */
	public void setDrillTypeRateList(List<Map<String, Object>> drillTypeRateList) {
		this.drillTypeRateList = drillTypeRateList;
	}
}
