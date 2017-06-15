/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.bl;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;

/**
 * @Description: ��������ҵ���߼��ӿ�
 * @Author  
 * @History 2010-9-13     �½� 
 * 			2012-3-20	  ����  120320�� ��������ʱ������ɾ�����ύ���͡��ύ��ȷ�ϡ��ĸ���
 * @Version V1.0
 */
public interface IGPRR01BL extends BaseBL {
	
	/**
	 * ���̷���ҳ���ʼ��
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO initIGPRR0101Action(IGPRR01DTO dto) throws BLException;
	
	/**
	 * ���̷���ҳ���ʼ��
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO initIGPRR0102Action(IGPRR01DTO dto) throws BLException;
	
	/**
	 *�鿴����_��ɫ��Ϣ��ѯ����
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	public IGPRR01DTO searchReadProcessParticipantRoleAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * ҳ���ʼ����ȷ���ò�������ҳ���п��Խ��еĲ���
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	public IGPRR01DTO getActionList(IGPRR01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ����ԾǨ 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO flow(IGPRR01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �������� 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO createProcessAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * ����ͼ��ѯ
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchFlowChartXmlAction(IGPRR01DTO dto) throws BLException;
	/**
	 * ��ϳ�������ͼ��ѯ
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchGroupFlowChartXml(IGPRR01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��ȡִ����
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO searchProcessExecutorsAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ִ����
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO adjustExecutorsAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��ȡOAִ����
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO searchAssignOAPersonAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: OAִ����
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO assignOAPersonAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ����״̬��־�鿴 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGPRR01DTO searchRecordStatusLogAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * ������תJSPȡ��
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchForwardJsp(IGPRR01DTO dto) throws Exception;
	
	/**
	 * <p>
	 * Description: ��ȡ����־��¼
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO getVarRecordLogs(IGPRR01DTO dto) throws BLException;
	
	/**
	 * �ɲ������̽�ɫȡ��
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchProcessRoleListAction(IGPRR01DTO dto) throws Exception;
	
	/**
	 * ��ͨ�ڵ�SUPER���ɳ�ʼ��
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO initIGPRR0113Action(IGPRR01DTO dto) throws BLException;
	
	/**
	 * SUPER��ɫ�����߷��ɴ���
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO addProcessParticipantBySuper(IGPRR01DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ͨ������id��login�û���ѯ��Ȩ��
	 * </p>
	 * 
	 * @param dto IGSVC02DTO
	 * @return IGSVC02DTO
	 * @throws BLException
	 * @author   
	 */
	
	public IGPRR01DTO getAuthorizeuser(IGPRR01DTO dto) throws BLException ;
	
	public IGPRR01DTO getRecordLogs(IGPRR01DTO dto) throws BLException;
	public IGPRR01DTO terminate(IGPRR01DTO dto) throws BLException;
	public Map<String,List<Attachment>> getProcessInfo(int prid) throws BLException;
	
	//====>120320Begin
	/**
	 * ɾ��������Ϣ
	 * 
	 * @param attid
	 * @param rlid
	 * @throws BLException
	 */
	public boolean deleteFile(Integer attid, Integer rlid) throws BLException;
	//====>120320End
	
	/**
	 * ָ��״̬�ɷ��ɽ�ɫ�������û�����ѯ
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchParticipantDefToBeAssignAction(IGPRR01DTO dto) throws Exception;
	
	/**
	 * ָ��״̬�ɷ��ɽ�ɫ���������û�����ѯ
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchRoleDefToBeAssignAction(IGPRR01DTO dto) throws Exception;
	
	/**
	 * <p>
	 * Description: ��ͨ�û�����ִ����
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	public IGPRR01DTO adjustExecutorsForNormalUserAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���ɱ���ִ����
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	public IGPRR01DTO saveExecutorsAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * ��ѯ�������̵�����ID
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO searchActionSortID(IGPRR01DTO dto) throws BLException;
	
	/**
     * <p>
     * Description: ȡ�������Զ���ķ���ҳ��URL��Ϣ
     * </p>
     * 
     * @param dto IGPRR01DTO
     * @return IGPRR01DTO
     * @throws BLException
     * @update
     */
    
    public IGPRR01DTO getAssignPageAction(IGPRR01DTO dto) throws BLException;
    
    /**
     * ��ǰ�����������ð汾��PDIDȡ�ô���7λ��PDIDȡ�ô���
     *
     * @param dto IGPRR01DTO
     * @return IGPRR01DTO
     */
    public IGPRR01DTO searchPdid7BitAction(IGPRR01DTO dto) throws BLException;
	
	//====>130225Begin 
	/**
	 * ���ݻ�����ѯִ����
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException 
	 */
	public IGPRR01DTO searchProcessExecutor(IGPRR01DTO dto) throws BLException;
	
	/**
	 * ��ִ�������Ϊ������
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	public IGPRR01DTO addProcessExecutor(IGPRR01DTO dto) throws BLException;
	//====>130225End
	
	/**
	 * ����super����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO addProcessParticipantByOrgSuper(IGPRR01DTO dto) throws BLException;

	/**
	 * ȡ�����̲�������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO searchParticipantInfoActon(IGPRR01DTO dto) throws BLException;

	/**
	 * ��ֵ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO copyProcessInfoValueAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��������ID��ѯ�����˸����̵����̼�¼
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO getProcessRecordByRelations(IGPRR01DTO dto) throws BLException;
	
	/**
	 * �����ɫ��Ϣ��ѯ����
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	public IGPRR01DTO searchInitProcessParticipantRoleAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * �ɵ��������߲�ѯ
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchAdjustParticipantAction(List<IG333Info> lst_ProcessStatusDef, IGPRR01DTO dto) throws BLException;
	
	/**
	 * �ɷ��ɲ����߲�ѯ
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchAssignParticipantAction(IGPRR01DTO dto) throws BLException;

	/**
	 * ���������̵�����ͼ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO searchChileFlowChartAction(IGPRR01DTO dto) throws BLException;
	/**
	 * ����ͼ��ѯ
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchFlowChartXmlActionForDrm(IGPRR01DTO dto) throws BLException;
	/**
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO searchProcessInfoLog(IGPRR01DTO dto) throws BLException;
	
	/**
	 * ��������prid��ȡ���̹�����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO searchSerialNum(IGPRR01DTO dto) throws BLException;
}
