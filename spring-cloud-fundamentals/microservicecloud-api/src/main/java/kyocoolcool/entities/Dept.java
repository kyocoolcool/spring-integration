package kyocoolcool.entities;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName Dept
 * @Description TODO
 * @Author chris
 * @Date 2019-02-22 13:51
 * @Version 1.0
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {
    private Long 	deptno; // key
    private String 	dname; // 部門名稱
    private String 	db_source;// 來自哪個DB,因為micro service可以一個服務對應一個數據庫，同一個信息被儲存到不同DB
}