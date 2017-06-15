package com.deliverik.infogovernor.sdl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sdl.model.IncidentKpi;
import com.deliverik.infogovernor.sdl.model.condition.IncidentKpiSearchCond;
import com.deliverik.infogovernor.sdl.model.dao.IncidentKpiVWDAO;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_�¼�KPIͳ�ƽӿ�ʵ��
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */
public class IncidentKpiBLImpl extends BaseBLImpl implements IncidentKpiBL {

	/** IncidentKpiVWDAO DAO */
	protected IncidentKpiVWDAO incidentKpiVWDAO;

	public void setIncidentKpiVWDAO(IncidentKpiVWDAO incidentKpiVWDAO) {
		this.incidentKpiVWDAO = incidentKpiVWDAO;
	}



	/**
	 * <p>
	 * Description: �¼�KPIͳ�Ʋ�ѯ
	 * </p>
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return List<IncidentKpi>
	 * @author maozhipeng@deliverik.com
	 */
	public List<IncidentKpi> searchIncidentKpi(IncidentKpiSearchCond cond, int start, int count){
		List<IncidentKpi> ret = incidentKpiVWDAO.findByCond(cond,start,count);
		return ret;
	}

}
