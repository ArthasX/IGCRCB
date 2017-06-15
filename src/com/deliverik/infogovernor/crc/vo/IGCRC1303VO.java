/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
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
public class IGCRC1303VO extends BaseVO{

	/** 文档信息集合 */
	protected List<IGCRC1303VWInfo> igcrc1303VWList;

	protected Map<String,Integer> maps;
	
	protected List<ModelVW> ListVM = new ArrayList<ModelVW>();
	
	protected List<Integer> listSum = new ArrayList<Integer>();
	
	public List<ModelVW> getListVM() {
		return ListVM;
	}

	public void setListVM(List<ModelVW> listVM) {
		ListVM = listVM;
	}

	/**
	 * 文档信息集合取得
	 * @return prList 文档信息集合
	 */
	public List<IGCRC1303VWInfo> getIgcrc1303VWList() {
		return igcrc1303VWList;
	}

	/**
	 * 文档信息集合设定
	 * @param prList 文档信息集合
	 */
	public void setIgcrc1303VWList(List<IGCRC1303VWInfo> igcrc1303vwList) {
		igcrc1303VWList = igcrc1303vwList;
	}
	
	
	
	/**
	 * @return the listSum
	 */
	public List<Integer> getListSum() {
		return listSum;
	}

	/**
	 * @param listSum the listSum to set
	 */
	public void setListSum(List<Integer> listSum) {
		this.listSum = listSum;
	}

	public void setMaps(Map<String,Integer> maps) {
		this.maps = maps; 
	}

	public Map<String, Integer> getMaps() {
		return maps;
	}
	
	
}
