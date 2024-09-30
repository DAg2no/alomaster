package com.principal.alomaster.models;

import com.principal.alomaster.enums.Role;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Client")
@PrimaryKeyJoinColumn(name = "user_id")
public class Client extends User {
}