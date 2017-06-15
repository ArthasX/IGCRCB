/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG545Bean;
import com.deliverik.framework.base.BaseVO;

/**
 * 资产下拉数据标识列表ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM04071VO extends BaseVO implements Serializable{
	
	/** 资产下拉数据标识列表 */
	protected List<IG545Bean> configurationCodeDetailBeanList;

	/**
	 * 构造函数
	 * @param configurationCodeDetailBeanList　资产下拉数据标识列表
	 */
	public IGCIM04071VO(List<IG545Bean> configurationCodeDetailBeanList) {
		this.configurationCodeDetailBeanList = configurationCodeDetailBeanList;
	}
	
	/**
	 * 资产下拉数据标识列表取得
	 * @return 资产下拉数据标识列表结果集
	 */
	public List<IG545Bean> getConfigurationCodeDetailBeanList() {
		return configurationCodeDetailBeanList;
	}
}


