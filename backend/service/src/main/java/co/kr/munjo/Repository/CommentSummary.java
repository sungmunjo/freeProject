package co.kr.munjo.Repository;

import org.springframework.beans.factory.annotation.Value;

public interface CommentSummary {
    String getCommentContext();

    int getUp();

    int getDown();


    default String getVotes(){
        return getUp() + " " + getDown();
    }

//    @Value("#{target.up + ' '  + target.down}")
//    String getVotes();

}
