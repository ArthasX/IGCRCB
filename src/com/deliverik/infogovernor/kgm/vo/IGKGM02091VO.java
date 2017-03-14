/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.kgm.model.Knowledge;


/**
 * 概述: 知识管理画面VO
 * 功能描述：1.知识管理画面VO
 *          
 * 创建记录：宋海洋 2010/12/07
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGKGM02091VO extends BaseVO implements Serializable{
	

	/** 知识结果集 */
	private List<Knowledge>  knowledgeList;
	/**
	 * 知识结果集的取得
	 * @return 知识结果集
	 */
	public List<Knowledge> getKnowledgeList() {
		return knowledgeList;
	}
	/**
	 * 设定知识结果集
	 * @param knowledgeList 知识结果集
	 */
	public void setKnowledgeList(List<Knowledge> knowledgeList) {
		this.knowledgeList = knowledgeList;
	}
	
	

}


