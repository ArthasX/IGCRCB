/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.risk.model.CheckWorkConutVWInfo;

/**
 * @Description: 
 * @Author       zhangqiang
 * @History      @2014-7-11�½� 
 * 			
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGRIS05ExcelDTO extends ExcelDTO {

	/**�����map����*/
	protected Map<String, Map<String,List<CheckWorkConutVWInfo>>> map;
	
	/**���*/
	protected Map<String,Map<Integer,String>> mapType;

	/**
	 * �����map����ȡ��
	 * @return the �����map����
	 */
	public Map<String, Map<String, List<CheckWorkConutVWInfo>>> getMap() {
		return map;
	}

	/**
	 * �����map�����趨
	 * @param map the �����map����
	 */
	public void setMap(Map<String, Map<String, List<CheckWorkConutVWInfo>>> map) {
		this.map = map;
	}

	/**
	 * ���ȡ��
	 * @return the mapType
	 */
	public Map<String, Map<Integer, String>> getMapType() {
		return mapType;
	}

	/**
	 * ����趨
	 * @param mapType the ���
	 */
	public void setMapType(Map<String, Map<Integer, String>> mapType) {
		this.mapType = mapType;
	}

}
