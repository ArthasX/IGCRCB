/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;

/**
 * 概述:填报考核 
 * 功能描述：填报考核
 * 创建人：赵梓廷
 * 创建记录： 2013-09-02
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSMR08011VO extends BaseVO {

	/**按人员考核查询结果*/
	protected Map<String,List<IGSMR08001VO>> map;
	
	/**按机构考核查询结果*/
	protected List<IGSMR08001VO> list;
	
	/**按机构考核查询结果合计*/
	protected IGSMR08001VO orgsum;
	
	/**按机构考核查询结果合计*/
	protected IGSMR08001VO usersum;

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
	
	
}
