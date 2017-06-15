package com.deliverik.infogovernor.drm.bl;

import org.dom4j.DocumentException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM02DTO;


/**
 * ��ϳ��������߼��ӿ�
 *
 *
 */
public interface IGDRM02BL extends BaseBL {
	

	/**
	 * ��ѯ������Ϣ
	 * @param IGDRM02DTO 
	 * @return
	 * @throws BLException
	 */
	public IGDRM02DTO searchSceneProcessInfo(IGDRM02DTO dto) throws BLException;
	/**
	 * ����ѡ��ĳ���jsonXml
	 * @param String 
	 * @return
	 * @throws BLException
	 */
	public String getSceneProcessXMLInfo(IGDRM02DTO dto) throws BLException;
	/**
	 * ������ϳ���������Ϣ
	 * @param String 
	 * @return
	 * @throws BLException
	 */
	public void saveSceneProcessAction(IGDRM02DTO dto) throws BLException, DocumentException;
	/**
	 * ��ѯ����������״̬����XML
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getStateFormXML(IGDRM02DTO dto)throws BLException;
	/**
	 * ��ϳ�����ʼ��jsonXml(�޶�+����)
	 * @author ZYL
	 * @param String 
	 * @return
	 * @throws BLException
	 */
	public String getSceneInitXMLInfo(IGDRM02DTO dto) throws BLException;
}
