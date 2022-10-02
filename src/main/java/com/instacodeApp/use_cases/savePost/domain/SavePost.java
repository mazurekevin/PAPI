package com.instacodeApp.use_cases.savePost.domain;

import com.instacodeApp.use_cases.comment.domain.Comment;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "SavePost")
public class SavePost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long savePostId;

    @Column(name = "myPseudo", nullable = false)
    private String myPseudo;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "caption", nullable = false)
    private String caption;

    @Column(name = "code", nullable = false, length = 65555)
    private String code;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "likes")
    private int likeCount;

    @Column(name = "originId")
    private Long originId;

    @Column(name = "originName")
    private String originName;

}
