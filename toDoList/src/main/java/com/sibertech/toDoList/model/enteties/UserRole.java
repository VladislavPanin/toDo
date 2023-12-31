package com.sibertech.toDoList.model.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;




@Entity
@Table(name="user_role")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="userId")
    private Long userId;

    @Column(name="roleId")
    private Long roleId;
}
