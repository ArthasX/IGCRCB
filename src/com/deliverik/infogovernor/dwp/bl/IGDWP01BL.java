/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dwp.dto.IGDWP01DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ�BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGDWP01BL extends BaseBL{

	/**
	 * �ճ������ƻ���ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO searchDayWorkPlanAction(IGDWP01DTO dto) throws BLException;

	/**
	 * �������Ͳ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO searchProcessDefinitions(IGDWP01DTO dto) throws BLException;

	/**
	 * ��ʼ���ճ������ƻ�����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO initDayWorkPlanAction(IGDWP01DTO dto) throws BLException;

	/**
	 * �����ճ������ƻ�
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO insertDayWorkPlanAction(IGDWP01DTO dto) throws BLException;

	/**
	 * �ճ������ƻ��޸Ĳ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO changeDayWorkPlanAction(IGDWP01DTO dto) throws BLException;

	/**
	 * ����ִ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO execute(IGDWP01DTO dto) throws BLException;

	/**
	 * �������̶�����Ϣ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO initProcessDefinitionAction(IGDWP01DTO dto) throws BLException;

	/**
	 * �������̵Ǽǲ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO craeteProcessAction(IGDWP01DTO dto) throws BLException;

	/**
	 * �ճ������ƻ�����ҳ��ʼ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO initDayWorkPlanAssignAction(IGDWP01DTO dto) throws BLException;

	/**
	 * ���������Ϣ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO saveAssignAction(IGDWP01DTO dto) throws BLException;

	/**
	 * �ճ������ƻ�ɾ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO deleteDayWorkPlanAction(IGDWP01DTO dto) throws BLException;
	
	/**
	 * �༭�ճ������ƻ���ʼ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO editDayWorkPlanAction(IGDWP01DTO dto) throws BLException;
}
