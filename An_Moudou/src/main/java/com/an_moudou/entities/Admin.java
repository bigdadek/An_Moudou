package com.an_moudou.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Admins")
//@DiscriminatorValue("Admins")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends Users{

	
}
