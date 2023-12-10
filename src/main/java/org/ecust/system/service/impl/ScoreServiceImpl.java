package org.ecust.system.service.impl;

import org.ecust.system.mapper.ScoreMapper;
import org.ecust.system.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreMapper scoreMapper;
    @Override
    public Long check(Long userId,Long courseId,String term){return scoreMapper.check(userId, courseId,term);}
    @Override
    public Long checkNull(Long userId,Long courseId,String term){return scoreMapper.checkNull(userId, courseId,term);}
}
