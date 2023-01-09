package org.ecust.system.service;

import org.ecust.system.pojo.param.AddSignParam;
import org.ecust.system.utils.Result;

public interface SignService {
    Result addSign(AddSignParam addSignParam);
}
