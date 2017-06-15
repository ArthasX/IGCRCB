package com.deliverik.infogovernor.crc.model.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.crc.model.ChangeProcessVWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 变更查询VO
 * </p>
 * 
 * @author changhao@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGCRC14011VO extends BaseVO {
	
	/** vo*/
	List<IGCRC14012VO> igcrc14012vos;

	/** 变更流程集合*/
	List<ChangeProcessVWInfo> changeProcessVWInfos;
	/**
	 * vo取得
	 * @return the igcrc14012vos
	 */
	public List<IGCRC14012VO> getIgcrc14012vos() {
		return igcrc14012vos;
	}

	/**
	 * vo设定
	 * @param igcrc14012vos the vo
	 */
	public void setIgcrc14012vos(List<IGCRC14012VO> igcrc14012vos) {
		this.igcrc14012vos = igcrc14012vos;
	}

	/**
	 * 变更流程集合取得
	 * @return the changeProcessVWInfos
	 */
	public List<ChangeProcessVWInfo> getChangeProcessVWInfos() {
		return changeProcessVWInfos;
	}

	/**
	 * 变更流程集合设定
	 * @param changeProcessVWInfos the 变更流程集合
	 */
	public void setChangeProcessVWInfos(
			List<ChangeProcessVWInfo> changeProcessVWInfos) {
		this.changeProcessVWInfos = changeProcessVWInfos;
	}
	
}
