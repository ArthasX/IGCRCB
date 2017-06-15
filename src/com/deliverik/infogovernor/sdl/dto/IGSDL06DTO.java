/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.sdl.model.ChangeKpi;
import com.deliverik.infogovernor.sdl.model.condition.ChangeKpiSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_ͳ��DTO
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSDL06DTO extends BaseDTO implements Serializable {
	
	/**���KPIͳ�Ʋ�ѯBean */
	protected ChangeKpiSearchCond changeKpiSearchCond;
	
	/**�����ѯ������¼��*/
	protected int maxSearchCount;

	/**��ҳBean*/
	protected PagingDTO pagingDto;
	
	/**���KPIͳ����ϢList*/
	protected List<ChangeKpi> changeKpiList;

	public List<ChangeKpi> getChangeKpiList() {
		return changeKpiList;
	}

	public void setChangeKpiList(List<ChangeKpi> changeKpiList) {
		this.changeKpiList = changeKpiList;
	}

	public ChangeKpiSearchCond getChangeKpiSearchCond() {
		return changeKpiSearchCond;
	}

	public void setChangeKpiSearchCond(ChangeKpiSearchCond changeKpiSearchCond) {
		this.changeKpiSearchCond = changeKpiSearchCond;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}	
	
}
