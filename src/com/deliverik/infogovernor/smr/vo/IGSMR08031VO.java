/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.smr.model.ReportDetailVWInfo;


/**
 * ����:��ر�����ϸҳ ��ѯVO
 * ������������ر�����ϸҳ ��ѯVO
 * �����ˣ��
 * ������¼�� 
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR08031VO extends BaseVO{

	
	/**��ر�����ϸҳ��Ϣ*/
	protected Map<String,List<ReportDetailVWInfo>> detailMap;
	
	/**���ر�ʶ*/
	protected String flag;
	
	
	
	
	/**
	 * ��ر�����ϸҳ��Ϣ ȡ��
	 * @return ��ر�����ϸҳ��Ϣ
	 */
	public Map<String, List<ReportDetailVWInfo>> getDetailMap() {
		return detailMap;
	}

	/**
	 * ��ر�����ϸҳ��Ϣ�趨
	 * @param detailMap ��ر�����ϸҳ��Ϣ
	 */
	public void setDetailMap(Map<String, List<ReportDetailVWInfo>> detailMap) {
		this.detailMap = detailMap;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	
}
