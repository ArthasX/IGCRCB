package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;

/**
 * IGCOM03011VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCOM0304VO extends BaseVO implements Serializable{
	
	/**  */
	protected List<CodeDetail> codeDetailList;

	/**
	 * 
	 * @param entityData
	 */
	public IGCOM0304VO(List<CodeDetail> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}
	
	/**
	 * 
	 * @return 
	 */
	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}

}


