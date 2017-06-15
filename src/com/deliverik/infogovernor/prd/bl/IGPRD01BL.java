/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.workflow.prd.model.IG286Info;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;

/**
 * ����: ���̶���ҵ���߼��ӿ�
 * ��������: ���̶���ҵ���߼��ӿ� 
 * ������¼: 2010/11/07		liupeng@deliverik.com
 * �޸ļ�¼: 2013/02/25		130225	���̻�������޸�
 */
public interface IGPRD01BL extends BaseBL {
	
	//-----------------------------------------------------------���̶���----------------------------------------------------------------------
	/**
	 * �жϵ�ǰ�Ƿ����δ�رյ�������ʹ��ģ��
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO isProcessDefinitionInUse(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ���̶�����Դ���
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO testProcessDefinitionAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ���̶�����Ϣ��ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessDefinitionAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ���̶�����Ϣ��ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchLastProcessDefinitionAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ������ʷ������Ϣ��ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchHistoryProcessDefinitionAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ���̶�����Ϣ�ǼǴ���
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertProcessDefinitionAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ���̶�����Ϣ�������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updateProcessDefinitionAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ���̶�����Ϣ�������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updateProcessInfoDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ���̶�����Ϣͣ��/���ô���
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO changeProcessDefinitionAction(IGPRD01DTO dto) throws BLException;
	
	
	/**
	 * ���̶�����Ϣ�����ʼ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO initIGPRD0102Action(IGPRD01DTO dto) throws BLException;
	
	//-----------------------------------------------------------���ɽ�ɫ----------------------------------------------------------------------
	/**
	 * ��ȡ���ɽ�ɫ
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO searchDispatchProcessParticipant(IGPRD01DTO dto) throws BLException;
	
	/**
	 * �趨���ɽ�ɫ
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO assignProcessParticipant(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ������ɽ�ɫ
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO clearProcessParticipant(IGPRD01DTO dto) throws BLException;
	
	//-----------------------------------------------------------ǰ����----------------------------------------------------------------------
	/**
	 * �����¼���ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchPreProcessEventDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ��ť�¼������ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessStatusButtonDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ��ť�¼������ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessStatusButtonDefByPK(IGPRD01DTO dto) throws BLException;
	
	/**
	 * �����¼���Ӵ���
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertPreProcessEventDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * �����¼���Ӵ���
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertProcessStatusButtonDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * �����¼��޸Ĵ���
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updatePreProcessEventDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * �����¼��޸Ĵ���
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updateProcessStatusButtonDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * �����¼�ɾ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deletePreProcessEventDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * �����¼�ɾ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deleteProcessStatusButtonDefAction(IGPRD01DTO dto) throws BLException;
	
	//-----------------------------------------------------------������----------------------------------------------------------------------
	
	/**
	 * ��������Ϣ��ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessTransitionDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ��������Ϣ��������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertProcessTransitionDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ��������Ϣɾ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deleteProcessTransitionDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ���нڵ��������Ϣ��������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertConcurrencyProcessTransitionDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ���нڵ��������Ϣ��ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchConcurrencyProcessTransitionDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ���нڵ��������Ϣɾ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deleteConcurrencyProcessTransitionDefAction(IGPRD01DTO dto) throws BLException;
	
	//-----------------------------------------------------------����Ϣ----------------------------------------------------------------------
	
	/**
	 * ����Ϣ��Ϣ��ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessInfoDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����Ϣ��Ϣ�ǼǴ���
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertProcessInfoDefAction(IGPRD01DTO dto) throws BLException;
	
	public IGPRD01DTO insertProcessInfoDefGeneralAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����Ϣ��Ϣɾ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deleteProcessInfoDefAction(IGPRD01DTO dto) throws BLException;
	
	public IGPRD01DTO orderProcessInfoDefAction(IGPRD01DTO dto) throws BLException;
	
	public IGPRD01DTO deleteProcessInfoDefGeneralAction(IGPRD01DTO dto) throws BLException ;
	
	public IGPRD01DTO searchProcessInfoDefGeneralAction(IGPRD01DTO dto) throws BLException;
	
	
	//-----------------------------------------------------------����״̬----------------------------------------------------------------------
	/**
	 * ����״̬��Ϣ��ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessStatusDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����״̬��Ϣɾ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deleteProcessStatusDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����״̬��Ϣ�ǼǴ���
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertProcessStatusDefinitionAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����״̬��Ϣ�����ʼ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO initIGPRD0105Action(IGPRD01DTO dto) throws BLException;

	/**
	 * ����״̬��Ϣ�������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updateProcessStatusDefinitionAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��ȡ����״̬������
	 * </p>
	 */
	
