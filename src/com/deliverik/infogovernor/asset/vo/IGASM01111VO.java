/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0151Info;

/**
 * 资产下拉数据标识列表ＶＯ
 * 
 * @author
 * 
 */
public class IGASM01111VO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 资产下拉数据标识列表 */
	private SOC0151Info configurationCodeDetail;

	public SOC0151Info getConfigurationCodeDetail() {
		return configurationCodeDetail;
	}

	public void setConfigurationCodeDetail(
			SOC0151Info configurationCodeDetail) {
		this.configurationCodeDetail = configurationCodeDetail;
	}

}
