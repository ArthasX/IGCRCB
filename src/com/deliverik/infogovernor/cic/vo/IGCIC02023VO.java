/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.cic.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.cic.model.CompareobjectHistoryInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 配置一致性比对_配置一致性比对_对比结果查看画面_显示内容VO
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIC02023VO extends BaseVO implements Serializable{
	
    /** 对象表主键 */
    protected Integer coid;

    /** 主机名称 */
    protected String hostname;
    
    /** 是否不同 0:相同 1:不同*/
    protected String isDifferent;

    /** 
     * 对象表主键 取得
     * @return coid 对象表主键 
     */
    public Integer getCoid() {
        return coid;
    }

    /** 
     * 对象表主键 设定
     * @param coid 对象表主键 
     */
    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    /** 
     * 主机名称 取得
     * @return hostname 主机名称 
     */
    public String getHostname() {
        return hostname;
    }

    /** 
     * 主机名称 设定
     * @param hostname 主机名称 
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /** 
     * 是否不同0:相同1:不同 取得
     * @return isDifferent 是否不同0:相同1:不同 
     */
    public String getIsDifferent() {
        return isDifferent;
    }

    /** 
     * 是否不同0:相同1:不同 设定
     * @param isDifferent 是否不同0:相同1:不同 
     */
    public void setIsDifferent(String isDifferent) {
        this.isDifferent = isDifferent;
    }
    
}


