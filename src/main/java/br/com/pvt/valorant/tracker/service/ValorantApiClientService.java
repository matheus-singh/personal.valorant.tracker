package br.com.pvt.valorant.tracker.service;

import java.util.*;

public interface ValorantApiClientService {

    List<String> getAgents();

    List<String> getMaps();

    List<String> getRanks();
}
