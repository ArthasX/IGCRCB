package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * FS关系信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM01341VO extends BaseVO implements Serializable{
	/**
	 * FS关系可选列表
	 */
	protected List<SOC0118Info> entityItemList;
	
	/**
	 * FS关系已经选列表
	 */
	protected List<SOC0118Info> entityItemedList;

	public List<SOC0118Info> getEntityItemList() {
		return entityItemList;
	}

	public void setEntityItemList(List<SOC0118Info> entityItemList) {
		this.entityItemList = entityItemList;
	}

	public List<SOC0118Info> getEntityItemedList() {
		return entityItemedList;
	}

	public void setEntityItemedList(List<SOC0118Info> entityItemedList) {
		this.entityItemedList = entityItemedList;
	}
	
	
	
}


