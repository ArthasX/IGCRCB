package com.deliverik.infogovernor.kgm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetailDef;

/**
 * 概述:选择业务系统VO
 * 功能描述：选择业务系统VO
 * 创建记录：cdd 2010/12/07
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGKGM02331VO  extends BaseVO implements Serializable{

	 /**业务系统分类列表*/
	protected List<CodeDetailDef> BusinessSystemList;

	public List<CodeDetailDef> getBusinessSystemList() {
		return BusinessSystemList;
	}

	public void setBusinessSystemList(List<CodeDetailDef> businessSystemList) {
		BusinessSystemList = businessSystemList;
	}
	
	
	
	
}
