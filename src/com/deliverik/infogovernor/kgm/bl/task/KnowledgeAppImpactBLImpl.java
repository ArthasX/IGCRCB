/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.kgm.bl.task;

 import java.util.List;
 import com.deliverik.framework.base.BLException;
 import com.deliverik.framework.base.BaseBLImpl;
 import com.deliverik.infogovernor.kgm.model.KnowledgeAppImpact;
 import com.deliverik.infogovernor.kgm.model.condition.KnowledgeAppImpactSearchCond;
 import com.deliverik.infogovernor.kgm.model.dao.KnowledgeAppImpactDAO;


/**
 * 
 * @Description:知识业务系统关联BL实现类
 * @Author
 * @History
 * @Version V1.0
 */
public class KnowledgeAppImpactBLImpl extends BaseBLImpl implements KnowledgeAppImpactBL{

  protected KnowledgeAppImpactDAO knowledgeAppImpactDAO;

 public void setKnowledgeAppImpactDAO(KnowledgeAppImpactDAO knowledgeAppImpactDAO) {
 this.knowledgeAppImpactDAO = knowledgeAppImpactDAO;
 }

   /**
    * 持久化处理
    * @param KnowledgeAppImpact实体类
    * @return KnowledgeAppImpact实体类
    */
 public KnowledgeAppImpact saveKnowledgeAppImpact(KnowledgeAppImpact knowledgeAppImpact) throws BLException{
 return knowledgeAppImpactDAO.save(knowledgeAppImpact);
 }

   /**
    * 主键检索处理
    * @param id 主键
    * @return 检索结果
    */
 public KnowledgeAppImpact findKnowledgeAppImpactByPK(Integer id) throws BLException{
 return knowledgeAppImpactDAO.findByPK(id);
 }

   /**
    * 全件检索
    * @return 检索结果集
    */
 public List<KnowledgeAppImpact> findAllKnowledgeAppImpact() throws BLException{
 return knowledgeAppImpactDAO.findAll();
 }

   /**
    * 条件检索结果件数取得
    * @param cond 检索条件
    * @return 检索结果件数
    */
 public int getSearchCount(KnowledgeAppImpactSearchCond cond) throws BLException{
 return knowledgeAppImpactDAO.getSearchCount(cond);
 }

    /**
     * 条件检索处理
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
 public List<KnowledgeAppImpact> findKnowledgeAppImpactByCond(KnowledgeAppImpactSearchCond cond, int start, int count) throws BLException{
 return knowledgeAppImpactDAO.findByCond(cond, start, count);
 }

    /**
     * 删除处理
     * @param KnowledgeAppImpact实体类
     */
 public void deleteKnowledgeAppImpact(KnowledgeAppImpact knowledgeAppImpact) throws BLException{
knowledgeAppImpactDAO.delete(knowledgeAppImpact);
 }

}

