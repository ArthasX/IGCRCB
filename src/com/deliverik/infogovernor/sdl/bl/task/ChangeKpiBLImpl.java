package com.deliverik.infogovernor.sdl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sdl.model.ChangeKpi;
import com.deliverik.infogovernor.sdl.model.condition.ChangeKpiSearchCond;
import com.deliverik.infogovernor.sdl.model.dao.ChangeKpiVWDAO;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_���KPIͳ�ƽӿ�ʵ��
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */
public class ChangeKpiBLImpl extends BaseBLImpl implements ChangeKpiBL {

	/** ChangeKpiVWDAO DAO */
	protected ChangeKpiVWDAO changeKpiVWDAO;

	public void setChangeKpiVWDAO(ChangeKpiVWDAO changeKpiVWDAO) {
		this.changeKpiVWDAO = changeKpiVWDAO;
	}



	/**
	 * <p>
	 * Description: ���KPIͳ�Ʋ�ѯ
	 * </p>
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return List<ChangeKpi>
	 * @author maozhipeng@deliverik.com
	 */
	public List<ChangeKpi> searchChangeKpi(ChangeKpiSearchCond cond, int start, int count){
		List<ChangeKpi> ret = changeKpiVWDAO.findByCond(cond,start,count);
		return ret;
	}

}
