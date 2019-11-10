package kr.co.timeattack.web.init;

import kr.co.timeattack.web.account.model.AccountModel;
import kr.co.timeattack.web.good.GoodRepository;
import kr.co.timeattack.web.good.model.GoodModel;
import kr.co.timeattack.web.member.MemberRepository;
import kr.co.timeattack.web.member.model.MemberModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;
import java.util.stream.IntStream;

@Component
public class InitComponent implements CommandLineRunner {
    @Autowired
    MemberRepository repository;

    @Autowired
    GoodRepository goodRepository;


    @Override
    public void run(String... args) throws Exception {
//        MemberModel admin = new MemberModel("admin", "admin", Set.of("ADMIN", "USER"));
        MemberModel member = new MemberModel(
                1,
                "sgjh4040@naver.com",
                "1111",
                "사공",
                "Y", "01055045331",
                "부산",
                "광역시",
                "1",
                "880729",
                "20190304",
                "Y",
                Set.of("ADMIN"));
        repository.create(member);

        Date now = new Date();
        GoodModel good = new GoodModel(1, "소설", "개미", "사공정훈", "동아", 3000, 4000, 10, new Date(), 500, "dff1225566", 1000, "bestseller", "인트로", "출판서 코멘트", "상품 목차");
        goodRepository.create(good);
        good = new GoodModel(2, "판타지", "퇴마록", "사공", "천재", 3400, 4000, 10, new Date(), 500, "dff1225566", 1000, "bestseller", "인트로", "출판서 코멘트", "상품 목차");
        goodRepository.create(good);
        good = new GoodModel(3, "소설", "개미", "사공정훈", "동아", 3000, 4000, 10, new Date(), 500, "dff1225566", 1000, "bestseller", "인트로", "출판서 코멘트", "상품 목차");
        goodRepository.create(good);

        System.out.println(member.toString());
        System.out.println(good.toString());
        goodRepository.create(good);


        System.out.println("system: admin, user created.");
    }
}
