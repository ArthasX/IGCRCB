/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
/**
 * 
 */
package com.deliverik.infogovernor.asset.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM26DTO;

/**
 * @author Administrator
 *
 */
/**
 * ����: ��������Դ��ͳ��ҵ���߼��ӿ�
 * ������������������Դ��ͳ��ҵ���߼��ӿ�
 * �����ˣ�����
 * ������¼�� 2012-8-3
 * �޸ļ�¼��
 */
public interface IGASM26BL extends BaseBL {

	/**
	 * ��������Դ��ͳ�ƴ���
	 *
	 * @param dto IGASM22DTO
	 * @return IGASM22DTO
	 */
	public IGASM26DTO searchEntityItemRelationVW(IGASM26DTO dto) throws BLException;
}
