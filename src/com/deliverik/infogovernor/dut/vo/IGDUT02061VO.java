/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dut.model.DutyPerson;
import com.deliverik.infogovernor.dut.model.DutyPlan;

/**
 * ֵ�������߼��ӿ�
 */
public class IGDUT02061VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ֵ�������������
	 */
	protected List<DutyPlan> dutyPlanList;

	/**
	 * ֵ������list�趨
	 * @param dutyPlanList ֵ������list
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
	 * ֵ�������������
	 */
	protected List<IGDUT02062VO> voList;

	public List<IGDUT02062VO> getVoList() {
		return voList;
	}

	public void setVoList(List<IGDUT02062VO> voList) {
		this.voList = voList;
	}

}
