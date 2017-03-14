/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sym.model.ReportFileVersion;
import com.deliverik.infogovernor.sym.model.condition.ReportFileVersionSearchCond;
import com.deliverik.infogovernor.sym.model.dao.ReportFileVersionDAO;

/**
 * ����汾ҵ���߼��ӿ�
 *
 */
public class ReportFileVersionBLImpl extends BaseBLImpl implements ReportFileVersionBL{
	
	/** ReportFileVersion DAO */
	protected ReportFileVersionDAO reportFileVersionDAO;
	
	public void setReportFileVersionDAO(
			ReportFileVersionDAO reportFileVersionDAO) {
		this.reportFileVersionDAO = reportFileVersionDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(ReportFileVersionSearchCond cond){
		
		return reportFileVersionDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param rfvid ������ϢID
	 * @return ������Ϣ
	 */
	public ReportFileVersion searchReportFileVersionByKey(Integer rfvid) throws BLException{
		
		return checkExistReportFileVersion(rfvid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��������Ϣ��Ϣ
	 */
	public List<ReportFileVersion> searchReportFileVersionAll(){
		
		return reportFileVersionDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ReportFileVersion> searchReportFileVersion(ReportFileVersionSearchCond cond, int start, int count){
		
		return reportFileVersionDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param reportFileVersion ��¼����
	 * @return ������Ϣ
	 */
	public ReportFileVersion registReportFileVersion(ReportFileVersion reportFileVersion) throws BLException{
		
		return reportFileVersionDAO.save(reportFileVersion);
	}

	/**
	 * ɾ������
	 * 
	 * @param rfvid ������ϢID
	 * @return
	 */
	public void deleteReportFileVersion(Integer rfvid) throws BLException{
		
		ReportFileVersion reportFileVersion = checkExistReportFileVersion(rfvid);
		
		reportFileVersionDAO.delete(reportFileVersion);
	}

	/**
	 * �������
	 * 
	 * @param reportFileVersion �������
	 * @return ������Ϣ
	 */
	public ReportFileVersion updateReportFileVersion(ReportFileVersion reportFileVersion) throws BLException{
		
		checkExistReportFileVersion(reportFileVersion.getRfvid());
		return reportFileVersionDAO.save(reportFileVersion);
	}

	/**
	 * ����汾��Ϣ���ڼ��
	 * 
	 * @param rfvid ����汾��ϢID
	 * @return ����汾��Ϣ
	 * @throws BLException 
	 */
	protected ReportFileVersion checkExistReportFileVersion(Integer rfvid) throws BLException{
		ReportFileVersion info = reportFileVersionDAO.findByPK(rfvid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","����汾����");
		}
		return info;
	}
	
}
