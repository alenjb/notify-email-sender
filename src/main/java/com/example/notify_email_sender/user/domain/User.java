package com.example.notify_email_sender.user.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;


    private String googleId;


    private String nickName;


    private String email;

    @Enumerated(value = EnumType.STRING)
    private UserMajor userMajor;

    public void update(String nickName, String email, UserMajor userMajor){
        this.nickName = nickName;
        this.email = email;
        this.userMajor = userMajor;
    }

}
