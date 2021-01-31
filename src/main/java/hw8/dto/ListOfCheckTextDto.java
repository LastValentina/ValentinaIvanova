package hw8.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListOfCheckTextDto {
    private List<CheckTextDto> listOfCheckTextDto;
}

