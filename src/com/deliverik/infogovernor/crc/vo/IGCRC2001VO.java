/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.crc.model.IGCRC1301VWInfo;
import com.deliverik.infogovernor.crc.model.IGCRC2001VWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:����¼���ѯVO 
 * </p>
 * 
 * @version 1.0
 */

public class IGCRC2001VO extends BaseVO implements Serializable{

	/** �кϼƵļ��� */
	protected List<Integer> sumList;
	/** �кϼƵļ��� */
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
