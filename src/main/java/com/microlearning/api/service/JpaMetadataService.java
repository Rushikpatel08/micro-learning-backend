package com.microlearning.api.service;

import com.microlearning.api.dto.EntityMetadata;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.metamodel.*;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JpaMetadataService {
    private final EntityManagerFactory entityManagerFactory;



    public List<Map<String,Object>> getEntities(){


        List<Map<String,Object>> result = new ArrayList<>();


        for(EntityType<?> entity :
                entityManagerFactory
                        .getMetamodel()
                        .getEntities()){


            Map<String,Object> entityData = new HashMap<>();


            entityData.put(
                    "name",
                    entity.getName()
            );


            List<Map<String,String>> fields =
                    new ArrayList<>();



            for(Attribute<?,?> attribute :
                    entity.getAttributes()){


                Map<String,String> field =
                        new HashMap<>();


                field.put(
                        "name",
                        attribute.getName()
                );


                field.put(
                        "type",
                        attribute.getJavaType().getSimpleName()
                );


                fields.add(field);

            }



            entityData.put(
                    "fields",
                    fields
            );


            result.add(entityData);


        }


        return result;

    }
}
