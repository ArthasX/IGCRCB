/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.drm.model.DrillplanInfo;
import com.deliverik.infogovernor.drm.model.DrillplanitemInfo;

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
public class IGDRM06031VO extends BaseVO{

	protected List<DrillplanitemInfo> drillItemList;

	protected DrillplanInfo drillplan;
	
    public DrillplanInfo getDrillplan() {
        return drillplan;
    }

    public void setDrillplan(DrillplanInfo drillplan) {
        this.drillplan = drillplan;
    }

    public List<DrillplanitemInfo> getDrillItemList() {
        return drillItemList;
    }

    public void setDrillItemList(List<DrillplanitemInfo> drillItemList) {
        this.drillItemList = drillItemList;
    }

	
	
	
}
