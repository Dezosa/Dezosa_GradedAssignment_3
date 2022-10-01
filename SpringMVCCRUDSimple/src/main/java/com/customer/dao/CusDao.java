package com.customer.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;

import com.customer.beans.Cus;  
  
public class CusDao {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Cus p){  
    String sql="insert into customertable(FirstName,SecondName,email) values('"+p.getFirstName()+"',"+p.getSecondName()+",'"+p.getemail()+"')";  
    return template.update(sql);  
}  
public int update(Cus p){  
    String sql="update customertable set FirstName='"+p.getFirstName()+"', SecondName="+p.getSecondName()+",email='"+p.getemail()+"' where id="+p.getId()+"";  
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from customertable where id="+id+"";  
    return template.update(sql);  
}  
public Cus getCusById(int id){  
    String sql="select * from customertable where id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Cus>(Cus.class));  
}  
public List<Cus> getCustomer(){  
    return template.query("select * from customertable",new RowMapper<Cus>(){  
        public Cus mapRow(ResultSet rs, int row) throws SQLException {  
            Cus e=new Cus();  
            e.setId(rs.getInt(1));  
            e.setFirstName(rs.getString(2));  
            e.setSecondName(rs.getString(3));  
            e.setemail(rs.getString(4));  
            return e;  
        }  
    });  
}  
}  