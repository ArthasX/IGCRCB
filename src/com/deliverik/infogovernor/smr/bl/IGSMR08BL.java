/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.dto.IGSMR08DTO;

/**
 * ����:��������� 
 * �������������������
 * �����ˣ�����͢
 * ������¼�� 2013-09-02
 * �޸ļ�¼��
 */
public interface IGSMR08BL extends BaseBL {

	/**
	 * 
	 *�����������ſ���
	 *ʱ�䣺2013-9-02
	 *@param dto
	 *@return
	 * @throws BLException 
	 */
	IGSMR08DTO initSMR0801ByOrgAction(IGSMR08DTO dto) throws BLException;
	
	/**
	 * 
	 *����������Ա����
	 *ʱ�䣺2013-9-02
	 *@param dto
	 *@return
	 * @throws BLException 
	 */
	IGSMR08DTO initSMR0801ByUserAction(IGSMR08DTO dto) throws BLException;
	
	/**
	 * ��ر�����ϸҳ ��Ϣ��ѯ
	 * @param dto
	 * @return
	 */
	public IGSMR08DTO searchListForDetailAction(IGSMR08DTO dto) throws BLException;
	
	/**
	 * ��������ϵͳ�������ͳ�Ƴ�ʼ����ѯ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException 
	 */
	public IGSMR08DTO searchIGSMR0804Action(IGSMR08DTO dto) throws BLException;
	
	/**
	 * ��������ϵͳ�������ͳ�Ƴ�ʼ����ѯ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException 
	 */
	public IGSMR08DTO searchIGSMR0805Action(IGSMR08DTO dto) throws BLException;
	
	/**
	 * ���п�ϵͳ�������ͳ�Ƴ�ʼ����ѯ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException 
	 */
	public IGSMR08DTO searchIGSMR0806Action(IGSMR08DTO dto) throws BLException;
}
