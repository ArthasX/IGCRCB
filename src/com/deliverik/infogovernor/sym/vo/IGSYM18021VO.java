/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sym.model.MSGFILTERInfo;

/**

 */
@SuppressWarnings("serial")
public class IGSYM18021VO extends BaseVO implements Serializable{
	
	/** IP��Ϣ */
	protected List<MSGFILTERInfo> ipInfoList;

	public List<MSGFILTERInfo> getIpInfoList() {
		return ipInfoList;
	}

	public void setIpInfoList(List<MSGFILTERInfo> ipInfoList) {
		this.ipInfoList = ipInfoList;
	}

	
	
}


