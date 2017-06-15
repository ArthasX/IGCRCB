/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.cic.form;

import com.deliverik.framework.base.BaseForm;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 配置一致性比对_对比执行情况查询画面FORM
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIC0201Form extends BaseForm {
	
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
