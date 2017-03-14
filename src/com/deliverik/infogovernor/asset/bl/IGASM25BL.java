package com.deliverik.infogovernor.asset.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM25DTO;

/**
 *  �����¼ͳ��ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM25BL extends BaseBL {


	/**
	 * �����¼ͳ����Ϣ��ѯ����
	 *
	 * @param dto IGASM21DTO
	 * @return IGASM21DTO
	 */
	public IGASM25DTO searchEntityItemRelationVW(IGASM25DTO dto) throws BLException;
	
	/**
	 * �����¼��ϸ��Ϣ��ѯ����
	 *
	 * @param dto IGASM21DTO
	 * @return IGASM21DTO
	 */
	public IGASM25DTO searchEntityItemRelationDetailVW(IGASM25DTO dto) throws BLException;
	
}
