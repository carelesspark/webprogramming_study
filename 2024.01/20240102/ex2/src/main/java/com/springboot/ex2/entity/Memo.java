package com.springboot.ex2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_memo") // default의 경우, 밑의 클래스 이름인 'Memo'가 테이블 이름으로 들어감
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Memo {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(length = 200, nullable = false)
    private String memoText;

}


