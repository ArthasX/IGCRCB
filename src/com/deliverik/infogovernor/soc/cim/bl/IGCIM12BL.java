package com.deliverik.infogovernor.soc.cim.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM12DTO;

/**
 * �������ݹ���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGCIM12BL extends BaseBL {


	/**
	 * <p>
	 * ��ѯentity��
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	public IGCIM12DTO searchEntityTreeAction(IGCIM12DTO dto) throws BLException;
	
	
	/**
	 * �ʲ�������ʷ�汾��Ϣ��ʾ����
	 * @param dto
	 * @return
	 * @throws BLException
	 * @author wangxing
	 */
	public IGCIM12DTO initIGCIM1203Action(IGCIM12DTO dto) throws BLException;

	/**
	 * �ʲ����԰汾�Ƚϴ���
	 * @param dto
	 * @return
	 * @throws BLException
	 * @author wangxing
	 */
	public IGCIM12DTO initIGCIM1204Action(IGCIM12DTO dto)throws BLException;
	
}
