/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.soc.dbs.bl.task;

 import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Info;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_InfoSearchCond;


/**
 * 
 * @Description:存储基本信息BL接口
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_Symmetrix_InfoBL extends BaseBL{
   /**
    * 持久化处理
    * @param Collect_Symmetrix_Info实体类
    * @return Collect_Symmetrix_Info实体类
    */
 public Collect_Symmetrix_Info saveCollect_Symmetrix_Info(Collect_Symmetrix_Info collect_Symmetrix_Info) throws BLException;

   /**
    * 主键检索处理
    * @param id 主键
    * @return 检索结果
    */
 public Collect_Symmetrix_Info findCollect_Symmetrix_InfoByPK(Integer id) throws BLException;

   /**
    * 全件检索
    * @return 检索结果集
    */
 public List<Collect_Symmetrix_Info> findAllCollect_Symmetrix_Info() throws BLException;

   /**
    * 条件检索结果件数取得
    * @param cond 检索条件
    * @return 检索结果件数
    */
 public int getSearchCount(Collect_Symmetrix_InfoSearchCond cond) throws BLException;

    /**
     * 条件检索处理
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
 public List<Collect_Symmetrix_Info> findCollect_Symmetrix_InfoByCond(Collect_Symmetrix_InfoSearchCond cond, int start, int count) throws BLException;

    /**
     * 删除处理
     * @param Collect_Symmetrix_Info实体类
     */
 public void deleteCollect_Symmetrix_Info(Collect_Symmetrix_Info collect_Symmetrix_Info) throws BLException;

 /**
  * 修改处理
  * @param collect_Symmetrix_Info
  * @throws BLException
  */
 public Collect_Symmetrix_Info updateCollect_Symmetrix_Info(Collect_Symmetrix_Info collect_Symmetrix_Info) throws BLException;

}

