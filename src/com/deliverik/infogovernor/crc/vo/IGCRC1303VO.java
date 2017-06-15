/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
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
public class IGCRC1303VO extends BaseVO{

	/** �ĵ���Ϣ���� */
	protected List<IGCRC1303VWInfo> igcrc1303VWList;

	protected Map<String,Integer> maps;
	
	protected List<ModelVW> ListVM = new ArrayList<ModelVW>();
	
	protected List<Integer> listSum = new ArrayList<Integer>();
	
	public List<ModelVW> getListVM() {
		return ListVM;
	}

	public void setListVM(List<ModelVW> listVM) {
		ListVM = listVM;
	}

	/**
	 * �ĵ���Ϣ����ȡ��
	 * @return prList �ĵ���Ϣ����
	 */
	public List<IGCRC1303VWInfo> getIgcrc1303VWList() {
		return igcrc1303VWList;
	}

	/**
	 * �ĵ���Ϣ�����趨
	 * @param prList �ĵ���Ϣ����
	 */
	public void setIgcrc1303VWList(List<IGCRC1303VWInfo> igcrc1303vwList) {
		igcrc1303VWList = igcrc1303vwList;
	}
	
	
	
	/**
	 * @return the listSum
	 */
	public List<Integer> getListSum() {
		return listSum;
	}

	/**
	 * @param listSum the listSum to set
	 */
	public void setListSum(List<Integer> listSum) {
		this.listSum = listSum;
	}

	public void setMaps(Map<String,Integer> maps) {
		this.maps = maps; 
	}

	public Map<String, Integer> getMaps() {
		return maps;
	}
	
	
}
