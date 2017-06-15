package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM20DTO;

/**
 * ����: 
 * ��������: 
 * ������¼: 
 * �޸ļ�¼: 
 */
public interface IGDRM20BL extends BaseBL{

	IGDRM20DTO insertEntityAction(IGDRM20DTO dto) throws BLException;

	IGDRM20DTO updateEntityAction(IGDRM20DTO dto) throws BLException;

	/**
	 * ��ȡԤ���½���Ϣ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO getPlanSectionTree(IGDRM20DTO dto) throws BLException;

	/**
	 * ����Ԥ���½ڴ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO insertSoc0509Info(IGDRM20DTO dto)throws BLException;

	/**
	 * ��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO searchPlanAction(IGDRM20DTO dto) throws BLException;

	/**
	 * �����½�
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO startAction(IGDRM20DTO dto) throws BLException;
	/**
	 * ͣ���½�
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO stopAction(IGDRM20DTO dto) throws BLException;

	/**
	 * ��ʼ��Entityʵ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO initEntityAction(IGDRM20DTO dto) throws BLException;

	/**
	 * ɾ��ĳ��Entity�µ�SOC0509
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO deletePlanOfEntity(IGDRM20DTO dto) throws BLException;
	/**
	 * ������ĳ��Entity�µ�SOC0509
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO renamePlanOfEntity(IGDRM20DTO dto) throws BLException;

	/**
	 * ��ȡĳ��ģ���µ���ϸ��Ϣ
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO getPlanTreeDetail(IGDRM20DTO dto) throws BLException;

	/**
	 * ��ʼ��ģ����Ϣ��ģ�����ֽڵ����Ϣ������У�
	 * @param dto
	 * @throws BLException
	 */
	IGDRM20DTO initModelAction(IGDRM20DTO dto) throws BLException;
	
	/**
	 * ��ʼ��Ԥ��ģ����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO initS0C0117EditInfo(IGDRM20DTO dto) throws BLException;

	/**
	 * ����ģ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO copyAction(IGDRM20DTO dto) throws BLException;

	IGDRM20DTO sortSoc0509Action(IGDRM20DTO dto) throws BLException;

}
