package br.com.fabex.api.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryDto {
    private int code;
    private String name;
    private long population;

    public static CountryDto of(final int cod, final String nm, final long popul) {
        return new CountryDto(cod, nm, popul);
    }
}
