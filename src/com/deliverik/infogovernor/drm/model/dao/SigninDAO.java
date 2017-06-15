/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.SigninInfo;
import com.deliverik.infogovernor.drm.model.condition.SigninSearchCond;

/**
  * 概述: 签到表DAO接口
  * 功能描述: 签到表DAO接口
  * 创建记录: 2015/03/12
  * 修改记录: 
  */
public interface SigninDAO extends BaseHibernateDAO<SigninInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SigninInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SigninInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SigninSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SigninInfo> findByCond(
			final SigninSearchCond cond, final int start,
			final int count);
	/**
	 * 查询签到信息
	 */
		public List<Map<String,Object>> searchSignInList(String userid,Integer prid,boolean isDrill) ;
		
		/**
		 * 更新签到表中应急指挥流程prid
		 * @param drillPrid 演练流程id
		 * @param directPrid 应急指挥流程prid
		 * @return
		 */
		public int setDirectPrid(Integer drillPrid,Integer directPrid);
		/**
		 * 更新签到表中场景流程prid
		 * @param directPrid 指挥流程prid
		 * @param scenePrid 场景流程prid
		 * @return
		 */
		public int setScenePrid(Integer directPrid,Integer scenePrid);
		/**
		 * 还原场景人员信息  删除
		 * @param ecprid
		 */
		public void delWDP (Integer ecprid);
		/**
		 * 还原场景人员信息  修改
		 * @param ecprid
		 */
		public void updWDP (Integer ecprid);
		/**
		 * dashboard 人员信息初始化信息
		 */
		public List<Map<String,Object>> searchSigninInitData(Integer ecprid);
		/**
		 * 更新签到表中场景流程prid
		 * 
		 * @param drillPrid
		 *            演练流程id
		 * @param scenePrid
		 *            场景流程prid
		 * @return
		 */
	public int setScenePridFormDrill(Integer drillPrid, Integer scenePrid);
		/**
		 * 查询参与人
		 * @param ecprid
		 * @return
		 */
		public List<Map<String,Object>> searchSigninPeopleDataByCond(Integer ecprid);
}