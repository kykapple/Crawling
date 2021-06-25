package restaurant.list.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
public class Restaurant_Info {
    private String name;    // 식당 이름
    private String type;    // 음식 타입
    private String img;     // 음식 사진

    @Override
    public String toString() {
        return "Restaurant_Info{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
