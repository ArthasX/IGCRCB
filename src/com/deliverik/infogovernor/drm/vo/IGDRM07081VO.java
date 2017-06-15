package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;

/**
 * ������������ϸ��Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGDRM07081VO extends BaseVO implements Serializable{
	
	/** ��������Ϣ */
	protected SOC0124Info soc0124Info;
	
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0129Info>> soc0129InfoVWMap;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	protected Map<String,List<SOC0129Info>> soc0129InfoMap;
	
	/** �ʲ���Ϣ */
	protected SOC0118Info soc0118Info;
	
	public SOC0124Info getSoc0124Info() {
		return soc0124Info;
	}

	public void setSoc0124Info(SOC0124Info soc0124Info) {
		this.soc0124Info = soc0124Info;
	}
	
	public SOC0118Info getSoc0118Info() {
		return soc0118Info;
	}

	public void setSoc0118Info(SOC0118Info soc0118Info) {
		this.soc0118Info = soc0118Info;
	}

	public Boolean getFlag() {
		return flag;
	}


	public Map<String, List<SOC0129Info>> getSoc0129InfoVWMap() {
		return soc0129InfoVWMap;
	}

	public void setSoc0129InfoVWMap(Map<String, List<SOC0129Info>> soc0129InfoVWMap) {
		this.soc0129InfoVWMap = soc0129InfoVWMap;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	

	/**
	 * ���캯��
	 * @param entityItemData���ʲ�����Ϣ
	 * @param configItemVWInfoMap���ʲ���������Ϣ�������
	 */
	public IGDRM07081VO(SOC0124Info soc0124Info,Map<String,List<SOC0129Info>> soc0129InfoVWMap) {
		this.soc0124Info = soc0124Info;
		this.soc0129InfoVWMap = soc0129InfoVWMap;
	}
	
	/**
	 * ��������Ϣȡ��
	 * @return ��������Ϣ
	 */
	public SOC0124Info getEntityData() {
		return soc0124Info;
	}

	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return soc0129InfoVWMap;
	}
	
	
}


