/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_�¼�KPIҵ���߼��ӿ�ʵ��
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */

public class IGSDL07BLImpl extends BaseBLImpl implements IGSDL07BL {

	static Log log = LogFactory.getLog(IGSDL07BLImpl.class);

	/** �¼�KPIͳ����ϢBL */
	protected IncidentKpiBL incidentKpiBL;

	public void setIncidentKpiBL(IncidentKpiBL incidentKpiBL) {
		this.incidentKpiBL = incidentKpiBL;
	}


	/**
	 * �¼�KPIͳ����ϢList��ѯ����
	 *
	 * @param dto IGSDL07DTO
	 * @return IGSDL07DTO
	 */
	public IGSDL07DTO searchIncidentKpiListAction(IGSDL07DTO dto) throws BLException {
		
		log.debug("========�¼�KPIͳ����ϢList��ѯ����ʼ========");
		IncidentKpiSearchCondImpl cond = this.getIncidentKpiCond(dto);
		
		List<IncidentKpi> incidentKpiList = this.incidentKpiBL.searchIncidentKpi(cond, 0, 0);
		
		dto.setIncidentKpiList(incidentKpiList);
		
		log.debug("========�¼�KPIͳ����ϢList��ѯ��������========");
		return dto;
	}
	
	/**
	 * �¼�KPIͳ����Ϣ�¼����Map��ѯ����
	 *
	 * @param dto IGSDL07DTO
	 * @return IGSDL07DTO
	 */
	public IGSDL07DTO searchTypeMapAction(IGSDL07DTO dto) throws BLException {
		
		log.debug("========�¼�KPIͳ����Ϣ�¼����Map��ѯ����ʼ========");
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
		
		log.debug("========�¼�KPIͳ����Ϣ�¼����Map��ѯ��������========");
		return dto;
	}
	
	/**
	 * �¼�KPIͳ����Ϣ�����̶�Map��ѯ����
	 *
	 * @param dto IGSDL07DTO
	 * @return IGSDL07DTO
	 */
	public IGSDL07DTO searchUrgencyMapAction(IGSDL07DTO dto) throws BLException {
		
		log.debug("========�¼�KPIͳ����Ϣ�����̶�Map��ѯ����ʼ========");
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
		
		log.debug("========�¼�KPIͳ����Ϣ�����̶�Map��ѯ��������========");
		return dto;
	}

	/**
	 * �¼�KPIͳ����Ϣ��ѯ������֯
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

