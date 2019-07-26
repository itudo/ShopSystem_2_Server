package com.yc.biz.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.FacetParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.bean.Goods;
import com.yc.bean.GoodsDetail;
import com.yc.bean.Person;
import com.yc.biz.GoodsBiz;

@Service
public class SolrService<T> {

	// 指定solr服务器的地址
	private final static String SOLR_URL = "http://localhost:8983/solr/";

	private String solrCore = "shopstem";// 指定的存储数据的collection
	
	@Autowired
	private GoodsBiz goodsBiz;

	/**
	 * 创建SolrServer对象
	 * 
	 * 该对象有两个可以使用，都是线程安全的 1、CommonsHttpSolrServer：启动web服务器使用的，通过http请求的 2、
	 * EmbeddedSolrServer：内嵌式的，导入solr的jar包就可以使用了 3、solr
	 * 4.0之后好像添加了不少东西，其中CommonsHttpSolrServer这个类改名为HttpSolrClient
	 * 
	 * @return
	 */
	public HttpSolrClient createSolrServer() {
		HttpSolrClient solr = null;
		solr = new HttpSolrClient(SOLR_URL);
		solr.setConnectionTimeout(100);
		solr.setDefaultMaxConnectionsPerHost(100);
		solr.setMaxTotalConnections(100);
		return solr;
	}

	public void addBeansBatch(List<T> list) throws IOException, SolrServerException {
		HttpSolrClient solr = new HttpSolrClient(SOLR_URL + solrCore);
		solr.addBeans(list);
		solr.commit();
		solr.close();
	}

	public void addBean(T t) throws IOException, SolrServerException {
		HttpSolrClient solr = new HttpSolrClient(SOLR_URL + solrCore);
		solr.addBean(t);
		solr.commit();
		solr.close();
	}

	/**
	 * 往索引库添加文档
	 * 
	 * @throws IOException
	 * @throws SolrServerException
	 */
	public void addDoc() throws SolrServerException, IOException {
		// 构造一篇文档
		SolrInputDocument document = new SolrInputDocument();
		// 往doc中添加字段,在客户端这边添加的字段必须在服务端中有过定义
		document.addField("id", "4");
		document.addField("goods_name", "LG 55LG63CJ-CA 4K液晶");
		document.addField("goods_price", "1000");
		document.addField("attr_name", "黄色，自由组合");
		document.addField("type_name", "超薄电视");
		// 获得一个solr服务端的请求，去提交 ,选择具体的某一个solr core
		HttpSolrClient solr = new HttpSolrClient(SOLR_URL + solrCore);
		solr.add(document);
		solr.commit();
		solr.close();
	}

	/**
	 * 根据id从索引库删除文档
	 */
	public void deleteDocumentById(String id) throws Exception {
		// 选择具体的某一个solr core
		HttpSolrClient server = new HttpSolrClient(SOLR_URL + solrCore);
		// 删除文档
		server.deleteById(id);
		// 删除所有的索引
		//server.deleteByQuery("*:*");
		// 提交修改
		server.commit();
		server.close();
	}