	public IGPRD01DTO getProcessParticipants(IGPRD01DTO dto) throws BLException;
	
	/**
     * ״̬������֧�ֻ���ѡ��
     * @param dto
     * @return
     * @throws BLException
     */
	public IGPRD01DTO getProcessParticipantsByOrg(IGPRD01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �������״̬������ 
	 * </p>
	 */
	
	public IGPRD01DTO addProcessParticipants(IGPRD01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ɾ������״̬������
	 * </p>
	 */
	
	public IGPRD01DTO removeProcessParticipants(IGPRD01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ����״̬������Ȩ��ҳ���ʼ��
	 * </p>
	 */
	
	public IGPRD01DTO processInfoParticipantDefInitAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ����״̬��������Ȩ����
	 * </p>
	 */
	
	public IGPRD01DTO grantPermissionAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ����״̬ȱʡ������Ȩ��ҳ���ʼ��
	 * </p>
	 */
	
	public IGPRD01DTO participantDefaultVariableInitAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ����״̬ȱʡ��������Ȩ����
	 * </p>
	 */
	
	public IGPRD01DTO grantDefaultPermissionAction(IGPRD01DTO dto) throws BLException;
	
	//-----------------------------------------------------------��̬��ǩ----------------------------------------------------------------------
	/**
	 * <p>
	 * Description: �������̶���id������״̬ȡ�ø�����״̬������
	 * </p>
	 */
	
	public String getPsNameByPdidAndPsdidAction(String pdid,String psdcode);
	
	//-----------------------------------------------------------����ͼ----------------------------------------------------------------------
	/**
	 * <p>
	 * Description: ��������״̬�����򹹽�����ͼ
	 * </p>
	 */
	
	public IGPRD01DTO initVmlAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��������ͼ
	 * </p>
	 */
	
	public IGPRD01DTO savePdXmlAction(IGPRD01DTO dto) throws BLException;
	
	public IGPRD01DTO insertProcessInfoDefFromProcessInfoDefGeneralAction(IGPRD01DTO dto) throws BLException ;
	/**
	 * <p>
	 * Description: ��ѡ��ɫ����
	 * </p>
	 */
	public IGPRD01DTO getProcessRoleTypeDefAction(IGPRD01DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ���ӽ�ɫ����
	 * </p>
	 */
	public IGPRD01DTO addProcessRoleTypes(IGPRD01DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ɾ����ɫ����
	 * </p>
	 */
	public IGPRD01DTO removeProcessRoleTypes(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ���ӹ�ͨ������ʼ����ѯҳ��IGPRD0119��
	 */
	public IGPRD01DTO searchProcessInfoDefGeneralActionFor0119(IGPRD01DTO dto) throws BLException;
	
	//�ı���󶨸���
	public  List<Attachment> searchInofAtt(String piattkey);
	
	/**
	 * <p>
	 * Description: ���̼��������ѯ
	 * </p>
	 */
	public IGPRD01DTO searchProcessLinkageDef(IGPRD01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���̼�������
	 * </p>
	 */
	public IGPRD01DTO insertProcessLinkageDef(IGPRD01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���̼���ɾ��
	 * </p>
	 */
	public void deleteProcessLinkageDef(String plid) throws BLException;
	
	/**
	 * <p>
	 * Description: ���̼�������
	 * </p>
	 */
	public IG286Info editProcessLinkageDef(String plid) throws BLException;
	
	/**
	 * ���̶������洦��
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO upgradeProcessDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ���̶��帴�ƴ���
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO copyProcessDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ���̶��嵼�봦��
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO importProcessDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ���̶��嵼������
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO exportProcessDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����״̬�ɷ��ɽ�ɫ��ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessStatusRoleDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����״̬�ɷ��ɽ�ɫ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO addProcessStatusRoleDef(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����״̬�ɷ��ɽ�ɫɾ��
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO removeProcessStatusRoleDef(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ���̱���Ϣ�޸�
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO initIGPRD0111Action(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����֪ͨ���Բ�ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO initIGPRD0158Action(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����֪ͨ�����趨����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO editIGPRD0158Action(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����֪ͨ������Ϣ�趨����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO setIGPRD0158Action(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����֪ͨ���Բ�ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO initIGPRD0159Action(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����ϵͳ���尴ť����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessButtonDef(IGPRD01DTO dto) throws BLException;
	
	/**
	 * �ⲿ�¼������ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessExternalDefByPK(IGPRD01DTO dto) throws BLException;
	
	/**
	 * �ⲿ�¼��޸Ĵ���
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updateProcessExternalDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * �ⲿ�¼����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertProcessExteralDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * �ⲿ�¼�ɾ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deleteProcessExternalDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * �ⲿ�¼���ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessExternalDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ͨ�ñ���Ϣ�����ʼ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO initIGPRD0118Action(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ���̶�����Ϣ�������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updateProcessInfoDefGeneralAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����״̬��ѯ
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessStatusDef(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����״̬�ɵ��������߲�ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessStatusPrtChangeDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����״̬�ɵ����������趨����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO changeProcessStatusPrtChangeDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����ʼ�����ò�ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchIG373InfoAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����ʼ��������������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertIG373InfoAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����ʼ������ɾ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deleteIG373InfoAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����ʼ�������޸ĳ�ʼ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO initIG373InfoAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����ʼ�������޸Ĵ���
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO editIG373InfoAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ��Ȩ�޲�ѯ��ʼ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO getProcessRoleConfigAction(IGPRD01DTO dto) throws BLException;

	/**
	 * ɾ����Ȩ�޽�ɫ
	 * @param dto
	 * @throws BLException
	 */
	public IGPRD01DTO removeProcessRoleConfig(IGPRD01DTO dto) throws BLException;

	/**
	 * ��ӱ�Ȩ�޽�ɫ
	 * @param dto
	 * @throws BLException
	 */
	public IGPRD01DTO addProcessRoleConfig(IGPRD01DTO dto) throws BLException;

	/**
	 * ����ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO getProcessRoleFormRelationAction(IGPRD01DTO dto) throws BLException;

	/**
	 * ɾ����Ȩ��
	 * @param dto
	 * @throws BLException
	 */
	public IGPRD01DTO removeProcessRoleFormRelation(IGPRD01DTO dto) throws BLException;

	/**
	 * ��ӱ�Ȩ��
	 * @param dto
	 * @throws BLException
	 */
	public IGPRD01DTO addProcessRoleFormRelation(IGPRD01DTO dto)throws BLException;
	
	/**
     * ��ط�������̶�����Ϣ��ѯ����
     *
     * @param dto IGPRD01DTO
     * @return IGPRD01DTO
     */
    public IGPRD01DTO searchRelevantProcessDefinitionAction(IGPRD01DTO dto) throws BLException;
    
    /**
     * ������ط�����Զ�������������Ϣ
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGPRD01DTO grantRelevantProcessAction(IGPRD01DTO dto) throws BLException;
    
    /**
     * ȱʡȨ�޵���ط�������̶�����Ϣ��ѯ����
     *
     * @param dto IGPRD01DTO
     * @return IGPRD01DTO
     */
    public IGPRD01DTO searchDefaultRelevantProcessDefinitionAction(IGPRD01DTO dto) throws BLException;
    
    /**
     * ����ȱʡȨ�޵���ط�����Զ�������������Ϣ
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGPRD01DTO grantDefaultRelevantProcessAction(IGPRD01DTO dto) throws BLException;
    
    /**
     * ��ѯ��ѡ��һ���˵��б�
     *
     * @param dto IGPRD01DTO
     * @return IGPRD01DTO
     */
    public IGPRD01DTO searchActionListAction(IGPRD01DTO dto) throws BLException;
    

	/**
	 * �Զ�������ҳ�����ò�ѯ
	 *
	 *��ѧ־
	 *2012-11-13����9:09:27
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO searchProcessJspInfoAction(IGPRD01DTO dto)throws BLException;

	/**
	 * �Զ�������ҳ�����õǼ�
	 *
	 *��ѧ־
	 *2012-11-13����1:14:19
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO insertProcessJspAction(IGPRD01DTO dto)throws BLException;
	/***
	 * �Զ�������ҳ�������޸�
	 *
	 *��ѧ־
	 *2012-11-13����3:39:08
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO editProcessJspAction(IGPRD01DTO dto)throws BLException;
	/**
	 * �Զ�������ҳ������ɾ��
	 *
	 *��ѧ־
	 *2012-11-13����4:48:45
	 * @param pjdid
	 * @throws BLException
	 */
	public IGPRD01DTO deleteProcessJspAction(IGPRD01DTO dto)throws BLException;

	/**
	 * ����״̬��Ϣ�������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updateProcessStatusDefZAction(IGPRD01DTO dto) throws BLException;

	/**
	 * ��ѯ�����趨ҳ���ʼ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO getProcessInfoQueryInfo(IGPRD01DTO dto) throws BLException;

	/**
	 * ��ѯ����ɾ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO addProcessInfoQuery(IGPRD01DTO dto) throws BLException;

	/**
	 * ��ѯ������������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO removeProcessInfoQuery(IGPRD01DTO dto) throws BLException;
	
	//====>130225Begin
	/**
	 * ��ѯ����������
	 * 
	 * @param dto
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO searchCodedetailFromPsdassign(IGPRD01DTO dto) throws BLException ;
	
	/**
	 * ����״̬�ɷ��ɻ�����ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessStatusOrgDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����״̬�ɷ��ɻ���ɾ��
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO removeProcessStatusOrgDef(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ����״̬�ɷ��ɻ�������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO addProcessStatusOrgDef(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ��ӻ���������
	 * @param dto
	 * @throws BLException
	 */
	public IGPRD01DTO addProcessParticipantsByOrg(IGPRD01DTO dto) throws BLException;

	/**
	 * ɾ������������
	 * @param dto
	 * @throws BLException
	 */
	public IGPRD01DTO removeProcessParticipantsByOrg(IGPRD01DTO dto) throws BLException;

	/**
	 * ���̻�����Χѡ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO getProcessOrgDefAction(IGPRD01DTO dto) throws BLException;

	/**
	 * �Ƴ�������Χ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO removeProcessOrg(IGPRD01DTO dto) throws BLException;

	/**
	 * ��ӻ�����Χ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO addProcessOrg(IGPRD01DTO dto) throws BLException;
	//====>130225End

	/**
	 * ������Ԥ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO searchColumnInfoAction(IGPRD01DTO dto) throws BLException;

	/**
	 * ���̲����߱������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO changeProcessParticipants(IGPRD01DTO dto) throws BLException;

	/**
	 * ��ѯ����URL
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO searchBackURLAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ��ѯ���̲���֪ͨ���ɫ
	 * 
	 * @param dto
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO searchRoleByIGBP06Action(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ��ѯ���̲��Դ���Bl����
	 * 
	 * @param dto
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO searchProcessBLByIGBP06Action(IGPRD01DTO dto) throws BLException;
	
	/**
	 * ȡ������ģ����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO searchProcessTemplateAction(IGPRD01DTO dto) throws BLException;

	/**
	 * ��ѯ���̶�����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO searchProcessDefinitonsAction(IGPRD01DTO dto) throws BLException;
/**
     * 
     * @Title: initStatusDefault
     * @Description: ״̬��˽�б�Ĭ��ֵ��ʼ��
     * @param dto
     * @return dto
     * @throws BLException
     * @throws
     */
	public IGPRD01DTO initStatusDefault(IGPRD01DTO dto)throws BLException;

	/**
	 * �������̲�ѯ�趨����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO changeProcessQueryAction(IGPRD01DTO dto) throws BLException;

	/**
	 * ���̲�ѯ��ʾ�ж����ʼ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO initProcessQueryShowColumnAction(IGPRD01DTO dto) throws BLException;

	/**
	 * ���̲�ѯ�����п�ȵ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO editProcessQueryShowColumnWidthAction(IGPRD01DTO dto) throws BLException;
	
	
	
	/***********************************���������***************************************************************/
	
	/**
	 * ��������������ı༭���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	
	public IGPRD01DTO updFlowXML(IGPRD01DTO dto)throws BLException;
	
	/**
	 * ���������������ʼ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO initFlowXML(IGPRD01DTO dto)throws BLException;
	
	/**
	 * ��������ͼxml
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	
	public IGPRD01DTO savePdXML(IGPRD01DTO dto)throws BLException;
	
	/**
	 * ��ѯ���̲�����xml �����������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO searchUserRoleInfoForPDeg(IGPRD01DTO dto) throws BLException;
	
	/**
     * ȱʡȨ�޵���ط�������̶�����Ϣ��ѯ����
     *
     * @param dto IGPRD01DTO
     * @return IGPRD01DTO
     */
    public String searchProcessDefinitionList(IGPRD01DTO dto) throws BLException;
}

