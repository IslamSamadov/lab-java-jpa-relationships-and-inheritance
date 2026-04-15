package com.example.lab.data;

import com.example.lab.entity.Association;
import com.example.lab.entity.Division;
import com.example.lab.entity.Member;
import com.example.lab.entity.MemberStatus;
import com.example.lab.repository.AssociationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner initData(AssociationRepository associationRepo) {
        return args -> {
            Association association = new Association();
            association.setName("Nurse Association");

            List<Division> divisions = new ArrayList<Division>();


            for (int i = 1; i <= 7; i++) {
                Division division = new Division();
                division.setName("Division " + i);
                division.setDistrict("District " + i);
                division.setPresident("President " + i);
                division.setAssociation(association);

                Member member = new Member();
                member.setName("Member " + i);
                member.setStatus(MemberStatus.ACTIVE);
                member.setRenewalDate(LocalDate.now().plusMonths(6));
                member.setDivision(division);

                division.setMembers(List.of(member));
                divisions.add(division);
            }
            association.setDivisions(divisions);

            associationRepo.save(association);
        };
    }
}
