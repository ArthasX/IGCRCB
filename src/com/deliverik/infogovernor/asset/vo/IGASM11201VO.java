/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.EquipmentInquireVWInfo;

/**
 * 概述:3D机房支持IP查询 
 * 功能描述：3D机房支持IP查询 
 * 创建人：赵梓廷
 * 创建记录： 2013-02-01
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGASM11201VO extends BaseVO {

	/**3D机房支持IP查询结果 */
	List<EquipmentInquireVWInfo> eilist;
	
	/**
	 * 3D机房支持IP查询结果取得
	 * @return 3D机房支持IP查询结果
	 */
	public List<EquipmentInquireVWInfo> getEilist() {
		return eilist;
	}
	/**
	 * 3D机房支持IP查询结果设定
	 *
	 * @param 3D机房支持IP查询结果
	 */
	public void setEilist(List<EquipmentInquireVWInfo> eilist) {
		this.eilist = eilist;
	}
}
