package com.deliverik.infogovernor.cic.bl;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.cic.dto.IGCIC01DTO;


/**
 * 比对规则相关业务逻辑接口
 *
 *
 */
public interface IGCIC01BL extends BaseBL {


	public IGCIC01DTO searchCompareRoleList(IGCIC01DTO dto) throws BLException;
	
	public IGCIC01DTO getSystemList(IGCIC01DTO dto)throws BLException;

	/**
	 * 根据业务系统和对比类型查询主机
	 * @param systemId
	 * @param crtype
	 * @return
	 */
	public List<Map<String,String>> searchHostList(Integer systemId,String crtype)throws BLException;
	
	public IGCIC01DTO insertIgcic0102Action(IGCIC01DTO dto)throws BLException;
	
	/**
	 * 查看时 加载对比规则详细信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIC01DTO loadCompareRoleInfo(IGCIC01DTO dto)throws BLException;
	
	/**
	 * 检查对比规则是否存在,如果不存在返回null 否则查询出该规则的信息
	 * @param systemId
	 * @param crtype
	 * @return
	 * @throws BLException
	 */
	public Map<String,Object> checkCompareRole(Integer systemId,String crtype)throws BLException;
	
	public IGCIC01DTO delCompareRole(IGCIC01DTO dto)throws BLException;
}
