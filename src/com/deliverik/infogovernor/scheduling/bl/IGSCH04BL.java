/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.scheduling.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.scheduling.dto.IGSCH04DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_�������_�¼��ල�ӿ�
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface IGSCH04BL extends BaseBL {
	
	/**
	 * ��ѯ�¼�����
	 * 
	 * @param dto IGSCH04DTO
	 * @return IGSCH04DTO
	 * @throws BLException
	 */
	public IGSCH04DTO searchRoleAction(IGSCH04DTO dto) throws BLException;
	
	/**
	 * ��ѯ����
	 * @param dto IGSCH04DTO
	 * @return IGSCH04DTO
	 * @throws BLException
	 */
	
	public IGSCH04DTO searchQuartzJobsAction(IGSCH04DTO dto) throws BLException;
	
	/**
	 * ���湤��
	 * @param dto IGSCH04DTO
	 * @return IGSCH04DTO
	 * @throws BLException
	 */
	
	public IGSCH04DTO saveQuartzJobsAction(IGSCH04DTO dto) throws BLException;
	
	/**
	 * ��ֹ����
	 * 
	 * @param dto IGSCH04DTO
	 * @return IGSCH04DTO
	 * @throws BLException
	 */
	public IGSCH04DTO removeQuartzJobsAction(IGSCH04DTO dto) throws BLException;
	
	/**
	 * ɾ������
	 * 
	 * @param dto IGSCH04DTO
	 * @return IGSCH04DTO
	 * @throws BLException
	 */
	public IGSCH04DTO deleteQuartzJobsAction(IGSCH04DTO dto) throws BLException;
}
