package login.com.ex.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import login.com.ex.models.entity.BlogEntity;

@Repository
public interface BlogDao extends JpaRepository<BlogEntity, Long> {

	//保存
	BlogEntity save(BlogEntity blogEntity);
	
	//一覧取得
	List<BlogEntity>findAll();
	
	//blogIdを使ってDBに検索
	BlogEntity findByBlogId(Long BlogId);
	//blogTitleで検索
	BlogEntity findByBlogTitle(String blogTitle);
	
	//blogIdでblogを削除する
	@Transactional
	List<BlogEntity> deleteByBlogId(Long blogId);
}
