/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sdl.dto.IGSDL03DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_��׼ҵ���߼��ӿ�
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public interface IGSDL03BL extends BaseBL {


	/**
	 * ��׼��ѯ����
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGSDL03DTO searchSdlDefineInfoAction(IGSDL03DTO dto) throws BLException;
	
	/**
	 * ��׼�ǼǴ���
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGSDL03DTO insertSdlDefineInfoAction(IGSDL03DTO dto) throws BLException;
	
	/**
	 * ��׼�༭���������ʾ����
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGSDL03DTO initSdlDefineInfoAction(IGSDL03DTO dto) throws BLException;

	/**
	 * ��׼���´���
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGSDL03DTO updateSdlDefineInfoAction(IGSDL03DTO dto) throws BLException;

	/**
	 * ��׼ɾ������
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGSDL03DTO deleteSdlDefineInfoAction(IGSDL03DTO dto) throws BLException;

}
	
