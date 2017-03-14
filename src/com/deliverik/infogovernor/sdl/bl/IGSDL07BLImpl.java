/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.bl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sdl.bl.task.IncidentKpiBL;
import com.deliverik.infogovernor.sdl.dto.IGSDL07DTO;
import com.deliverik.infogovernor.sdl.model.IncidentKpi;
import com.deliverik.infogovernor.sdl.model.condition.IncidentKpiSearchCond;
import com.deliverik.infogovernor.sdl.model.condition.IncidentKpiSearchCondImpl;
import com.deliverik.infogovernor.util.PRJHelper;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_事件KPI业务逻辑接口实现
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */

public class IGSDL07BLImpl extends BaseBLImpl implements IGSDL07BL {

	static Log log = LogFactory.getLog(IGSDL07BLImpl.class);

	/** 事件KPI统计信息BL */
	protected IncidentKpiBL incidentKpiBL;

	public void setIncidentKpiBL(IncidentKpiBL incidentKpiBL) {
		this.incidentKpiBL = incidentKpiBL;
	}


	/**
	 * 事件KPI统计信息List查询处理
	 *
	 * @param dto IGSDL07DTO
	 * @return IGSDL07DTO
	 */
	public IGSDL07DTO searchIncidentKpiListAction(IGSDL07DTO dto) throws BLException {
		
		log.debug("========事件KPI统计信息List查询处理开始========");
		IncidentKpiSearchCondImpl cond = this.getIncidentKpiCond(dto);
		
		List<IncidentKpi> incidentKpiList = this.incidentKpiBL.searchIncidentKpi(cond, 0, 0);
		
		dto.setIncidentKpiList(incidentKpiList);
		
		log.debug("========事件KPI统计信息List查询处理终了========");
		return dto;
	}
	
	/**
	 * 事件KPI统计信息事件类别Map查询处理
	 *
	 * @param dto IGSDL07DTO
	 * @return IGSDL07DTO
	 */
	public IGSDL07DTO searchTypeMapAction(IGSDL07DTO dto) throws BLException {
		
		log.debug("========事件KPI统计信息事件类别Map查询处理开始========");
		IncidentKpiSearchCondImpl cond = this.getIncidentKpiCond(dto);
		
		List<IncidentKpi> incidentKpiList = this.incidentKpiBL.searchIncidentKpi(cond, 0, 0);
		
		Map<String,List<IncidentKpi>> incidentKpiMap = new LinkedHashMap<String, List<IncidentKpi>>();
		
		for(IncidentKpi kpi : incidentKpiList){
			String key = kpi.getTypeName();
			if(!incidentKpiMap.containsKey(key)){
				incidentKpiMap.put(key, new ArrayList<IncidentKpi>());
			}
			incidentKpiMap.get(key).add(kpi);
		}
		
		dto.setIncidentKpiMap(incidentKpiMap);
		
		log.debug("========事件KPI统计信息事件类别Map查询处理终了========");
		return dto;
	}
	
	/**
	 * 事件KPI统计信息紧急程度Map查询处理
	 *
	 * @param dto IGSDL07DTO
	 * @return IGSDL07DTO
	 */
	public IGSDL07DTO searchUrgencyMapAction(IGSDL07DTO dto) throws BLException {
		
		log.debug("========事件KPI统计信息紧急程度Map查询处理开始========");
		IncidentKpiSearchCondImpl cond = this.getIncidentKpiCond(dto);
		
		List<IncidentKpi> incidentKpiList = this.incidentKpiBL.searchIncidentKpi(cond, 0, 0);
		
		Map<String,List<IncidentKpi>> incidentKpiMap = new LinkedHashMap<String, List<IncidentKpi>>();
		
		for(IncidentKpi kpi : incidentKpiList){
			String key = kpi.getUrgencyName();
			if(!incidentKpiMap.containsKey(key)){
				incidentKpiMap.put(key, new ArrayList<IncidentKpi>());
			}
			incidentKpiMap.get(key).add(kpi);
		}
		
		dto.setIncidentKpiMap(incidentKpiMap);
		
		log.debug("========事件KPI统计信息紧急程度Map查询处理终了========");
		return dto;
	}

	/**
	 * 事件KPI统计信息查询条件组织
	 *
	 * @param dto IGSDL07DTO
	 * @return IGSDL07DTO
	 */
	private IncidentKpiSearchCondImpl getIncidentKpiCond(IGSDL07DTO dto){
		IncidentKpiSearchCond ikscond = dto.getIncidentKpiSearchCond()	;
		IncidentKpiSearchCondImpl cond = new IncidentKpiSearchCondImpl();
		cond.setRadioValue(ikscond.getRadioValue());
		String kpiYear = ikscond.getKpiYear();
		String kpiMonth = ikscond.getKpiMonth();
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
		return cond;
	}

}

