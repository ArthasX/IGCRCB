/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.entity.DepartModelVW;
import com.deliverik.infogovernor.crc.model.entity.ModelVW;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:文档信息统计VO 
 * </p>
 * 
 * @author 史凯龙
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC1304VO extends BaseVO{

	/** 文档信息集合 */
	protected List<IGCRC1303VWInfo> igcrc1304VWList;

	protected Map<String,Integer> maps;
	
	protected List<DepartModelVW> listVM = new ArrayList<DepartModelVW>();
	
	protected List<IG500Info> processList;

	public List<DepartModelVW> getListVM() {
		return listVM;
	}

	public void setListVM(List<DepartModelVW> listVM) {
		this.listVM = listVM;
	}

	/**
	 * 文档信息集合取得
	 * @return prList 文档信息集合
	 */
	public List<IGCRC1303VWInfo> getIgcrc1304VWList() {
		return igcrc1304VWList;
	}

	/**
	 * 文档信息集合设定
	 * @param prList 文档信息集合
	 */
	
	
	public void setIgcrc1304VWList(List<IGCRC1303VWInfo> igcrc1304vwList) {
		igcrc1304VWList = igcrc1304vwList;
	}
	
	public void setMaps(Map<String,Integer> maps) {
		this.maps = maps; 
	}

	public Map<String, Integer> getMaps() {
		return maps;
	}

	/**
	 * @return the processList
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}

	/**
	 * @param processList the processList to set
	 */
	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
	}
	
	
}
