/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.xls.smr.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.smr.vo.IGSMR08001VO;

/**
 * ����:����˰���Ա
 * ��������������˰���Ա
 * �����ˣ�����͢
 * ������¼�� 2013-09-04
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR0802ExcelDTO extends ExcelDTO {

	/**����Ա���˲�ѯ���*/
	protected Map<String,List<IGSMR08001VO>> map;
	
	/**���������˲�ѯ����ϼ�*/
	protected IGSMR08001VO usersum;
	
	/** ���˿�ʼ���� */
	protected String assessstartdate;
	
	/** ���˽������� */
	protected String assessoverdate;
	
	public Map<String, List<IGSMR08001VO>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<IGSMR08001VO>> map) {
		this.map = map;
	}


	public IGSMR08001VO getUsersum() {
		return usersum;
	}

	public void setUsersum(IGSMR08001VO usersum) {
		this.usersum = usersum;
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
