package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.cim.model.IG500VWInfo;

/**
 * �ʲ�������̣֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM01581VO extends BaseVO implements Serializable{
	
	protected List<IG500VWInfo> res500VWList;

	/**
	 * res500VWListȡ��
	 * @return res500VWList res500VWList
	 */
	public List<IG500VWInfo> getRes500VWList() {
		return res500VWList;
	}

	/**
	 * res500VWList�趨
	 * @param res500VWList res500VWList
	 */
	public void setRes500VWList(List<IG500VWInfo> res500vwList) {
		res500VWList = res500vwList;
	}
	
	
}


