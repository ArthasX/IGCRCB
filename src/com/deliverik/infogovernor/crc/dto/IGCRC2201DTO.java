/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.crc.form.IGCRC2201Form;
import com.deliverik.infogovernor.crc.model.IGCRC2201VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2201Cond;
import com.deliverik.infogovernor.crc.vo.IGCRC2202VO;

/**	
 * 概述:变更总体统计DTO
 * 创建记录：yukexin    2014-8-15 下午5:15:21	
 * 修改记录：null
 */	
public class IGCRC2201DTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 变更总体统计Form */
	protected IGCRC2201Form igcrc2201Form;

	/** 变更总体统计查询条件接口 */
	protected IGCRC2201Cond igcrc2201Cond;

	/** 变更总体统计接口 */
	protected IGCRC2201VWInfo igcrc2201VWInfo;
	
	/** 返回的页面显示的变更数据  */	
	protected List<IGCRC2202VO> igcrc2202voList;

	/**
	 * 变更总体统计Form取得
	 * @return igcrc2201Form  变更总体统计Form
	 */
	public IGCRC2201Form getIgcrc2201Form() {
		return igcrc2201Form;
	}

	/**
	 * 变更总体统计Form设定
	 * @param igcrc2201Form  变更总体统计Form
	 */
	public void setIgcrc2201Form(IGCRC2201Form igcrc2201Form) {
		this.igcrc2201Form = igcrc2201Form;
	}

	/**
	 * 变更总体统计查询条件接口取得
	 * @return igcrc2201Cond  变更总体统计查询条件接口
	 */
	public IGCRC2201Cond getIgcrc2201Cond() {
		return igcrc2201Cond;
	}

	/**
	 * 变更总体统计查询条件接口设定
	 * @param igcrc2201Cond  变更总体统计查询条件接口
	 */
	public void setIgcrc2201Cond(IGCRC2201Cond igcrc2201Cond) {
		this.igcrc2201Cond = igcrc2201Cond;
	}

	/**
	 * 变更总体统计接口取得
	 * @return igcrc2201VWInfo  变更总体统计接口
	 */
	public IGCRC2201VWInfo getIgcrc2201VWInfo() {
		return igcrc2201VWInfo;
	}

	/**
	 * 变更总体统计接口设定
	 * @param igcrc2201vwInfo  igcrc2201VWInfo
	 */
	public void setIgcrc2201VWInfo(IGCRC2201VWInfo igcrc2201vwInfo) {
		igcrc2201VWInfo = igcrc2201vwInfo;
	}

	/**
	 * 返回的页面显示的变更数据取得
	 * @return igcrc2202voList  返回的页面显示的变更数据
	 */
	public List<IGCRC2202VO> getIgcrc2202voList() {
		return igcrc2202voList;
	}

	/**
	 * 返回的页面显示的变更数据设定
	 * @param igcrc2202voList  返回的页面显示的变更数据
	 */
	public void setIgcrc2202voList(List<IGCRC2202VO> igcrc2202voList) {
		this.igcrc2202voList = igcrc2202voList;
	}


}
