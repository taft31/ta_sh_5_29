package com.iotek.app;

import com.iotek.dao.HibernateSessionFactory;
import com.iotek.dto.UserDTO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import java.util.List;


/**
 * Created by taft on 2016/5/28.
 */
public class Test {
    public static void main(String[] args) {
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select u.id as id,u.name as name,u.pass as pass,u.img as img,ud.id as udid,ud.phone as phone,ud.address as address,ud.userID as userID from users u,usersDetails ud where u.id = ud.userID";

        Query query = session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(UserDTO.class));

        List<UserDTO> list = query.list();
        transaction.commit();
        for (UserDTO userDTO : list) {
            System.out.println(userDTO);
        }
        System.out.println("±£´æ³É¹¦");
    }
}
