package com.deliverik.infogovernor.wki.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.wki.dto.IGWKI01DTO;

/**
 * ������ϢCRUD
 * @author KJB-001064
 *
 */
public interface IGWKI01BL extends BaseBL {
	
	/**
	 * ��ѯ������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWKI01DTO searchWorkInfos(IGWKI01DTO dto)throws BLException;
	/**
	 * ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWKI01DTO addWorkInfos(IGWKI01DTO dto)throws BLException;
	/**
	 * ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWKI01DTO updateWorkInfos(IGWKI01DTO dto)throws BLException;
	
	
}
