package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.TableSpaceInfo;

/**
 * ��Ա��Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM01361VO extends BaseVO implements Serializable{
	
	/** ���ݱ���Ϣ������� */
	protected List<TableSpaceInfo> tableSpaceInfoList;

	public List<TableSpaceInfo> getTableSpaceInfoList() {
		return tableSpaceInfoList;
	}

	public void setTableSpaceInfoList(List<TableSpaceInfo> tableSpaceInfoList) {
		this.tableSpaceInfoList = tableSpaceInfoList;
	}

}


