/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM18DTO;

/**
 * <p>
 * Title : InfoGovernor Ӧ������
 * </p>
 * <p>
 * Description:ͳ�Ʒ���BL�ӿ�
 * </p>
 * 
 * @author zhangjian@deliverik.com
 * @version 1.0
 */
public interface IGDRM18BL extends BaseBL {

	/**
	 * Ӧ��Ԥ��ͳ�Ʋ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM18DTO getPlanRate(IGDRM18DTO dto)throws BLException;
	
	/**
	 * ����ͳ�Ʋ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM18DTO getDrillRate(IGDRM18DTO dto)throws BLException;
	
	
	/**
	 * Ԥ��שȡ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM18DTO searchPlanInfo(IGDRM18DTO dto) throws BLException;
	
}
