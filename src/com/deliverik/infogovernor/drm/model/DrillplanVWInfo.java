/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 演练计划接口
  * 功能描述: 演练计划接口
  * 创建记录: 2015/02/28
  * 修改记录: 
  */
public interface DrillplanVWInfo extends BaseModel {

    public Integer getDiid();

    public Integer getDid() ;

    public Integer getPrid();

    public String getStatus() ;

    public String getExpecttime();

    public String getActstarttime();

    public String getDiname() ;

    public String getDicontant();

    public String getDidestination();

    public String getDiscene() ;

    public String getDiscope();

    public String getDidutyorg();
    
    public String getPartorg();

    public String getDuserid();

    public String getDusername() ;

    public String getCrttime() ;

    public String getJudgetime() ;

    public String getDserial() ;

    public String getDname();

    public String getJudgestatus();

   
}