/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.dto.IGSMR05DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������ҵ���߼�����ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGSMR05BL extends BaseBL{

	/**
	 * ��ѯ������Ϣ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR05DTO searchRegulatoryHistoryListAction(IGSMR05DTO dto) throws BLException;

	/**
	 * �˵����ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR05DTO searchReportDescAction(IGSMR05DTO dto) throws BLException;

}
