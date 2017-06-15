/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.crc.report.jdbc.query;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 报表值查询DAO接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ReportValueQueryDAO {

	/**
	 * 查询报表表单值
	 * 通过流程定义ID，取得XML配置文件名称，通过XML文件取得该流程对应的所有取值sql
	 * 通过连接取得所有的表单值组装成Map返回
	 * 返回值格式：key -- 表单全路径（例：顶级标题#二级标题#三级标题）
	 *            value -- 表单值集合，可能是多行，所以是个List
	 * @param pdid 报表流程ID
	 * @return 表单值结合
	 */
	public Map<String,List<String>> getValue(String pdid);
}
