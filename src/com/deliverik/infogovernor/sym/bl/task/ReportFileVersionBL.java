/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.model.ReportFileVersion;
import com.deliverik.infogovernor.sym.model.condition.ReportFileVersionSearchCond;

/**
 * 
 * ����汾ҵ���߼��ӿ�
 *
 */
public interface ReportFileVersionBL extends BaseBL{
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(ReportFileVersionSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param rfvid ������ϢID
	 * @return ������Ϣ
	 */
	public ReportFileVersion searchReportFileVersionByKey(Integer rfvid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��������Ϣ��Ϣ
	 */
	public List<ReportFileVersion> searchReportFileVersionAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ReportFileVersion> searchReportFileVersion(ReportFileVersionSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param ReportFileVersion ��¼����
	 * @return ������Ϣ
	 */
	public ReportFileVersion registReportFileVersion(ReportFileVersion reportFileVersion) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param rfvid ������ϢID
	 * @return
	 */
	public void deleteReportFileVersion(Integer rfvid) throws BLException;

	/**
	 * �������
	 * 
	 * @param reportFileVersion �������
	 * @return ������Ϣ
	 */
	public ReportFileVersion updateReportFileVersion(ReportFileVersion reportFileVersion) throws BLException;
	
}
