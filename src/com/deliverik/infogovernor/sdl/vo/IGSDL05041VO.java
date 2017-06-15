/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sdl.model.SdlYearSummary;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_统计VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL05041VO extends BaseVO implements Serializable {
	
	/**统计信息List*/
	protected List<SdlYearSummary> sdlYearSummaryList;
	
	/**
	 * 获取统计信息List
	 * @return List<SdlYearSummary>
	 */
	
	public List<SdlYearSummary> getSdlYearSummaryList() {
		return sdlYearSummaryList;
	}
	

	/**
	 * 构造函数
	 * @param sdlYearSummaryList List<SdlYearSummary>
	 */
	public IGSDL05041VO(List<SdlYearSummary> sdlYearSummaryList) {
		this.sdlYearSummaryList = sdlYearSummaryList;
	}
}
