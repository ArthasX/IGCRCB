package com.deliverik.infogovernor.soc.mnt.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.mnt.model.SOC0306Info;

/**
 * IGMNT02071VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGMNT02071VO extends BaseVO implements Serializable{

	/** �������ݱ���list */
	protected List<SOC0306Info> soc0306List;

	/**
	 * �������ݱ���listȡ��
	 *
	 * @return soc0306List �������ݱ���list
	 */
	public List<SOC0306Info> getSoc0306List() {
		return soc0306List;
	}

	/**
	 * �������ݱ���list�趨
	 *
	 * @param soc0306List �������ݱ���list
	 */
	public void setSoc0306List(List<SOC0306Info> soc0306List) {
		this.soc0306List = soc0306List;
	}
	
}


