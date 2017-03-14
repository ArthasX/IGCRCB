/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sdl.dto.IGSDL07DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_�¼�KPIͳ��ҵ���߼��ӿ�
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */
public interface IGSDL07BL extends BaseBL {


	/**
	 * �¼�KPIͳ�Ʋ�ѯ����
	 *
	 * @param dto IGSDL07DTO
	 * @return IGSDL07DTO
	 */
	public IGSDL07DTO searchIncidentKpiListAction(IGSDL07DTO dto) throws BLException;
	
	/**
	 * �¼�KPIͳ����Ϣ�¼����Map��ѯ����
	 *
	 * @param dto IGSDL07DTO
	 * @return IGSDL07DTO
	 */
	public IGSDL07DTO searchTypeMapAction(IGSDL07DTO dto) throws BLException;
	
	/**
	 * �¼�KPIͳ����Ϣ�����̶�Map��ѯ����
	 *
	 * @param dto IGSDL07DTO
	 * @return IGSDL07DTO
	 */
	public IGSDL07DTO searchUrgencyMapAction(IGSDL07DTO dto) throws BLException;
		
}
	
