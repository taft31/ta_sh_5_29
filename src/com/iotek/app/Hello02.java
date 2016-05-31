package com.iotek.app;

import com.iotek.dao.HibernateSessionFactory;
import com.iotek.model.UsersDetailsEntity;
import com.iotek.model.UsersEntity;
import com.iotek.utils.IDType;
import com.iotek.utils.MD5;
import com.iotek.utils.RoundID;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by taft on 2016/5/29.
 */
public class Hello02 {
    public static void main(String[] args) {

        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        String userID = RoundID.getID(IDType.USER);
        String userDetailsID = RoundID.getID(IDType.USER_DETAILS);

        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setId(userID);
        usersEntity.setName("haha");
        usersEntity.setPass(MD5.GetMD5Code("haha123"));
        usersEntity.setImg("userPortrait/default.jpg");

        UsersDetailsEntity usersDetailsEntity = new UsersDetailsEntity();
        usersDetailsEntity.setId(userDetailsID);
        usersDetailsEntity.setPhone("15088889999");
        usersDetailsEntity.setAddress("陕西省西安市雁塔区");
        session.save(usersEntity);
        session.save(usersDetailsEntity);


        transaction.commit();
        System.out.println("保存成功");
    }
}
