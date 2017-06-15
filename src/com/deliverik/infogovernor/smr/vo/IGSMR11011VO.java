/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.entity.AnnualReportVW;

/**
 * ����:���������ѯ��� 
 * �������������������ѯ��� 
 * �����ˣ�����͢
 * ������¼�� 2013-08-08
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR11011VO extends BaseVO {

	/** �걨��ѯ���*/
	protected Map<String,List<AnnualReportVW>> map_arq;
	
	/** �걨һ��������ѯ���*/
	protected Map<String,List<AnnualReportVW>> map_first;
	
	/** �걨����������ѯ���*/
	protected List<RegulatoryReportInstanceInfo> second_list;
	
	/**
	 * �걨��ѯ���ȡ��
	 * 
	 * @return �걨��ѯ���
	 */
	public Map<String, List<AnnualReportVW>> getMap_arq() {
		return map_arq;
	}

	
	/**
	 * �걨��ѯ����趨
	 * 
	 * @param arqMap �걨��ѯ���
	 */
	public void setMap_arq(Map<String, List<AnnualReportVW>> map_arq) {
		this.map_arq = map_arq;
	}	

	
	/**
	 * �걨һ��������ѯ���ȡ��
	 * 
	 * @return �걨һ��������ѯ���
	 */
	public Map<String, List<AnnualReportVW>> getMap_first() {
		return map_first;
	}

	/**
	 * �걨һ��������ѯ����趨
	 * 
	 * @param first_list �걨һ��������ѯ���
	 */
	public void setMap_first(Map<String, List<AnnualReportVW>> map_first) {
		this.map_first = map_first;
	}
	
	
	/**
	 * �걨����������ѯ���ȡ��
	 * 
	 * @return �걨����������ѯ���
	 */
	public List<RegulatoryReportInstanceInfo> getSecond_list() {
		return second_list;
	}
	
	/**
	 * �걨����������ѯ����趨
	 * 
	 * @param second_list �걨����������ѯ���
	 */
	public void setSecond_list(List<RegulatoryReportInstanceInfo> second_list) {
		this.second_list = second_list;
	}
}
