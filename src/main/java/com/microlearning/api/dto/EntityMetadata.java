package com.microlearning.api.dto;

import lombok.Data;
import java.util.List;
@Data
public class EntityMetadata {
    private String entityName;

    private String tableName;

    private List<FieldMetadata> fields;


    @Data
    public static class FieldMetadata {

        private String fieldName;

        private String columnName;

        private String javaType;

        private boolean primaryKey;

    }
}
