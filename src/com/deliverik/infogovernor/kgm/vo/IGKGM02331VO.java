package com.deliverik.infogovernor.kgm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetailDef;

/**
 * ����:ѡ��ҵ��ϵͳVO
 * ����������ѡ��ҵ��ϵͳVO
 * ������¼��cdd 2010/12/07
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGKGM02331VO  extends BaseVO implements Serializable{

	 /**ҵ��ϵͳ�����б�*/
	protected List<CodeDetailDef> BusinessSystemList;

	public List<CodeDetailDef> getBusinessSystemList() {
		return BusinessSystemList;
	}

	public void setBusinessSystemList(List<CodeDetailDef> businessSystemList) {
		BusinessSystemList = businessSystemList;
	}
	
	
	
	
}
