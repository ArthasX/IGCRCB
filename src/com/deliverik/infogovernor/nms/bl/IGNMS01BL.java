/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.bl.task.NMSBaseBL;
import com.deliverik.infogovernor.nms.dto.IGNMS01DTO;

/**
 * ����: �Զ�����BL�ӿ�
 * ��������: �Զ�����BL�ӿ�
 * ������¼: 2013/12/20
 * �޸ļ�¼: 
 */
public interface IGNMS01BL extends NMSBaseBL{
	
	/**
	 * ��ȡ��汾
	 * ��Ҫ��������� groupID�����룩
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO searchGroupVersionAction(IGNMS01DTO dto) throws BLException;

    /**
     * <p>
     * ��ѯ����xml
     * </p>
     * ��Ҫ���������� userid�����룩 groupID����ѡ�� topoType����ѡ��Ĭ��Ϊȫ���� groupVersion ����ѡ��Ϊ��ʱ��ѯ���°棩
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGNMS01DTO searchTopoXML(IGNMS01DTO dto) throws BLException;
    
    /**
     *  ����������ʾ��xml
     *  
     * @param dto
     * @return
     * @throws BLException 
     */
    public IGNMS01DTO saveTopoXML(IGNMS01DTO dto) throws BLException;
    
    /**
     * <p>
     * ������������
     * </p>
     * 
     * ��Ҫ���������� userid�����룩 groupID����ѡ�� topoType����ѡ��Ĭ��Ϊȫ����
     * 
     * @param dto
     * @return
     * @throws BLException 
     */
    public IGNMS01DTO saveTopoInfo(IGNMS01DTO dto) throws BLException;
    
    /**
     * ��ȡ����С
     * 
     * @param dto
     * @return
     */
    public IGNMS01DTO getPanelSize(IGNMS01DTO dto) throws BLException;
    
    /**
     * ��������С
     * 
     * @param dto
     * @return
     * @throws BLException 
     */
    public IGNMS01DTO updatePanelSize(IGNMS01DTO dto) throws BLException;
    
	/**
	 * �鿴SNMP������Ϣ
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO initNMS02Action(IGNMS01DTO dto) throws BLException;
	
	/**
	 * �Ǽ�SNMP������Ϣ
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO insertNMS02Action(IGNMS01DTO dto) throws BLException ;
	
	/**
	 * ɾ��SNMP������Ϣ
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO deleteNMS02Action(IGNMS01DTO dto) throws BLException ;

	/**
	 * �鿴����������Ϣ
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO initNMS03Action(IGNMS01DTO dto) throws BLException;
	
	/**
	 * �Ǽ�����������Ϣ
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO insertNMS03Action(IGNMS01DTO dto) throws BLException ;
	
	/**
	 * ɾ������������Ϣ
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO deleteNMS03Action(IGNMS01DTO dto) throws BLException ;
	
	/**
	 * ����ɨ�����
	 * ��Ҫ���������� groupID�����룩
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO execCommandAction(IGNMS01DTO dto) throws BLException;
	 /**
	 * ȡ�������豸ͼƬ·��
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO getImgUrl(IGNMS01DTO dto) throws BLException;
	/**
	 * ȡ�������豸����
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO getDevType(IGNMS01DTO dto) throws BLException;
}
