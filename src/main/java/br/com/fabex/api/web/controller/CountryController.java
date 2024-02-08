package br.com.fabex.api.web.controller;

import br.com.fabex.api.web.dto.CountryDto;
import br.com.fabex.api.web.exceptions.BaseException;
import br.com.fabex.api.web.exceptions.NotFoundCountryException;
import br.com.fabex.api.web.exceptions.dto.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    private static final List<CountryDto> counties = List.of(
            new CountryDto[]{
                CountryDto.of(1, "Brazil", 18_000_00),
                CountryDto.of(2, "Argentina", 5_000_00),
                CountryDto.of(3, "Chile", 2_000_00),
            }
    );

    @GetMapping("/country")
    public ResponseEntity<CountryDto> getCountry() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("timestamp", String.valueOf(System.currentTimeMillis()))
                .body(CountryDto.of(1, "Brazil", 18_000_00));
    }

    @GetMapping("/country/{code}")
    public ResponseEntity<?> getCountryByCode(@PathVariable int code) {
        try {
            CountryDto countryDto = counties.stream()
                    .filter(country -> country.getCode() == code)
                    .findFirst()
                    .orElseThrow(NotFoundCountryException::new);
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .header("timestamp", String.valueOf(System.currentTimeMillis()))
                    .body(countryDto);
        } catch (BaseException be) {
            ErrorDetails ed = new ErrorDetails(404, "Not Found Country");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ed);
        }
    }
}
