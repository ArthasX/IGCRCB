/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prr.dto.IGPRR10DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̵���BL�ӿ� 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGPRR10BL extends BaseBL{

	/**
	 * ���̶����ѯ������ʼ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR10DTO searchProcessDefinitionsAction(IGPRR10DTO dto) throws BLException;

	/**
	 * ��װ����ģ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR10DTO initProcessExportTemplateAction(IGPRR10DTO dto) throws BLException;

	/**
	 * ���̵������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR10DTO importProcessRecordsAction(IGPRR10DTO dto) throws BLException;

}
