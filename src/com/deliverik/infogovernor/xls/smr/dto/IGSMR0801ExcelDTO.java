/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.xls.smr.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.smr.vo.IGSMR08001VO;

/**
 * ����:����˵��� 
 * ��������������˵���
 * �����ˣ�����͢
 * ������¼�� 2013-09-03
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR0801ExcelDTO extends ExcelDTO {

	
	
	/**���������˲�ѯ���*/
	protected List<IGSMR08001VO> list;
	
	/**���������˲�ѯ����ϼ�*/
	protected IGSMR08001VO orgsum;
		
	
	/** ���˿�ʼ���� */
	protected String assessstartdate;
	
	/** ���˽������� */
	protected String assessoverdate;

	
	public List<IGSMR08001VO> getList() {
		return list;
	}

	public void setList(List<IGSMR08001VO> list) {
		this.list = list;
	}

	public IGSMR08001VO getOrgsum() {
		return orgsum;
	}

	public void setOrgsum(IGSMR08001VO orgsum) {
		this.orgsum = orgsum;
	}


	public String getAssessstartdate() {
		return assessstartdate;
	}

	public void setAssessstartdate(String assessstartdate) {
		this.assessstartdate = assessstartdate;
	}

	public String getAssessoverdate() {
		return assessoverdate;
	}

	public void setAssessoverdate(String assessoverdate) {
		this.assessoverdate = assessoverdate;
	}	
	
	
}
