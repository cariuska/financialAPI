package br.com.cariuska.financialAPI.util;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageFinacial<T>{

    @JsonInclude(Include.ALWAYS)
    public int number;
    
    @JsonInclude(Include.ALWAYS)
    public int size;

    public List<T> content;
}