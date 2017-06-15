/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCond;

/**
 * 
 * ������Ϣҵ���߼��ӿ�
 *
 */
public interface ReportFileDefinitionBL extends BaseBL{
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(ReportFileDefinitionSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param rfdid ������ϢID
	 * @return ������Ϣ
	 */
	public ReportFileDefinition searchReportFileDefinitionByKey(Integer rfdid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��������Ϣ��Ϣ
	 */
	public List<ReportFileDefinition> searchReportFileDefinitionAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ReportFileDefinition> searchReportFileDefinition(ReportFileDefinitionSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param ReportFileDefinition ��¼����
	 * @return ������Ϣ
	 */
	public ReportFileDefinition registReportFileDefinition(ReportFileDefinition reportFileDefinition) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param rfdid ������ϢID
	 * @return
	 */
	public void deleteReportFileDefinition(Integer rfdid) throws BLException;

	/**
	 * �������
	 * 
	 * @param reportFileDefinition �������
	 * @return ������Ϣ
	 */
	public ReportFileDefinition updateReportFileDefinition(ReportFileDefinition reportFileDefinition) throws BLException;
	
	/**
	 * У�鱨����ʾ�����Ƿ����
	 * 
	 * @param rfdtitle ������ʾ����
	 * @return
	 * @throws BLException 
	 */
	public void checkRfdtitle(String rfdtitle) throws BLException;
	
	/**
	 * У�鱨���������Ƿ����
	 * 
	 * @param rfdtitle ����������
	 * @return
	 * @throws BLException 
	 */
	public void checkRfdfilename(String rfdfilename,String rfdtype) throws BLException;
	
}
