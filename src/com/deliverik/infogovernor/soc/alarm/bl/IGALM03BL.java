/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.alarm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM03DTO;



/**
 *	��ض�����������
 *	2013.08.01
 *	@author wangxing
 */
public interface IGALM03BL extends BaseBL {
	
	/**
	 * ��ȡ��ض�����ͼ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGALM03DTO searchIGALM03Action(IGALM03DTO dto) throws BLException;
	
	/**
	 * �޸ļ�ض���״̬�������Ƿ����ɸ澯
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGALM03DTO changeStatus(IGALM03DTO dto) throws BLException;
	
	/**
	 * ��ȡ����ģ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGALM03DTO getRuleTemps(IGALM03DTO dto) throws BLException;
	
	/**
	 * ���ü�ض���澯����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGALM03DTO insertRuleTemps(IGALM03DTO dto) throws BLException;
	
	/**
	 * ��ȡCRM09��ϵʵ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGALM03DTO getCRM09Info(IGALM03DTO dto) throws BLException;
	
}
