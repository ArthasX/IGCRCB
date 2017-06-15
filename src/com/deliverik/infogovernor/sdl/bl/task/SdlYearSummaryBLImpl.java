package com.deliverik.infogovernor.sdl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sdl.model.SdlYearSummary;
import com.deliverik.infogovernor.sdl.model.condition.SdlYearSummarySearchCond;
import com.deliverik.infogovernor.sdl.model.dao.SdlYearSummaryVWDAO;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_ͳ�ƽӿ�ʵ��
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public class SdlYearSummaryBLImpl extends BaseBLImpl implements SdlYearSummaryBL {

	/** SdlYearSummaryVWDAO DAO */
	protected SdlYearSummaryVWDAO sdlYearSummaryVWDAO;

	public void setSdlYearSummaryVWDAO(SdlYearSummaryVWDAO sdlYearSummaryVWDAO) {
		this.sdlYearSummaryVWDAO = sdlYearSummaryVWDAO;
	}

	/**
	 * <p>
	 * Description: ͳ�Ʋ�ѯ
	 * </p>
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return List<SdlDefineInfo>
	 * @author liupeng@deliverik.com
	 */
	public List<SdlYearSummary> searchSdlYearSummary(SdlYearSummarySearchCond cond, int start, int count){
		List<SdlYearSummary> ret = sdlYearSummaryVWDAO.findByCond(cond,start,count);
		return ret;
	}

}
