/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.srv.bl;


import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.soc.srv.dto.IGSRV02DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:  ���̹���_�¼�ҵ���߼��ӿ�
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @History 2010-7-13     0000000: ���ӿ�ݷ����¼�����
 *          2010-12-07    yangliang: ���Ӳ�ѯȫ�����̹���
 * @version 1.0
 */

public interface IGSRV02BL extends BaseBL {
	/**
	 * <p>
	 * Description: ��ȡ�¼�������ʾ״̬������ťȨ�ޣ� 
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getActionStatus(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ��ȡ�¼������� 
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getImplementors(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ��ȡ��ʷ��¼ 
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getRecordLogs(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ��ȡ�¼������
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getVerifiors(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ɾ���¼���¼
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGSRV02DTO delProcessRecord(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ��ѯ�¼���¼
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGSRV02DTO getProcessRecords(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ��ѯȫ�����̼�¼
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update yangliang@deliverik.com
	 */
	
	public IGSRV02DTO getProcessRecordsAll(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ͨ��prid����ѯ����
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public List<IG500Info> searchProcessRecordByKey(Integer prid) throws BLException;
	/**
	 * <p>
	 * Description: �û���ɫ��ѯ
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getUserRoles(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: �û������̽�ɫ��ѯ
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */

	public IGSRV02DTO getUserRolesNotInProcess(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ��ȡָ���¼�״̬�Ĳ�����
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSRV02DTO getProcessParticipantsByStatus(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ��ȡ�û������е�ָ���¼��Ĳ����߽�ɫ
	 * </p>
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */

	public IGSRV02DTO getUserRolesInProcessParticipants(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ��ѯ���Է��ɵĽ�ɫ
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getDispatchRoles(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ��ѯ�¼����
	 * <p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 */
	
	public IGSRV02DTO searchIncidentCategory(IGSRV02DTO dto) throws BLException;
	/**
	 * �¼������̶ȷ�����Բ�ѯ
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 */
	
	public IGSRV02DTO searchIncidentUrgency(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ��ȡδȷ�ϲ�����
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGSRV02DTO getConfirmer(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ��ȡִ����
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO searchAssignPersonAction(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ��ȡ����״̬�б�
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update yangshengnan@deliverik.com
	 */
	
	public IGSRV02DTO getProcessDefinition(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ��ȡȫ������״̬�б�
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update yangliang@deliverik.com
	 */
	
	public IGSRV02DTO getProcessDefinitionAll(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ����״̬��־�鿴 
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGSRV02DTO searchRecordStatusLogAction(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ���ӹ����ֶεĴ��������޸ĵײ㣬���Դ��ֶε�ֵ����ӵ������ֶ���
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update
	 */
	public IGSRV02DTO getSortOrder(IGSRV02DTO dto) throws BLException;
}
