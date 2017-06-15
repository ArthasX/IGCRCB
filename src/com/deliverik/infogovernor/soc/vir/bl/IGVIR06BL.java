package com.deliverik.infogovernor.soc.vir.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR06DTO;

/**
 * �豸���ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGVIR06BL extends BaseBL {

	/**
	 * �������ˣ����⻯�����ϵ��
	 * @param dto
	 * @return
	 */
	public IGVIR06DTO getVMWareTree(IGVIR06DTO dto) throws BLException;
	/**
	 * ���⻯������Ϣ�༭������ڻ�����
	 *
	 * @param dto 
	 * @return 
	 */
	public IGVIR06DTO initIGVIR0602Action(IGVIR06DTO dto) throws BLException;
	
	/**
	 * Ӧ��������Ϣ�༭����
	 *
	 * @param dto 
	 * @return 
	 */
	public IGVIR06DTO editEntityItemActionApp(IGVIR06DTO dto) throws BLException,
	FileNotFoundException, IOException;
	
	/**
	 * �жϵ�½�û��Ƿ����豸�ʲ������ɫ������
	 * 
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @throws BLException 
	 */
	public IGVIR06DTO checkEntityItemDomain(IGVIR06DTO dto) throws BLException;
	
	/**
	 * 0604�豸��Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGVIR06DTO searchEntityItem0604Action(IGVIR06DTO dto) throws BLException;
	
	/**
	 * 0606�豸��Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGVIR06DTO searchEntityItem0606Action(IGVIR06DTO dto) throws BLException;
	
	/**
	 * 0605�豸��Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGVIR06DTO searchEntityItem0605Action(IGVIR06DTO dto) throws BLException;

}
