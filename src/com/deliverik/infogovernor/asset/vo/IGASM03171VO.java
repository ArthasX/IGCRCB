/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseVO;

/**
 * @Description: ����ʲ���Ϣ�֣�
 * @Author  
 * @History 2009-8-18     �½�
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGASM03171VO extends BaseVO implements Serializable{
	/** ����ʲ���ź����� */
	protected List<LabelValueBean> relationList;

	public List<LabelValueBean> getRelationList() {
		return relationList;
	}

	public void setRelationList(List<LabelValueBean> relationList) {
		this.relationList = relationList;
	}
	
}