/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.aut.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.aut.dto.IGAUT02DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_���˹���ҵ���߼��ӿ� 
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

public interface IGAUT02BL extends BaseBL {

	public IGAUT02DTO checkEntityItemDomain(IGAUT02DTO dto) throws BLException;
	public IGAUT02DTO searchEntityItemAction(IGAUT02DTO dto) throws BLException;
	public IGAUT02DTO searchEntityItemFor0201Action(IGAUT02DTO dto) throws BLException;
	public IGAUT02DTO searchEntityItemFor0202Action(IGAUT02DTO dto) throws BLException;
	public IGAUT02DTO searchEntityItemFor0203Action(IGAUT02DTO dto) throws BLException;
	public IGAUT02DTO searchEntityItemFor0204Action(IGAUT02DTO dto) throws BLException;
	public IGAUT02DTO searchEntityItemFor0205Action(IGAUT02DTO dto) throws BLException;
}
