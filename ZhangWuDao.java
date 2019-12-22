package dao;

import java.sql.SQLException;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.ZhangWu;

import domain.ZhangWu;
import tools.JDBCUtils;

public class ZhangWuDao {

	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	
	
	public void deleteZhangWu(int zwid) {
		
		try {
			String sql = "DELETE from gjp_zhangwu WHERE zwid=?";
			qr.update(sql, zwid);
		}

		catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("账户删除失败");
		}
	
	}
	
	
	public void editZhangWu(ZhangWu zw) {
		
			try {
				String sql = "UPDATE gjp_zhangwu SET flname=?, money=?, zhanghu=?, createtime=?, description=? WHERE zwid=?";
				Object[] params = { zw.getFlname(), zw.getMoney(), zw.getZhanghu(), zw.getCreatetime(),
						zw.getDescription(),zw.getZwid()};
				qr.update(sql, params);
			}

			catch (SQLException ex) {
				System.out.println(ex);
				throw new RuntimeException("账户更新失败");
			}

		}
		

	public void addZhangWu(ZhangWu zw) {
		try {
			String sql = "INSERT INTO gjp_zhangwu (flname, money, zhanghu, createtime, description) values(?,?,?,?,?)";
			Object[] params = { zw.getFlname(), zw.getMoney(), zw.getZhanghu(), zw.getCreatetime(),
					zw.getDescription() };
			qr.update(sql, params);
		}

		catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("账户添加失败");
		}

	}

	public List<ZhangWu> select(String startDate, String endDate) {

		try {
			String sql = "SELECT * FROM gjp_zhangwu where createtime between ? and ?";
			Object[] params = { startDate, endDate };

			List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class), params);
			return list;
		}

		catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("条件查询失败");
		}

	}

	public List<ZhangWu> selectAll() {

		try {
			String sql = "SELECT * FROM gjp_zhangwu";
			List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
			return list;
		}

		catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("查询所有账户失败");
		}

	}





}
