package com.deliverik.infogovernor.soc.mnt.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0307Info;

/**
 * IGMNT02061VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGMNT02061VO extends BaseVO implements Serializable{

	/**������־���������List	 */
    protected List<SOC0307Info> soc0307List;

	/**
	 * ������־���������Listȡ��
	 *
	 * @return soc0307List ������־���������List
	 */
	public List<SOC0307Info> getSoc0307List() {
		return soc0307List;
	}

	/**
	 * ������־���������List�趨
	 *
	 * @param soc0307List ������־���������List
	 */
	public void setSoc0307List(List<SOC0307Info> soc0307List) {
		this.soc0307List = soc0307List;
	}
	
}


