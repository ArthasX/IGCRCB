/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG238Info;
import com.deliverik.framework.workflow.prd.model.IG335Info;

/**
 * ����: ����֪ͨ�����趨VO
 * ��������: ����֪ͨ�����趨VO
 * ������¼: 2012/04/11
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGPRD01581VO extends BaseVO implements Serializable {

	/** ���̲����б� */
	protected List<IG238Info> lst_ProcessNoticeStrategyDef;
	
	/** ҳ����ʾ������ϢMap */
	protected Map<IG238Info, List<IG335Info>> showMap;
	
	/** ����������� */
    protected List<IG335Info> processWholeTactic_list;

	/**
	 * ���̲����б�ȡ��
	 * 
	 * @return ���̲����б�
	 */
	public List<IG238Info> getLst_ProcessNoticeStrategyDef() {
		return lst_ProcessNoticeStrategyDef;
	}

	/**
	 * ���̲����б��趨
	 * 
	 * @param lst_ProcessNoticeStrategyDef ���̲����б�
	 */
	public void setLst_ProcessNoticeStrategyDef(
			List<IG238Info> lst_ProcessNoticeStrategyDef) {
		this.lst_ProcessNoticeStrategyDef = lst_ProcessNoticeStrategyDef;
	}

	/**
	 * ҳ����ʾ������ϢMapȡ��
	 * @return showMap ҳ����ʾ������ϢMap
	 */
	public Map<IG238Info, List<IG335Info>> getShowMap() {
		return showMap;
	}

	/**
	 * ҳ����ʾ������ϢMap�趨
	 * @param showMap ҳ����ʾ������ϢMap
	 */
	public void setShowMap(Map<IG238Info, List<IG335Info>> showMap) {
		this.showMap = showMap;
	}

    /** 
     * ����������� ȡ��
     * @return processWholeTactic_list ����������� 
     */
    public List<IG335Info> getProcessWholeTactic_list() {
        return processWholeTactic_list;
    }

    /** 
     * ����������� �趨
     * @param processWholeTactic_list ����������� 
     */
    public void setProcessWholeTactic_list(List<IG335Info> processWholeTactic_list) {
        this.processWholeTactic_list = processWholeTactic_list;
    }

}
