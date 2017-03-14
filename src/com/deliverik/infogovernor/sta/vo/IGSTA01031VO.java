/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sta.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sta.model.Contract;



@SuppressWarnings("serial")
public class IGSTA01031VO extends BaseVO implements Serializable {

  /**合同统计信息*/
  protected List<Contract> contracts;
  
  /** 合同信息检索结果 */
  protected List<IG499Info> entityItemCompactVWInfoList;

/**
 * 合同统计信息取得
 *
 * @return contracts 合同统计信息
 */
public List<Contract> getContracts() {
    return contracts;
}

/**
 * 合同统计信息设定
 *
 * @param contracts 合同统计信息
 */
public void setContracts(List<Contract> contracts) {
    this.contracts = contracts;
}

/**
 * 合同信息检索结果取得
 *
 * @return entityItemCompactVWInfoList 合同信息检索结果
 */
public List<IG499Info> getEntityItemCompactVWInfoList() {
    return entityItemCompactVWInfoList;
}

/**
 * 合同信息检索结果设定
 *
 * @param entityItemCompactVWInfoList 合同信息检索结果
 */
public void setEntityItemCompactVWInfoList(List<IG499Info> entityItemCompactVWInfoList) {
    this.entityItemCompactVWInfoList = entityItemCompactVWInfoList;
}
  
}
