package com.deliverik.infogovernor.sdl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sdl.model.SdlSummary;
import com.deliverik.infogovernor.sdl.model.condition.SdlSummarySearchCond;
import com.deliverik.infogovernor.sdl.model.dao.SdlSummaryVWDAO;


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
public class SdlSummaryBLImpl extends BaseBLImpl implements SdlSummaryBL {

	/** SdlSummaryVWDAO DAO */
	protected SdlSummaryVWDAO sdlSummaryVWDAO;

	public void setSdlSummaryVWDAO(SdlSummaryVWDAO sdlSummaryVWDAO) {
		this.sdlSummaryVWDAO = sdlSummaryVWDAO;
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
	public List<SdlSummary> searchSdlSummary(SdlSummarySearchCond cond, int start, int count){
		List<SdlSummary> ret = sdlSummaryVWDAO.findByCond(cond,start,count);
		return ret;
	}

}
