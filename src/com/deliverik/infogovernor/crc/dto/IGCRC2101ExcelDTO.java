/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.crc.vo.IGCRC2102VO;

/**	
 * ����:��Ա����ͳ�Ƶ�����DTO
 * ������¼��yukexin    2014-8-15 ����5:15:02	
 * �޸ļ�¼��null
 */	
@SuppressWarnings("serial")
public class IGCRC2101ExcelDTO extends ExcelDTO{
	
	/** ��Ա����ͳ�Ƽ������ ���ϼ�*/
	protected List<IGCRC2102VO> igcrc2102voList;

	/** ��Ա����ͳ�Ʒ���ϼƽ�� */
	protected List<Integer> listSum;

	public List<IGCRC2102VO> getIgcrc2102voList() {
		return igcrc2102voList;
	}

	public void setIgcrc2102voList(List<IGCRC2102VO> igcrc2102voList) {
		this.igcrc2102voList = igcrc2102voList;
	}

	public List<Integer> getListSum() {
		return listSum;
	}

	public void setListSum(List<Integer> listSum) {
		this.listSum = listSum;
	}
	

	

}
