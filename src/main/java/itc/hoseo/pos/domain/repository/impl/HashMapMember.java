package itc.hoseo.pos.domain.repository.impl;

import itc.hoseo.pos.domain.Member;
import itc.hoseo.pos.domain.repository.MemberRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;


@Component
public class HashMapMember implements MemberRepository {

 //   private static final MemberRepository instance = new HashMapMember();

 //   public static MemberRepository getInstance(){
 //       return instance;
 //   }


    private final Map<Integer,Member> map1 = new HashMap<>(); // 실질적 저장공간
    Integer key = 1; // key

    @Override
    public Optional<Member> findById(Integer id) {

        Optional<Member> ret;

        for(Member m : map1.values()){
            if (m.getSeq().equals(id)){
                ret = Optional.of(m);
                return ret;
            }
        }

        return Optional.empty();
        //return Optional.of(map1.get(id));
    }

    @Override
    public List<Member> findByName(String name) {
        //List<Member> mem = new ArrayList<>();
        //for(Member m:map1.values()){
        //    if (m.getName().equals(name)){
        //        mem.add(m);
        //    }
        //}
        //return mem;

        return map1.values().stream()
                .filter(i-> name.equals(i.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public void save(Member member) {
        map1.put (key++, member);
    }

    @Override
    public List<Member> allMembers() {
        //return new ArrayList<>(map1.values());
        return map1.values()
                .stream()
                .collect(Collectors.toList());

    }
}
