/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG222Info;

/**
 * 流程定义_分派角色VO
 * 
 */
@SuppressWarnings("serial")
public class IGPRD01141VO extends BaseVO implements Serializable {

	
	/**  已添加参与者 */
	protected List<IG222Info> processParticipantDefList;

	/**
	 * 构造方法
	 * @param processParticipantDefList
	 */
	public IGPRD01141VO(List<IG222Info> processParticipantDefList) {
		this.processParticipantDefList = processParticipantDefList;
	}
	
	/**
	 * 已添加参与者取得
	 * @return 已添加参与者
	 */

	public List<IG222Info> getProcessParticipantDefList() {
		return processParticipantDefList;
	}


	
}
