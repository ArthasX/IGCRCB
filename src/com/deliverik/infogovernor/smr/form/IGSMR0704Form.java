/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述:年报列表查询 
 * 功能描述：年报列表查询 
 * 创建记录： 2013-07-25
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSMR0704Form extends BaseForm {
	
	/** 实例ID */
	private	Integer instanceID;
	
	/** 流程主键集合 */
	private Integer[] prids;
	
   /** 流程定义ID集合 */
    private String[] prpdids;
	
	/** 审批驳回标识   1、审批  2、驳回 */
	private String type;

	/**
	 * 实例ID取得
	 * 
	 * @return 实例ID
	 */
	public Integer getInstanceID() {
		return instanceID;
	}

	/**
	 * 实例ID设定
	 * 
	 * @param instanceID 实例ID
	 */
	public void setInstanceID(Integer instanceID) {
		this.instanceID = instanceID;
	}
	
	/**
	 * 流程主键集合取得
	 * 
	 * @return 流程主键集合
	 */
	public Integer[] getPrids() {
		return prids;
	}
	
	/**
	 * 流程主键集合设定
	 * 
	 * @param prids 流程主键集合
	 */
	public void setPrids(Integer[] prids) {
		this.prids = prids;
	}
	/**
	 * 审批驳回标识取得
	 * 
	 * @return 审批驳回标识
	 */
	public String getType() {
		return type;
	}
	/**
	 * 审批驳回标识设定
	 * 
	 * @param type 审批驳回标识
	 */
	public void setType(String type) {
		this.type = type;
	}
	
    /**
     * @return the 流程定义ID集合
     */
    public String[] getPrpdids() {
        return prpdids;
    }

    /**
     * @param 流程定义ID集合 the prpdids to set
     */
    public void setPrpdids(String[] prpdids) {
        this.prpdids = prpdids;
    }
	
}
