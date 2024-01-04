package co.kr.munjo;

import co.kr.munjo.Entity.Comment;
import co.kr.munjo.Entity.Post;
import co.kr.munjo.Repository.AccountRepository;
import co.kr.munjo.Repository.PostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;


@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PostRepository postRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Post post = new Post();
        post.setTitle("Comment Title");

        Comment comment = new Comment();
        comment.setCommentContext("testComment");
        post.addCommnet(comment);

        Comment comment1 = new Comment();
        comment1.setCommentContext("testComment2");
        post.addCommnet(comment1);

        postRepository.save(post);

        System.out.println(post.getTitle());

        Page<Post> postPage = postRepository.findByTitleContains("mment", PageRequest.of(0, 10));
        System.out.println(postPage.getSize());

//        Session session = entityManager.unwrap(Session.class);
//        Post post1 = session.get(Post.class, 2);
//        for(Comment comment2 : post1.getComments()){
//            System.out.println(comment2.getCommentContext());
//        }

//        TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post as p", Post.class);
//        List<Post> posts = query.getResultList();
//        posts.forEach(System.out::println);

//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Post> query =  builder.createQuery(Post.class);
//        Root<Post> root = query.from(Post.class);
//        query.select(root);
//        List<Post> posts = entityManager.createQuery(query).getResultList();
//        posts.forEach(System.out::println);


//        accountRepository.findAll().forEach(System.out::println);


    }
}
