/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.wkm.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGWKM01101VO extends BaseVO{

	/** ���̶���List */
	protected List<IG500Info> processList;

	/**
	 * ���̶���Listȡ��
	 * @return processList ���̶���List
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}

	/**
	 * ���̶���List�趨
	 * @param processList ���̶���List
	 */
	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
	}
}
