/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR30DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���⻯Vcloud����BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGVIR30BL extends BaseBL{

	/**
	 * ��ʼ��������Ϣ
	 * @param dto
	 * @return
	 */
	public IGVIR30DTO initBasicInfoAction(IGVIR30DTO dto) throws BLException;

	/**
	 * ��ѯģ�����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR30DTO searchTemplateAction(IGVIR30DTO dto) throws BLException;

	/**
	 * ����ģ����Ϣ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR30DTO saveApplyVMInfoAction(IGVIR30DTO dto) throws BLException;

	/**
	 * ȡ��vm��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR30DTO getApplyVMInfAction(IGVIR30DTO dto) throws BLException;

	/**
	 * ��ѯ�����е�VM��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR30DTO getApplyVMListAction(IGVIR30DTO dto) throws BLException;

	/**
	 * �Զ������������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR30DTO getApplyVMDataListAction(IGVIR30DTO dto) throws BLException;

	/**
	 * ��ѯ������־����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR30DTO searchDeployLogAction(IGVIR30DTO dto) throws BLException;

}
