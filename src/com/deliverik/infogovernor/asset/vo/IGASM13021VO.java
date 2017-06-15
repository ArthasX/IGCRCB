package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0604Info;

/**
 * ��������ͳ�Ʒ�������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM13021VO extends BaseVO implements Serializable{
	
	/** ��������ͳ�Ʒ�����Ϣ�ӿ�*/
	private List<SOC0604Info> roomandcontainerList;
	
	/**
	 * ���캯��
	 */
	public IGASM13021VO() {

	}

	public List<SOC0604Info> getRoomandcontainerList() {
		return roomandcontainerList;
	}

	public void setRoomandcontainerList(
			List<SOC0604Info> roomandcontainerList) {
		this.roomandcontainerList = roomandcontainerList;
	}


	
	
}


