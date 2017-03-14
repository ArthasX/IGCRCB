/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.cic.vo;

import java.io.Serializable;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;

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
public class IGCIC02031VO extends BaseVO implements Serializable{

    /** 页面显示用Map key：页面显示组名 value：显示对象Map key：模型名称 value：属性列表 */
    protected Map<String, Map<String, IGCIC02032VO>> cic0203ShowMap;

    /** 
     * 页面显示用Mapkey：页面显示组名value：显示对象Mapkey：模型名称value：属性列表 取得
     * @return cic0203ShowMap 页面显示用Mapkey：页面显示组名value：显示对象Mapkey：模型名称value：属性列表 
     */
    public Map<String, Map<String, IGCIC02032VO>> getCic0203ShowMap() {
        return cic0203ShowMap;
    }

    /** 
     * 页面显示用Mapkey：页面显示组名value：显示对象Mapkey：模型名称value：属性列表 设定
     * @param cic0203ShowMap 页面显示用Mapkey：页面显示组名value：显示对象Mapkey：模型名称value：属性列表 
     */
    public void setCic0203ShowMap(Map<String, Map<String, IGCIC02032VO>> cic0203ShowMap) {
        this.cic0203ShowMap = cic0203ShowMap;
    }
    
}


