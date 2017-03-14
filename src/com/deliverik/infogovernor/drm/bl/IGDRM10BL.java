/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM10DTO;

/**
 * ��ɫ��֯�ܹ���ϵ��ϢBL
 */
public interface IGDRM10BL extends BaseBL {
	/**
	 * ��ɫ��֯�ܹ���ϵ��ʼ����ѯ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO initIGDRM1002Action(IGDRM10DTO dto) throws BLException;
	
	/**
	 * ��ɫ��֯�ܹ���ϵ�޸Ĳ�ѯ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO editIGDRM1002Action(IGDRM10DTO dto) throws BLException;
	
	/**
	 * ��ɫ��֯�ܹ���ϵ���»���뷽��
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO searchRole(IGDRM10DTO dto) throws BLException;

    /** 
     * @Title: deleteRoleRelation 
     * @param dto
     * @return    
     * IGDRM10DTO    
     * @throws 
     */
    public IGDRM10DTO deleteRoleRelation(IGDRM10DTO dto)throws BLException;
    /**
	 * ������Ϣɾ������
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO realdeleteCodeDetailDefAction(IGDRM10DTO dto) throws BLException ;
	/**
	 * ������Ϣɾ������
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO deleteCodeDetailDefAction(IGDRM10DTO dto) throws BLException;
    /**
	 * ������Ϣ��ϸ���������ʾ
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO initIGDRM1001Action(IGDRM10DTO dto) throws BLException;
	/**
	 * ������Ϣ��ϸ���淵����ʾ
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO initIGDRM1001BackAction(IGDRM10DTO dto) throws BLException ;
	/**
	 * ���ݷ�����Ϣ��ѯ����
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO initIGDRM1003Action(IGDRM10DTO dto) throws BLException;
	/**
	 * ���ݷ���ɾ������
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO deleteIGDRM1003Action(IGDRM10DTO dto) throws BLException;
	/**
	 * ���ݷ�����������
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO saveIGDRM1003Action(IGDRM10DTO dto) throws BLException;
	/**
	 * ������Ϣ�༭���������ʾ
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO initIGDRM1004Action(IGDRM10DTO dto) throws BLException;
	/**
	 * ������Ϣ�ǼǴ���
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO insertCodeDetailDefAction(IGDRM10DTO dto) throws BLException;
	/**
	 * ������Ϣ���´���
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO updateCodeDetailDefAction(IGDRM10DTO dto) throws BLException;
	/**
	 * ��ѯӦ����֯�ܹ��µ��ĸ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO searchCodeDetailDef(IGDRM10DTO dto) throws BLException;
	
	/**
     * ��ɫ��֯�ܹ���ϵ��ʼ����ѯ
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGDRM10DTO searchRoleAndUser(IGDRM10DTO dto) throws BLException;
    /**
	 * ���ݷ�����Ϣ��ѯ����
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO initIGDRM1007Action(IGDRM10DTO dto) throws BLException;

	/**
	 * ������֯�ܹ���
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO exportOrgTree(IGDRM10DTO dto) throws BLException;

	/**
	 * ��ʼ��������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO initWorkFlowAction(IGDRM10DTO dto) throws BLException;

	/**
	 * ���̴������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO doFlowAction(IGDRM10DTO dto) throws BLException;

	/**
	 * ���Ͷ���
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO sendSMS(IGDRM10DTO dto) throws BLException;

	/**
	 * ����֪ͨ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO sendNotice(IGDRM10DTO dto) throws BLException;

	/**
	 * ��ʼ������̨
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO initWorkbenchAction(IGDRM10DTO dto) throws BLException;
	
	/**
	 * ��ѯ����̨��־
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */

	public IGDRM10DTO searchLog(IGDRM10DTO dto) throws BLException;
	
	/**
	 * �����ϴ�
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO uploadAtt(IGDRM10DTO dto) throws BLException;

	/**
	 * ��ѯ�����е�Ԥ�ƻָ�ʱ��
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO searchSenceTimes(IGDRM10DTO dto) throws BLException;

	/**
	 * ��������״̬��ѯ����˵����ֵ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO searchDesc(IGDRM10DTO dto) throws BLException;

	/**
	 * ����״̬��(����˵��)
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO saveDesc(IGDRM10DTO dto) throws BLException;
}