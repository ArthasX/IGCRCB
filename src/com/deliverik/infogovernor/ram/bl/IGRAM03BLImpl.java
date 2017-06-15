package com.deliverik.infogovernor.ram.bl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.infogovernor.ram.bl.task.AssessmentScoreVWBL;
import com.deliverik.infogovernor.ram.dto.IGRAM03DTO;
import com.deliverik.infogovernor.ram.model.condition.AssessmentScoreVWSearchCondImpl;

/**
 * ������������ͳ�� ���ҵ���߼�ʵ��
 *
 */

public class IGRAM03BLImpl extends BaseBLImpl implements IGRAM03BL {

	static Log log = LogFactory.getLog(IGRAM03BLImpl.class);
	
	/** �����÷�BL */
	protected AssessmentScoreVWBL assessmentScoreVWBL;

	/**
	 * assessmentScoreVWBL�趨
	 */
	public void setAssessmentScoreVWBL(AssessmentScoreVWBL assessmentScoreVWBL) {
		this.assessmentScoreVWBL = assessmentScoreVWBL;
	}
	
	/** ���̶���BL */
	protected IG380BL ig380BL;

	/**
	 * ig380BL�趨
	 */
	public void setIg380BL(IG380BL ig380bl) {
		ig380BL = ig380bl;
	}



	/**
	 * <p>
	 * Description: ����������������ͳ��
	 * </p>
	 * 
	 * @param dto IGSVC13DTO
	 * @return IGSVC13DTO
	 * @throws BLException
	 * @author tangzhen@deliverik.com
	 */
	public IGRAM03DTO getAssessmentOrgReport(IGRAM03DTO dto) throws BLException {
		
		AssessmentScoreVWSearchCondImpl cond= new AssessmentScoreVWSearchCondImpl();
		
		IG380SearchCondImpl ig380SearchCond = new IG380SearchCondImpl();
		ig380SearchCond.setPtid(IGRAMCONSTANTS.ramPtid);
		List<IG380Info> ig380List =  ig380BL.searchIG380Info(ig380SearchCond);
//		List<IG380Info> ig380List =  ig380BL.searchIG380InfoByPtid(IGRAMCONSTANTS.ramPtid);
		List<String> pdidList = new ArrayList<String>();
		for(IG380Info info : ig380List){
			//�������� pdid ����
			pdidList.add(info.getPdid());
		}
		cond.setList(pdidList);
		//�Ӷ���������ʼ��ѯ
		cond.setTopOrgid(IGRAMCONSTANTS.ORGSYSCODING);
		//ͳ�ƿ�ʼʱ��ͽ���ʱ��
		cond.setBegintime(dto.getPropentime_from()+" 00:00");
		cond.setEndtime(dto.getPropentime_to()+" 24:00");
		
		List<Object[]> list = assessmentScoreVWBL.getAssessmentOrgReport(cond);
		List<String> strList = new ArrayList();
		for(Object[] obs : list){
			for(Object o:obs){
				String str = String.valueOf(o);
				if("null".equals(str)){
					strList.add("0");
				}else{
					strList.add(str);
				}
			}
		}

		dto.setOrgReport(strList);
		return dto;
	}
}
