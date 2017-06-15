/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.kgm.bl.task;

 import java.util.List;
 import com.deliverik.framework.base.BLException;
 import com.deliverik.framework.base.BaseBL;
 import com.deliverik.infogovernor.kgm.model.KnowledgeGrade;
 import com.deliverik.infogovernor.kgm.model.condition.KnowledgeGradeSearchCond;


/**
 * 
 * @Description:知识评分BL接口
 * @Author
 * @History
 * @Version V1.0
 */
public interface KnowledgeGradeBL extends BaseBL{
   /**
    * 持久化处理
    * @param KnowledgeGrade实体类
    * @return KnowledgeGrade实体类
    */
 public KnowledgeGrade saveKnowledgeGrade(KnowledgeGrade knowledgeGrade) throws BLException;

   /**
    * 主键检索处理
    * @param id 主键
    * @return 检索结果
    */
 public KnowledgeGrade findKnowledgeGradeByPK(Integer id) throws BLException;

   /**
    * 全件检索
    * @return 检索结果集
    */
 public List<KnowledgeGrade> findAllKnowledgeGrade() throws BLException;

   /**
    * 条件检索结果件数取得
    * @param cond 检索条件
    * @return 检索结果件数
    */
 public int getSearchCount(KnowledgeGradeSearchCond cond) throws BLException;

    /**
     * 条件检索处理
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
 public List<KnowledgeGrade> findKnowledgeGradeByCond(KnowledgeGradeSearchCond cond, int start, int count) throws BLException;

    /**
     * 删除处理
     * @param KnowledgeGrade实体类
     */
 public void deleteKnowledgeGrade(KnowledgeGrade knowledgeGrade) throws BLException;

}

