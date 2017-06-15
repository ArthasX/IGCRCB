/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG126Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * ����: �Զ�������ҳ������ ��ѯVO
 * ��������: �Զ�������ҳ�����ò�ѯVO
 * ������¼: 2012/11/13
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGPRD01681VO extends BaseVO implements Serializable{

	/** �Զ�������ҳ�������б� */
	protected List<IG126Info> lst_IG126Info;
	
	/** �Զ���·��ҳ������ ��ѯ��������*/
    protected IG380Info ig380info;
    
	/**
	 * ���캯��
	 * @param processInfoDef���Զ�������ҳ�������б�������
	 */
	public IGPRD01681VO(List<IG126Info> ig126infoList) {
		this.lst_IG126Info = ig126infoList;
	}
	/**
	 * �Զ�������ҳ�������б�ȡ��
	 * @return the lst_IG126Info
	 */
	public List<IG126Info> getLst_IG126Info() {
		return lst_IG126Info;
	}

	/**
	 *�Զ�������ҳ�������б�����
	 *	
	 * @param lst_IG126Info the lst_IG126Info to set
	 */
	public void setLst_IG126Info(List<IG126Info> lst_IG126Info) {
		this.lst_IG126Info = lst_IG126Info;
	}

	/**
     * �Զ�������ҳ������ ��ѯ�������� ��ȡ
     * @return the ig380info
     */
    public IG380Info getIg380info() {
        return ig380info;
    }
    /**
     * �Զ�������ҳ������ ��ѯ�������� ����
     * @param ig380info the ig380info to set
     */
    public void setIg380info(IG380Info ig380info) {
        this.ig380info = ig380info;
    }
	
}


