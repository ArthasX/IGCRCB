package com.deliverik.infogovernor.drm.bl;

import org.dom4j.DocumentException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM02DTO;


/**
 * 组合场景定义逻辑接口
 *
 *
 */
public interface IGDRM02BL extends BaseBL {
	

	/**
	 * 查询场景信息
	 * @param IGDRM02DTO 
	 * @return
	 * @throws BLException
	 */
	public IGDRM02DTO searchSceneProcessInfo(IGDRM02DTO dto) throws BLException;
	/**
	 * 返回选择的场景jsonXml
	 * @param String 
	 * @return
	 * @throws BLException
	 */
	public String getSceneProcessXMLInfo(IGDRM02DTO dto) throws BLException;
	/**
	 * 保存组合场景流程信息
	 * @param String 
	 * @return
	 * @throws BLException
	 */
	public void saveSceneProcessAction(IGDRM02DTO dto) throws BLException, DocumentException;
	/**
	 * 查询该流程组下状态级表单XML
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getStateFormXML(IGDRM02DTO dto)throws BLException;
	/**
	 * 组合场景初始化jsonXml(修订+定义)
	 * @author ZYL
	 * @param String 
	 * @return
	 * @throws BLException
	 */
	public String getSceneInitXMLInfo(IGDRM02DTO dto) throws BLException;
}
