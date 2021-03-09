package week14.homework;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Department {
    int id;
    String name;
    String city;

}
