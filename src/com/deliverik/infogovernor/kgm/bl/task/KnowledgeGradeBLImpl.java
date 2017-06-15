/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.bl.task;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.kgm.model.KnowledgeGrade;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeGradeSearchCond;
import com.deliverik.infogovernor.kgm.model.dao.KnowledgeGradeDAO;

/**
 * 概述:知识评分BL实现类
 * 功能描述：知识评分BL实现类
 * 创建记录：wangxiaoqiang 2010/12/07
 * 修改记录：
 */
public class KnowledgeGradeBLImpl extends BaseBLImpl implements
		KnowledgeGradeBL {

	/**知识评分DAO */
	protected KnowledgeGradeDAO knowledgeGradeDAO;

	/**
	 * 知识评分DAO设定
	 * @param knowledgeGradeDAO 知识评分DAO
	 */
	public void setKnowledgeGradeDAO(KnowledgeGradeDAO knowledgeGradeDAO) {
		this.knowledgeGradeDAO = knowledgeGradeDAO;
	}

	/**
	 * 持久化处理
	 * 
	 * @param KnowledgeGrade实体类
	 * @return KnowledgeGrade实体类
	 */
	public KnowledgeGrade saveKnowledgeGrade(KnowledgeGrade knowledgeGrade)
			throws BLException {
		return knowledgeGradeDAO.save(knowledgeGrade);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param id 主键
	 * @return 检索结果
	 */
	public KnowledgeGrade findKnowledgeGradeByPK(Integer id) throws BLException {
		return knowledgeGradeDAO.findByPK(id);
	}

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<KnowledgeGrade> findAllKnowledgeGrade() throws BLException {
		return knowledgeGradeDAO.findAll();
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(KnowledgeGradeSearchCond cond) throws BLException {
		return knowledgeGradeDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<KnowledgeGrade> findKnowledgeGradeByCond(
			KnowledgeGradeSearchCond cond, int start, int count)
			throws BLException {
		return knowledgeGradeDAO.findByCond(cond, start, count);
	}

	/**
	 * 删除处理
	 * 
	 * @param KnowledgeGrade实体类
	 */
	public void deleteKnowledgeGrade(KnowledgeGrade knowledgeGrade)
			throws BLException {
		knowledgeGradeDAO.delete(knowledgeGrade);
	}

}
