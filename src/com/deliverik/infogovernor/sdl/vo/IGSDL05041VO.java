/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sdl.model.SdlYearSummary;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_ͳ��VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL05041VO extends BaseVO implements Serializable {
	
	/**ͳ����ϢList*/
	protected List<SdlYearSummary> sdlYearSummaryList;
	
	/**
	 * ��ȡͳ����ϢList
	 * @return List<SdlYearSummary>
	 */
	
	public List<SdlYearSummary> getSdlYearSummaryList() {
		return sdlYearSummaryList;
	}
	

	/**
	 * ���캯��
	 * @param sdlYearSummaryList List<SdlYearSummary>
	 */
	public IGSDL05041VO(List<SdlYearSummary> sdlYearSummaryList) {
		this.sdlYearSummaryList = sdlYearSummaryList;
	}
}
