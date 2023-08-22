package login.com.ex.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import login.com.ex.models.dao.BlogDao;
import login.com.ex.models.entity.BlogEntity;
import lombok.NonNull;

@Service
public class BlogService {
	@Autowired
	private BlogDao blogDao;
	
	//内容を保存
	public boolean createBlog(@NonNull String blogTitle, @NonNull String blogImage,
			@NonNull String article,@NonNull String usersId) {
		BlogEntity blogList = blogDao.findByBlogTitle(blogTitle);
		if(blogList == null) {
			blogDao.save(new BlogEntity(blogTitle,blogImage,article,usersId));
			return true;
		}else {
			return false;
		}
	}
	
	public List<BlogEntity> selectAll(Long usersId){
		if(usersId == null) {
			return null;
		}else {
			return blogDao.findAll();
		}
	}
	
	//blogIdでデータを取得
	public BlogEntity getByBlogPost(Long blogId) {
		if(blogId == null) {
			//nullの場合は、検索出来ません。
			return null;
		}else {
			return blogDao.findByBlogId(blogId);
		}
	}
	
	//更新処理
	public boolean editBlog(Long blogId,@NonNull String blogTitle, @NonNull String blogImage,
			@NonNull String article) {
		//更新する前にデータベースの内容を取得
		BlogEntity blogList = blogDao.findByBlogId(blogId);
		if(blogList == null) {
			return false;
		}else {
			blogList.setBlogTitle(blogTitle);
			blogList.setBlogImage(blogImage);
			blogList.setArticle(article);

			blogDao.save(blogList);
			return true;
		}
	}
	
	//削除処理
	public boolean deleteBlog(Long blogId) {
		if(blogId == null) {
			return false;
		}else {
			blogDao.deleteById(blogId);
			return true;
		}
	}
}
