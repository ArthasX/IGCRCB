package com.deliverik.infogovernor.soc.mnt.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.rpt.model.SOC0423Info;

/**
 * IGMNT01071VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGMNT01121VO extends BaseVO implements Serializable{
	/**������ع���List*/
	protected List<SOC0423Info> soc0423List;

	/**
	 * ������ع���Listȡ��
	 *
	 * @return soc0423List ������ع���List
	 */
	public List<SOC0423Info> getSoc0423List() {
		return soc0423List;
	}

	/**
	 * ������ع���List�趨
	 *
	 * @param soc0423List ������ع���List
	 */
	public void setSoc0423List(List<SOC0423Info> soc0423List) {
		this.soc0423List = soc0423List;
	}

	
}


