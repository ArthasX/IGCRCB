/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.condition;

/**
  * 概述: 合同资产信息视图检索条件接口
  * 功能描述: 合同资产信息视图检索条件接口
  * 创建记录: 2012/04/10
  * 修改记录: 
  */
public interface IG499SearchCond {
	/**
	 * 合同类别取得
	 * @return 合同类别
	 */
	public String getCompacttype();


	/**
	 * 签订时间取得
	 * @return 签订时间
	 */
	public String getCondudetime();


	/**
	 * 服务商取得
	 * @return 服务商
	 */
	public String getFacilitator();


	/**
	 * 经手人取得
	 * @return 经手人
	 */
	public String getOperator();


	/**
	 * 合同名称取得
	 * @return 合同名称
	 */
	public String getEiname();


	/**
	 * 合同编号取得
	 * @return 合同编号
	 */
	public String getEilabel();


	/**
	 * 查询时间点取得
	 * @return 查询时间点
	 */
	public String getDatetime();

	/**
	 * 签订时间:从取得
	 * @return 签订时间:从
	 */
	public String getCondudetime_from();

	/**
	 * 签订时间:到取得
	 * @return 签订时间:到
	 */
	public String getCondudetime_to();
	
	/**
	 * 合同eiid
	 * @return
	 */
	public String getEiid();

	/**
	 * 是否付款完毕取得
	 * @return
	 */
	public String getPayed();
	
	/**
	 * 所属机构码获取
	 * @return eiorgsyscoding_in
	 */
	public String getEiorgsyscoding_in();

	/**
	 * 所属机构码设定
	 * @param eiorgsyscoding_in
	 */
	public void setEiorgsyscoding_in(String eiorgsyscoding_in);
	
	/**
	 * eiusername取得
	 *
	 * @return eiusername eiusername
	 */
	public String getEiusername();
	
	/**
     * 资产模型名取得
     *
     * @return ename 资产模型名
     */
    public String getEname();

    /**
     * 资产项所属模型取得
     *
     * @return esyscoding 资产项所属模型
     */
    public String getEsyscoding();
}