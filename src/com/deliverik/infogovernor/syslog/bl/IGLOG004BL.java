package com.deliverik.infogovernor.syslog.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.syslog.dto.IGLOG0041DTO;

public interface IGLOG004BL extends BaseBL{
	/**
	 * 
	 * ��ѯ����ģ��
	 *
	 * @���� zhaoyong
	 */
	public IGLOG0041DTO searchMss00004(IGLOG0041DTO dto);
	
	/**
	 * 
	 * ����ģ���״̬
	 * @throws BLException 
	 *
	 * @���� zhaoyong
	 */
	public IGLOG0041DTO changeTempstate(IGLOG0041DTO dto) throws BLException;

	/**
	 * 
	 * ¼���������ģ��
	 * @throws BLException 
	 *
	 * @���� zhaoyong
	 */
	public IGLOG0041DTO insertMss0004(IGLOG0041DTO dto) throws BLException;
	
	/**
	 * �޸Ĺ�������ģ��
	 * @���� zhaoyong
	 */
	public IGLOG0041DTO updateMss0004(IGLOG0041DTO dto)throws BLException;
	
	/**
	 * 
	 * ��õ�ǰ��������ģ��
	 *
	 * @���� zhaoyong
	 */
	public IGLOG0041DTO getMss0004(IGLOG0041DTO dto)throws BLException;

	/**
	 * ɾ����ǰģ��
	 * @���� zhaoyong
	 */
	public void deleteTemp(IGLOG0041DTO dto)throws BLException;
	
	/**
	 * �ӻ������ݱ�codedetail����ȡ�澯����
	 * @return
	 * @throws Exception
	 */
	public IGLOG0041DTO getAlarmPriority(IGLOG0041DTO dto) throws Exception;
	
	
	/**
	 * ��ȡĳ��ģ����豸�б��ַ�����ʽ��
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGLOG0041DTO getDeviceListString(IGLOG0041DTO dto) throws Exception;
}
