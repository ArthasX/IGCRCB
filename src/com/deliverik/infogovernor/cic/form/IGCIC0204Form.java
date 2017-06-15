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
 * Description: 配置一致性比对_对比结果详细画面FORM
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIC0204Form extends BaseForm {

    /** 比对结果表主键 */
    protected Integer crid;

    /** 
     * 比对结果表主键 取得
     * @return crid 比对结果表主键 
     */
    public Integer getCrid() {
        return crid;
    }

    /** 
     * 比对结果表主键 设定
     * @param crid 比对结果表主键 
     */
    public void setCrid(Integer crid) {
        this.crid = crid;
    }
    
    
}
