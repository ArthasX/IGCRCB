/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.entity.AnnualReportVW;

/**
 * ����:��ҳ����
 * ������������ҳ����
 * �����ˣ�����͢
 * ������¼�� 2013-08-14
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR03041VO extends BaseVO {

	/** ��ҳ��������ѯ���*/
	protected Map<String,List<AnnualReportVW>> map_more;

	public Map<String, List<AnnualReportVW>> getMap_more() {
		return map_more;
	}

	public void setMap_more(Map<String, List<AnnualReportVW>> map_more) {
		this.map_more = map_more;
	}
	
	
}
