package com.deliverik.infogovernor.xls.prj.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.prj.vo.IGPRJ01HistoryVO;

@SuppressWarnings("serial")
public class IGPRJ0108ExcelDTO extends ExcelDTO  {
	
	protected IGPRJ01HistoryVO[] historyVOs;
	
	protected List<CodeDetail> codeDetailList;

	public IGPRJ01HistoryVO[] getHistoryVOs() {
		return historyVOs;
	}

	public void setHistoryVOs(IGPRJ01HistoryVO[] historyVOs) {
		this.historyVOs = historyVOs;
	}

	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}

	public void setCodeDetailList(List<CodeDetail> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}
	
}
