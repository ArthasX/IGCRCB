/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM03DTO;
/**
 * ����: �ʲ����ҵ���߼��ӿ�
 * ��������: �ʲ����ҵ���߼��ӿ�
 * ������¼: 2111/04/25
 * �޸ļ�¼: 
 */
public interface IGCIM03BL extends BaseBL{

	/**
	 * ����̨��ʾ����
	 *
	 * @param dto IGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO initIGCIM0301Action(IGCIM03DTO dto) throws BLException;
	
	/**
	 * ����������ɾ������
	 * 
	 * @param dto IGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO deleteAuditWaitTaskAction(IGCIM03DTO dto) throws BLException;
	
	/**
	 * ����̨���봦��
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO importIGCIM0301Action(IGCIM03DTO dto) throws BLException;
	
	/**
	 * ����̨�Աȴ���
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO compareIGCIM0301Action(IGCIM03DTO dto) throws BLException;
	
	/**
	 * ����̨����鿴����
	 *
	 * @param dto IGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO initIGCIM0303Action(IGCIM03DTO dto) throws BLException;
	
	/**
	 * ��ƶԱȽ����ѯ����
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO searchAuditResultAction(IGCIM03DTO dto) throws BLException;
	
	/**
	 * ��ƶԱȽ�����洦��
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public void updateAuditResultAction(IGCIM03DTO dto) throws BLException;

	/**
	 * �������ǼǴ���
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO insertAuditTaskAction(IGCIM03DTO dto) throws BLException;

	/**
	 * ��������ѯ����
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO searchAuditTaskAction(IGCIM03DTO dto) throws BLException;

	/**
	 * ��������ѯ��������ҳ��
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO searchAuditTaskActionForChoose(IGCIM03DTO dto) throws BLException;

	/**
	 * ���������������ʾ
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO initIGCIM0305Action(IGCIM03DTO dto) throws BLException;

	/**
	 * �������������
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO updateAuditTaskAction(IGCIM03DTO dto) throws BLException;

	/**
	 * �豸��Ϣ��ѯ����
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO searchEntityItemAction(IGCIM03DTO dto) throws BLException;

	/**
	 * �豸��ϸ��Ϣ��ѯ����
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO initIGCIM0309Action(IGCIM03DTO dto) throws BLException;

	/**
	 * �豸Ӱ�췶Χ��ѯ����
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO initIGCIM0308Action(IGCIM03DTO dto) throws BLException;
	
	/**
	 * �ʲ����´���
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO updateEntityAction(IGCIM03DTO dto) throws BLException;
	
	/**
	 * ��������CI(���ù�ϵ������bat)
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
//	public IGCIM03DTO rootMarkUpdateAction(IGCIM03DTO dto) throws BLException;
	
	/**
	 * ��ƶԱȽ����ѯ����
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO searchIGCIM0302Action(IGCIM03DTO dto) throws BLException;
}
