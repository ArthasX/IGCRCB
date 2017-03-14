/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sdl.model.ChangeKpi;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_���KPIͳ��VO
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL06011VO extends BaseVO implements Serializable {
	
	/**���KPIͳ����ϢList*/
	protected List<ChangeKpi> changeKpiList;

	/**
	 * ���캯��
	 * @param ChangeKpiList List<ChangeKpi>
	 * 
	 */
	public IGSDL06011VO(List<ChangeKpi> changeKpiList) {
		this.changeKpiList = changeKpiList;
	}

	/**
	 * ��ȡ���KPIͳ����ϢLis
	 * @return ���KPIͳ����ϢLis
	 */
	public List<ChangeKpi> getChangeKpiList() {
		return changeKpiList;
	}
	
}
