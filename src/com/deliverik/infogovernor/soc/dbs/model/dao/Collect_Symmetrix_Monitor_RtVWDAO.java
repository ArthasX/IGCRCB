/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
 package com.deliverik.infogovernor.soc.dbs.model.dao;

 import java.util.Date;
import java.util.List;
 import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Monitor_RtVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_Monitor_RtVWSearchCond;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_Symmetrix_Monitor_RtVWDAO;


/**
 * 
 * @Description:存储实时信息视图DAO接口
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_Symmetrix_Monitor_RtVWDAO extends BaseHibernateDAO<Collect_Symmetrix_Monitor_RtVWInfo> {
   
    /**
     * 条件检索处理
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public List<Collect_Symmetrix_Monitor_RtVWInfo> findByCond(final Collect_Symmetrix_Monitor_RtVWSearchCond cond);
    
    /**
	 * 获取最大时间
	 * @return
	 */
	public Date getMaxSaveTime(final Collect_Symmetrix_Monitor_RtVWSearchCond cond);
}

