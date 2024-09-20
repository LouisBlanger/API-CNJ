package com.izi.ws.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izi.ws.repository.JudgingBodyRepository;

@Service
public class JudgingBodyService {

  @Autowired
  private JudgingBodyRepository repository;

}
