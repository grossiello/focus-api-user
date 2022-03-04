package com.example.demo;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Length(min=5)
    private String password;
    private String username;

    @Email
    private String email;
    private String phoneNumber;
    private boolean enabled;
    private boolean verified;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Authority> roles= new HashSet<>();

    //...
}