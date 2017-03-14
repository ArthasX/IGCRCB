/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sym.model.CustomReport;
import com.deliverik.infogovernor.sym.model.condition.CustomReportSearchCond;
import com.deliverik.infogovernor.sym.model.dao.CustomReportDAO;

/**
 * 
 * @Description:订制报表实体BL实现类
 * @Author
 * @History
 * @Version V1.0
 */
public class CustomReportBLImpl extends BaseBLImpl implements CustomReportBL {
	
	protected CustomReportDAO customReportDAO;
	

	public void setCustomReportDAO(CustomReportDAO customReportDAO) {
		this.customReportDAO = customReportDAO;
	}

	/**
     * 持久化处理
     * @param hacProcess 实体
     */
	public CustomReport saveProject(CustomReport hacProcess) throws BLException{
		return customReportDAO.save(hacProcess);
	}
	
	/**
     * 主键检索处理
     * @param id 主键
     * @return 检索结果
     */
	public CustomReport findByPK(Integer hpid) throws BLException{
		return customReportDAO.findByPK(hpid);
	}
	
	/**
     * 全件检索
     * @return 检索结果集
     */
	public List<CustomReport> findAllProject() throws BLException{
		return customReportDAO.findAll();
	}
	
	/**
     * 条件检索结果件数取得
     * @param cond 检索条件
     * @return 检索结果件数
     */
	public int getSearchCount(CustomReportSearchCond cond) throws BLException{
		return customReportDAO.getSearchCount(cond);
	}
	
	/**
     * 条件检索处理
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
	public List<CustomReport> findByCond(CustomReportSearchCond cond, int start, int count) throws BLException{
		return customReportDAO.findByCond(cond, start, count);
	}
	
	/**
     * 删除处理
     * @param crid 主键
     */
	public void deleteProject(Integer crid) throws BLException{
		CustomReport customReport = findByPK(crid);
		customReportDAO.delete(customReport);
	}

}
