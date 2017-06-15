/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: 演练计划检索条件接口
  * 功能描述: 演练计划检索条件接口
  * 创建记录: 2015/02/28
  * 修改记录: 
  */
public interface DrillplanSearchCond {
    
    /**
     * 
     * @Title: getJudgeuserid 
     * @Description: TODO 审批人userid取得
     * @return    
     * String    
     * @throws
     */
    public String getJudgeuserid();
    /**
     * 
     * @Title: getJudgeusername 
     * @Description: TODO 审批人username取得
     * @return    
     * String    
     * @throws
     */
    public String getJudgeusername();

    /**
     * 演练计划id取得
     *
     * @return 演练计划id
     */
    public Integer getDid() ;

    /**
     * 演练计划制定人id取得
     *
     * @return 演练计划制定人id
     */
    public String getDuserid();

    /**
     * 演练计划指定人名取得
     *
     * @return 演练计划指定人名
     */
    public String getDusername();


    /**
     * 演练计划编号取得
     *
     * @return 演练计划编号
     */
    public String getDserial();

    /**
     * 演练计划名称取得
     *
     * @return 演练计划名称
     */
    public String getDname() ;
    //创建时间从
    public String getCrttimestart();
    //创建时间到
    public String getCrttimeend(); 
    //审批时间从
    public String getJudgetimestart();
    //审批时间到
    public String getJudgetimeend();
    /**是否是具有审批权限*/
    public String getIsAdmin();
    /**审批状态*/
    public String getJudgestatus() ;
	/**
	 * serial_like   取得
	 * @return serial_like serial_like
	 */
	public String getSerial_like() ;
	
	/**
	 * judgestatus_ne取得
	 *
	 * @return judgestatus_ne judgestatus_ne
	 */
	public String getJudgestatus_ne();
	
	/**  
	 * 获取开始时间  
	 * @return propentime 开始时间  
	 */
	public String getPropentime();
	
	/**  
	 * 获取结束时间  
	 * @return prclosetime 结束时间  
	 */
	
	public String getPrclosetime();
}