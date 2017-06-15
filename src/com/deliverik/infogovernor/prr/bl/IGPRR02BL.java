/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prr.dto.IGPRR02DTO;

/**
 * ����:������ 
 * ����������������
 * �����ˣ�����͢
 * ������¼�� 2013-02-25
 * �޸ļ�¼��
 */
public interface IGPRR02BL extends BaseBL {

	/**
	 * ��ѯ�����˽�ɫ�µ�������
	 * @param dto
	 * @return IGPRR02DTO
	 * @throws BLException
	 */
	public IGPRR02DTO getPeopleUnderRoleAction(IGPRR02DTO dto) throws BLException;
	
	/**
	 * ��������id��ѯ������Ϣ
	 * @param dto
	 * @return IGPRR02DTO
	 * @throws BLException
	 */
//	public IGPRR02DTO getProcessInfoByPkAction(IGPRR02DTO dto) throws BLException;
	
	/**
	 * ����������ѯ��������Ϣ
	 * @param dto
	 * @return IGPRR02DTO
	 * @throws BLException
	 */
	public IGPRR02DTO getCopyReadInfoByCondAction(IGPRR02DTO dto) throws BLException;
	/**
	 * ���泭������Ϣ
	 * @param dto
	 * @return IGPRR02DTO
	 * @throws BLException
	 */
	public IGPRR02DTO saveCopyReadInfoByPkAction(IGPRR02DTO dto) throws BLException;
	
	/**
	 * ���ȷ�ϰ�ť�޸Ĳ鿴ʱ��
	 * @param dto
	 * @return IGPRR02DTO
	 * @throws BLException
	 */
	public IGPRR02DTO updateIsLookAction(IGPRR02DTO dto) throws BLException;
	
	/**
     * ����Ӱ���ļ�
     *
     * @param dto IGPRR01DTO
     * @return IGPRR01DTO
     */
    public IGPRR02DTO generateImageAction(IGPRR02DTO dto)throws BLException;

}
