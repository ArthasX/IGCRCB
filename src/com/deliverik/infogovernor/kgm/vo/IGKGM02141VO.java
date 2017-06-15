/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.kgm.model.Knowledge;
/**
 * 概述:知识库详细查询VO
 * 功能描述：知识库详细查询VO
 * 创建记录：wangxiaoqiang 2010/12/07
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGKGM02141VO extends BaseVO implements Serializable{
	
	/**知识库详细信息*/
	protected Knowledge knowledge;
	
	
	/**
	 * 知识库详细信息取得
	 * @return 知识库详细信息
	 */
	public Knowledge getKnowledge() {
		return knowledge;
	}

	/**
	 * 知识库详细信息设定
	 * @param knowledge 知识库详细信息
	 */
	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}

	
}


