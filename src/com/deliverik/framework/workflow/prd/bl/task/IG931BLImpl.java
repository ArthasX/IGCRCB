/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG931Info;
import com.deliverik.framework.workflow.prd.model.condition.IG931SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG931SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG931DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG931TB;

/**
  * 概述: 缺省状态参与者关联流程类型定义表业务逻辑实现
  * 功能描述: 缺省状态参与者关联流程类型定义表业务逻辑实现
  * 创建记录: 2012/10/18
  * 修改记录: 
  */
public class IG931BLImpl extends BaseBLImpl implements
		IG931BL {

	/** 缺省状态参与者关联流程类型定义表DAO接口 */
	protected IG931DAO ig931DAO;
	
	/**
	 * 缺省状态参与者关联流程类型定义表DAO接口设定
	 *
	 * @param iG931DAO 缺省状态参与者关联流程类型定义表DAO接口
	 */
	public void setIg931DAO(IG931DAO ig931DAO) {
		this.ig931DAO = ig931DAO;
	}

	/**
	 * 缺省状态参与者关联流程类型定义表实例取得
	 *
	 * @return 缺省状态参与者关联流程类型定义表实例
	 */
	public IG931TB getIG931TBInstance() {
		return new IG931TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG931Info> searchIG931Info() {
		return ig931DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG931Info searchIG931InfoByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG931SearchCond cond) {
		return ig931DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG931Info> searchIG931Info(
			IG931SearchCond cond) {
		return ig931DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG931Info> searchIG931Info(
			IG931SearchCond cond, int start,
			int count) {
		return ig931DAO.findByCond(cond, start, count);
	}

	/**
     * 相关发起流程状态为启用状态的默认权限的相关发起信息取得
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public List<IG931Info> searchIg931RelevantPdid(
            IG931SearchCond cond) {
        return ig931DAO.getIg931RelevantPdidfindByCond(cond);
    }
    
    /**
     * 相关发起流程状态为启用状态的默认权限的相关发起信息条数取得
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public int getIg931RelevantPdidCount(IG931SearchCond cond) {
        return ig931DAO.getIg931RelevantPdidCount(cond);
    }
    
    /**
     * 相关发起可发起流程的流程定义信息取得（根据IG931关联取得IG380的信息）
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public List<IG380Info> searchIg380ByIg931Cond(IG931SearchCond cond) {
        return ig931DAO.getIg380InfoByIg931Cond(cond);
    }
    
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG931Info registIG931Info(IG931Info instance)
		throws BLException {
		return ig931DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG931Info updateIG931Info(IG931Info instance)
		throws BLException {
		checkExistInstance(instance.getDpsprpid());
		return ig931DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG931InfoByPK(String pk)
		throws BLException {
		ig931DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG931Info(IG931Info instance)
		throws BLException {
		ig931DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG931Info checkExistInstance(String pk)
		throws BLException {
		IG931Info instance = ig931DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	/**
     * PPDID主键值取得
     * 
     * @param 流程状态ID
     * @return PPDID主键值
     */
    public String getDpsprpidSequenceNextValue(String psdid) {
        return ig931DAO.getDpsprpidSequenceNextValue(psdid);
    }
    
    /**
     * XML脚本导出处理
     *
     * @param pdid 流程定义ID
     * @return XML脚本
     */
    public StringBuffer exportXML(String pdid) throws BLException {
        IG931SearchCondImpl cond = new IG931SearchCondImpl();
        cond.setPdid(pdid);
        List<IG931Info> lst_IG931Info = this.searchIG931Info(cond);
        StringBuffer sbf_xml = new StringBuffer("");
        sbf_xml.append("<IG931>");
        sbf_xml.append("<DATALIST>");
        if(lst_IG931Info != null) {
            for(IG931Info info : lst_IG931Info) {
                sbf_xml.append("<DATA>");
                sbf_xml.append("<DPSPRPID>");
                sbf_xml.append(StringUtils.isEmpty(info.getDpsprpid()) ? "" : IGStringUtils.filterXMLStr(info.getDpsprpid()));
                sbf_xml.append("</DPSPRPID>");
                sbf_xml.append("<PDID>");
                sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
                sbf_xml.append("</PDID>");
                sbf_xml.append("<PSDID>");
                sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
                sbf_xml.append("</PSDID>");
                sbf_xml.append("<RELEVANTPDID>");
                sbf_xml.append(StringUtils.isEmpty(info.getRelevantPdid()) ? "" : IGStringUtils.filterXMLStr(info.getRelevantPdid()));
                sbf_xml.append("</RELEVANTPDID>");
                sbf_xml.append("<FINGERPRINT>");
                sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
                sbf_xml.append("</FINGERPRINT>");
                sbf_xml.append("</DATA>");
            }
        }
        sbf_xml.append("</DATALIST>");
        sbf_xml.append("</IG931>");
        return sbf_xml;
    }
    
    /**
     * XML脚本导入处理
     *
     * @param element Element
     * @throws BLException
     */
    @SuppressWarnings("unchecked")
    public void importXML(Element element) throws BLException {
        Element data = element.getChild("DATALIST");
        List<Element> dataList = data.getChildren();
        List<IG931Info> lst_IG931 = new ArrayList<IG931Info>();
        IG931TB entity = null;
        for(Element e : dataList) {
            entity = this.getIG931TBInstance();
            entity.setDpsprpid(e.getChildText("DPSPRPID"));
            entity.setPdid(e.getChildText("PDID"));
            entity.setPsdid(e.getChildText("PSDID"));
            entity.setRelevantPdid(e.getChildText("RELEVANTPDID"));
            entity.setFingerPrint(e.getChildText("FINGERPRINT"));
            lst_IG931.add(entity);
        }
        this.ig931DAO.saveOrUpdateAll(lst_IG931);
    }
}
