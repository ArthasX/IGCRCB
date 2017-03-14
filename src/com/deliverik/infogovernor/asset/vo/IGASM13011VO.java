package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG011Info;
import com.deliverik.framework.base.BaseVO;

/**
 * �豸����ͳ�Ʒ�������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM13011VO extends BaseVO implements Serializable{
	
	/** �豸ͳ�Ʒ�����Ϣ�ӿ�*/
	private List<IG011Info> entityCountList;
	
	/** ����*/
	private Integer total;
	
	/**
	 * ���캯��
	 */
	public IGASM13011VO(List<IG011Info> entityCountList,
			Integer total) {
		this.entityCountList = entityCountList;
		this.total = total;

	}
	
	public List<IG011Info> getEntityCountList() {
		return entityCountList;
	}

	public void setEntityCountList(List<IG011Info> entityCountList) {
		this.entityCountList = entityCountList;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}