	/**
	 * 查询
	 * 
	 * @throws Exception
	 */
	public List<Goods> querySolr(String search) throws Exception {
		HttpSolrClient solrServer = new HttpSolrClient(SOLR_URL + solrCore);
		SolrQuery query = new SolrQuery();
		// 下面设置solr查询参数
		query.set("q", search);// 参数q 查询所有
		//query.set("q","*长虹*");//相关查询，比如某条数据某个字段含有周、星、驰三个字 将会查询出来
		// ，这个作用适用于联想查询

		// 参数fq, 给query增加过滤查询条件
		// query.addFilterQuery("id:[0 TO 9]");//id为0-9

		// 给query增加布尔过滤条件
		// query.addFilterQuery("description:演员"); //description字段中含有“演员”两字的数据

		// 参数df,给query设置默认搜索域
		// query.set("df", "name");

		//query.setQuery("name:*");
		//query.setQuery("goods_name:"+search+" OR goods_price:"+search+"  OR type_name:"+search+"" );//name
		// 包含zhangsan或者123
		// query.setQuery("name:*zhangsan* AND description:*zhangsan*" );//
		// name包含且

		// 分组查询
		//query.setFacet(true);
		//query.addFacetField("name", "description");// 两个域有各自独立的结果
		/*
		 * FacetComponet有两种排序选择，分别是count和index，
		 * count是按每个词出现的次数，index是按词的字典顺序。如果查询参数不指定facet.sort，solr默认是按count排序。
		 */
		query.setFacetSort(FacetParams.FACET_SORT_COUNT);
		/* query.setFacetLimit(101); */// 设置返回结果条数 ,-1表示返回所有,默认值为100
		/* query.setParam(FacetParams.FACET_OFFSET, "100"); */// 开始条数,偏移量,它与facet.limit配合使用可以达到分页的效果
		query.setFacetMinCount(1);// 设置 限制 count的最小返回值，默认为0
		query.setFacetMissing(false);// 不统计null的值
		/* query.setFacetPrefix("test");//设置前缀 */

		// 参数sort,设置返回结果的排序规则
		// query.addSort("id",SolrQuery.ORDER.asc);
		// query.addSort("name", SolrQuery.ORDER.desc);

		// 设置分页参数
		// query.setStart(0);
		// query.setRows(10);//每一页多少值

		// 参数hl,设置高亮
		query.setHighlight(true);
		// 设置高亮的字段
		query.addHighlightField("goods_name");
		// 设置高亮的样式
		query.setHighlightSimplePre("<font color='red'>");
		query.setHighlightSimplePost("</font>");

		// 获取查询结果
		QueryResponse response = solrServer.query(query);
		// 两种结果获取：得到文档集合或者实体对象

		// 获取高亮数据结果
		// Map<String, Map<String, List<String>>> map =
		// response.getHighlighting();

		// 得到FacetField结果
		System.out.println(response.getFacetFields());

		// 获取高亮数据结果
		System.out.println("高亮数据结果" + response.getHighlighting());

		// 查询得到文档的集合
		SolrDocumentList solrDocumentList = response.getResults();
		System.out.println("通过文档集合获取查询文档数量：" + solrDocumentList.getNumFound());
		// 遍历列表
		List<Goods> list = new ArrayList<Goods>();
		for (SolrDocument doc : solrDocumentList) {
			Goods goods = new Goods();
			goods.setGoods_id(Integer.parseInt(doc.get("goods_id").toString().substring(doc.get("goods_id").toString().indexOf("[")+1,doc.get("goods_id").toString().length()-1)));
			//goodsdetail.setGoods_name( doc.get("goods_name").toString().substring(doc.get("goods_name").toString().indexOf("[")+1,doc.get("goods_name").toString().length()-1));
			//goodsdetail.setType_name( doc.get("type_name").toString().substring(doc.get("type_name").toString().indexOf("[")+1,doc.get("type_name").toString().length()-1));
			//goodsdetail.setAttr_name(doc.get("attr_name").toString().substring(doc.get("attr_name").toString().indexOf("[")+1,doc.get("attr_name").toString().length()-1));
			System.out.println(goods.toString());
			list.add(goods);
		}

		// 得到实体对象
//		List<GoodsDetail> tmpLists = response.getBeans(GoodsDetail.class);
//		if (tmpLists != null && tmpLists.size() > 0) {
//			System.out.println("实体对象赋值内容：");
//			for (Person per : tmpLists) {
//				System.out.println(per.toString());
//			}
//		}
//		System.out.println(tmpLists);
		return list;
	}

	public static void main(String[] args) throws Exception {
		SolrService solr = new SolrService();
		// solr.createSolrServer();
		//solr.addDoc();
		//solr.addPersonIndex();
		//solr.addPersonBatch();
		//solr.deleteDocumentById("12");
		solr.querySolr("毛衣");
	}

}
