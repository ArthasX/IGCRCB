package com.deliverik.infogovernor.rdp.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rdp.dto.IGRDP01DTO;

public interface IGRDP01BL extends BaseBL {
	
	/**
	 * Զ�̲���ű�
	 * @param dto
	 * @return
	 */
	public IGRDP01DTO remoteDeploy(final IGRDP01DTO dto) throws BLException;
	
	
	/**
	 * ��ȡҵ��ϵͳ�б�
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO getBusinessSystems(IGRDP01DTO dto) throws BLException;
	
	
	/**
	 * ͨ��ҵ��ϵͳeiid��ȡ���������б�
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO getHostsBySystemID(IGRDP01DTO dto) throws BLException;
	
	/**
	 * ��Ӳ�������ͽ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO insertTaskAndResults(IGRDP01DTO dto) throws BLException;
	
	
	/**
	 * ��ѯ��������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO searchTasks(IGRDP01DTO dto) throws BLException;
	
	/**
	 * ��ȡ��������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO searchAllTasks(IGRDP01DTO dto) throws BLException;
	
	/**
	 * ͨ������id��ȡ������
	 * @param dto
	 * @return
	 */
	public IGRDP01DTO getExcuteResultByTaskID(IGRDP01DTO dto) throws BLException;
	
	/**
	 * ͨ������id��ȡ������(ajax)
	 * @param dto
	 * @return
	 */
	public IGRDP01DTO getExcuteResultByTaskIDByAjax(IGRDP01DTO dto) throws BLException;
	
	
	/**
	 * ͨ����־·����ȡ������־
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO getLogByLogPath(IGRDP01DTO dto) throws BLException;
	
	/**
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO getHostByAjax(IGRDP01DTO dto) throws BLException;
	/**
	 * Ajax ��������id �� ����ip��ѯrealtimedetail ��������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO searchRealTimeDetail(IGRDP01DTO dto)throws BLException;
	/**
	 * Ajax ��������id �� �Ѳ��������id ��ȡ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO searchLastRealTimeDetail(IGRDP01DTO dto)throws BLException;
}
