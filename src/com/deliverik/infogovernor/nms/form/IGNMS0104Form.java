/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 网络拓扑手动扫描推送form
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGNMS0104Form extends BaseForm {

	/** 关闭推送连接 */
	protected String doClose;
	
	/** 组版本 */
	protected String gversion;
	
	/** 推送内容xml */
	protected String pushXML;

    /**
     * 获取关闭推送连接
     * @return 关闭推送连接 
     */
    public String getDoClose() {
        return doClose;
    }

    /**
     * 设置关闭推送连接
     * @param doClose 关闭推送连接
     */
    public void setDoClose(String doClose) {
        this.doClose = doClose;
    }

    /**
     * 获取组版本
     * @return 组版本 
     */
    public String getGversion() {
        return gversion;
    }

    /**
     * 设置组版本
     * @param gversion 组版本
     */
    public void setGversion(String gversion) {
        this.gversion = gversion;
    }

    /**
     * 获取推送内容xml
     * @return 推送内容xml 
     */
    public String getPushXML() {
        return pushXML;
    }

    /**
     * 设置推送内容xml
     * @param pushXML 推送内容xml
     */
    public void setPushXML(String pushXML) {
        this.pushXML = pushXML;
    }
}
