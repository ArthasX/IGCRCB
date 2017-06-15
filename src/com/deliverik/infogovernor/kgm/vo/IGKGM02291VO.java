/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.kgm.model.KnowLogInfo;
/**
 * 概述:知识库日志查询VO
 * 功能描述：知识库日志查询VO
 * 创建记录：2011/05/30
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGKGM02291VO extends BaseVO implements Serializable{

	/**知识库日志*/
	protected List<KnowLogInfo> recordList;

	/**
	 * 知识库日志取得
	 * @return recordLogMap 知识库日志
	 */
	public List<KnowLogInfo> getRecordList() {
		return recordList;
	}

	/**
	 * 知识库日志设定
	 * @param recordLogMap 知识库日志
	 */
	public void setRecordList(List<KnowLogInfo> recordList) {
		this.recordList = recordList;
	}

}


