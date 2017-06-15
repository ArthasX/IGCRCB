/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */

package com.deliverik.infogovernor.dut.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dut.dto.IGDUT02DTO;


/**
 * ֵ�����ҵ���߼��ӿ�
 *
 *
 */
public interface IGDUT02BL extends BaseBL {

	/**
	 * <p>
	 * Description: ֵ�ཻ����ϸ��Ϣ��ѯ
	 * </p>
	 */
	public IGDUT02DTO initIGDUT0204Action(IGDUT02DTO dto) throws BLException;
	
	/**
	 * ֵ�ཻ��ȷ����Ϣ��ѯ����
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO initIGDUT0205Action(IGDUT02DTO dto) throws BLException;
	
	/**
	 * ֵ�ཻ��ȷ�ϴ���
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO confirmIGDUT0205Action(IGDUT02DTO dto) throws BLException;
	
	/**
	 * ֵ����ֹ��ϸ��Ϣ��ѯ����
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO initIGDUT0207Action(IGDUT02DTO dto) throws BLException;
	
	/**
	 * ֵ����ֹ����
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO terminateIGDUT0207Action(IGDUT02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ֵ���˳�����ʾ
	 * </p>
	 */
	public IGDUT02DTO initIGDUT0202Action(IGDUT02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���ֵ����
	 * </p>
	 */
	public IGDUT02DTO addDutyPersonAction(IGDUT02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ɾ��ֵ����
	 * </p>
	 */
	public IGDUT02DTO removeDutyPersonAction(IGDUT02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ������ʼ����Ϣ
	 * </p>
	 */
	public IGDUT02DTO initIGDUT0201Action(IGDUT02DTO dto) throws BLException;
	
	/**
	 * ֵ���ձ���ʼ������
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO initIGDUT0203Action(IGDUT02DTO dto) throws BLException;
	
	/**
	 * ֵ���ձ����洦��
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO insertIGDUT0203Action(IGDUT02DTO dto) throws BLException;
	/**
	 * 
	 * Description: ����ֵ��ƻ���ѯ
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 * @throws BLException
	 * @update
	 * 
	 */
	public IGDUT02DTO searchDutyPlanAction(IGDUT02DTO dto) throws BLException;

	/**
	 * ��������
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO changeDutyPlanAction(IGDUT02DTO dto) throws BLException ;
}
