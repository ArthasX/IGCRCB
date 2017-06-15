/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.bl;

import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.dto.IGRPT02DTO;

/**
 * ����: �¼��ͱ������Ч��ҵ���߼��ӿ�
 * ��������: �¼��ͱ������Ч��ҵ���߼��ӿ�
 * ������¼: 2011/11/23
 * �޸ļ�¼: 
 */
public interface IGRPT02BL extends BaseBL {

	/**
	 * ִ������¼�����Ч�ʴ���
	 * @throws BLException
	 */
	public void saveIncidentEfficiency() throws BLException;

	/**
	 * ִ����ӱ������Ч�ʴ���
	 * @throws BLException
	 */
	public void saveAlterationEfficiency() throws BLException;
	/**
	 * �Զ������ѯ
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO searchReportTemplateByCond(IGRPT02DTO dto)throws BLException;
	/**
	 * �Զ�����ɾ��
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO deleteReportTemplateInstance(IGRPT02DTO dto)throws BLException;
	/**
	 * �Զ���������
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO insertReportTemplateInstance(IGRPT02DTO dto)throws BLException;
	/**
	 * �Զ��������
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO updateReportTemplateInstance(IGRPT02DTO dto)throws BLException;
	/**
	 * ��Ӹ�������
	 * @param dto
	 * @return Map<String,String> �����ļ���Ϣ
	 */
	public Map<String, String> insertFileAction(IGRPT02DTO dto)throws BLException;
	/**
	 * ��ʼ����������
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO initInsertAction(IGRPT02DTO dto)throws BLException;
	/**
	 * �Զ�����ģ����»�����ʾ����
	 * @param IGRPT02DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO initUpdateReportTemplateAction(IGRPT02DTO dto)
			throws BLException;

	/**
	 * ��ʼ����ѯ���ӱ���
	 * @param dto
	 * @return IGRPT01DTO
	 * @throws BLException
	 */
	public IGRPT02DTO searchInitAnnexationAction(IGRPT02DTO dto)throws BLException;
	
	/**
	 * ɾ�����ӱ���
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO deleteReportAnnexationInstance(IGRPT02DTO dto)throws BLException;
	/**
	 * ��������ҳ��ѯ
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO searchReportManageByCond(IGRPT02DTO dto)throws BLException;
	/**
	 * �������ɾ��
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO deleteReportManageInstance(IGRPT02DTO dto)throws BLException;
	/**
	 * �����������
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO insertReportManageInstance(IGRPT02DTO dto)throws BLException;
	/**
	 * ���������ʼ��
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO insertReportManageInitAction(IGRPT02DTO dto)throws BLException;
	/**
	 * �޸�ӳ���ϵ
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO updateSOC0206(IGRPT02DTO dto)throws BLException; 
	/**
	 * �޸ı����ʼ��
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO initUpdateReportManageInstance(IGRPT02DTO dto)throws BLException;
	/**
	 * ��������޸�
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO updateReportManageInstance(IGRPT02DTO dto)throws BLException;
	/**
	 * �Զ��屨���������
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO searchSOC0204Action(IGRPT02DTO dto)throws BLException;
}
