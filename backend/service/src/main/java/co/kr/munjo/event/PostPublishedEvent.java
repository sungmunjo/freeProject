package co.kr.munjo.event;

import co.kr.munjo.Entity.Post;
import org.springframework.context.ApplicationEvent;

public class PostPublishedEvent extends ApplicationEvent {

    private final Post post;

    public PostPublishedEvent(Object source) {
        super(source);
        this.post = (Post) source;
    }

    public Post getPost(){
        return post;
    }


}
