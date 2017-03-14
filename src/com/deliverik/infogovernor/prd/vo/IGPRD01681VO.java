/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG126Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * 概述: 自定义流程页面设置 查询VO
 * 功能描述: 自定义流程页面设置查询VO
 * 创建记录: 2012/11/13
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGPRD01681VO extends BaseVO implements Serializable{

	/** 自定义流程页面设置列表 */
	protected List<IG126Info> lst_IG126Info;
	
	/** 自定义路程页面设置 查询流程名称*/
    protected IG380Info ig380info;
    
	/**
	 * 构造函数
	 * @param processInfoDef　自定义流程页面设置列表检索结果
	 */
	public IGPRD01681VO(List<IG126Info> ig126infoList) {
		this.lst_IG126Info = ig126infoList;
	}
	/**
	 * 自定义流程页面设置列表取得
	 * @return the lst_IG126Info
	 */
	public List<IG126Info> getLst_IG126Info() {
		return lst_IG126Info;
	}

	/**
	 *自定义流程页面设置列表设置
	 *	
	 * @param lst_IG126Info the lst_IG126Info to set
	 */
	public void setLst_IG126Info(List<IG126Info> lst_IG126Info) {
		this.lst_IG126Info = lst_IG126Info;
	}

	/**
     * 自定义流程页面设置 查询流程名称 获取
     * @return the ig380info
     */
    public IG380Info getIg380info() {
        return ig380info;
    }
    /**
     * 自定义流程页面设置 查询流程名称 设置
     * @param ig380info the ig380info to set
     */
    public void setIg380info(IG380Info ig380info) {
        this.ig380info = ig380info;
    }
	
}


