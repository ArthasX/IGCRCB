package com.deliverik.infogovernor.syslog.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.syslog.dto.IGLOG0021DTO;

public interface IGLOG002BL extends BaseBL{

	/**
	 * 
	 * �豸�б��ѯ
	 *
	 * @���� zhaoyong
	 */
	public IGLOG0021DTO searchDeviceTemps(IGLOG0021DTO dto) throws Exception;
	
	/**
	 * �澯ģ���б��ѯ
	 * @param dto 
	 *
	 * @���� zhaoyong
	 */
	public IGLOG0021DTO searchAllTemp(IGLOG0021DTO dto) throws BLException;
	
	/**
	 * 
	 * ���Ĺ����״̬
	 * @throws BLException 
	 *
	 * @���� zhaoyong
	 */
	public IGLOG0021DTO changeTempstate(IGLOG0021DTO dto) throws BLException;
	
	/**
	 * ��ȡ��ǰ�澯����ģ��
	 * @param dto
	 * @return
	 */
	public IGLOG0021DTO getAlarmRule(IGLOG0021DTO dto) throws BLException;
	
	/**
	 * ɾ��ѡ���澯����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG0021DTO deleteAlarmRule(IGLOG0021DTO dto) throws BLException;
	

	/**
	 * 
	 * �澯����¼��
	 *
	 * @���� zhaoyong
	 */
	public IGLOG0021DTO insertDeviceAndRules(IGLOG0021DTO dto)throws BLException;
	
	/**
	 * �澯�����޸�
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG0021DTO updateDeviceAndRules(IGLOG0021DTO dto)throws BLException;
	
	/**
	 * ͨ���豸���ͻ�ȡ�������豸�б�
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG0021DTO getDevicesByTypeid(IGLOG0021DTO dto) throws BLException; 
	
	/**
	 * ͨ���豸���ͻ�ȡ�����͹����б�
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG0021DTO getRuleTempsByTypeid(IGLOG0021DTO dto) throws BLException;
	
	/**
	 * �����豸ID��ȡ�豸��Ϣ
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGLOG0021DTO getDevice(IGLOG0021DTO dto) throws Exception;
	
	/**
	 * ͨ��IP��ȡ�豸��Ϣ
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGLOG0021DTO getDeviceByIp(IGLOG0021DTO dto) throws Exception;
	
	/**
	 * �����豸ID��ȡ���������б�
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGLOG0021DTO getRuleTempsByDeviceid(IGLOG0021DTO dto) throws Exception;
	
	/**
	 * �����豸IDȡ�ù�ϵʵ�壨Mss00002��
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGLOG0021DTO getRelationEntityByDeviceid(IGLOG0021DTO dto) throws Exception;
	
	/**
	 * �������ø澯����
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGLOG0021DTO fastConfigAlarmRule(IGLOG0021DTO dto) throws Exception;
	
	
}
