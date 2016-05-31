package com.iotek.dao;

import com.iotek.dto.UserDTO;
import com.iotek.model.UsersEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import java.util.List;

/**
 * Created by taft on 2016/5/29.
 */
public class UserDAOImpl implements UserDAO{
    Session session = HibernateSessionFactory.getSession();
    @Override
    public boolean isUserNameRepeat(String userName) {
        String hql ="from UsersEntity where name = ?";
        Query query = session.createQuery(hql);
        query.setString(0,userName);
        List list = query.list();
        if (0==list.size()){
            return true;
        }
        return false;
    }

    @Override
    public boolean createUser(UsersEntity usersEntity) {
        return false;
    }

    @Override
    public boolean updateUser(UsersEntity usersEntity) {
        return false;
    }

    @Override
    public UsersEntity checkLogin(UsersEntity usersEntity) {
        String hql = "from UsersEntity where name = ? and  pass =?";
        Query query = session.createQuery(hql);
        query.setString(0,usersEntity.getName());
        query.setString(1,usersEntity.getPass());
        List list = query.list();
        return (UsersEntity) list.get(0);
    }

    @Override
    public List<UserDTO> listUser(UsersEntity usersEntity) {
        String sql = "select u.id as id,u.name as name,u.pass as pass,u.img as img,ud.id as udid,ud.phone as phone,ud.address as address,ud.userID as userID from users u,usersDetails ud where u.id = ud.userID and u.id=?";
        Query query = session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(UserDTO.class));
        query.setString(0,usersEntity.getId());
        System.out.println("query:"+query);
        List list = query.list();
        return list;
    }
}
