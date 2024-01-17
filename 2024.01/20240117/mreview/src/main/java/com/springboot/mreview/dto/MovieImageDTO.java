package com.springboot.mreview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieImageDTO {
    private String path;
    private String uuid;
    private String imgName;

    public String getImageURL(){

        try{
            return URLEncoder.encode(path+"/"+uuid+"_"+imgName,"UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        return "";
    }

    public String getThumbnailURL(){
        try {
            return URLEncoder.encode(path+"/s_"+uuid+"_"+imgName,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
