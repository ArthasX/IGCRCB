/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG913Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG913SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;

/**
 * <p>
 * 流程定义业务逻辑
 * </p>
 */

public interface IG380BL extends BaseBL {
	
	/**
	 * 获取流程定义实例
	 * 
	 * @return IG380TB
	 * @throws BLException
	 */
	
	public IG380TB getIG380TBInstance();

	/**
	 * 根据流程模版ID获取流程定义集合
	 * @param processTemplateId 流程模版ID
	 * @return  List<ProcessDefinition>
	 */
	
	public List<IG380Info> searchIG380InfoByPtid(Integer processTemplateId);
	
	/**
	 * 根据流程定义ID获取流程定义
	 * @param pdid 流程定义ID
	 * @return ProcessTemplate
	 * @throws BLException
	 */
	public IG380Info searchIG380InfoByKey(String pdid) throws BLException;
	
	/**
	 * 根据检索条件取得流程定义信息结果条数
	 * 
	 * @param cond 流程定义信息检索条件
	 * @return 流程定义信息结果条数
	 */
	public int getIG380InfoSearchCount(IG380SearchCond cond);
	
	/**
	 * 根据检索条件取得流程最新定义信息结果条数
	 * 
	 * @param cond 流程定义信息检索条件
	 * @return 流程定义信息结果条数
	 */
	public int getIG380InfoSearchLastCount(IG380SearchCond cond);
	
	/**
	 * 根据检索条件取得流程历史定义信息结果条数
	 * 
	 * @param cond 流程定义信息检索条件
	 * @return 流程定义信息结果条数
	 */
	public int getIG380InfoSearchHistoryCount(IG380SearchCond cond);
	
	/**
	 * 根据检索条件取得流程定义信息列表
	 * 
	 * @param cond 流程定义检索条件
	 * @return 流程定义信息列表
	 */
	public List<IG380Info> searchIG380Info(IG380SearchCond cond);
	
	/**
	 * 根据检索条件取得流程定义最新信息列表
	 * 
	 * @param cond 流程定义检索条件
	 * @return 流程定义信息列表
	 */
	public List<IG380Info> searchLastIG380Info(IG380SearchCond cond, int start, int count);
	
	/**
	 * 根据检索条件取得流程定义历史信息列表
	 * 
	 * @param cond 流程定义检索条件
	 * @return 流程定义信息列表
	 */
	public List<IG380Info> searchHistoryIG380Info(IG380SearchCond cond, int start, int count);
	
	/**
	 * 根据检索条件取得流程定义信息列表
	 * 
	 * @param cond 流程定义检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 流程定义信息列表
	 */
	public List<IG380Info> searchIG380Info(IG380SearchCond cond, int start, int count);
	
	/**
	 * 流程定义信息
	 * 
	 * @param ig380Info 流程定义信息
	 * @return 流程定义
	 */
	public IG380Info registIG380Info(IG380Info ig380Info) throws BLException;

	/**
	 * 删除流程定义信息
	 * 
	 * @param pdid 流程定义主键
	 * @return
	 * @throws BLException
	 */
	public void deleteIG380InfoByKey(String pdid) throws BLException;
	
	/**
	 * 删除流程定义信息
	 * 
	 * @param ig380Info 流程定义信息
	 * @return
	 * @throws BLException
	 */
	public void deleteIG380Info(IG380Info ig380Info) throws BLException;

	/**
	 * 更新流程定义信息
	 * 
	 * @param ig380Info 流程定义信息
	 * @return 流程定义
	 * @throws BLException
	 */
	public IG380Info updateIG380Info(IG380Info ig380Info) throws BLException;
	
	/**
	 * 流程定义不存在检查
	 * 
	 * @param ptid 流程模板ID
	 * @param pdname 流程定义名称
	 * @return
	 * @throws BLException 
	 */
	public void checkNotExistIG380Info(Integer ptid, String pdname) throws BLException;
	
	/**
	 * 根据用户ID获取该用户定义的流程定义信息结果列表
	 * @param userid 用户ID
	 * @param pdstatus 自定义流程状态
	 * @return 流程定义信息结果列表
	 */
	public List<IG380Info> findSelfDefinitionByUserId(String userid, String pdstatus);
	
	/**
	 * 根据用户ID获取该用户定义的流程定义信息结果列表(运维计划用)
	 * @return 流程定义信息结果列表
	 */
	public List<IG380Info> findSelfDefinitionAll();
	
	/**
	 * 根据用户ID获取该用户流程定义信息结果列表
	 * @param userid 用户ID
	 * @return 流程信息结果列表
	 */
	public List<IG380Info> findSelfDefinitionByUserIdCom(String userid, Integer ptid
			, String pdstatus);
	
	/**
	 * 流程定义主键值取得
	 * @param firstsite 主键首位标识
	 * @param pdsequence 序列名称
	 * @return PDID主键值
	 */
	public String getPdidNextValue(String firstsite,String pdsequence);
	
	/**
	 * 流程定义升版本处理
	 * 
	 * @param pdid 流程定义ID
	 */
	public String upgradeProcessDefVersion(String pdid) throws BLException;
	
	/**
	 * 流程定义复制处理
	 * 
	 * @param pdid 流程定义ID
	 * @param pdsequence 序列定义
	 */
	public String copyProcessDefVersion(String pdid,String pdsequence) throws BLException;
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 * @throws BLException
	 */
	public StringBuffer exportXML(String pdid) throws BLException;
	
	/**
	 * XML脚本导入处理
	 *
	 * @param element Element
	 * @throws BLException
	 */
	public void importXML(Element element) throws BLException;
	
	/**
     * 根据检索条件取得流程定义及状态参与者可发起流程类型的信息
     * 
     * @param cond 流程定义检索条件
     * @return 流程定义信息列表
     */
    public List<IG913Info> searchLastIG380AndIG911Info(IG913SearchCond cond);
    
    /**
     * 根据检索条件取得缺省权限的相关发起的自定义流程类型的信息
     * 
     * @param cond 流程定义检索条件
     * @return 流程定义信息列表
     */
    public List<IG913Info> searchLastIG380AndIG931Info(IG913SearchCond cond);
    
	/**
	 * 解析流程图XML
	 * @param e 流程图节点
	 * @param sbf XML字符串
	 */
	public void display(Element e, StringBuffer sbf);
}
