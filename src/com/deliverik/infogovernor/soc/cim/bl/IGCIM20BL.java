package com.deliverik.infogovernor.soc.cim.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM20DTO;

/**
 * �������BL
 * @author Administrator
 *
 */
public interface IGCIM20BL {
	
	/**
	 * ��ȡ�豸������ֵ
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM20DTO searchEntityItemLableAction(IGCIM20DTO dto) throws BLException ;
	
	/**
	 * �豸��Ϣ�ǼǴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM20DTO insertEntityItemAction(IGCIM20DTO dto) throws BLException;
	/**
	 * �豸������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM20DTO initIGCIM2002Action(IGCIM20DTO dto) throws BLException ;
	
	/**
	 * �豸������Ϣ�༭����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGCIM20DTO editEntityItemAction(IGCIM20DTO dto) throws BLException,FileNotFoundException,IOException;
	
	/**
	 * �жϵ�½�û��Ƿ����豸�ʲ������ɫ������
	 * 
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @throws BLException 
	 */
	public IGCIM20DTO checkEntityItemDomain(IGCIM20DTO dto) throws BLException;
	
	/**
	 * �豸��Ϣɾ������
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM20DTO deleteEntityItemAction(IGCIM20DTO dto) throws BLException;
	
	/**
	 * �豸��Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM20DTO searchEntityItemAction(IGCIM20DTO dto) throws BLException;
	
	/**
	 *	��ȡӦ�ù�����ϵ����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM20DTO searchRelationListActionApp(IGCIM20DTO dto) throws BLException;
	
	/**
	 * Ӧ�ù�ϵ�ǼǴ���
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM20DTO insertEntityItemRelationActionApp(IGCIM20DTO dto) throws BLException ;
	
	/**
	 * Ӧ�ù�ϵ���������
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM20DTO updateEntityItemRelationActionApp(IGCIM20DTO dto) throws BLException;
	
	/**
	 * Ӧ�ù�ϵ�༭������ڻ�����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM20DTO initIGCIM2006Action(IGCIM20DTO dto) throws BLException;
	
	/**
	 * Ӧ�ù�ϵ��������ڻ�����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM20DTO initIGCIM2005Action(IGCIM20DTO dto) throws BLException ;
	
	/**
	 * Ӧ�ù�ϵɾ������
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM20DTO deleteEntityItemRelationActionApp(IGCIM20DTO dto) throws BLException;

	/**
	 * �����豸������汾
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM20DTO updateVersion(IGCIM20DTO dto) throws BLException;
}
