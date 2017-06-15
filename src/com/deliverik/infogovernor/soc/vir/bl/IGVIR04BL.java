/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR04DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������Դ��������BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGVIR04BL extends BaseBL{

	/**
	 * ��ȡVM��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR04DTO getApplyVMInfAction(IGVIR04DTO dto) throws BLException;

	/**
	 * ������������Ϣ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR04DTO saveRecycleVMInfoAction(IGVIR04DTO dto) throws BLException;

	/**
	 * ��ѯ������������Դ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR04DTO getRecycleVMInfAction(IGVIR04DTO dto) throws BLException;

	/**
	 * ȡ�û��ս���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR04DTO getProgressAction(IGVIR04DTO dto) throws BLException;

}
