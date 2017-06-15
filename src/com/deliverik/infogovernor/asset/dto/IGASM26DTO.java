/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
/**
 * 
 */
package com.deliverik.infogovernor.asset.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.asset.form.IGASM2601Form;
import com.deliverik.infogovernor.asset.model.IG342Info;

/**
 * @author Administrator
 *
 */
/**
 * 概述: 
 * 功能描述：
 * 创建人：赵敏
 * 创建记录： 2012-8-1
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGASM26DTO extends BaseDTO {

	/** 服务商资源池统计结果 */
	protected List<IG342Info>  entityItemAndConfigItemVWInfoList;
	
	/** 服务记录开始时间 */
	protected String beginTime_q;
	
	/** 服务记录结束时间 */
	protected String endTime_q;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 查询form*/
	protected IGASM2601Form igasm2601Form;
	
	/**
	 * 获取igasm2201Form
	 * @return figasm2201Form igasm2201Form
	 */
	public IGASM2601Form getIgasm2601Form() {
		return igasm2601Form;
	}

	/**
	 * 设置igasm2201Form
	 * @param igasm2201Form  igasm2201Form
	 */
	public void setIgasm2601Form(IGASM2601Form igasm2601Form) {
		this.igasm2601Form = igasm2601Form;
	}

	/**
	 * 获取entityItemAndConfigItemVWInfoList
	 * @return fentityItemAndConfigItemVWInfoList entityItemAndConfigItemVWInfoList
	 */
	public List<IG342Info> getEntityItemAndConfigItemVWInfoList() {
		return entityItemAndConfigItemVWInfoList;
	}

	/**
	 * 设置entityItemAndConfigItemVWInfoList
	 * @param entityItemAndConfigItemVWInfoList  entityItemAndConfigItemVWInfoList
	 */
	public void setEntityItemAndConfigItemVWInfoList(
			List<IG342Info> entityItemAndConfigItemVWInfoList) {
		this.entityItemAndConfigItemVWInfoList = entityItemAndConfigItemVWInfoList;
	}

	/**
	 * 获取beginTime_q
	 * @return fbeginTime_q beginTime_q
	 */
	public String getBeginTime_q() {
		return beginTime_q;
	}

	/**
	 * 设置beginTime_q
	 * @param beginTime_q  beginTime_q
	 */
	public void setBeginTime_q(String beginTime_q) {
		this.beginTime_q = beginTime_q;
	}

	/**
	 * 获取endTime_q
	 * @return fendTime_q endTime_q
	 */
	public String getEndTime_q() {
		return endTime_q;
	}

	/**
	 * 设置endTime_q
	 * @param endTime_q  endTime_q
	 */
	public void setEndTime_q(String endTime_q) {
		this.endTime_q = endTime_q;
	}

	/**
	 * 获取maxSearchCount
	 * @return fmaxSearchCount maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 设置maxSearchCount
	 * @param maxSearchCount  maxSearchCount
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 获取pagingDto
	 * @return fpagingDto pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 设置pagingDto
	 * @param pagingDto  pagingDto
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	
}
