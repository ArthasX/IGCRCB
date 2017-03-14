/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG108Info;
import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.IG111Info;
/**
 * ����: �Զ������̱���ѯ��������vo
 * ��������: �Զ������̱���ѯ��������vo
 * ������¼: 2013/03/13
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGPRD01451VO extends BaseVO{

	/** ��ѡ��ѯ���� */
	protected List<IG108Info> pqList;
	/** ��ѡ��ѯ���� */
	protected List<IG007Info> pdList;
	/** ���趨���̲�ѯ��ʾ�м��� */
    protected List<IG110Info> queryShowColumnList;
    
    /** δ�趨���̲�ѯ��ʾ�м��� */
    protected Map<String, String> queryShowColumnMap;
    
    /** ���趨��ѯ�������� */
    protected List<IG111Info> queryList;
    
    /** δ�趨��ѯ�������� */
    protected Map<String, String> queryMap;

	/**
	 * ���趨���̲�ѯ��ʾ�м���ȡ��
	 * @return queryShowColumnList ���趨���̲�ѯ��ʾ�м���
	 */
	public List<IG110Info> getQueryShowColumnList() {
		return queryShowColumnList;
	}

	/**
	 * ���趨���̲�ѯ��ʾ�м����趨
	 * @param queryShowColumnList ���趨���̲�ѯ��ʾ�м���
	 */
	public void setQueryShowColumnList(List<IG110Info> queryShowColumnList) {
		this.queryShowColumnList = queryShowColumnList;
	}

	/**
	 * δ�趨���̲�ѯ��ʾ�м���ȡ��
	 * @return queryShowColumnMap δ�趨���̲�ѯ��ʾ�м���
	 */
	public Map<String, String> getQueryShowColumnMap() {
		return queryShowColumnMap;
	}

	/**
	 * δ�趨���̲�ѯ��ʾ�м����趨
	 * @param queryShowColumnMap δ�趨���̲�ѯ��ʾ�м���
	 */
	public void setQueryShowColumnMap(Map<String, String> queryShowColumnMap) {
		this.queryShowColumnMap = queryShowColumnMap;
	}

	/**
	 * ���趨��ѯ��������ȡ��
	 * @return queryList ���趨��ѯ��������
	 */
	public List<IG111Info> getQueryList() {
		return queryList;
	}

	/**
	 * ���趨��ѯ���������趨
	 * @param queryList ���趨��ѯ��������
	 */
	public void setQueryList(List<IG111Info> queryList) {
		this.queryList = queryList;
	}

	/**
	 * δ�趨��ѯ��������ȡ��
	 * @return queryMap δ�趨��ѯ��������
	 */
	public Map<String, String> getQueryMap() {
		return queryMap;
	}

	/**
	 * δ�趨��ѯ���������趨
	 * @param queryMap δ�趨��ѯ��������
	 */
	public void setQueryMap(Map<String, String> queryMap) {
		this.queryMap = queryMap;
	}
	
	/**
	 * ��ѡ��ѯ����ȡ��
	 * @return ��ѡ��ѯ����
	 */
	public List<IG108Info> getPqList() {
		return pqList;
	}
	
	/**
	 * ��ѡ��ѯ����ȡ��
	 * @return ��ѡ��ѯ����
	 */
	public List<IG007Info> getPdList() {
		return pdList;
	}
	
	/**
	 * ��ѡ��ѯ�����趨
	 * @param pqList ��ѡ��ѯ����
	 */
	public void setPqList(List<IG108Info> pqList) {
		this.pqList = pqList;
	}
	
	/**
	 * ��ѡ��ѯ�����趨
	 * @param pdList ��ѡ��ѯ����
	 */
	public void setPdList(List<IG007Info> pdList) {
		this.pdList = pdList;
	}
	
}
