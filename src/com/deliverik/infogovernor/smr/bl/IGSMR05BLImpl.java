/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.infogovernor.smr.bl.task.ReportHistoryVWBL;
import com.deliverik.infogovernor.smr.dto.IGSMR05DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0501Form;
import com.deliverik.infogovernor.smr.form.IGSMR0502Form;
import com.deliverik.infogovernor.smr.model.ReportHistoryVWInfo;
import com.deliverik.infogovernor.smr.model.condition.ReportHistoryVWSearchCondImpl;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������ҵ���߼�����
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGSMR05BLImpl extends BaseBLImpl implements IGSMR05BL{
	
	private static Log log = LogFactory.getLog(IGSMR05BLImpl.class);

	/** ������ʷ���¼��ͼBL */
	protected ReportHistoryVWBL reportHistoryVWBL;
	
	/** ���̶���BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	/**
	 * ������ʷ���¼��ͼBL�趨
	 * @param reportHistoryVWBL ������ʷ���¼��ͼBL
	 */
	public void setReportHistoryVWBL(ReportHistoryVWBL reportHistoryVWBL) {
		this.reportHistoryVWBL = reportHistoryVWBL;
	}
	/**
	 * ���̶���BL�趨
	 * @param workFlowDefinitionBL ���̶���BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	/**
	 * ��ѯ������Ϣ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR05DTO searchRegulatoryHistoryListAction(IGSMR05DTO dto) throws BLException{
		log.debug("==============��ѯ������Ϣ������ʼ===============");
		//����ȡ��
		IGSMR0501Form form = dto.getIgsmr0501Form();
		//ʵ������ѯ����
		ReportHistoryVWSearchCondImpl cond = new ReportHistoryVWSearchCondImpl();
		cond.setPdid(form.getPdid());
		cond.setPrtype(form.getPrtype());
		cond.setCurrentPrid(form.getCurrentPrid());
		List<ReportHistoryVWInfo> reportHistoryVWInfoList = reportHistoryVWBL.searchReportHistoryVWInfoList(cond);
		dto.setReportHistoryVWInfoList(reportHistoryVWInfoList);
		log.debug("==============��ѯ������Ϣ��������===============");
		return dto;
	}
	
	/**
	 * �˵����ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR05DTO searchReportDescAction(IGSMR05DTO dto) throws BLException {
		log.debug("===============�˵����ѯ������ʼ===============");
		//dto����ȡ��
		IGSMR0502Form form = dto.getIgsmr0502Form();
		IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(form.getPdid());
		if(pd != null){
			form.setReportdesc(pd.getReportdesc());
		}
		log.debug("===============�˵����ѯ��������===============");
		return dto;
	}
}
