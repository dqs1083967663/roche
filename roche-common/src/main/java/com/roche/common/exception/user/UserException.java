package com.roche.common.exception.user;

import com.roche.common.exception.base.BaseException;
import com.roche.common.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author Aarn A Dong
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
