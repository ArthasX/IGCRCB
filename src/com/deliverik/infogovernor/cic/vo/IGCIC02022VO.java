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
public class IGCIC02022VO extends BaseVO implements Serializable{
	
    /** 业务系统id */
    protected Integer crsystemid;

    /** 业务系统名称 */
    protected String crsystemname;
    
    /** 对比类型 */
    protected String crtype;
    
    /** 对比源对象名称d */
    protected String cosourceName;

    /** 对比目标对象集合 */
    protected Map<String, List<IGCIC02023VO>>  cotargetVOLi;

    /** 
     * 业务系统id 取得
     * @return crsystemid 业务系统id 
     */
    public Integer getCrsystemid() {
        return crsystemid;
    }

    /** 
     * 业务系统id 设定
     * @param crsystemid 业务系统id 
     */
    public void setCrsystemid(Integer crsystemid) {
        this.crsystemid = crsystemid;
    }

    /** 
     * 业务系统名称 取得
     * @return crsystemname 业务系统名称 
     */
    public String getCrsystemname() {
        return crsystemname;
    }

    /** 
     * 业务系统名称 设定
     * @param crsystemname 业务系统名称 
     */
    public void setCrsystemname(String crsystemname) {
        this.crsystemname = crsystemname;
    }

    /** 
     * 对比类型 取得
     * @return crtype 对比类型 
     */
    public String getCrtype() {
        return crtype;
    }

    /** 
     * 对比类型 设定
     * @param crtype 对比类型 
     */
    public void setCrtype(String crtype) {
        this.crtype = crtype;
    }

    /** 
     * 对比源对象名称d 取得
     * @return cosourceName 对比源对象名称d 
     */
    public String getCosourceName() {
        return cosourceName;
    }

    /** 
     * 对比源对象名称d 设定
     * @param cosourceName 对比源对象名称d 
     */
    public void setCosourceName(String cosourceName) {
        this.cosourceName = cosourceName;
    }

    /** 
     * 对比目标对象集合 取得
     * @return cotargetVOLi 对比目标对象集合 
     */
    public Map<String, List<IGCIC02023VO>> getCotargetVOLi() {
        return cotargetVOLi;
    }

    /** 
     * 对比目标对象集合 设定
     * @param cotargetVOLi 对比目标对象集合 
     */
    public void setCotargetVOLi(Map<String, List<IGCIC02023VO>> cotargetVOLi) {
        this.cotargetVOLi = cotargetVOLi;
    }
    
}


