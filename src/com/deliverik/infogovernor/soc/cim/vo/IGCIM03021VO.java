package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.SOC0137Info;
import com.deliverik.framework.soc.asset.model.SOC0103Info;

/**
 * 审计对比结果检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM03021VO extends BaseVO implements Serializable{
	
	/** 审计对比结果检索结果 */
	protected List<SOC0103Info> SOC0103List;
	
	/** 审计对比结果检索结果 */
	protected List<SOC0137Info> SOC0137List;

	/**
	 * sOC0103List取得
	 *
	 * @return sOC0103List sOC0103List
	 */
	public List<SOC0103Info> getSOC0103List() {
		return SOC0103List;
	}

	/**
	 * sOC0103List设定
	 *
	 * @param list sOC0103List
	 */
	public void setSOC0103List(List<SOC0103Info> list) {
		SOC0103List = list;
	}

	/**
	 * sOC0137List取得
	 *
	 * @return sOC0137List sOC0137List
	 */
	public List<SOC0137Info> getSOC0137List() {
		return SOC0137List;
	}

	/**
	 * sOC0137List设定
	 *
	 * @param list sOC0137List
	 */
	public void setSOC0137List(List<SOC0137Info> list) {
		SOC0137List = list;
	}
	
	
}


