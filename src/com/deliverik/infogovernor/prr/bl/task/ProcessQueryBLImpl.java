/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̲�ѯBLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ProcessQueryBLImpl extends BaseBLImpl implements ProcessQueryBL{

	/** ���̲�ѯDAO */
	protected ProcessQueryDAO processQueryDAO;
	
	/** ����BL */
	protected IG500BL ig500BL;
	
	/** ������BL */
	protected IG337BL ig337BL;
	
	/**
	 * ���̲�ѯDAO�趨
	 * @param processQueryDAO ���̲�ѯDAO
	 */
	public void setProcessQueryDAO(ProcessQueryDAO processQueryDAO) {
		this.processQueryDAO = processQueryDAO;
	}
	
	/**
	 * ����BL�趨
	 * @param ig500BL ����BL
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}

	/**
	 * ������BL�趨
	 * @param ig337BL ������BL
	 */
	public void setIg337BL(IG337BL ig337bl) {
		ig337BL = ig337bl;
	}

	/**
	 * ��������ȡ��
	 * @param cond ��ѯ����
	 * @return �涨����
	 * @throws BLException
	 */
	public int getProcessCount(ProcessSearchCond cond) throws BLException {
		String sql = getSql(cond);
		return processQueryDAO.getSearchCount(sql);
	}
	
	/**
	 * ƴ�Ӳ�ѯSQL
	 * @param cond ��ѯ����
	 * @return ƴ�Ӻ��SQL
	 */
	private String getSql(ProcessSearchCond cond) {
		StringBuffer query = new StringBuffer();
		//�����ѯ����
		String[] queryKey = cond.getQueryKey();
		String[] queryValue = cond.getQueryValue();
		/*
		 * ����ѯ������װ��queryInfoMap�У���ƴ��sql��ʱ�򣬸���keyֵ����value��
		 * �������valueֵ����ֵ����Ϊ�������� 
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
		 * �����ѯ����������Ϣ�������װ��Map�У��ѱ�ʶΪkey��������� 
		 */
		Map<String, IG111Info> queryMap = new HashMap<String, IG111Info>();
		List<IG111Info> queryList = cond.getQueryList();
		for(IG111Info info:queryList){
			queryMap.put(info.getQflag(), info);
		}
		//ȡ����ʾ��
		List<IG110Info> list = cond.getShowColumnList();
		/*
		 * map����Ϊ������Ҫ��ѯ���м��ϣ����а�����ʾ�кͲ�ѯ������
		 * ����sql�Ż����ǣ�ֻ��ѯ��Ҫ�õ��Ķ�����
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
		 * ������ѯ������Ϣ������ѯ��������ֵ�ķ���map�й��˲�ѯ�ṹ
		 * ���ⲻ��Ҫ���������ظ�����Ӱ���ѯЧ��
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
		//���̶���ID
		String pdid = cond.getPdid().substring(0, 5);
//		query.append(" select * from ( ");
		
		//�����������Ϣ����������Ϣ��ʱ��֮��Ĳ�ѯ���ݽ��Ӵ���ʱ���л�ȡ���Ż���ѯ�ٶ�
		if(map.get("pi") != null){
			//������ʱ���Ż���ѯ�ٶ�
			query.append(" with pi as (select b.prid,b.pivarname,b.pivartype,b.pivarvalue,b.pidid from ig599 b where b.pidid like '");
			query.append(pdid);
			query.append("%') ");
		}
		query.append(" select * from ( select row_number() over(");
		/**
		 *	��ʾ��δѡ����ʱ���bug
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
		//ƴ�Ӳ�ѯ���� ������ʽ �� stype#sflag
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
		//����������Ϣ��ֻ��ѯҪ��ʾ����
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
		 * ����Ӳ�ѯ���� ��������Ϊ��ѯ����
		 * time 2015/06/11
		 * autho zhangqiang
		 * ��������˲�Ϊ����Ӵ˲�ѯ����
		 */
		if (queryKey !=null) {
			
			int num = -1; //���㴦��������λ��
			
			for(int j=0;j<queryKey.length;j++){
				if(queryKey[j].contains("������")){
					num=j;
				}
			} 
			//�жϴ������Ƿ�Ϊ��
			if(num>=0&&StringUtils.isNotBlank(queryValue[num])){
				query.append(" and exists (select 1 from ig337 i3 where i3.prid=pr.prid and i3.ppstatus=pr.prstatus and i3.ppusername like '%"+queryValue[num]+"%') ");
				}
		}
		
		//���������ѯ����ֱ������ʱ���й���
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
			 * ������ڲ�ѯ����ֵ��������ֵ����Ϊ��ѯ������ʹ��������;
			 * ��������ڲ�ѯ������������ֵֻΪ��ʾ��ʹ�������ӣ�
			 * ps����Ȼ�����Ƿ���ֵ����������IG599���д���һ����¼��
			 *     ���ǣ����ǵ����棬���ܵͰ汾������ʷ�����п��ܲ������������
			 *     ����ʹ��������
             * ���ǵ�inner join �� left join ����ʹ�ûᱨ������ѭ�����Σ���һ��ʹ��inner join �ڶ���ʹ��left join
			 */
			for(Iterator<String> iter = map.get("pi").iterator();iter.hasNext();){
				//ȡ�õ�valueʵ���Ǳ�����ID
				String next = iter.next();
				//key���ǲ�ѯ������ϢMap��Ѱ�Ҳ�ѯ����ֵ��key��������Ϊƴ��sql�б�ֵ�ı�ʶ
				String key = "pi#" + next;
				//�Ӳ�ѯ����map��ȡ�ò�ѯ����ֵ
				String val = queryInfoMap.get(key);
				if(StringUtils.isNotEmpty(val)){
					//�滻��ı�����ID�����汾����λ�滻�� ��_��;
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
				//ȡ�õ�valueʵ���Ǳ�����ID
				String next = iter.next();
				//key���ǲ�ѯ������ϢMap��Ѱ�Ҳ�ѯ����ֵ��key��������Ϊƴ��sql�б�ֵ�ı�ʶ
				String key = "pi#" + next;
				//�Ӳ�ѯ����map��ȡ�ò�ѯ����ֵ
				String val = queryInfoMap.get(key);
				if(StringUtils.isEmpty(val)){
					//�滻��ı�����ID�����汾����λ�滻�� ��_��;
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
	 * ȡ�ò�ѯ����ֵ����ƴ��sql
	 * @param key ��Ӧ�����ʱ��ı�ʶ����
	 * @param val ֵ
	 * @param queryObj ��ѯ�����������
	 * @return ƴ�Ӻ��sql
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
		    //ʱ����Ϊ�յĲ�ѯ�ᱨ��split
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
	 * ��ѯ������Ϣ
	 * @param cond ��ѯ����
	 * @param start ��ʼҳ��
	 * @param count ��ʾ����
	 * @return ������Ϣ����
	 */
	public List<Map<String, Object>> searchProcess(ProcessSearchCond cond, int start, int count) {
		//ȡ����ʾ��
		List<IG110Info> showColumnList = cond.getShowColumnList();
		//��ȡ��ѯsql
		String sql = getSql(cond);
		//����DAO��ѯ
		List<Map<String,Object>> list = processQueryDAO.searchProcessRecordInfo(sql,start,count);
		//������װ�����������е�����ֵ�����磺��������������ɫ����Ŀ�ȣ����ֻ��ʾ����
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		for(Map<String,Object> map:list){
			Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
			//��������������ֵ
			resultMap.put("PRID", map.get("PRID"));
			Object obj =  resultMap.get("PRID");
			Integer prid = Integer.parseInt(obj.toString());
			//����hibernate��ѯ�����map�������������ģ�Ҫ�������ʾ˳��Ͳ���ֱ�ӱ���map
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
						// ��ѯ��������Ϣ
						list_337.addAll(ig337BL.getIG337Infos(cond337));
					}
					if(list_337.size() > 0){
						for(int i = 0; i < list_337.size(); i++){
							IG337Info pp = list_337.get(i);
							if(StringUtils.isEmpty(pp.getPpusername())){
								if(processParticipants.indexOf("δָ��") == -1) {
									processParticipants.append("δָ����");
								}
								continue;
							}
							processParticipants.append(pp.getPpusername());
							if(i < list_337.size() - 1){
								processParticipants.append("��");
							}
						}
					} else {
						processParticipants.append("");
					}
					if(processParticipants.toString().endsWith("��")) {
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
