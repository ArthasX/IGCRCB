/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.drm.model.DrillplanInfo;

/**
 * <p>
 * Title:InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����ƻ���ѯVO
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
