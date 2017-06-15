/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.svc.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_����̨_ͨ�ò�ѯVO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSVC01061VO extends BaseVO implements Serializable {

	/**����List*/
	private List<IG500Info> processRecordList;
	
	/**����ģ��鿴ҳURL*/
	private Map<String,String> detailPgMap;
	
	/**
	 * ��ȡ����List
	 * @return ����List
	 */
	public List<IG500Info> getProcessRecordList() {
		return processRecordList;
	}
	

	/**
	 * ��������map
	 * @param processRecordList ����List
	 */

	public void setProcessRecordList(List<IG500Info> processRecordList) {
		this.processRecordList = processRecordList;
	}

	/**
	 * ��ȡ����ģ��鿴ҳURL
	 * @return ����ģ��鿴ҳURL
	 */
	public Map<String,String> getDetailPgMap() {
		return detailPgMap;
	}

	/**
	 * ��������ģ��鿴ҳURL
	 * @param detailPgMap ����ģ��鿴ҳURL
	 */
	public void setDetailPgMap(Map<String,String> detailPgMap) {
		this.detailPgMap = detailPgMap;
	}
	
}
