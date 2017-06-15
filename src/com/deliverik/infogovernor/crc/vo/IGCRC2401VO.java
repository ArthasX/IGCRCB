/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:事件平均解决时间VO 
 * </p>
 * 
 * @version 1.0
 */

public class IGCRC2401VO extends BaseVO implements Serializable{

	/**   */	
	private static final long serialVersionUID = 1L;
	
	/** 事件平均解决时间集合 */
	protected List<IGCRC2402VO> igcrc2402voList;
	
	/**
	 * 事件平均解决时间集合取得
	 * @return igcrc2402voList  事件平均解决时间集合
	 */
	public List<IGCRC2402VO> getIgcrc2402voList() {
		return igcrc2402voList;
	}
	/**
	 * 事件平均解决时间集合设定
	 * @param igcrc2402voList  事件平均解决时间集合
	 */
	public void setIgcrc2402voList(List<IGCRC2402VO> igcrc2402voList) {
		this.igcrc2402voList = igcrc2402voList;
	}
	
	


	
	
}
