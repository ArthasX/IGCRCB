package com.dev.hac.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.dev.hac.dto.IGHAC01DTO;
/**
 * ���ݹ���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGHAC01BL extends BaseBL {
	
	/**
	 * <p>
	 * ��ѯ������Ϣ��
	 * </p>
	 * @throws BLException
	 * @author lvxin@deliverik.com
	 */
	public IGHAC01DTO searchCodeTreeAction(IGHAC01DTO dto) throws BLException;

}