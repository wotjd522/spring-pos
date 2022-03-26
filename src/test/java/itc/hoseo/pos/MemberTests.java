package itc.hoseo.pos;

import itc.hoseo.pos.domain.Item;
import itc.hoseo.pos.domain.Member;
import itc.hoseo.pos.domain.repository.ItemRepository;
import itc.hoseo.pos.domain.repository.MemberRepository;
import itc.hoseo.pos.domain.repository.impl.HashMapItem;
import itc.hoseo.pos.domain.repository.impl.HashMapMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MemberTests { // 여기를 누르면 전체 테스트

    @Test
    void test_김봉남() {
        Member m = new Member(1,"김봉남", "1", 30);

        Member m2 = Member.builder()
                .name("김봉남")
                .build();

        assertEquals("김봉남", m2.getName());
        assertEquals("김봉남", m.getName());
        assertEquals(null, m2.getAge());




    }


    @Test
    void test_마봉필() {
        Member m = new Member(1,"마봉필", "1", 30);

        Member m2 = Member.builder()
                .name("마봉필")
                .build();

        assertEquals("마봉필", m2.getName());
        assertEquals("마봉필", m.getName());
        assertEquals(null, m2.getAge());

    }

    @Test
    void test_Item(){
        Item i = new Item(1,"과자", 3500, 5);
        assertEquals(1, i.getItem());
        assertEquals("과자", i.getName());
        assertEquals(3500, i.getPrice());
        assertEquals(5, i.getStockQuantity());

        i.addStock(3);
        assertEquals(8, i.getStockQuantity());

        i.removeStock(3);
        assertEquals(5, i.getStockQuantity());
    }

    @Autowired
    MemberRepository repository;

    @Test
    void test_HashMapTest(){


        repository.save(new Member(1,"dfs","352",1));
        repository.save(new Member(2,"dfs","352",1));
        repository.save(new Member(3,"dhs","352",1));
        repository.save(new Member(4,"dss","352",1));
        System.out.println(repository.findByName("dfs"));
        System.out.println(repository.findByName("dhs"));
        System.out.println(repository.findByName("ffs"));
        System.out.println(repository.findById(3));
        System.out.println(repository.findById(5));
        System.out.println(repository.allMembers());
    }

    @Test
    void test_HashItemTest(){
        ItemRepository itemRep = new HashMapItem();
        Item i1 = new Item(1, "abda", 1, 312);
        Item i2 = new Item(1, "asdf", 2, 333);
        Item i3 = new Item(3, "awer", 5, 2);
        Item i4 = new Item(5, "awer", 6, 23);
        itemRep.addItem(i1);
        itemRep.addItem(i2);
        itemRep.addItem(i3);
        itemRep.addItem(i4);

        System.out.println(itemRep);

        System.out.println(itemRep.findItem("awer"));

        itemRep.deleteItem(2);
        itemRep.deleteItem(4);
        System.out.println(itemRep);

        System.out.println(itemRep.findItem("awer"));


    }
}
