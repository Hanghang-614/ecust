package org.ecust.system.service;

public interface ScoreService {
    Long check(Long userId,Long courseId,String term);
    Long checkNull(Long userId,Long courseId,String term);


}
