package com.deliverik.infogovernor.soc.cim.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM05DTO;

/**
 * ����: ���÷���bl�ӿ�
 * ��������: ���÷���bl�ӿ�
 * ������¼: yanglongquan 2013/05/22
 * �޸ļ�¼: 
 */
public interface IGCIM05BL extends BaseBL {


	/**
	 * �豸��Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM05DTO searchEntityItemAction(IGCIM05DTO dto) throws BLException;
	
	
	/**
	 * �жϵ�½�û��Ƿ����豸�ʲ������ɫ������
	 * 
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @throws BLException 
	 */
	public IGCIM05DTO checkEntityItemDomain(IGCIM05DTO dto) throws BLException;
	
	
}
