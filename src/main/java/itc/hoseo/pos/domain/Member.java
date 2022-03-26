package itc.hoseo.pos.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Member {
    private Integer seq;
    private String name;
    private String password;
    private Integer age;
}
