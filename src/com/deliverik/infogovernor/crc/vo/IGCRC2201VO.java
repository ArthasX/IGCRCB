/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;


/**	
 * ����: ���ͳ�Ʋ�ѯVO
 * ������¼��yukexin    2014-8-8 ����9:08:40	
 * �޸ļ�¼��null
 */	
public class IGCRC2201VO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;
	/** ���ͳ�Ʋ�ѯList */
	private List<IGCRC2202VO> igcrc2202voList;
	/**
	 * ���ͳ�Ʋ�ѯListȡ��
	 * @return igcrc2202voList  ���ͳ�Ʋ�ѯList
	 */
	public List<IGCRC2202VO> getIgcrc2202voList() {
		return igcrc2202voList;
	}
	/**
	 * ���ͳ�Ʋ�ѯList�趨
	 * @param igcrc2202voList  ���ͳ�Ʋ�ѯList
	 */
	public void setIgcrc2202voList(List<IGCRC2202VO> igcrc2202voList) {
		this.igcrc2202voList = igcrc2202voList;
	}

}
