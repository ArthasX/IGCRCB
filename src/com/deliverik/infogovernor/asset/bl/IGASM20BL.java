/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.bl;

import java.util.List;

import com.deliverik.framework.asset.model.EiDomainDetailInfo;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDetailSearchCond;
import com.deliverik.framework.asset.model.condition.ImportVersionSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM20DTO;
/**
 * ����: �ʲ�����ҵ���߼��ӿ�
 * ��������: �ʲ�����ҵ���߼��ӿ�
 * ������¼: 2011/04/25
 * �޸ļ�¼: 
 */
public interface IGASM20BL extends BaseBL{

	/**
	 * �ʲ�������Ϣ�ǼǴ���
	 *
	 * @param dto IGASM20DTO
	 * @return IGASM20DTO
	 */
	public IGASM20DTO insertEiDomainDefAction(IGASM20DTO dto) throws BLException;

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<EiDomainDetailInfo> searchEiDomainDetailAction(EiDomainDetailSearchCond cond) throws BLException;
	
		
	/**
	 * �������Ӧ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public List<IG688Info>searchAppForDomainDetail()throws BLException;
	
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<ImportVersionInfo> searchImportVersionAction(ImportVersionSearchCond cond) throws BLException;
	
	
	/**
	 * ����������
	 * @param dto
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO searchImportVersionAction(IGASM20DTO dto) throws BLException;
	
	/**
	 * �ɼ�����̨��ѯ����
	 * @param dto IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO initIGASM2014Action(IGASM20DTO dto) throws BLException;
	
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
	
	public IGASM20DTO revokeImportVesionAction(IGASM20DTO dto) throws BLException;
	
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
	
	public IGASM20DTO InsertImportVesionAction(IGASM20DTO dto)throws BLException;
	
	/**
	 * �ʲ�������Ϣ��ѯ����
	 *
	 * @param dto IGASM20DTO
	 * @return IGASM20DTO
	 */
	public IGASM20DTO searchEiDomainDefAction(IGASM20DTO dto) throws BLException;
	/**
	 * �ʲ���������ʼ��
	 * @param dto
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO initIGASM2002Action(IGASM20DTO dto)throws BLException;

	/**
	 * �ʲ�����������
	 * @param dto
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO updateEiDomainDefAction(IGASM20DTO dto) throws BLException;
	/**
	 * �ʲ�������ϸ��Ϣ��ʼ��
	 * @param dto
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO initIGASM2005Action(IGASM20DTO dto) throws BLException;
	
	/**
	 * ����̨��ʾ����
	 *
	 * @param dto IGASM20DTO
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO initIGASM2001Action(IGASM20DTO dto) throws BLException;
	
	/**
	 * ����̨����鿴����
	 *
	 * @param dto IGASM20DTO
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO initIGASM2010Action(IGASM20DTO dto) throws BLException;
	
	/**
	 * ����������ɾ������
	 * 
	 * @param dto IGASM20DTO
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO deleteEiWaitTaskAction(IGASM20DTO dto) throws BLException;
	
	/**
	 * �ʲ�����ɾ������
	 * @param dto
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO deleteEiDomainDefAction(IGASM20DTO dto) throws BLException;

	/**
	 * ���������Ϣ�ǼǴ���
	 * @param dto
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO insertImportVersionAction(IGASM20DTO dto) throws BLException;
	
	/**
	 * ����̨���봦��
	 * 
	 * @param dtoIGASM20DTO
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO importIGASM2001Action(IGASM20DTO dto) throws BLException;

	/**
	 * �������ɾ������
	 * @param dto
	 * @throws BLException
	 */
	public IGASM20DTO deleteImportVersionAction(IGASM20DTO dto) throws BLException;
	
	/**
	 * �������״̬����
	 * @param dto
	 * @throws BLException
	 */
	public void changeDeleteFlagAction(IGASM20DTO dto) throws BLException ;

	/**
	 * �����������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO getEiImportProgrammeAction(IGASM20DTO dto) throws BLException;
	/**
	 * �������汾����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO searchImportVersionIGASM2010Action(IGASM20DTO dto) throws BLException;
	
	/**
	 * �ʲ�����汾����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO searchIGASM2012Action(IGASM20DTO dto) throws BLException;
	
	/**
	 * ���ֶ���������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO handSnapshotAction(IGASM20DTO dto) throws BLException;

	/**
	 * ���°汾����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO searchIGASM2013Action(IGASM20DTO dto)throws BLException;

	/**
	 * ��CI��ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO searchDoaminCiInfoAction(IGASM20DTO dto) throws BLException;
}
