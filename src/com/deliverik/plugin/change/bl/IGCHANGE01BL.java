package com.deliverik.plugin.change.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.plugin.change.dto.IGCHANGE01DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������־����BL�ӿ�
 * </p>
 * 
 * @author dinghaonan@deliverik.com
 * @version 1.0
 */
public interface IGCHANGE01BL extends BaseBL{
	
	public IGCHANGE01DTO registIGCHANGEAction(IGCHANGE01DTO dto,String[] acceptMsg) throws BLException;
	
	public IGCHANGE01DTO saveInitiacteChangeAction(IGCHANGE01DTO dto) throws BLException;
	
	/**����prid ��ѯ�����־��¼*/
	public IGCHANGE01DTO searchInitiacteChangeAction(IGCHANGE01DTO dto) throws BLException;
}
