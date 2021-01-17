package Vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author xianzheTM
 * @date 2021/1/16 21:38
 */
@Data
@Builder
public class UserVO {
    private Integer id;
    private String username;
}
