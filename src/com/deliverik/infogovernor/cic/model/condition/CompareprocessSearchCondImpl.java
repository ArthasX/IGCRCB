/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.condition;

/**
  * 概述: 对比记录检索条件实现
  * 功能描述: 对比记录检索条件实现
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public class CompareprocessSearchCondImpl implements
		CompareprocessSearchCond {

    /** 开始时间Form */
    protected String cpstarttime_form;
    
    /** 开始时间To */
    protected String cpstarttime_to;

    /** 
     * 开始时间Form 取得
     * @return cpstarttime_form 开始时间Form 
     */
    public String getCpstarttime_form() {
        return cpstarttime_form;
    }

    /** 
     * 开始时间Form 设定
     * @param cpstarttime_form 开始时间Form 
     */
    public void setCpstarttime_form(String cpstarttime_form) {
        this.cpstarttime_form = cpstarttime_form;
    }

    /** 
     * 开始时间To 取得
     * @return cpstarttime_to 开始时间To 
     */
    public String getCpstarttime_to() {
        return cpstarttime_to;
    }

    /** 
     * 开始时间To 设定
     * @param cpstarttime_to 开始时间To 
     */
    public void setCpstarttime_to(String cpstarttime_to) {
        this.cpstarttime_to = cpstarttime_to;
    }
    
}