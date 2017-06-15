package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
 * <p>
 * 资产信息检索条件
 * </p>
 * <p>
 * （未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>eid</td>
 * <td>资产模型ID</td>
 * </tr>
 * <tr>
 * <td>einame</td>
 * <td>资产名称（模糊匹配）</td>
 * </tr>
 * <tr>
 * <td>eilabel</td>
 * <td>资产编号</td>
 * </tr> 
 * <tr>
 * <td>eiorgsyscoding</td>
 * <td>资产所属机构层次码（前方一致模糊匹配）</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface SOC0118SearchCond {
	
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
	/** 状态不等于 */
	public String getEistatus_ne();

	/** 场景分类查询条件 演练场景:1,应急场景0 */
	public String getScenceCategory();
}
