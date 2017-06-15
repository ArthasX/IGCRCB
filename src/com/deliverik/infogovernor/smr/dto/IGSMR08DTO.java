/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.smr.form.IGSMR0801Form;
import com.deliverik.infogovernor.smr.form.IGSMR0803Form;
import com.deliverik.infogovernor.smr.form.IGSMR0804Form;
import com.deliverik.infogovernor.smr.model.ReportDetailVWInfo;
import com.deliverik.infogovernor.smr.vo.IGSMR08001VO;

/**
 * 概述:填报考核 
 * 功能描述：填报考核 
 * 创建人：赵梓廷
 * 创建记录： 2013-09-02
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSMR08DTO extends BaseDTO {

	/**按人员考核查询结果*/
	protected Map<String,List<IGSMR08001VO>> map;
	
	/**按机构考核查询结果*/
	protected List<IGSMR08001VO> list;
	
	/**按机构考核查询结果合计*/
	protected IGSMR08001VO orgsum;
	
	/**按机构考核查询结果合计*/
	protected IGSMR08001VO usersum;
	
	/**考核查询form*/
	protected IGSMR0801Form igsmr0801Form;
	
	/**监控报表详细页form*/
	protected IGSMR0803Form igsmr0803Form;
	
	/**监控报表详细页信息*/
	protected Map<String,List<ReportDetailVWInfo>> detailMap;
	
	/**监控报表季报1中核心网络系统运行情况信息*/
	protected Map<String, List<String[]>> map_report;

	/**监控报表季报1中核心网络系统运行情况Form*/
	protected IGSMR0804Form igsmr0804Form;
	
	/**监控报表季报1上报的总数*/
	protected int countall;
	
	/**
	 * 监控报表季报1上报的总数取得
	 *
	 * @return countall 监控报表季报1上报的总数
	 */
	public int getCountall() {
		return countall;
	}

	/**
	 * 监控报表季报1上报的总数设定
	 *
	 * @param countall 监控报表季报1上报的总数
	 */
	public void setCountall(int countall) {
		this.countall = countall;
	}

	/**
	 * 监控报表季报1中核心网络系统运行情况Form取得
	 *
	 * @return igsmr0804Form 监控报表季报1中核心网络系统运行情况Form
	 */
	public IGSMR0804Form getIgsmr0804Form() {
		return igsmr0804Form;
	}

	/**
	 * 监控报表季报1中核心网络系统运行情况Form设定
	 *
	 * @param igsmr0804Form 监控报表季报1中核心网络系统运行情况Form
	 */
	public void setIgsmr0804Form(IGSMR0804Form igsmr0804Form) {
		this.igsmr0804Form = igsmr0804Form;
	}

	/**
	 * 监控报表季报1中核心网络系统运行情况信息取得
	 *
	 * @return map_report 监控报表季报1中核心网络系统运行情况信息
	 */
	public Map<String, List<String[]>> getMap_report() {
		return map_report;
	}

	/**
	 * 监控报表季报1中核心网络系统运行情况信息设定
	 *
	 * @param map_report 监控报表季报1中核心网络系统运行情况信息
	 */
	public void setMap_report(Map<String, List<String[]>> map_report) {
		this.map_report = map_report;
	}

	public Map<String, List<IGSMR08001VO>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<IGSMR08001VO>> map) {
		this.map = map;
	}

	public List<IGSMR08001VO> getList() {
		return list;
	}

	public void setList(List<IGSMR08001VO> list) {
		this.list = list;
	}

	public IGSMR0801Form getIgsmr0801Form() {
		return igsmr0801Form;
	}

	public void setIgsmr0801Form(IGSMR0801Form igsmr0801Form) {
		this.igsmr0801Form = igsmr0801Form;
	}

	public IGSMR08001VO getOrgsum() {
		return orgsum;
	}

	public void setOrgsum(IGSMR08001VO orgsum) {
		this.orgsum = orgsum;
	}

	public IGSMR08001VO getUsersum() {
		return usersum;
	}

	public void setUsersum(IGSMR08001VO usersum) {
		this.usersum = usersum;
	}

	/**
	 * 监控报表详细页 Form取得
	 * @return 监控报表详细页Form
	 */
	public IGSMR0803Form getIgsmr0803Form() {
		return igsmr0803Form;
	}

	/**
	 * 监控报表详细页Form设定
	 * @param igsmr0803Form 监控报表详细页Form
	 */
	public void setIgsmr0803Form(IGSMR0803Form igsmr0803Form) {
		this.igsmr0803Form = igsmr0803Form;
	}

	/**
	 * 监控报表详细页信息 取得
	 * @return 监控报表详细页信息
	 */
	public Map<String, List<ReportDetailVWInfo>> getDetailMap() {
		return detailMap;
	}

	/**
	 * 监控报表详细页信息设定
	 * @param detailMap 监控报表详细页信息
	 */
	public void setDetailMap(Map<String, List<ReportDetailVWInfo>> detailMap) {
		this.detailMap = detailMap;
	}
	
	
	
	
}
