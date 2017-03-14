/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR13DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����Դ����BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGVIR13BL extends BaseBL{

	/**
	 * ��ѯvCenter��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR13DTO searchVCenterAction(IGVIR13DTO dto) throws BLException;

	/**
	 * ��ȡ��������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR13DTO getHostsAction(IGVIR13DTO dto) throws BLException;

	/**
	 * vm��Ϣ��ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR13DTO searchVMInfoAction(IGVIR13DTO dto) throws BLException;

	/**
	 * ��ʼ�������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR13DTO initVmInfoAction(IGVIR13DTO dto) throws BLException;

	/**
	 * �����Ϣ�༭
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR13DTO editVmInfoAction(IGVIR13DTO dto) throws BLException;
}
