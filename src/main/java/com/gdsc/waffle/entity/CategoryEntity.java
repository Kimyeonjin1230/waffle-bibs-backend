package com.gdsc.waffle.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

/**
대분류
assignment, work out, daily, meet
 */
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "category")
@ToString
public class CategoryEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column @NotNull
    private String title;
}