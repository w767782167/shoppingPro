package lwd.dao;

import java.util.ArrayList;
import java.util.List;



import lwd.entity.ProductQueryObject;
import lwd.entity.kind;

import lwd.utils.JDBCUtils;
import lwd.utils.StringUtils;

public class ProductDirDao {
	//创建一个JDBC
	private JDBCUtils util = new JDBCUtils();

	public ProductDirDao() {
		util.getConnection();
	}

	// 查找 所有的商品分类
	public List<kind> queryAllproductDirs() throws Exception {
		String sql = "SELECT * FROM tb_bigtype";
		List<kind> list = util.findMoreRefResult(sql, null, kind.class);
		util.releaseConn();
		return list;

	}
	
	public boolean addKind(kind k) throws Exception {
		String sql = "insert into tb_bigtype values(null,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(k.getbigName());
		
	

		boolean flag = util.updateByPreparedStatement(sql, params);
		util.releaseConn();
		return flag;

	}
		
	
}
