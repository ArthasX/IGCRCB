/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prd.bl.task.IG001BL;
import com.deliverik.framework.workflow.prd.bl.task.IG007BL;
import com.deliverik.framework.workflow.prd.bl.task.IG008BL;
import com.deliverik.framework.workflow.prd.bl.task.IG105BL;
import com.deliverik.framework.workflow.prd.bl.task.IG108BL;
import com.deliverik.framework.workflow.prd.bl.task.IG110BL;
import com.deliverik.framework.workflow.prd.bl.task.IG111BL;
import com.deliverik.framework.workflow.prd.bl.task.IG123BL;
import com.deliverik.framework.workflow.prd.bl.task.IG126BL;
import com.deliverik.framework.workflow.prd.bl.task.IG132BL;
import com.deliverik.framework.workflow.prd.bl.task.IG156BL;
import com.deliverik.framework.workflow.prd.bl.task.IG202BL;
import com.deliverik.framework.workflow.prd.bl.task.IG212BL;
import com.deliverik.framework.workflow.prd.bl.task.IG213BL;
import com.deliverik.framework.workflow.prd.bl.task.IG221BL;
import com.deliverik.framework.workflow.prd.bl.task.IG222BL;
import com.deliverik.framework.workflow.prd.bl.task.IG233BL;
import com.deliverik.framework.workflow.prd.bl.task.IG237BL;
import com.deliverik.framework.workflow.prd.bl.task.IG243BL;
import com.deliverik.framework.workflow.prd.bl.task.IG258BL;
import com.deliverik.framework.workflow.prd.bl.task.IG259BL;
import com.deliverik.framework.workflow.prd.bl.task.IG273BL;
import com.deliverik.framework.workflow.prd.bl.task.IG286BL;
import com.deliverik.framework.workflow.prd.bl.task.IG298BL;
import com.deliverik.framework.workflow.prd.bl.task.IG299BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG334BL;
import com.deliverik.framework.workflow.prd.bl.task.IG335BL;
import com.deliverik.framework.workflow.prd.bl.task.IG373BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.bl.task.IG413BL;
import com.deliverik.framework.workflow.prd.bl.task.IG480BL;
import com.deliverik.framework.workflow.prd.bl.task.IG560BL;
import com.deliverik.framework.workflow.prd.bl.task.IG699BL;
import com.deliverik.framework.workflow.prd.bl.task.IG700BL;
import com.deliverik.framework.workflow.prd.bl.task.IG701BL;
import com.deliverik.framework.workflow.prd.bl.task.IG725BL;
import com.deliverik.framework.workflow.prd.bl.task.IG881BL;
import com.deliverik.framework.workflow.prd.bl.task.IG911BL;
import com.deliverik.framework.workflow.prd.bl.task.IG931BL;
import com.deliverik.framework.workflow.prd.bl.task.IG992BL;
import com.deliverik.framework.workflow.prd.model.IG001Info;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG008Info;
import com.deliverik.framework.workflow.prd.model.IG100Info;
import com.deliverik.framework.workflow.prd.model.IG105Info;
import com.deliverik.framework.workflow.prd.model.IG108Info;
import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.framework.workflow.prd.model.IG123Info;
import com.deliverik.framework.workflow.prd.model.IG126Info;
import com.deliverik.framework.workflow.prd.model.IG132Info;
import com.deliverik.framework.workflow.prd.model.IG156Info;
import com.deliverik.framework.workflow.prd.model.IG202Info;
import com.deliverik.framework.workflow.prd.model.IG212Info;
import com.deliverik.framework.workflow.prd.model.IG213Info;
import com.deliverik.framework.workflow.prd.model.IG221Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG233Info;
import com.deliverik.framework.workflow.prd.model.IG237Info;
import com.deliverik.framework.workflow.prd.model.IG238Info;
import com.deliverik.framework.workflow.prd.model.IG243Info;
import com.deliverik.framework.workflow.prd.model.IG258Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.IG286Info;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.IG299Info;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG334Info;
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.IG373Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG413Info;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.IG560VWInfo;
import com.deliverik.framework.workflow.prd.model.IG699Info;
import com.deliverik.framework.workflow.prd.model.IG700Info;
import com.deliverik.framework.workflow.prd.model.IG701Info;
import com.deliverik.framework.workflow.prd.model.IG725Info;
import com.deliverik.framework.workflow.prd.model.IG881Info;
import com.deliverik.framework.workflow.prd.model.IG909Info;
import com.deliverik.framework.workflow.prd.model.IG911Info;
import com.deliverik.framework.workflow.prd.model.IG913Info;
import com.deliverik.framework.workflow.prd.model.IG931Info;
import com.deliverik.framework.workflow.prd.model.IG992Info;
import com.deliverik.framework.workflow.prd.model.condition.IG001SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG001SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG008SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG100SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG105SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG110SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG111SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG126SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG132SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG156SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG202SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG213SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG221SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG233SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG237SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG243SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG258SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG286SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG335SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG373SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG413SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG480SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG480SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG699SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG700SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG701SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG725SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG909SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG911SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG913SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG931SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG992SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prd.model.entity.IG259TB;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG560TB;
import com.deliverik.framework.workflow.prd.model.entity.IG700PK;
import com.deliverik.framework.workflow.prd.model.entity.IG701PK;
import com.deliverik.framework.workflow.prr.bl.task.IG561BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;

/**
 * <p>概述:流程定义业务逻辑实现</p>
 * <p>功能描述：1.获取使用中的流程模板信息</p>
 * <p>          2.条件检索流程模板信息</p>
 * <p>          3.条件检索流程模板信息（分页查询用）</p>
 * <p>          4.根据流程模板ID获取流程模板</p>
 * <p>          5.新增流程模板处理</p>
 * <p>          6.删除流程模板处理</p>
 * <p>          7.变更流程模板信息处理</p>
 * <p>          8.根据流程模版ID获取流程定义集合</p>
 * <p>          9.根据流程定义ID获取流程定义</p>
 * <p>          10.根据检索条件取得流程定义信息结果条数</p>
 * <p>          11.根据检索条件取得流程定义信息列表</p>
 * <p>          12.根据检索条件取得流程定义信息列表（分页查询使用）</p>
 * <p>          13.流程定义信息</p>
 * <p>          14.删除流程定义信息</p>
 * <p>          15.更新流程定义信息</p>
 * <p>          16.根据流程定义ID获取流程变量定义集合</p>
 * <p>          17.根据流程定义ID获取流程变量定义集合，不包括缺省变量（平台保留）</p>
 * <p>          18.流程变量定义条件检索结果件数取得</p>
 * <p>          19.流程变量定义条件检索处理</p>
 * <p>          20.流程变量定义条件检索处理</p>
 * <p>          21.根据流程变量定义ID获取流程变量定义信息</p>
 * <p>          22.流程变量定义信息登录处理</p>
 * <p>          23.流程变量定义信息更新处理</p>
 * <p>          24.流程变量定义信息删除处理</p>
 * <p>          25.流程变量定义信息删除处理</p>
 * <p>创建记录：
 */
public class WorkFlowDefinitionBLImpl extends BaseBLImpl implements WorkFlowDefinitionBL {
	
	/** 流程模板信息操作 */
	protected IG259BL ig259BL;
	
	/** 流程类型信息操作 */
	protected IG380BL ig380BL;
	
	/** 流程变量定义信息操作 */
	protected IG007BL ig007BL;
	
	/** 流程策略信息操作 */
	protected IG105BL ig105BL;
	
	/** 角色配置BL */
	protected IG001BL ig001BL;
	
	/** 流程查看角色授权表单表BL */
	protected IG701BL ig701BL;

	/** 流程前后处理定义BL */
	protected IG413BL ig413BL;
	
	/** 流程状态信息BL */
	protected IG333BL ig333BL;
	
	/** 流程状态_参与者信息BL */
	protected IG222BL ig222BL;
	
	/** 流程表单初始化事件定义信息BL */
	protected IG373BL ig373BL;
	
	/** 流程主题显示BL */
	protected IG243BL ig243BL;
	
	/**流程状态可分派角色定义BL*/
	protected IG298BL ig298BL;
	
	/** 流程角色类型授权BL */
	protected IG213BL ig213BL;
	
	/** 状态参与者关联流程类型定义BL*/
	protected IG911BL ig911BL;
	
	/** 流程状态可分派机构定义BL */
	protected IG299BL ig299BL;
	
	/** 缺省状态参与者关联流程类型定义BL*/
	protected IG931BL ig931BL;
	
	/** 机构范围BL */
	protected IG123BL ig123BL;
	
	/** 流程状态按钮定义BL */
	protected IG156BL ig156BL;
	
	/** 流程表单联动BL */
	protected IG286BL ig286BL;
	
	/** 流程状态_参与者按钮BL */
	protected IG132BL ig132BL;
	
	/** 流程状态_参与者按钮vwBL */
	protected IG221BL ig221BL;
	
	/** 流程状态_参与者_权限信息BL */
	protected IG881BL ig881BL;
	
	/** 规则定义信息BL */
	protected IG273BL ig273BL;
	
	/** 缺省参与人按钮定义BL */
	protected IG725BL ig725BL;
	
	/** 定制页面BL */
	protected IG126BL ig126BL;
	
	/** 流程缺省参与者变量权限BL */
	protected IG699BL ig699BL;
	
	/** 共通变量表单信息信息BL */
	protected IG202BL ig202BL;
	
	/** 流程查看角色BL */
	protected IG700BL ig700BL;
	
	/** 流程通知策略设定BL */
	protected IG212BL ig212BL;
	
	/** 流程通知策略通知人BL */
	protected IG237BL ig237BL;
	
	/**  外部调用  */
	protected IG992BL ig992BL;
	
	/**  流程可调整参与者  */
	protected IG258BL ig258BL;
	
	/** 分派状态BL */
	protected IG233BL ig233BL;
    
    /** 表单查询条件BL */
    protected IG108BL ig108BL;
    
	/**  通知策略基本信息BL */
	protected IG334BL ig334BL;
	
	/**  表单策略BL */
	protected IG335BL ig335BL;
	
	/** 表单角色限定BL */
	protected IG008BL ig008BL;
	
	/**状态级私有表单默认值BL*/
    protected IG560BL ig560BL;
    
    /**状态级私有表单值表*/
    protected IG561BL ig561BL;
    
    /** 流程查询显示列定义BL */
    protected IG110BL ig110BL;
    
    /** 流程查询条件定义实体BL */
    protected IG111BL ig111BL;
    
    /** 流程组定义操作BL */
    protected IG480BL ig480BL;
    
	/**
	 * @param ig480bl the 流程组定义操作BL to set
	 */
	public void setIg480BL(IG480BL ig480bl) {
		ig480BL = ig480bl;
	}

	/**
	 * 流程模板信息操作设定
	 * @param ig259BL 流程模板信息操作
	 */
	public void setIg259BL(IG259BL ig259bl) {
		ig259BL = ig259bl;
	}

	/**
	 * 流程类型信息操作设定
	 * @param ig380BL 流程类型信息操作
	 */
	public void setIg380BL(IG380BL ig380bl) {
		ig380BL = ig380bl;
	}

	/**
	 * 流程变量定义信息操作设定
	 * @param ig007BL 流程变量定义信息操作
	 */
	public void setIg007BL(IG007BL ig007bl) {
		ig007BL = ig007bl;
	}

	/**
	 * 流程策略信息操作设定
	 * @param ig105BL 流程策略信息操作
	 */
	public void setIg105BL(IG105BL ig105bl) {
		ig105BL = ig105bl;
	}

	/**
	 * 角色配置BL设定
	 * @param ig001BL 角色配置BL
	 */
	public void setIg001BL(IG001BL ig001bl) {
		ig001BL = ig001bl;
	}

	/**
	 * 流程查看角色授权表单表BL设定
	 * @param ig701BL 流程查看角色授权表单表BL
	 */
	public void setIg701BL(IG701BL ig701bl) {
		ig701BL = ig701bl;
	}

