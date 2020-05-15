package com.db.hackathon.service;

import com.db.hackathon.model.Investments;
import com.db.hackathon.repository.InvestmentsRepository;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentsServiceImpl implements InvestmentsService {

    @Autowired
    private InvestmentsRepository investmentsRepository;

}
