package co.kr.munjo.controller;

import co.kr.munjo.Entity.Post;
import co.kr.munjo.Repository.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {


    @Autowired
    MockMvc mockMvc;


    @Autowired
    PostRepository postRepository;

    @Test
    public void getPost() throws Exception{
//        Post post = new Post();
//        post.setTitle("jpa");
//        postRepository.save(post);

//        mockMvc.perform(get("/posts").param("page","0").param("size","10")
//                        .param("sort","created,desc").param("sort","title"))
//                .andDo(print());
    }


    @Test
    public void getPostsList() throws Exception {
        createPosts();

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/posts/hateoas")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                    .param("page", "0")
                    .param("size", "10")
                    .param("sort", "created,desc")
                    .param("sort", "title"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].title").value("jpa1"));

    }

    public void createPosts(){
        int postsCount = 100;

        while(postsCount > 0){
            Post post = new Post();
            post.setTitle("jpa" + postsCount);
            postRepository.save(post);
            postsCount--;
        }

    }
}