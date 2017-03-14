/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.crc.model.IGCRC1301VWInfo;
import com.deliverik.infogovernor.crc.model.IGCRC2001VWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:年度事件查询VO 
 * </p>
 * 
 * @version 1.0
 */

public class IGCRC2001VO extends BaseVO implements Serializable{

	/** 列合计的集合 */
	protected List<Integer> sumList;
	/** 行合计的集合 */
	protected List<IGCRC2002VO> igcrc2002voList;
	
	public List<Integer> getSumList() {
		return sumList;
	}

	public void setSumList(List<Integer> sumList) {
		this.sumList = sumList;
	}

	public List<IGCRC2002VO> getIgcrc2002voList() {
		return igcrc2002voList;
	}

	public void setIgcrc2002voList(List<IGCRC2002VO> igcrc2002voList) {
		this.igcrc2002voList = igcrc2002voList;
	}

	
	
}
