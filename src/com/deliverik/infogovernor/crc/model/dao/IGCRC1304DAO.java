package com.deliverik.infogovernor.crc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1304Cond;
/**
 * 概述: 比对结果DAO接口
 * 功能描述: 比对结果DAO接口
 * 创建记录: 史凯龙 2014/07/22
 * 修改记录: 
 */
public interface IGCRC1304DAO extends BaseHibernateDAO<IGCRC1303VWInfo>{
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IGCRC1304Cond cond);
	
	/**
     * 根据对象比对结果
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
    public List<IGCRC1303VWInfo> searchIGCRC1304VWInfo(final IGCRC1304Cond cond, final int start,
			final int count);
    /**
     * 查询借阅文档
     * @return
     */
    public List<String> searchType();
    
    /**
	 * 查询被下载的文档的部门
	 * @return
	 */
    public List<String> searchDownDepart();
    
    /**
     * 查询借阅文档的流程ID
     * @return
     */
    public List<Integer> searchTypeID(IGCRC1304Cond cond);
}
