/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:�¼�ƽ�����ʱ��VO 
 * </p>
 * 
 * @version 1.0
 */

public class IGCRC2401VO extends BaseVO implements Serializable{

	/**   */	
	private static final long serialVersionUID = 1L;
	
	/** �¼�ƽ�����ʱ�伯�� */
	protected List<IGCRC2402VO> igcrc2402voList;
	
	/**
	 * �¼�ƽ�����ʱ�伯��ȡ��
	 * @return igcrc2402voList  �¼�ƽ�����ʱ�伯��
	 */
	public List<IGCRC2402VO> getIgcrc2402voList() {
		return igcrc2402voList;
	}
	/**
	 * �¼�ƽ�����ʱ�伯���趨
	 * @param igcrc2402voList  �¼�ƽ�����ʱ�伯��
	 */
	public void setIgcrc2402voList(List<IGCRC2402VO> igcrc2402voList) {
		this.igcrc2402voList = igcrc2402voList;
	}
	
	


	
	
}
