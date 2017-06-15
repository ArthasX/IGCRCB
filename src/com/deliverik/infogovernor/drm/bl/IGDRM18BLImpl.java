/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.drm.bl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.StatisticsBL;
import com.deliverik.infogovernor.drm.dto.IGDRM18DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1801Form;
import com.deliverik.infogovernor.drm.form.IGDRM1802Form;
import com.deliverik.infogovernor.drm.form.IGDRM1811Form;
import com.deliverik.infogovernor.drm.model.condition.StatisticsSearchCondImpl;

/**
 * <p>
 * Title : InfoGovernor Ӧ������
 * </p>
 * <p>
 * Description:ͳ�Ʒ�������BLʵ��
 * </p>
 * 
 * @author zhangjian@deliverik.com
 * @version 1.0
 */
public class IGDRM18BLImpl extends BaseBLImpl implements IGDRM18BL {
	
	/** ��־����ʵ�� */
	private static final Log log = LogFactory.getLog(IGDRM18BLImpl.class);
	
	/**
	 * ͳ�Ʋ�ѯBL
	 */
	private StatisticsBL StatisticsBL;
	
	private SOC0118BL soc0118BL;

	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	public void setStatisticsBL(StatisticsBL statisticsBL) {
		StatisticsBL = statisticsBL;
	}
	
	
	/**
	 * Ӧ��Ԥ��ͳ�Ʋ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM18DTO getPlanRate(IGDRM18DTO dto)throws BLException{
		log.debug("========Ԥ��ͳ�Ʋ�ѯ��ʼ=========");
		IGDRM1801Form form = (IGDRM1801Form)dto.getForm();
		StatisticsSearchCondImpl cond = new StatisticsSearchCondImpl();
		BeanUtils.copyProperties(form, cond);
		dto.setPlanRateList(StatisticsBL.planStatistics(cond));
		log.debug("========Ԥ��ͳ�Ʋ�ѯ����=========");
		return dto;
	}
	
	/**
	 * ����ͳ�Ʋ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM18DTO getDrillRate(IGDRM18DTO dto)throws BLException{
		log.debug("========����ͳ�Ʋ�ѯ��ʼ=========");
		IGDRM1811Form form = (IGDRM1811Form)dto.getForm();
		StatisticsSearchCondImpl cond = new StatisticsSearchCondImpl();
		BeanUtils.copyProperties(form, cond);
		dto.setDrillRateList(StatisticsBL.drillStatistics(cond));
		dto.setDrillTypeRateList(StatisticsBL.drillTypeStatistics(cond));
		log.debug("========����ͳ�Ʋ�ѯ����=========");
		return dto;
	}
	
	/**
	 * Ԥ����ȡ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM18DTO searchPlanInfo(IGDRM18DTO dto) throws BLException{
		
		log.debug("========Ԥ����ȡ��ʼ=========");
		
		IGDRM1802Form form  = (IGDRM1802Form) dto.getForm();
		
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		cond.setEsyscoding(form.getEsyscoding());
		
		cond.setEiinsdate_gt(form.getEiinstimeFrom());;
		
		cond.setEiinsdate_lt(form.getEiinstimeTo());
		
		cond.setEiname(form.getEiname());
		
		//��ѯ�����Ԥ��
		if(IGDRMCONSTANTS.PLAN_SEARCH_TYPE_UPGRADE.equals(form.getSearchFlag())){
			cond.setUpgrade(true);
		}else if(IGDRMCONSTANTS.PLAN_SEARCH_TYPE_DIRLL.equals(form.getSearchFlag())){
			StatisticsSearchCondImpl scond = new StatisticsSearchCondImpl();
			scond.setEsyscoding(form.getEsyscoding());
			List<Map<String, Object>> eiidList = StatisticsBL.getSceneEiids(scond);
			List<String> eiids = new ArrayList<String>();
			for(Map<String, Object> map : eiidList ){
				if(map.get("EIID")!=null)
				eiids.add(map.get("EIID").toString());
			}
			cond.setEiidList(eiids);
		}
		
		List<SOC0124Info> soc0118List = soc0118BL.searchEntityItemVW(cond);
		
		dto.setPlanList(soc0118List);
		
		log.debug("========Ԥ����ȡ����=========");
		
		return dto;
	}
	
}
