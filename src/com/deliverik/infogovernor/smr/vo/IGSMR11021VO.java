/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.smr.model.entity.AnnualReportVW;

/**
 * ����:�߰�
 * �����������߰�
 * �����ˣ�����͢
 * ������¼�� 2013-08-08
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR11021VO extends BaseVO {

	/** ��鿴��ѯ���*/
	protected Map<String,List<AnnualReportVW>> map_see;
	
	/**
	 * ��鿴��ѯ���ȡ��
	 * 
	 * @return ��鿴��ѯ���
	 */

	public Map<String, List<AnnualReportVW>> getMap_see() {
		return map_see;
	}

	/**
	 * ��鿴��ѯ����趨
	 * 
	 * @param list_rri ��鿴��ѯ���
	 */
	public void setMap_see(Map<String, List<AnnualReportVW>> map_see) {
		this.map_see = map_see;
	}
}
