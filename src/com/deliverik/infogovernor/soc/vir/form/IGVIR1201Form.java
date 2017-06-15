/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 资源分配情况Form
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR1201Form extends BaseForm{

    /** 主机名称 */
	protected String hostname;

    /**
     * 获取主机名称
     * @return 主机名称 
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * 设置主机名称
     * @param hostname 主机名称
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
	
}
