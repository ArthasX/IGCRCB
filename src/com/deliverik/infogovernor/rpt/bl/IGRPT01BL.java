/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.rpt.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.dto.IGRPT01DTO;

/**
 * ͳ�Ʒ���ҵ���߼��ӿ�
 *
 */
public interface IGRPT01BL extends BaseBL {
	
	
	
	/**
	 * �����������ѯ����
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO searchReportTypeTreeAction(IGRPT01DTO dto) throws BLException;
	
	/**
	 * ������Ϣ��ѯ����
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO searchReportFileDefinitionAction(IGRPT01DTO dto) throws BLException;
	
	/**
	 * ������Ȩ��������ѯ
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO filterReportTypeTreeAction(IGRPT01DTO dto) throws BLException;
	
	/**
	 * ���Ʊ�����Ϣ��ѯ����
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO searchReportByCustom(IGRPT01DTO dto) throws BLException;
	
	/**
	 * ���Ʊ���־û�����
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO insertCustomReport(IGRPT01DTO dto) throws BLException;
	
	/**
	 * ȡ�����Ʊ�����
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO deleteCustomReport(IGRPT01DTO dto) throws BLException;
	
	/**
	 * ���Ʊ���������
	 * 
	 * @param dto
	 *            IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO orderCustomReport(IGRPT01DTO dto) throws BLException;
	
	public List<Integer> getPiller() throws BLException;
	
	public void setCalendar(int year,int month)  throws BLException;
	
	public String getMap(String mapname)throws BLException;
	
	public int getStudy()throws BLException;
}
