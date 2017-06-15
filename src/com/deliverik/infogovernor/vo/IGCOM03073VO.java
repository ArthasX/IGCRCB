/*
 * 北京递蓝科信息技术有限公司版权所有,保留所有权利.
 */
package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;

/**
 * 配置项信息VO
 */
@SuppressWarnings("serial")
public class IGCOM03073VO extends BaseVO implements Serializable {
	
	
	/**
	 * 属性信息
	 */
	protected SOC0109Info configuration;
	
	/**
	 * 配置项信息检索结果
	 */
	protected List<SOC0107Info> configItemList;
	
	/**
	 * 构造函数
	 * 
	 * @param ci 配置项信息
	 */
	public IGCOM03073VO(SOC0107Info ci) {
		setConfiguration(ci.getConfiguration());
		addConfigItem(ci);
	}

	/**
	 * 配置项信息检索结果取得
	 * @return 配置项信息检索结果
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * 配置项信息检索结果设定
	 * @param configItemList 配置项信息检索结果
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * 属性信息取得
	 * @return 属性信息
	 */
	public SOC0109Info getConfiguration() {
		return configuration;
	}

	/**
	 * 属性信息设定
	 * @param info 属性信息
	 */
	public void setConfiguration(SOC0109Info info) {
		this.configuration = info;
	}

	/**
	 * 添加配置项信息
	 * 
	 * @param ci 配置项信息
	 */
	public void addConfigItem(SOC0107Info ci) {
		if(this.configItemList == null) {
			this.configItemList = new ArrayList<SOC0107Info>();
		} 
		this.configItemList.add(ci);
	}
	
}
