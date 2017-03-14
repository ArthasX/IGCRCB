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
import com.deliverik.framework.workflow.prd.model.IG911Info;
import com.deliverik.framework.workflow.prd.model.condition.IG911SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG911SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG911DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG911TB;

/**
  * 概述: 状态参与者关联流程类型定义表业务逻辑实现
  * 功能描述: 状态参与者关联流程类型定义表业务逻辑实现
  * 创建记录: 2012/10/18
  * 修改记录: 
  */
public class IG911BLImpl extends BaseBLImpl implements
		IG911BL {

	/** 状态参与者关联流程类型定义表DAO接口 */
	protected IG911DAO ig911DAO;
	
	/**
	 * 状态参与者关联流程类型定义表DAO接口设定
	 *
	 * @param iG911DAO 状态参与者关联流程类型定义表DAO接口
	 */
	public void setIg911DAO(IG911DAO ig911DAO) {
		this.ig911DAO = ig911DAO;
	}

	/**
	 * 状态参与者关联流程类型定义表实例取得
	 *
	 * @return 状态参与者关联流程类型定义表实例
	 */
	public IG911TB getIG911TBInstance() {
		return new IG911TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG911Info> searchIG911Info() {
		return ig911DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG911Info searchIG911InfoByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG911SearchCond cond) {
		return ig911DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG911Info> searchIG911Info(
			IG911SearchCond cond) {
		return ig911DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 相关发起流程状态为启用状态的状态参与者相关发起信息取得
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG911Info> searchIg911RelevantPdid(IG911SearchCond cond) {
	    return ig911DAO.getIg911RelevantPdidfindByCond(cond);
	}
	
	/**
	 * 相关发起可发起流程的流程定义信息取得（根据IG911关联取得IG380的信息）
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG380Info> searchIg380ByIg911Cond(
	        IG911SearchCond cond) {
	    return ig911DAO.getIg380InfoByIg911Cond(cond);
	}
	
	/**
     * 相关发起流程状态为启用状态的状态参与者相关发起信息条数取得
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public int getIg911RelevantPdidCount(IG911SearchCond cond) {
        return ig911DAO.getIg911RelevantPdidCount(cond);
    }

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG911Info> searchIG911Info(
			IG911SearchCond cond, int start,
			int count) {
		return ig911DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG911Info registIG911Info(IG911Info instance)
		throws BLException {
		return ig911DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG911Info updateIG911Info(IG911Info instance)
		throws BLException {
		checkExistInstance(instance.getPsprpid());
		return ig911DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG911InfoByPK(String pk)
		throws BLException {
		ig911DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG911Info(IG911Info instance)
		throws BLException {
		ig911DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG911Info checkExistInstance(String pk)
		throws BLException {
		IG911Info instance = ig911DAO.findByPK(pk);
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
    public String getPsprpidSequenceNextValue(String psdid) {
        return ig911DAO.getPsprpidSequenceNextValue(psdid);
    }

    /**
     * XML脚本导出处理
     *
     * @param pdid 流程定义ID
     * @return XML脚本
     */
    public StringBuffer exportXML(String pdid) throws BLException {
        IG911SearchCondImpl cond = new IG911SearchCondImpl();
        cond.setPdid(pdid);
        List<IG911Info> lst_IG911Info = this.searchIG911Info(cond);
        StringBuffer sbf_xml = new StringBuffer("");
        sbf_xml.append("<IG911>");
        sbf_xml.append("<DATALIST>");
        if(lst_IG911Info != null) {
            for(IG911Info info : lst_IG911Info) {
                sbf_xml.append("<DATA>");
                sbf_xml.append("<PSPRPID>");
                sbf_xml.append(StringUtils.isEmpty(info.getPsprpid()) ? "" : IGStringUtils.filterXMLStr(info.getPsprpid()));
                sbf_xml.append("</PSPRPID>");
                sbf_xml.append("<PDID>");
                sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
                sbf_xml.append("</PDID>");
                sbf_xml.append("<PSDID>");
                sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
                sbf_xml.append("</PSDID>");
                sbf_xml.append("<ROLEID>");
                sbf_xml.append(info.getRoleid()==null ? "" : "&roleid_" + String.valueOf(info.getRoleid()) + ";");
                sbf_xml.append("</ROLEID>");
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
        sbf_xml.append("</IG911>");
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
        List<IG911Info> lst_IG911 = new ArrayList<IG911Info>();
        IG911TB entity = null;
        for(Element e : dataList) {
            entity = this.getIG911TBInstance();
            entity.setPsprpid(e.getChildText("PSPRPID"));
            entity.setPdid(e.getChildText("PDID"));
            entity.setPsdid(e.getChildText("PSDID"));
            entity.setRoleid(Integer.parseInt(e.getChildText("ROLEID")));
            entity.setRelevantPdid(e.getChildText("RELEVANTPDID"));
            entity.setFingerPrint(e.getChildText("FINGERPRINT"));
            lst_IG911.add(entity);
        }
        this.ig911DAO.saveOrUpdateAll(lst_IG911);
    }
}
