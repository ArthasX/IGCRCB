/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 流程策略设定Form
 * 功能描述：流程策略设定Form
 * 创建记录：刘鹏    2010/11/26
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSYM1702Form extends BaseForm {
	
	/** 流程定义ID */
	protected String pdid;
	
	/** 流程模版ID */
	protected Integer ptid;
	
	/** 流程策略 */
	protected Map<String, String> strategyMap;
	
	/** 流程策略版本号 */
	protected Integer psdversion;
	
	/**
	 * 流程定义ID取得
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
	/**
	 * 流程模版ID取得
	 * @return 流程模版ID
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * 流程模版ID设定
	 * @param ptid流程模版ID
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	/**
	 * 流程策略取得
	 * @return 流程策略
	 */
	public String getStrategy(String key) {
		return (String) strategyMap.get(key);
	}

	/**
	 * 流程策略设定
	 * @param key 流程策略数组索引
	 * @param expecttime 流程策略
	 */
	public void setStrategy(String key, String expecttime) {
		strategyMap.put(key, expecttime);
	}
	
	/**
	 * 流程策略Map取得
	 * @return 流程策略Map
	 */
	public Map<String, String> getStrategyMap() {
		return strategyMap;
	}
	
	/**
	 * 流程策略Map设定
	 * @param strategyMap流程策略Map
	 */
	public void setStrategyMap(Map<String, String> strategyMap) {
		this.strategyMap = strategyMap;
	}
	
	@Override
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.strategyMap = new HashMap<String, String>();
		this.psdversion = null;
	}
	
	/**
	 * 流程策略版本号取得
	 * @return 流程策略版本号
	 */
	public Integer getPsdversion() {
		if(psdversion != null && psdversion == 0) {
			return null;
		} else {
			return psdversion;
		}
	}

	/**
	 * 流程策略版本号设定
	 * @param psdversion流程策略版本号
	 */
	public void setPsdversion(Integer psdversion) {
		this.psdversion = psdversion;
	}
	
}
