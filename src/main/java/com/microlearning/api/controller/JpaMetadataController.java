package com.microlearning.api.controller;

import com.microlearning.api.dto.EntityMetadata;
import com.microlearning.api.service.JpaMetadataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/metadata")
public class JpaMetadataController {
    private final JpaMetadataService jpaMetadataService;

    public JpaMetadataController(
            JpaMetadataService service
    ){

        this.jpaMetadataService = service;

    }


    @GetMapping("/entities")
    public List<Map<String,Object>> getEntities(){

        return jpaMetadataService.getEntities();

    }
}
