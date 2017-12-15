package com.file.upload.entity.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.file.upload.entity.FileUpload;

public interface FileUploadRepository extends PagingAndSortingRepository<FileUpload, Long>{

	
}
