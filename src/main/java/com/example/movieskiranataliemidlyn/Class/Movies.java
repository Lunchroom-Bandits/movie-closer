package com.example.movieskiranataliemidlyn.Class;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Movies {
    private Long id;
    private String title;
    private String genre;
    private String rating;
    private String director;
}