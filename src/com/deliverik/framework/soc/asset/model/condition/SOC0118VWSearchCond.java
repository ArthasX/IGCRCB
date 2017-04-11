/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

import com.deliverik.framework.soc.asset.model.entity.SOC0118VWPK;

/**
  * 概述: SOC0118VW检索条件接口
  * 功能描述: SOC0118VW检索条件接口
  * 创建记录: 2016/06/21
  * 修改记录: 
  */
public interface SOC0118VWSearchCond {
	
	/**
	 * @return the 数据库id
	 */
	public Integer getId();
	
	/**
	 * @return the 主键集合pKs
	 */
	public List<SOC0118VWPK> getPKs();
	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEid();

	/**
	 * 资产编号取得
	 * @return 资产编号
	 */
	public String getEilabel();
	
	/**
	 * 资产名称取得
	 * @return 资产名称
	 */
	public String getEiname();
	
	/**
	 * 资产所属机构层次码取得
	 * @return 资产所属机构层次码
	 */
	public String getEiorgsyscoding();
	
	/**
	 * 资产ID取得（平台保留）
	 * @return 资产ID
	 */
	public String getEiid();
	
	/**
	 * 资产版本号取得
	 * @return 资产版本号
	 */
	public Integer getEiversion();
	
	/**
	 * 资产小版本取得
	 * @return 资产小版本
	 */
	public Integer getEismallversion() ;
	
	public List<String> getEilabel_list();
	
	/**
	 * 资产名称（完全匹配 ）取得
	 * @return 资产名称（完全匹配 ）
	 */
	public String getEiname_equal();
	
	/**
	 * 资产顶级实体ID（完全匹配 ）取得
	 * @return 资产顶级实体（完全匹配 ）
	 */
	public Integer getEirootmark();
	
	/**
	 * 资产eiid取得
	 *
	 * @return eiids 资产eiid
	 */
	
	public List<Integer> getEiids();
	
	/**
	 * 资产模型ID取得
	 *
	 * @return eids 资产模型ID
	 */
	
	public String[] getEids();
	
	/**
	 * 存储过滤eq取得
	 *
	 * @return esyscoding_eq 存储过滤eq
	 */
	public String getEsyscoding_eq();
	/**
	 * 存储过滤like取得
	 *
	 * @return esyscoding_like 存储过滤like
	 */
	public String getEsyscoding_like();
	
	public String getCcid() ;


	public String getPcid() ;


	public String getCdstatus();
	/**
	 * eid_arr取得
	 *
	 * @return eid_arr eid_arr
	 */
	public String[] getEid_arr();
	
	public String getMagName();
	
	public List<String> getEiname_in() ;
	
	public String getEilabel_like();
	
	public String getEidesc_falg();
	
	public String getEiupdtime_from();
	
	public String getEiupdtime_to();

	public Integer getSystemId();
	
	public String getEnvironmentType();
	public boolean isClumped();
	public String getEitype();
	/**
	 * @return the 资产状态
	 */
	public String getEistatus();
	/**
	 * @return the eiinsdate_like
	 */
	public String getEiinsdate_like();
	/**
	 * @return the 负责人
	 */
	public String getEiusername();
	/**
	 * 是否升级
	 * @return
	 */
	public boolean isUpgrade();
	
	public String getEiinsdate_gt() ;


	public String getEiinsdate_lt() ;
	/**  
	 * 获取结束时间  
	 * @return prclosetime 结束时间  
	 */
	
	public String getPrclosetime();
	/**  
	 * 获取开始时间  
	 * @return propentime 开始时间  
	 */
	
	public String getPropentime();
	/**
	 * 需要过滤掉的eiid(应急资源专用)
	 * @return the eiidNotIn
	 */
	public String getEiidNotIn();
	
	public String getEiid_cld_ywxt();
	
	public String getEiid_cld_cj();
	
	public String getEiid_cld_yjzy();
	
	public String getEiname_q();
	
	/**
	 * 应急资源专用
	 * 资源类型(1:应急,0:演练)
	 * @return
	 */
	public String getResourceType();
}