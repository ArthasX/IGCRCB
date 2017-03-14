/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;

/**
 * �������ҵ���߼��ӿ�
 *
 *	@author liupeng@deliverik.com
 */
public interface IGRIS01BL extends BaseBL {
	
	//-----------------------------------------------------------��ư汾----------------------------------------------------------------------
	
	/**
	 * ���������Ϣ��ѯ����
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * ���������Ϣ�ǼǴ���
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO insertRiskAuditAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * ���������Ϣͣ��/���ô���
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO changeRiskAuditAction(IGRIS01DTO dto) throws BLException;
	
	//-----------------------------------------------------------��Ʒ���----------------------------------------------------------------------
	
	/**
	 * ��Ʒ�����Ϣ��ѯ����
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditInsAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * ��Ʒ�����Ϣ�ǼǴ���
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO insertRiskAuditInsAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * ��Ʒ�����Ϣͣ��/���ô���
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO changeRiskAuditInsAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * ��Ʒ�����Ϣ�������
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO updateRiskAuditInsAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * ��Ʒ�����Ϣ�����ʼ������
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO initIGRIS0110Action(IGRIS01DTO dto) throws BLException;
	//-----------------------------------------------------------������趨---------------------------------------------------------------------
	
	/**
	 * <p>
	 * Description: ���������
	 * </p>
	 * 
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	
	public IGRIS01DTO insertRiskAuditDefAction(IGRIS01DTO dto) throws BLException;
	/**
	 * �������Ϣ��һ����ѯ����
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditDefNextAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * �������Ϣȫ���¼���ѯ����
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditDefAllAction(IGRIS01DTO dto) throws BLException;
	

	/**
	 * �������Ϣͣ��/���ô���
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO changeRiskAuditDefAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * �������ϸ��Ϣ����
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO initIGRIS0108Action(IGRIS01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ѯ���ڵ��ϼ�����һ������
	 * </p>
	 * 
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 */
	
	public IGRIS01DTO searchAuditTreeAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * ��ȡ�����õ���ư汾���������б�
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditLabelInUse(IGRIS01DTO dto) throws BLException;
	
	/**
	 * �������ϸ��Ϣ�޸ĳ�ʼ������
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO initRiskAuditDefAction(IGRIS01DTO dto) throws BLException;
	/**
	 * �������ϸ��Ϣ�޸Ĵ���
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO editRiskAuditDefAction(IGRIS01DTO dto) throws BLException;
	
	//-----------------------------------------------------------�������----------------------------------------------------------------------
	/**
	 * ���������Ϣ��ѯ����
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditResultAction(IGRIS01DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ���������ʼ��
	 * </p>
	 * 
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	
	public IGRIS01DTO initRiskAuditResultAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �����������
	 * </p>
	 * 
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	
	public IGRIS01DTO updateRiskAuditResultAction(IGRIS01DTO dto) throws BLException;
	/**
	 * ��ȡ�����õ�������κ������б�
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditInsLabelInUse(IGRIS01DTO dto) throws BLException ;
	
	/**
	 * <p>
	 * Description: ���ռ���ѯ
	 * </p>
	 */
	
	public IGRIS01DTO searchRiskCheckAction(IGRIS01DTO dto) throws BLException ;
	/**
	 * <p>
	 * Description: ���ռ������ѯ
	 * </p>
	 */
	
	public IGRIS01DTO searchRiskCheckResultAction(IGRIS01DTO dto) throws BLException ;
	/**
	 * <p>
	 * Description: ���ռ��鿴ҳ
	 * </p>
	 */
	
	public IGRIS01DTO initRiskCheckAction(IGRIS01DTO dto) throws BLException;
	//-----------------------------------------------------------�����----------------------------------------------------------------------
	
	/**
	 * �������Ϣ��ѯ����
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditDefResultVWAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * �������Ϣ���洦��
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO saveRiskAuditResultAction(IGRIS01DTO dto) throws BLException;
	
	//-----------------------------------------------------------��Ʊ���----------------------------------------------------------------------
	
	/**
	 * ��Ʊ�����Ϣ��ѯ����
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditReportAction(IGRIS01DTO dto) throws BLException;
	
}
