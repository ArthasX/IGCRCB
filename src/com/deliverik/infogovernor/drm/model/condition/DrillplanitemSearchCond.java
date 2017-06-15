/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: 演练计划条目检索条件接口
  * 功能描述: 演练计划条目检索条件接口
  * 创建记录: 2015/02/28
  * 修改记录: 
  */
public interface DrillplanitemSearchCond {

    public Integer getDid() ;

    public Integer getPrid();

    public String getStatus() ;

    public String getExpecttimestart() ;

    public String getExpecttimeend();

    public String getDiname() ;

    public String getDicontant();

    public String getDidestination() ;

    public String getDiscene();

    public String getDiscope();

    public String getDidutyorg() ;

    public String getPartorg();
    
}