/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 检查工作执行查询VO
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGRIS02013VO extends BaseVO implements Serializable{
	/** 风险检查结果信息检索结果 */
	protected List<IGRIS02012VO> igris02012voList;

	/**
	 * 风险检查结果信息检索结果取得
	 * @return igris02012voList 风险检查结果信息检索结果
	 */
	public List<IGRIS02012VO> getIgris02012voList() {
		return igris02012voList;
	}

	/**
	 * 风险检查结果信息检索结果设定
	 * @param igris02012voList 风险检查结果信息检索结果
	 */
	public void setIgris02012voList(List<IGRIS02012VO> igris02012voList) {
		this.igris02012voList = igris02012voList;
	}
}
