/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.IG622Info;
import com.deliverik.infogovernor.sym.form.IGSYM1802Form;
import com.deliverik.infogovernor.sym.form.IGSYM1803Form;
import com.deliverik.infogovernor.sym.model.MSGFILTERInfo;

@SuppressWarnings("serial")
public class IGSYM20DTO extends BaseDTO implements Serializable {

	/** ���������� */
	public int maxSearchCount;

	/** ��ҳ��DTO */
	public PagingDTO pagingDto;

	public IGSYM1803Form igsym1803form;

	public MSGFILTERInfo msgfilterinfo;

	public MSGFILTERInfo getMsgfilterinfo() {
		return msgfilterinfo;
	}

	public void setMsgfilterinfo(MSGFILTERInfo msgfilterinfo) {
		this.msgfilterinfo = msgfilterinfo;
	}

	public List<MSGFILTERInfo> ipInfoList;

	public IGSYM1803Form getIgsym1803form() {
		return igsym1803form;
	}

	public void setIgsym1803form(IGSYM1803Form igsym1803form) {
		this.igsym1803form = igsym1803form;
	}

	public List<MSGFILTERInfo> getIpInfoList() {
		return ipInfoList;
	}

	public void setIpInfoList(List<MSGFILTERInfo> ipInfoList) {
		this.ipInfoList = ipInfoList;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

}
