/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM21DTO;
/**
 * ����: �ʲ����ҵ���߼��ӿ�
 * ��������: �ʲ����ҵ���߼��ӿ�
 * ������¼: 2111/04/25
 * �޸ļ�¼: 
 */
public interface IGASM21BL extends BaseBL{

	/**
	 * ����̨��ʾ����
	 *
	 * @param dto IGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO initIGASM2101Action(IGASM21DTO dto) throws BLException;
	
	/**
	 * ����������ɾ������
	 * 
	 * @param dto IGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO deleteAuditWaitTaskAction(IGASM21DTO dto) throws BLException;
	
	/**
	 * ����̨���봦��
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO importIGASM2101Action(IGASM21DTO dto) throws BLException;
	
	/**
	 * ����̨�Աȴ���
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO compareIGASM2101Action(IGASM21DTO dto) throws BLException;
	
	/**
	 * ����̨����鿴����
	 *
	 * @param dto IGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO initIGASM2103Action(IGASM21DTO dto) throws BLException;
	
	/**
	 * ��ƶԱȽ����ѯ����
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO searchAuditResultAction(IGASM21DTO dto) throws BLException;
	
	/**
	 * ��ƶԱȽ�����洦��
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public void updateAuditResultAction(IGASM21DTO dto) throws BLException;

	/**
	 * �������ǼǴ���
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO insertAuditTaskAction(IGASM21DTO dto) throws BLException;

	/**
	 * ��������ѯ����
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO searchAuditTaskAction(IGASM21DTO dto) throws BLException;

	/**
	 * ��������ѯ��������ҳ��
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO searchAuditTaskActionForChoose(IGASM21DTO dto) throws BLException;

	/**
	 * ���������������ʾ
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO initIGASM2105Action(IGASM21DTO dto) throws BLException;

	/**
	 * �������������
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO updateAuditTaskAction(IGASM21DTO dto) throws BLException;

	/**
	 * �豸��Ϣ��ѯ����
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO searchEntityItemAction(IGASM21DTO dto) throws BLException;

	/**
	 * �豸��ϸ��Ϣ��ѯ����
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO initIGASM2109Action(IGASM21DTO dto) throws BLException;

	/**
	 * �豸Ӱ�췶Χ��ѯ����
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO initIGASM2108Action(IGASM21DTO dto) throws BLException;
	
	/**
	 * �ʲ����´���
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO updateEntityAction(IGASM21DTO dto) throws BLException;
	
	/**
	 * ��������CI(���ù�ϵ������bat)
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
//	public IGASM21DTO rootMarkUpdateAction(IGASM21DTO dto) throws BLException;
}
