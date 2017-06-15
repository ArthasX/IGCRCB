package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.CIResultInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * CI变更对比结果检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM22021VO extends BaseVO implements Serializable{
	
	/** CI变更对比结果检索结果 */
	protected List<CIResultInfo> ciResultList;

	/**
	 * CI变更对比结果检索结果取得
	 * @return CI变更对比结果检索结果
	 */
	public List<CIResultInfo> getCiResultList() {
		return ciResultList;
	}

	/**
	 * CI变更对比结果检索结果设置
	 * @param ciResultList CI变更对比结果检索结果
	 */
	public void setCiResultList(List<CIResultInfo> ciResultList) {
		this.ciResultList = ciResultList;
	}
}


