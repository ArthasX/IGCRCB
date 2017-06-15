/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sdl.dto.IGSDL05DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_ͳ��ҵ���߼��ӿ�
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public interface IGSDL05BL extends BaseBL {


	/**
	 * ͳ�Ʋ�ѯ����
	 *
	 * @param dto IGSDL05DTO
	 * @return IGSDL05DTO
	 */
	public IGSDL05DTO searchSdlSummaryAction(IGSDL05DTO dto) throws BLException;
	
	/**
	 * ��Ϣ��ѯ����
	 *
	 * @param dto IGSDL05DTO
	 * @return IGSDL05DTO
	 */
	public IGSDL05DTO searchSdlInfoAction(IGSDL05DTO dto) throws BLException;
	
	/**
	 * ��Ϣ��ϸ��Ϣ����
	 *
	 * @param dto IGSDL05DTO
	 * @return IGSDL05DTO
	 */
	public IGSDL05DTO searchSdlInfoDetailAction(IGSDL05DTO dto) throws BLException;

/**
	 * ͳ�Ʋ�ѯ����
	 *
	 * @param dto IGSDL05DTO
	 * @return IGSDL05DTO
	 */
	public IGSDL05DTO searchSdlYearSummaryAction(IGSDL05DTO dto) throws BLException;
}
	
