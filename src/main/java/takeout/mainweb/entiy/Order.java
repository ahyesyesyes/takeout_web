package takeout.mainweb.entiy;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String id;
    private String goodId;
    private String goodName;
    private double price;
    private String type; //商品类型 用于推荐
    private String sellerId; //卖家ID
    private String buyerId; //卖家ID
    private String state; //交易状态

    @TableField(fill = FieldFill.INSERT, value = "create_time")
    private LocalDateTime createTime;  //订单创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE, value = "update_time")
    private LocalDateTime updateTime;  //订单交易时间
}