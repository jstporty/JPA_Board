package kr.kwangan2.springbootsecurity.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

   @Id
   private String id;
   private String password;
   private String name;
   @Enumerated(EnumType.STRING)
   private Role role;
   private String enabled;
   
}