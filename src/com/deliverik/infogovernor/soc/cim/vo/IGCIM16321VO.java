package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * 
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM16321VO extends BaseVO implements Serializable{
	
	/** �豸��Ϣ */
	protected SOC0124Info entityItemData;
	
	
	/** �ʲ����ϵ��Ϣ1���� */
	protected int parCount;
	
	/** �ʲ����ϵ��Ϣ2���� */
	protected int cldCount;
	
	/** �豸������������ */
	protected String eiorgname;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	protected List<SOC0119Info> soc0119List;
	
	
	

	public List<SOC0119Info> getSoc0119List() {
		return soc0119List;
	}

	public void setSoc0119List(List<SOC0119Info> soc0119List) {
		this.soc0119List = soc0119List;
	}

	public SOC0124Info getEntityItemData() {
		return entityItemData;
	}

	public void setEntityItemData(SOC0124Info entityItemData) {
		this.entityItemData = entityItemData;
	}

	

	public int getParCount() {
		return parCount;
	}

	public void setParCount(int parCount) {
		this.parCount = parCount;
	}

	public int getCldCount() {
		return cldCount;
	}

	public void setCldCount(int cldCount) {
		this.cldCount = cldCount;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	
	
	
	
	
}


