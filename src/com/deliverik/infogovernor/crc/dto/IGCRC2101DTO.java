/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.crc.form.IGCRC2101Form;
import com.deliverik.infogovernor.crc.model.IGCRC2102VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2101Cond;
import com.deliverik.infogovernor.crc.vo.IGCRC2102VO;

/**	
 * 概述:人员工作统计查询用DTO
 * 创建记录：yukexin    2014-8-15 下午5:14:43	
 * 修改记录：null
 */	
@SuppressWarnings("serial")
public class IGCRC2101DTO extends BaseDTO implements Serializable{
	
	
	/** 人员工作统计查询画面FORM */
	private IGCRC2101Form igcrc2101Form;
	
	/** 人员工作统计信息检索条件 */
	protected IGCRC2101Cond entityItemVWSearchCond;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 人员工作统计检索结果 带合计*/
	protected List<IGCRC2102VO> igcrc2102voList;

	/** 人员工作统计分项合计结果 */
	protected List<Integer> listSum;
	
	 /** 部门下拉列表  */	
	protected List<IGCRC2102VWInfo> departmentBeanList;

	/**
	 * 翻页用DTO取得
	 * @return 翻页用DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 翻页用DTO设定
	 *
	 * @param pagingDto 翻页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public IGCRC2101Form getIgcrc2101Form() {
		return igcrc2101Form;
	}

	public void setIgcrc2101Form(IGCRC2101Form igcrc2101Form) {
		this.igcrc2101Form = igcrc2101Form;
	}

	/**
	 * 人员工作统计信息检索条件取得
	 * @return 人员工作统计信息检索条件
	 */
	public IGCRC2101Cond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 人员工作统计信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 人员工作统计信息检索条件
	 */
	public void setEntityItemVWSearchCond(IGCRC2101Cond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}

	public List<Integer> getListSum() {
		return listSum;
	}

	public void setListSum(List<Integer> listSum) {
		this.listSum = listSum;
	}

	public List<IGCRC2102VO> getIgcrc2102voList() {
		return igcrc2102voList;
	}

	public void setIgcrc2102voList(List<IGCRC2102VO> igcrc2102voList) {
		this.igcrc2102voList = igcrc2102voList;
	}

	public List<IGCRC2102VWInfo> getDepartmentBeanList() {
		return departmentBeanList;
	}

	public void setDepartmentBeanList(List<IGCRC2102VWInfo> departmentBeanList) {
		this.departmentBeanList = departmentBeanList;
	}

}
