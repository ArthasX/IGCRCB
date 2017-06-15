package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.TableSpaceInfo;

/**
 * 人员信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM01361VO extends BaseVO implements Serializable{
	
	/** 数据表信息检索结果 */
	protected List<TableSpaceInfo> tableSpaceInfoList;

	public List<TableSpaceInfo> getTableSpaceInfoList() {
		return tableSpaceInfoList;
	}

	public void setTableSpaceInfoList(List<TableSpaceInfo> tableSpaceInfoList) {
		this.tableSpaceInfoList = tableSpaceInfoList;
	}

}


