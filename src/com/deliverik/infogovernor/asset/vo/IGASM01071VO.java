/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;

/**
 * 资产下拉数据标识列表ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM01071VO extends BaseVO implements Serializable{
	
	/** 资产下拉数据标识列表 */
	protected List<ConfigurationCodeDetailBean> configurationCodeDetailBeanList;

	/**
	 * 构造函数
	 * @param configurationCodeDetailBeanList　资产下拉数据标识列表
	 */
	public IGASM01071VO(List<ConfigurationCodeDetailBean> configurationCodeDetailBeanList) {
		this.configurationCodeDetailBeanList = configurationCodeDetailBeanList;
	}
	
	/**
	 * 资产下拉数据标识列表取得
	 * @return 资产下拉数据标识列表结果集
	 */
	public List<ConfigurationCodeDetailBean> getConfigurationCodeDetailBeanList() {
		return configurationCodeDetailBeanList;
	}
}


