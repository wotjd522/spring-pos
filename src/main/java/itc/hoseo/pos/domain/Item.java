package itc.hoseo.pos.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Item {
    /*  ○ 상품 ID (id / int)
        ○ 상품명 (name / String)
        ○ 가격 (price / int)
        ○ 재고 (stockQuantity / int)

        ○ 재고 추가 : addStock(int stock)
        ○ 재고 제거 : removeStock(int stock)
    */
    private int item;
    private String name;
    private int price;
    private int stockQuantity;

    public void addStock(int stock) {
        stockQuantity+=stock;
    }
    public void removeStock(int stock){
        stockQuantity-=stock;
    }

}

