/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
  * 概述: SOC0117VW检索条件接口
  * 功能描述: SOC0117VW检索条件接口
  * 创建记录: 2016/06/21
  * 修改记录: 
  */
public interface SOC0117VWSearchCond {

	/**
	 * 资产模型状态取得
	 * @return 资产模型状态
	 */
	public String getEstatus();


	/**
	 * 资产模型父级层次码检索条件取得
	 * @return 资产模型父级层次码检索条件
	 */
	public String getEparcoding_q();


	/**
	 * 资产模型父级层次码前方一致模糊匹配检索条件取得
	 * @return 资产模型父级层次码前方一致模糊匹配检索条件
	 */
	public String getEsyscoding_q();


	/**
	 * 资产模型层次码前方一致模糊匹配检索条件取得
	 * @return 资产模型层次码前方一致模糊匹配检索条件
	 */
	public String getSyscoding_q();


	/**
	 * 资产模型层次码取得
	 * @return 资产模型层次码
	 */
	public String getEsyscoding();
	
	/**
	 * 资产模型层次码前方一致模糊匹配检索条件（not like）取得
	 * @return 资产模型层次码前方一致模糊匹配检索条件（not like）
	 */
	public String getEsyscoding_nq();

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEidStr();


	/**
	 * 资产模型编号取得
	 * @return 资产模型编号
	 */
	public String getElabel();

	/**
	 * 资产模型名称取得
	 * @return 资产模型名称
	 */
	public String getEname();
	
	/**
	 * 资产模型分类取得
	 * @return 资产模型分类
	 */
	public String getEcategory_q();
	
	/**
	 * 资产模型层次码区间检索条件取得
	 * @return 去掉资产模型层次码与该集合内的元素模糊匹配的资产模型信息
	 */
	public List<String> getDelList_q();
	
	/**
	 * 资产模型层次码区间检索条件取得（平台保留）
	 * @return 资产模型层次码区间检索条件
	 */
	public List<String> getDelList();
	

	/**
	 * 资产模型层次码区间检索条件取得（平台保留）
	 * @return 资产模型层次码区间检索条件
	 */
	public List<String> getSelectList();

	
	/**
	 * 资产模型层次码辅助检索条件取得（平台保留）
	 * @return 资产模型层次码辅助检索条件
	 */
	public String getEsyscoding_tree();


	/**
	 * 资产模型层次码检索条件取得（平台保留）
	 * @return 资产模型层次码检索条件
	 */
	public String getEparcoding_status_start();


	/**
	 * 资产模型父级层次码检索条件取得（平台保留）
	 * @return 资产模型父级层次码检索条件
	 */
	public String getEparcoding_status();
	
	/**
	 * 资产模型父级层次码取得（平台保留）
	 * @return 资产模型父级层次码
	 */
	public String getEparcoding();

	

	/**
	 * 资产模型分类取得（平台保留）
	 * @return 资产模型分类
	 */
	public String getEcategory();

	/**
	 * 资产模型一级子类取得（平台保留）
	 * @return 资产模型一级子类
	 */
	public String getEkey1();

	/**
	 * 资产模型二级子类取得（平台保留）
	 * @return 资产模型二级子类
	 */
	public String getEkey2();

	/**
	 * 资产模型三级子类取得（平台保留）
	 * @return 资产模型三级子类
	 */
	public String getEkey3();

	/**
	 * 资产模型层次码区间检索条件取得 （平台保留）
	 * @return 资产模型层次码区间检索条件
	 */
	public List<String> getEsyscodingList();

	/**
	 * 资产模型ID like取得
	 * @return 资产模型ID like
	 */
	public String getEidStr_like();
	/**
	 * @return the 数据库id
	 */
	public Integer getId();
}