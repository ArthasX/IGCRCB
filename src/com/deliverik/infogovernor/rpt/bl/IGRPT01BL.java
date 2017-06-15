/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.rpt.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.dto.IGRPT01DTO;

/**
 * 统计分析业务逻辑接口
 *
 */
public interface IGRPT01BL extends BaseBL {
	
	
	
	/**
	 * 报表分类树查询处理
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO searchReportTypeTreeAction(IGRPT01DTO dto) throws BLException;
	
	/**
	 * 报表信息查询处理
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO searchReportFileDefinitionAction(IGRPT01DTO dto) throws BLException;
	
	/**
	 * 报表授权过滤树查询
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO filterReportTypeTreeAction(IGRPT01DTO dto) throws BLException;
	
	/**
	 * 订制报表信息查询处理
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO searchReportByCustom(IGRPT01DTO dto) throws BLException;
	
	/**
	 * 订制报表持久化处理
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO insertCustomReport(IGRPT01DTO dto) throws BLException;
	
	/**
	 * 取消订制报表处理
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO deleteCustomReport(IGRPT01DTO dto) throws BLException;
	
	/**
	 * 订制报表排序处理
	 * 
	 * @param dto
	 *            IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO orderCustomReport(IGRPT01DTO dto) throws BLException;
	
	public List<Integer> getPiller() throws BLException;
	
	public void setCalendar(int year,int month)  throws BLException;
	
	public String getMap(String mapname)throws BLException;
	
	public int getStudy()throws BLException;
}
