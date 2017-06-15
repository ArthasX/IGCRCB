/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dut.model.DutyPerson;
import com.deliverik.infogovernor.dut.model.DutyPlan;

/**
 * 值班启动逻辑接口
 */
public class IGDUT02061VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 值班启动检索结果
	 */
	protected List<DutyPlan> dutyPlanList;

	/**
	 * 值班启动list设定
	 * @param dutyPlanList 值班启动list
	 */
	public void setDutyPlanList(List<DutyPlan> dutyPlanList) {
		this.dutyPlanList = dutyPlanList;
		
		if(dutyPlanList != null) {
			voList = new ArrayList<IGDUT02062VO>();
			for(DutyPlan dp : dutyPlanList) {
				IGDUT02062VO vo = new IGDUT02062VO();
				vo.setDutyPlan(dp);
				StringBuffer sb = new StringBuffer();
				for(DutyPerson per : dp.getDutyPersonList()) {
					sb.append(per.getDperusername()).append("&nbsp;&nbsp;");
				}
				vo.setName(sb.toString());
				voList.add(vo);
			}
		}
	}
	
	/**
	 * 值班启动检索结果
	 */
	protected List<IGDUT02062VO> voList;

	public List<IGDUT02062VO> getVoList() {
		return voList;
	}

	public void setVoList(List<IGDUT02062VO> voList) {
		this.voList = voList;
	}

}
