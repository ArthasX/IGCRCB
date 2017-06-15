/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.entity.DepartModelVW;
import com.deliverik.infogovernor.crc.model.entity.ModelVW;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:�ĵ���Ϣͳ��VO 
 * </p>
 * 
 * @author ʷ����
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC1304VO extends BaseVO{

	/** �ĵ���Ϣ���� */
	protected List<IGCRC1303VWInfo> igcrc1304VWList;

	protected Map<String,Integer> maps;
	
	protected List<DepartModelVW> listVM = new ArrayList<DepartModelVW>();
	
	protected List<IG500Info> processList;

	public List<DepartModelVW> getListVM() {
		return listVM;
	}

	public void setListVM(List<DepartModelVW> listVM) {
		this.listVM = listVM;
	}

	/**
	 * �ĵ���Ϣ����ȡ��
	 * @return prList �ĵ���Ϣ����
	 */
	public List<IGCRC1303VWInfo> getIgcrc1304VWList() {
		return igcrc1304VWList;
	}

	/**
	 * �ĵ���Ϣ�����趨
	 * @param prList �ĵ���Ϣ����
	 */
	
	
	public void setIgcrc1304VWList(List<IGCRC1303VWInfo> igcrc1304vwList) {
		igcrc1304VWList = igcrc1304vwList;
	}
	
	public void setMaps(Map<String,Integer> maps) {
		this.maps = maps; 
	}

	public Map<String, Integer> getMaps() {
		return maps;
	}

	/**
	 * @return the processList
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}

	/**
	 * @param processList the processList to set
	 */
	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
	}
	
	
}
