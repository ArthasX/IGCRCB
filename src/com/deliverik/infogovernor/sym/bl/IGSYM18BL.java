/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM18DTO;

/**
 * ����: ���ݹ��� ��ҳ������
 * �������������ݹ��� ��ҳ������
 * ������¼����ѧ־    2012/11/14
 * �޸ļ�¼��
 */
public interface IGSYM18BL extends BaseBL {
	/**
	 * ���ܣ���ҳ�����ѯ���� ��ѯig622��Ϣ
	 * 
	 * @param dto IGSYM18DTO
	 * @return IGSYM18DTO
	 */
	public IGSYM18DTO searchFirstJspInfoAction(IGSYM18DTO dto) throws BLException;

	/**
	 * ��ҳ����Ǽ� ����ig622����
	 *
	 *��ѧ־
	 *2012-11-14����2:06:31
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM18DTO insertFirstJspInfoAction(IGSYM18DTO dto)throws BLException;
	/***
	 * ����������ѯ
	 *
	 *��ѧ־
	 *2012-11-14����3:41:53
	 * @param dto
	 * @return
	 */
	public IGSYM18DTO searchFirstJspInfoByPKAction(IGSYM18DTO dto)throws BLException;
	/**
	 * �޸���ҳ��Ϣ
	 *
	 *��ѧ־
	 *2012-11-14����3:55:42
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM18DTO editFirstJspInfoAction(IGSYM18DTO dto)throws BLException;
	/**
	 *  ��ҳ��Ϣɾ��
	 *
	 *��ѧ־
	 *2012-11-14����4:19:20
	 * @param dto
	 * @throws BLException
	 */
	public IGSYM18DTO deleteFirstJspInfoAction(IGSYM18DTO dto)throws BLException;
	
}
