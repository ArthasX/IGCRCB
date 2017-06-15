/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.cic.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.cic.model.CompareprocessInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 配置一致性比对_对比执行情况查询画面VO
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIC02011VO extends BaseVO implements Serializable{
	
    /** 对比记录集合 */
    protected List<CompareprocessInfo> compareprocessList;

    /** 
     * 对比记录集合 取得
     * @return compareprocessList 对比记录集合 
     */
    public List<CompareprocessInfo> getCompareprocessList() {
        return compareprocessList;
    }

    /** 
     * 对比记录集合 设定
     * @param compareprocessList 对比记录集合 
     */
    public void setCompareprocessList(List<CompareprocessInfo> compareprocessList) {
        this.compareprocessList = compareprocessList;
    }

	
}


