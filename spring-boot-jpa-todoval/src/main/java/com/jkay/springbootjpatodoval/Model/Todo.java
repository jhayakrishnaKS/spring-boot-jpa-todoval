package com.jkay.springbootjpatodoval.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue
    private int id;
    private String todo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="userid",referencedColumnName = "id")
    private AppUser appUser;
}