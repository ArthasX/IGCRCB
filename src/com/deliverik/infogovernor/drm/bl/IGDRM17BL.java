/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM17DTO;

/**
 * <p>
 * Title : InfoGovernor ģ������
 * </p>
 * <p>
 * Description:��ѵ��¼����BL�ӿ�
 * </p>
 * 
 * @author zhangbo@deliverik.com
 * @version 1.0
 */
public interface IGDRM17BL extends BaseBL {

	/**
	 * ��ѵ��¼��ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO searchTrainAction(IGDRM17DTO dto) throws BLException;

	/**
	 * ��ʼ����ѵ��¼��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO initTrainRecordAction(IGDRM17DTO dto) throws BLException;

	/**
	 * ��ѵ��¼��������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO insertTrainRecordAction(IGDRM17DTO dto) throws BLException;

	/**
	 * ��ѵ��¼�޸Ĳ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO changeTrainRecordAction(IGDRM17DTO dto) throws BLException;

	/**
	 * ��ѵ��¼ɾ������
	 * @param dto
	 * @throws BLException
	 */
	public IGDRM17DTO  delTrainRecordAction(IGDRM17DTO dto)throws BLException;
	
	/**
	 * ��ѯ�û���Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO searchUserRoleAction(IGDRM17DTO dto)throws BLException;
	
	/**
	 * ��ѵ��¼����ɾ��ɾ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO deleteEntityItemAction(IGDRM17DTO dto)throws BLException;
	
}
