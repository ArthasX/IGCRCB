/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * @Description: 流程定义_参与者Vo
 * @Author  
 * @History 2009-8-23     新建 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRR01033VO extends BaseVO implements Serializable {
	
	/** 可分派参与者集合 */
	private List<IGPRR01034VO> lst_IGPRR01034VO;

	/** 参与者处理标识集合(0未处理，1已处理) */
	protected Map<String, String> map_ParticipantDoneFlag;

	/**
	 * 可分派角色设定
	 * 
	 * @param map_AssignParticipant 可分派角色
	 */
	public IGPRR01033VO(Map<IG333Info, IGPRR01036VO> map_AssignParticipant) {
		if(map_AssignParticipant != null) {
			Set<Map.Entry<IG333Info, IGPRR01036VO>> set = map_AssignParticipant.entrySet();
			if(set.size() > 0) {
				this.lst_IGPRR01034VO = new ArrayList<IGPRR01034VO>();
				Map.Entry<IG333Info, IGPRR01036VO> entry = null;
				for(Iterator<Map.Entry<IG333Info, IGPRR01036VO>> iter = set.iterator();iter.hasNext();){
					entry = iter.next();
					this.lst_IGPRR01034VO.add(new IGPRR01034VO(entry.getKey(), entry.getValue()));
				}
			}
		}
	}

	/**
	 * 可分派参与者集合
	 * 
	 * @return 可分派参与者集合
	 */
	public List<IGPRR01034VO> getLst_IGPRR01034VO() {
		return lst_IGPRR01034VO;
	}
	
	/**
	 * 参与者处理标识集合取得
	 * 
	 * @return 参与者处理标识集合
	 */
	public Map<String, String> getMap_ParticipantDoneFlag() {
		return map_ParticipantDoneFlag;
	}

	/**
	 * 参与者处理标识集合设定
	 * 
	 * @param map_ParticipantDoneFlag 参与者处理标识集合
	 */
	public void setMap_ParticipantDoneFlag(
			Map<String, String> map_ParticipantDoneFlag) {
		this.map_ParticipantDoneFlag = map_ParticipantDoneFlag;
	}

}
