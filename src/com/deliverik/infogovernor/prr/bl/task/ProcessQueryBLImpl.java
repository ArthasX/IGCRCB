/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.bl.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.infogovernor.prr.model.condition.ProcessSearchCond;
import com.deliverik.infogovernor.prr.model.dao.ProcessQueryDAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程查询BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ProcessQueryBLImpl extends BaseBLImpl implements ProcessQueryBL{

	/** 流程查询DAO */
	protected ProcessQueryDAO processQueryDAO;
	
	/** 流程BL */
	protected IG500BL ig500BL;
	
	/** 参与人BL */
	protected IG337BL ig337BL;
	
	/**
	 * 流程查询DAO设定
	 * @param processQueryDAO 流程查询DAO
	 */
	public void setProcessQueryDAO(ProcessQueryDAO processQueryDAO) {
		this.processQueryDAO = processQueryDAO;
	}
	
	/**
	 * 流程BL设定
	 * @param ig500BL 流程BL
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}

	/**
	 * 参与人BL设定
	 * @param ig337BL 参与人BL
	 */
	public void setIg337BL(IG337BL ig337bl) {
		ig337BL = ig337bl;
	}

	/**
	 * 流程数量取得
	 * @param cond 查询条件
	 * @return 规定总数
	 * @throws BLException
	 */
	public int getProcessCount(ProcessSearchCond cond) throws BLException {
		String sql = getSql(cond);
		return processQueryDAO.getSearchCount(sql);
	}
	
	/**
	 * 拼接查询SQL
	 * @param cond 查询条件
	 * @return 拼接后的SQL
	 */
	private String getSql(ProcessSearchCond cond) {
		StringBuffer query = new StringBuffer();
		//处理查询条件
		String[] queryKey = cond.getQueryKey();
		String[] queryValue = cond.getQueryValue();
		/*
		 * 将查询条件封装到queryInfoMap中，在拼接sql的时候，根据key值查找value，
		 * 如果存在value值，该值将作为过滤条件 
		 */
		Map<String, String> queryInfoMap = new LinkedHashMap<String, String>();
		if(queryKey != null && queryValue != null && queryKey.length == queryValue.length){
			for(int i=0;i<queryKey.length;i++){
				String[] split = queryKey[i].split("#");
				String key = split[0] + "#" + split[1];
				queryInfoMap.put(key, queryValue[i]);
			}
		}
		/*
		 * 处理查询条件定义信息，将其封装的Map中，已标识为key，方便查找 
		 */
		Map<String, IG111Info> queryMap = new HashMap<String, IG111Info>();
		List<IG111Info> queryList = cond.getQueryList();
		for(IG111Info info:queryList){
			queryMap.put(info.getQflag(), info);
		}
		//取得显示列
		List<IG110Info> list = cond.getShowColumnList();
		/*
		 * map将作为所有需要查询的列集合，其中包括显示列和查询条件，
		 * 出于sql优化考虑，只查询需要用到的东西；
		 */
		Map<String, Set<String>> map = new LinkedHashMap<String, Set<String>>();
		for(IG110Info info:list){
			if("pp".equals(info.getStype())){
				continue;
			}
			if(map.get(info.getStype()) == null){
				map.put(info.getStype(), new LinkedHashSet<String>());
			}
			map.get(info.getStype()).add(info.getSflag());
		}
		
		/*
		 * 遍历查询条件信息，将查询条件中有值的放入map中过滤查询结构
		 * 避免不需要的条件和重复条件影响查询效率
		 */
		for(Iterator<Entry<String, String>> iter = queryInfoMap.entrySet().iterator();iter.hasNext();){
			Entry<String, String> entry = iter.next();
			String key = entry.getKey();
			String value = entry.getValue();
			if(StringUtils.isNotEmpty(value)){
				String[] split = key.split("#");
				String type = split[0];
				String flag = split[1];
				if(map.get(type) == null){
					map.put(type, new LinkedHashSet<String>());
				}
				Set<String> set = map.get(type);
				if(!set.contains(flag)){
					set.add(flag);
				}
			}
		}
		//流程定义ID
		String pdid = cond.getPdid().substring(0, 5);
//		query.append(" select * from ( ");
		
		//如果包含表单信息，创建表单信息临时表，之后的查询数据将从此临时表中获取，优化查询速度
		if(map.get("pi") != null){
			//定义临时表，优化查询速度
			query.append(" with pi as (select b.prid,b.pivarname,b.pivartype,b.pivarvalue,b.pidid from ig599 b where b.pidid like '");
			query.append(pdid);
			query.append("%') ");
		}
		query.append(" select * from ( select row_number() over(");
		/**
		 *	显示列未选择发起时间的bug
		 * 	DYF 	2015-6-8 13:56:01
		 */
		if (map.containsKey("pr")) {
			for(Iterator<String> iter = map.get("pr").iterator();iter.hasNext();){
				String next = iter.next();
				if("propentime".equals(next)){
				    query.append(" order by a.propentime desc ");
				    break;
				}
			}
		}
		query.append(") AS rownum, a.prid as prid");
		//拼接查询条件 别名格式 ： stype#sflag
		for(IG110Info info:cond.getShowColumnList()){
			if("pi".equals(info.getStype())){
				String key = "pi#" + info.getSflag();
				query.append(" ,");
				query.append(key);
				query.append(".pivarvalue as ");
				query.append(key);
				query.append(" ");
			}else if("pr".equals(info.getStype())){
				if("prstatus".equals(info.getSflag())){
					query.append(",ps.psdname as ");
					query.append(info.getStype());
					query.append("#");
					query.append(info.getSflag());
					query.append(" ");
				}else{
					query.append(",a.");
					query.append(info.getSflag());
					query.append(" as ");
					query.append(info.getStype());
					query.append("#");
					query.append(info.getSflag());
					query.append(" ");
				}
			}
		}
		query.append(" from ");
		query.append("( select  pr.prid,pr.prpdid as prpdid ,pr.prstatus as prcode ");
		//流程主表信息中只查询要显示的列
		if(map.get("pr") != null){
			for(Iterator<String> iter = map.get("pr").iterator();iter.hasNext();){
				String next = iter.next();
				if("prclosetime".equalsIgnoreCase(next)){
				    query.append(", VARCHAR( pr.propentime,32) propentime");
				}else if("propentime".equals(next)){
				    query.append(", VARCHAR( pr.prclosetime,32) prclosetime");
				}else{
				    query.append(",pr.");
				    query.append(next);
				}
			}
		}
		query.append(" from ig500 pr where pr.prpdid like '");
		query.append(pdid);
		query.append("%' ");
		if (StringUtils.isNotEmpty(cond.getPrurgency())) {
			query.append(" and pr.prurgency = '" + cond.getPrurgency() + "' ");
		}
		
		/*
		 * 新添加查询条件 处理人作为查询条件
		 * time 2015/06/11
		 * autho zhangqiang
		 * 如果处理人不为空则加此查询条件
		 */
		if (queryKey !=null) {
			
			int num = -1; //计算处理人所在位置
			
			for(int j=0;j<queryKey.length;j++){
				if(queryKey[j].contains("处理人")){
					num=j;
				}
			} 
			//判断处理人是否为空
			if(num>=0&&StringUtils.isNotBlank(queryValue[num])){
				query.append(" and exists (select 1 from ig337 i3 where i3.prid=pr.prid and i3.ppstatus=pr.prstatus and i3.ppusername like '%"+queryValue[num]+"%') ");
				}
		}
		
		//流程主表查询条件直接在临时表中过滤
		for(Iterator<Entry<String, String>> iter = queryInfoMap.entrySet().iterator();iter.hasNext();){
			Entry<String, String> entry = iter.next();
			String key = entry.getKey();
			String[] split = key.split("#");
			String type = split[0];
			String flag = split[1];
			String value = entry.getValue();
			if(key.startsWith("pr") && StringUtils.isNotEmpty(value)){
				query.append(getValueSql(type + "." + flag , value, queryMap.get(flag)));
			}
		}
		query.append(") a ");
		query.append(" left join (select c.pdid,c.psdcode,c.psdname from ig333 c where c.pdid like '");
		query.append(pdid);
		query.append("%') ps on (ps.pdid = a.prpdid and ps.psdcode = a.prcode) ");
		if(map.get("pi") != null){
			/*
			 * 如果存在查询条件值，本条表单值将作为查询条件，使用内连接;
			 * 如果不存在查询条件，本条表单值只为显示，使用外连接；
			 * ps：虽然无论是否有值，表单都会在IG599表中存在一条记录，
			 *     但是，考虑到升版，可能低版本流程历史数据中可能不存在这个表单，
			 *     所以使用外连接
             * 考虑到inner join 和 left join 交叉使用会报错，所以循环两次，第一次使用inner join 第二次使用left join
			 */
			for(Iterator<String> iter = map.get("pi").iterator();iter.hasNext();){
				//取得的value实际是表单定义ID
				String next = iter.next();
				//key将是查询条件信息Map中寻找查询条件值的key，并且作为拼接sql中表单值的标识
				String key = "pi#" + next;
				//从查询条件map中取得查询条件值
				String val = queryInfoMap.get(key);
				if(StringUtils.isNotEmpty(val)){
					//替换后的表单定义ID，将版本的两位替换成 “_”;
					String pidid = next.substring(0,5) + "__" + next.substring(7);
					query.append(" inner join pi ");
					query.append(key);
					query.append(" on ");
					query.append(key);
					query.append(".prid=a.prid and ");
					query.append(key);
					query.append(".pidid like '");
					query.append(pidid);
					query.append("' ");
					query.append(getValueSql(key + ".pivarvalue",val,queryMap.get(next)));
				}
			}
			for(Iterator<String> iter = map.get("pi").iterator();iter.hasNext();){
				//取得的value实际是表单定义ID
				String next = iter.next();
				//key将是查询条件信息Map中寻找查询条件值的key，并且作为拼接sql中表单值的标识
				String key = "pi#" + next;
				//从查询条件map中取得查询条件值
				String val = queryInfoMap.get(key);
				if(StringUtils.isEmpty(val)){
					//替换后的表单定义ID，将版本的两位替换成 “_”;
					String pidid = next.substring(0,5) + "__" + next.substring(7);
					query.append(" left join pi ");
					query.append(key);
					query.append(" on ");
					query.append(key);
					query.append(".prid=a.prid and ");
					query.append(key);
					query.append(".pidid like '");
					query.append(pidid);
					query.append("' ");
				}
			}
		}
		 query.append(") where 1=1  ");
		
		return query.toString();
	}
	
	/**
	 * 取得查询条件值过滤拼接sql
	 * @param key 对应表或临时表的标识名称
	 * @param val 值
	 * @param queryObj 查询条件定义对象
	 * @return 拼接后的sql
	 */
	private String getValueSql(String key, String val, IG111Info queryObj) {
		StringBuffer sql = new StringBuffer();
		if("like".equals(queryObj.getQmode())){
			sql.append(" and ");
			sql.append(key);
			sql.append(" like '%");
			sql.append(val);
			sql.append("%' ");
		}else if("bt".equals(queryObj.getQmode())){
		    //时间间隔为空的查询会报错，split
		    if("#".equals(val)){
		        return "";
		    }
			String[] split = val.split("#");
			String v1 = split[0];
			String v2 = null;
			if(split.length > 1){
				v2 = split[1];
			}
			if(StringUtils.isNotEmpty(v1)){
				sql.append(" and ");
				sql.append(key);
				sql.append(" >= '");
				sql.append(v1);
				sql.append("' ");
			}
			if(StringUtils.isNotEmpty(v2)){
				sql.append(" and ");
				sql.append(key);
				sql.append(" <= '");
				sql.append(v2);
				sql.append("' ");
			}
		}else{
			sql.append(" and ");
			sql.append(key);
			sql.append(" = '");
			sql.append(val);
			sql.append("' ");
		}
		return sql.toString();
	}

	/**
	 * 查询流程信息
	 * @param cond 查询条件
	 * @param start 起始页码
	 * @param count 显示数量
	 * @return 流程信息集合
	 */
	public List<Map<String, Object>> searchProcess(ProcessSearchCond cond, int start, int count) {
		//取得显示列
		List<IG110Info> showColumnList = cond.getShowColumnList();
		//获取查询sql
		String sql = getSql(cond);
		//调用DAO查询
		List<Map<String,Object>> list = processQueryDAO.searchProcessRecordInfo(sql,start,count);
		//重新组装结果，将结果中的特殊值（例如：树、机构数，角色、项目等）变成只显示汉字
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		for(Map<String,Object> map:list){
			Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
			//先设置流程主键值
			resultMap.put("PRID", map.get("PRID"));
			Object obj =  resultMap.get("PRID");
			Integer prid = Integer.parseInt(obj.toString());
			//由于hibernate查询结果在map的情况下是无序的，要想控制显示顺序就不能直接遍历map
			for(IG110Info info:showColumnList){
				String key = info.getStype().toUpperCase() + "#" + info.getSflag().toUpperCase();
				if("pp".equals(info.getStype())){
					StringBuffer processParticipants = new StringBuffer();
					List<String> lst_Status = null;
					try {
						lst_Status = ig500BL.searchCurrentStatus(new Integer(prid));
					} catch (BLException e) {
						lst_Status = new ArrayList<String>();
					}
				    IG337SearchCondImpl cond337 = new IG337SearchCondImpl();
					cond337.setPrid(new Integer(prid));
					List<IG337Info> list_337 =  new ArrayList<IG337Info>();
					for(String status : lst_Status) {
						cond337.setPpstatus_q(status);
						// 查询处理人信息
						list_337.addAll(ig337BL.getIG337Infos(cond337));
					}
					if(list_337.size() > 0){
						for(int i = 0; i < list_337.size(); i++){
							IG337Info pp = list_337.get(i);
							if(StringUtils.isEmpty(pp.getPpusername())){
								if(processParticipants.indexOf("未指定") == -1) {
									processParticipants.append("未指定、");
								}
								continue;
							}
							processParticipants.append(pp.getPpusername());
							if(i < list_337.size() - 1){
								processParticipants.append("、");
							}
						}
					} else {
						processParticipants.append("");
					}
					if(processParticipants.toString().endsWith("、")) {
						resultMap.put(key, processParticipants.substring(0, processParticipants.length()-1).toString());
				    } else {
				    	resultMap.put(key, processParticipants.toString());
				    }
				}else{
					Object value = map.get(key);
					if(value != null && StringUtils.isNotEmpty(value.toString())){
						String val = value.toString();
						if(val.contains("_tree_")){
							resultMap.put(key, val.split("_tree_")[1]);
						}else if(val.contains("_OrgTree_")){
							resultMap.put(key, val.split("_OrgTree_")[1]);
						}else if(val.contains("_role_")){
							resultMap.put(key, val.split("_role_")[1]);
						}else if(val.contains("_prj_")){
							resultMap.put(key, val.split("_prj_")[1]);
						}else{
							resultMap.put(key, value);
						}
					}else{
						resultMap.put(key, "");
					}
				}
			}
			result.add(resultMap);
		}
		return result;
	}
}
