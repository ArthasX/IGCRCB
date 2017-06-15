package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM09DTO;


/**
 * Ԥ������ҵ���߼��ӿ�
 *
 *
 */
public interface IGDRM09BL extends BaseBL {
	/**
	 * ���ݲ˵���ʶ��ȡ�˵�����
	 * 
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getActionName(IGDRM09DTO dto) throws BLException;
	
	/**
	 * ��ѯָ��������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM09DTO getProcessRecords(IGDRM09DTO dto) throws BLException;
	/**
	 * ��ѯ���̶���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM09DTO getProcessDef(IGDRM09DTO dto) throws BLException;

	/**
	 * @Description: Ӧ�����̵�����ѯҳ
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM07DTO    
	 * @throws
	 */
	public IGDRM09DTO searchProcess(IGDRM09DTO dto)throws BLException;
	
	/**
	 * ��ʼ����ϳ��������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM09DTO getGroupSenceInfo(IGDRM09DTO dto)throws BLException;
}
