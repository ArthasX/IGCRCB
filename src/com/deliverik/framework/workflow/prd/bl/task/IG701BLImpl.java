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
import com.deliverik.framework.workflow.prd.model.IG701Info;
import com.deliverik.framework.workflow.prd.model.condition.IG701SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG701SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG701DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG701PK;
import com.deliverik.framework.workflow.prd.model.entity.IG701TB;

/**
  * 概述: 流程查看角色授权表单表业务逻辑实现
  * 功能描述: 流程查看角色授权表单表业务逻辑实现
  * 创建记录: 2012/10/15
  * 修改记录: 
  */
public class IG701BLImpl extends BaseBLImpl implements
		IG701BL {

	/** 流程查看角色授权表单表DAO接口 */
	protected IG701DAO ig701DAO;
	
	/**
	 * 流程查看角色授权表单表DAO接口设定
	 *
	 * @param ig701DAO 流程查看角色授权表单表DAO接口
	 */
	public void setIg701DAO(IG701DAO ig701DAO) {
		this.ig701DAO = ig701DAO;
	}

	/**
	 * 流程查看角色授权表单表实例取得
	 *
	 * @return 流程查看角色授权表单表实例
	 */
	public IG701TB getIg701TBInstance() {
		return new IG701TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG701Info> searchIg701() {
		return ig701DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG701Info searchIg701ByPK(IG701PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG701SearchCond cond) {
		return ig701DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG701Info> searchIg701(
			IG701SearchCond cond) {
		return ig701DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG701Info> searchIg701(
			IG701SearchCond cond, int start,
			int count) {
		return ig701DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG701Info registIg701(IG701Info instance)
		throws BLException {
		return ig701DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG701Info updateIg701(IG701Info instance)
		throws BLException {
		checkExistInstance(new IG701PK(instance.getPdid(), instance.getRoleid(), instance.getPidid()));
		return ig701DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIg701ByPK(IG701PK pk)
		throws BLException {
		ig701DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIg701(IG701Info instance)
		throws BLException {
		ig701DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG701Info checkExistInstance(IG701PK pk)
		throws BLException {
		IG701Info instance = ig701DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	/**
     * XML脚本导出处理
     *
     * @param pdid 流程定义ID
     * @return XML脚本
     */
    public StringBuffer exportXML(String pdid) throws BLException {
    	IG701SearchCondImpl cond = new IG701SearchCondImpl();
        cond.setPdid(pdid);
        List<IG701Info> lst_IG701Info = this.searchIg701(cond);
        StringBuffer sbf_xml = new StringBuffer("");
        sbf_xml.append("<IG701>");
        sbf_xml.append("<DATALIST>");
        if(lst_IG701Info != null) {
            for(IG701Info info : lst_IG701Info) {
                sbf_xml.append("<DATA>");
                sbf_xml.append("<PDID>");
                sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
                sbf_xml.append("</PDID>");
                sbf_xml.append("<ROLEID>");
                sbf_xml.append(StringUtils.isEmpty(info.getRoleid().toString()) ? "" : "&roleid_" + info.getRoleid().toString() + ";");
                sbf_xml.append("</ROLEID>");
                sbf_xml.append("<PIDID>");
                sbf_xml.append(StringUtils.isEmpty(info.getPidid()) ? "" : IGStringUtils.filterXMLStr(info.getPidid()));
                sbf_xml.append("</PIDID>");
                sbf_xml.append("<FINGERPRINT>");
                sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
                sbf_xml.append("</FINGERPRINT>");
                sbf_xml.append("</DATA>");
            }
        }
        sbf_xml.append("</DATALIST>");
        sbf_xml.append("</IG701>");
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
        List<IG701Info> lst_IG701 = new ArrayList<IG701Info>();
        IG701TB entity = null;
        for(Element e : dataList) {
            entity = this.getIg701TBInstance();
            entity.setPdid(e.getChildText("PDID"));
            entity.setRoleid(Integer.parseInt(e.getChildText("ROLEID")));
            entity.setPidid(e.getChildText("PIDID"));
            entity.setFingerPrint(e.getChildText("FINGERPRINT"));
            lst_IG701.add(entity);
        }
        this.ig701DAO.saveOrUpdateAll(lst_IG701);
    }

}