package com.mis.education.Education.MIS.repositories.contactus;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ContactusRepositoryCustomImpl implements ContactusRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;
}
