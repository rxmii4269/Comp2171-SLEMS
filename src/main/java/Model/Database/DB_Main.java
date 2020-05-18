package Model.Database;

import java.sql.*;

public class DB_Main {
    private static Connection con;
    protected Query query;

    public DB_Main() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SLEMS", "admin", "SLEMS2171");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int query(String query,Object[] params) throws SQLException{
        PreparedStatement ps = con.prepareStatement(query);
        if (params != null){
            int index = 1;
            for (Object param : params){
                ps.setObject(index,param);
                index++;
            }
        }
        return ps.executeUpdate();
    }

    /**
     * Removes data from a database table
     * @param table
     * @param requirement
     * @param param
     * @return
     * @throws SQLException
     */


    public int delete(String table, String requirement, Object[] param) throws SQLException{
        query = new Query();
        query.delete(table)
                .where(requirement);
        return query(query.getQuery(),param);
    }

    /**
     * Inserts one row to a database table
     * @param table
     * @param params
     * @return
     * @throws SQLException
     */

    public int insert(String table, Object[] params) throws SQLException{
        query = new Query();
        query.insert(table)
                .values(params);
        return query(query.getQuery(),params);
    }

    /**
     * Updates data stored in a database table
     * @param table
     * @param columns
     * @param requirement
     * @param params
     * @return
     * @throws SQLException
     */

    public int update(String table, String[] columns, String requirement, Object[] params)throws SQLException{
        query = new Query();
        query.update(table)
                .set(columns)
                .where(requirement);
        return query(query.getQuery(),params);
    }

    /**
     * Returns data from a table
     * @param table
     * @param columns
     * @param params
     * @return
     * @throws SQLException
     */

    public ResultSet select(String table, Object[] columns, Object[] params) throws SQLException{
        return this.select(table, columns, "",params);
    }

    /**
     * Returns data from a table
     * @param table
     * @param columns
     * @param requirement
     * @param params
     * @return
     * @throws SQLException
     */

    public ResultSet select(String table, Object[] columns, String requirement, Object[] params) throws SQLException{
        query = new Query();
        query.select(columns)
                .from(table)
                .where(requirement);

        PreparedStatement ps = con.prepareStatement(query.getQuery());
        if(params != null){
            int index = 1;
            for(Object param : params){
                ps.setObject(index,param);
                index++;
            }
        }
        ResultSet rs = ps.executeQuery();
        return rs;
    }
}
