/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.drm.model.DrillplanVWInfo;

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
public class IGDRM06041VO extends BaseVO{

	protected List<DrillplanVWInfo> drillItemList;

    public List<DrillplanVWInfo> getDrillItemList() {
        return drillItemList;
    }

    public void setDrillItemList(List<DrillplanVWInfo> drillItemList) {
        this.drillItemList = drillItemList;
    }
	
	
}
