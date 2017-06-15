/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.iam.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.iam.dto.IGIAM03DTO;

/**
 * ����: ��Ʊ����߼�ҵ��ӿ�
 * ����������
 * �����ˣ���ӿ��
 * ������¼�� 2012-8-8
 * �޸ļ�¼��
 */
public interface IGIAM03BL extends BaseBL {
	/**
	 * ��ѯ��Ʊ�����Ϣ
	 * @param dto
	 * @return
	 */
	public IGIAM03DTO searchIAM03DTOAction(IGIAM03DTO dto) ;
	
	/**
	 * ��Ʊ�����ϸ��Ϣ�鿴
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIAM03DTO dsearchIAMAction(IGIAM03DTO dto) throws BLException ;
	
	/**
	 * ������Ʊ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIAM03DTO insertIAMAction(IGIAM03DTO dto) throws BLException ;
	
	/**
	 * ɾ����Ʊ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIAM03DTO deleteIAMAction(IGIAM03DTO dto) throws BLException ;
	
	/**
	 * ������Ʊ�����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIAM03DTO updateIAMAction(IGIAM03DTO dto) throws BLException ;
}	
