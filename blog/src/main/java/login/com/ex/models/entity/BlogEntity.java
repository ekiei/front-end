package login.com.ex.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NonNull;

@Entity
@Table(name="blog")
public class BlogEntity {
	
	@Id
	@Column(name="blog_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long blogId;
	
	@NonNull
	@Column(name="blog_title")
	private String blogTitle;
	
	@NonNull
	@Column(name="blog_image")
	private String blogImage;
	
	@NonNull
	@Column(name="article")
	private String article;

	@NonNull
	@Column(name="users_id")
	private String usersId;

	public BlogEntity() {

	}

	public BlogEntity(@NonNull String blogTitle, @NonNull String blogImage,
			@NonNull String article, @NonNull String usersId) {
		this.blogTitle = blogTitle;
		this.blogImage = blogImage;
		this.article = article;

	}

	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogImage() {
		return blogImage;
	}

	public void setBlogImage(String blogImage) {
		this.blogImage = blogImage;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}
	
	public String getUsersId() {
		return usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
}
