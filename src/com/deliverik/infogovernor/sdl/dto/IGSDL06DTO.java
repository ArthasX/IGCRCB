/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_统计DTO
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSDL06DTO extends BaseDTO implements Serializable {
	
	/**变更KPI统计查询Bean */
	protected ChangeKpiSearchCond changeKpiSearchCond;
	
	/**允许查询的最大记录数*/
	protected int maxSearchCount;

	/**分页Bean*/
	protected PagingDTO pagingDto;
	
	/**变更KPI统计信息List*/
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
