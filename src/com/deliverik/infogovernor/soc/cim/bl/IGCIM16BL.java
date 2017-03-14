package com.deliverik.infogovernor.soc.cim.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM16DTO;

public interface IGCIM16BL extends BaseBL{
	
	/**
	 * ����������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO insertSoc0501Info(IGCIM16DTO dto) throws BLException;
	/**
	 * �������������ϵ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO insertSoc0502Info(IGCIM16DTO dto) throws BLException;
	/**
	 * ��ȡ���������ϵ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO getSoc0502Info(IGCIM16DTO dto) throws BLException;
	/**
	 * ��ȡ������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO getSoc0501Info(IGCIM16DTO dto) throws BLException;
	/**
	 * ������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO deleteSoc0501Info(IGCIM16DTO dto) throws BLException;
	/**
	 * ɾ�����������ϵ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO deleteSoc0502Info(IGCIM16DTO dto) throws BLException;
	
	/**
	 * ��ѯ�豸
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO searchSoc0124List(IGCIM16DTO dto) throws BLException;
	/**
	 * ��ѯ����ҵ��ϵͳ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO searchBusiessList(IGCIM16DTO dto) throws BLException;
	
	/**
	 * �������������ϵ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO insertBusiessRelation(IGCIM16DTO dto) throws BLException;
	
	/**
	 * �豸������ϵ������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM16DTO initIGCIM1632BelongAction(IGCIM16DTO dto) throws BLException ;
	
	/**
	 * ɾ����ϵ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO delRelation (IGCIM16DTO dto) throws BLException;
	
	/**
	 * ��ʼ��������������ϵҳ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO initIGCIM1632EditAction(IGCIM16DTO dto) throws BLException;
	
	/**
	 * �������˹�ϵ������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM16DTO initIGCIM1634TopoBelongAction(IGCIM16DTO dto) throws BLException ;
	
	/**
	 * ��ѯ�豸
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO searchSoc0163List(IGCIM16DTO dto) throws BLException;
}
