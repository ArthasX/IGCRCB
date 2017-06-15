/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG500ONLYInfo;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCond;

/**
 * <p>概述:流程记录DAO接口</p>
 * <p>功能描述：1.全件检索</p>
 * <p>          2.条件检索结果件数取得</p>
 * <p>          3.主键检索处理</p>
 * <p>          4.条件检索处理</p>
 * <p>          5.根据流程类型查询当前最大流水号</p>
 * <p>          6.服务请求条件检索处理</p>
 * <p>          7.服务请求条件检索记录数</p>
 * <p>          8.流程(包含事件处理子状态）条件检索处理</p>
 * <p>          9.流程(包含事件处理子状态）条件检索记录数</p>
 * <p>          10.指定用户相关处理流程条件检索处理</p>
 * <p>          11.指定角色未处理流程条件检索处理</p>
 * <p>          12.自定义流程条件检索记录数</p>
 * <p>          13.自定义流程条件检索处理</p>
 * <p>          14.自定义流程相关工作条件检索记录数</p>
 * <p>          15.自定义流程条件检索处理</p>
 * <p>创建记录：</p>
 */
public interface IG500DAO extends BaseHibernateDAO<IG500Info> {

	/**
	 * 功能：全件检索
	 * @return 检索结果集
	 */
	public List<IG500Info> findAll();
	
	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG500SearchCond cond);

	/**
	 * 功能：主键检索处理
	 * @param prid 主键
	 * @return 检索结果
	 */
	public IG500Info findByPK(Serializable prid);

	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> findByCond(final IG500SearchCond cond, final int start, final int count);
	
	/**
	 * 功能：根据流程类型查询当前最大流水号
	 * @param prserialnum 流水号
	 * @return 最大流水号
	 */
	
	public String getMaxPrserialnum(String prserialnum);
	
	/**
	 * 功能：服务请求条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryServiceRequestList(final IG500SearchCond cond, final int start, final int count);
	
	/**
	 * 功能：服务请求条件检索记录数
	 * @return 条件检索记录数
	 */
	public int queryServiceRequestListCount(final IG500SearchCond cond);
	
	/**
	 * 功能：流程(包含事件处理子状态）条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryIG500InfoSubStatusList(final IG500SearchCond cond, final int start, final int count);

	/**
	 * 功能：流程(包含事件处理子状态）条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500ONLYInfo> queryIG500ONLYInfoSubStatusList(final IG500SearchCond cond, final int start, final int count);
	
	/**
	 * 功能：流程(包含事件处理子状态）条件检索记录数
	 * @return 流程(包含事件处理子状态）条件检索记录数
	 */
	public int queryIG500InfoSubStatusListCount(final IG500SearchCond cond);

	/**
	 * 功能：流程(包含事件处理子状态）条件检索记录数
	 * @return 流程(包含事件处理子状态）条件检索记录数
	 */
	public int queryIG500ONLYInfoSubStatusListCount(final IG500SearchCond cond);
	
	/**
	 * 指定用户未处理流程条件检索处理
	 * @param userid 用户ID
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryActiveProcessByUserid(final String userid);

	/**
	 * 功能：指定用户相关处理流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @param closeFlag 查询关闭标志。0：已处理，1：未处理，其他：所有
	 * @param dealFlag  查询处理标志。0：已关闭，1：未关闭，其他：所有
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryCorrelationProcessByUserid(final IG677SearchCond cond, 
			final int start, final int count, final int closeFlag, final int dealFlag);
	
	/**
	 * 功能：指定用户相关处理流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @param closeFlag 查询关闭标志。0：已处理，1：未处理，其他：所有
	 * @param dealFlag  查询处理标志。0：已关闭，1：未关闭，其他：所有
	 * @return 检索结果数量
	 */
	public int queryCorrelationProcessByUseridCount(final IG677SearchCond cond, 
			final int start, final int count, final int closeFlag, final int dealFlag);
	
	/**
	 * 功能：指定角色未处理流程条件检索处理
	 * @param roleid 角色ID
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryActiveProcessByRoleid(final Integer roleid);
	
	/**
	 * 检测指定用户是否具有指定流程查看权限（目前只支持变更，发布）
	 * @param userid 用户ID
	 * @param prid 流程ID
	 * @return 权限标识
	 */
	public boolean checkLookDetailPermission(String userid, Integer prid);

	/**
	 * 当流程指定到角色时,在角色负责人的我的工作中显示此条流程信息
	 * @param userid 用户ID
	 * @return 
	 */
	public List<IG677Info> queryActiveProcessByFPRoleid(String userid);
	
	/**
	 * 流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryIG500EntityList(final IG500SearchCond cond, final int start, final int count);

	/**
	 * 功能：自定义流程条件检索记录数
	 * @return 自定义流程条件检索记录数
	 */
	public int searchIG500CountForSelfDef(final IG500SearchCond cond);
	
	/**
	 * 功能：自定义流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> searchIG500InfoForSelfDef(final IG500SearchCond cond, final int start, final int count);

	
	/**
	 * 功能：自定义流程相关工作条件检索记录数
	 * @return 自定义流程条件检索记录数
	 */
	public int searchIG500InfoCountForRelatedWork(final IG500SearchCond cond);
	
	/**
	 * 功能：自定义流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> searchIG500InfoForRelatedWork(final IG500SearchCond cond, final int start, final int count);
	
	/**
	 * 功能：发文流程统计条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> searchDispatchStatisticsVW(final IG677SearchCond cond, final int start, final int count);
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	public int findDispatchStatisticsSearchCount(final IG677SearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryIG500EntityListByProcessInfo(final IG500SearchCond cond, final int start, final int count);
	
	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int queryIG500EntityCount(final IG500SearchCond cond);
	
	/**
	 * 查询指定监管报表key关联的流程
	 * @param type 报表类型
	 * @param pdid 报表定义ID
	 * @param key 报表实例key
	 * @param isClose true：查询已关闭，false：查询未关闭，null：查询全部，不包括中止
	 * @return 关联流程
	 */
	public List<Integer> searchRegulatoryReportDetailByKey(final String type, final String pdid,
			final String key, final Boolean isClose) throws BLException;
	
	/**
	 * 查询我的工单条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> searchMyProcess(final IG500SearchCond cond, final int start, final int count); 
	
	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int searchMyProcessCount(final IG500SearchCond cond);
	
	/**
	 * 查询同机构工单条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> searchMyProcessByOrg(final IG500SearchCond cond, final int start, final int count); 
	
	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int searchMyProcessByOrgCount(final IG500SearchCond cond);
	
	/**
	 * 查询同角色工单条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	
	public List<IG500Info> searchMyProcessByRole(final IG500SearchCond cond, final int start, final int count); 
	
	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int searchMyProcessByRoleCount(final IG500SearchCond cond);
	
	/**
	 * 获取流程当前状态显示名称
	 * @param prid 流程ID
	 * @return 流程当前状态显示名称
	 */
	public String searchCurrentStatusName(final Integer prid) throws BLException;
	
	/**
	 * 获取流程当前状态
	 * @param prid 流程ID
	 * @return 流程当前状态
	 */
	public List<String> searchCurrentStatus(final Integer prid) throws BLException;
	
	/**
	 * dashboard
	 *	获取 指定流程的 月统计数据 
	 * @param months 月份(yyyy/MM),(yyyy/MM )....
	 * @param prpdid 流程定义的前五位
	 * @return List<Map>
	 * <p>
	 * 	map 结构 DATEMONTH,PRPDID,PRPDNAME,ACOUNT,CLOSECOUNT
	 * </p>
	 */
	public List<Map> getRiskAssess (String months,String prpdid);

	/**
	 * 获取我处理过的工作列表
	 * @param cond IG500SearchCond
	 * @param start int
	 * @param count int
	 * @return List<IG500Info>
	 */
	public List<IG500Info> searchMyProcessed(final IG500SearchCond cond, final int start, final int count);

    /** 
     * @Title: queryIG500WithStatusAndPart 
     * @Description: TODO 查询ig500 和流程状态，当前流程状态的参与者
     * @param prSearchCond
     * @param i
     * @param j
     * @return    
     * List<IG500Info>    
     * @throws 
     */
    public List<Map<String, Object>> queryIG500WithStatusAndPart(final IG500SearchCond prSearchCond,final int i,final int j);
    /**
     * 查询应急处置流程
     * @param cond
     * @param start
     * @param count
     * @return
     */
    public List<IG500Info> getDrmFlow(final IG500SearchCond cond,final int start,final int count);
    
    /**
     * 查询应急处置流程数量
     * @param cond
     * @param start
     * @param count
     * @return
     */
    public Integer countDrmFlow(final IG500SearchCond cond);
    
    /**
	 * 查询我未处理过的工单条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> searchMyUnProcessd(final IG500SearchCond cond,final int start,
			final int count);
	
	/**
	 * 演练流程查询
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<IG500Info> searchDrillProcess(IG500SearchCond cond,final int start, final int count);
}
