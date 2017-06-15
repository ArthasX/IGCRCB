package com.deliverik.infogovernor.svc.bl;


import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.infogovernor.svc.dto.IGSVC06DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0601Form;

/**
 * <p>
 * 统计分析图形显示接口
 * </p>
 * @author duchong@deliverik.com
 * @version 1.0
 */
public interface IGSVC06BL extends BaseBL {
	

	/**
	 * Description: 根据条件取得统计数据
	 */
	public String findByCond(IGSVC06DTO dto) throws BLException;
	
	/**
	 * Description: 取得返回给前台页面的XML字符串
	 */
	public String getXmlByCondition(IGSVC0601Form form) throws BLException;
	

	public List<IG259Info> getAllActiveTemplate() throws BLException;

	/**
	 * 故障类型统计数据查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchIncidentTypeAction(IGSVC06DTO dto) throws BLException;

	/**
	 * 部门服务统计查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchOrganizationServiceAction(IGSVC06DTO dto) throws BLException;

	/**
	 * 部门服务top5统计数据查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchServiceTopFiveDateAction(IGSVC06DTO dto) throws BLException;

	/**
	 * 时间平均解决时间统计数据查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchIncidentAveSolveTimeAction(IGSVC06DTO dto) throws BLException;
	
	/**
	 * 查询人员工作量统计数据
	 * @param cond 检索条件
	 * @return
	 */
	public IGSVC06DTO searchSummary(IGSVC06DTO dto)throws BLException;
	
	/**
	 * 年度工作趋势统计数据查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchAnnualTrendVWAction(IGSVC06DTO dto) throws BLException;

	/**
	 * 流程数量统计数据查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchProcessRecordCountAction(IGSVC06DTO dto) throws BLException;
	
}
