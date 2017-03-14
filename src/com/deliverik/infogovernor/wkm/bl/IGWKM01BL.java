/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.wkm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.wkm.dto.IGWKM01DTO;

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

public interface IGWKM01BL extends BaseBL {

	public IGWKM01DTO getProcessRecords(IGWKM01DTO dto) throws BLException;
	public IGWKM01DTO getProcessTemplate(IGWKM01DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ɾ�����̼�¼
	 * </p>
	 */
	public IGWKM01DTO delProcessRecord(IGWKM01DTO dto) throws BLException;
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
	public IGWKM01DTO searchProcessRecordAction(IGWKM01DTO dto) throws BLException;
	
	/**
	 * ���̲�ѯJSPȡ��
	 * @param dto
	 * @return IGWKM01DTO
	 * @throws BLException
	 */
	public IGWKM01DTO searchForwardJsp(IGWKM01DTO dto) throws BLException;
	
	/**
	 * ���ݲ˵���ʶ��ȡ�˵�����
	 * 
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getActionName(IGWKM01DTO dto) throws BLException;
	
	
	/**
	 * ��ȡ���̱������ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWKM01DTO getPivarQueryInfoAction(IGWKM01DTO dto) throws BLException;
	
	/**
	 * ����PDID��ȡ���õ�����PDID
	 */
	public IGWKM01DTO searchPdid7BitAction(IGWKM01DTO dto) throws BLException;
	
	/**
	 * ����Excel
	 */
	public IGWKM01DTO getExcel(IGWKM01DTO dto) throws BLException;
	
}
