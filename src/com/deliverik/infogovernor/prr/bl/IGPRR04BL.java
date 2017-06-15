/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prr.dto.IGPRR04DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̷���Ŀ¼BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGPRR04BL extends BaseBL{

	/**
	 * ��ʼ������Ŀ¼��ʾҳ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR04DTO initServiceCatelogAction(IGPRR04DTO dto) throws BLException;

	/**
	 * һ���˵��µķ���Ŀ¼��ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR04DTO searchFirstActionServiceCatalog(IGPRR04DTO dto) throws BLException;

}
