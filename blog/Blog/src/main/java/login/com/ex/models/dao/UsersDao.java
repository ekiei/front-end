package login.com.ex.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import login.com.ex.models.entity.UsersEntity;

public interface UsersDao extends JpaRepository<UsersEntity, Long> {
//データを保存するinsert文に該当するメソッドを書く
//UsersEntityを引数として受け取ってUsersEntityの内容を保存した結果を返す
	UsersEntity save(UsersEntity usersEntity);
	
//usersNameの内容を受け取ってUsersEntityを返すメソッド
//Where users_name = ?
	UsersEntity findByUsersName(String usersName);
//Select * from users Where email = ?And password=?
	UsersEntity findByUsersNameAndPassword(String usersName,String password);

//一覧を取得　SELECT*FROM users;
	List<UsersEntity> findAll();
}
