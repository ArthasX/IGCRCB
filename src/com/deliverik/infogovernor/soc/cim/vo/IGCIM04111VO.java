/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.IG545Info;
import com.deliverik.framework.base.BaseVO;

/**
 * 资产下拉数据标识列表ＶＯ
 * 
 * @author
 * 
 */
public class IGCIM04111VO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 资产下拉数据标识列表 */
	private IG545Info configurationCodeDetail;

	public IG545Info getConfigurationCodeDetail() {
		return configurationCodeDetail;
	}

	public void setConfigurationCodeDetail(
			IG545Info configurationCodeDetail) {
		this.configurationCodeDetail = configurationCodeDetail;
	}

}
