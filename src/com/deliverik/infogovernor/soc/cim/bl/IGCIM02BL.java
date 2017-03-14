/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0112Info;
import com.deliverik.framework.soc.asset.model.SOC0120Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0112SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0120SearchCond;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM02DTO;
/**
 * ����: �ʲ�����ҵ���߼��ӿ�
 * ��������: �ʲ�����ҵ���߼��ӿ�
 * ������¼: 2011/04/25
 * �޸ļ�¼: 
 */
public interface IGCIM02BL extends BaseBL{

	/**
	 * �ʲ�������Ϣ�ǼǴ���
	 *
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 */
	public IGCIM02DTO insertEiDomainDefAction(IGCIM02DTO dto) throws BLException;

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0112Info> searchEiDomainDetailAction(SOC0112SearchCond cond) throws BLException;
	
		
	/**
	 * �������Ӧ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public List<SOC0124Info>searchAppForDomainDetail()throws BLException;
	
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0120Info> searchImportVersionAction(SOC0120SearchCond cond) throws BLException;
	
	
	/**
	 * ����������
	 * @param dto
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO searchImportVersionAction(IGCIM02DTO dto) throws BLException;
	
	/**
	 * �ɼ�����̨��ѯ����
	 * @param dto IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0214Action(IGCIM02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ɾ���û���ɫ
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGCIM02DTO revokeImportVesionAction(IGCIM02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ����û���ɫ
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGCIM02DTO InsertImportVesionAction(IGCIM02DTO dto)throws BLException;
	
	/**
	 * �ʲ�������Ϣ��ѯ����
	 *
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 */
	public IGCIM02DTO searchEiDomainDefAction(IGCIM02DTO dto) throws BLException;
	/**
	 * �ʲ���������ʼ��
	 * @param dto
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0202Action(IGCIM02DTO dto)throws BLException;

	/**
	 * �ʲ�����������
	 * @param dto
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO updateEiDomainDefAction(IGCIM02DTO dto) throws BLException;
	/**
	 * �ʲ�������ϸ��Ϣ��ʼ��
	 * @param dto
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0205Action(IGCIM02DTO dto) throws BLException;
	
	/**
	 * ����̨��ʾ����
	 *
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0201Action(IGCIM02DTO dto) throws BLException;
	
	/**
	 * ����̨��ʾ����[����ԭ����]
	 *
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0803Action(IGCIM02DTO dto) throws BLException;
	
	/**
	 * ��soc0115 ״̬ID ����CR03����CR����
	 *
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initCR03Action(IGCIM02DTO dto) throws BLException;
	
	/**
	 * ����̨���봦��
	 * 
	 * @param dtoIGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO importIGCIM0803Action(IGCIM02DTO dto) throws BLException;
	
	/**
	 * ����������ɾ������
	 * 
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO deleteEiWaitTaskAction0803(IGCIM02DTO dto) throws BLException;
	
	/**
	 * ����̨����鿴����
	 *
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0210Action(IGCIM02DTO dto) throws BLException;
	
	/**
	 * ����������ɾ������
	 * 
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO deleteEiWaitTaskAction(IGCIM02DTO dto) throws BLException;
	
	/**
	 * �ʲ�����ɾ������
	 * @param dto
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO deleteEiDomainDefAction(IGCIM02DTO dto) throws BLException;

	/**
	 * ���������Ϣ�ǼǴ���
	 * @param dto
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO insertImportVersionAction(IGCIM02DTO dto) throws BLException;
	
	/**
	 * ����̨���봦��
	 * 
	 * @param dtoIGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO importIGCIM0201Action(IGCIM02DTO dto) throws BLException;

	/**
	 * �������ɾ������
	 * @param dto
	 * @throws BLException
	 */
	public IGCIM02DTO deleteImportVersionAction(IGCIM02DTO dto) throws BLException;
	
	/**
	 * �������״̬����
	 * @param dto
	 * @throws BLException
	 */
	public void changeDeleteFlagAction(IGCIM02DTO dto) throws BLException ;

	/**
	 * �����������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO getEiImportProgrammeAction(IGCIM02DTO dto) throws BLException;
	/**
	 * �������汾����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO searchImportVersionIGCIM0210Action(IGCIM02DTO dto) throws BLException;
	
	/**
	 * �ʲ�����汾����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO searchIGCIM0212Action(IGCIM02DTO dto) throws BLException;
	
	/**
	 * ���ֶ���������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO handSnapshotAction(IGCIM02DTO dto) throws BLException;

	/**
	 * ���°汾����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO searchIGCIM0213Action(IGCIM02DTO dto)throws BLException;

	/**
	 * ��CI��ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO searchDoaminCiInfoAction(IGCIM02DTO dto) throws BLException;
	
	/**
	 * �ʲ�������Ϣ��ѯ����
	 * 
	 * @param dtoIGCIM02DTO
	 * @return IGCIM02DTO
	 */
	public IGCIM02DTO searchEiDomainDefActionNoPage(IGCIM02DTO dto) throws BLException;
	
	/**
	 * �ɼ���ѯ
	 * 
	 * @param dtoIGCIM02DTO
	 * @return IGCIM02DTO
	 */
	public IGCIM02DTO searchCr03Action(IGCIM02DTO dto) throws BLException;
	
	
}
