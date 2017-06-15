/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM11DTO;

/**
 * ǩ��BL 
 * 2015��3��13��10:21:51
 */

public interface IGDRM11BL extends BaseBL {
	 /**
     * @Description: ǩ����ʼ����ʾ
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM11DTO    
     * @throws
     */
	public IGDRM11DTO initIGDRM1101Action(IGDRM11DTO dto)throws BLException;
	/**
	 * @Description: ǩ�������
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM11DTO    
	 * @throws
	 */
	public IGDRM11DTO updateIGDRM1101Action(IGDRM11DTO dto)throws BLException;
	/**
	 * @Description: ��ǩ����ʼ����ʾ 
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM11DTO    
	 * @throws
	 */
	public IGDRM11DTO initIGDRM1102Action(IGDRM11DTO dto)throws BLException;
	/**
	 * @Description: ��ǩ������ 
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM11DTO    
	 * @throws
	 */
	public IGDRM11DTO updateIGDRM1102Action(IGDRM11DTO dto)throws BLException;
	/**
	 * @Description: ��ǩ��-��ǩ�����̳�ʼ����ʾ 
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM11DTO    
	 * @throws
	 */
	public IGDRM11DTO showSigninableProcess(IGDRM11DTO dto)throws BLException;
	/**
	 * @Description: ǩ��-�������� 
	 * @param dto
	 * @throws BLException    
	 * IGDRM11DTO    
	 * @throws
	 */
	public void pushSigninableMessage(IGDRM11DTO dto)throws BLException;
	/**
	 * @Description: ��ǩ��-�������� 
	 * @param dto
	 * @throws BLException    
	 * IGDRM11DTO    
	 * @throws
	 */
	public void pushSigninHelpMessage(IGDRM11DTO dto)throws BLException;

}
