/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.cic.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 配置一致性比对_对比结果查看画面VO
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIC02021VO extends BaseVO implements Serializable{
    /** 比对结果Map */
    protected Map<String, List<IGCIC02022VO>> resultVoMap;

    /** 
     * 比对结果Map 取得
     * @return resultVoMap 比对结果Map 
     */
    public Map<String, List<IGCIC02022VO>> getResultVoMap() {
        return resultVoMap;
    }

    /** 
     * 比对结果Map 设定
     * @param resultVoMap 比对结果Map 
     */
    public void setResultVoMap(Map<String, List<IGCIC02022VO>> resultVoMap) {
        this.resultVoMap = resultVoMap;
    }
}


