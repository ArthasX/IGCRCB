/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.cic.vo;

import java.io.Serializable;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����һ���Աȶ�_�ԱȽ����ϸ�鿴����VO
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIC02051VO extends BaseVO implements Serializable{


	public IGCIC02051VO(String treeMapJson){
		this.treeMapJson = treeMapJson;
	}
	public IGCIC02051VO(){
	}
	
    
    private String treeMapJson;
 
    private String soc0124InfoJson;
    
    private Map<String,String> sourceMap;
    private Map<String,String> targetMap;

	public String getTreeMapJson() {
		return treeMapJson;
	}

	public void setTreeMapJson(String treeMapJson) {
		this.treeMapJson = treeMapJson;
	}
	public String getSoc0124InfoJson() {
		return soc0124InfoJson;
	}
	public void setSoc0124InfoJson(String soc0124InfoJson) {
		this.soc0124InfoJson = soc0124InfoJson;
	}
	public Map<String, String> getSourceMap() {
		return sourceMap;
	}
	public void setSourceMap(Map<String, String> sourceMap) {
		this.sourceMap = sourceMap;
	}
	public Map<String, String> getTargetMap() {
		return targetMap;
	}
	public void setTargetMap(Map<String, String> targetMap) {
		this.targetMap = targetMap;
	}

    
	
    
}


