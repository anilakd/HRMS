package com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.adapters.cloudinary;

import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {

    DataResult<?> save(MultipartFile file);

}
