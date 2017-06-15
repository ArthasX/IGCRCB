/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.cic.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.cic.model.CompareresultVWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 配置一致性比对_对比结果明细查看画面VO
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIC02032VO extends BaseVO implements Serializable{

    public IGCIC02032VO() {
        this.crvwLst = new LinkedHashMap<String, List<CompareresultVWInfo>>();
    }
    
    /** 属性列表 */
    protected Map<String, List<CompareresultVWInfo>> crvwLst;
    
    /** 是否为基本属性 0：不是 1：是 */
    protected Integer isBase;

    /** 
     * 属性列表 取得
     * @return crvwLst 属性列表 
     */
    public Map<String, List<CompareresultVWInfo>> getCrvwLst() {
        return crvwLst;
    }

    /** 
     * 属性列表 设定
     * @param crvwLst 属性列表 
     */
    public void setCrvwLst(Map<String, List<CompareresultVWInfo>> crvwLst) {
        this.crvwLst = crvwLst;
    }

    /** 
     * 是否为基本属性0：不是1：是 取得
     * @return isBase 是否为基本属性0：不是1：是 
     */
    public Integer getIsBase() {
        return isBase;
    }

    /** 
     * 是否为基本属性0：不是1：是 设定
     * @param isBase 是否为基本属性0：不是1：是 
     */
    public void setIsBase(Integer isBase) {
        this.isBase = isBase;
    }

}