	/**
	 * 流程前后处理定义BL设定
	 * @param ig413BL 流程前后处理定义BL
	 */
	public void setIg413BL(IG413BL ig413bl) {
		ig413BL = ig413bl;
	}

	/**
	 * 流程状态信息BL设定
	 * @param ig333BL 流程状态信息BL
	 */
	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
	}

	/**
	 * 流程状态_参与者信息BL设定
	 * @param ig222BL 流程状态_参与者信息BL
	 */
	public void setIg222BL(IG222BL ig222bl) {
		ig222BL = ig222bl;
	}

	/**
	 * 流程表单初始化事件定义信息BL设定
	 * @param ig373BL 流程表单初始化事件定义信息BL
	 */
	public void setIg373BL(IG373BL ig373bl) {
		ig373BL = ig373bl;
	}

	/**
	 * 流程主题显示BL设定
	 * @param ig243BL 流程主题显示BL
	 */
	public void setIg243BL(IG243BL ig243bl) {
		ig243BL = ig243bl;
	}

	/**
	 * 流程状态可分派角色定义BL设定
	 * @param ig298BL 流程状态可分派角色定义BL
	 */
	public void setIg298BL(IG298BL ig298bl) {
		ig298BL = ig298bl;
	}

	/**
	 * 流程角色类型授权BL设定
	 * @param ig213BL 流程角色类型授权BL
	 */
	public void setIg213BL(IG213BL ig213bl) {
		ig213BL = ig213bl;
	}

	/**
	 * 状态参与者关联流程类型定义BL设定
	 * @param ig911BL 状态参与者关联流程类型定义BL
	 */
	public void setIg911BL(IG911BL ig911bl) {
		ig911BL = ig911bl;
	}

	/**
	 * 流程状态可分派机构定义BL设定
	 * @param ig299BL 流程状态可分派机构定义BL
	 */
	public void setIg299BL(IG299BL ig299bl) {
		ig299BL = ig299bl;
	}

	/**
	 * 缺省状态参与者关联流程类型定义BL设定
	 * @param ig931BL 缺省状态参与者关联流程类型定义BL
	 */
	public void setIg931BL(IG931BL ig931bl) {
		ig931BL = ig931bl;
	}

	/**
	 * 机构范围BL设定
	 * @param ig123BL 机构范围BL
	 */
	public void setIg123BL(IG123BL ig123bl) {
		ig123BL = ig123bl;
	}

	/**
	 * 流程状态按钮定义BL设定
	 * @param ig156BL 流程状态按钮定义BL
	 */
	public void setIg156BL(IG156BL ig156bl) {
		ig156BL = ig156bl;
	}

	/**
	 * 流程表单联动BL设定
	 * @param ig286BL 流程表单联动BL
	 */
	public void setIg286BL(IG286BL ig286bl) {
		ig286BL = ig286bl;
	}

	/**
	 * 流程状态_参与者按钮BL设定
	 * @param ig132BL 流程状态_参与者按钮BL
	 */
	public void setIg132BL(IG132BL ig132bl) {
		ig132BL = ig132bl;
	}

	/**
	 * 流程状态_参与者按钮vwBL设定
	 * @param ig221BL 流程状态_参与者按钮vwBL
	 */
	public void setIg221BL(IG221BL ig221bl) {
		ig221BL = ig221bl;
	}

	/**
	 * 流程状态_参与者_权限信息BL设定
	 * @param ig881BL 流程状态_参与者_权限信息BL
	 */
	public void setIg881BL(IG881BL ig881bl) {
		ig881BL = ig881bl;
	}

	/**
	 * 规则定义信息BL设定
	 * @param ig273BL 规则定义信息BL
	 */
	public void setIg273BL(IG273BL ig273bl) {
		ig273BL = ig273bl;
	}

	/**
	 * 缺省参与人按钮定义BL设定
	 * @param ig725BL 缺省参与人按钮定义BL
	 */
	public void setIg725BL(IG725BL ig725bl) {
		ig725BL = ig725bl;
	}

	/**
	 * 定制页面BL设定
	 * @param ig126BL 定制页面BL
	 */
	public void setIg126BL(IG126BL ig126bl) {
		ig126BL = ig126bl;
	}

	/**
	 * 流程缺省参与者变量权限BL设定
	 * @param ig699BL 流程缺省参与者变量权限BL
	 */
	public void setIg699BL(IG699BL ig699bl) {
		ig699BL = ig699bl;
	}

	/**
	 * 共通变量表单信息信息BL设定
	 * @param ig202BL 共通变量表单信息信息BL
	 */
	public void setIg202BL(IG202BL ig202bl) {
		ig202BL = ig202bl;
	}

	/**
	 * 流程查看角色BL设定
	 * @param ig700BL 流程查看角色BL
	 */
	public void setIg700BL(IG700BL ig700bl) {
		ig700BL = ig700bl;
	}

	/**
	 * 流程通知策略设定BL设定
	 * @param ig212BL 流程通知策略设定BL
	 */
	public void setIg212BL(IG212BL ig212bl) {
		ig212BL = ig212bl;
	}

	/**
	 * 流程通知策略通知人BL设定
	 * @param ig237BL 流程通知策略通知人BL
	 */
	public void setIg237BL(IG237BL ig237bl) {
		ig237BL = ig237bl;
	}

	/**
	 * 外部调用设定
	 * @param ig992BL 外部调用
	 */
	public void setIg992BL(IG992BL ig992bl) {
		ig992BL = ig992bl;
	}
	
    public void setIg561BL(IG561BL ig561bl) {
        ig561BL = ig561bl;
    }

    public void setIg560BL(IG560BL ig560bl) {
        ig560BL = ig560bl;
    }

	/**
	 * 流程可调整参与者设定
	 * @param ig258BL 流程可调整参与者
	 */
	public void setIg258BL(IG258BL ig258bl) {
		ig258BL = ig258bl;
	}

	/**
	 * 分派状态BL设定
	 * @param ig233BL 分派状态BL
	 */
	public void setIg233BL(IG233BL ig233bl) {
		ig233BL = ig233bl;
	}

	/**
	 * 表单查询条件BL设定
	 * @param ig108BL 表单查询条件BL
	 */
	public void setIg108BL(IG108BL ig108bl) {
		ig108BL = ig108bl;
	}

	/**
	 * 通知策略基本信息BL设定
	 * @param ig334BL 通知策略基本信息BL
	 */
	public void setIg334BL(IG334BL ig334bl) {
		ig334BL = ig334bl;
	}

	/**
	 * 表单策略BL设定
	 * @param ig335BL 表单策略BL
	 */
	public void setIg335BL(IG335BL ig335bl) {
		ig335BL = ig335bl;
	}
	
	/**
	 * 表单角色限定BL设定
	 * @param ig008BL 表单角色限定BL
	 */
	public void setIg008BL(IG008BL ig008bl) {
		ig008BL = ig008bl;
	}

	/**
	 * 流程查询显示列定义BL设定
	 * @param ig110BL 流程查询显示列定义BL
	 */
	public void setIg110BL(IG110BL ig110bl) {
		ig110BL = ig110bl;
	}

	/**
	 * 流程查询条件定义实体BL设定
	 * @param ig111BL 流程查询条件定义实体BL
	 */
	public void setIg111BL(IG111BL ig111bl) {
		ig111BL = ig111bl;
	}

	/**
	 * <p>
	 * 新的流程模板信息对象实例取得
	 * <p>
	 * 
	 * @return 新的流程模板信息对象实例取得
	 */
	
	public IG259TB getProcessTemplateTBInstance() {
		return ig259BL.getIG259TBInstance();
	}
	
	/**
	 * <p>
	 * 新的流程类型信息对象实例取得
	 * <p>
	 * 
	 * @return 新的流程类型信息对象实例取得
	 */
	
	public IG380TB getProcessDefinitionTBInstance() {
		return ig380BL.getIG380TBInstance();
	}
	/**
	 * <p>
	 * 新的流程变量定义信息对象实例取得
	 * <p>
	 * 
	 * @return 新的流程变量定义信息对象实例取得
	 */
	
	public IG007TB getIG007TBInstance() {
		return ig007BL.getIG007TBInstance();
	}
	
	/**
	 * 功能：获取使用中的流程模板信息
	 * @param prtype 流程模板类型
	 * @return 流程模板信息
	 * @throws BLException
	 */
	
	public IG259Info searchProcessTemplateByPrType(String prtype){
		return ig259BL.searchIG259ByPrType(prtype);
	}
	
	/**
	 * 功能：条件检索流程模板信息
	 * @param cond 流程模板信息检索条件
	 * @return 流程模板信息结果列表
	 */
	public List<IG259Info> searchProcessTemplate(IG259SearchCond cond) {
		return ig259BL.searchIG259Info(cond);
	}
	
	/**
	 * 功能：条件检索流程模板信息（分页查询用）
	 * @param cond 流程模板信息检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 流程模板信息结果列表
	 */
	public List<IG259Info> searchProcessTemplate(IG259SearchCond cond, int start, int count){
		return ig259BL.searchIG259Info(cond, start, count);
	}
	
	/**
	 * 功能：根据流程模板ID获取流程模板
	 * @param ptid 流程模板ID
	 * @return 流程模板信息
	 * @throws BLException
	 */
	public IG259Info searchProcessTemplateByKey(Integer ptid) throws BLException{
		return ig259BL.searchIG259InfoByKey(ptid);
	}
	
	/**
	 * 功能：新增流程模板处理
	 * 
	 * @param processTemplate 新增数据
	 * @return 流程模板信息
	 * @throws BLException
	 */
	
	public IG259Info registProcessTemplate(IG259Info processTemplate)throws BLException{
		return ig259BL.registIG259Info(processTemplate);
	}
	
	
	/**
	 * 功能：删除流程模板处理
	 * 
	 * @param ptid 流程模版ID
	 * @return
	 * @throws BLException
	 */
	
	public void deleteProcessTemplateByKey(Integer ptid) throws BLException{
		ig259BL.deleteIG259InfoByKey(ptid);
	}
	
	/**
	 * 功能：变更流程模板信息处理
	 * 
	 * @param processTemplate 变更数据
	 * @return 流程模板信息
	 * @throws BLException
	 */
	
	public IG259Info updateProcessTemplate(IG259Info processTemplate)throws BLException{
		return ig259BL.updateIG259Info(processTemplate);
	}
	
	
	/**
	 * 功能：根据流程模版ID获取流程定义集合
	 * @param processTemplateId 流程模版ID
	 * @return  流程定义信息集合
	 */
	
	public List<IG380Info> searchProcessDefinitionsByPtid(Integer processTemplateId){
		return ig380BL.searchIG380InfoByPtid(processTemplateId);
	}
	
	/**
	 * 功能：根据流程定义ID获取流程定义
	 * @param pdid 流程定义ID
	 * @return 流程定义信息
	 * @throws BLException
	 */
	public IG380Info searchProcessDefinitionByKey(String pdid) throws BLException {
		return ig380BL.searchIG380InfoByKey(pdid);
	}
	/**
	 * 功能：根据流程组定义ID获取流程组定义
	 * @param pgdid 流程定义ID
	 * @return 流程组定义信息
	 * @throws BLException
	 */
	public IG480Info searchGroupProcessDefinitionByKey(String pgdid) throws BLException {
		return ig480BL.searchIG480ByPK(pgdid);
	}
	
	/**
	 * 功能：根据检索条件取得流程定义信息结果条数
	 * 
	 * @param cond 流程定义信息检索条件
	 * @return 流程定义信息结果条数
	 */
	public int getProcessDefinitionSearchCount(IG380SearchCond cond){
		return ig380BL.getIG380InfoSearchCount(cond);
	}
	
	/**
	 * 功能：根据检索条件取得流程定义信息列表
	 * 
	 * @param cond 流程定义检索条件
	 * @return 流程定义信息列表
	 */
	public List<IG380Info> searchProcessDefinition(IG380SearchCond cond){
		return ig380BL.searchIG380Info(cond);
	}
	/**
	 * 功能：根据检索条件取得流程组定义信息列表
	 * 
	 * @param cond 流程定义检索条件
	 * @return 流程定义信息列表
	 */
	public List<IG480Info> searchIG480ProcessDefinition(IG480SearchCond cond){
		return ig480BL.searchIG480(cond);
	}
	
	/**
	 * 功能：根据检索条件取得流程定义信息列表（分页查询使用）
	 * 
	 * @param cond 流程定义检索条件
	 * @param start 检索起始条数
	 * @param count 检索个数
	 * @return 流程定义信息列表
	 */
	public List<IG380Info> searchProcessDefinition(IG380SearchCond cond,int start,int count){
		return ig380BL.searchIG380Info(cond,start,count);
	}
	
	/**
	 * 功能：流程定义信息
	 * 
	 * @param processDefinition 流程定义信息
	 * @return 流程定义
	 * @throws BLException
	 */
	public IG380Info registProcessDefinition(IG380Info processDefinition) throws BLException{
		return ig380BL.registIG380Info(processDefinition);
	}
	/**
	 * 功能：删除流程定义信息
	 * 
	 * @param pdid 流程定义主键
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessDefinitionByKey(String pdid) throws BLException{
		ig380BL.deleteIG380InfoByKey(pdid);
	}
	/**
	 * 功能：更新流程定义信息
	 * 
	 * @param processDefinition 流程定义信息
	 * @return 流程定义
	 * @throws BLException
	 */
	public IG380Info updateProcessDefinition(IG380Info processDefinition) throws BLException{
		return ig380BL.updateIG380Info(processDefinition);
	}
	/**
	 * 功能：更新流程组定义信息
	 * 
	 * @param processDefinition 流程组定义信息
	 * @return 流程组定义
	 * @throws BLException
	 */
	public IG480Info updateGroupProcessDefinition(IG480Info processDefinition) throws BLException{
		return ig480BL.updateIG480(processDefinition);
	}
	
	/**
	 * 功能：根据检索条件取得历史流程定义信息结果条数
	 * 
	 * @param cond 流程定义信息检索条件
	 * @return 历史流程定义信息结果条数
	 */
	public int getProcessDefinitionSearchHistoryCount(IG380SearchCond cond){
		return ig380BL.getIG380InfoSearchHistoryCount(cond);
	}
	
	/**
	 * 功能：根据检索条件取得历史流程定义信息列表（分页查询使用）
	 * 
	 * @param cond 流程定义检索条件
	 * @param start 检索起始条数
	 * @param count 检索个数
	 * @return 历史流程定义信息列表
	 */
	public List<IG380Info> searchHistoryProcessDefinition(IG380SearchCond cond,int start,int count) throws BLException {
		return ig380BL.searchHistoryIG380Info(cond, start, count);
	}
	
	/**
	 * 流程定义主键值取得
	 * @param firstsite 主键首位标识
	 * @param pdsequence 序列名称
	 * @return PDID主键值
	 */
	public String getProcessDefinitionPK(String firstsite,String pdsequence) {
		String pdid = ig380BL.getPdidNextValue(firstsite,pdsequence);
		while(true) {
			IG380SearchCondImpl cond_IG380 = new IG380SearchCondImpl();
			cond_IG380.setPdid_like(pdid.substring(0, 5));
			List<IG380Info> lst_IG380 = searchProcessDefinition(cond_IG380);
			if(lst_IG380.isEmpty()) {
				break;
			}
			pdid = getProcessDefinitionPK(firstsite,pdsequence);
		}
		return pdid;
	}
	/**
	 * 流程组定义主键值取得
	 * @param firstsite 主键首位标识
	 * @param pdsequence 序列名称
	 * @return PDID主键值
	 */
	public String getIG480ProcessDefinitionPK(String firstsite,String pdsequence) {
		String pgdid = ig480BL.getPdidNextValue(firstsite,pdsequence);
		while(true) {
			IG480SearchCondImpl cond_IG480 = new IG480SearchCondImpl();
			cond_IG480.setPgdid_like(pgdid.substring(0, 5));
			List<IG480Info> lst_IG480 = searchIG480ProcessDefinition(cond_IG480);
			if(lst_IG480.isEmpty()) {
				break;
			}
			pgdid = getProcessDefinitionPK(firstsite,pdsequence);
		}
		return pgdid;
	}
	
	/**
	 * 根据检索条件取得流程定义最新信息结果条数
	 * 
	 * @param cond 流程定义信息检索条件
	 * @return 流程定义信息结果条数
	 */
	public int getProcessDefinitionSearchLastCount(IG380SearchCond cond){
		return ig380BL.getIG380InfoSearchLastCount(cond);
	}
	
	/**
	 * 根据检索条件取得流程定义最新信息列表
	 * 
	 * @param cond 流程定义检索条件
	 * @return 流程定义信息列表
	 */
	public List<IG380Info> searchLastProcessDefinition(IG380SearchCond cond, int start, int count){
		return ig380BL.searchLastIG380Info(cond, start, count);
	}
	
	/**
	 * 根据检索条件取得相关发起的自定义流程类型的信息
	 * 
	 * @param cond 流程定义检索条件
	 * @return 流程定义信息列表
	 */
	public List<IG913Info> searchLastIG380AndIG911Info(IG913SearchCond cond){
		return ig380BL.searchLastIG380AndIG911Info(cond);
	}
	
	/**
     * 根据检索条件取得缺省权限的相关发起的自定义流程类型的信息
     * 
     * @param cond 流程定义检索条件
     * @return 流程定义信息列表
     */
    public List<IG913Info> searchLastIG380AndIG931Info(IG913SearchCond cond){
    	return ig380BL.searchLastIG380AndIG931Info(cond);
    }
    
	/**
	 * 流程定义不存在检查
	 * 
	 * @param ptid 流程模板ID
	 * @param pdname 流程定义名称
	 * @return
	 * @throws BLException 
	 */
	public void checkNotExistProcessDefinition(Integer ptid, String pdname) throws BLException{
		ig380BL.checkNotExistIG380Info(ptid, pdname);
	}
	
	/**
	 * 流程定义升版处理
	 * 
	 * @param pdid 流程定义ID
	 */
	public void upgradeProcessDefVersion(String pdid) throws BLException{
		String newPdid = ig380BL.upgradeProcessDefVersion(pdid);
		copyStatusFormDefinition(pdid,newPdid);
	}
	/**
	 * 流程组定义升版处理存储过程
	 * 
	 * @param pdid 流程定义ID
	 */
	public void upgradeGroupProcessDefVersion(String pgdid) throws BLException{
		ig480BL.upgradeGroupProcessDefVersion(pgdid);
	}
	
	/**
	 * 流程定义复制处理
	 * 
	 * @param pdid 流程定义ID
	 */
	public String copyProcessDefVersion(String pdid) throws BLException{
		IG380Info pd = searchProcessDefinitionByKey(pdid);
		IG259Info pt = searchProcessTemplateByKey(pd.getPtid());
		String newPdid = ig380BL.copyProcessDefVersion(pdid,pt.getPdsequence());
		copyStatusFormDefinition(pdid,newPdid);
		return newPdid;
	}
	
	private void copyStatusFormDefinition(String pdid, String newPdid) throws BLException {
		//查询状态及表单定义
		IG560SearchCondImpl cond = new IG560SearchCondImpl();
		cond.setPidid_l(pdid);
		List<IG560Info> list = ig560BL.searchIG560(cond);
		for(IG560Info info:list){
			IG560TB tb = new IG560TB();
			tb.setPidid(info.getPidid().replace(pdid, newPdid));
			tb.setPsdid(info.getPsdid().replace(pdid, newPdid));
			tb.setDfvalue(info.getDfvalue());
			tb.setUsedtoall(info.getUsedtoall());
			ig560BL.registIG560(tb);
		}
	}

	/**
	 * 流程组定义复制处理
	 * 
	 * @param pgdid 流程组定义ID
	 */
	public String copyGroupProcessDefVersion(String pgdid) throws BLException{
		IG480Info pd = searchGroupProcessDefinitionByKey(pgdid);
		IG259Info pt = searchProcessTemplateByKey(pd.getPtid());
		return ig480BL.copyGroupProcessDefVersion(pgdid,pt.getPdsequence());
	}
	
	/**
	 * 功能：根据流程定义ID获取流程变量定义集合
	 * @param processDefinitionId 流程定义ID
	 * @return  流程变量定义集合
	 */
	
	public List<IG007Info> searchProcessInfoDefsByPdid(String processDefinitionId){
		return ig007BL.searchIG007InfoByPdid(processDefinitionId);
	}
	/**
	 * 功能：根据流程定义ID获取流程变量定义集合，不包括缺省变量（平台保留）
	 * @param processDefinitionId 流程定义ID
	 * @return  流程变量定义集合
	 */
	
	public List<IG007Info> searchProcessInfoDefsNoDefault(String processDefinitionId){
		return ig007BL.searchIG007InfoNoDefault(processDefinitionId);
	}
	
	/**
	 * 运行状态检索表单定义
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public List<IG007Info> searchIG007InfoRun(IG007SearchCond cond){
		return ig007BL.searchIG007InfoRun(cond);
	}
	/**
	 * 功能：流程变量定义条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getProcessInfoDefSearchCount(IG007SearchCond cond){
		return ig007BL.getIG007InfoSearchCount(cond);
	}
	/**
	 * 功能：流程变量定义条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG007Info> searchProcessInfoDef(IG007SearchCond cond){
		return ig007BL.searchIG007Info(cond);
	}
	
	/**
	 * 功能：流程变量定义条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG007Info> searchProcessInfoDef(IG007SearchCond cond, int start, int count){
		return ig007BL.searchIG007Info(cond, start, count);
	}
	/**
	 * 功能：根据流程变量定义ID获取流程变量定义信息
	 * 
	 * @param pidid 流程变量定义ID
	 * @return 流程变量定义信息
	 * @throws BLException 
	 */
	public IG007Info searchProcessInfoDefByKey(String pidid) throws BLException {
		return ig007BL.searchIG007InfoByKey(pidid);
	}
	
	/**
	 * 功能：流程变量定义信息登录处理
	 * 
	 * @param processInfoDef 登录数据
	 * @return 流程变量定义信息
	 * @throws BLException
	 */
	public IG007Info registProcessInfoDef(IG007Info processInfoDef) throws BLException{
		return ig007BL.registIG007Info(processInfoDef);
	}
	
	/**
	 * 功能：流程变量定义信息更新处理
	 * 
	 * @param processInfoDef 更新数据
	 * @return 流程变量定义信息
	 * @throws BLException
	 */
	public IG007Info updateProcessInfoDef(IG007Info processInfoDef) throws BLException{
		return ig007BL.updateIG007Info(processInfoDef);
	}
	
	/**
	 * 功能：流程变量定义信息删除处理
	 * 
	 * @param pidid 删除全局变量主键
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessInfoDefByKey(String pidid) throws BLException{
		ig007BL.deleteIG007InfoByKey(pidid);
	}
	
	/**
	 * 功能：流程变量定义信息删除处理
	 * 
	 * @param processInfoDef 流程变量定义
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessInfoDef(IG007Info processInfoDef) throws BLException{
		ig007BL.deleteIG007Info(processInfoDef);
	}
	
	/**
	 * 功能：获取流程变量缺省审批人
	 * @param pdid 流程定义ID
	 * @return  Map<String,List<IG337Info>> 流程变量缺省审批人
	 */
	
	public Map<String,List<IG337Info>> getDefaultApprovors(String pdid){
		return ig007BL.getDefaultApprovors(pdid);
	}
	
	/**
	 * 表单定义主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PIDID主键值
	 */
	public String getProcessInfoDefPK(String pdid){
		return ig007BL.getPididSequenceNextValue(pdid);
	}
	
	/**
	 * 功能：获取流程变量缺省审批分派人(ppcomment获取之后不用要清空)
	 * @param pdid 流程定义ID
	 * @return  List<IG337Info> 流程变量缺省审批分派人
	 */
	public List<IG337Info> searchDefaultApprovorDispatcherByPdid(String pdid){
		return ig007BL.searchDefaultApprovorDispatcherByPdid(pdid);
	}
	
	/**
	 * 功能：条件检索处理
	 * 
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<IG105Info> searchProcessStrategyDef(IG105SearchCond cond) {
		return ig105BL.searchIG105Info(cond);
	}
	
	/**
	 * 查询角色配置
	 * @param cond 查询条件
	 * @return 角色配置信息集合
	 * @throws BLException
	 */
	public List<IG001Info> searchOARoleConfig(IG001SearchCond cond) throws BLException {
		return ig001BL.searchIG001(cond);
	}
	
	/**
	 * 删除角色配置
	 * @param entity 角色配置信息
	 * @throws BLException
	 */
	public void deleteOARoleConfig(IG001Info entity) throws BLException {
		ig001BL.deleteIG001(entity);
	}
	
	/**
	 * 删除角色配置
	 * @param entity 角色配置信息
	 * @throws BLException
	 */
	public void deleteOARoleConfig(List<IG001Info> entitys) throws BLException{
		ig001BL.deleteIG001(entitys);
	}
	
	/**
	 * 注册角色配置
	 * @param entity 角色配置信息
	 * @return 角色配置信息
	 * @throws BLException
	 */
	public IG001Info registOARoleConfig(IG001Info entity) throws BLException {
		return ig001BL.registIG001(entity);
	}
	
	/**
	 * 根据类型查询配置角色主键
	 * @param type 类型
	 * @return
	 * @throws BLException
	 */
	public List<Integer> searchOARoleidByType(String type) throws BLException {
		List<Integer> roles = null;
		IG001SearchCondImpl cond = new IG001SearchCondImpl();
		cond.setProtype_eq(type);
		List<IG001Info> list = ig001BL.searchIG001(cond);
		if(list!=null){
			for(IG001Info pro:list){
				if(roles == null){
					roles = new ArrayList<Integer>();
				}
				roles.add(pro.getProroleid());
			}
		}
		return roles;
	}
	
	/**
	 * 角色授权表单检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG701Info> searchRoleForm(IG701SearchCond cond){
		return ig701BL.searchIg701(cond);
	}
	
	/**
	 * 注册角色授权表单
	 * @param entity 角色授权表单实体
	 * @return 角色授权表单实体
	 * @throws BLException
	 */
	public IG701Info registRoleForm(IG701Info entity) throws BLException {
		return ig701BL.registIg701(entity);
	}
	
	/**
	 * 根据主键删除角色授权表单
	 * @param pk
	 * @throws BLException
	 */
	public void deleteRoleForm(IG701PK pk) throws BLException {
		ig701BL.deleteIg701ByPK(pk);
	}
	
	/**
	 * 事件处理检索
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public List<IG413Info> searchWorkFlowEventHandler(IG413SearchCond cond){
		return ig413BL.searchIG413Info(cond);
	}
	
	/**
	 * 事件处理主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PEDID主键值
	 */
	public String getWorkFlowEventHandlerPK(String psdid){
		return ig413BL.getPedidSequenceNextValue(psdid);
	}
	
	/**
	 * 注册事件处理
	 * @param entity 事件处理实体
	 * @return 事件处理实体
	 * @throws BLException
	 */
	public IG413Info registWorkFlowEventHandler(IG413Info entity) throws BLException{
		return ig413BL.registIG413Info(entity);
	}
	
	/**
	 * 更新事件处理
	 * @param entity 事件处理实体
	 * @return 事件处理实体
	 * @throws BLException
	 */
	public IG413Info updateWorkFlowEventHandler(IG413Info entity) throws BLException{
		return ig413BL.updateIG413Info(entity);
	}
	
	/**
	 * 根据主键删除事件处理
	 * @param key 事件处理主键
	 * @throws BLException
	 */
	public void deleteWorkFlowEventHandlerByKey(String key) throws BLException{
		ig413BL.deleteIG413Info(key);
	}
	
	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getProcessStatusDefSearchCount(IG333SearchCond cond) throws BLException{
		return ig333BL.getIG333InfoSearchCount(cond);
	}
	
	/**
	 * 状态信息检索
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public List<IG333Info> searchProcessStatusDef(IG333SearchCond cond) {
		return ig333BL.searchIG333Info(cond);
	}
	
	/**
	 * 可被分派节点检索
	 * @param psdid 分派节点定义id
	 * @param pbdid 操作按钮
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG333Info> searchAssignedStatusDef(String psdid,String pbdid) throws BLException{
		return ig333BL.searchAssignedStatusDef(psdid, pbdid);
	}
	
	/**
	 * 主键检索状态定义
	 * @param psdid 主键
	 * @return 状态定义信息
	 * @throws BLException
	 */
	public IG333Info searchProcessStatusDefByKey(String psdid) throws BLException{
		return ig333BL.searchIG333InfoByKey(psdid);
	}
	
	/**
	 * 指定状态关联的可调整参与者的状态集合取得
	 * @param psdid 状态ID
	 * @return 状态集合
	 */
	public List<IG333Info> searchAdjustStatus(String psdid){
		return ig333BL.searchAdjustStatus(psdid);
	}
	
	/**
	 * 功能：根据状态code获取指定流程类型的状态ID
	 * @param pdid 流程定义ID
	 * @param psdcode 流程状态标识
	 * @return 流程状态ID
	 * @throws BLException 
	 */
	public String searchProcessStatusKey(String pdid,String psdcode) throws BLException{
		return ig333BL.getIG333InfoIdByStatus(pdid, psdcode);
	}
	
	/**
	 * 新增流程状态定义
	 * @param entity 流程状态定义实体
	 * @return 流程状态定义实体
	 * @throws BLException
	 */
	public IG333Info registProcessStatus(IG333Info entity) throws BLException {
		return ig333BL.registIG333Info(entity);
	}
	
	/**
	 * 流程状态定义主键值取得
	 * 
	 * @param 流程定义ID
	 * @return 流程状态定义主键值
	 */
	public String getProcessStatusDefPK(String pdid_one) {
		return ig333BL.getPsdidSequenceNextValue(pdid_one);
	}
	
	/**
	 * 根据主键删除状态定义
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteProcessStatusDefByPK(String pk) throws BLException {
		ig333BL.deleteIG333InfoByKey(pk);
	}
	
	/**
	 * 更新流程状态定义
	 * @param entity 流程状态定义实体
	 * @return 流程状态定义实体
	 * @throws BLException
	 */
	public IG333Info updateProcessStatus(IG333Info entity) throws BLException {
		return ig333BL.updateIG333Info(entity);
	}
	
	/**
	 * 功能：获取指定用户具有的发起流程的角色
	 * @param userid 用户ID
	 * @param pdid 流程定义ID
	 * @return 发起角色下拉列表
	 */
	public List<LabelValueBean> searchInitProcessParticipantRole(String userid,String pdid){
		return ig222BL.searchInitProcessParticipantRole(userid, pdid);
	}
	
	/**
	 * 参与者可视按钮查询
	 * @param psdid 状态ID
	 * @param roleid 角色ID
	 * @return 可视按钮列表
	 */
	public List<IG309Info> searchVisibleButton(String psdid, Integer roleid){
		return ig222BL.searchVisibleButton(psdid, roleid);
	}
	
	/**
	 * 参与人定义检索
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public List<IG222Info> searchParticipantDef(IG222SearchCond cond){
		return ig222BL.searchIG222Info(cond);
	}
	
	/**
	 * 根据主键查询参与人定义信息
	 * @param pk 主键
	 * @return 参与人定义信息
	 * @throws BLException
	 */
	public IG222Info searchParticipantDefByKey(String pk) throws BLException{
		return ig222BL.searchIG222InfoByKey(pk);
	}
	
	/**
	 * 参与人定义主键值取得
	 * 
	 * @param 流程状态ID
	 * @return 参与人定义主键值
	 */
	public String getParticipantDefPK(String pdid_one) throws BLException {
		return ig222BL.getPpdidSequenceNextValue(pdid_one);
	}
	
	/**
	 * 新增参与人定义信息
	 * @param entity 参与人定义实体
	 * @return 参与人定义实体
	 * @throws BLException
	 */
	public IG222Info registParticipantDef(IG222Info entity) throws BLException {
		return ig222BL.registIG222Info(entity);
	}
	
	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getParticipantSearchCount(IG222SearchCond cond) throws BLException {
		return ig222BL.getIG222InfoSearchCount(cond);
	}
	
	/**
	 * 删除参与人定义信息
	 * @param entity 参与人定义信息
	 * @throws BLException
	 */
	public IG222Info deleteParticipantDefByKey(String pk) throws BLException{
		return ig222BL.deleteIG222Info(pk);
	}
	
	/**
	 * 更新参与人定义信息
	 * @param entity 参与人定义信息
	 * @return 参与人定义信息
	 * @throws BLException
	 */
	public IG222Info updateParticipantDef(IG222Info entity) throws BLException {
		return ig222BL.updateIG222Info(entity);
	}
	
	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getParticipantDefSearchCount(IG222SearchCond cond) throws BLException {
		return ig222BL.getIG222InfoSearchCount(cond);
	}
	
	/**
	 * 同角色所有人提交跃迁按钮查询（普通权限）
	 * 
	 * @param psdid 状态ID
	 * @return 按钮列表
	 */
	public Map<String, String> searchRoleCommitNormalAuth(String psdid){
		return ig222BL.searchRoleCommitNormalAuth(psdid);
	}
	
	/**
	 * 同角色所有人提交跃迁按钮查询（缺省权限）
	 * 
	 * @param psdid 状态ID
	 * @return 按钮列表
	 */
	public List<String> searchRoleCommitDefaultAuth(String psdid){
		return ig222BL.searchRoleCommitDefaultAuth(psdid);
	}
	
	/**
	 * 表单初始化事件检索
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public List<IG373Info> searchInitFormEventHandler(IG373SearchCond cond){
		return ig373BL.searchIG373Info(cond);
	}
	
	/**
	 * 表单初始化事件主键值取得
	 * @param 流程状态ID
	 * @return 表单初始化事件主键值
	 */
	public String getInitFormEventHandlerPK(String psdid) throws BLException {
		return ig373BL.getPiididSequenceNextValue(psdid);
	}
	
	/**
	 * 注册表单初始化事件
	 * @param entity 表单初始化事件实体
	 * @return 表单初始化事件实体
	 * @throws BLException
	 */
	public IG373Info registInitFormEventHandler(IG373Info entity) throws BLException {
		return ig373BL.registIG373Info(entity);
	}
	
	/**
	 * 更新表单初始化事件
	 * @param entity 表单初始化事件实体
	 * @return 表单初始化事件实体
	 * @throws BLException
	 */
	public IG373Info updateInitFormEventHandler(IG373Info entity) throws BLException {
		return ig373BL.updateIG373Info(entity);
	}
	
	/**
	 * 主键检索表单初始化事件
	 * @param pk 主键
	 * @return 表单初始化事件实体
	 * @throws BLException
	 */
	public IG373Info searchInitFormEventHandlerByKey(String pk) throws BLException {
		return ig373BL.searchIG373InfoByPK(pk);
	}
	
	/**
	 * 根据主键删除表单初始化事件
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteInitFormEventHandlerByKey(String pk) throws BLException {
		ig373BL.deleteIG373InfoByPK(pk);
	}
	
	/**
	 * 流程标题定义检索
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public List<IG243Info> searchProcessTitleDef(IG243SearchCond cond){
		return ig243BL.searchIG243Info(cond);
	}
	
	/**
	 * 流程标题定义主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PTDID主键值
	 */
	public String getProcessTitleDefPK(String pdid_one){
		return ig243BL.getPtdidSequenceNextValue(pdid_one);
	}
	
	/**
	 * 新增流程标题定义
	 * @param entity 流程标题定义实体
	 * @return 流程标题定义实体
	 * @throws BLException
	 */
	public IG243Info registProcessTitleDef(IG243Info entity) throws BLException {
		return ig243BL.registIG243Info(entity);
	}
	
	/**
	 * 主键查询流程标题定义
	 * @param pk 主键
	 * @return 流程标题定义实体
	 * @throws BLException
	 */
	public IG243Info searchProcessTitleDefByPK(String pk) throws BLException {
		return ig243BL.searchIG243InfoByPK(pk);
	}
	
	/**
	 * 更新流程标题定义
	 * @param entity 流程标题定义实体
	 * @return 流程标题定义实体
	 * @throws BLException
	 */
	public IG243Info updateProcessTitleDef(IG243Info entity) throws BLException {
		return ig243BL.updateIG243Info(entity);
	}
	
	/**
	 * 根据状态主键查询可被分派参与者(角色)
	 * @param psdid 状态主键
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG298Info> searchProcessStatusRoleDefInfoByPsdid(String psdid) throws BLException{
		return ig298BL.searchIG298Info(psdid);
	}
	
	/**
	 * 可被分派参与者(角色)实例存在检测
	 * @param psdid 状态ID
	 * @param roleid 角色ID
	 * @return 实例
	 * @throws BLException
	 */
	public IG298Info checkProcessStatusRoleDefInfo(String psdid, Integer roleid) throws BLException{
		return ig298BL.checkIG298Info(psdid, roleid);
	}
	
	/**
	 * 可被分派参与者(角色)主键值取得
	 * @param psdid 流程状态ID
	 * @return 可被分派参与者(角色)主键值
	 */
	public String getProcessStatusRoleDefInfoPK(String psdid) throws BLException {
		return ig298BL.getPsrdidSequenceNextValue(psdid);
	}
	
	/**
	 * 注册可被分派参与者(角色)
	 * @param entity 可被分派参与者(角色)实体
	 * @return 可被分派参与者(角色)实体
	 * @throws BLException
	 */
	public IG298Info registProcessStatusRoleDefInfo(IG298Info entity) throws BLException {
		return ig298BL.registIG298Info(entity);
	}
	
	/**
	 * 删除可被分派参与者(角色)
	 * @param entity 可被分派参与者(角色)实体
	 * @throws BLException
	 */
	public void deleteProcessStatusRoleDefInfoByKey(String pk) throws BLException {
		ig298BL.deleteIG298InfoByPK(pk);
	}
	
	/**
	 * 可被分派的角色检索处理
	 * @param pdid 流程定义ID
	 * @param psdid 流程状态ID
	 * @return 可被分派的角色列表
	 */
	public List<Role> searchToBeAssignRole(String pdid, String psdid) {
		return ig298BL.searchToBeAssignRole(pdid, psdid);
	}
	
	/**
	 * 根据状态主键查询可被分派参与者(机构)
	 * @param psdid 状态主键
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG299Info> searchProcessStatusOrgDefInfoByPsdid(String psdid) throws BLException{
		return ig299BL.searchIG299Info(psdid);
	}
	
	/**
	 * 可被分派的机构检索处理
	 * @param pdid 流程类型ID
	 * @param levellen 机构的当前级数
	 * @param psdid 流程状态节点ID
	 * @return 可被分派的机构列表
	 */
	public List<Organization> searchToBeAssignOrg(String pdid, int levellen, String psdid) {
		return ig299BL.searchToBeAssignOrg(pdid, levellen, psdid);
	}
	
	/**
	 * 可被分派的机构主键值取得
	 * @param 流程状态ID
	 * @return 可被分派的机构主键值
	 */
	public String getProcessStatusOrgDefInfoPK(String psdid) throws BLException {
		return ig299BL.getPsrdidSequenceNextValue(psdid);
	}
	
	/**
	 * 注册可被分派的机构
	 * @param entity 可被分派的机构实体
	 * @return 可被分派的机构实体
	 * @throws BLException
	 */
	public IG299Info registProcessStatusOrgDefInfo(IG299Info entity) throws BLException {
		return ig299BL.registIG299(entity);
	}
	
	/**
	 * 根据主键删除可被分派的机构
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteProcessStatusOrgDefInfoByKey(String pk) throws BLException {
		ig299BL.deleteIG299ByPK(pk);
	}
	
	/**
	 * 角色范围检索
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public List<IG213Info> searchProcessRoleTypeDef(IG213SearchCond cond) {
		return ig213BL.searchIG213Info(cond);
	}
	
	/**
	 * 角色范围主键值取得
	 * @param 流程定义ID
	 * @return 角色范围主键值
	 */
	public String getProcessRoleTypeDefPK(String pdid_one) throws BLException {
		return ig213BL.getPrtdidSequenceNextValue(pdid_one);
	}
	
	/**
	 * 注册角色范围信息
	 * @param entity 角色范围信息实体
	 * @return 角色范围信息实体
	 * @throws BLException
	 */
	public IG213Info registProcessRoleTypeDef(IG213Info entity) throws BLException {
		return ig213BL.registIG213Info(entity);
	}
	
	/**
	 * 根据主键删除角色范围信息
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteProcessRoleTypeDefByKey(String pk) throws BLException {
		ig213BL.deleteIG213InfoByKey(pk);
	}
	
	/**
     * 相关发起流程状态为启用状态的状态参与者相关发起信息条数取得
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public int getIg911RelevantPdidCount(IG911SearchCond cond) {
    	return ig911BL.getIg911RelevantPdidCount(cond);
    }
    
	/**
	 * 相关发起流程状态为启用状态的状态参与者相关发起信息取得
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG911Info> searchIg911RelevantPdid(IG911SearchCond cond) {
	    return ig911BL.searchIg911RelevantPdid(cond);
	}
	
	/**
     * 状态参与者关联流程类型定义主键值取得
     * @param 流程状态ID
     * @return 状态参与者关联流程类型定义主键值
     */
	public String getParticipantRelevantDefPK(String psdid) throws BLException {
		return ig911BL.getPsprpidSequenceNextValue(psdid);
	}
	
	/**
	 * 注册状态参与者关联流程类型定义
	 * @param entity 状态参与者关联流程类型定义实体
	 * @return 状态参与者关联流程类型定义实体
	 * @throws BLException
	 */
	public IG911Info registParticipantRelevantDefInfo(IG911Info entity) throws BLException {
		return ig911BL.registIG911Info(entity);
	}
	
	/**
	 * 根据主键删除状态参与者关联流程类型定义
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteParticipantRelevantDefInfoByKey(String pk) throws BLException {
		ig911BL.deleteIG911InfoByPK(pk);
	}
	
	/**
	 * 相关发起可发起流程的流程定义信息取得（根据IG911关联取得IG380的信息）
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG380Info> searchIg380ByIg911Cond(IG911SearchCond cond){
		return ig911BL.searchIg380ByIg911Cond(cond);
	}
	
    /**
     * 相关发起流程状态为启用状态的默认权限的相关发起信息条数取得
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public int getIg931RelevantPdidCount(IG931SearchCond cond) {
        return ig931BL.getIg931RelevantPdidCount(cond);
    }
    
	/**
     * 相关发起流程状态为启用状态的默认权限的相关发起信息取得
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public List<IG931Info> searchIg931RelevantPdid(IG931SearchCond cond) {
        return ig931BL.searchIg931RelevantPdid(cond);
    }
    
	/**
     * 缺省状态参与者关联流程类型定义主键值取得
     * @param 流程状态ID
     * @return 缺省状态参与者关联流程类型定义主键值
     */
    public String getDefaultParticipantRelevantDefPK(String psdid) throws BLException {
    	return ig931BL.getDpsprpidSequenceNextValue(psdid);
    }
    
    /**
     * 注册缺省状态参与者关联流程类型定义
     * @param entity 缺省状态参与者关联流程类型定义实体
     * @return 缺省状态参与者关联流程类型定义实体
     * @throws BLException
     */
    public IG931Info registDefaultParticipantRelevantDefInfo(IG931Info entity) throws BLException {
    	return ig931BL.registIG931Info(entity);
    }
    
    /**
     * 根据主键删除缺省状态参与者关联流程类型定义
     * @param pk 主键
     * @throws BLException
     */
    public void deleteDefaultParticipantRelevantDefInfoByKey(String pk) throws BLException {
    	ig931BL.deleteIG931InfoByPK(pk);
    }
    
    /**
     * 相关发起可发起流程的流程定义信息取得（根据IG931关联取得IG380的信息）
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public List<IG380Info> searchIg380ByIg931Cond(IG931SearchCond cond){
    	return ig931BL.searchIg380ByIg931Cond(cond);
    }
    
    /**
     * 根据流程定义主键检索机构范围
     * @param pdid 流程定义主键
     * @return 检索结果
     */
    public List<IG123Info> searchProcessOrgScopeByPdid(String pdid){
    	return ig123BL.findBypdid(pdid);
    }
    
	/**
	 * 机构范围主键值取得
	 * 
	 * @param 流程定义ID
	 * @return 机构范围主键值
	 */
    public String getProcessOrgScopePK(String pdid_one) throws BLException{
    	return ig123BL.getPotdidSequenceNextValue(pdid_one);
    }
    
    /**
     * 注册机构范围
     * @param entity 机构范围实体
     * @return 机构范围实体
     * @throws BLException
     */
    public IG123Info registProcessOrgScope(IG123Info entity) throws BLException {
    	return ig123BL.registIG123(entity);
    }
 
    /**
     * 删除机构范围
     * @param entity 机构范围实体
     * @throws BLException
     */
    public void deleteProcessOrgScope(List<IG123Info> entitys) throws BLException {
    	ig123BL.deleteIG123List(entitys);
    }
    
    /**
     * 流程状态按钮定义检索
     * @param cond 检索条件
     * @return 流程状态按钮定义信息集合
     * @throws BLException
     */
    public List<IG156Info> searchProcessStatusButtonDef(IG156SearchCond cond) throws BLException{
    	return ig156BL.searchIG156Info(cond);
    }
    
    /**
     * 主键检索流程状态按钮定义
     * @param pk 主键
     * @return 流程状态按钮定义信息
     * @throws BLException
     */
    public IG156Info searchProcessStatusButtonDefByKey(String pk) throws BLException {
    	return ig156BL.searchIG156InfoByPK(pk);
    }
    
	/**
	 * 状态按钮定义主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PEDID主键值
	 */
	public String getProcessStatusButtonDefPK(String psdid) {
		return ig156BL.getPedidSequenceNextValue(psdid);
	}
	
	/**
	 * 注册状态按钮定义
	 * @param entity 状态按钮定义实体
	 * @return 状态按钮定义实体
	 * @throws BLException
	 */
	public IG156Info registProcessStatusButtonDef(IG156Info entity) throws BLException {
		return ig156BL.registIG156Info(entity);
	}
	
	/**
	 * 更新状态按钮定义
	 * @param entity 状态按钮定义实体
	 * @return 状态按钮定义实体
	 * @throws BLException
	 */
	public IG156Info updateProcessStatusButtonDef(IG156Info entity) throws BLException {
		return ig156BL.updateIG156Info(entity);
	}
	
	/**
	 * 根据主键删除状态按钮定义
	 * @param entity 状态按钮定义实体
	 * @throws BLException
	 */
	public void deleteProcessStatusButtonDefByPK(String pk) throws BLException {
		ig156BL.deleteIG156InfoByPK(pk);
	}
	
	/**
	 * 表单联动定义信息检索
	 * @param cond 检索条件 
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG286Info> searchProcessLinkageDef(IG286SearchCond cond) throws BLException {
		return ig286BL.searchIG286Info(cond);
	}
	
	/**
	 * 表单联动定义信息主键值取得
	 * @param 流程定义ID
	 * @return 表单联动定义信息主键值
	 */
	public String getProcessLinkageDefPK(String pdid_one) throws BLException {
		return ig286BL.getPlidSequenceNextValue(pdid_one);
	}
	
	/**
	 * 注册表单联动定义信息
	 * @param entity 表单联动定义信息实体
	 * @return 表单联动定义信息实体
	 * @throws BLException
	 */
	public IG286Info registProcessLinkageDef(IG286Info entity) throws BLException {
		return ig286BL.insertIG286Info(entity);
	}
	
	/**
	 * 删除表单联动定义信息
	 * @param entity 表单联动定义信息实体
	 * @return 表单联动定义信息实体
	 * @throws BLException
	 */
	public void deleteProcessLinkageDef(IG286Info entity) throws BLException {
		ig286BL.deleteIG286Info(entity);
	}
	
	/**
	 * 主键检索表单联动定义信息
	 * @param pk 主键
	 * @return 表单联动定义信息
	 * @throws BLException
	 */
	public IG286Info searchProcessLinkageDefByKey(String pk) throws BLException {
		return ig286BL.searchIG286InfoByPk(pk);
	}
	
	/**
	 * 参与人按钮定义检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG132Info> searchParticipantButtonDef(IG132SearchCond cond) throws BLException {
		return ig132BL.searchIG132Info(cond);
	}
	
	/**
	 * 主键检索参与人按钮定义
	 * @param pk 主键
	 * @return 参与人按钮定义信息
	 * @throws BLException
	 */
	public IG132Info searchParticipantButtonDefByKey(String pk) throws BLException {
		return ig132BL.searchIG132InfoByPK(pk);
	}
	
	/**
	 * 参与人按钮定义主键值取得
	 * @param 流程定义ID
	 * @return 参与人按钮定义主键值
	 */
	public String getParticipantButtonDefPK(String pbdid) throws BLException {
		return ig132BL.getPpbdidSequenceNextValue(pbdid);
	}
	
	/**
	 * 注册参与人按钮定义信息 
	 * @param entity 参与人按钮定义信息实体
	 * @return 参与人按钮定义信息实体
	 * @throws BLException
	 */
	public IG132Info registParticipantButtonDef(IG132Info entity) throws BLException {
		return ig132BL.registIG132Info(entity);
	}
	
	/**
	 * 根据主键删除参与人按钮定义信息 
	 * @param entity 参与人按钮定义信息实体
	 * @throws BLException
	 */
	public void deleteParticipantButtonDefByKey(String pk) throws BLException {
		ig132BL.deleteIG132InfoByPK(pk);
	}
	
	/**
	 * 更新参与人按钮定义信息 
	 * @param entity 参与人按钮定义信息实体
	 * @return 参与人按钮定义信息实体
	 * @throws BLException
	 */
	public IG132Info updateParticipantButtonDef(IG132Info entity) throws BLException {
		return ig132BL.updateIG132Info(entity);
	}
	
	/**
	 * 参与人按钮定义视图检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG221Info> searchParticipantButtonVW(IG221SearchCond cond) throws BLException {
		return ig221BL.searchIG221Info(cond);
	}
	
	/**
	 * 缺省参与人按钮定义视图检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG221Info> searchDefaultParticipantButtonVW(IG221SearchCond cond) throws BLException {
		return ig221BL.searchIG221InfoVW(cond);
	}
	
	/**
	 * 流程参与者变量权限视图查询
	 * @param cond 查询条件
	 * @return 流程参与者变量权限
	 * @throws BLException 
	 */
	public List<IG100Info> searchProcessInfoParticipantDefVW(IG100SearchCond cond) throws BLException {
		return ig881BL.searchIG100Info(cond);
	}
	
	/**
	 * 主键检索参与人变量权限信息
	 * @param pk 主键
	 * @return 参与人变量权限信息
	 * @throws BLException
	 */
	public IG881Info searchProcessInfoParticipantDefByKey(String pk) throws BLException {
		return ig881BL.searchIG881InfoByKey(pk);
	}
	
	/**
	 * 参与人变量权限主键值取得
	 * @param 流程状态参与者定义ID
	 * @return 参与人变量权限主键值
	 */
	public String getProcessInfoParticipantDefPK(String ppdid) throws BLException {
		return ig881BL.getPipdidSequenceNextValue(ppdid);
	}
	
	/**
	 * 注册参与人变量权限
	 * @param entity 参与人变量权限实体
	 * @return 参与人变量权限实体
	 * @throws BLException
	 */
	public IG881Info registProcessInfoParticipantDef(IG881Info entity) throws BLException {
		return ig881BL.registIG881Info(entity);
	}
	
	/**
	 * 更新参与人变量权限
	 * @param entity 参与人变量权限实体
	 * @return 参与人变量权限实体
	 * @throws BLException
	 */
	public IG881Info updateProcessInfoParticipantDef(IG881Info entity) throws BLException {
		return ig881BL.updateIG881Info(entity);
	}
	
	/**
	 * 跃迁规则检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG273Info> searchProcessTransitionDef(IG273SearchCond cond) throws BLException {
		return ig273BL.searchIG273Info(cond);
	}
	
	/**
	 * 跃迁规则主键值取得
	 * @param 流程状态ID
	 * @return 跃迁规则主键值
	 */
	public String getProcessTransitionDefPK(String psdid) throws BLException {
		return ig273BL.getPtdidSequenceNextValue(psdid);
	}
	
	/**
	 * 注册跃迁规则
	 * @param entity 跃迁规则实体
	 * @return 跃迁规则实体
	 * @throws BLException
	 */
	public IG273Info registProcessTransitionDef(IG273Info entity) throws BLException {
		return ig273BL.registIG273Info(entity);
	}
	
	/**
	 * 更新跃迁规则
	 * @param entity 跃迁规则实体
	 * @return 跃迁规则实体
	 * @throws BLException
	 */
	public IG273Info updateProcessTransitionDef(IG273Info entity) throws BLException {
		return ig273BL.updateIG273Info(entity);
	}
	
	/**
	 * 根据主键删除跃迁规则
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteProcessTransitionDefByKey(String pk) throws BLException {
		ig273BL.deleteIG273InfoByKey(pk);
	}
	
	/**
	 * 缺省参与人按钮定义检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG725Info> searchParticipantDefaultButtonDef(IG725SearchCond cond) throws BLException {
		return ig725BL.searchIG725Info(cond);
	}
	
	/**
	 * 新增确认按钮处理
	 * @param psdid 流程状态ID
	 */
	public void registConfirmButton(String psdid) throws BLException {
		ig725BL.registConfirmButton(psdid);
	}
	
	/**
	 * 删除确认按钮处理
	 * @param psdid 流程状态ID
	 */
	public void deleteConfirmButton(String psdid) throws BLException {
		ig725BL.deleteConfirmButton(psdid);
	}
	
	/**
	 * 缺省参与人按钮定义主键值取得
	 * @param 流程定义ID
	 * @return 缺省参与人按钮定义主键值
	 */
	public String getParticipantDefaultButtonDefPK(String psdid) throws BLException {
		return ig725BL.getPdbdidSequenceNextValue(psdid);
	}
	
	/**
	 * 注册缺省参与人按钮定义
	 * @param entity 缺省参与人按钮定义实体
	 * @return 缺省参与人按钮定义实体
	 * @throws BLException
	 */
	public IG725Info registParticipantDefaultButtonDef(IG725Info entity) throws BLException {
		return ig725BL.registIG725Info(entity);
	}
	
	/**
	 * 更新缺省参与人按钮定义
	 * @param entity 缺省参与人按钮定义实体
	 * @return 缺省参与人按钮定义实体
	 * @throws BLException
	 */
	public IG725Info updateParticipantDefaultButtonDef(IG725Info entity) throws BLException {
		return ig725BL.updateIG725Info(entity);
	}
	
	/**
	 * 根据主键删除缺省参与人按钮定义
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteParticipantDefaultButtonDefByKey(String pk) throws BLException {
		ig725BL.deleteIG725InfoByPK(pk);
	}
	
	/**
	 * 根据主键删除缺省参与人按钮定义
	 * @param pk 主键
	 * @throws BLException
	 */
	public IG725Info searchParticipantDefaultButtonDefByKey(String pk) throws BLException {
		return ig725BL.searchIG725InfoByPK(pk);
	}
	
	/**
	 * 定制页面检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG126Info> searchProcessJspDef(IG126SearchCond cond) throws BLException {
		return ig126BL.searchIG126Info(cond);
	}
	
	/**
	 * 定制页面主键值取得
	 * @param 流程定义ID
	 * @return 定制页面主键值
	 */
	public String getProcessJspDefPK(String pdid) throws BLException {
		return ig126BL.getPjdidSequenceNextValue(pdid);
	}
	
	/**
	 * 注册定制页面
	 * @param entity 定制页面实体
	 * @return 定制页面实体
	 * @throws BLException
	 */
	public IG126Info registProcessJspDef(IG126Info entity) throws BLException {
		return ig126BL.registIG126Info(entity);
	}
	
	/**
	 * 更新定制页面
	 * @param entity 定制页面实体
	 * @return 定制页面实体
	 * @throws BLException
	 */
	public IG126Info updateProcessJspDef(IG126Info entity) throws BLException {
		return ig126BL.updateIG126Info(entity);
	}
	
	/**
	 * 主键检索定制页面
	 * @param pk 主键
	 * @return 定制页面实体
	 * @throws BLException
	 */
	public IG126Info searchProcessJspDefByKey(String pk) throws BLException {
		return ig126BL.searchIG126InfoByKey(pk);
	}
	
	/**
	 * 根据主键删除定制页面
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteProcessJspDefByKey(String pk) throws BLException {
		ig126BL.deleteIG126Info(pk);
	}
	
	/**
	 * 流程缺省变量权限视图查询
	 * @param cond 查询条件
	 * @return 流程缺省变量权限
	 * @throws BLException 
	 */
	public List<IG909Info> searchParticipantDefaultVariableVW(IG909SearchCond cond) throws BLException {
		return ig699BL.searchIG909Info(cond);
	}
	
	/**
	 * 流程缺省变量权限主键值取得
	 * 
	 * @param 流程状态ID
	 * @return 流程缺省变量权限主键值
	 */
	public String getParticipantDefaultVariablePK(String pdid) throws BLException {
		return ig699BL.getPdvidSequenceNextValue(pdid);
	}
	
	/**
	 * 注册流程缺省变量权限
	 * @param entity 流程缺省变量权限实体
	 * @return 流程缺省变量权限实体
	 * @throws BLException
	 */
	public IG699Info registParticipantDefaultVariable(IG699Info entity) throws BLException {
		return ig699BL.registIG699Info(entity);
	}
	
	/**
	 * 更新流程缺省变量权限
	 * @param entity 流程缺省变量权限实体
	 * @return 流程缺省变量权限实体
	 * @throws BLException
	 */
	public IG699Info updateParticipantDefaultVariable(IG699Info entity) throws BLException {
		return ig699BL.updateIG699Info(entity);
	}
	
	/**
	 * 主键检索流程缺省变量权限
	 * @param pk 主键
	 * @return 流程缺省变量权限实体
	 * @throws BLException
	 */
	public IG699Info searchParticipantDefaultVariableByKey(String pk) throws BLException {
		return ig699BL.searchIG699InfoByKey(pk);
	}
	
	/**
	 * 缺省变量权限检索
	 * @param cond 检索条件
	 * @return 缺省变量权限集合
	 * @throws BLException
	 */
	public List<IG699Info> searchParticipantDefaultVariable(IG699SearchCond cond) throws BLException {
		return ig699BL.searchIG699Info(cond);
	}
	
	/**
	 * 流程查看角色检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG700Info> searchProcessSeeRoleInfo(IG700SearchCond cond) throws BLException {
		return ig700BL.searchIg700(cond);
	}
	
	/**
	 * 注册流程查看角色
	 * @param entity 流程查看角色实体
	 * @return 流程查看角色实体
	 * @throws BLException
	 */
	public IG700Info registProcessSeeRoleInfo(IG700Info entity) throws BLException {
		return ig700BL.registIg700(entity);
	}
	
	/**
	 * 根据主键删除流程查看角色
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteProcessSeeRoleInfoByKey(IG700PK pk) throws BLException {
		ig700BL.deleteIg700ByPK(pk);
	}
	
	/**
	 * 流程共通变量检索结果件数
	 * @param cond 检索条件
	 * @return 检索件数
	 * @throws BLException
	 */
	public int getProcessInfoDefGeneralSearchCount(IG202SearchCond cond) throws BLException {
		return ig202BL.getIG202InfoSearchCount(cond);
	}
	
	/**
	 * 流程共通变量检索(分页用)
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 * @throws BLException
	 */
	public List<IG202Info> searchProcessInfoDefGeneral(IG202SearchCond cond,int start,int count) throws BLException {
		return ig202BL.searchIG202Info(cond, start, count);
	}
	
	/**
	 * 流程共通变量检索结果件数
	 * @param cond 检索条件
	 * @return 检索件数
	 * @throws BLException
	 */
	public int getProcessInfoDefGeneralVWSearchCount(IG202SearchCond cond) throws BLException {
		return ig202BL.searchIG202InfoCount(cond);
	}
	
	/**
	 * 流程共通变量检索(分页用)
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 * @throws BLException
	 */
	public List<IG202Info> searchProcessInfoDefGeneralVW(IG202SearchCond cond,int start,int count) throws BLException {
		return ig202BL.searchIG202InfoFromVW(cond, start, count);
	}
	
	/**
	 * 主键检索流程共通变量
	 * @param pk 主键
	 * @return 流程共通变量
	 * @throws BLException
	 */
	public IG202Info searchProcessInfoDefGeneralByKey(Integer pk) throws BLException {
		return ig202BL.findIG202InfoByPK(pk);
	}
	
	/**
	 * 注册流程共通变量
	 * @param entity 流程共通变量实体
	 * @return 流程统统变量实体
	 * @throws BLException
	 */
	public IG202Info registProcessInfoDefGeneral(IG202Info entity) throws BLException {
		return ig202BL.registIG202Info(entity);
	}
	
	/**
	 * 流程共通变量更新
	 * @param entity 流程共通变量实体
	 * @return 流程共通变量实体
	 * @throws BLException
	 */
	public IG202Info updateProcessInfoDefGeneral(IG202Info entity) throws BLException {
		return ig202BL.updateIG202Info(entity);
	}
	
	/**
	 * 根据主键删除流程共通变量
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteProcessInfoDefGeneralByKey(Integer pk) throws BLException {
		ig202BL.deleteIG202Info(pk);
	}
	
	/**
	 * 注册流程通知策略
	 * @param entity 流程通知策略实体
	 * @return 流程通知策略实体
	 * @throws BLException
	 */
	public IG212Info registProcessNoticeStrategyDefInfo(IG212Info entity) throws BLException {
		return ig212BL.registIG212Info(entity);
	}
	
	/**
	 * 流程通知策略查询
	 * @param pdid 流程定义ID
	 * @return 流程通知策略列表
	 */
	public List<IG238Info> searchProcessNoticeStrategyVWInfoByPdid(String pdid) throws BLException {
		return ig212BL.searchIG238Info(pdid);
	}
	
	/**
	 * 流程策略通知人检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG237Info> searchProcessNoticeStrategyUserInfo(IG237SearchCond cond) {
		return ig237BL.searchIG237Info(cond);
	}
	
	/**
	 * 删除流程策略通知人
	 * @param entity 流程策略通知人实体
	 * @throws BLException
	 */
	public void deleteProcessNoticeStrategyUserInfo(IG237Info entity) throws BLException {
		ig237BL.deleteIG237Info(entity);
	}
	
	/**
	 * 注册流程策略通知人
	 * @param entitys 流程策略通知人实体集合
	 * @throws BLException
	 */
	public void registProcessNoticeStrategyUserInfo(List<IG237Info> entitys) throws BLException {
		ig237BL.registAllIG237Info(entitys);
	}
	
	/**
	 * 主键检索流程外部调用定义
	 * @param pk 主键
	 * @return 流程外部调用定义实体
	 * @throws BLException
	 */
	public IG992Info searchProcessExternalDefInfoByKey(Integer pk) throws BLException {
		return ig992BL.searchIG992InfoByPK(pk);
	}
	
	/**
	 * 注册流程外部调用定义
	 * @param entity 流程外部调用定义实体
	 * @return 流程外部调用定义实体
	 * @throws BLException
	 */
	public IG992Info registProcessExternalDefInfo(IG992Info entity) throws BLException {
		return ig992BL.registIG992Info(entity);
	}
	
	/**
	 * 更新流程外部调用定义
	 * @param entity 流程外部调用定义实体
	 * @return 流程外部调用定义实体
	 * @throws BLException
	 */
	public IG992Info updateProcessExternalDefInfo(IG992Info entity) throws BLException {
		return ig992BL.updateIG992Info(entity);
	}
	
	/**
	 * 根据主键删除流程外部调用定义
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteProcessExternalDefInfoByKey(Integer pk) throws BLException {
		ig992BL.deleteIG992InfoByPK(pk);
	}
	
	/**
	 * 流程外部调用定义检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG992Info> searchProcessExternalDefInfo(IG992SearchCond cond) throws BLException {
		return ig992BL.searchIG992Info(cond);
	}
	
	/**
	 * 流程状态参与者调整检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG258Info> searchProcessStatusPrtChangeDefInfo(IG258SearchCond cond) throws BLException {
		return ig258BL.searchIG258Info(cond);
	}
	
	/**
	 * 流程状态参与者调整主键值取得
	 * @param 流程定义ID
	 * @return 流程状态参与者调整主键值
	 */
	public String getProcessStatusPrtChangeDefPK(String psdid) throws BLException {
		return ig258BL.getPspcdSequenceNextValue(psdid);
	}
	
	/**
	 * 注册流程状态参与者调整
	 * @param entity 流程状态参与者调整实体
	 * @return 流程状态参与者调整实体
	 * @throws BLException
	 */
	public IG258Info registProcessStatusPrtChangeDefInfo(IG258Info entity) throws BLException {
		return ig258BL.registIG258Info(entity);
	}
	
	/**
	 * 删除流程状态参与者调整
	 * @param entity 流程状态参与者调整实体
	 * @throws BLException
	 */
	public void deleteProcessStatusPrtChangeDefInfo(IG258Info entity) throws BLException {
		ig258BL.deleteIG258Info(entity);
	}
	
	/**
	 * 注册分派定义
	 * @param entity 分派定义实体
	 * @return 分派定义实体
	 * @throws BLException
	 */
	public IG233Info registAssignedDefInfo(IG233Info entity) throws BLException {
		return ig233BL.registIG233(entity);
	}
	
	/**
	 * 查询指定状态的分派信息
	 * @param psdid 状态ID
	 * @return 分派信息结合
	 * @throws BLException
	 */
	public List<IG233Info> searchAssignedDefInfoByPsdid(String psdid) throws BLException {
		return ig233BL.searchByPsdid(psdid);
	}
	
	/**
	 * 条件检索状态的分派信息
	 * @param cond 检索条件
	 * @return 分派信息结合
	 * @throws BLException
	 */
	public List<IG233Info> searchAssignedDefInfo(IG233SearchCond cond) throws BLException {
		return ig233BL.searchIG233(cond);
	}
	
	/**
	 * 删除分派信息
	 * @param entitys 分派信息实体集合
	 * @throws BLException
	 */
	public void deleteAssignedDefInf(List<IG233Info> entitys) throws BLException {
		ig233BL.deleteIG233(entitys);
	}
	
	/**
	 * 根据流程定义主键查询表单查询条件定义
	 * @param pdid 流程定义主键
	 * @return 表单查询条件定义实体
	 * @throws BLException
	 */
	public List<IG108Info> searchFormQueryDefByPdid(String pdid) throws BLException {
		return ig108BL.findBypdid(pdid);
	}
	
	/**
	 * 注册表单查询条件
	 * @param entity 表单查询条件实体
	 * @return 表单查询条件实体
	 * @throws BLException
	 */
	public IG108Info registFormQueryDefInfo(IG108Info entity) throws BLException {
		return ig108BL.registIG108(entity);
	}
	
	/**
	 * 根据主键删除表单查询条件定义
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteFormQueryDefByKey(Integer pk) throws BLException {
		ig108BL.deleteIG108ByPK(pk);
	}
	
	/**
	 * 通知策略检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG334Info> searchInformStrategy(IG334SearchCond cond) throws BLException {
		return ig334BL.searchIG334(cond);
	}
	
	/**
	 * 注册通知策略
	 * @param entity 通知策略实体
	 * @return 通知策略实体
	 * @throws BLException
	 */
	public IG334Info registInformStrategy(IG334Info entity) throws BLException {
		return ig334BL.registIG334(entity);
	}
	
	/**
	 * 删除通知策略
	 * @param entity 通知策略实体
	 * @throws BLException
	 */
	public void deleteInformStrategy(IG334Info entity) throws BLException {
		ig334BL.deleteIG334(entity);
	}
	
	/**
	 * 表单策略检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG335Info> searchFormStrategy(IG335SearchCond cond) throws BLException {
		return ig335BL.searchIG335(cond);
	}
	
	/**
	 * 超时通知策略查询
	 * @param pdid 流程定义ID
	 * @param psdid 状态定义ID
	 * @param pidid 表单定义ID
	 * @return  超时通知策略列表
	 * @throws BLException
	 */
	public List<IG335Info> searchFormStrategyVW(String pdid,  String psdid, String pidid, String psdconfirm) throws BLException {
		return ig335BL.searchIG335Info(pdid, psdid, pidid, psdconfirm);
	}
	
	/**
	 * 注册表单策略
	 * @param entity 表单策略实体
	 * @return 表单策略实体
	 * @throws BLException
	 */
	public IG335Info registFormStrategy(IG335Info entity) throws BLException {
		return ig335BL.registIG335(entity);
	}
	
	/**
	 * 表单策略删除
	 * @param entitys 表单策略实体集合
	 * @throws BLException
	 */
	public void deleteFormStrategy(List<IG335Info> entitys) throws BLException {
		ig335BL.deleteIG335(entitys);
	}
	
	/**
	 * 表单角色范围注册
	 * @param entity 表单角色范围实体
	 * @return 表单角色范围实体
	 * @throws BLException
	 */
	public IG008Info registFormRoleScope(IG008Info entity) throws BLException {
		return ig008BL.registIG008(entity);
	}
	
	/**
	 * 根据表单定义ID检索表单角色限定范围
	 * @param pidid 表单定义主键
	 * @return
	 */
	public List<IG008Info> searchFormRoleScopeByPidid(String pidid){
		if(StringUtils.isNotEmpty(pidid)){
			IG008SearchCondImpl cond = new IG008SearchCondImpl();
			cond.setPidid(pidid);
			return ig008BL.searchIG008(cond);
		}else{
			return null;
		}
	}
	
	/**
	 * 表单角色限定范围删除
	 * @param entitys 表单角色限定范围实体集合
	 */
	public void deleteFormRoleScope(List<IG008Info> entitys) throws BLException{
		ig008BL.deleteIG008(entitys);
	}
	
	/**
	 * XML脚本导出处理
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public String exportXML(String pdid) throws BLException{
		StringBuffer sbf_xml = new StringBuffer();
		sbf_xml.append(ig380BL.exportXML(pdid));
		sbf_xml.append(ig007BL.exportXML(pdid));
		sbf_xml.append(ig333BL.exportXML(pdid));
		sbf_xml.append(ig258BL.exportXML(pdid));
		sbf_xml.append(ig222BL.exportXML(pdid));
		sbf_xml.append(ig132BL.exportXML(pdid));
		sbf_xml.append(ig881BL.exportXML(pdid));
		sbf_xml.append(ig273BL.exportXML(pdid));
		sbf_xml.append(ig286BL.exportXML(pdid));
		sbf_xml.append(ig413BL.exportXML(pdid));
		sbf_xml.append(ig126BL.exportXML(pdid));
		sbf_xml.append(ig725BL.exportXML(pdid));
		sbf_xml.append(ig699BL.exportXML(pdid));
		sbf_xml.append(ig213BL.exportXML(pdid));
		sbf_xml.append(ig243BL.exportXML(pdid));
		sbf_xml.append(ig298BL.exportXML(pdid));
		sbf_xml.append(ig156BL.exportXML(pdid));
		sbf_xml.append(ig212BL.exportXML(pdid));
		sbf_xml.append(ig237BL.exportXML(pdid));
		sbf_xml.append(ig373BL.exportXML(pdid));
		sbf_xml.append(ig911BL.exportXML(pdid));
		sbf_xml.append(ig931BL.exportXML(pdid));
		sbf_xml.append(ig700BL.exportXML(pdid));
		sbf_xml.append(ig701BL.exportXML(pdid));
//		sbf_xml.append(ig108BL.exportXML(pdid));
		sbf_xml.append(ig233BL.exportXML(pdid));
		sbf_xml.append(ig334BL.exportXML(pdid));
		sbf_xml.append(ig335BL.exportXML(pdid));
		sbf_xml.append(ig008BL.exportXML(pdid));
		sbf_xml.append(ig110BL.exportXML(pdid));
		sbf_xml.append(ig111BL.exportXML(pdid));
		return sbf_xml.toString();
	}
	
	/**
	 * XML脚本导入处理
	 * @param element Element
	 * @throws BLException
	 */
	public void importXML(List<org.jdom.Element> elements) throws BLException {
		for(org.jdom.Element element : elements) {
			if("IG380".equals(element.getName())) {
				ig380BL.importXML(element);
			} else if("IG007".equals(element.getName())) {
				ig007BL.importXML(element);
			} else if("IG333".equals(element.getName())) {
				ig333BL.importXML(element);
			} else if("IG258".equals(element.getName())) {
				ig258BL.importXML(element);
			} else if("IG222".equals(element.getName())) {
				ig222BL.importXML(element);
			} else if("IG132".equals(element.getName())) {
				ig132BL.importXML(element);
			} else if("IG881".equals(element.getName())) {
				ig881BL.importXML(element);
			} else if("IG273".equals(element.getName())) {
				ig273BL.importXML(element);
			} else if("IG286".equals(element.getName())) {
				ig286BL.importXML(element);
			} else if("IG413".equals(element.getName())) {
				ig413BL.importXML(element);
			} else if("IG126".equals(element.getName())) {
				ig126BL.importXML(element);
			} else if("IG725".equals(element.getName())) {
				ig725BL.importXML(element);
			} else if("IG699".equals(element.getName())) {
				ig699BL.importXML(element);
			} else if("IG213".equals(element.getName())) {
				ig213BL.importXML(element);
			} else if("IG243".equals(element.getName())) {
				ig243BL.importXML(element);
			} else if("IG298".equals(element.getName())) {
				ig298BL.importXML(element);
			} else if("IG156".equals(element.getName())) {
				ig156BL.importXML(element);
			} else if("IG212".equals(element.getName())) {
				ig212BL.importXML(element);
			} else if("IG237".equals(element.getName())) {
				ig237BL.importXML(element);
			} else if("IG373".equals(element.getName())) {
				ig373BL.importXML(element);
			} else if("IG911".equals(element.getName())) {
                ig911BL.importXML(element);
			} else if("IG931".equals(element.getName())) {
                ig931BL.importXML(element);
            } else if("IG700".equals(element.getName())) {
                ig700BL.importXML(element);
			} else if("IG701".equals(element.getName())) {
                ig701BL.importXML(element);
            } else if("IG108".equals(element.getName())) {
            	ig108BL.importXML(element);
            } else if("IG233".equals(element.getName())) {
            	ig233BL.importXML(element);
            } else if("IG334".equals(element.getName())) {
            	ig334BL.importXML(element);
            } else if("IG335".equals(element.getName())) {
            	ig335BL.importXML(element);
            } else if("IG008".equals(element.getName())) {
				ig008BL.importXML(element);
			} else if ("IG110".equals(element.getName())) {
				ig110BL.importXML(element);
			} else if ("IG111".equals(element.getName())) {
				ig111BL.importXML(element);
            }else if(!"CHECKINFO".equals(element.getName())){
				//throw new BLException("IGPRD0101.E006");
			}
		}
	}

    /**
     * 状态级私有表单单保存或更改
     * @Description: 状态级私有表单单保存或更改
     * @param dfvalue 默认值
     * @param usedToAll 是否应用到所有状态
     * @param psdid 状态id
     * @param pidid 表单id
     * @throws BLException
     */
    public void saveOrUpdateStatusDefault(String dfvalue,boolean usedToAll,String psdid,String pidid)throws BLException{
        IG560SearchCondImpl cond= new IG560SearchCondImpl();
        cond.setPidid_l(pidid);
        cond.setUsedToAll("T");
        List<IG560Info>  lst=ig560BL.searchIG560(cond);
        IG560TB ig560TB=new IG560TB();
        if(lst!=null&&lst.size()>0){
            ig560TB=(IG560TB) lst.get(0);
        }
        ig560TB.setDfvalue(dfvalue);
        ig560TB.setPidid(pidid);
        if(usedToAll){
            ig560TB.setUsedtoall("T");
        }else{
            ig560TB.setUsedtoall("F");
        }
        if(StringUtils.isNotEmpty(psdid)){
            ig560TB.setPsdid(psdid);
        }
        ig560BL.registIG560(ig560TB);
    }
    /**
     * 保存状态级私有表单默认值
     * @Description: 保存状态级私有表单默认值
     * @param list ig560list
     * @throws BLException
     */
    public void saveStatusDefaultList(List<IG560Info> list)throws BLException{
        ig560BL.saveOrUpdateAll(list);
    }
    /**
     * 查询某一状态或某一表单的默认值，如果同一个表单有多个默认值，则取最高权限。
     * @Description: 查询某一状态或某一表单的默认值，如果同一个表单有多个默认值，则取最高权限。
     * @param psdid 节点id,like查询
     * @param pidid 表单id,like查询
     * @return 状态级私有表单默认值视图
     * @throws BLException
     */
    public List<IG560VWInfo> searchIG560VWInfo(String psdid,String pidid)throws BLException{
        IG560SearchCondImpl cond= new IG560SearchCondImpl();
        cond.setPidid_l(pidid);
        cond.setPsdid_l(psdid);
        cond.setUsedToAll("T");
        List<IG560VWInfo> lst= ig560BL.searchIG560VW(cond);
        Map<String, IG560VWInfo> map= new HashMap<String, IG560VWInfo>();
        
        for(IG560VWInfo info:lst ){
            //empty
            if(StringUtils.isNotEmpty(info.getUsedtoall())&&"T".equals(info.getUsedtoall())){
                map.put(info.getPidid(), info);
            }
        }
        for(IG560VWInfo info:lst ){
            if(!(StringUtils.isNotEmpty(info.getUsedtoall())&&"T".equals(info.getUsedtoall()))){
                map.put(info.getPidid(), info);
            }
        }
        List<IG560VWInfo> returnLst= new ArrayList<IG560VWInfo>();
        for(Entry<String, IG560VWInfo> entry:map.entrySet()){
            returnLst.add(entry.getValue());
        }
        return returnLst;
    }
    /**
     * 状态级私有表单默认值 cond检索
     * @Description: 状态级私有表单默认值 cond检索
     * @param cond 
     * @return
     * @throws BLException
     */
    public List<IG560Info> searchIG560TBInfo(IG560SearchCond cond)throws BLException{
        return this.ig560BL.searchIG560(cond);      
    }
    
    /**
     * 流程查询显示列查询
     * @param pdid 流程定义ID
     * @return 流程查询显示列集合
     * @throws BLException
     */
	public List<IG110Info> searchProcessQueryShowColumnByPdid(String pdid) throws BLException {
		if(StringUtils.isEmpty(pdid)) {
			pdid = "N/A";
		}
		IG110SearchCondImpl cond = new IG110SearchCondImpl();
		cond.setPdid(pdid);
		return ig110BL.searchIG110(cond);
	}
	
	/**
	 * 流程查询条件查询
	 * @param pdid 流程定义ID
	 * @return 流程查询条件集合
	 * @throws BLException
	 */
	public List<IG111Info> searchprocessQueryByPdid(String pdid) throws BLException {
		if(StringUtils.isEmpty(pdid)) {
			pdid = "N/A";
		}
		IG111SearchCondImpl cond = new IG111SearchCondImpl();
		cond.setPdid(pdid);
		
		return ig111BL.searchIG111(cond);
	}
	
	/**
	 * 删除流程查询显示列
	 * @param instance 流程查询显示列
	 * @throws BLException
	 */
	public void deleteProcessQueryShowColumn(IG110Info instance) throws BLException {
		ig110BL.deleteIG110(instance);
	}
	
	/**
	 * 根据pdid删除流程查询显示列
	 * 
	 * @param instance
	 *            流程查询显示列
	 * @throws BLException
	 */
	public void deleteProcessQueryShowColumnByPdid(String pdid) throws BLException {
		ig110BL.deleteByPdid(pdid);
	}

	/**
	 * 删除流程查询条件
	 * 
	 * @param instance
	 *            流程查询条件
	 * @throws BLException
	 */
	public void deleteProcessQuery(IG111Info instance) throws BLException {
		ig111BL.deleteIG111(instance);
	}
	
	/**
	 * 根据pdid删除流程查询条件
	 * 
	 * @param instance
	 *            流程查询条件
	 * @throws BLException
	 */
	public void deleteProcessQueryByPdid(String pdid) throws BLException {
		ig111BL.deleteByPdid(pdid);
	}

	/**
	 * 流程查询显示列定义登记处理
	 * 
	 * @param instance
	 *            流程查询显示列实体
	 * @return 流程查询显示列实体
	 * @throws BLException
	 */
	public IG110Info registProcessQueryShowColumn(IG110Info instance) throws BLException {
		return ig110BL.registIG110(instance);
	}
	
	/**
	 * 流程查询显示列定义更新处理
	 * @param instance 流程查询显示列实体
	 * @return 流程查询显示列实体
	 * @throws BLException
	 */
	public IG110Info updateProcessQueryShowColumn(IG110Info instance) throws BLException {
		return ig110BL.updateIG110(instance);
	}
	
	/**
	 * 取得查询显示列实体的下一个ID
	 * @param pdid 流程定义ID
	 * @return 流程显示列实体ID
	 * @throws BLException
	 */
	public String getProcessQueryShowColumnNextId(String pdid) throws BLException {
		return ig110BL.getNextId(pdid);
	}
	
	/**
	 * 取得查询条件实体的下一个ID
	 * @param pdid 流程定义ID
	 * @return 流程查询条件实体ID
	 * @throws BLException
	 */
	public String getProcessQueryNextId(String pdid) throws BLException {
		return ig111BL.getNextId(pdid);
	}
	
	/**
	 * 流程查询条件登记处理
	 * @param instance 流程查询条件实体
	 * @return 流程查询条件实体
	 * @throws BLException
	 */
	public IG111Info registProcessQuery(IG111Info instance) throws BLException {
		return ig111BL.registIG111(instance);
	}
}
