package co.kr.munjo.controller;


import co.kr.munjo.Entity.Post;
import co.kr.munjo.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PostController {

    private final String CONTEXT = "/posts";

    @Autowired
    PostRepository postRepository;

    @GetMapping(CONTEXT + "/{id}")
    public String getAPost(@PathVariable("id") Post post){
        return post.getTitle();
    }

    @GetMapping("/posts")
    public Page<Post> getPosts(Pageable pageable){
        return postRepository.findAll(pageable);
    }

    @GetMapping(CONTEXT + "/hateoas")
    public PagedModel<EntityModel<Post>> getHateousPosts(Pageable pageable, PagedResourcesAssembler<Post> assembler){
        return assembler.toModel(postRepository.findAll(pageable));
    }
}
