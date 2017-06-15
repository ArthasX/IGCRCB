/*
 * 北京递蓝科信息技术有限公司版权所有,保留所有权利.
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;

/**
 * 配置项信息VO
 */
@SuppressWarnings("serial")
public class IGCIM12042VO extends BaseVO implements Serializable {
	
	/**
	 * 配置项类型信息
	 */
	protected String ccategory;
	/**
	 * 配置项信息检索结果
	 */
	protected List<IGCIM12043VO> voList;
	

	/**
	 * 配置项信息检索结果取得
	 * @return 配置项信息检索结果
	 */
	public List<IGCIM12043VO> getVoList() {
		return voList;
	}

	/**
	 * 配置项信息检索结果设定
	 * @param voList 配置项信息检索结果
	 */
	public void setVoList(List<IGCIM12043VO> voList) {
		this.voList = voList;
	}

	/**
	 * 配置项类型信息取得
	 * @return 配置项类型信息
	 */
	public String getCcategory() {
		return ccategory;
	}

	/**
	 * 配置项类型信息设定
	 * @param ccategory 配置项类型信息
	 */
	public void setCcategory(String ccategory) {
		this.ccategory = ccategory;
	}
	/**
	 * 添加资产配置项
	 * 
	 * @param ci
	 */
	public void addConfigItem(SOC0107Info ci) {
		if(this.voList == null) {
			this.voList = new ArrayList<IGCIM12043VO>();
		} 
		boolean flag = true;
		for(IGCIM12043VO vo : this.voList) {
			if(ci.getCid().equals(vo.getConfiguration().getCid())) {
				vo.addConfigItem(ci);
				flag = false;
				break;
			}
		}
		if(flag){
			this.voList.add(new IGCIM12043VO(ci));
		}
	}
	
}
