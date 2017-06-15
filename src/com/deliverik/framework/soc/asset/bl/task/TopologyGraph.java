/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

/**
 * 概述: 拓扑图
 * 功能描述: 存放节点数，作为新生成的节点ID
 * 创建记录: 2011/04/20
 * 修改记录: 
 */
class TopologyGraph {
	private int nodecount = 1;

	public int getNodecount() {
		return nodecount;
	}

	public int getRootid() {
		return 1;
	}

	public void setNodecount(int nodecount) {
		this.nodecount = nodecount;
	}

	public void increase() {
		this.nodecount++;
	}

	public static String filterStr(String str) {
		if (null == str || "".equals(str)) {
			return str;
		}
		StringBuffer buf = new StringBuffer();
		char ch = ' ';
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (ch == '<') {
				buf.append("&lt;");
			} else if (ch == '>') {
				buf.append("&gt;");
			} else if (ch == '&') {
				buf.append("&amp;");
			} else if (ch == '"') {
				buf.append("&quot;");
			} else if (ch == '\'') {
				buf.append("&apos;");
			} else {
				buf.append(ch);
			}
		}
		return buf.toString();
	}

}
