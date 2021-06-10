package com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.adapters.cloudinary;

import java.io.IOException;
import java.util.Map;

import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.ErrorDataResult;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryManager implements CloudinaryService {

    private Cloudinary cloudinary;

    @Autowired
    public CloudinaryManager(Cloudinary cloudinary) {
        super();
        this.cloudinary = cloudinary;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public DataResult<?> save(MultipartFile file) {
        try {
            Map cloudinaryUploader = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(cloudinaryUploader);
        } catch (IOException e) {

        }
        return new ErrorDataResult<Map>();
    }

}