package com.nisuniversity.spring.service.util;

import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import java.sql.Timestamp;
 
@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Timestamp> {
     
    @Override
    public Timestamp convertToDatabaseColumn(LocalDate localDate) {
        return localDate == null ? null : Timestamp.valueOf(localDate.atStartOfDay());
    }
 
    @Override
    public LocalDate convertToEntityAttribute(Timestamp sqlTimestamp) {
        return sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime().toLocalDate();
    }
}