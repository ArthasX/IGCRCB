/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.google.gson.Gson;

/**
 * <p>
 * Title : InfoGovernor Ӧ������
 * </p>
 * <p>
 * Description: ����ͳ��
 * </p>
 * 
 * @author zhangjian@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM18111VO extends BaseVO{
	
	/** ����ͳ�� */
	protected List<Map<String,Object>> drillRateList;
	
	/** ��������ͳ�� */
	protected List<Map<String,Object>> drillTypeRateList;

	/**
	 * ����ͳ��ȡ��
	 * @return drillRateList ����ͳ��
	 */
	public List<Map<String, Object>> getDrillRateList() {
		return drillRateList;
	}

	/**
	 * ����ͳ���趨
	 * @param drillRateList ����ͳ��
	 */
	public void setDrillRateList(List<Map<String, Object>> drillRateList) {
		this.drillRateList = drillRateList;
	}

	/**
	 * ��������ͳ��ȡ��
	 * @return drillTypeRateList ��������ͳ��
	 */
	public String getDrillTypeRateList() {
		Gson g = new Gson();
		return g.toJson(this.drillTypeRateList);
	}

	/**
	 * ��������ͳ���趨
	 * @param drillTypeRateList ��������ͳ��
	 */
	public void setDrillTypeRateList(List<Map<String, Object>> drillTypeRateList) {
		this.drillTypeRateList = drillTypeRateList;
	}
}
