package com.example.demo.entity;

import javax.persistence.GenerationType;

public @interface GeneratedValue {
    GenerationType strategy();
}
