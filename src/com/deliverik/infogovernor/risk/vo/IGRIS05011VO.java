/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.risk.model.CheckWorkConutVWInfo;

/**
 * @Description: 
 * @Author       zhangqiang
 * @History      @2014-7-9�½� 
 * 			
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGRIS05011VO extends BaseVO implements Serializable{
	
	
	/**�����map����*/
	Map<String, Map<String, List<CheckWorkConutVWInfo>>>  checkWorkMap;
	
	
	/**���������*/
	protected List<CheckWorkConutVWInfo> CheckWorkConutList;

	/**
	 * checkWorkConutListȡ��
	 * @return checkWorkConutList checkWorkConutList
	 */
	public List<CheckWorkConutVWInfo> getCheckWorkConutList() {
		return CheckWorkConutList;
	}

	/**
	 * checkWorkConutList�趨
	 * @param checkWorkConutList checkWorkConutList
	 */
	public void setCheckWorkConutList(List<CheckWorkConutVWInfo> checkWorkConutList) {
		CheckWorkConutList = checkWorkConutList;
	}

	/**
	 * �����map����ȡ��
	 * @return the checkWorkMap
	 */
	public Map<String, Map<String, List<CheckWorkConutVWInfo>>> getCheckWorkMap() {
		return checkWorkMap;
	}

	/**
	 * �����map�����趨
	 * @param checkWorkMap the �����map����
	 */
	public void setCheckWorkMap(
			Map<String, Map<String, List<CheckWorkConutVWInfo>>> checkWorkMap) {
		this.checkWorkMap = checkWorkMap;
	}


}
