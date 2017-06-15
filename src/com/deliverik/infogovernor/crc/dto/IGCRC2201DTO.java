/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.crc.form.IGCRC2201Form;
import com.deliverik.infogovernor.crc.model.IGCRC2201VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2201Cond;
import com.deliverik.infogovernor.crc.vo.IGCRC2202VO;

/**	
 * ����:�������ͳ��DTO
 * ������¼��yukexin    2014-8-15 ����5:15:21	
 * �޸ļ�¼��null
 */	
public class IGCRC2201DTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/** �������ͳ��Form */
	protected IGCRC2201Form igcrc2201Form;

	/** �������ͳ�Ʋ�ѯ�����ӿ� */
	protected IGCRC2201Cond igcrc2201Cond;

	/** �������ͳ�ƽӿ� */
	protected IGCRC2201VWInfo igcrc2201VWInfo;
	
	/** ���ص�ҳ����ʾ�ı������  */	
	protected List<IGCRC2202VO> igcrc2202voList;

	/**
	 * �������ͳ��Formȡ��
	 * @return igcrc2201Form  �������ͳ��Form
	 */
	public IGCRC2201Form getIgcrc2201Form() {
		return igcrc2201Form;
	}

	/**
	 * �������ͳ��Form�趨
	 * @param igcrc2201Form  �������ͳ��Form
	 */
	public void setIgcrc2201Form(IGCRC2201Form igcrc2201Form) {
		this.igcrc2201Form = igcrc2201Form;
	}

	/**
	 * �������ͳ�Ʋ�ѯ�����ӿ�ȡ��
	 * @return igcrc2201Cond  �������ͳ�Ʋ�ѯ�����ӿ�
	 */
	public IGCRC2201Cond getIgcrc2201Cond() {
		return igcrc2201Cond;
	}

	/**
	 * �������ͳ�Ʋ�ѯ�����ӿ��趨
	 * @param igcrc2201Cond  �������ͳ�Ʋ�ѯ�����ӿ�
	 */
	public void setIgcrc2201Cond(IGCRC2201Cond igcrc2201Cond) {
		this.igcrc2201Cond = igcrc2201Cond;
	}

	/**
	 * �������ͳ�ƽӿ�ȡ��
	 * @return igcrc2201VWInfo  �������ͳ�ƽӿ�
	 */
	public IGCRC2201VWInfo getIgcrc2201VWInfo() {
		return igcrc2201VWInfo;
	}

	/**
	 * �������ͳ�ƽӿ��趨
	 * @param igcrc2201vwInfo  igcrc2201VWInfo
	 */
	public void setIgcrc2201VWInfo(IGCRC2201VWInfo igcrc2201vwInfo) {
		igcrc2201VWInfo = igcrc2201vwInfo;
	}

	/**
	 * ���ص�ҳ����ʾ�ı������ȡ��
	 * @return igcrc2202voList  ���ص�ҳ����ʾ�ı������
	 */
	public List<IGCRC2202VO> getIgcrc2202voList() {
		return igcrc2202voList;
	}

	/**
	 * ���ص�ҳ����ʾ�ı�������趨
	 * @param igcrc2202voList  ���ص�ҳ����ʾ�ı������
	 */
	public void setIgcrc2202voList(List<IGCRC2202VO> igcrc2202voList) {
		this.igcrc2202voList = igcrc2202voList;
	}


}
