package com.an_moudou.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)


//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "Users")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="first_name", nullable=false, length=50)
	private String first_name;

	@Column(name="last_name", nullable=false, length=50)
	private String last_name;

	@Column(name="Adress", nullable=false, length=100)
	private String Adress;

	@Column(name="email", nullable=false, length=50)
	private String email;

	@Column(name="phone", nullable=false, length=50)
	private String phone;

	@Column(name="password", nullable=false, length=50)
	private String password;

	@Enumerated(EnumType.ORDINAL)
	private Role role;
	
	@OneToMany(mappedBy ="owner")
	private List<Trip> Trips;
	
	
}
