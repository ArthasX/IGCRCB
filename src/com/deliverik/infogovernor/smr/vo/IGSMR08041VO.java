/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;


/**
 * ����:��������ϵͳ������� ��ѯVO
 * ������������������ϵͳ������� ��ѯVO
 * ������¼�� 
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR08041VO extends BaseVO{

	
	/**��ر�����1�к�������ϵͳ���������Ϣ*/
	protected Map<String, List<String[]>> map_report;

	/**
	 * ��ر�����1�к�������ϵͳ���������Ϣȡ��
	 *
	 * @return map_report ��ر�����1�к�������ϵͳ���������Ϣ
	 */
	public Map<String, List<String[]>> getMap_report() {
		return map_report;
	}

	/**
	 * ��ر�����1�к�������ϵͳ���������Ϣ�趨
	 *
	 * @param map_report ��ر�����1�к�������ϵͳ���������Ϣ
	 */
	public void setMap_report(Map<String, List<String[]>> map_report) {
		this.map_report = map_report;
	}
	
	
}
