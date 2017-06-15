/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.util;

import java.util.Comparator;

import com.deliverik.framework.model.CodeDetail;

/**
 * CodeDetail表查询结果比较器
 * 根据cid字段的值顺序排列主要为了保证查询顺序而添加
 */
public class CodeDetailComparator implements Comparator<Object> {
	public int compare(Object one, Object two) {
		CodeDetail oneInfo = (CodeDetail) one;
		CodeDetail twoInfo = (CodeDetail) two;
		if(!oneInfo.getCid().equals(twoInfo.getCid()))
			return Integer.parseInt(oneInfo.getCid())>Integer.parseInt(twoInfo.getCid())? 1:-1;
		else
			return Integer.parseInt(oneInfo.getCid())>Integer.parseInt(twoInfo.getCid())? 1:-1;
	}
}