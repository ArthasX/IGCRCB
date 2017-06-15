package com.deliverik.infogovernor.asset.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM32DTO;

/**
 * �����¼�����ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM32BL extends BaseBL {


	/**
	 * �����¼���ѯ����
	 *
	 * @param dto IGASM32DTO
	 * @return IGASM32DTO
	 */
	public IGASM32DTO searchEntityItemAction(IGASM32DTO dto) throws BLException;
	
	/**
	 * �����¼���ʷ�汾��ѯ����
	 *
	 * @param dto IGASM32DTO
	 * @return IGASM32DTO
	 */
	public IGASM32DTO searchEntityItemByVersion(IGASM32DTO dto) throws BLException;
	
	/**
	 * �����¼�Ӧ�Բ���
	 *
	 * @param dto IGASM32DTO
	 * @return IGASM32DTO
	 */
	public IGASM32DTO searchRiskPolicyAction(IGASM32DTO dto) throws BLException;
	
	/**
	 * �����¼��ǼǴ���
	 *
	 * @param dto IGASM32DTO
	 * @return IGASM32DTO
	 */
	public IGASM32DTO insertEntityItemAction(IGASM32DTO dto) throws BLException;

	/**
	 * �����¼��޸Ĵ���
	 *
	 * @param dto IGASM32DTO
	 * @return IGASM32DTO
	 */
	public IGASM32DTO updateEntityItem(IGASM32DTO dto) throws BLException;
}
