/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.svc.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_���̹���_��ѯVO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSVC01001VO extends BaseVO implements Serializable {

	/**
	 * ���̶���List
	 */
	
	protected List<IG500Info> processRecordList;

	/**
	 * ���췽��
	 * @param processRecordList List<ProcessRecord>
	 */
	
	public IGSVC01001VO(List<IG500Info> processRecordList) {
		this.processRecordList = processRecordList;
	}
	
	/**
	 * ��ȡ���̶���List
	 * @return List<ProcessRecord>
	 */
	
	public List<IG500Info> getProcessRecordList() {
		return processRecordList;
	}
}
