package com.deliverik.infogovernor.ram.bl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.ram.bl.task.AssessmentScoreVWBL;
import com.deliverik.infogovernor.ram.dto.IGRAM04DTO;
import com.deliverik.infogovernor.ram.model.condition.AssessmentScoreVWSearchCondImpl;

/**
 * ���ռ��ҵ���߼�ʵ��
 *
 */

public class IGRAM04BLImpl extends BaseBLImpl implements IGRAM04BL {

	static Log log = LogFactory.getLog(IGRAM04BLImpl.class);
	/** �����÷�BL */
	protected AssessmentScoreVWBL assessmentScoreVWBL;

	/**
	 * assessmentScoreVWBL�趨
	 */
	public void setAssessmentScoreVWBL(AssessmentScoreVWBL assessmentScoreVWBL) {
		this.assessmentScoreVWBL = assessmentScoreVWBL;
	}

	/**
	 * <p>
	 * Description: ���������������ͳ��
	 * </p>
	 * 
	 * @param dto IGSVC13DTO
	 * @return IGSVC13DTO
	 * @throws BLException
	 * @author tangzhen@deliverik.com
	 */
	public IGRAM04DTO getAssessmentYearReport(IGRAM04DTO dto)
			throws BLException {

		AssessmentScoreVWSearchCondImpl cond= new AssessmentScoreVWSearchCondImpl();
		cond.setCurrentyear(dto.getCurrentyear());
		List<Object[]> list = assessmentScoreVWBL.getAssessmentYearReport(cond);		
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

		dto.setYearReport(strList);
		return dto;
	}
}
