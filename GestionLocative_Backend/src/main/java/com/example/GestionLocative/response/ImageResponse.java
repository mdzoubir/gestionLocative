package com.example.GestionLocative.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ImageResponse {
    private String name;
    private String url;
    private String type;
    private long size;
    private Long maisonId;
}
