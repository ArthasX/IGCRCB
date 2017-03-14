/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 概述: 日常维护登记实体接口
 * 功能描述: 日常维护登记实体接口
 * 创建记录: 2012/04/01
 * 修改记录: 
 */
public interface OnDutyPersonRecordInfo extends BaseModel{
    
    /**
     * 日常维护登记主键ID取得
     * @return 日常维护登记主键ID
     */
    public Integer getOdprid();
    
    /**
     * 日常维护登记来访人员取得
     * @return 日常维护登记来访人员取得
     */
    public String getOdprguest();
    
    /**
     * 日常维护登记单位取得
     * @return 日常维护登记单位取得
     */
    public String getOdprguestorg();
    
    /**
     * 日常维护登记来访身份取得
     * @return 日常维护登记来访身份取得
     */
    public String getOdprguestidnum();
    
    /**
     * 日常维护登记来访进入区域取得
     * @return 日常维护登记来访进入区域取得
     */
    public String getOdprarea();
    
    /**
     * 日常维护登记来访来访时间取得
     * @return 日常维护登记来访来访时间取得
     */
    public String getOdprctime();
    
    /**
     * 日常维护登记来访来访时间取得
     * @return 日常维护登记来访来访时间取得
     */
    public String getOdprltime();
    
    /**
     * 日常维护登记操作人取得
     * @return 日常维护登记操作人取得
     */
    public String getOdpropter();
    
    /**
     * 日常维护登记批准人取得
     * @return 日常维护登记批准人取得
     */
    public String getOdpracter();
    
    /**
     * 日常维护登记记录人取得
     * @return 日常维护登记记录人取得
     */
    public String getOdprusername();
    
    /**
     * 日常维护登记操作目标取得
     * @return 日常维护登记操作目标取得
     */
    public String getOdprtarget();
    
    /**
     * 日常维护登记操作记录取得
     * @return 日常维护登记操作记录取得
     */
    public String getOdprrecord();
    
    /**
     * 日常维护登记录入时间取得
     * @return 日常维护登记录入时间取得
     */
    public String getOdprinserttime();
    
    /**
     * 日常维护登记编辑记录取得
     * @return 日常维护登记编辑记录取得
     */
    public String getOdprmodtime();
}
