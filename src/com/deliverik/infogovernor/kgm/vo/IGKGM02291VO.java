/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.kgm.model.KnowLogInfo;
/**
 * ����:֪ʶ����־��ѯVO
 * ����������֪ʶ����־��ѯVO
 * ������¼��2011/05/30
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGKGM02291VO extends BaseVO implements Serializable{

	/**֪ʶ����־*/
	protected List<KnowLogInfo> recordList;

	/**
	 * ֪ʶ����־ȡ��
	 * @return recordLogMap ֪ʶ����־
	 */
	public List<KnowLogInfo> getRecordList() {
		return recordList;
	}

	/**
	 * ֪ʶ����־�趨
	 * @param recordLogMap ֪ʶ����־
	 */
	public void setRecordList(List<KnowLogInfo> recordList) {
		this.recordList = recordList;
	}

}


