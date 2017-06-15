/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sdl.dto.IGSDL04DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_��Ϣҵ���߼��ӿ�
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public interface IGSDL04BL extends BaseBL {


	/**
	 * ��Ϣ��ѯ����
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO searchSdlInfoAction(IGSDL04DTO dto) throws BLException;
	
	/**
	 * ��Ϣ����
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO insertSdlInfoAction(IGSDL04DTO dto) throws BLException;
	
	/**
	 * ��Ϣ�༭���������ʾ����
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO initSdlInfoAction(IGSDL04DTO dto) throws BLException;

	/**
	 * ��Ϣ���´���
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO updateSdlInfoAction(IGSDL04DTO dto) throws BLException;

	/**
	 * ��Ϣɾ������
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO deleteSdlInfoAction(IGSDL04DTO dto) throws BLException;
	
	/**
	 * ��Ϣ��ϸ��Ϣ����
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO searchSdlInfoDetailAction(IGSDL04DTO dto) throws BLException;

}
	
