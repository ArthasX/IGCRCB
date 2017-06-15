/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCond;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCondImpl;
import com.deliverik.infogovernor.sym.model.dao.ReportFileDefinitionDAO;

/**
 * ������Ϣҵ���߼��ӿ�
 *
 */
public class ReportFileDefinitionBLImpl extends BaseBLImpl implements ReportFileDefinitionBL{
	
	/** ReportFileDefinition DAO */
	protected ReportFileDefinitionDAO reportFileDefinitionDAO;
	
	public void setReportFileDefinitionDAO(
			ReportFileDefinitionDAO reportFileDefinitionDAO) {
		this.reportFileDefinitionDAO = reportFileDefinitionDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(ReportFileDefinitionSearchCond cond){
		
		return reportFileDefinitionDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param rfdid ������ϢID
	 * @return ������Ϣ
	 */
	public ReportFileDefinition searchReportFileDefinitionByKey(Integer rfdid) throws BLException{
		
		return checkExistReportFileDefinition(rfdid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��������Ϣ��Ϣ
	 */
	public List<ReportFileDefinition> searchReportFileDefinitionAll(){
		
		return reportFileDefinitionDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ReportFileDefinition> searchReportFileDefinition(ReportFileDefinitionSearchCond cond, int start, int count){
		
		return reportFileDefinitionDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param reportFileDefinition ��¼����
	 * @return ������Ϣ
	 */
	public ReportFileDefinition registReportFileDefinition(ReportFileDefinition reportFileDefinition) throws BLException{
		
		//checkRfdtitle(reportFileDefinition.getRfdtitle());
		checkRfdfilename(reportFileDefinition.getRfdfilename(),reportFileDefinition.getRfdtype());
		
//		if("1".equals(reportFileDefinition.getIsFlag())){
//			checkRfdfilename(reportFileDefinition.getRfdfilename());
//		}
		return reportFileDefinitionDAO.save(reportFileDefinition);
	}

	/**
	 * ɾ������
	 * 
	 * @param rfdid ������ϢID
	 * @return
	 */
	public void deleteReportFileDefinition(Integer rfdid) throws BLException{
		
		ReportFileDefinition reportFileDefinition = checkExistReportFileDefinition(rfdid);
		
		reportFileDefinitionDAO.delete(reportFileDefinition);
	}

	/**
	 * �������
	 * 
	 * @param reportFileDefinition �������
	 * @return ������Ϣ
	 */
	public ReportFileDefinition updateReportFileDefinition(ReportFileDefinition reportFileDefinition) throws BLException{
		
		checkExistReportFileDefinition(reportFileDefinition.getRfdid());
		return reportFileDefinitionDAO.save(reportFileDefinition);
	}

	/**
	 * ������Ϣ���ڼ��
	 * 
	 * @param rfdid ������ϢID
	 * @return ������Ϣ
	 * @throws BLException 
	 */
	protected ReportFileDefinition checkExistReportFileDefinition(Integer rfdid) throws BLException{
		ReportFileDefinition info = reportFileDefinitionDAO.findByPK(rfdid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","�������");
		}
		return info;
	}
	
	/**
	 * У�鱨����ʾ�����Ƿ����
	 * 
	 * @param rfdtitle ������ʾ����
	 * @return
	 * @throws BLException 
	 */
	public void checkRfdtitle(String rfdtitle) throws BLException{
		ReportFileDefinitionSearchCondImpl cond = new ReportFileDefinitionSearchCondImpl();
		
		cond.setRfdtitle(rfdtitle);
		
		List<ReportFileDefinition> raList = reportFileDefinitionDAO.findByCond(cond, 0, 0);
		if( raList != null && raList.size()>0 ) {
			throw new BLException("IGSYM1402.E001","��ʾ����");
		}
	}
	
	/**
	 * У�鱨���������Ƿ����
	 * 
	 * @param rfdtitle ����������
	 * @return
	 * @throws BLException 
	 */
	public void checkRfdfilename(String rfdfilename,String rfdtype) throws BLException{
		ReportFileDefinitionSearchCondImpl cond = new ReportFileDefinitionSearchCondImpl();
		
		cond.setRfdfilename(rfdfilename);
		cond.setRfdtype(rfdtype);
		List<ReportFileDefinition> raList = reportFileDefinitionDAO.findByCond(cond, 0, 0);
		if( raList != null && raList.size()>0 ) {
			throw new BLException("IGSYM1402.E001","��������");
		}
	}
	
}
