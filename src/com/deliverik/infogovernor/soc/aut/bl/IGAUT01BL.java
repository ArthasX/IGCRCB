/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.aut.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.aut.dto.IGAUT01DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_���˹���ҵ���߼��ӿ� 
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

public interface IGAUT01BL extends BaseBL {

	public IGAUT01DTO getProcessRecords(IGAUT01DTO dto) throws BLException;
	public IGAUT01DTO getProcessTemplate(IGAUT01DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ɾ�����̼�¼
	 * </p>
	 */
	public IGAUT01DTO delProcessRecord(IGAUT01DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: �жϵ�ǰ�û��Ƿ������������Ȩ��
	 * </p>
	 * 
	 * @param userid String
	 * @return boolean
	 * @throws BLException
	 * @update 
	 */
	public boolean isApproveRole(String userid) throws BLException ;

    /**
	 * ���̲�ѯ����
	 * @param dto 
	 * @return
	 * @throws BLException
	 */
	public IGAUT01DTO searchProcessRecordAction(IGAUT01DTO dto) throws BLException;
	
	/**
	 * ���̲�ѯJSPȡ��
	 * @param dto
	 * @return IGAUT01DTO
	 * @throws BLException
	 */
	public IGAUT01DTO searchForwardJsp(IGAUT01DTO dto) throws BLException;
	
	/**
	 * ���ݲ˵���ʶ��ȡ�˵�����
	 * 
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getActionName(IGAUT01DTO dto) throws BLException;
	
	
	/**
	 * ��ȡ���̱������ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGAUT01DTO getPivarQueryInfo0101Action(IGAUT01DTO dto) throws BLException;
	public IGAUT01DTO getPivarQueryInfo0102Action(IGAUT01DTO dto) throws BLException;
	public IGAUT01DTO getPivarQueryInfo0103Action(IGAUT01DTO dto) throws BLException;
	public IGAUT01DTO getPivarQueryInfo0104Action(IGAUT01DTO dto) throws BLException;
	
	/**
	 * ����PDID��ȡ���õ�����PDID
	 */
	public IGAUT01DTO searchPdid7BitAction(IGAUT01DTO dto) throws BLException;
}
