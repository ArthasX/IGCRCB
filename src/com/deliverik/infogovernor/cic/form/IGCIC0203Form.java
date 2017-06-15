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
public class IGCIC0203Form extends BaseForm {

    /** 比配规则对象表主键 */
    protected Integer coid;
    
    /** 比对任务表主键 */
    protected Integer cpid;

    /** 
     * 比配规则对象表主键 取得
     * @return coid 比配规则对象表主键 
     */
    public Integer getCoid() {
        return coid;
    }

    /** 
     * 比配规则对象表主键 设定
     * @param coid 比配规则对象表主键 
     */
    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    /** 
     * 比对任务表主键 取得
     * @return cpid 比对任务表主键 
     */
    public Integer getCpid() {
        return cpid;
    }

    /** 
     * 比对任务表主键 设定
     * @param cpid 比对任务表主键 
     */
    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }
    
}
