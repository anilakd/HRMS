package com.kodlamaio.hrmsdemo.hrmsdemo.configurations;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.adapters.cloudinary.CloudinaryManager;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.adapters.cloudinary.CloudinaryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    @Value("${cld.access-key}")
    String apiKey;

    @Value("${cld.secret-key}")
    String apiSecretKey;



    @Bean
    public Cloudinary cloudinaryUser(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "akdemiranil",
                "api_key", apiKey,
                "api_secret", apiSecretKey));
    }

    @Bean
    public CloudinaryService cloudinaryService(){
        return new CloudinaryManager(cloudinaryUser());
    }

}
