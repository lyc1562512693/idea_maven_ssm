package com.surfilter.springXml.jdbc;

import com.surfilter.ssm.model.SmUser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;

public class JdbcUtils {
    /**
     * 传统方式
     * @param id
     */
    public static void jdbcConnection(int id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys_db_ssm","root","111111");
            String sql = "select * from sm_user where user_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1,id);
            ResultSet res = pre.executeQuery();
            while (res.next()){
                System.out.println(res.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * spring的jdbcTemplate方式实现
     * @param jdbcTemplate
     * @param id
     */
    public static void jdbcTemplate(JdbcTemplate jdbcTemplate, int id){
        String sql = "select * from sm_user where user_id = ?";
        SmUser user = jdbcTemplate.queryForObject(sql, new RowMapper<SmUser>() {
            @Override
            public SmUser mapRow(ResultSet rs, int rowNum) throws SQLException {
                //List<SmUser> lst = new ArrayList<>();
                SmUser user = new SmUser();
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setUserType(rs.getString(3));
                user.setMail(rs.getString(4));
                user.setAddress(rs.getString(5));
                user.setPhone(rs.getString(6));
                user.setUserPic(rs.getString(7));
                return user;
            }
        },id);
        System.out.println(user);
    }
}
