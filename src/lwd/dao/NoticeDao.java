package lwd.dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.etcxm.utils.JDBCUtils;
public class NoticeDao {
	private JDBCUtils utils=new JDBCUtils();
	public NoticeDao(){
		utils.getConnection();
	}
	//添加公告
	public boolean addNotice(String title,String comment) throws SQLException{
		String sql="insert into tb_affiche values(null,?,?,null)";
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(title);
		params.add(comment);
		boolean flag = utils.updateByPreparedStatement(sql, params);
		return flag;
		
	}
}
