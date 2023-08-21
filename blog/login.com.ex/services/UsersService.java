package login.com.ex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import login.com.ex.models.dao.UsersDao;
import login.com.ex.models.entity.UsersEntity;

@Service
public class UsersService {

	@Autowired
	private UsersDao usersDao;
	
	//登録処理用メソッド
	public boolean CreatUsers(String username,String password,String email) {
		if(usersDao.findByUsersName(username) == null) {
			usersDao.save(new UsersEntity(username,password,email));
			return true;
		}else {
			return false;
		}
	}
	//ログインチェック用のメソッド
	//trueはログインできる
	//falseの場合はログインできません
	public UsersEntity loginCheck(String username,String password) {
		UsersEntity user = usersDao.findByUsersNameAndPassword(username,password);
		if(user == null) {
			return null;
		}else {
			return user;
		}
	}
	
}
