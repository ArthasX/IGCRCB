package com.deliverik.infogovernor.soc.mnt.bl;


import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT03DTO;

/**
 * �ʲ����ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGMNT03BL extends BaseBL {
	/**
	 * �豸������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGMNT03DTO
	 * @return IGMNT03DTO
	 */
	public IGMNT03DTO initIGMNT0204Action(IGMNT03DTO dto) throws BLException;
}
