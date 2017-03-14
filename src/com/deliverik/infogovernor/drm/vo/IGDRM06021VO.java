/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.drm.model.DrillplanInfo;

/**
 * <p>
 * Title:InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 演练计划查询VO
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM06021VO extends BaseVO{

	protected List<DrillplanInfo> drilllist;

	List<Map<String, Object>> searchDrillplanMap;
    public List<DrillplanInfo> getDrilllist() {
        return drilllist;
    }
    public void setDrilllist(List<DrillplanInfo> drilllist) {
        this.drilllist = drilllist;
    }
	public List<Map<String, Object>> getSearchDrillplanMap() {
		return searchDrillplanMap;
	}
	public void setSearchDrillplanMap(List<Map<String, Object>> searchDrillplanMap) {
		this.searchDrillplanMap = searchDrillplanMap;
	}
	
	
}
