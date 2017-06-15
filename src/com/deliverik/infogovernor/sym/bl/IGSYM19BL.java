/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.sym.bl;

import java.text.ParseException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM19DTO;
/**
 * ����:����������Чʱ�����ҵ���߼��ӿ�
 * ��������������������Чʱ�����
 * ������¼�����    2011/10/18
 */
public interface IGSYM19BL extends BaseBL{
	/**
	 * ��Ϣ���ڲ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM19DTO searchProcessWorkTimeTemplate(IGSYM19DTO dto) throws BLException;
	/**
	 * ��Ϣ��������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM19DTO insertProcessWorkTimeTemplateAction(IGSYM19DTO dto) throws BLException;
	/**
	 * ��Ϣ���ڱ��
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws ParseException 
	 */
	public IGSYM19DTO updateProcessWorkTimeTemplateAction(IGSYM19DTO dto) throws BLException, ParseException;

	/**
	 * �û���Ϣ���ڲ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM19DTO searchProcessWorkTimeCount(IGSYM19DTO dto) throws BLException;
	
	/**
	 * ��Ϣ����ģ����������
	 * @param dto
	 * @return
	 */
	public IGSYM19DTO searchProcessWorkTimeTemplateByPK(IGSYM19DTO dto) throws BLException;
}
