package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.cim.model.IG500VWInfo;

/**
 * 资产相关流程ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM01581VO extends BaseVO implements Serializable{
	
	protected List<IG500VWInfo> res500VWList;

	/**
	 * res500VWList取得
	 * @return res500VWList res500VWList
	 */
	public List<IG500VWInfo> getRes500VWList() {
		return res500VWList;
	}

	/**
	 * res500VWList设定
	 * @param res500VWList res500VWList
	 */
	public void setRes500VWList(List<IG500VWInfo> res500vwList) {
		res500VWList = res500vwList;
	}
	
	
}


