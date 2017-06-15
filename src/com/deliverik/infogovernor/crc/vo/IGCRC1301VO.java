/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.crc.model.IGCRC1301VWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:文档信息查询VO 
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC1301VO extends BaseVO{

	/** 文档信息集合 */
	protected List<IGCRC1301VWInfo> igcrc1301VWList;

	/**
	 * 文档信息集合取得
	 * @return prList 文档信息集合
	 */
	public List<IGCRC1301VWInfo> getIgcrc1301VWList() {
		return igcrc1301VWList;
	}

	/**
	 * 文档信息集合设定
	 * @param prList 文档信息集合
	 */
	public void setIgcrc1301VWList(List<IGCRC1301VWInfo> igcrc1301vwList) {
		igcrc1301VWList = igcrc1301vwList;
	}
}
