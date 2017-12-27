package test;

public class TestMain {
	public static void main(String args[]){
		try {
			DBUtil_BO dbBo=new DBUtil_BO();
			DBUtils dbUtils=new DBUtils();
			
			dbBo.conn=C3p0Utils.getConnection();
			String sql = "select * from t_tgt_inventoryforecast";
			dbBo.st=dbBo.conn.prepareStatement(sql);//预处理sql语句
//			dbBo.st.setString(1, name);
//			dbBo.st.setString(2, pass);
			//此时dbBo对象已经封装了一个数据库连接以及要执行的操作            

			dbUtils.executeQuery(dbBo);//通过数据库操作类来执行这个操作封装类，结果封装回这个操作封装类

			//从dbBo类提取操作结果
			if (dbBo.rs.next()) {
			   int quantity =dbBo.rs.getInt("quantity");
			   System.out.println("库存量为："+quantity);
			}
			//结果集遍历完了，手动释放连接回连接池
			dbUtils.realseSource(dbBo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
