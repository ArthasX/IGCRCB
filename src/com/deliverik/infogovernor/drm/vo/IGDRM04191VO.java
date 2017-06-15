/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0151Info;

/**
 * 资产下拉数据标识列表ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGDRM04191VO extends BaseVO implements Serializable{
	
	/** 资产下拉数据标识列表 */
	protected List<SOC0151Info> configurationCodeDetailList;

	/**
	 * 构造函数
	 * @param configurationCodeDetailBeanList　资产下拉数据标识列表
	 */
	public IGDRM04191VO(List<SOC0151Info> configurationCodeDetailList) {
		this.configurationCodeDetailList = configurationCodeDetailList;
	}

	public List<SOC0151Info> getConfigurationCodeDetailList() {
		return configurationCodeDetailList;
	}

}


