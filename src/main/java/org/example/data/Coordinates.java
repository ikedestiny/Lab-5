package org.example.data;



import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coordinates {
    @Min(value = -285)
    private Long x; //Значение поля должно быть больше -286
    @Max(value = 703)
    @NotNull
    private Double y; //Максимальное значение поля: 703, Поле не может быть null


}
