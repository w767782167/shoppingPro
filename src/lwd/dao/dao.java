package lwd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lwd.entity.PageRuselt;
import lwd.entity.ProductQueryObject;
import lwd.entity.goods;
import lwd.utils.JDBCUtils;

public class dao {
	private JDBCUtils util = new JDBCUtils();

	public dao() {
		util.getConnection();
	}

	// 登录

	public boolean add(goods g) throws Exception {
		String sql = "insert into tb_goods values(null,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(g.getName());
		params.add(g.getPrice());
		params.add(g.getCostprice());
		params.add(g.getProperty());
		params.add(g.getPacking());
		params.add(g.getStock());
		params.add(g.getBigtype_id());
		params.add(g.getPath());
		params.add(g.getWebsite());
		params.add(g.getEdit_website());
		params.add(g.getGoodsFrom());
		params.add(g.getIntroduce());
		params.add(g.getCreateTime());

		boolean flag = util.updateByPreparedStatement(sql, params);
		util.releaseConn();
		return flag;
	}
	
	
	
	public boolean updateGood(Long id, String name, Double price, Double costprice,
			String property, String packing, Long stock, Long bigtype_id, String website, String edit_website, String goodsFrom,
			String introduce,String path) throws Exception {
		String sql = "update tb_goods set name='"+name+"',price='"+price+"',costprice='"+costprice+"',property='"+property+"',packing='"+packing+"',stock='"+stock+"',bigtype_id='"+bigtype_id+"',website='"+website+"',goodsFrom='"+goodsFrom+"',introduce='"+introduce+"',path='"+path+"' where id ='"+id+"'";
	/*, Double costprice,
		String property, String packing, Long stock, Long bigtype_id, String website, String edit_website, String goodsFrom,
		String introduce,String path*/
		
		//List<Object> params = new ArrayList<Object>();
		

		boolean flag = util.updateByPreparedStatement(sql, null);
		util.releaseConn();
		return flag;
	}

	public List<goods> querySp() throws Exception {

		// op.getQuerySql(); sql语句
		// op.getParames() sql对应的参数

		String sql = "SELECT * FROM tb_goods";

		List<goods> list = util.findMoreRefResult(sql, null, goods.class);
		util.releaseConn();
		return list;

	}

	public goods checkLogin(String str) throws Exception {
		String sql = "SELECT * FROM tb_goods WHERE name = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(str);

		goods sp = util.findSimpleRefResult(sql, params, goods.class);
		util.releaseConn();
		return sp;
	}
	
	public goods queryEmple(Long id) throws Exception {
		String sql = "SELECT * FROM tb_goods WHERE id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);

		goods sp = util.findSimpleRefResult(sql, params, goods.class);
		util.releaseConn();
		return sp;
	}

	public PageRuselt queryPageResult(ProductQueryObject op) throws Exception {
		// 查询 结果集
		Integer totalCount = (int) totalCount(op);
		// 查询总条数

		Integer c = op.getCurrentPage();
		Integer p = op.getPageSize();
		int a = totalCount % p == 0 ? (totalCount / p) : (totalCount / p) + 1;
		if (a == 0) {
			a = 1;
			System.out.println("ifa==0运行了");
		}
		String sql = "";
		List<Object> params = null;
		if (c > a)
			op.setCurrentPage(a);

		sql = "SELECT * FROM tb_goods " + op.getQuerySql() + " LIMIT ?,?";

		params = new ArrayList<Object>();
		if (op.getParames().size() != 0) {
			params.addAll(op.getParames());// /////////////////////用addAll////////////////
		}
		params.add((op.getCurrentPage() - 1) * op.getPageSize());
		params.add(op.getPageSize());
System.out.println(params.toString());
		List<goods> list = util.findMoreRefResult(sql, params, goods.class);

		System.out.println(op.getCurrentPage());
		PageRuselt pr = new PageRuselt(list, totalCount, op.getCurrentPage(),
				op.getPageSize());
		System.out.println(";;" + pr + ";;");
		util.releaseConn();
		return pr;
	}

	public long totalCount(ProductQueryObject op) {
		String sql = "SELECT COUNT(*) FROM tb_goods" + op.getQuerySql();
		System.out.println("total：" + sql.toString());
		ResultSet resultSet = util.query(sql, op.getParames().toArray());
		long result = 0;
		try {
			if (resultSet.next()) {
				result = resultSet.getLong(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public goods addActivities1() throws Exception {
		String sql = "SELECT name FROM tb_goods WHERE  bigtype_id= ?";
		List<Object> params = new ArrayList<Object>();
		params.add(1);

		goods sp = util.findSimpleRefResult(sql, params, goods.class);
		util.releaseConn();
		return sp;
	}
	public List<goods> addActivities() throws Exception {

		// op.getQuerySql(); sql语句
		// op.getParames() sql对应的参数

		String sql = "SELECT * FROM tb_goods WHERE  bigtype_id= 1";

		List<goods> list = util.findMoreRefResult(sql, null, goods.class);
		util.releaseConn();
		return list;

	}
	public List<goods> addDessert() throws Exception {

		// op.getQuerySql(); sql语句
		// op.getParames() sql对应的参数

		String sql = "SELECT * FROM tb_goods WHERE  bigtype_id= 2";

		List<goods> list = util.findMoreRefResult(sql, null, goods.class);
		util.releaseConn();
		return list;

	}
	public List<goods> addNuts() throws Exception {

		// op.getQuerySql(); sql语句
		// op.getParames() sql对应的参数

		String sql = "SELECT * FROM tb_goods WHERE  bigtype_id= 3";

		List<goods> list = util.findMoreRefResult(sql, null, goods.class);
		util.releaseConn();
		return list;

	}
	
	public List<goods> addRecommend() throws Exception {

		// op.getQuerySql(); sql语句
		// op.getParames() sql对应的参数

		String sql = "SELECT * FROM tb_goods WHERE  bigtype_id= 4";

		List<goods> list = util.findMoreRefResult(sql, null, goods.class);
		util.releaseConn();
		return list;

	}
	public List<goods> addDay() throws Exception {

		// op.getQuerySql(); sql语句
		// op.getParames() sql对应的参数

		String sql = "SELECT * FROM tb_goods WHERE  bigtype_id= 4";

		List<goods> list = util.findMoreRefResult(sql, null, goods.class);
		util.releaseConn();
		return list;

	}
	
	public boolean deleteGoods(Long id) throws Exception {
		String sql = "delete from tb_goods WHERE  id= ?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		boolean flase = util.updateByPreparedStatement(sql, params);
		
		
		return flase;
		
		
	}
	

}
