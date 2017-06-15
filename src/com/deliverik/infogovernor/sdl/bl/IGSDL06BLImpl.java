/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.bl;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sdl.bl.task.ChangeKpiBL;
import com.deliverik.infogovernor.sdl.dto.IGSDL06DTO;
import com.deliverik.infogovernor.sdl.model.ChangeKpi;
import com.deliverik.infogovernor.sdl.model.condition.ChangeKpiSearchCond;
import com.deliverik.infogovernor.sdl.model.condition.ChangeKpiSearchCondImpl;
import com.deliverik.infogovernor.util.PRJHelper;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_变更KPI业务逻辑接口实现
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */

public class IGSDL06BLImpl extends BaseBLImpl implements IGSDL06BL {

	static Log log = LogFactory.getLog(IGSDL06BLImpl.class);

	/** 变更KPI统计信息BL */
	protected ChangeKpiBL changeKpiBL;
	
	public void setChangeKpiBL(ChangeKpiBL changeKpiBL) {
		this.changeKpiBL = changeKpiBL;
	}



	/**
	 * 变更KPI统计信息查询处理
	 *
	 * @param dto IGSDL06DTO
	 * @return IGSDL06DTO
	 */
	public IGSDL06DTO searchChangeKpiAction(IGSDL06DTO dto) throws BLException {

		log.debug("========变更KPI统计信息查询处理开始========");
		
		ChangeKpiSearchCond ckscond = dto.getChangeKpiSearchCond()	;
		ChangeKpiSearchCondImpl cond = new ChangeKpiSearchCondImpl();
		
		String kpiYear = ckscond.getKpiYear();
		String kpiMonth = ckscond.getKpiMonth();
		String day = "";

		if (StringUtils.isEmpty(kpiMonth)) {
			cond.setKpiOpenTime(kpiYear+"/"+"01"+"/"+"01"+" "+"00:00");
			cond.setKpiEndTime(kpiYear+"/"+"12"+"/"+"31"+" "+"23:59");
		}else{
			switch(Integer.parseInt(kpiMonth)){
			case 1:	
			case 3:	
			case 5:	
			case 7:	
			case 8:	
			case 10:	
			case 12:	
				day = 31+"";
				break;
			case 2:	
				if(PRJHelper.isLeapYear(Calendar.getInstance().get(Calendar.YEAR))){
					day = 29+"";
				}else{
					day = 28+"";
				}
				break;
			case 4:	
			case 6:	
			case 9:	
			case 11:	
				day = 30+"";
				break;
			}
			cond.setKpiOpenTime(kpiYear+"/"+kpiMonth+"/"+"01"+" "+"00:00");
			cond.setKpiEndTime(kpiYear+"/"+kpiMonth+"/"+day+" "+"23:59");
		}
		List<ChangeKpi> changeKpiList = this.changeKpiBL.searchChangeKpi(cond, 0, 0);
		
		dto.setChangeKpiList(changeKpiList);
		
		log.debug("========变更KPI统计信息查询处理终了========");
		return dto;
	}

}

