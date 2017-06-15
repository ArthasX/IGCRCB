/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.dto.IGSMR03DTO;

/**
 * ����:�ҵ�����걨����ѯ 
 * �����������ҵ�����걨����ѯ 
 * �����ˣ�����͢
 * ������¼�� 2013-07-25
 * �޸ļ�¼��
 */
public interface IGSMR03BL extends BaseBL {

	/**
	 * ��ѯ��Ҫ�Ҵ�����걨
	 *
	 */
	public IGSMR03DTO needMeManagerAction(IGSMR03DTO dto) throws BLException;
	
	/**
	 * ��ѯ��������
	 *
	 */
	public IGSMR03DTO reportExamineAction(IGSMR03DTO dto)throws BLException;
	
	/**
	 * ��ѯ�걨����
	 *
	 */
	public IGSMR03DTO AnnualreportExamineAction(IGSMR03DTO dto);
	
	/**
	 * ��鿴
	 *
	 */
	public IGSMR03DTO seeFillInAction(IGSMR03DTO dto)throws BLException;
	
	/**
	 * ���ֹ
	 *
	 */
	public IGSMR03DTO stopFillInAction(IGSMR03DTO dto)throws BLException;
	
	
	/**
	 * �߰�
	 *
	 */
	public IGSMR03DTO pressAction(IGSMR03DTO dto)throws BLException;	

	/**
	 * ��������ʱ��
	 *
	 */
	public IGSMR03DTO setCautionTimeAction(IGSMR03DTO dto)throws BLException;	
	
	/**
	 * �������ʱ��
	 *
	 */
	public IGSMR03DTO eliminateCautionTimeAction(IGSMR03DTO dto)throws BLException;	
	
	/**
	 * ����ʱ���ѯ
	 *
	 */
	public IGSMR03DTO searchCautionTimeAction(IGSMR03DTO dto)throws BLException;
	
	/**
	 * ��ֹ����ʱ��
	 *
	 */
	public IGSMR03DTO stopCautionTimeAction(IGSMR03DTO dto)throws BLException;
	
	/**
	 * �����ҳ��ת��������ҵĹ���
	 *
	 */
	public IGSMR03DTO init0304Action(IGSMR03DTO dto)throws BLException;
	
	/**
	 * ͨ�ò�ѯ 
	 *
	 */
	public IGSMR03DTO init0305Action(IGSMR03DTO dto)throws BLException;
}
